/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrintField72ppip.java
 *
 * Created on May 9, 2012, 4:16:59 PM
 */

package ETM.MONITOR.PANEL;

import HydeModule.GraphEngine.GraphPanel;
import java.util.Vector;

public class GraphPrintFormatter extends javax.swing.JPanel
{
    public GraphPanel GP;
    //public Vector statData;
    public GraphPrintFormatter(GraphPanel GP, String dep, String fromto, Vector statData)
    {
        initComponents();
        this.GP = GP;
        graphArea.add(this.GP);
        orgField.setText("-");
        depField.setText(dep);
        dateField.setText("Data from : "+fromto);

        Object[][] obj = new Object[statData.size()][6];
        for (int i=0;i<statData.size();i++)
        {
            Vector statData1 = (Vector) statData.elementAt(i);
            obj[i][0] = statData1.elementAt(0);
            obj[i][1] = statData1.elementAt(1);
            obj[i][2] = statData1.elementAt(2);
            obj[i][3] = statData1.elementAt(3);
            obj[i][4] = statData1.elementAt(4);
            obj[i][5] = statData1.elementAt(5);
        }
        avgTable.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                new String [] {
                    "Probe", "AVG", "Max", "Min", "STD", "Alarm"
                }

            ));
        avgTable.getColumnModel().getColumn(0).setMinWidth(300);
        avgTable.getColumnModel().getColumn(1).setMinWidth(100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphArea = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        orgLabel = new javax.swing.JLabel();
        orgField = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        depLabel = new javax.swing.JLabel();
        depField = new javax.swing.JLabel();
        dateField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        avgTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(756, 509));
        setMinimumSize(new java.awt.Dimension(756, 509));
        setPreferredSize(new java.awt.Dimension(756, 509));

        graphArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        graphArea.setPreferredSize(new java.awt.Dimension(821, 350));
        graphArea.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        orgLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        orgLabel.setText("Organization : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(orgLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(orgField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(orgLabel)
            .addComponent(orgField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 27));

        depLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        depLabel.setText("Department : ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(depLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(depField, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(depLabel)
                .addComponent(depField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dateField.setText("Data From : ");

        avgTable.setAutoCreateRowSorter(true);
        avgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Probe", "AVG", "Max", "Min", "STD", "Alarm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(avgTable);
        avgTable.getColumnModel().getColumn(0).setMinWidth(300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                            .addComponent(graphArea, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphArea, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable avgTable;
    private javax.swing.JLabel dateField;
    private javax.swing.JLabel depField;
    private javax.swing.JLabel depLabel;
    private javax.swing.JPanel graphArea;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel orgField;
    private javax.swing.JLabel orgLabel;
    // End of variables declaration//GEN-END:variables

}
