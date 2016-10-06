/*
 * HydeColorRenderer Module
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.Table;


import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class HydeColorRenderer implements TableCellRenderer
    {
     private String columnName;
     private JLabel JL;
     private JButton JB;

     public HydeColorRenderer()
     {}

     public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column)
     {
         Object columnValue;
         try
         {
             columnValue = table.getValueAt(row,table.getColumnModel().getColumnIndex("STATUS"));
         }
         catch (java.lang.IllegalArgumentException iLA)
         {
             columnValue = table.getValueAt(row,0);
         }
         
         JL = new JLabel();
         if (value != null) 
         {
             /*if (value.equals("T"))
             {
                     JL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button/ok_mini.png")));
                 JL.setHorizontalAlignment(JLabel.CENTER);
             }
             else if (value.equals("F"))
             {
                 JL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button/cancel_mini.png")));
                 JL.setHorizontalAlignment(JLabel.CENTER);
             }
             else if (value.equals("ON"))
             {
                 JL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/ON_16.png")));
                 JL.setHorizontalAlignment(JLabel.CENTER);
             }
             else if (value.equals("OFF"))
             {
                 JL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/OFF_16.png")));
                 JL.setHorizontalAlignment(JLabel.CENTER);
             }*/
             //else JL.setText(value.toString());
             JL.setText(value.toString());
         }
         else JL.setText("");
         //if (table.getColumnName(column).equals("QUANTITY")) JL.setHorizontalAlignment(JLabel.CENTER);
         //else if (table.getColumnName(column).equals("TYPE")) JL.setHorizontalAlignment(JLabel.CENTER);
         JL.setOpaque(true);

         if(isSelected)
         {
             JL.setBackground(table.getSelectionBackground());
             JL.setForeground(table.getSelectionForeground());
         }
         else
         {
             JL.setBackground(table.getBackground());
             JL.setForeground(table.getForeground());
             if (row%2 == 1) JL.setBackground(new java.awt.Color(240,248,255));
         }
         return JL;
     }

}
