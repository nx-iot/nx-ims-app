/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MONITOR.DIALOG;

import ETM.MAIN.POPUP.LocationPopup2;
import ETM.MONITOR.MonitorIF;
import ETM.MONITOR.PANEL.FloorplanEffectPanel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class BalloonOptionDialog extends javax.swing.JDialog implements ActionListener
{

    private FloorplanEffectPanel FEP;
    private String deviceID;
    
    public BalloonOptionDialog(FloorplanEffectPanel FEP, Dimension dim, String deviceID) 
    {
        this.FEP = FEP;
        this.deviceID = deviceID;
        initComponents();
        actionComponents();
        
        this.setLocationRelativeTo(FEP);
        this.setLocation(dim.width, dim.height);
        this.setVisible(true);
    }

    private void actionComponents()
    {
        infoButton.addActionListener(this);
        alarmButton.addActionListener(this);
        locationButton.addActionListener(this);
        graphButton.addActionListener(this);
        tableButton.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        infoButton = new javax.swing.JButton();
        alarmButton = new javax.swing.JButton();
        locationButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        graphButton = new javax.swing.JButton();
        tableButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        jToolBar1.setFloatable(false);

        infoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/info_16.png"))); // NOI18N
        infoButton.setToolTipText("Info");
        jToolBar1.add(infoButton);

        alarmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/bell_16.png"))); // NOI18N
        alarmButton.setToolTipText("Currently Alarm");
        alarmButton.setFocusable(false);
        alarmButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(alarmButton);

        locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/map_zoom_16.png"))); // NOI18N
        locationButton.setToolTipText("Location");
        locationButton.setFocusable(false);
        locationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        locationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(locationButton);

        jPanel1.add(jToolBar1);

        jToolBar2.setFloatable(false);

        graphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/graph_16.png"))); // NOI18N
        graphButton.setToolTipText("Go to Graph");
        graphButton.setFocusable(false);
        graphButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        graphButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(graphButton);

        tableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/table_16.png"))); // NOI18N
        tableButton.setToolTipText("Go to Table");
        tableButton.setFocusable(false);
        tableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(tableButton);

        jPanel1.add(jToolBar2);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmButton;
    private javax.swing.JButton graphButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton locationButton;
    private javax.swing.JButton tableButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == infoButton)
        {
            BalloonInfoDialog BID = new BalloonInfoDialog(FEP.FPP.MIF.MF, deviceID);
        }
        else if (src == alarmButton)
        {
            BalloonAlarmDialog BAD = new BalloonAlarmDialog(FEP.FPP.MIF.MF, deviceID);
        }
        else if (src == locationButton)
        {
            LocationPopup2 LP2 = new LocationPopup2(FEP.FPP.MIF.MF,deviceID,0);
        }
        else if (src == graphButton)
        {
            if (FEP.FPP.MIF == null || !FEP.FPP.MIF.isVisible())
            {
                FEP.FPP.MIF = new MonitorIF(FEP.FPP.MIF.MF);
                FEP.FPP.MIF.setBounds(50, 20, 900, 600);
                FEP.FPP.MIF.MF.desktopPane.add(FEP.FPP.MIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                //FEP.FPP.MIF.MF.menuStat.setSelected(true);
            }
            try
            {
                FEP.FPP.MIF.setSelected(true);
                FEP.FPP.MIF.graphButton.doClick();
                Vector v = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT "
                        + "CONCAT('[CH:',channel,'] of ',device_name,' (',device_id+0,')') "
                        + "FROM device_channel NATURAL JOIN device "
                        + "WHERE device_id = '"+deviceID+"' AND channel_enable = '1';");

                Object[] obj = v.toArray();
                FEP.FPP.MIF.GDP.setSelectedProbe(obj);
                FEP.BOD.dispose();
            }
            catch (Exception ee) 
            { 
                JOptionPane.showMessageDialog(null, "Cannot open graph function...");
            }
        }
        else if (src == tableButton)
        {
            if (FEP.FPP.MIF == null || !FEP.FPP.MIF.isVisible())
            {
                FEP.FPP.MIF = new MonitorIF(FEP.FPP.MIF.MF);
                FEP.FPP.MIF.setBounds(50, 20, 900, 600);
                FEP.FPP.MIF.MF.desktopPane.add(FEP.FPP.MIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                //FEP.FPP.MIF.MF.menuStat.setSelected(true);
            }
            try
            {
                FEP.FPP.MIF.setSelected(true);
                FEP.FPP.MIF.tableButton.doClick();
                Vector v = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT "
                        + "CONCAT('[CH:',channel,'] of ',device_name,' (',device_id+0,')') "
                        + "FROM device_channel NATURAL JOIN device "
                        + "WHERE device_id = '"+deviceID+"' AND channel_enable = '1';");

                Object[] obj = v.toArray();
                FEP.FPP.MIF.TDP.setSelectedProbe(obj);
                FEP.BOD.dispose();
            }
            catch (Exception ee) 
            { 
                JOptionPane.showMessageDialog(null, "Cannot open graph function...");
            }
        }
    }
}
