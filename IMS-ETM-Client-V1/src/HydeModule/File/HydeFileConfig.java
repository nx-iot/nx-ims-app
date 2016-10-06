/*
 * HydeFileConfig Module
 *  Version 1.20 (26/09/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.File;

import ETM.Util.HydeLogger;
import java.io.*;
import java.util.Vector;

public class HydeFileConfig
{

    HydeLogger HL;
    public HydeFileConfig()
    {

    }

    public static void checkConfigByContext(String context, String follow, String target)
    {
        String cnt = "";
        FileReader FR;
        BufferedReader BR;
        FileWriter FW;
        BufferedWriter BW;
        try // Reader /////////////////////////////////////////////////////////
        {
            HydeFileManager.copy(target, target+"~");
            FR = new FileReader(target+"~");
            FW = new FileWriter(target,true);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/writeConfig.1 : " + e);
            return;
        }
        try
        {
            BR = new BufferedReader(FR);
            BW = new BufferedWriter(FW);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/writeConfig.2 : " + e);
            return;
        }
        try
        {
            String reader = BR.readLine();
                System.out.println("looking for "+context);
            while (reader != null)
            {
                if (reader.indexOf("#") != -1);
                else if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1)
                {
                    cnt = reader.substring(1,reader.length()-1);
                    if (cnt.equals(context))
                    {
                        FR.close();
                        BR.close();
                        FW.close();
                        BW.close();
                        return;
                    }
                }
                reader = BR.readLine();
            }
            System.out.println("Not Equala !!");
            BW.write("\r\n");
            BW.write("["+context+"]\r\n");
            BW.write(follow+"\r\n");
            
            BW.close();
            FW.close();
            BR.close();
            FR.close();
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/checkConfigByContext.3 : " + e);
        }
    }
    
    public static boolean createConfig(String path, String value)
    {

        FileWriter FW;
        BufferedWriter BW;
        try // Writer /////////////////////////////////////////////////////////
        {
            FW = new FileWriter(path);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/createConfig.1 : " + e);
            return false;
        }
        try
        {
            BW = new BufferedWriter(FW);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/createConfig.2 : " + e);
            return false;
        }
        try
        {
            BW.write(value);
            BW.close();
            FW.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/createConfig.3 : " + e);
            return false;
        }
    }

    public static boolean writeConfig(String path, String context, String target, String newValue)
    {
        String cnt = "";
        FileReader FR;
        BufferedReader BR;
        FileWriter FW;
        BufferedWriter BW;
        try // Reader /////////////////////////////////////////////////////////
        {
            HydeFileManager.copy(path, path+"~");
            FR = new FileReader(path+"~");
            FW = new FileWriter(path);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/writeConfig.1 : " + e);
            return false;
        }
        try
        {
            BR = new BufferedReader(FR);
            BW = new BufferedWriter(FW);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/writeConfig.2 : " + e);
            return false;
        }
        try
        {
            String reader = BR.readLine();
            String writer = reader;
            while (reader != null)
            {
                boolean notWrite = true;
                if (reader.indexOf("#") != -1);
                else if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1)
                {
                    cnt = reader.substring(1,reader.length()-1);
                    if (cnt.equals(context))
                    {
                        BW.write(writer+"\r\n");
                        reader = BR.readLine();
                        writer = reader;
                        notWrite = false;
                        while (reader != null)
                        {
                            if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1) break;
                            else
                            {
                                if (reader.indexOf("=") != -1)
                                {
                                    int p1 = reader.indexOf("=");
                                    String header = (reader.substring(0,p1)).trim();
                                    if (header.equals(target))
                                    {
                                        writer = header+" = "+newValue;
                                    }
                                }
                            }
                            BW.write(writer+"\r\n");
                            reader = BR.readLine();
                            writer = reader;
                            notWrite = false;
                        }
                    }
                }
                if (notWrite)
                {
                    BW.write(writer+"\r\n");
                    reader = BR.readLine();
                    writer = reader;
                }
            }
            BW.close();
            FW.close();
            BR.close();
            FR.close();
            return true;
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigWriter/writeConfig.3 : " + e);
            return false;
        }
    }

    public static String readConfig(String path, String context, String target)
    {
        String cnt = "";
        FileReader FR;
        BufferedReader BR;
        try // Reader /////////////////////////////////////////////////////////
        {
            FR = new FileReader( path);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.1 : " + e);
            return null;
        }
        try
        {
            BR = new BufferedReader(FR);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.2 : " + e);
            return null;
        }
        try
        {
            String reader = BR.readLine();
            while (reader != null)
            {
                if (reader.indexOf("#") != -1);
                else if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1)
                {
                    cnt = reader.substring(1,reader.length()-1);
                    if (cnt.equals(context))
                    {
                        reader = BR.readLine();
                        while (reader != null)
                        {
                            if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1) break;
                            else
                            {
                                if (reader.indexOf("=") != -1)
                                {
                                    int p1 = reader.indexOf("=");
                                    String header = (reader.substring(0,p1)).trim();
                                    if (header.equals(target))
                                    {
                                        FR.close();
                                        BR.close();
                                        return (reader.substring(p1+1, reader.length())).trim();
                                    }
                                }
                            }
                            reader = BR.readLine();
                        }
                    }
                }
                reader = BR.readLine();
            }
            FR.close();
            BR.close();
            return null;
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.3 : " + e);
            return null;
        }
    }

    public static Vector readSetConfig(String path, String context)
    {
        String cnt = "";
        Vector v = new Vector();
        FileReader FR;
        BufferedReader BR;
        try // Reader /////////////////////////////////////////////////////////
        {
            FR = new FileReader( path);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.1 : " + e);
            return null;
        }
        try
        {
            BR = new BufferedReader(FR);
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.2 : " + e);
            return null;
        }
        try
        {
            String reader = BR.readLine();
            while (reader != null)
            {
                if (reader.indexOf("#") != -1);
                else if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1)
                {
                    cnt = reader.substring(1,reader.length()-1);
                    if (cnt.equals(context))
                    {
                        reader = BR.readLine();
                        while (reader != null)
                        {
                            if (reader.indexOf("[") == 0 && reader.indexOf("]") == reader.length()-1) break;
                            else
                            {
                                if (reader.indexOf("=") != -1)
                                {
                                    int p1 = reader.indexOf("=");
                                    v.add((reader.substring(p1+1, reader.length())).trim());
                                }
                            }
                            reader = BR.readLine();
                        }
                    }
                }
                reader = BR.readLine();
            }
            FR.close();
            BR.close();
            return v;
        }
        catch (Exception e)
        {
            System.out.println("HydeConfigReader/readConfig.3 : " + e);
            return null;
        }
    }

    public String getMainPath()
    {
        String OS = System.getProperty("os.name");
        String mainPath = "";
        if (OS.indexOf("Windows") != -1)
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index+1,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
        }
        else if (OS.indexOf("Linux") != -1)
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
        }
        else
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index+1,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
            mainPath = "/"+mainPath;
        }
        return mainPath;
    }

    public String getRootPackagePath()
    {
        String OS = System.getProperty("os.name");
        String mainPath = "";
        if (OS.indexOf("Windows") != -1)
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index+1,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
        }
        else if (OS.indexOf("Linux") != -1)
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
        }
        else
        {
            mainPath = (getClass().getResource("HydeFileConfig.class")).toString();
            int index = mainPath.indexOf("/");
            int index2 = mainPath.lastIndexOf("/");
            index2 = mainPath.lastIndexOf("/",index2-1);
            mainPath = mainPath.substring(index+1,index2+1);
            mainPath = mainPath.replaceAll("%20"," ");
            mainPath = "/"+mainPath;
        }
        return mainPath;
    }

}
