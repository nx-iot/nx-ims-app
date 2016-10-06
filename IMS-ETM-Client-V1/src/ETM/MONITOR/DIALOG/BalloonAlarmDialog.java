/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MONITOR.DIALOG;

import ETM.MAIN.MainFrame;
import ETM.MONITOR.PANEL.AlarmMediumPanel2;
import HydeModule.Table.HydeDataSet;
import java.awt.Dimension;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class BalloonAlarmDialog extends javax.swing.JDialog 
{
    private String deviceID;
    private MainFrame MF;
    
    public BalloonAlarmDialog(MainFrame MF, String deviceID) 
    {
        this.MF = MF;
        this.deviceID = deviceID;
        initComponents();
        setAlarm();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alarmScroll = new javax.swing.JScrollPane();
        alarmPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Currently Alarm");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(200, 200));
        getContentPane().setLayout(new java.awt.GridLayout());

        alarmScroll.setPreferredSize(new java.awt.Dimension(0, 0));

        alarmPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        alarmPanel.setLayout(new javax.swing.BoxLayout(alarmPanel, javax.swing.BoxLayout.PAGE_AXIS));
        alarmScroll.setViewportView(alarmPanel);

        getContentPane().add(alarmScroll);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setAlarm()
    {
        Vector am =MF.HDC.queryAll("SELECT "
                    + "error_name, alarm_timestamp, device_id, device_name, user_fix, "
                    + "user_username, user_timestamp, note, system_fix, system_timestamp, "
                    + "g.depart_id, depart_name, d.device_group_id, device_group_name, alarm_source, "
                    + "alarm_id "
                    + "FROM alarm_current NATURAL JOIN error NATURAL JOIN device d "
                    + "LEFT JOIN device_group g ON d.device_group_id LEFT JOIN department ON g.depart_id "
                    + "WHERE device_id = '"+deviceID+"' AND g.depart_id = department.depart_id;");
        
        if (am != null)
        {
            HydeDataSet HDS = new HydeDataSet(am);
            Vector rv = HDS.getRowVector();
            
            int size = rv.size();
            alarmPanel.setPreferredSize(new Dimension(100,130*size));
            int dialogSize = size*130 +20;
            if (size > 3) dialogSize = 3*130 +20;
            this.setPreferredSize(new Dimension(300,dialogSize));
            this.setSize(new Dimension(300,dialogSize));
            //alarmScroll.setPreferredSize(new Dimension(300,dialogSize));
            
            Enumeration enu = rv.elements();
            while (enu.hasMoreElements())
            {
                Vector alarmInfo = (Vector) enu.nextElement();
                AlarmMediumPanel2 AMP = new AlarmMediumPanel2(MF,alarmInfo);
                alarmPanel.add(AMP);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Alarm");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alarmPanel;
    private javax.swing.JScrollPane alarmScroll;
    // End of variables declaration//GEN-END:variables
}
