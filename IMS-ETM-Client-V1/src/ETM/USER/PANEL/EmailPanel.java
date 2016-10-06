/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.USER.PANEL;

import ETM.USER.UserManagementIF;
import HydeModule.File.HydeFileConfig;
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
public class EmailPanel extends javax.swing.JPanel implements ActionListener
{
    private UserManagementIF UMIF;
    private SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
    
    public EmailPanel(UserManagementIF UMIF) 
    {
        this.UMIF = UMIF;
        initComponents();
        extendComponents();
        actionComponents();
    }
    
    private void extendComponents()
    {
        Vector v = UMIF.MF.HDC.queryRow("SELECT email, username, password, message1, message2  "
                + "FROM alarm_message NATURAL JOIN email_provider WHERE message_id = 1");
        if (v != null)
        {
            emailCheckBox.setSelected(v.elementAt(0).equals("1") ? true : false);
            userField.setText((String)v.elementAt(1));
            passField.setText(HydeCrypto.decryptFromString((String)v.elementAt(2),SK, "Blowfish" ));
            msgArea.setText((String)v.elementAt(3)+(String)v.elementAt(4));
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
        emailCheckBox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        providerComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        userField = new javax.swing.JTextField();
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

        emailCheckBox.setText("Email Service");

        jLabel12.setText("Provider");

        providerComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "gmail" }));

        jLabel13.setText("Username");

        jLabel14.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(providerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userField)
                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(emailCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailCheckBox)
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
                .addContainerGap(15, Short.MAX_VALUE))
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
        jLabel4.setText("*Note : maximum 500 charactors");

        deviceIDInsertButton.setText("Device ID");
        deviceIDInsertButton.setFocusable(false);

        deviceNameInsertButton.setText("Device Name");
        deviceNameInsertButton.setFocusable(false);

        alarmTimeInsertButton.setText("Alarm Time");
        alarmTimeInsertButton.setFocusable(false);

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
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Alert Mail Management");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        editButton.setToolTipText("Edit Profile");
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
    private javax.swing.JCheckBox emailCheckBox;
    private javax.swing.JButton errorNameInsertButton;
    private javax.swing.JButton idInsertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JButton sensorNameButton;
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
                    + "email = '"+(emailCheckBox.isSelected() == true ? "1" : "0")+"', "
                    + "email_provider_id = '"+(providerComboBox.getSelectedIndex()+1)+"' "
                    + ";");
            
            boolean b2 = UMIF.MF.HDC.customUpdate("UPDATE email_provider SET "
                    + "message1 = '"+s1+"', "
                    + "message2 = '"+s2+"', "
                    + "username = '"+userField.getText()+"', "
                    + "password = '"+(HydeCrypto.encryptToString(passField.getText(), SK, "Blowfish"))+"' "
                    + "WHERE email_provider_id = '"+(providerComboBox.getSelectedIndex()+1)+"' "
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
