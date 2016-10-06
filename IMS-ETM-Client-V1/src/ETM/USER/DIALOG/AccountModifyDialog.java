/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AccountModifyDialog.java
 *
 * Created on May 30, 2012, 9:18:26 PM
 */

package ETM.USER.DIALOG;

import ETM.USER.UserManagementIF;
import ETM.Util.HydeCrypto;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import HydeModule.SCP.HydeSCP;
import HydeModule.TCPFileTransfer.FileSender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class AccountModifyDialog extends javax.swing.JDialog implements ActionListener, KeyListener
{
    public static int MY_ACCOUNT_PANEL = 0;
    public static int ACCOUNT_PANEL = 1;
    public static int ACCOUNT_PANEL_NEW = 2;
    public static int MAXIMUM_LENGTH = 4;
    
    private static String defaultComboBox = "Select a profile...";
    private static String defaultDepartComboBox = "Select a department...";

    public ImageIcon yes = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    public ImageIcon no = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    public ImageIcon na = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"));

    public UserManagementIF UMIF;
    public int panelType;

    public AccountModifyDialog(UserManagementIF UMIF, int panelType)
    {
        this.UMIF = UMIF;
        this.panelType = panelType;
        initComponents();
        extendComponents();
        actionComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        noteComment.setText("*Note : User/Pass must be at least "+MAXIMUM_LENGTH+" charactors...");
        setComboBox();
        setAlarmComboBox();
        switch (panelType)
        {
            case 0: // MY_ACCOUNT_PANEL
                permissionComboBox.setEnabled(false);
                userField.setEnabled(false);
                setInfo(UMIF.MF.SD.loginUser);
                break;
            case 1: // ACCOUNT_PANEL
                userField.setEnabled(false);
                setInfo((String) UMIF.AP.userComboBox.getSelectedItem());
                break;
            case 2: // ACCOUNT_PANEL_NEW
                break;
        }
    }

    private void actionComponents()
    {
        userField.addKeyListener(this);
        passwordField1.addKeyListener(this);
        passwordField2.addKeyListener(this);

        browseButton.addActionListener(this);
        applyButton.addActionListener(this);
        answerButton.addActionListener(this);
        alarmComboBox.addActionListener(this);
        permissionComboBox.addActionListener(this);

        profileNewButton.addActionListener(this);
        profileSaveButton.addActionListener(this);
        profileDeleteButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        noteComment = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        noteComment1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        questionComboBox = new javax.swing.JComboBox();
        addressLabel1 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jToolBar2 = new javax.swing.JToolBar();
        answerButton = new javax.swing.JButton();
        alarmPanel = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        alarmComboBox = new javax.swing.JComboBox();
        methodPanel = new javax.swing.JPanel();
        smsCheckBox = new javax.swing.JCheckBox();
        emailCheckBox = new javax.swing.JCheckBox();
        popupCheckBox = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        upperCheckBox = new javax.swing.JCheckBox();
        upperTimeCheckBox = new javax.swing.JCheckBox();
        connectionCheckBox = new javax.swing.JCheckBox();
        deviceCheckBox = new javax.swing.JCheckBox();
        probeCheckBox = new javax.swing.JCheckBox();
        upperExCheckBox = new javax.swing.JCheckBox();
        lowerExCheckBox = new javax.swing.JCheckBox();
        lowerTimeCheckBox = new javax.swing.JCheckBox();
        lowerCheckBox = new javax.swing.JCheckBox();
        jToolBar1 = new javax.swing.JToolBar();
        profileSaveButton = new javax.swing.JButton();
        profileNewButton = new javax.swing.JButton();
        profileDeleteButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        permissionLabel = new javax.swing.JLabel();
        permissionComboBox = new javax.swing.JComboBox();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Account");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Account");

        picPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picPanel.setMaximumSize(new java.awt.Dimension(105, 105));
        picPanel.setPreferredSize(new java.awt.Dimension(105, 105));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picLabel.setMinimumSize(new java.awt.Dimension(101, 101));
        picLabel.setPreferredSize(new java.awt.Dimension(101, 101));
        picPanel.add(picLabel);

        browseButton.setText("Browse");

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        userLabel.setText("Username : ");

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        passwordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        passwordLabel.setText("Password :");

        noteComment.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        noteComment.setForeground(new java.awt.Color(204, 0, 0));
        noteComment.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noteComment.setText("*Note : User/Pass must be at least 4 charactors...");

        infoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        nameLabel.setText("Name");

        surnameLabel.setText("Surname");

        addressLabel.setText("Address");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Phone");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Email");

        noteComment1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        noteComment1.setForeground(new java.awt.Color(204, 0, 0));
        noteComment1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        noteComment1.setText("*Note : Phone & Email will be used for alarm report system...");

        jLabel4.setText("Question");

        addressLabel1.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jToolBar2.setFloatable(false);

        answerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/comment_16.png"))); // NOI18N
        answerButton.setToolTipText("Answer this question");
        answerButton.setFocusable(false);
        answerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        answerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(answerButton);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                                .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
                            .addGroup(infoPanelLayout.createSequentialGroup()
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(infoPanelLayout.createSequentialGroup()
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nameField))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, infoPanelLayout.createSequentialGroup()
                                        .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(noteComment1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addressLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, 0, 162, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(questionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameLabel)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressLabel)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteComment1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar2, 0, 0, Short.MAX_VALUE)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(questionComboBox)
                        .addComponent(jLabel4))
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departmentComboBox)
                        .addComponent(addressLabel1)))
                .addContainerGap())
        );

        alarmPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Alarm Report"));

        profileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profileLabel.setText("Profile");

        alarmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a profile..." }));

        methodPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));

        smsCheckBox.setText("SMS");

        emailCheckBox.setText("Email");

        popupCheckBox.setText("Software Popup");

        javax.swing.GroupLayout methodPanelLayout = new javax.swing.GroupLayout(methodPanel);
        methodPanel.setLayout(methodPanelLayout);
        methodPanelLayout.setHorizontalGroup(
            methodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(methodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(methodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailCheckBox)
                    .addComponent(popupCheckBox)
                    .addComponent(smsCheckBox))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        methodPanelLayout.setVerticalGroup(
            methodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(methodPanelLayout.createSequentialGroup()
                .addComponent(smsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(popupCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Type"));

        upperCheckBox.setText("Upper");

        upperTimeCheckBox.setText("Upper-Time");

        connectionCheckBox.setText("Connection Lost");

        deviceCheckBox.setText("Device Error");

        probeCheckBox.setText("Probe Error");

        upperExCheckBox.setText("Upper-Extreme");

        lowerExCheckBox.setText("Lower-Extreme");

        lowerTimeCheckBox.setText("Lower-Time");

        lowerCheckBox.setText("Lower");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(upperCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(upperTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(upperExCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deviceCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(probeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lowerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerExCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upperCheckBox)
                            .addComponent(probeCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(upperTimeCheckBox))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(deviceCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(upperExCheckBox)
                            .addComponent(connectionCheckBox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lowerCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lowerTimeCheckBox))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lowerExCheckBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setFloatable(false);

        profileSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        profileSaveButton.setToolTipText("Save selected profile");
        profileSaveButton.setEnabled(false);
        profileSaveButton.setFocusable(false);
        profileSaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileSaveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(profileSaveButton);

        profileNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/new_16.png"))); // NOI18N
        profileNewButton.setToolTipText("Create new profile");
        profileNewButton.setFocusable(false);
        profileNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(profileNewButton);

        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        profileDeleteButton.setToolTipText("Delete selected profile");
        profileDeleteButton.setEnabled(false);
        profileDeleteButton.setFocusable(false);
        profileDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(profileDeleteButton);

        javax.swing.GroupLayout alarmPanelLayout = new javax.swing.GroupLayout(alarmPanel);
        alarmPanel.setLayout(alarmPanelLayout);
        alarmPanelLayout.setHorizontalGroup(
            alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(alarmPanelLayout.createSequentialGroup()
                        .addComponent(profileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alarmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(alarmPanelLayout.createSequentialGroup()
                        .addComponent(methodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        alarmPanelLayout.setVerticalGroup(
            alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmPanelLayout.createSequentialGroup()
                .addGroup(alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alarmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(profileLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(alarmPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(methodPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        applyButton.setText("Apply Change");

        permissionLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/key_16.png"))); // NOI18N
        permissionLabel.setText("Permission");

        permissionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a profile..." }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alarmPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(permissionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(permissionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(applyButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(browseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(picPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(noteComment, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(userLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(userField, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(passwordField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                            .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel)
                            .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(noteComment))
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alarmPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(permissionLabel)
                    .addComponent(permissionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String answer = "";
    private void setInfo(String username)
    {
        Vector userInfo = UMIF.MF.HDC.queryRow("SELECT "
                + "user_password, user_name, user_surname, user_address, user_register_date, "
                + "user_phone, user_email, depart_id, permission_id, user_question_id, "
                + "user_question_answer "
                + "FROM user NATURAL JOIN department WHERE user_username = '"+username+"';");
        if (userInfo != null)
        {
            userField.setText(username);
            SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
            passwordField1.setText(HydeCrypto.decryptFromString((String) userInfo.elementAt(0), SK, "Blowfish"));
            passwordField2.setText(HydeCrypto.decryptFromString((String) userInfo.elementAt(0), SK, "Blowfish"));
            nameField.setText((String)userInfo.elementAt(1));
            surnameField.setText((String)userInfo.elementAt(2));
            addressField.setText((String)userInfo.elementAt(3));
            phoneField.setText((String)userInfo.elementAt(5));
            emailField.setText((String)userInfo.elementAt(6));

            if (userInfo.elementAt(7) != null)
            {
                departmentComboBox.setSelectedItem(UMIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id,')') "
                    + "FROM department WHERE depart_id = '"+userInfo.elementAt(7)+"';"));
            }
            if (userInfo.elementAt(8) != null)
            {
                permissionComboBox.setSelectedItem(UMIF.MF.HDC.query0("SELECT CONCAT(permission_name,' (',permission_id,')') "
                    + "FROM permission WHERE permission_id = '"+userInfo.elementAt(8)+"';"));
            }
            questionComboBox.setSelectedIndex(Integer.parseInt((String)userInfo.elementAt(9))-1);
            answer = (String)userInfo.elementAt(10);

            Vector alarmInfo = UMIF.MF.HDC.queryRow("SELECT "
                    + "M_POPUP, M_SMS, M_EMAIL, A_UPPER, A_UPPERTIME, "
                    + "A_UPPEREXTREME, A_LOWER, A_LOWERTIME, A_LOWEREXTREME, A_PROBE, "
                    + "A_DEVICE, A_CONNECTION "
                    + "FROM user_alarm WHERE user_username = '"+username+"';");
            if (alarmInfo != null)
            {
                if (alarmInfo.elementAt(0).equals("1")) popupCheckBox.setSelected(true);
                if (alarmInfo.elementAt(1).equals("1")) smsCheckBox.setSelected(true);
                if (alarmInfo.elementAt(2).equals("1")) emailCheckBox.setSelected(true);

                if (alarmInfo.elementAt(3).equals("1")) upperCheckBox.setSelected(true);
                if (alarmInfo.elementAt(4).equals("1")) upperTimeCheckBox.setSelected(true);
                if (alarmInfo.elementAt(5).equals("1")) upperExCheckBox.setSelected(true);
                if (alarmInfo.elementAt(6).equals("1")) lowerCheckBox.setSelected(true);
                if (alarmInfo.elementAt(7).equals("1")) lowerTimeCheckBox.setSelected(true);
                if (alarmInfo.elementAt(8).equals("1")) lowerExCheckBox.setSelected(true);
                if (alarmInfo.elementAt(9).equals("1")) probeCheckBox.setSelected(true);
                if (alarmInfo.elementAt(10).equals("1")) deviceCheckBox.setSelected(true);
                if (alarmInfo.elementAt(11).equals("1")) connectionCheckBox.setSelected(true);
            }
        }
        HydeImage HI = new HydeImage();
        System.out.println(UMIF.MF.SD.urlImgPath+"/image/user/"+UMIF.MF.SD.loginUser+".jpg");
        HI.setImageFromUrl(UMIF.MF.SD.urlImgPath+"/image/user/"+UMIF.MF.SD.loginUser+".jpg", picLabel, picPanel, 99, 99,HydeImage.HEIGHT_PRIORITY);
    }

    private void setAlarmInfo(String apid)
    {
        if (apid.equals(defaultComboBox)) 
        {
            profileSaveButton.setEnabled(false);
            profileDeleteButton.setEnabled(false);
            return;
        }
        Vector alarmInfo = UMIF.MF.HDC.queryRow("SELECT "
                    + "M_POPUP, M_SMS, M_EMAIL, A_UPPER, A_UPPERTIME, "
                    + "A_UPPEREXTREME, A_LOWER, A_LOWERTIME, A_LOWEREXTREME, A_PROBE, "
                    + "A_DEVICE, A_CONNECTION "
                    + "FROM user_alarm_profile WHERE user_alarm_profile_id = '"+HydeFormat.parseID(apid)+"';");
        if (alarmInfo != null)
        {
            popupCheckBox.setSelected(alarmInfo.elementAt(0).equals("1") ? true : false);
            smsCheckBox.setSelected(alarmInfo.elementAt(1).equals("1") ? true : false);
            emailCheckBox.setSelected(alarmInfo.elementAt(2).equals("1") ? true : false);

            upperCheckBox.setSelected(alarmInfo.elementAt(3).equals("1") ? true : false);
            upperTimeCheckBox.setSelected(alarmInfo.elementAt(4).equals("1") ? true : false);
            upperExCheckBox.setSelected(alarmInfo.elementAt(5).equals("1") ? true : false);
            lowerCheckBox.setSelected(alarmInfo.elementAt(6).equals("1") ? true : false);
            lowerTimeCheckBox.setSelected(alarmInfo.elementAt(7).equals("1") ? true : false);
            lowerExCheckBox.setSelected(alarmInfo.elementAt(8).equals("1") ? true : false);
            probeCheckBox.setSelected(alarmInfo.elementAt(9).equals("1") ? true : false);
            deviceCheckBox.setSelected(alarmInfo.elementAt(10).equals("1") ? true : false);
            connectionCheckBox.setSelected(alarmInfo.elementAt(11).equals("1") ? true : false);

            profileSaveButton.setEnabled(true);
            profileDeleteButton.setEnabled(true);
        }
    }

    private void saveAlarmProfile()
    {
        String apf = (String) alarmComboBox.getSelectedItem();
        if (apf != null && !apf.equals(defaultComboBox))
        {
            boolean success = UMIF.MF.HDC.customUpdate("UPDATE user_alarm_profile SET "
                    + "M_POPUP = '"+(popupCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_SMS = '"+(smsCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_EMAIL = '"+(emailCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPER = '"+(upperCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPERTIME = '"+(upperTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPEREXTREME = '"+(upperExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWER = '"+(lowerCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWERTIME = '"+(lowerTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWEREXTREME = '"+(lowerExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_PROBE = '"+(probeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_DEVICE = '"+(deviceCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_CONNECTION = '"+(connectionCheckBox.isSelected() == true ? 1 : 0)+"' "
                    + "WHERE user_alarm_profile_id = '"+HydeFormat.parseID(apf)+"' "
                    + ";"
                    );
            if (success)
            {
                JOptionPane.showMessageDialog(this, "Profile has been updated...");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cannot update profile...", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void newAlarmProfile(String pname)
    {
        if (UMIF.MF.HDC.query0("SELECT user_alarm_profile_name FROM user_alarm_profile WHERE user_alarm_profile_name = '"+pname+"';") != null)
        {
            JOptionPane.showMessageDialog(this, "Profile name already exists...", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success = UMIF.MF.HDC.customUpdate("INSERT INTO user_alarm_profile SET "
                + "user_alarm_profile_name = '"+pname+"', "
                + "M_POPUP = '"+(popupCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "M_SMS = '"+(smsCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "M_EMAIL = '"+(emailCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_UPPER = '"+(upperCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_UPPERTIME = '"+(upperTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_UPPEREXTREME = '"+(upperExCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_LOWER = '"+(lowerCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_LOWERTIME = '"+(lowerTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_LOWEREXTREME = '"+(lowerExCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_PROBE = '"+(probeCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_DEVICE = '"+(deviceCheckBox.isSelected() == true ? 1 : 0)+"', "
                + "A_CONNECTION = '"+(connectionCheckBox.isSelected() == true ? 1 : 0)+"' "
                + ";"
                );
        if (success)
        {
            setAlarmComboBox();
            alarmComboBox.setSelectedItem(UMIF.MF.HDC.query0("SELECT CONCAT(user_alarm_profile_name, ' (', user_alarm_profile_id, ')') FROM user_alarm_profile WHERE user_alarm_profile_name = '"+pname+"';"));
            JOptionPane.showMessageDialog(this, "Profile has been created...");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot create profile...", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteAlarmProfile()
    {
        String apf = (String) alarmComboBox.getSelectedItem();
        if (apf != null && !apf.equals(defaultComboBox))
        {
            UMIF.MF.HDC.customUpdate("DELETE FROM user_alarm_profile WHERE user_alarm_profile_id = '"+HydeFormat.parseID(apf)+"';");
        }
    }

    private void setComboBox()
    {
        Enumeration enu;
        enu = UMIF.MF.HDC.queryColumn("SELECT user_question_text FROM user_question;").elements();
        questionComboBox.removeAllItems();
        while (enu.hasMoreElements())
        {
            questionComboBox.addItem(enu.nextElement());
        }

        enu = UMIF.MF.HDC.queryColumn("SELECT CONCAT(permission_name, ' (', permission_id, ')') FROM permission;").elements();
        permissionComboBox.removeAllItems();
        permissionComboBox.addItem(defaultComboBox);
        while (enu.hasMoreElements())
        {
            permissionComboBox.addItem(enu.nextElement());
        }

        enu = UMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name, ' (', depart_id, ')') FROM department;").elements();
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartComboBox);
        while (enu.hasMoreElements())
        {
            departmentComboBox.addItem(enu.nextElement());
        }
    }

    private void setAlarmComboBox()
    {
        Enumeration enu;
        enu = UMIF.MF.HDC.queryColumn("SELECT CONCAT(user_alarm_profile_name, ' (', user_alarm_profile_id, ')') FROM user_alarm_profile;").elements();
        alarmComboBox.removeAllItems();
        alarmComboBox.addItem(defaultComboBox);
        while (enu.hasMoreElements())
        {
            alarmComboBox.addItem(enu.nextElement());
        }
    }

    private void updateAccount()
    {
        if (!passwordField1.getText().equals(passwordField2.getText()))
        {
            JOptionPane.showMessageDialog(this, "Password mismatch...");
            return;
        }
        if (userField.getText().length() < 8 && !userField.getText().toLowerCase().equals("admin"))
        {
            JOptionPane.showMessageDialog(this, "Username too short...");
            return;
        }
        if (passwordField1.getText().length() < 8)
        {
            JOptionPane.showMessageDialog(this, "Password too short...");
            return;
        }
        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
        boolean success = UMIF.MF.HDC.customUpdate("UPDATE user SET "
                + "user_password = '"+HydeCrypto.encryptToString(passwordField1.getText(), SK, "Blowfish")+"', "
                + "user_name = '"+nameField.getText()+"', "
                + "user_surname = '"+surnameField.getText()+"', "
                + "user_address = '"+addressField.getText()+"', "
                + "user_phone = '"+phoneField.getText()+"', "
                + "user_email = '"+emailField.getText()+"', "
                + "depart_id = '"+(departmentComboBox.getSelectedItem().equals(defaultDepartComboBox) ? null : HydeFormat.parseID((String) departmentComboBox.getSelectedItem()))+"', "
                + "permission_id = '"+(permissionComboBox.getSelectedItem().equals(defaultComboBox) ? null : HydeFormat.parseID((String) permissionComboBox.getSelectedItem()))+"', "
                + "user_question_id = '"+(questionComboBox.getSelectedIndex()+1)+"', "
                + "user_question_answer = '"+answer+"' "
                + "WHERE user_username = '"+userField.getText()+"' "
                + ";");
        if (success)
        {
            
            boolean bs = UMIF.MF.HDC.customUpdate("UPDATE user_alarm SET "
                    + "M_POPUP = '"+(popupCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_SMS = '"+(smsCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_EMAIL = '"+(emailCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPER = '"+(upperCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPERTIME = '"+(upperTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPEREXTREME = '"+(upperExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWER = '"+(lowerCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWERTIME = '"+(lowerTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWEREXTREME = '"+(lowerExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_PROBE = '"+(probeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_DEVICE = '"+(deviceCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_CONNECTION = '"+(connectionCheckBox.isSelected() == true ? 1 : 0)+"' "
                    + "WHERE user_username = '"+userField.getText()+"'"
                    + ";"
                    );
            if(!selectedImage.equals(""))
            {
                //HP.DMIF.MF.HI.resizeImageFileToFile(selectedImage, HP.DMIF.MF.mainPath+"temp.jpg", imageWidth, imageHeight);
                if (UMIF.MF.SD.upload.toLowerCase().equals("scp"))
                {
                    HydeSCP HSCP = new HydeSCP();
                    HSCP.createSession("root", UMIF.MF.SD.serverPassword, UMIF.MF.SD.serverIP);
                    boolean bb =HSCP.scpTo(selectedImage, UMIF.MF.SD.serverImgPath+"/image/user/"+userField.getText()+".jpg");
                }
                else
                {
                    FileSender.send(UMIF.MF.SD.serverIP, UMIF.MF.SD.FILE_SERVER_PORT, selectedImage, UMIF.MF.SD.serverImgPath+"/image/user/"+userField.getText()+".jpg");
                }
            }
            switch (panelType)
            {
                case 0: // MY_ACCOUNT_PANEL
                    UMIF.MP.setInfo(userField.getText());
                    break;
                case 1: // ACCOUNT_PANEL
                    UMIF.AP.setUserComboBox();
                    UMIF.AP.userComboBox.setSelectedItem(userField.getText());
                    break;
            }
            JOptionPane.showMessageDialog(this, "Account has been updated...\nPlease relogin to make changes to your profile");
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot update account...", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void newAccount()
    {
        if (!passwordField1.getText().equals(passwordField2.getText()))
        {
            JOptionPane.showMessageDialog(this, "Password mismatch...");
            return;
        }
        if (userField.getText().length() < MAXIMUM_LENGTH)
        {
            JOptionPane.showMessageDialog(this, "Username too short...");
            return;
        }
        if (passwordField1.getText().length() < MAXIMUM_LENGTH)
        {
            JOptionPane.showMessageDialog(this, "Password too short...");
            return;
        }
        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
        boolean success = UMIF.MF.HDC.customUpdate("INSERT INTO user SET "
                + "user_username = '"+userField.getText()+"', "
                + "user_password = '"+HydeCrypto.encryptToString(passwordField1.getText(), SK, "Blowfish")+"', "
                + "user_name = '"+nameField.getText()+"', "
                + "user_surname = '"+surnameField.getText()+"', "
                + "user_address = '"+addressField.getText()+"', "
                + "user_phone = '"+phoneField.getText()+"', "
                + "user_email = '"+emailField.getText()+"', "
                + "depart_id = '"+(departmentComboBox.getSelectedItem().equals(defaultDepartComboBox) ? null : HydeFormat.parseID((String) departmentComboBox.getSelectedItem()))+"', "
                + "permission_id = '"+(permissionComboBox.getSelectedItem().equals(defaultComboBox) ? null : HydeFormat.parseID((String) permissionComboBox.getSelectedItem()))+"', "
                + "user_question_id = '"+(questionComboBox.getSelectedIndex()+1)+"', "
                + "user_question_answer = '"+answer+"' "
                + ";");
        if (success)
        {
            boolean bs = UMIF.MF.HDC.customUpdate("UPDATE user_alarm SET "
                    + "M_POPUP = '"+(popupCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_SMS = '"+(smsCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "M_EMAIL = '"+(emailCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPER = '"+(upperCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPERTIME = '"+(upperTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_UPPEREXTREME = '"+(upperExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWER = '"+(lowerCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWERTIME = '"+(lowerTimeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_LOWEREXTREME = '"+(lowerExCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_PROBE = '"+(probeCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_DEVICE = '"+(deviceCheckBox.isSelected() == true ? 1 : 0)+"', "
                    + "A_CONNECTION = '"+(connectionCheckBox.isSelected() == true ? 1 : 0)+"' "
                    + "WHERE user_username = '"+userField.getText()+"'"
                    + ";"
                    );
            if(!selectedImage.equals(""))
            {
                //HP.DMIF.MF.HI.resizeImageFileToFile(selectedImage, HP.DMIF.MF.mainPath+"temp.jpg", imageWidth, imageHeight);
                if (UMIF.MF.SD.upload.toLowerCase().equals("scp"))
                {
                    HydeSCP HSCP = new HydeSCP();
                    HSCP.createSession("root", UMIF.MF.SD.serverPassword, UMIF.MF.SD.serverIP);
                    boolean bb =HSCP.scpTo(selectedImage, UMIF.MF.SD.serverImgPath+"/image/user/"+userField.getText()+".jpg");
                }
                else
                {
                    FileSender.send(UMIF.MF.SD.serverIP, UMIF.MF.SD.FILE_SERVER_PORT, selectedImage, UMIF.MF.SD.serverImgPath+"/image/user/"+userField.getText()+".jpg");
                }
            }
            JOptionPane.showMessageDialog(this, "Account has been inserted...");
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot insert new account...", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JComboBox alarmComboBox;
    private javax.swing.JPanel alarmPanel;
    private javax.swing.JButton answerButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JCheckBox connectionCheckBox;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JCheckBox deviceCheckBox;
    private javax.swing.JCheckBox emailCheckBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JCheckBox lowerCheckBox;
    private javax.swing.JCheckBox lowerExCheckBox;
    private javax.swing.JCheckBox lowerTimeCheckBox;
    private javax.swing.JPanel methodPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel noteComment;
    private javax.swing.JLabel noteComment1;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JComboBox permissionComboBox;
    private javax.swing.JLabel permissionLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JCheckBox popupCheckBox;
    private javax.swing.JCheckBox probeCheckBox;
    private javax.swing.JButton profileDeleteButton;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JButton profileNewButton;
    private javax.swing.JButton profileSaveButton;
    private javax.swing.JComboBox questionComboBox;
    private javax.swing.JCheckBox smsCheckBox;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JCheckBox upperCheckBox;
    private javax.swing.JCheckBox upperExCheckBox;
    private javax.swing.JCheckBox upperTimeCheckBox;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

    private String selectedImage = "";
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == browseButton)
        {
            HydeImage HI = new HydeImage();
            selectedImage = HI.browseImage(this, userField.getText());
            HI.setImage(selectedImage, picLabel, picPanel, 99, 99, HydeImage.HEIGHT_PRIORITY);
        }
        else if (src == answerButton)
        {
            String inp = JOptionPane.showInputDialog(this, "Insert your answer...");
            if (inp != null && inp.length() > 0)
            {
                answer = inp;
                JOptionPane.showMessageDialog(this, "Answer set (please click apply to save)");
            }
        }
        else if (src == applyButton)
        {
            switch (panelType)
            {
                case 0: // MY_ACCOUNT_PANEL
                    updateAccount();
                    break;
                case 1: // ACCOUNT_PANEL
                    updateAccount();
                    break;
                case 2: // ACCOUNT_PANEL_NEW
                    newAccount();
                    break;
            }
        }
        else if (src == alarmComboBox && alarmComboBox.getSelectedItem() != null)
        {
            setAlarmInfo((String)alarmComboBox.getSelectedItem());
        }
        else if (src == profileSaveButton)
        {
            saveAlarmProfile();
        }
        else if (src == profileNewButton)
        {
             String inp = JOptionPane.showInputDialog("Please insert profile name...");
             if (inp != null && inp.length() > 0)
             {
                 newAlarmProfile(inp);
             }
        }
        else if (src == profileDeleteButton)
        {
             int inp = JOptionPane.showConfirmDialog(this, "You want to delete this profile ?", "Are you sure ?", JOptionPane.YES_NO_OPTION);
             if (inp == 1)
             {
                 deleteAlarmProfile();
             }
        }
    }

    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e)
    {
        Object src = e.getSource();
        if (src == userField)
        {
            userLabel.setIcon( userField.getText().length() >= MAXIMUM_LENGTH ? yes : no);
        }
        else if (src == passwordField1 || src == passwordField2)
        {
            passwordLabel.setIcon( (passwordField1.getText().length() >= MAXIMUM_LENGTH && passwordField1.getText().equals(passwordField2.getText())) ? yes : no);

        }
    }

}
