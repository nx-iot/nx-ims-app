package HydeModule.Table;

import HydeModule.File.HydeFileFilter;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class HydeTable
{
    public static void exportTableGUI(Component parent, JTable JT) throws IOException
    {
        JFileChooser jFC = new JFileChooser();
        jFC.setFileFilter(new HydeFileFilter(HydeFileFilter.CSV_TYPE));
        if (jFC.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION)
        {
            String outPath = jFC.getSelectedFile().getAbsolutePath();
            if (outPath.indexOf(".csv") != outPath.length()-4)
            {
                outPath += ".csv";
            }
            HydeTable.exportTable(JT, outPath);
            JOptionPane.showMessageDialog(parent, "Export complete.", "HydeExport", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void exportTable(JTable JT, String outPath) throws IOException
    {
        FileWriter FW = new FileWriter(outPath);
        BufferedWriter BW = new BufferedWriter(FW);
        int column = JT.getColumnCount();
        for (int i=0;i<column;i++)
        {
            String value = (String) JT.getColumnName(i);
            if (value == null)
            {
                value = "";
            }
            if (i < column-1)
            {
                BW.write(value+",");
            }
            else
            {
                BW.write(value+",\r\n");
            }
        }
        int row = JT.getRowCount();
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<column;j++)
            {
                String value = (String) JT.getValueAt(i, j);
                if (value == null)
                {
                    value = "";
                }
                if (j < column-1)
                {
                    BW.write(value+",");
                }
                else
                {
                    BW.write(value+",\r\n");
                }
            }
        }
        BW.close();
        FW.close();
    }
}
