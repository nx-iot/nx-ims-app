package ETM.MONITOR.PANEL;

import java.util.Vector;

public class TablePrintFormatter extends javax.swing.JPanel
{

    public TablePrintFormatter(String dep, String fromto, Vector data)
    {
        initComponents();
        orgField.setText("-");
        depField.setText(dep);
        dateField.setText("Data from : "+fromto);
        Object[][] obj = new Object[data.size()][5];
        for (int i=0;i<data.size();i++)
        {
            Vector statData1 = (Vector) data.elementAt(i);
            obj[i][0] = statData1.elementAt(0);
            obj[i][1] = statData1.elementAt(1);
            obj[i][2] = statData1.elementAt(2);
            obj[i][3] = statData1.elementAt(3);
            obj[i][4] = statData1.elementAt(4);
        }
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
                obj,
                new String [] {
                    "Probe", "Data", "Unit", "Time","Type"
                }

            ));
        dataTable.getColumnModel().getColumn(0).setMinWidth(215);
        dataTable.getColumnModel().getColumn(2).setMaxWidth(25);
        dataTable.getColumnModel().getColumn(3).setMinWidth(120);
        dataTable.getColumnModel().getColumn(4).setMaxWidth(60);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        orgLabel = new javax.swing.JLabel();
        orgField = new javax.swing.JLabel();
        depLabel = new javax.swing.JLabel();
        depField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        dateField = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(509, 756));
        setMinimumSize(new java.awt.Dimension(509, 756));
        setPreferredSize(new java.awt.Dimension(509, 756));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        orgLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        orgLabel.setText("Organization : ");

        depLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        depLabel.setText("Department : ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(orgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orgField, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(depLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depField, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orgLabel)
                    .addComponent(orgField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depLabel)
                    .addComponent(depField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dataTable.setAutoCreateRowSorter(true);
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(dataTable);

        dateField.setText("Data from : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(dateField, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateField))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel dateField;
    private javax.swing.JLabel depField;
    private javax.swing.JLabel depLabel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel orgField;
    private javax.swing.JLabel orgLabel;
    // End of variables declaration//GEN-END:variables

}
