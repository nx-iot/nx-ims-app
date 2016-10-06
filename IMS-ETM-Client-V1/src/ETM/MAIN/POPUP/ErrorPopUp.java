package ETM.MAIN.POPUP;

import ETM.MAIN.DIALOG.ErrorCancelDialog;
import ETM.MAIN.MainFrame;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

public class ErrorPopUp extends javax.swing.JDialog implements ActionListener
{
    public MainFrame MF;

    public String alarmID;

    public ErrorPopUp(MainFrame MF,String alarmID)
    {
        //super(MF,true);
        this.MF = MF;
        this.alarmID = alarmID;
        initComponents();
        extendComponents();
        actionComponents();
        int maxX = MF.desktopPane.getWidth();
        int maxY = MF.desktopPane.getHeight();
        Random rd = new Random();
        
        this.setLocation(rd.nextInt(maxX-getWidth()), rd.nextInt(maxY-getHeight()));
        setVisible(true);
    }

    public boolean systemFixFlag;
    public boolean userFixFlag;
    
    public String errorName;
    public String userFix;
    public String systemFix;
    public String alarmTime;
    public String deviceID;
    public String deviceName;
    public String department;
    public String deviceGroup;
    public String alarmSource;
    public String alarmSourceName;
    public Vector ad;
    private void extendComponents()
    {
        setInfo();
    }
    
    public void reload(boolean uf, boolean sf)
    {
        if (uf != userFixFlag || sf != systemFixFlag) 
        {
            setInfo();
        }
    }
    
    public void setInfo()
    {
        if (MF.HDC.query0("SELECT alarm_id FROM alarm_current WHERE alarm_id = '"+alarmID+"';") != null)
        {
            ad = MF.HDC.queryRow("SELECT "
                    + "error_name, alarm_timestamp, device_id, device_name, user_fix, "
                    + "user_username, user_timestamp, note, system_fix, system_timestamp, "
                    + "g.depart_id, depart_name, d.device_group_id, device_group_name, alarm_source "
                    + "FROM alarm_current NATURAL JOIN error NATURAL JOIN device d "
                    + "LEFT JOIN device_group g ON d.device_group_id LEFT JOIN department ON g.depart_id "
                    + "WHERE alarm_id = '"+alarmID+"';");
        }
        else
        {
            ad = MF.HDC.queryRow("SELECT "
                    + "error_name, alarm_timestamp, device_id, device_name, user_fix, "
                    + "user_username, user_timestamp, note, system_fix, system_timestamp, "
                    + "g.depart_id, depart_name, d.device_group_id, device_group_name, alarm_source "
                    + "FROM "+MF.HDC.database+"_log.alarm_log NATURAL JOIN "+MF.SD.defaultDatabase+".error NATURAL JOIN "+MF.SD.defaultDatabase+".device d "
                    + "LEFT JOIN device_group g ON d.device_group_id LEFT JOIN department ON g.depart_id "
                    + "WHERE alarm_id = '"+alarmID+"';");
        }

        userFix = "  -";
        systemFix = "  -";
        Vector deviceInfo = new Vector();
        if (ad != null)
        {
            errorName = (String) ad.elementAt(0);
            //headerLabel.setMinimumSize(new Dimension((errorName.length()*13)+80,250));
            //headerLabel.setPreferredSize(new Dimension((errorName.length()*14)+80,250));

            alarmTime = (String) ad.elementAt(1);
            deviceID = (String) ad.elementAt(2);
            deviceName = (String) ad.elementAt(3);
            deviceGroup = (String) ad.elementAt(13);
            department = (String) ad.elementAt(11);
            alarmSource = (String) ad.elementAt(14);
            
            if (alarmSource.indexOf("Sensor") > -1)
            {
                alarmSourceName = MF.HDC.query0("SELECT channel_name FROM device_channel WHERE channel = "
                        +alarmSource.charAt(7) +" AND device_id = '"+deviceID+"';");
            }
            else
            {
                alarmSourceName = "Alarm from device, not from probes";
            }
            userFixFlag = ad.elementAt(4).equals("1")? true:false;
            systemFixFlag = ad.elementAt(8).equals("1")? true:false;
            if (ad.elementAt(4).equals("1"))
            {
                userFix = " "+ad.elementAt(6)+" by "+ad.elementAt(5);
            }
            if (ad.elementAt(8).equals("1"))
            {
                systemFix = " "+ad.elementAt(9)+"";
            }
            if (ad.elementAt(4).equals("1") && ad.elementAt(8).equals("0"))
            {
                headerLabel.setText("ACK : "+errorName);
                headerLabel.setForeground(new java.awt.Color(220,170,10));
                headerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/user_fix_32.png")));
            }
            else if (ad.elementAt(4).equals("0") && ad.elementAt(8).equals("1"))
            {
                headerLabel.setText("ACK : "+errorName);
                headerLabel.setForeground(new java.awt.Color(220,170,10));
                headerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/system_fix_32.png")));
            }
            else if (ad.elementAt(4).equals("1") && ad.elementAt(8).equals("1"))
            {
                headerLabel.setText("Fixed : "+errorName);
                headerLabel.setForeground(new java.awt.Color(0, 200, 0));
                headerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/ok_32.png")));
            }
            else
            {
                headerLabel.setText("WARNING : "+errorName);
                headerLabel.setForeground(new java.awt.Color(255, 0, 0));
                headerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/error.gif")));
            }

            headerLabel.revalidate();
            ackPanel.revalidate();
            Dimension d = headerLabel.getPreferredSize();
            Dimension d2 = ackPanel.getPreferredSize();
            if (d.width+40 > 343 || d2.width+40 > 343)
            {
                if (d.width > d2.width+20)
                {
                    setMinimumSize(new Dimension(d.width+40,getHeight()));
                    setPreferredSize(new Dimension(d.width+40,getHeight()));
                }
                else
                {
                    setMinimumSize(new Dimension(d2.width+60,getHeight()));
                    setPreferredSize(new Dimension(d2.width+60,getHeight()));
                }
            }
            else
            {
                    setMinimumSize(new Dimension(343,getHeight()));
                    setPreferredSize(new Dimension(343,getHeight()));
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
        deviceInfoField.setText(alarmSource+" ("+alarmSourceName+")");
        deviceInfoField2.setText("group:"+deviceGroup +" @Department:"+department);

    }

    private void actionComponents()
    {
        okButton.addActionListener(this);
        locationButton.addActionListener(this);
        //detailButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dateTimeLabel = new javax.swing.JLabel();
        deviceNameField = new javax.swing.JLabel();
        deviceInfoField = new javax.swing.JLabel();
        deviceInfoField2 = new javax.swing.JLabel();
        locationButton = new javax.swing.JButton();
        ackPanel = new javax.swing.JPanel();
        userFixLabel = new javax.swing.JLabel();
        systemFixLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Warning");
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                Closing(evt);
            }
        });

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        okButton.setText("OK, Comment");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Device & Alarm time"));
        jPanel1.setLayout(new java.awt.GridLayout(0, 1));

        dateTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateTimeLabel.setForeground(new java.awt.Color(153, 0, 0));
        dateTimeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/clock_red_16.png"))); // NOI18N
        dateTimeLabel.setText(" -");
        dateTimeLabel.setMaximumSize(new java.awt.Dimension(30000, 30000));
        jPanel1.add(dateTimeLabel);

        deviceNameField.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        deviceNameField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/device_16.png"))); // NOI18N
        deviceNameField.setText(" -");
        jPanel1.add(deviceNameField);

        deviceInfoField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deviceInfoField.setForeground(new java.awt.Color(0, 102, 153));
        deviceInfoField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/info_16.png"))); // NOI18N
        deviceInfoField.setText(" -");
        jPanel1.add(deviceInfoField);

        deviceInfoField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deviceInfoField2.setForeground(new java.awt.Color(0, 102, 153));
        deviceInfoField2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/info_16.png"))); // NOI18N
        deviceInfoField2.setText(" -");
        jPanel1.add(deviceInfoField2);

        locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/view_16.png"))); // NOI18N
        locationButton.setText("LOCATION");

        ackPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Acknowledged"));
        ackPanel.setLayout(new java.awt.GridLayout(0, 1));

        userFixLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userFixLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userFixLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/user_fix_16.png"))); // NOI18N
        userFixLabel.setText(" -");
        ackPanel.add(userFixLabel);

        systemFixLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        systemFixLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        systemFixLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/system_fix_16.png"))); // NOI18N
        systemFixLabel.setText(" -");
        ackPanel.add(systemFixLabel);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 0, 0));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/error.gif"))); // NOI18N
        headerLabel.setText(" Warning");
        jPanel3.add(headerLabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(locationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton))
                    .addComponent(ackPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(locationButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Closing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_Closing
        
        close();
    }//GEN-LAST:event_Closing

    public String getDeviceID()
    {
        return deviceID;
    }

    public String getErrorID()
    {
        return errorName.substring(errorName.lastIndexOf("(")+1,errorName.lastIndexOf(")"));
    }
    
    public String getAlarmID()
    {
        return alarmID;
    }

    public void close()
    {
        MF.VEPU.remove(this);
        if (ECD != null)
        {
            ECD.dispose();
        }
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ackPanel;
    private javax.swing.JLabel dateTimeLabel;
    private javax.swing.JLabel deviceInfoField;
    private javax.swing.JLabel deviceInfoField2;
    private javax.swing.JLabel deviceNameField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton locationButton;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel systemFixLabel;
    private javax.swing.JLabel userFixLabel;
    // End of variables declaration//GEN-END:variables

    public ErrorCancelDialog ECD;
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == okButton)
        {
            if (ad != null)
            {
                if (ad.elementAt(4).equals("1"))
                {
                    ECD = new ErrorCancelDialog(MF,alarmID,ad.elementAt(7)+"",deviceID);
                }
                else
                {
                    ECD = new ErrorCancelDialog(MF,alarmID,"",deviceID);
                }
            }
            else
            {
                ECD = new ErrorCancelDialog(MF,alarmID,"",deviceID);
            }
        }
        else if (src == locationButton)
        {
            int choice = 0;
            if (alarmSource.equals("Sensor 1")) choice = 1;
            else if (alarmSource.equals("Sensor 2")) choice = 2;
            else if (alarmSource.equals("Sensor 3")) choice = 3;
            else if (alarmSource.equals("Sensor 4")) choice = 4;
            else if (alarmSource.equals("Sensor 5")) choice = 5;
            LocationPopup2 LP = new LocationPopup2(MF, deviceID,choice);
        }
        /*else if (src == detailButton)
        {
            SuggestionDialog SD = new SuggestionDialog(MF, alarmID);
        }*/
    }

}
