package ETM.DEVICE.PANEL;

import ETM.DEVICE.DIALOG.NewDeviceDialog;
import ETM.DEVICE.DeviceManagementIF;
import ETM.Util.HydeFormat;
import ETM.Util.HydeTreeRenderer1;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class DeviceModifyPanel extends javax.swing.JPanel implements ActionListener, TreeSelectionListener, KeyListener, ChangeListener
{
    public DeviceManagementIF DMIF;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultDeviceGroupComboBox = "Select a group...";

    private String any = "00";
    
    public DeviceModifyPanel(DeviceManagementIF DMIF)
    {
        this.DMIF = DMIF;
        initComponents();
        extendComponents();

        setDepartmentComboBox();
        actionComponents();
    }

    private void extendComponents()
    {
        setPermission();
        treePanel.add(DMIF.DRC.deviceTree2);
        unknownTreePanel.add(DMIF.DRC.deviceTree3);
        
        setTree3(DMIF.DRC.buildUnknownList());
        unknownTreePanel.removeAll();
        unknownTreePanel.add(DMIF.DRC.deviceTree3);
        unknownTreePanel.validate();
        //setCurrentPanel(DMIF.DRC.currentPanel);
        
    }

    private void actionComponents()
    {
        deviceGroupComboBox.addActionListener(this);
        departmentComboBox.addActionListener(this);
        treeToggleButton.addActionListener(this);
        listToggleButton.addActionListener(this);

        refreshTreeButton.addActionListener(this);
        refreshPanelButton.addActionListener(this);
        readButton.addActionListener(this);
        applyButton.addActionListener(this);
        addButton.addActionListener(this);
        deleteButton.addActionListener(this);

        DMIF.DRC.deviceTree2.addTreeSelectionListener(this);
        DMIF.DRC.deviceTree3.addTreeSelectionListener(this);
        searchField.addKeyListener(this);
        
        deviceTab.addChangeListener(this);
    }

    private void setPermission()
    {
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        deviceListSplitPane = new javax.swing.JSplitPane();
        deviceSelectPanel = new javax.swing.JPanel();
        deviceTab = new javax.swing.JTabbedPane();
        treeScroll = new javax.swing.JScrollPane();
        treePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        unknownTreePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        refreshTreeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        treeToggleButton = new javax.swing.JToggleButton();
        listToggleButton = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        selectedPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        selectedLabel = new javax.swing.JLabel();
        selectedField = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        refreshPanelButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        noteField = new javax.swing.JLabel();
        configPanel = new javax.swing.JPanel();
        groupPanel = new javax.swing.JPanel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();

        jLabel1.setText("Configuration");

        deviceListSplitPane.setDividerLocation(300);

        deviceSelectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deviceSelectPanel.setPreferredSize(new java.awt.Dimension(360, 489));
        deviceSelectPanel.setLayout(new java.awt.BorderLayout());

        treePanel.setLayout(new java.awt.GridLayout(1, 0));
        treeScroll.setViewportView(treePanel);

        deviceTab.addTab("Ready Devices", treeScroll);

        unknownTreePanel.setLayout(new java.awt.GridLayout(1, 0));
        jScrollPane1.setViewportView(unknownTreePanel);

        deviceTab.addTab("Unknown state device", jScrollPane1);

        deviceSelectPanel.add(deviceTab, java.awt.BorderLayout.CENTER);

        jPanel3.setMinimumSize(new java.awt.Dimension(100, 44));
        jPanel3.setPreferredSize(new java.awt.Dimension(295, 44));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(295, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(295, 24));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText(" Search   ");
        jPanel6.add(jLabel3);

        searchField.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        searchField.setMinimumSize(new java.awt.Dimension(6, 15));
        searchField.setPreferredSize(new java.awt.Dimension(6, 15));
        jPanel6.add(searchField);

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel3.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        refreshTreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshTreeButton.setToolTipText("Refresh List");
        refreshTreeButton.setFocusable(false);
        refreshTreeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshTreeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(refreshTreeButton);

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/add_16.png"))); // NOI18N
        addButton.setToolTipText("Add New Device");
        addButton.setFocusable(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(addButton);

        jPanel5.add(jToolBar5);

        jPanel4.add(jPanel5, java.awt.BorderLayout.EAST);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        buttonGroup1.add(treeToggleButton);
        treeToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/node_tree_16.png"))); // NOI18N
        treeToggleButton.setSelected(true);
        treeToggleButton.setToolTipText("Parent Tree View");
        treeToggleButton.setFocusable(false);
        treeToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        treeToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(treeToggleButton);

        buttonGroup1.add(listToggleButton);
        listToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/list_16.png"))); // NOI18N
        listToggleButton.setToolTipText("List View");
        listToggleButton.setFocusable(false);
        listToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(listToggleButton);

        jPanel4.add(jToolBar1, java.awt.BorderLayout.LINE_START);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        deviceSelectPanel.add(jPanel3, java.awt.BorderLayout.SOUTH);

        deviceListSplitPane.setLeftComponent(deviceSelectPanel);

        jPanel1.setLayout(new java.awt.BorderLayout());

        selectedPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selectedPanel.setMaximumSize(new java.awt.Dimension(32767, 45));
        selectedPanel.setMinimumSize(new java.awt.Dimension(32, 45));
        selectedPanel.setPreferredSize(new java.awt.Dimension(32, 45));
        selectedPanel.setRequestFocusEnabled(false);
        selectedPanel.setLayout(new java.awt.BorderLayout());

        jPanel7.setMaximumSize(new java.awt.Dimension(57, 20));
        jPanel7.setMinimumSize(new java.awt.Dimension(57, 20));
        jPanel7.setPreferredSize(new java.awt.Dimension(57, 20));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        selectedLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selectedLabel.setText("  Selected : ");
        jPanel7.add(selectedLabel);

        selectedField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        selectedField.setForeground(new java.awt.Color(0, 102, 0));
        jPanel7.add(selectedField);

        selectedPanel.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel8.setMinimumSize(new java.awt.Dimension(25, 25));
        jPanel8.setPreferredSize(new java.awt.Dimension(365, 25));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        refreshPanelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshPanelButton.setToolTipText("Refresh List");
        refreshPanelButton.setFocusable(false);
        refreshPanelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshPanelButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(refreshPanelButton);

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setToolTipText("Apply to Device");
        applyButton.setEnabled(false);
        applyButton.setFocusable(false);
        applyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        applyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(applyButton);

        readButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/chip_read_16.png"))); // NOI18N
        readButton.setToolTipText("Read From Device");
        readButton.setEnabled(false);
        readButton.setFocusable(false);
        readButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        readButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(readButton);

        jLabel5.setText("   ");
        jToolBar6.add(jLabel5);

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/device_remove_16.png"))); // NOI18N
        deleteButton.setToolTipText("Remove Device");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(deleteButton);

        jPanel8.add(jToolBar6, java.awt.BorderLayout.EAST);
        jPanel8.add(noteField, java.awt.BorderLayout.CENTER);

        selectedPanel.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(selectedPanel, java.awt.BorderLayout.SOUTH);

        configPanel.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(configPanel, java.awt.BorderLayout.CENTER);

        deviceListSplitPane.setRightComponent(jPanel1);

        groupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        jLabel2.setText("Device Group");

        jLabel4.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2)
                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deviceListSplitPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deviceListSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setDepartmentComboBox()
    {
        Enumeration enu;
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
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

    private void setDeviceGroupComboBox()
    {
        Enumeration enu;
        if (departmentComboBox.getSelectedItem() != null)
        {
            String department = (String) departmentComboBox.getSelectedItem();
            if (department.equals("All"))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group;").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else if (!department.equals(defaultDepartmentComboBox))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group WHERE depart_id = '"+HydeFormat.parseID(department)+"';").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
            }
        }
    }


    public void resetTree()
    {
        if (deviceGroupComboBox.getSelectedItem() != null)
        {
            String group = (String) deviceGroupComboBox.getSelectedItem();
            String depart = (String) departmentComboBox.getSelectedItem();
            DMIF.DRC.rootNodeName = depart + " / "+group+"";
            if (!group.equals("All") && !group.equals("No group...") && !group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
            }
            else if (group.equals(defaultDeviceGroupComboBox))
            {
                group = "0";
            }
            if (!depart.equals("All"))
            {
                depart = HydeFormat.parseID(depart);
            }

            String key = searchField.getText();
            String search = "";
            String searchProbe = "";
            if (key != null && key.length() != 0)
            {
                search = " AND ("
                    + "device_id LIKE '%"+key+"%' OR "
                    + "device_name LIKE '%"+key+"%' OR "
                    + "device_serial LIKE '%"+key+"%'"
                    + ")";
                searchProbe = " AND ("
                    + "probe_id LIKE '%"+key+"%' OR "
                    + "probe_name LIKE '%"+key+"%' OR "
                    + "probe_serial LIKE '%"+key+"%'"
                    + ")";
            }

            if (treeToggleButton.isSelected())
            {
                setTree2(DMIF.DRC.buildDeviceTree(depart,group, search));
            }
            else
            {
                setTree2(DMIF.DRC.buildDeviceList(depart,group, search));
            }
            treePanel.removeAll();
            treePanel.add(DMIF.DRC.deviceTree2);
            treePanel.validate();
            setTree3(DMIF.DRC.buildUnknownList());
            unknownTreePanel.removeAll();
            unknownTreePanel.add(DMIF.DRC.deviceTree3);
            unknownTreePanel.validate();
            DMIF.DRC.deviceTree2.addTreeSelectionListener(this);
            DMIF.DRC.deviceTree3.addTreeSelectionListener(this);
        }
    }

    public void setTree2(DefaultTreeModel dTM)
    {
        DMIF.DRC.deviceTree2 = new JTree();
        DMIF.DRC.deviceTree2.setCellRenderer(new HydeTreeRenderer1());
        DMIF.DRC.deviceTree2.setModel(dTM);
    }

    public void setTree3(DefaultTreeModel dTM)
    {
        DMIF.DRC.deviceTree3 = new JTree();
        DMIF.DRC.deviceTree3.setCellRenderer(new HydeTreeRenderer1());
        DMIF.DRC.deviceTree3.setModel(dTM);
    }
    
    public String selectedID = "";
    public String selectedName = "";
    public void loadDeviceData(String data)
    {
        selectedID = HydeFormat.parseID(data);
        selectedName = HydeFormat.parseName(data);
        Vector dataRow = DMIF.MF.HDC.queryRow("SELECT device_id, device_name, equipment_id FROM device NATURAL JOIN equipment WHERE device_id = '"+selectedID+"';");
        if (dataRow != null && dataRow.size() >= 2)
        {
            selectedField.setText(data);
            String type = (String) dataRow.elementAt(2);
            if (type.equals("5"))
            {
                Type5ConfigPanel ETCP = new Type5ConfigPanel(this, selectedID);
                configPanel.removeAll();
                configPanel.add(ETCP);
                currentPanel = ETCP;
                currentPanelType = 1;
            }
            String comp = DMIF.MF.HDC.query0("SELECT last_config_complete FROM device_status WHERE device_id = '"+selectedID+"';");
            if (comp != null && comp.equals("0"))
            {
                noteField.setText("Configuration pending...");
                noteField.setIcon(new ImageIcon(getClass().getResource("/Picz/Button16/error_16.png")));
                noteField.setForeground(new Color(200,0,0));
            }
            else
            {
                noteField.setText("");
                noteField.setIcon(null);
            }
            applyButton.setEnabled(true);
            deleteButton.setEnabled(true);
            readButton.setEnabled(true);
        }
        else
        {
            selectedField.setText("Not found...");
            configPanel.removeAll();
            configPanel.repaint();
            currentPanel = null;
            currentPanelType = 0;
            
            applyButton.setEnabled(false);
            deleteButton.setEnabled(false);
            readButton.setEnabled(false);
        }
    }
    
    public Object currentPanel;
    public int currentPanelType;
    public void loadSensorData(String data, String parent)
    {
        selectedID = HydeFormat.parseID(parent);
        String selectedName = HydeFormat.parseName(parent);
        String selectedChannel = data.charAt(4)+"";
        Vector dataRow = DMIF.MF.HDC.queryRow("SELECT channel_name FROM device_channel WHERE device_id = '"+selectedID+"' AND channel = '"+selectedChannel+"';");
        if (dataRow != null && dataRow.size() >= 1)
        {
            selectedField.setText(data);
            Type5SensorConfigPanel ETSCP = new Type5SensorConfigPanel(this, selectedID, selectedName, selectedChannel);
            configPanel.removeAll();
            configPanel.add(ETSCP);
            currentPanel = ETSCP;
            currentPanelType = 2;
            
            String comp = DMIF.MF.HDC.query0("SELECT last_config_complete FROM device_status WHERE device_id = '"+selectedID+"';");
            if (comp != null && comp.equals("0"))
            {
                noteField.setText("Configuration pending...");
                noteField.setIcon(new ImageIcon(getClass().getResource("/Picz/Button16/error_16.png")));
                noteField.setForeground(new Color(200,0,0));
            }
            else
            {
                noteField.setText("");
                noteField.setIcon(null);
            }
            applyButton.setEnabled(true);
            deleteButton.setEnabled(false);
            readButton.setEnabled(true);
        }
        else
        {
            selectedField.setText("Not found...");
            configPanel.removeAll();
            configPanel.repaint();
            currentPanel = null;
            currentPanelType = 2;
            
            applyButton.setEnabled(false);
            deleteButton.setEnabled(false);
            readButton.setEnabled(false);
        }
    }
    
    public void newDevice(String typeID, String deviceID)
    {
        boolean b = DMIF.MF.HDC.customUpdate("INSERT INTO device SET "
                + "device_id = '"+deviceID+"', "
                + "equipment_id = '"+typeID+"' ;");
        if (b)
        {
            DMIF.MF.HDC.customUpdate("INSERT INTO "+DMIF.MF.HDC.database+"_log.modify_log SET "
                + "device_id = '"+deviceID+"', "
                + "log_id = '104', "
                + "description = 'Create new device instance', "
                + "user_username = '"+DMIF.MF.SD.loginUser+"' "
                + ";");
            JOptionPane.showMessageDialog(null, "Device has been added.\nThe device need to be configured, you can find in 'Unknown State Device' tab");
            setTree3(DMIF.DRC.buildUnknownList());
            resetTree();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton applyButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel configPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    public javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JSplitPane deviceListSplitPane;
    private javax.swing.JPanel deviceSelectPanel;
    private javax.swing.JTabbedPane deviceTab;
    private javax.swing.JPanel groupPanel;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToggleButton listToggleButton;
    private javax.swing.JLabel noteField;
    private javax.swing.JButton readButton;
    private javax.swing.JButton refreshPanelButton;
    private javax.swing.JButton refreshTreeButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel selectedField;
    private javax.swing.JLabel selectedLabel;
    private javax.swing.JPanel selectedPanel;
    private javax.swing.JPanel treePanel;
    private javax.swing.JScrollPane treeScroll;
    private javax.swing.JToggleButton treeToggleButton;
    private javax.swing.JPanel unknownTreePanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == deviceGroupComboBox || src == treeToggleButton || src == listToggleButton)
        {
            resetTree();
        }
        else if (src == refreshTreeButton)
        {
            resetTree();
            select();
        }
        else if (src == refreshPanelButton)
        {
            select();
        }
        else if (src == readButton)
        {
            switch (currentPanelType)
            {
                case 0 : // null
                    break;
                case 1 : 
                    Type5ConfigPanel ETCP = (Type5ConfigPanel) currentPanel;
                    ETCP.read();
                    break;
                case 2 : 
                    Type5SensorConfigPanel ETSCP = (Type5SensorConfigPanel) currentPanel;
                    ETSCP.read();
                    break;
            }
        }
        else if (src == deleteButton)
        {
            int tab = deviceTab.getSelectedIndex();
            if (tab == 0)
            {
                int choice = JOptionPane.showConfirmDialog(null, "You want to remove "+selectedName+" ("+selectedID+") ?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == 0)
                {
                    int choice2 = JOptionPane.showConfirmDialog(null, "The device will STOP operate that means the measured data will not be recorded\nDo you want to continue ?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (choice2 == 0)
                    {
                        removeDevice(selectedID);
                        DMIF.MF.HDC.customUpdate("INSERT INTO "+DMIF.MF.HDC.database+"_log.modify_log SET "
                                + "device_id = '"+selectedID+"', "
                                + "log_id = '106', "
                                + "description = 'Remove device', "
                                + "user_username = '"+DMIF.MF.SD.loginUser+"' "
                                + ";");
                        resetTree();
                    }
                }
            }
            else if (tab == 1)
            {
                int choice = JOptionPane.showConfirmDialog(null, "You want to delete "+selectedName+" ("+selectedID+") from database ??","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == 0)
                {
                    int choice2 = JOptionPane.showConfirmDialog(null, "All of device data will be deleted from this world !\nDo you want to continue ?","Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (choice2 == 0)
                    {
                        boolean b = DMIF.MF.HDC.customUpdate("DELETE FROM device WHERE device_id = '"+selectedID+"';");
                        if (b) 
                        {
                            JOptionPane.showMessageDialog(null, "Device has been deleted");
                            
                        DMIF.MF.HDC.customUpdate("INSERT INTO "+DMIF.MF.HDC.database+"_log.modify_log SET "
                                + "device_id = '"+selectedID+"', "
                                + "log_id = '106', "
                                + "description = 'Delete device data from database', "
                                + "user_username = '"+DMIF.MF.SD.loginUser+"' "
                                + ";");
                        }
                        else JOptionPane.showMessageDialog(null, "Delete fail");
                        resetTree();
                    }
                }
            }
        }
        else if (src == addButton)
        {
            NewDeviceDialog NDD = new NewDeviceDialog(this);
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setDeviceGroupComboBox();
        }
        else if (src == applyButton)
        {
            int app = JOptionPane.showConfirmDialog(this, "Apply this configuration ?", "Message", JOptionPane.YES_NO_OPTION);
            if (app == 0)
            {
                switch (currentPanelType)
                {
                    case 0 : // null
                        break;
                    case 1 : 
                        Type5ConfigPanel ETCP = (Type5ConfigPanel) currentPanel;
                        ETCP.modify();
                        break;
                    case 2 : 
                        Type5SensorConfigPanel ETSCP = (Type5SensorConfigPanel) currentPanel;
                        ETSCP.modify();
                        break;
                }
            }
        }
    }
    
    public void removeDevice(String deviceID)
    {
        IMSProtocolStructure IPS = new IMSProtocolStructure();
        IPS.setFrameType(IMSClientProtocol.REMOVE_DEVICE_CMD);
        IPS.setDeviceID(deviceID);
        IPS.setAccessDirection(IMSClientProtocol.ACCD_WRITE);
        DMIF.MF.FC.findBufferByID("0000000000000000",DMIF.MF.SD.serverIP,DMIF.MF.SD.SERVER_PORT).addFrame(IPS);
        
    }

    private String selected = "";
    private int selectedRow = 0;
    private TreePath[] paths;
    private TreePath selectedPath;
    public void valueChanged(TreeSelectionEvent e)
    {
        Object src = e.getSource();
        if (src == DMIF.DRC.deviceTree2 || src == DMIF.DRC.deviceTree3)
        {
            paths = e.getPaths();
            selected = "";
            for (int i=0; i<paths.length; i++)
            {
                if (e.isAddedPath(i))
                {
                    selected = paths[i].getLastPathComponent().toString();
                    selectedRow = i;
                    selectedPath = paths[i];
                    break;
                }
            }
            selectTree();
            //System.out.println(selected);
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e)
    {
        Object src = e.getSource();
        //resetTree();
    }
    
    

    public void select()
    {
        if (selectedPath != null)
        {
            Object pathNames[] =  selectedPath.getPath();
            int pathCount = selectedPath.getPathCount();
            DMIF.DRC.deviceTree.scrollPathToVisible(selectedPath);
            for (int i=0; i<pathCount ;i++)
            {
                for (int row = 0; row < DMIF.DRC.deviceTree.getRowCount();row++)
                {
                    //System.out.println(pathNames[i] + " vs. "+ DMIF.deviceTree.getPathForRow(row).getLastPathComponent());
                    if ((DMIF.DRC.deviceTree.getPathForRow(row).getLastPathComponent().toString()).equals(pathNames[i].toString()))
                    {
                        DMIF.DRC.deviceTree.expandRow(row);
                        break;
                    }
                }
            }
            DMIF.DRC.deviceTree.setSelectionPath(selectedPath);
            selectTree();
        }
    }

    public void selectTree()
    {
        if (!selected.equals(""))
        {
            if (selected.indexOf("[CH") == 0)
            {
                String pa[] = selectedPath.toString().split(",");
                loadSensorData(selected, pa[pa.length-2].substring(1));
            }
            else
            {
                loadDeviceData(selected);
            }
        }
    }

    public void stateChanged(ChangeEvent e) 
    {
        Object src = e.getSource();
        if (src == deviceTab)
        {
            if (deviceTab.getSelectedIndex() == 0)
            {
                DMIF.DRC.deviceTree2.setSelectionRow(0);
                configPanel.removeAll();
                configPanel.repaint();
            }
            else if (deviceTab.getSelectedIndex() == 1)
            {
                DMIF.DRC.deviceTree3.setSelectionRow(0);
                configPanel.removeAll();
                configPanel.repaint();
            }
        }
    }

}
