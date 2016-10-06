package ETM.MONITOR.PANEL;

import ETM.MAIN.MainFrame;
import ETM.MAIN.POPUP.ErrorPopUp;
import java.util.Vector;

public class AlarmMediumPanel2 extends javax.swing.JPanel
{
    public String errorName;
    public String userFix;
    public String systemFix;
    public String alarmTime;
    public String deviceID;
    public String deviceName;
    public String department;
    public String deviceGroup;
    public String alarmSource;
    public Vector ad;
    
    private MainFrame MF;
    private String alarmID;
    
    public AlarmMediumPanel2(MainFrame MF, Vector alarmData) 
    {
        this.MF = MF;
        this.alarmID = (String)alarmData.elementAt(15);
        ad = alarmData;
        initComponents();
        setAlarmInfo();
    }
    private void setAlarmInfo()
    {
        userFix = "  -";
        systemFix = "  -";
        if (ad != null)
        {
            errorName = (String) ad.elementAt(0);
            alarmIDLabel.setText(alarmID + " : "+errorName);
            //headerLabel.setMinimumSize(new Dimension((errorName.length()*13)+80,250));
            //headerLabel.setPreferredSize(new Dimension((errorName.length()*14)+80,250));

            alarmTime = (String) ad.elementAt(1);
            deviceID = (String) ad.elementAt(2);
            deviceName = (String) ad.elementAt(3);
            deviceGroup = (String) ad.elementAt(13);
            department = (String) ad.elementAt(11);
            alarmSource = (String) ad.elementAt(14);
            if (ad.elementAt(4).equals("1"))
            {
                userFix = " "+ad.elementAt(6)+" by "+ad.elementAt(5);
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 0)));
                setBackground(new java.awt.Color(255, 255, 240));
            }
            if (ad.elementAt(8).equals("1"))
            {
                systemFix = " "+ad.elementAt(9)+"";
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 0)));
                setBackground(new java.awt.Color(255, 255, 240));
            }
            if (ad.elementAt(4).equals("1") && ad.elementAt(8).equals("1"))
            {
                setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 222, 0)));
                setBackground(new java.awt.Color(240, 255, 240));
            }
            
        }
        else 
        {   
            errorName = "";
            alarmTime = "";
            deviceID = "";
            deviceName = "";
        }
        userFixLabel.setText(userFix);
        systemFixLabel.setText(systemFix);
        dateTimeLabel.setText(alarmTime);
        deviceNameField.setText(deviceName +" ("+deviceID+")");
        deviceInfoField.setText(alarmSource+" (group:"+deviceGroup +" @Department:"+department+")");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        alarmIDLabel = new javax.swing.JLabel();
        dateTimeLabel = new javax.swing.JLabel();
        deviceNameField = new javax.swing.JLabel();
        deviceInfoField = new javax.swing.JLabel();
        userFixLabel = new javax.swing.JLabel();
        systemFixLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 240, 240));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 0, 0)));
        setPreferredSize(new java.awt.Dimension(100, 100));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridLayout(0, 1));

        alarmIDLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alarmIDLabel.setForeground(new java.awt.Color(153, 0, 0));
        alarmIDLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/bell_16.png"))); // NOI18N
        alarmIDLabel.setText(" -");
        alarmIDLabel.setToolTipText("Alarm Type");
        alarmIDLabel.setMaximumSize(new java.awt.Dimension(30000, 30000));
        add(alarmIDLabel);

        dateTimeLabel.setForeground(new java.awt.Color(153, 0, 0));
        dateTimeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/clock_red_16.png"))); // NOI18N
        dateTimeLabel.setText(" -");
        dateTimeLabel.setToolTipText("Alarm Time");
        dateTimeLabel.setMaximumSize(new java.awt.Dimension(30000, 30000));
        add(dateTimeLabel);

        deviceNameField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/device_16.png"))); // NOI18N
        deviceNameField.setText(" -");
        deviceNameField.setToolTipText("Alarm Device");
        add(deviceNameField);

        deviceInfoField.setForeground(new java.awt.Color(0, 102, 153));
        deviceInfoField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/info_16.png"))); // NOI18N
        deviceInfoField.setText(" -");
        deviceInfoField.setToolTipText("Info");
        add(deviceInfoField);

        userFixLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userFixLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/user_fix_16.png"))); // NOI18N
        userFixLabel.setText(" -");
        userFixLabel.setToolTipText("User Acknowledge");
        add(userFixLabel);

        systemFixLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        systemFixLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/system_fix_16.png"))); // NOI18N
        systemFixLabel.setText(" -");
        systemFixLabel.setToolTipText("Device Acknowledge");
        add(systemFixLabel);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        if (evt.getClickCount() == 2)
        {
            ErrorPopUp EPP = new ErrorPopUp(MF, alarmID);
        }
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alarmIDLabel;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JLabel deviceInfoField;
    private javax.swing.JLabel deviceNameField;
    private javax.swing.JLabel systemFixLabel;
    private javax.swing.JLabel userFixLabel;
    // End of variables declaration//GEN-END:variables

 
}
