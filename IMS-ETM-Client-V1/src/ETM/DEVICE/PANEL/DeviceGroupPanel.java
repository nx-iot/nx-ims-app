package ETM.DEVICE.PANEL;

import ETM.DEVICE.DIALOG.DeviceGroupEditDialog;
import ETM.DEVICE.DeviceManagementIF;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class DeviceGroupPanel extends javax.swing.JPanel implements ActionListener
{
    public DeviceManagementIF DIF;
    private static String defaultGroupComboBox = "Select a group...";
    private static String defaultDepartmentComboBox = "Select a department...";
    
    private int maxCount;
    private int count;

    private String any = "1111";

    public DeviceGroupPanel(DeviceManagementIF DIF)
    {
        this.DIF = DIF;
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        count = 0;
        setPermission();
        setComboBox();
        checkComboBox();
    }

    private void actionComponents()
    {
        deviceGroupComboBox.addActionListener(this);
        departmentComboBox.addActionListener(this);

        newButton.addActionListener(this);
        modifyButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    private void setPermission()
    {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        groupLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        headerLabel13 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        headerLabel12 = new javax.swing.JLabel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        departmentField = new javax.swing.JLabel();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jToolBar6 = new javax.swing.JToolBar();
        modifyButton = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        jToolBar7 = new javax.swing.JToolBar();
        deleteButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();

        setPreferredSize(new java.awt.Dimension(600, 400));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new java.awt.BorderLayout());

        groupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupLabel.setText("In group device(s)");
        groupLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        groupLabel.setMaximumSize(new java.awt.Dimension(100, 20));
        groupLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        groupLabel.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel3.add(groupLabel, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(deviceList);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Device Group");

        headerLabel13.setText("Department");
        headerLabel13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        headerLabel13.setMaximumSize(new java.awt.Dimension(63, 10));
        headerLabel13.setMinimumSize(new java.awt.Dimension(63, 10));
        headerLabel13.setOpaque(true);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        headerLabel12.setText("Device Group");
        headerLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        headerLabel12.setMaximumSize(new java.awt.Dimension(63, 10));
        headerLabel12.setMinimumSize(new java.awt.Dimension(63, 10));
        headerLabel12.setOpaque(true);

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        jLabel3.setText("Device Group ID");

        jLabel4.setText("Group Name");

        jLabel9.setText("Department");

        idField.setText("-");

        nameField.setText("-");

        departmentField.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(headerLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(headerLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(departmentField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                            .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentField))))
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 5000));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 300));
        modifyButtonGroup.setPreferredSize(new java.awt.Dimension(34, 300));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel2.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel2.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel2);

        jSeparator5.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator5.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator5);

        jToolBar6.setFloatable(false);
        jToolBar6.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar6.setMinimumSize(new java.awt.Dimension(32, 40));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        modifyButton.setToolTipText("Modify Group");
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
        newButton.setToolTipText("Add New Group");
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
        deleteButton.setToolTipText("Delete Group");
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(32, 40));
        deleteButton.setMinimumSize(new java.awt.Dimension(32, 40));
        deleteButton.setPreferredSize(new java.awt.Dimension(32, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(deleteButton);

        modifyButtonGroup.add(jToolBar7);
        modifyButtonGroup.add(jSeparator4);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    public void setForm()
    {
        String str = (String) deviceGroupComboBox.getSelectedItem();
        if (!str.equals(defaultDepartmentComboBox))
        {
            String name = HydeFormat.parseName(str);
            String gid = HydeFormat.parseID(str);
            idField.setText(gid);
            nameField.setText(name);

            String did = DIF.MF.HDC.query0("SELECT depart_id FROM device_group WHERE device_group_id = "+gid+";");
            if (did != null)
            {
                departmentField.setText(DIF.MF.HDC.query0("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') FROM department WHERE depart_id = '" + did + "';"));
            }
        }
        else
        {
            idField.setText("");
            nameField.setText("");
            departmentField.setText("");
        }
    }

    public void setList()
    {
        String str = (String) deviceGroupComboBox.getSelectedItem();
        if (!str.equals(defaultDepartmentComboBox))
        {
            String gid = HydeFormat.parseID(str);
            Vector v = DIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE device_group_id = "+gid+";");
            Object[] obj = v.toArray();
            count = deviceGroupComboBox.getSelectedIndex();
            deviceList.setListData(obj);
            deviceList.setSelectedIndex(0);
            deviceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            count = 0;
            deviceList.setListData(obj);
        }
    }

    public void setComboBox()
    {
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
        Enumeration enu;
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem("All");
            enu = DIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(DIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+DIF.MF.SD.loginDepartment+"';"));
        }
        setGroupComboBox();
    }
    
    public void setGroupComboBox()
    {
        deviceGroupComboBox.removeAllItems();
        deviceGroupComboBox.addItem(defaultDepartmentComboBox);
        Enumeration enu;
        Vector v;
        if (any.charAt(1) == '1')
        {
             v = DIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name, ' (', device_group_id+0, ')') FROM device_group;");
        }
        else
        {
            v = DIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name, ' (', device_group_id+0, ')') FROM device_group WHERE depart_id = '"+DIF.MF.SD.loginDepartment+"';");
        }
        if (v != null)
        {
            maxCount = v.size();
        }
        else
        {
            maxCount = 0;
        }
        enu = v.elements();
        while (enu.hasMoreElements())
        {
            deviceGroupComboBox.addItem(enu.nextElement());
        }
    }


    private void checkComboBox()
    {
        if (deviceGroupComboBox.getSelectedItem() != null && deviceGroupComboBox.getSelectedItem().equals(defaultDepartmentComboBox))
        {
            modifyButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
        else
        {
            modifyButton.setEnabled(true);
            deleteButton.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JButton deleteButton;
    public javax.swing.JComboBox departmentComboBox;
    public javax.swing.JLabel departmentField;
    public javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JList deviceList;
    private javax.swing.JLabel groupLabel;
    public javax.swing.JLabel headerLabel12;
    public javax.swing.JLabel headerLabel13;
    public javax.swing.JLabel idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel modifyButtonGroup;
    public javax.swing.JLabel nameField;
    private javax.swing.JButton newButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == newButton)
        {
            DeviceGroupEditDialog DGED = new DeviceGroupEditDialog(this,false);
        }
        else if (src == modifyButton)
        {
            if (!deviceGroupComboBox.getSelectedItem().equals(defaultDepartmentComboBox))
            {
                DeviceGroupEditDialog DGED = new DeviceGroupEditDialog(this,true);
            }
        }
        else if (src == deleteButton)
        {
            String str = (String) deviceGroupComboBox.getSelectedItem();
            if (!str.equals(defaultDepartmentComboBox))
            {
                int select = JOptionPane.showConfirmDialog(null, str+" will be delete, are you sure ? ",
                        "Device Management",
                        JOptionPane.YES_NO_OPTION);
                if (select == 0)
                {
                    String gid = HydeFormat.parseID(str);
                    DIF.MF.HDC.customUpdate("DELETE FROM device_group WHERE device_group_id = '"+gid+"';");
                    setComboBox();
                    setList();
                }
            }
        }
        else if (src == deviceGroupComboBox && deviceGroupComboBox.getSelectedItem() != null)
        {
            setForm();
            setList();
            checkComboBox();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setGroupComboBox();
        }
    }

}
