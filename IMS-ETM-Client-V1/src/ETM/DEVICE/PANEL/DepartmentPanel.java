/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HostPanel.java
 *
 * Created on Jun 6, 2012, 7:51:21 PM
 */

package ETM.DEVICE.PANEL;

import ETM.DEVICE.DIALOG.DepartmentModifyDialog;
import ETM.DEVICE.DeviceManagementIF;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DepartmentPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener
{
    private static String defaultComboBox = "Select a department...";
    public DeviceManagementIF DMIF;

    public DepartmentPanel(DeviceManagementIF DMIF)
    {
        this.DMIF = DMIF;
        
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setDepartmentComboBox();
        setGroupList();
        setDeviceList();
        setUserList();
    }

    private void actionComponents()
    {
        departmentComboBox.addActionListener(this);
        
        modifyButton.addActionListener(this);
        newButton.addActionListener(this);
        deleteButton.addActionListener(this);

        //toDeviceButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        headerLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupList = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JList();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jToolBar6 = new javax.swing.JToolBar();
        modifyButton = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        jToolBar7 = new javax.swing.JToolBar();
        deleteButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText(" Depart. ");
        jPanel5.add(jLabel3);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));
        jPanel5.add(departmentComboBox);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        headerLabel.setText("Department Management");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        idLabel.setText("Depart ID");

        nameLabel.setText("Depart Name");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Address"));

        descriptionField.setBackground(new java.awt.Color(240, 240, 240));
        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        descriptionField.setBorder(null);
        jScrollPane2.setViewportView(descriptionField);

        idField.setText("-");

        nameField.setText("-");

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        picPanel.setMaximumSize(new java.awt.Dimension(360, 240));
        picPanel.setMinimumSize(new java.awt.Dimension(360, 240));
        picPanel.setPreferredSize(new java.awt.Dimension(360, 240));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picPanel.add(picLabel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        listPanel.setMaximumSize(new java.awt.Dimension(30000, 20042));
        listPanel.setMinimumSize(new java.awt.Dimension(200, 242));
        listPanel.setPreferredSize(new java.awt.Dimension(150, 150));
        listPanel.setLayout(new javax.swing.BoxLayout(listPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Device Group in this department");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 20));
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel1.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        groupList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(groupList);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        listPanel.add(jPanel1);

        jPanel6.setPreferredSize(new java.awt.Dimension(100, 150));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Device in this department");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel4.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel4.setMinimumSize(new java.awt.Dimension(100, 20));
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel6.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        deviceList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(deviceList);

        jPanel6.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        listPanel.add(jPanel6);

        jPanel7.setPreferredSize(new java.awt.Dimension(100, 150));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("User in this department");
        jLabel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel5.setMaximumSize(new java.awt.Dimension(100, 20));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 20));
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel7.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(userList);

        jPanel7.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        listPanel.add(jPanel7);

        jScrollPane3.setViewportView(listPanel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 5000));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 200));
        modifyButtonGroup.setPreferredSize(new java.awt.Dimension(34, 200));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel1.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel1.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel1);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator4);

        jToolBar6.setFloatable(false);
        jToolBar6.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar6.setMinimumSize(new java.awt.Dimension(32, 40));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        modifyButton.setToolTipText("Modify Department");
        modifyButton.setEnabled(false);
        modifyButton.setFocusable(false);
        modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyButton.setMaximumSize(new java.awt.Dimension(32, 40));
        modifyButton.setMinimumSize(new java.awt.Dimension(32, 40));
        modifyButton.setPreferredSize(new java.awt.Dimension(32, 40));
        modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(modifyButton);

        modifyButtonGroup.add(jToolBar6);

        jToolBar5.setFloatable(false);
        jToolBar5.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar5.setMinimumSize(new java.awt.Dimension(32, 40));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_new_32.png"))); // NOI18N
        newButton.setToolTipText("Add New Department");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setMaximumSize(new java.awt.Dimension(32, 40));
        newButton.setMinimumSize(new java.awt.Dimension(32, 40));
        newButton.setPreferredSize(new java.awt.Dimension(32, 40));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(newButton);

        modifyButtonGroup.add(jToolBar5);

        jToolBar7.setFloatable(false);
        jToolBar7.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar7.setMinimumSize(new java.awt.Dimension(32, 40));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_delete_32.png"))); // NOI18N
        deleteButton.setToolTipText("Delete Department");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(32, 40));
        deleteButton.setMinimumSize(new java.awt.Dimension(32, 40));
        deleteButton.setPreferredSize(new java.awt.Dimension(32, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(deleteButton);

        modifyButtonGroup.add(jToolBar7);

        jSeparator5.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator5);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    public void setDepartmentComboBox()
    {
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultComboBox);
        Enumeration enu;
        if (DMIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem("All");
            enu = DMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(DMIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+DMIF.MF.SD.loginDepartment+"';"));
        }
    }
    
    public void clearList()
    {
        Object[] obj = new Object[0];
        deviceList.setListData(obj);
        groupList.setListData(obj);
        userList.setListData(obj);
    }
    
    public void setDeviceList()
    {
        String str = (String) departmentComboBox.getSelectedItem();
        if (str != null && !str.equals(defaultComboBox))
        {
            Vector v;
            if (str.equals("All"))
            {
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device NATURAL JOIN device_group;");
            }
            else
            {
                String gid = HydeFormat.parseID(str);
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device NATURAL JOIN device_group WHERE depart_id = "+gid+";");
            }
            Object[] obj = v.toArray();
            deviceList.setListData(obj);
            deviceList.setSelectedIndex(0);
            //deviceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            deviceList.setListData(obj);
        }
    }
    
    public void setUserList()
    {
        String str = (String) departmentComboBox.getSelectedItem();
        if (str != null && !str.equals(defaultComboBox))
        {
            Vector v;
            if (str.equals("All"))
            {
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(user_username, ' (',user_name, ' ', user_surname, ')') FROM user;");
            }
            else
            {
               String gid = HydeFormat.parseID(str);
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(user_username, ' (',user_name, ' ', user_surname, ')') FROM user WHERE depart_id = "+gid+";");
            }
            Object[] obj = v.toArray();
            userList.setListData(obj);
            userList.setSelectedIndex(0);
            //userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            userList.setListData(obj);
        }
    }

    public void setGroupList()
    {
        String str = (String) departmentComboBox.getSelectedItem();
        if (str != null && !str.equals(defaultComboBox))
        {
            Vector v;
            if (str.equals("All"))
            {
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name, ' (',device_group_id+0, ')') FROM device_group;");
            }
            else
            {
               String gid = HydeFormat.parseID(str);
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name, ' (',device_group_id+0, ')') FROM device_group WHERE depart_id = "+gid+";");
            }
            Object[] obj = v.toArray();
            groupList.setListData(obj);
            groupList.setSelectedIndex(0);
            //groupList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            groupList.setListData(obj);
        }
    }

    public void setInfo(String depart)
    {
        if (depart != null)
        {
            HydeImage HI = new HydeImage();
            Vector v = DMIF.MF.HDC.queryRow("SELECT depart_name, depart_address "
                    + "FROM department "
                    + "WHERE depart_id = '"+HydeFormat.parseID(depart)+"';");
            if (v != null && v.size() >= 2)
            {
                idField.setText(HydeFormat.parseID(depart));
                nameField.setText((String)v.elementAt(0));
                descriptionField.setText((String)v.elementAt(1));
                HI.setImageFromUrl(DMIF.MF.SD.urlImgPath+"/image/department/"+idField.getText()+".jpg", picLabel, listPanel, 99, 99,HydeImage.HEIGHT_PRIORITY);
                
                modifyButton.setEnabled(true);
                deleteButton.setEnabled(true);
                //toDeviceButton.setEnabled(true);
            }
            else
            {
                idField.setText("Not found...");
                nameField.setText("Not found...");
                descriptionField.setText("Not found...");
                //typeField.setText("Not found...");
                //departmentField.setText("Not found...");
                HI.setImage(picLabel, listPanel);
            }
        }
    }

    public void clearInfo()
    {
        HydeImage HI = new HydeImage();
        idField.setText("-");
        nameField.setText("-");
        descriptionField.setText("-");
        HI.setImage(picLabel, listPanel);

        modifyButton.setEnabled(false);
        deleteButton.setEnabled(false);
        //toDeviceButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JButton deleteButton;
    public javax.swing.JComboBox departmentComboBox;
    public javax.swing.JTextArea descriptionField;
    private javax.swing.JList deviceList;
    private javax.swing.JList groupList;
    private javax.swing.JLabel headerLabel;
    public javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JPanel listPanel;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel modifyButtonGroup;
    public javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JList userList;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == modifyButton)
        {
            DepartmentModifyDialog HAD = new DepartmentModifyDialog(this, DepartmentModifyDialog.DEPART_EDIT);
        }
        else if (src == newButton)
        {
            DepartmentModifyDialog HAD = new DepartmentModifyDialog(this, DepartmentModifyDialog.DEPART_NEW);
        }
        else if (src == deleteButton)
        {
            int inp = JOptionPane.showConfirmDialog(this, "You want to delete this department ?", "Are you sure ?", JOptionPane.YES_NO_OPTION);
            if (inp == 0)
            {
                
            }
        }
        /*else if (src == toDeviceButton)
        {
            DepartToDeviceialog DTDD = new DepartToDeviceialog(this);
        }*/
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            if (departmentComboBox.getSelectedIndex() == 0)
            {
                modifyButton.setEnabled(false);
                deleteButton.setEnabled(false);
                clearList();
                clearInfo();
            }
            else
            {
                selectedDepartment = (String)departmentComboBox.getSelectedItem();
                if (selectedDepartment.equals("All"))
                {
                    modifyButton.setEnabled(false);
                    deleteButton.setEnabled(false);
                    clearInfo();
                }
                else
                {
                    setInfo(selectedDepartment);
                }
                setGroupList();
                setDeviceList();
                setUserList();
            }
        }
    }

    private String selectedDepartment = "";
    public void valueChanged(ListSelectionEvent e)
    {
        Object src = e.getSource();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        int clickCount = e.getClickCount();
        Object src = e.getSource();
        
    }

}
