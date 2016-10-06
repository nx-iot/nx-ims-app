/*
 * HydeFileFilter Module
 *  Version 1.0 (01/01/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.File;

import java.io.File;

public class HydeFileFilter extends javax.swing.filechooser.FileFilter
{
    private int type = 0;

    public static final int IMAGE_TYPE = 1;
    public static final int CSV_TYPE = 2;
    public static final int SQL_TYPE = 3;

    public HydeFileFilter(int type)
    {
        this.type = type;
    }
    
    public boolean accept(File f)
    {
        switch (type)
        {
            case IMAGE_TYPE : return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg")
                                || f.getName().toLowerCase().endsWith(".png");
            case CSV_TYPE : return f.isDirectory() || f.getName().toLowerCase().endsWith(".csv");
            case SQL_TYPE : return f.isDirectory() || f.getName().toLowerCase().endsWith(".sql");
        }
        return f.isDirectory();
    }

    public String getDescription()
    {
        switch (type)
        {
            case IMAGE_TYPE: return "JPG, PNG File (*.jpg, *.png)";
            case CSV_TYPE: return "CSV File (*.csv)";
            case SQL_TYPE: return "SQL File (*.sql)";
        }
        return "No Description...";
    }
}
