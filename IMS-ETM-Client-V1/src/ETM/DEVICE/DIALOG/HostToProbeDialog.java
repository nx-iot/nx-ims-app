package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.HostPanel;
import ETM.MAIN.MainFrame;
import ETM.Util.HydeDatabaseConnector;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class HostToProbeDialog extends javax.swing.JDialog implements ActionListener, MouseListener
{
    private HostPanel HP;
    private String wid;

    private MainFrame MF;
    private HydeDatabaseConnector HDC;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultDeviceGroupComboBox = "Select a group...";

    public int configSet;
    public String configCMD;

    public HostToProbeDialog(HostPanel HP)
    {
        this.HP = HP;
        this.HDC = HP.DMIF.MF.HDC;
        this.MF = HP.DMIF.MF;
        initComponents();
        extendComponents();
        actionComponents();

        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        wid = (String) HP.nameField.getText() + " ("+HP.idField.getText()+")";
        profileField.setText(wid);
        wid = HydeFormat.parseID(wid);
        setDepartmentComboBox();
        setList();
    }

    private void actionComponents()
    {
        selectAllButton.addActionListener(this);
        selectAllChannelButton.addActionListener(this);
        applyButton.addActionListener(this);
        cancelButton.addActionListener(this);
        transmitterList.addMouseListener(this);
        channelList.addMouseListener(this);
        departmentComboBox.addActionListener(this);
        deviceGroupComboBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        profileField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        deviceListScroll = new javax.swing.JScrollPane();
        transmitterList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        groupLabel = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        selectAllButton = new javax.swing.JButton();
        departmentLabel1 = new javax.swing.JLabel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        deviceListScroll1 = new javax.swing.JScrollPane();
        channelList = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        groupLabel1 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        selectAllChannelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Host->Probe");

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText("Save");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.setText("Cancel");

        jLabel1.setText("Config profile : ");

        departmentLabel.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        deviceListScroll.setViewportView(transmitterList);

        jPanel1.add(deviceListScroll, java.awt.BorderLayout.CENTER);

        groupLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupLabel.setText("Transmitter List");
        groupLabel.setMaximumSize(new java.awt.Dimension(100, 20));
        groupLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        groupLabel.setPreferredSize(new java.awt.Dimension(100, 20));

        jToolBar2.setFloatable(false);

        selectAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/all_16.png"))); // NOI18N
        selectAllButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar2.add(selectAllButton);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, 0, 0, Short.MAX_VALUE)
            .addComponent(groupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        departmentLabel1.setText("Device Group");

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.BorderLayout());

        deviceListScroll1.setViewportView(channelList);

        jPanel3.add(deviceListScroll1, java.awt.BorderLayout.CENTER);

        groupLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupLabel1.setText("Probe List");
        groupLabel1.setMaximumSize(new java.awt.Dimension(100, 20));
        groupLabel1.setMinimumSize(new java.awt.Dimension(100, 20));
        groupLabel1.setPreferredSize(new java.awt.Dimension(100, 20));

        jToolBar3.setFloatable(false);

        selectAllChannelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/all_16.png"))); // NOI18N
        selectAllChannelButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar3.add(selectAllChannelButton);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, 0, 0, Short.MAX_VALUE)
            .addComponent(groupLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(departmentLabel1)
                                    .addComponent(departmentLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deviceGroupComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel1)
                    .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(applyButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDepartmentComboBox()
    {
        Enumeration enu;
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);

        if (HP.DMIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem("All");
            enu = HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+MF.SD.loginDepartment+"';"));
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
                enu = HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group;").elements();
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
                enu = HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group WHERE depart_id = '"+HydeFormat.parseID(department)+"';").elements();
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

    private void setList()
    {
        String depart = (String) departmentComboBox.getSelectedItem();
        String group = (String) deviceGroupComboBox.getSelectedItem();

        if (depart.equals("All"))
        {
            if (group.equals("All"))
            {
                Vector v = HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE equipment_id = 5;");
                if (v != null)
                {
                    Object[] obj = v.toArray();
                    transmitterList.setListData(obj);
                    transmitterList.setSelectedIndex(0);
                    transmitterList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                }
            }
            else if(group.equals("No group..."))
            {
                Vector v = HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE equipment_id = 5 AND device_group_id IS NULL;");
                if (v != null)
                {
                    Object[] obj = v.toArray();
                    transmitterList.setListData(obj);
                    transmitterList.setSelectedIndex(0);
                    transmitterList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                }
            }
            else if(!group.equals(defaultDeviceGroupComboBox))
            {
                String gid = HydeFormat.parseID(group);
                Vector v = HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE equipment_id = 5 AND device_group_id = "+gid+";");
                if (v != null)
                {
                    Object[] obj = v.toArray();
                    transmitterList.setListData(obj);
                    transmitterList.setSelectedIndex(0);
                    transmitterList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                }
            }
            else
            {
                Object[] obj = new Object[0];
                transmitterList.setListData(obj);
            }
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            String departID = HydeFormat.parseID(depart);
            if (group.equals("All"))
            {
                Vector v = HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device NATURAL JOIN device_group WHERE equipment_id = 5 AND  depart_id = '"+departID+"';");
                if (v != null)
                {
                    Object[] obj = v.toArray();
                    transmitterList.setListData(obj);
                    transmitterList.setSelectedIndex(0);
                    transmitterList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                }
            }
            else if(!group.equals(defaultDeviceGroupComboBox))
            {
                String gid = HydeFormat.parseID(group);
                Vector v = HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE equipment_id = 5 AND  device_group_id = "+gid+";");
                if (v != null)
                {
                    Object[] obj = v.toArray();
                    transmitterList.setListData(obj);
                    transmitterList.setSelectedIndex(0);
                    transmitterList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                }
            }
            else
            {
                Object[] obj = new Object[0];
                transmitterList.setListData(obj);
            }

        }
    }

    private void setchannelList()
    {
        Object[] obj = transmitterList.getSelectedValues();
        String deviceIDs = "";
        for(int i=0;i<obj.length;i++)
        {
            String id = (String) obj[i];
            id = HydeFormat.parseID(id);
            deviceIDs += "OR device_id = '"+id+"' ";
        }
        Vector v = HDC.queryColumn("SELECT CONCAT(channel_name,' (',channel+0 , ':',device_id+0,')') FROM device_channel NATURAL JOIN device WHERE false "+deviceIDs+";");
        if (v != null)
        {
            channelList.setListData(v.toArray());
            channelList.setSelectedIndex(0);
            channelList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        }
    }

    private void apply()
    {
        String userIDs = " WHERE false ";
        Object[] obj = channelList.getSelectedValues();
        for(int i=0;i<obj.length;i++)
        {
            String id = (String) obj[i];
            id = HydeFormat.parseID(id);
            String channel = id.charAt(0)+"";
            String deviceID = id.substring(2,id.length());
            userIDs += "OR (device_id = '"+deviceID+"' AND channel = '"+channel+"') ";
        }
        System.out.println("UPDATE device_channel SET host_id = "+wid+userIDs+";");
        boolean b1 = HDC.customUpdate("UPDATE device_channel SET host_id = "+wid+userIDs+";");
                
        if (b1)
        {
            JOptionPane.showMessageDialog(this, "Host has been set to selected channel(s).", "Host Management",JOptionPane.INFORMATION_MESSAGE);
            //configPending(obj);
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot set host to selected channel(s) !", "Host Management",JOptionPane.ERROR_MESSAGE);
        }
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JList channelList;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel departmentLabel1;
    private javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JScrollPane deviceListScroll;
    private javax.swing.JScrollPane deviceListScroll1;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel groupLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel profileField;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JButton selectAllChannelButton;
    private javax.swing.JList transmitterList;
    // End of variables declaration//GEN-END:variables


    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == selectAllChannelButton)
        {
            channelList.setSelectionInterval(0, channelList.getModel().getSize() -1);
            selected = channelList.getSelectedValues();
        }
        else if (src == selectAllButton)
        {
            transmitterList.setSelectionInterval(0, transmitterList.getModel().getSize() -1);
            setchannelList();
        }
        else if (src == applyButton)
        {
            apply();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setDeviceGroupComboBox();
            setList();
        }
        else if (src == deviceGroupComboBox && deviceGroupComboBox.getSelectedItem() != null)
        {
            setList();
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }

    Object selected[];
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        if (src == transmitterList)
        {
            setchannelList();
        }
        else if(src == channelList)
        {
            selected = channelList.getSelectedValues();
        }
    }
}
