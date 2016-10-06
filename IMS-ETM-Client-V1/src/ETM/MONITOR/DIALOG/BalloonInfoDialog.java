/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MONITOR.DIALOG;

import ETM.MAIN.MainFrame;
import java.util.Vector;
import javax.swing.ImageIcon;

public class BalloonInfoDialog extends javax.swing.JDialog 
{
    private String ID;
    private MainFrame MF;
    
    private ImageIcon ON = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    private ImageIcon OFF = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    
    private ImageIcon REALTIME = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/realtime_32.png"));
    private ImageIcon DATALOGGER = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/data_log_32.png"));
    
    private ImageIcon DEV_ENABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_enable_32.png"));
    private ImageIcon DEV_DISABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_disable_32.png"));
    
    private ImageIcon ALARM_ENABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_enable_32.png"));
    private ImageIcon ALARM_DISABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_disable_32.png"));
    
    private ImageIcon CHARGE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_charge_32.png"));
    private ImageIcon UNCHARGE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_uncharge_32.png"));
    
    private ImageIcon LIGHT_ON = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_24.png"));
    private ImageIcon LIGHT_OFF = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"));
    
    public BalloonInfoDialog(MainFrame MF, String ID) 
    {
        this.ID = ID;
        this.MF = MF;
        initComponents();
        extendComponents();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void extendComponents()
    {
        setInfo();
        setStatus();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        serialLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        serialField = new javax.swing.JLabel();
        groupField = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        batteryBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        do1 = new javax.swing.JLabel();
        do2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        di1 = new javax.swing.JLabel();
        di2 = new javax.swing.JLabel();
        acIcon = new javax.swing.JLabel();
        currentStateLabel = new javax.swing.JLabel();
        operatingIcon = new javax.swing.JLabel();
        alarmDetectIcon = new javax.swing.JLabel();
        deviceEnableIcon = new javax.swing.JLabel();
        do3 = new javax.swing.JLabel();
        do4 = new javax.swing.JLabel();
        do5 = new javax.swing.JLabel();
        do6 = new javax.swing.JLabel();
        do7 = new javax.swing.JLabel();
        do8 = new javax.swing.JLabel();
        di3 = new javax.swing.JLabel();
        di4 = new javax.swing.JLabel();
        di5 = new javax.swing.JLabel();
        di6 = new javax.swing.JLabel();
        di7 = new javax.swing.JLabel();
        di8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Info");
        setAlwaysOnTop(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("General Info"));

        serialLabel.setText("Serial");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idLabel.setText("Device ID");

        typeLabel.setText("Type");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setText("Device Name");

        groupLabel.setText("Group");

        typeField.setForeground(new java.awt.Color(0, 153, 0));
        typeField.setText("-");

        idField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idField.setForeground(new java.awt.Color(0, 153, 0));
        idField.setText("-");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 153, 0));
        nameField.setText("-");

        serialField.setForeground(new java.awt.Color(0, 153, 0));
        serialField.setText("-");

        groupField.setForeground(new java.awt.Color(0, 153, 0));
        groupField.setText("-");

        ipLabel.setText("IP");

