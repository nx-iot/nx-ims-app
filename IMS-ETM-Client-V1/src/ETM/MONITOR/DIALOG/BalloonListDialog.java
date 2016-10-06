package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.FloorplanPanel;
import HydeModule.Table.HydeDataSet;
import java.util.Vector;

public class BalloonListDialog extends javax.swing.JFrame
{
    private FloorplanPanel FPP;

    public BalloonListDialog(FloorplanPanel FPP)
    {
        this.FPP = FPP;
        initComponents();
        extendComponents();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void extendComponents()
    {
        Vector v = FPP.MIF.MF.HDC.queryAll("SELECT DISTINCT "
                + "balloon_id AS 'Balloon ID', "
                + "floorplan_name AS 'Floor', "
                + "CONCAT(device.device_name,' (',balloon.device_id+0,')') AS 'Device' "
                + "FROM balloon NATURAL JOIN floorplan JOIN device WHERE balloon.device_id = device.device_id OR balloon.device_id IS NULL;");
        HydeDataSet HDS = new HydeDataSet(v);
        HDS.generateTable(balloonTable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        balloonTableScroll = new javax.swing.JScrollPane();
        balloonTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        balloonTableScroll.setViewportView(balloonTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(balloonTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(balloonTableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable balloonTable;
    private javax.swing.JScrollPane balloonTableScroll;
    // End of variables declaration//GEN-END:variables

}
