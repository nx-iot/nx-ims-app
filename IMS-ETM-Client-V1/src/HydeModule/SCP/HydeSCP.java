/*
 * HydeColorRenderer Module
 *  Version 1.0 (01/07/2010)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.SCP;

import HydeModule.File.HydeDirectory;
import com.jcraft.jsch.*;
import java.io.*;

public class HydeSCP
{
    JSch jsch;
    Session session;
    FileOutputStream fos = null;
    FileInputStream fis = null;

    Thread timerThread;

    public HydeSCP()
    {
    }

    public boolean createSession(String user, String pass, String ip)
    {
        try
        {
            jsch=new JSch();
            session = jsch.getSession(user, ip, 22);
            // username and password will be given via UserInfo interface.
            UserInfo ui = new HydeSCPUserInfo(pass);
            session.setUserInfo(ui);
            session.connect();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean terminateSession()
    {
        try
        {
            session.disconnect();
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean scpTo(String src, String dest)
    {
        try
        {
            boolean ptimestamp = true;
            // exec 'scp -t rfile' remotely
            String command = "scp " + (ptimestamp ? "-p" :"") +" -t "+dest;
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);

            // get I/O streams for remote scp
            OutputStream out = channel.getOutputStream();
            InputStream in = channel.getInputStream();

            channel.connect();

            if(checkAck(in)!=0) return false;
            File _lfile = new File(src);

            if(ptimestamp)
            {
                command="T "+(_lfile.lastModified()/1000)+" 0";
                command+=(" "+(_lfile.lastModified()/1000)+" 0\n");
                out.write(command.getBytes()); out.flush();
                if(checkAck(in)!=0) return false;
            }

            long filesize=_lfile.length();
            command="C0644 "+filesize+" ";
            if(src.lastIndexOf('/')>0)
            {
                command += src.substring(src.lastIndexOf('/')+1);
            }
            else
            {
                command += src;
            }
            command+="\n";
            out.write(command.getBytes()); out.flush();
            if(checkAck(in)!=0) return false;
            // send a content of lfile
            fis = new FileInputStream(src);
            byte[] buf=new byte[1024];
            while(true)
            {
                int len=fis.read(buf, 0, buf.length);
                if(len<=0) break;
                out.write(buf, 0, len);
                //out.flush();
            }
            fis.close();
            fis = null;
            // send '\0'
            buf[0] = 0;
            out.write(buf, 0, 1);
            out.flush();
            if(checkAck(in)!=0) return false;
            out.close();
            channel.disconnect();

            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            try{if(fis!=null)fis.close();}catch(Exception ee){return false;}
            return false;
        }
    }

    public boolean scpFrom(String src, String dest)
    {
        String lfile = dest;
        String prefix=null;
        if(new File(lfile).isDirectory())
        {
            prefix = lfile+File.separator;
        }
        try
        {
            // exec 'scp -f rfile' remotely
            String command = "scp -f "+src;
            Channel channel=session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);
            // get I/O streams for remote scp
            OutputStream out = channel.getOutputStream();
            InputStream in = channel.getInputStream();

            channel.connect();
            byte[] buf=new byte[1024];
            // send '\0'
            buf[0]=0; out.write(buf, 0, 1); out.flush();
            while(true)
            {
                int c = checkAck(in);
                if(c!='C') break;
                // read '0644 '
                in.read(buf, 0, 5);

                long filesize=0L;
                while(true)
                {
                    if(in.read(buf, 0, 1)<0) break;
                    if(buf[0]==' ') break;
                    filesize=filesize*10L+(long)(buf[0]-'0');
                }

                String file=null;
                for(int i=0;;i++)
                {
                    in.read(buf, i, 1);
                    if(buf[i]==(byte)0x0a)
                    {
                        file=new String(buf, 0, i);
                        break;
                    }
                }
                //System.out.println("filesize="+filesize+", file="+file);
                // send '\0'
                buf[0]=0; out.write(buf, 0, 1); out.flush();

                // read a content of lfile
                fos = new FileOutputStream(prefix == null ? lfile : prefix+file);
                int foo;
                while(true)
                {
                    if(buf.length<filesize) foo=buf.length;
                    else foo=(int)filesize;
                    foo=in.read(buf, 0, foo);
                    if(foo<0) break;
                    fos.write(buf, 0, foo);
                    filesize-=foo;
                    if(filesize==0L) break;
                }
                fos.close();
                fos=null;
                if(checkAck(in)!=0) return false;
                // send '\0'
                buf[0]=0; out.write(buf, 0, 1); out.flush();
            }
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            try{if(fos!=null)fos.close();}catch(Exception ee){return false;}
            return false;
        }
    }

    static int checkAck(InputStream in) throws IOException
    {
        int b=in.read();
        // b may be 0 for success,
        //          1 for error,
        //          2 for fatal error,
        //          -1
        if(b==0) return b;
        if(b==-1) return b;

        if(b==1 || b==2)
        {
            StringBuffer sb=new StringBuffer();
            int c;
            do
            {
                c=in.read();
                sb.append((char)c);
            }
            while(c!='\n');
            if(b==1){ // error
                System.out.print(sb.toString());
            }
            if(b==2){ // fatal error
                System.out.print(sb.toString());
            }
        }
        return b;
    }

}


/*/ EXAMPLE /////////////////////////////////////////
        //if (scpFrom("/var/www/html/cctv/bk02/K01.jpg","c://test.jpg")) System.out.println("SCP FROM OK");
        //else System.out.println("SCP FROM FAIL");

        //if (scpTo("c://test.jpg","c://test2.jpg")) System.out.println("SCP To OK");
        //else System.out.println("SCP To FAIL");

        //if (scpTo("c://test.jpg","/var/www/html/cctv/bk02/KTEST1.jpg")) System.out.println("SCP TO OK");
        //else System.out.println("SCP FROM FAIL");
        // EXAMPLE ////////////////////////////////////////*/

        //if (scpTo("c://test.jpg","/data/wowza")) System.out.println("SCP To OK");
        //else System.out.println("SCP To FAIL");

       //File dir = new File("/data/wowza");
       //File dir = new File("C:\\");
       //String[] s = dir.list();