        ipField.setForeground(new java.awt.Color(0, 153, 0));
        ipField.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(serialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serialField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(groupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(groupField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ipField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialLabel)
                    .addComponent(serialField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupLabel)
                    .addComponent(groupField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(ipField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Battery Power");

        batteryBar.setForeground(new java.awt.Color(51, 204, 0));
        batteryBar.setValue(80);
        batteryBar.setString("80% (Plugged in)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Digital Output ");

        do1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N

        do2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Digital Input");

        di1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N

        di2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N

        acIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_charge_32.png"))); // NOI18N
        acIcon.setBorder(javax.swing.BorderFactory.createTitledBorder("AC Power"));

        currentStateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        currentStateLabel.setText("Current State");
        currentStateLabel.setToolTipText("");

        operatingIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operatingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/realtime_32.png"))); // NOI18N
        operatingIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operating", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        alarmDetectIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alarmDetectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_enable_32.png"))); // NOI18N
        alarmDetectIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarm Detect", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        deviceEnableIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deviceEnableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_enable_32.png"))); // NOI18N
        deviceEnableIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dev. Enable", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        do3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do3.setEnabled(false);

        do4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do4.setEnabled(false);

        do5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do5.setEnabled(false);

        do6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do6.setEnabled(false);

        do7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do7.setEnabled(false);

        do8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        do8.setEnabled(false);

        di3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di3.setEnabled(false);

        di4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di4.setEnabled(false);

        di5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di5.setEnabled(false);

        di6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di6.setEnabled(false);

        di7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di7.setEnabled(false);

        di8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.PNG"))); // NOI18N
        di8.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(acIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operatingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alarmDetectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deviceEnableIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(batteryBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batteryBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(acIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentStateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operatingIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alarmDetectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceEnableIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(do1))
                    .addComponent(do2)
                    .addComponent(do4)
                    .addComponent(do3)
                    .addComponent(do6)
                    .addComponent(do5)
                    .addComponent(do7)
                    .addComponent(do8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di5)
                            .addComponent(di6))
                        .addComponent(di7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(di8, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di1)
                            .addComponent(di2))
                        .addComponent(di3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(di4, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo()
    {
        Vector form1 = MF.HDC.queryRow("SELECT "
                + "device_name, device_serial, device_product_serial, equipment_type, device_link, "
                + "device_group_id, location_id, device_firmware "
                + "FROM device NATURAL JOIN equipment WHERE device_id = '"+ID+"';");
        if (form1 != null && form1.size() >= 7)
        {
            idField.setText(ID);
            nameField.setText((String) form1.elementAt(0));
            serialField.setText((String) form1.elementAt(1));
            
            String group = MF.HDC.query0("SELECT CONCAT(device_group_name, ' (', device_group_id, ')') "
                    + "FROM device_group WHERE device_group_id = '"+form1.elementAt(5)+"';");
            groupField.setText(group);
        }
         
        Vector ipp = MF.HDC.queryRow("SELECT device_ip, device_port FROM device_network WHERE device_id = '"+ID+"';");
        if (ipp != null && ipp.size() >= 2)
        {
            ipField.setText((String)ipp.elementAt(0) + ":"+ipp.elementAt(1));
        }
    }
    
    public void setStatus()
    {
        Vector form = MF.HDC.queryRow("SELECT "
                + "power_source, battery, device_enable, operate_mode, alarm_detector, "
                + "digital_output, digital_input "
                + "FROM device_status WHERE device_id = '"+ID+"'"
                + ";");
        if (form != null && form.size() >= 6)
        {
            acIcon.setIcon( form.elementAt(0).equals("0") ? CHARGE : UNCHARGE );
            deviceEnableIcon.setIcon( form.elementAt(2).equals("1") ? DEV_ENABLE : DEV_DISABLE );
            operatingIcon.setIcon( form.elementAt(3).equals("0") ? REALTIME : DATALOGGER );
            alarmDetectIcon.setIcon( form.elementAt(4).equals("1") ? ALARM_ENABLE : ALARM_DISABLE );
            
            String am = (String) form.elementAt(5);
            do1.setIcon( am.charAt(0) == '1' ? LIGHT_ON : LIGHT_OFF );
            do2.setIcon( am.charAt(1) == '1' ? LIGHT_ON : LIGHT_OFF );
            
            am = (String) form.elementAt(6);
            di1.setIcon( am.charAt(0) == '1' ? LIGHT_ON : LIGHT_OFF );
            di2.setIcon( am.charAt(1) == '1' ? LIGHT_ON : LIGHT_OFF );
            
            double d = Double.parseDouble((String) form.elementAt(1));
            if (d <= 3.0)
            {
                batteryBar.setValue(0);
            }
            else
            {
                int batteryLevel = (int)(( (d-3d)*100d) / 1.2d);
                batteryBar.setValue(batteryLevel);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acIcon;
    private javax.swing.JLabel alarmDetectIcon;
    private javax.swing.JProgressBar batteryBar;
    private javax.swing.JLabel currentStateLabel;
    private javax.swing.JLabel deviceEnableIcon;
    private javax.swing.JLabel di1;
    private javax.swing.JLabel di2;
    private javax.swing.JLabel di3;
    private javax.swing.JLabel di4;
    private javax.swing.JLabel di5;
    private javax.swing.JLabel di6;
    private javax.swing.JLabel di7;
    private javax.swing.JLabel di8;
    private javax.swing.JLabel do1;
    private javax.swing.JLabel do2;
    private javax.swing.JLabel do3;
    private javax.swing.JLabel do4;
    private javax.swing.JLabel do5;
    private javax.swing.JLabel do6;
    private javax.swing.JLabel do7;
    private javax.swing.JLabel do8;
    private javax.swing.JLabel groupField;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel operatingIcon;
    private javax.swing.JLabel serialField;
    private javax.swing.JLabel serialLabel;
    private javax.swing.JLabel typeField;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
