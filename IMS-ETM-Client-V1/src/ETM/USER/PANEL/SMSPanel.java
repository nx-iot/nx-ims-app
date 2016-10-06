/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.USER.PANEL;

import ETM.USER.UserManagementIF;
import ETM.Util.HydeCrypto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class SMSPanel extends javax.swing.JPanel implements ActionListener
{
    private UserManagementIF UMIF;
    private SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
    
    public SMSPanel(UserManagementIF UMIF) 
    {
        this.UMIF = UMIF;
        initComponents();
        extendComponents();
        actionComponents();
    }
    
    private void extendComponents()
    {
        
        Vector v = UMIF.MF.HDC.queryRow("SELECT sms_internet, sms_gateway, username, password, message1, message2, sender_name  "
                + "FROM alarm_message NATURAL JOIN sms_provider WHERE message_id = 1");
        if (v != null && v.size() >= 5)
        {
            smsInternetCheckBox.setSelected(v.elementAt(0).equals("1") ? true : false);
            smsGatewayCheckBox.setSelected(v.elementAt(1).equals("1") ? true : false);
            userField.setText((String)v.elementAt(2));
            passField.setText(HydeCrypto.decryptFromString((String)v.elementAt(3),SK, "Blowfish" ));
            msgArea.setText((String)v.elementAt(4)+(String)v.elementAt(5));
            senderField.setText((String)v.elementAt(6));
            //emailCheckBox.setSelected(v.elementAt(5).equals("1") ? true : false);
        }
    }
    
    private void actionComponents()
    {
        idInsertButton.addActionListener(this);
        codeInsertButton.addActionListener(this);
        errorNameInsertButton.addActionListener(this);
        deviceIDInsertButton.addActionListener(this);
        deviceNameInsertButton.addActionListener(this);
        alarmTimeInsertButton.addActionListener(this);
        editButton.addActionListener(this);
        
        channelButton.addActionListener(this);
        sensorNameButton.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        smsInternetCheckBox = new javax.swing.JCheckBox();
        smsGatewayCheckBox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        providerComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        senderField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgArea = new javax.swing.JTextArea();
        idInsertButton = new javax.swing.JButton();
        codeInsertButton = new javax.swing.JButton();
        errorNameInsertButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        deviceIDInsertButton = new javax.swing.JButton();
        deviceNameInsertButton = new javax.swing.JButton();
        alarmTimeInsertButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        channelButton = new javax.swing.JButton();
        sensorNameButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jToolBar5 = new javax.swing.JToolBar();
        editButton = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(759, 1000));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Message Method"));

        smsInternetCheckBox.setText("Internet Messaging Service (SMS)");

        smsGatewayCheckBox.setText("Intelenics GSM Gateway (SMS)");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("*Note : GSM Gateway must be installed");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("*Note : IMS server must connect to the internet");

        providerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MessageDD" }));

        jLabel12.setText("Provider");

        jLabel13.setText("Username");

        jLabel14.setText("Password");

        jLabel15.setText("Sender");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(smsInternetCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(providerComboBox, 0, 126, Short.MAX_VALUE)
                                    .addComponent(userField)
                                    .addComponent(passField)
                                    .addComponent(senderField))))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(smsGatewayCheckBox)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(smsGatewayCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(smsInternetCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(providerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(senderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Message"));

        msgArea.setColumns(20);
        msgArea.setRows(5);
        msgArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(msgArea);

        idInsertButton.setText("Alarm ID");
        idInsertButton.setFocusable(false);

        codeInsertButton.setText("Error Code");
        codeInsertButton.setFocusable(false);

        errorNameInsertButton.setText("Error Name");
        errorNameInsertButton.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*Note : 1 SMS credit can send 160 charactors in English or 70 in Thai.");

        deviceIDInsertButton.setText("Device ID");
        deviceIDInsertButton.setFocusable(false);

        deviceNameInsertButton.setText("Device Name");
        deviceNameInsertButton.setFocusable(false);

        alarmTimeInsertButton.setText("Alarm Time");
        alarmTimeInsertButton.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Alarm ID : 1~10 chars (depends on number of alarm)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Error Code : 4 chars");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("Error Name : 5~30 chars (depends on event name)");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Device ID : 10 chars");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 255));
        jLabel10.setText("Device Name : (vary, depends on user defined in device management)");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 255));
        jLabel11.setText("Alarm Time : 19 chars");

        channelButton.setText("Sensor Channel");
        channelButton.setFocusable(false);

        sensorNameButton.setText("Sensor Name");
        sensorNameButton.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idInsertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codeInsertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errorNameInsertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deviceIDInsertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deviceNameInsertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alarmTimeInsertButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(channelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sensorNameButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(errorNameInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deviceIDInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deviceNameInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alarmTimeInsertButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(channelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sensorNameButton))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Alert SMS Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel3);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 2147483647));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 300));
        modifyButtonGroup.setPreferredSize(new java.awt.Dimension(32, 300));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel7.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel7.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel7.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel7);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator4);

        jToolBar5.setFloatable(false);
        jToolBar5.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar5.setMinimumSize(new java.awt.Dimension(32, 40));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        editButton.setToolTipText("Modify Profile");
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setMaximumSize(new java.awt.Dimension(32, 40));
        editButton.setMinimumSize(new java.awt.Dimension(32, 40));
        editButton.setPreferredSize(new java.awt.Dimension(32, 40));
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(editButton);

        modifyButtonGroup.add(jToolBar5);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmTimeInsertButton;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JButton channelButton;
    private javax.swing.JButton codeInsertButton;
    private javax.swing.JButton deviceIDInsertButton;
    private javax.swing.JButton deviceNameInsertButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton errorNameInsertButton;
    private javax.swing.JButton idInsertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JPanel modifyButtonGroup;
    private javax.swing.JTextArea msgArea;
    private javax.swing.JPasswordField passField;
    private javax.swing.JComboBox providerComboBox;
    private javax.swing.JTextField senderField;
    private javax.swing.JButton sensorNameButton;
    private javax.swing.JCheckBox smsGatewayCheckBox;
    private javax.swing.JCheckBox smsInternetCheckBox;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == idInsertButton)
        {
            msgArea.append("%ALARM_ID%");
        }
        else if (src == codeInsertButton)
        {
            msgArea.append("%ERR_CODE%");
        }
        else if (src == errorNameInsertButton)
        {
            msgArea.append("%ERR_NAME%");
        }
        else if (src == deviceIDInsertButton)
        {
            msgArea.append("%DEVICE_ID%");
        }
        else if (src == deviceNameInsertButton)
        {
            msgArea.append("%DEVICE_NAME%");
        }
        else if (src == alarmTimeInsertButton)
        {
            msgArea.append("%ALARM_TIME%");
        }
        else if (src == channelButton)
        {
            msgArea.append("%CHANNEL%");
        }
        else if (src == sensorNameButton)
        {
            msgArea.append("%SENSOR_NAME%");
        }
        else if (src == editButton)
        {
            int slen = msgArea.getText().length();
            String s1 = "";
            String s2 = "";
            if (slen >= 250)
            {
                s1 = msgArea.getText().substring(0,250);
                s2 = msgArea.getText().substring(250);
            }
            else
            {
                s1 = msgArea.getText();
            }
            boolean b = UMIF.MF.HDC.customUpdate("UPDATE alarm_message SET "
                    + "sms_internet = '"+(smsInternetCheckBox.isSelected() == true ? "1" : "0")+"', "
                    + "sms_gateway = '"+(smsGatewayCheckBox.isSelected() == true ? "1" : "0")+"', "
                    + "sms_provider_id = '"+(providerComboBox.getSelectedIndex()+1)+"' "
                    //+ "email = '"+(emailCheckBox.isSelected() == true ? "1" : "0")+"' "
                    + ";");
            
            boolean b2 = UMIF.MF.HDC.customUpdate("UPDATE sms_provider SET "
                    + "message1 = '"+s1+"', "
                    + "message2 = '"+s2+"', "
                    + "username = '"+userField.getText()+"', "
                    + "password = '"+(HydeCrypto.encryptToString(passField.getText(), SK, "Blowfish"))+"', "
                    + "sender_name = '"+senderField.getText()+"' "
                    + "WHERE sms_provider_id = '"+(providerComboBox.getSelectedIndex()+1)+"' "
                    + ";");
            if (b)
            {
                JOptionPane.showMessageDialog(null, "Alarm message has been set !!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error...");
            }
        }
    }
}
