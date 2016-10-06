package ETM.DEVICE.PANEL;

import ETM.DEVICE.DeviceManagementIF;
import ETM.Util.HydeFormat;
import ETM.Util.HydeTreeRenderer1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class DeviceListPanel extends javax.swing.JPanel implements ActionListener, TreeSelectionListener, KeyListener
{
    public DeviceManagementIF DMIF;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultDeviceGroupComboBox = "Select a group...";

    public static int DISPLAY_TREE = 0;
    public static int DISPLAY_LIST = 1;


    public DeviceListPanel(DeviceManagementIF DMIF)
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
        treePanel.add(DMIF.DRC.deviceTree);
        setCurrentPanel(DMIF.DRC.currentPanel);
    }

    private void actionComponents()
    {
        deviceGroupComboBox.addActionListener(this);
        departmentComboBox.addActionListener(this);
        treeToggleButton.addActionListener(this);
        listToggleButton.addActionListener(this);

        refreshTreeButton.addActionListener(this);
        refreshButton.addActionListener(this);

        //DMIF.removeListeners();
        DMIF.DRC.deviceTree.addTreeSelectionListener(this);
        searchField.addKeyListener(this);
    }
    
    private void setPermission()
    {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewButtonGroup = new javax.swing.ButtonGroup();
        deviceListSplitPane = new javax.swing.JSplitPane();
        deviceSelectPanel = new javax.swing.JPanel();
        treeScroll = new javax.swing.JScrollPane();
        treePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        refreshTreeButton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        treeToggleButton = new javax.swing.JToggleButton();
        listToggleButton = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        selectedLabel = new javax.swing.JLabel();
        selectedField = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jToolBar6 = new javax.swing.JToolBar();
        refreshButton = new javax.swing.JButton();
        detailPanel = new javax.swing.JPanel();
        groupPanel = new javax.swing.JPanel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        deviceListSplitPane.setDividerLocation(300);

        deviceSelectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        deviceSelectPanel.setPreferredSize(new java.awt.Dimension(360, 489));
        deviceSelectPanel.setLayout(new java.awt.BorderLayout());

        treePanel.setLayout(new java.awt.GridLayout(1, 0));
        treeScroll.setViewportView(treePanel);

        deviceSelectPanel.add(treeScroll, java.awt.BorderLayout.CENTER);

        jPanel3.setMinimumSize(new java.awt.Dimension(100, 44));
        jPanel3.setPreferredSize(new java.awt.Dimension(295, 44));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setMinimumSize(new java.awt.Dimension(295, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(295, 24));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText(" Search   ");
        jPanel2.add(jLabel3);
        jPanel2.add(searchField);

        jPanel3.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        refreshTreeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshTreeButton.setToolTipText("Refresh");
        refreshTreeButton.setFocusable(false);
        refreshTreeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshTreeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(refreshTreeButton);

        jPanel5.add(jToolBar5);

        jPanel4.add(jPanel5, java.awt.BorderLayout.EAST);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        viewButtonGroup.add(treeToggleButton);
        treeToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/node_tree_16.png"))); // NOI18N
        treeToggleButton.setSelected(true);
        treeToggleButton.setToolTipText("Parent Tree View");
        treeToggleButton.setFocusable(false);
        treeToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        treeToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(treeToggleButton);

        viewButtonGroup.add(listToggleButton);
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

        jPanel1.setMinimumSize(new java.awt.Dimension(32, 44));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setMaximumSize(new java.awt.Dimension(32767, 45));
        jPanel6.setMinimumSize(new java.awt.Dimension(32, 45));
        jPanel6.setPreferredSize(new java.awt.Dimension(32, 45));
        jPanel6.setRequestFocusEnabled(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        jPanel6.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setMaximumSize(new java.awt.Dimension(0, 0));
        jPanel8.setMinimumSize(new java.awt.Dimension(25, 25));
        jPanel8.setPreferredSize(new java.awt.Dimension(365, 25));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshButton.setToolTipText("Refresh Info");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(refreshButton);

        jPanel8.add(jToolBar6, java.awt.BorderLayout.EAST);

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

        detailPanel.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(detailPanel, java.awt.BorderLayout.CENTER);

        deviceListSplitPane.setRightComponent(jPanel1);

        groupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        jLabel1.setText("Device Group");

        jLabel2.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2)
                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel4.setText("Device List");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deviceListSplitPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                    .addComponent(groupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deviceListSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
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
                setTree(DMIF.DRC.buildDeviceTree(depart,group, search));
            }
            else
            {
                setTree(DMIF.DRC.buildDeviceList(depart,group, search));
            }
            treePanel.removeAll();
            treePanel.add(DMIF.DRC.deviceTree);
            treePanel.validate();
            DMIF.DRC.deviceTree.addTreeSelectionListener(this);
        }
    }

    public void setTree(DefaultTreeModel dTM)
    {
        DMIF.DRC.deviceTree = new JTree();
        DMIF.DRC.deviceTree.setCellRenderer(new HydeTreeRenderer1());
        DMIF.DRC.deviceTree.setModel(dTM);
    }
    
    public void loadDeviceData(String data)
    {
        String selectedID = HydeFormat.parseID(data);
        Vector dataRow = DMIF.MF.HDC.queryRow("SELECT device_id, device_name, equipment_id FROM device NATURAL JOIN equipment WHERE device_id = '"+selectedID+"';");
        if (dataRow != null && dataRow.size() >= 2)
        {
            selectedField.setText(data);
            String type = (String) dataRow.elementAt(2);
            if (type.equals("5"))
            {
                Type5DisplayPanel ETCP = new Type5DisplayPanel(this, selectedID);
                detailPanel.removeAll();
                detailPanel.add(ETCP);
                currentPanel = ETCP;
                currentPanelType = 1;
            }
        }
        else
        {
            selectedField.setText("Not found...");
            detailPanel.removeAll();
            currentPanel = null;
            currentPanelType = 0;
        }
    }
    
    public Object currentPanel;
    public int currentPanelType;
    public void loadSensorData(String data, String parent)
    {
        String selectedID = HydeFormat.parseID(parent);
        String selectedName = HydeFormat.parseName(parent);
        String selectedChannel = data.charAt(4)+"";
        Vector dataRow = DMIF.MF.HDC.queryRow("SELECT channel_name FROM device_channel WHERE device_id = '"+selectedID+"' AND channel = '"+selectedChannel+"';");
        if (dataRow != null && dataRow.size() >= 1)
        {
            selectedField.setText(data);
            Type5SensorDisplayPanel ETSCP = new Type5SensorDisplayPanel(this, selectedName, selectedID, selectedChannel);
            detailPanel.removeAll();
            detailPanel.add(ETSCP);
            currentPanel = ETSCP;
            currentPanelType = 2;
        }
        else
        {
            selectedField.setText("Not found...");
            detailPanel.removeAll();
            currentPanel = null;
            currentPanelType = 2;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox departmentComboBox;
    private javax.swing.JPanel detailPanel;
    public javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JSplitPane deviceListSplitPane;
    private javax.swing.JPanel deviceSelectPanel;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToggleButton listToggleButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshTreeButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel selectedField;
    private javax.swing.JLabel selectedLabel;
    private javax.swing.JPanel treePanel;
    private javax.swing.JScrollPane treeScroll;
    private javax.swing.JToggleButton treeToggleButton;
    private javax.swing.ButtonGroup viewButtonGroup;
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
        else if (src == refreshButton)
        {
            select();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setDeviceGroupComboBox();
        }
    }

    private String selected = "";
    private int selectedRow = 0;
    private TreePath[] paths;
    private TreePath selectedPath;
    public void valueChanged(TreeSelectionEvent e)
    {
        Object src = e.getSource();
        if (src == DMIF.DRC.deviceTree)
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

    public void setCurrentPanel(int i)
    {
        switch(i)
        {
            /*case 1:
                detailPanel.removeAll();
                detailPanel.add(DMIF.BDP);
                detailPanel.repaint();
                detailPanel.validate();
                break;
            case 2:
                detailPanel.removeAll();
                detailPanel.add(DMIF.RDP);
                detailPanel.repaint();
                detailPanel.validate();
                break;
            case 3:
                detailPanel.removeAll();
                detailPanel.add(DMIF.TDP);
                detailPanel.repaint();
                detailPanel.validate();
                break;
            case 4:
                detailPanel.removeAll();
                detailPanel.add(DMIF.PDP);
                detailPanel.repaint();
                detailPanel.validate();
                break;*/
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e)
    {
        Object src = e.getSource();
        resetTree();
    }

}
