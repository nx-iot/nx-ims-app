package ETM.MONITOR.PANEL;

import HydeModule.Table.HydeDataSet;

public class AlarmTimeTablePanel extends javax.swing.JPanel {

    private HydeDataSet HDS;
    public AlarmTimeTablePanel(HydeDataSet HDS)
    {
        this.HDS = HDS;
        initComponents();
        HDS.generateTable(sumTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sumTableScroll = new javax.swing.JScrollPane();
        sumTable = new javax.swing.JTable();

        setLayout(new java.awt.GridLayout(1, 0));

        sumTable.setAutoCreateRowSorter(true);
        sumTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        sumTableScroll.setViewportView(sumTable);

        add(sumTableScroll);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable sumTable;
    private javax.swing.JScrollPane sumTableScroll;
    // End of variables declaration//GEN-END:variables

}
