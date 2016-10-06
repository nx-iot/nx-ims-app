/*
 * HydeFileManager Module
 *  Version 1.0 (01/10/2010)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.File;

import java.io.*;

public class HydeFileManager
{
    public static boolean checkDirectory(String directory)
    {
        File dir = new File(directory);
        dir.exists();
        return dir.exists();
    }
    public static boolean createDirectory(String directory)
    {
        File dir = new File(directory);
        return dir.mkdirs();
    }

    public static void copy(String src, String dest)
    {
        try
        {
            File f1 = new File(src);
            File f2 = new File(dest);

            InputStream in = new FileInputStream(f1);
            OutputStream out = new FileOutputStream(f2);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0)
            {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("HydeFileManager/copy : Error File not found \n"+e);
        }
        catch (Exception e)
        {
            System.out.println("HydeFileManager/copy : Error \n"+e);
        }
    }
}


