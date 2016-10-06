/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MyProfilePanel.java
 *
 * Created on May 30, 2012, 8:02:43 PM
 */

package ETM.USER.PANEL;

import ETM.USER.DIALOG.AccountModifyDialog;
import ETM.USER.UserManagementIF;
import HydeModule.Image.HydeImage;
import HydeModule.Table.HydeDataSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ImageIcon;


public class MyAccountPanel extends javax.swing.JPanel implements ActionListener
{
    public UserManagementIF UMIF;

    private ImageIcon yes = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    private ImageIcon no = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    private ImageIcon na = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"));

    public MyAccountPanel(UserManagementIF UMIF)
    {
        this.UMIF = UMIF;
        
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setInfo(UMIF.MF.SD.loginUser);
        setAccessTable(UMIF.MF.SD.loginUser);
    }

    private void actionComponents()
    {
        modifyButton.addActionListener(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        sectorTabbedPane = new javax.swing.JTabbedPane();
        infoPanel = new javax.swing.JPanel();
        reportPanel = new javax.swing.JPanel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JLabel();
        basicPanel = new javax.swing.JPanel();
        addressLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JLabel();
        addressField2 = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        departmentField = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        profilePanel = new javax.swing.JPanel();
        alarmMethodPanel = new javax.swing.JPanel();
        sms = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        popup = new javax.swing.JLabel();
        alarmTypePanel = new javax.swing.JPanel();
        upper = new javax.swing.JLabel();
        upperTime = new javax.swing.JLabel();
        upperExtreme = new javax.swing.JLabel();
        lower = new javax.swing.JLabel();
        lowerTime = new javax.swing.JLabel();
        lowerExtreme = new javax.swing.JLabel();
        probe = new javax.swing.JLabel();
        device = new javax.swing.JLabel();
        connection = new javax.swing.JLabel();
        permissionPanel = new javax.swing.JPanel();
        manageUser = new javax.swing.JLabel();
        manageDevice = new javax.swing.JLabel();
        manageHost = new javax.swing.JLabel();
        viewLog = new javax.swing.JLabel();
        viewFloorplan = new javax.swing.JLabel();
        dataPresentation = new javax.swing.JLabel();
        crossDepartment = new javax.swing.JLabel();
        accessPanel = new javax.swing.JPanel();
        accessScroll = new javax.swing.JScrollPane();
        accessTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        userField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        surnameField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jToolBar4 = new javax.swing.JToolBar();
        modifyButton = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        reportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Report : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 0, 0))); // NOI18N

        phoneLabel.setForeground(new java.awt.Color(204, 0, 0));
        phoneLabel.setText("Phone (SMS Report Number) : ");

        phoneField.setForeground(new java.awt.Color(204, 0, 0));

        emailLabel.setForeground(new java.awt.Color(204, 0, 0));
        emailLabel.setText("Email (Email Report Address) :");

        emailField.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        basicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Basic :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        addressLabel.setText("Address :");

        departmentLabel.setText("Department : ");

        javax.swing.GroupLayout basicPanelLayout = new javax.swing.GroupLayout(basicPanel);
        basicPanel.setLayout(basicPanelLayout);
        basicPanelLayout.setHorizontalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentField, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
                    .addGroup(basicPanelLayout.createSequentialGroup()
                        .addComponent(addressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addressField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                            .addComponent(addressField, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))))
                .addContainerGap())
        );
        basicPanelLayout.setVerticalGroup(
            basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentLabel))
                .addGap(12, 12, 12)
                .addGroup(basicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(basicPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(basicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sectorTabbedPane.addTab("Information", infoPanel);

        alarmMethodPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Alarm Method"));

        sms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        sms.setText("SMS");

        email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        email.setText("Email");

        popup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        popup.setText("Popup");

        javax.swing.GroupLayout alarmMethodPanelLayout = new javax.swing.GroupLayout(alarmMethodPanel);
        alarmMethodPanel.setLayout(alarmMethodPanelLayout);
        alarmMethodPanelLayout.setHorizontalGroup(
            alarmMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmMethodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sms, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(popup, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        alarmMethodPanelLayout.setVerticalGroup(
            alarmMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmMethodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alarmMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sms)
                    .addComponent(email)
                    .addComponent(popup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sms.getAccessibleContext().setAccessibleName("");
        email.getAccessibleContext().setAccessibleName("");
        popup.getAccessibleContext().setAccessibleName("");

        alarmTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Alarm Type"));

        upper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        upper.setText("Upper");

        upperTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        upperTime.setText("Upper-Time");

        upperExtreme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        upperExtreme.setText("Upper-Extreme");

        lower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        lower.setText("Lower");

        lowerTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        lowerTime.setText("Lower-Time");

        lowerExtreme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        lowerExtreme.setText("Lower-Extreme");

        probe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        probe.setText("Probe Error");

        device.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        device.setText("Device Error");

        connection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        connection.setText("Connection");

        javax.swing.GroupLayout alarmTypePanelLayout = new javax.swing.GroupLayout(alarmTypePanel);
        alarmTypePanel.setLayout(alarmTypePanelLayout);
        alarmTypePanelLayout.setHorizontalGroup(
            alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upper, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperTime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperExtreme, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lower, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerExtreme, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(probe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(device, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connection, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        alarmTypePanelLayout.setVerticalGroup(
            alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alarmTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alarmTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(alarmTypePanelLayout.createSequentialGroup()
                        .addComponent(probe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(device)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connection))
                    .addGroup(alarmTypePanelLayout.createSequentialGroup()
                        .addComponent(lower)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerExtreme))
                    .addGroup(alarmTypePanelLayout.createSequentialGroup()
                        .addComponent(upper)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upperTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upperExtreme)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        upper.getAccessibleContext().setAccessibleName("");
        upperTime.getAccessibleContext().setAccessibleName("");
        upperExtreme.getAccessibleContext().setAccessibleName("");

        permissionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Permission"));

        manageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageUser.setText("Manage User");

        manageDevice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageDevice.setText("Manage Device");

        manageHost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageHost.setText("Manage Host/Location");

        viewLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        viewLog.setText("View Log");

        viewFloorplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        viewFloorplan.setText("View Floorplan");

        dataPresentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        dataPresentation.setText("Data Presentation");

        crossDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        crossDepartment.setText("Cross Department");

        javax.swing.GroupLayout permissionPanelLayout = new javax.swing.GroupLayout(permissionPanel);
        permissionPanel.setLayout(permissionPanelLayout);
        permissionPanelLayout.setHorizontalGroup(
            permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(permissionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(permissionPanelLayout.createSequentialGroup()
                        .addComponent(manageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewLog, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crossDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(permissionPanelLayout.createSequentialGroup()
                        .addComponent(manageDevice, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewFloorplan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(permissionPanelLayout.createSequentialGroup()
                        .addComponent(manageHost, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataPresentation, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        permissionPanelLayout.setVerticalGroup(
            permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(permissionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageUser)
                    .addComponent(viewLog)
                    .addComponent(crossDepartment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageDevice)
                    .addComponent(viewFloorplan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(permissionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageHost)
                    .addComponent(dataPresentation))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alarmMethodPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(permissionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alarmTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alarmMethodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alarmTypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(permissionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(profilePanel);

        sectorTabbedPane.addTab("Alarm & Permission", jScrollPane1);

        accessPanel.setLayout(new javax.swing.BoxLayout(accessPanel, javax.swing.BoxLayout.LINE_AXIS));

        accessTable.setAutoCreateRowSorter(true);
        accessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        accessScroll.setViewportView(accessTable);

        accessPanel.add(accessScroll);

        sectorTabbedPane.addTab("Access History", accessPanel);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("My Account");

        picPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picPanel.setPreferredSize(new java.awt.Dimension(120, 100));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picLabel.setMinimumSize(new java.awt.Dimension(101, 101));
        picLabel.setPreferredSize(new java.awt.Dimension(101, 101));
        picPanel.add(picLabel);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        userLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 153));
        userLabel.setText("Username");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLabel.setText("Name ");

        surnameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        surnameLabel.setText("Surname");

        userField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userField.setForeground(new java.awt.Color(0, 0, 153));

        nameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        surnameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(surnameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(surnameLabel)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sectorTabbedPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(sectorTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel5);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 2147483647));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 200));
        modifyButtonGroup.setPreferredSize(new java.awt.Dimension(32, 200));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel2.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel2.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel2);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator2.setMinimumSize(new java.awt.Dimension(0, 1));
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator2);

        jToolBar4.setFloatable(false);
        jToolBar4.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar4.setMinimumSize(new java.awt.Dimension(32, 40));
        jToolBar4.setPreferredSize(new java.awt.Dimension(32, 40));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        modifyButton.setToolTipText("Edit My Account");
        modifyButton.setFocusable(false);
        modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyButton.setMaximumSize(new java.awt.Dimension(32, 40));
        modifyButton.setMinimumSize(new java.awt.Dimension(32, 40));
        modifyButton.setPreferredSize(new java.awt.Dimension(32, 40));
        modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(modifyButton);

        modifyButtonGroup.add(jToolBar4);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup);
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(String username)
    {
        String option = "WHERE user_username = '"+username+"';";
        Vector u = UMIF.MF.HDC.queryRow("SELECT "
                + "user_username, user_password, user_name, user_surname , user_phone, "
                + "user_email, depart_name, user_address, permission_id "
                + "FROM user NATURAL JOIN department "
                + option);
        if (u != null)
        {
            userField.setText((String) u.elementAt(0));
            nameField.setText((String) u.elementAt(2));
            surnameField.setText((String) u.elementAt(3));
            phoneField.setText((String) u.elementAt(4));

            emailField.setText((String) u.elementAt(5));
            departmentField.setText((String) u.elementAt(6));
            addressField.setText((String) u.elementAt(7));

            Vector alarmInfo = UMIF.MF.HDC.queryRow("SELECT "
                    + "M_POPUP, M_SMS, M_EMAIL, A_UPPER, A_UPPERTIME, "
                    + "A_UPPEREXTREME, A_LOWER, A_LOWERTIME, A_LOWEREXTREME, A_PROBE, "
                    + "A_DEVICE, A_CONNECTION "
                    + "FROM user_alarm WHERE user_username = '"+username+"';");
            if (alarmInfo != null)
            {
                popup.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                sms.setIcon(alarmInfo.elementAt(1).equals("1") ? yes : no);
                email.setIcon(alarmInfo.elementAt(2).equals("1") ? yes : no);

                upper.setIcon(alarmInfo.elementAt(3).equals("1") ? yes : no);
                upperTime.setIcon(alarmInfo.elementAt(4).equals("1") ? yes : no);
                upperExtreme.setIcon(alarmInfo.elementAt(5).equals("1") ? yes : no);
                lower.setIcon(alarmInfo.elementAt(6).equals("1") ? yes : no);
                lowerTime.setIcon(alarmInfo.elementAt(7).equals("1") ? yes : no);
                lowerExtreme.setIcon(alarmInfo.elementAt(8).equals("1") ? yes : no);
                probe.setIcon(alarmInfo.elementAt(9).equals("1") ? yes : no);
                device.setIcon(alarmInfo.elementAt(10).equals("1") ? yes : no);
                connection.setIcon(alarmInfo.elementAt(11).equals("1") ? yes : no);
            }

            Vector permissionInfo = UMIF.MF.HDC.queryRow("SELECT "
                    + "MANAGE_USER, MANAGE_DEVICE, MANAGE_HOST, VIEW_LOG, VIEW_FLOORPLAN, "
                    + "DATA_PRESENTATION, CROSS_DEPARTMENT "
                    + "FROM permission WHERE permission_id = '"+u.elementAt(8)+"';");
            if (permissionInfo != null)
            {
                manageUser.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                manageDevice.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                manageHost.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                viewLog.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                viewFloorplan.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                dataPresentation.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
                crossDepartment.setIcon(alarmInfo.elementAt(0).equals("1") ? yes : no);
            }
        }
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(UMIF.MF.SD.urlImgPath+"/image/user/"+UMIF.MF.SD.loginUser+".jpg", picLabel, picPanel, 99, 99,HydeImage.HEIGHT_PRIORITY);
    }

    private void setAccessTable(String currentUser)
    {
        String stmt = "SELECT user_username AS Username, log_name AS 'Type', user_log_timestamp AS 'Date-Time' "
                + "FROM "+UMIF.MF.SD.defaultDatabase+"_log.user_log NATURAL JOIN "+UMIF.MF.SD.defaultDatabase+"_log.log_type "
                + "WHERE user_log.USER_USERNAME = '"+currentUser+"' && true ORDER BY user_log.user_log_timestamp DESC;";
        Vector VSS = UMIF.MF.HDC.queryAll(stmt);
        HydeDataSet HDS = new HydeDataSet(VSS);
        HDS.generateTable(accessTable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accessPanel;
    private javax.swing.JScrollPane accessScroll;
    private javax.swing.JTable accessTable;
    private javax.swing.JLabel addressField;
    private javax.swing.JLabel addressField2;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JPanel alarmMethodPanel;
    private javax.swing.JPanel alarmTypePanel;
    private javax.swing.JPanel basicPanel;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JLabel connection;
    private javax.swing.JLabel crossDepartment;
    private javax.swing.JLabel dataPresentation;
    private javax.swing.JLabel departmentField;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel device;
    private javax.swing.JLabel email;
    private javax.swing.JLabel emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JLabel lower;
    private javax.swing.JLabel lowerExtreme;
    private javax.swing.JLabel lowerTime;
    private javax.swing.JLabel manageDevice;
    private javax.swing.JLabel manageHost;
    private javax.swing.JLabel manageUser;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel modifyButtonGroup;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel permissionPanel;
    private javax.swing.JLabel phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JLabel popup;
    private javax.swing.JLabel probe;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JTabbedPane sectorTabbedPane;
    private javax.swing.JLabel sms;
    private javax.swing.JLabel surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel upper;
    private javax.swing.JLabel upperExtreme;
    private javax.swing.JLabel upperTime;
    private javax.swing.JLabel userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JLabel viewFloorplan;
    private javax.swing.JLabel viewLog;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == modifyButton)
        {
            AccountModifyDialog AMD = new AccountModifyDialog(UMIF,AccountModifyDialog.MY_ACCOUNT_PANEL);
        }
    }
}
