/*
 * HydeDirectory Module
 *  Version 1.0 (01/10/2010)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.File;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class HydeDirectory
{

    File dir;

    public HydeDirectory(String path)
    {
        dir = new File(path);
        String[] children = dir.list();
    }

    public void close()
    {
    }

    public void setPath(String path)
    {
        dir = new File(path);
        String[] children = dir.list();
    }
    
    public String[] listFileName()
    {
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter()
        {
            public boolean accept(File file)
            {
                return !file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        String[] listedFilesPath = new String[files.length];
        for (int i=0; i<files.length; i++)
        {
            listedFilesPath[i] = files[i].getAbsolutePath();
        }
        return listedFilesPath;
    }

    public String[] listFileName2()
    {
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter()
        {
            public boolean accept(File file)
            {
                return !file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        String[] listedFilesPath = new String[files.length];
        for (int i=0; i<files.length; i++)
        {
            listedFilesPath[i] = files[i].getName();
        }
        return listedFilesPath;
    }

    public String[] listFileDirectory()
    {
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter()
        {
            public boolean accept(File file)
            {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        String[] listedFilesPath = new String[files.length];
        for (int i=0; i<files.length; i++)
        {
            listedFilesPath[i] = files[i].getAbsolutePath();
        }
        return listedFilesPath;
    }

    public String[] listFilteredFile()
    {
        FilenameFilter filter = new FilenameFilter()
        {
            public boolean accept(File dir, String name)
            {
                return !name.startsWith(".");
            }
        };
        String[] children = dir.list(filter);
        for (int i=0; i<children.length; i++)
        {
            // Get filename of file or directory
            String filename = children[i];
            //System.out.println(filename);
        }
        return children;
    }

    
}
