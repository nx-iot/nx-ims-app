/*
 * HydeDataSet Module
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */
package HydeModule.Table;

import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class HydeDataSet {

    private Vector<String> columnVector;
    private Vector<Vector> rowVector;

    int columnSize,
        rowSize;
    
    public HydeDataSet(Vector<Vector> VSS)
    {
        columnVector = new Vector();
        rowVector = new Vector();
        Enumeration enu = VSS.elements();
        columnVector = (Vector<String>) enu.nextElement();
        while(enu.hasMoreElements()) rowVector.add( (Vector) enu.nextElement());
        enu = columnVector.elements();
        columnSize = columnVector.size();
        rowSize = rowVector.size();
    }

    public Vector getColumnVector() { return columnVector;  }
    public Vector getRowVector()    { return rowVector;     }
    public int getColumnSize()      { return columnSize;    }
    public int getRowSize()         { return rowSize;       }

    public void generateTable(JTable JT)
    {
        DefaultTableModel DTM = new HydeDefaultTableModel();
        HydeColorRenderer HCR = new HydeColorRenderer();
        copyToTable(this.getColumnVector(),this.getRowVector(),DTM);
        JT.setModel(DTM);
        for (int i=0;i<JT.getColumnCount();i++) JT.getColumn(JT.getColumnName(i)).setCellRenderer(HCR);
        /*for (int i=0;i<DTM.getColumnCount();i++)
        {
            //if (  JT.getColumnName(i).indexOf("Profile") != -1 ) JT.getColumnModel().getColumn(i).setPreferredWidth(300);
            //else if (  JT.getColumnName(i).indexOf("Status") != -1 ) JT.getColumnModel().getColumn(i).setPreferredWidth(30);
        }*/
    }

    public static void clearTable(JTable JT)
    {
        DefaultTableModel DTM = new HydeDefaultTableModel();
        JT.setModel(DTM);
    }

    public void copyToTable(Vector cv, Vector rv, DefaultTableModel tModel)
    {
        Enumeration enu = cv.elements();
        Enumeration enu2 = rv.elements();
        while(enu.hasMoreElements()) 
        {
            //System.out.println((String) enu.nextElement());
            tModel.addColumn((String) enu.nextElement());
        }
        while(enu2.hasMoreElements())
        {
            //System.out.println((String) enu2.nextElement());
            tModel.addRow((Vector) enu2.nextElement());
        }
    }


}
