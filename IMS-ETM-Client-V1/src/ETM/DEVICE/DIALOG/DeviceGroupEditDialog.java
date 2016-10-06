package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.DeviceGroupPanel;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class DeviceGroupEditDialog extends javax.swing.JDialog implements ActionListener, MouseListener
{
    private DeviceGroupPanel DGP;

    private Vector ungroupedVector;
    private Vector groupedVector;

    private static String defaultComboBox = "Select a department...";


    public DeviceGroupEditDialog(DeviceGroupPanel DGP, boolean edit)
    {
        this.DGP = DGP;
        initComponents();
        extendComponents();
        if (edit)
        {
            initData();
        }
        actionComponents();

        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initData()
    {
        aiButton.setEnabled(false);
        groupIDField.setEnabled(false);

        String gid = (String) DGP.deviceGroupComboBox.getSelectedItem();
        groupLabel.setText("Device(s) in "+gid);
        groupNameField.setText(HydeFormat.parseName(gid));
        gid = HydeFormat.parseID(gid);
        groupIDField.setText(gid);

        departmentComboBox.setSelectedItem(DGP.departmentField.getText());

        setGroupList();
        setListVector();
    }

    private void extendComponents()
    {
        setUngroupList();
        setListVector();
        setComboBox();
    }

    private void actionComponents()
    {
        leftButton.addActionListener(this);
        left2Button.addActionListener(this);
        rightButton.addActionListener(this);
        right2Button.addActionListener(this);

        groupedList.addMouseListener(this);
        ungroupedList.addMouseListener(this);

        undoButton.addActionListener(this);
        aiButton.addActionListener(this);
        applyButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        aiButton = new javax.swing.JButton();
        undoButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        groupIDField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        groupPanel = new javax.swing.JPanel();
        groupLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupedList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        right2ButtonToolBar = new javax.swing.JToolBar();
        right2Button = new javax.swing.JButton();
        rightButtonToolBar = new javax.swing.JToolBar();
        rightButton = new javax.swing.JButton();
        left2ButtonToolBar = new javax.swing.JToolBar();
        left2Button = new javax.swing.JButton();
        leftButtonToolBar = new javax.swing.JToolBar();
        leftButton = new javax.swing.JButton();
        ungroupPanel = new javax.swing.JPanel();
        ungroupLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ungroupedList = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        groupNameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        departmentComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Device Group ID ");

        aiButton.setText("Auto");

        undoButton.setText("Reset");

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText("Save");

        groupPanel.setLayout(new javax.swing.BoxLayout(groupPanel, javax.swing.BoxLayout.PAGE_AXIS));

        groupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        groupLabel.setText("In group device(s)");
        groupLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        groupLabel.setMaximumSize(new java.awt.Dimension(3000, 20));
        groupLabel.setMinimumSize(new java.awt.Dimension(3000, 20));
        groupLabel.setPreferredSize(new java.awt.Dimension(3000, 20));
        groupPanel.add(groupLabel);

        jScrollPane1.setViewportView(groupedList);

        groupPanel.add(jScrollPane1);

        jLabel2.setText(" ");
        groupPanel.add(jLabel2);

        right2ButtonToolBar.setBorder(null);
        right2ButtonToolBar.setFloatable(false);

        right2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/right_green_2arrow_24.png"))); // NOI18N
        right2Button.setToolTipText("Remove All");
        right2ButtonToolBar.add(right2Button);

        rightButtonToolBar.setBorder(null);
        rightButtonToolBar.setFloatable(false);

        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/right_green_arrow_24.png"))); // NOI18N
        rightButton.setToolTipText("Remove Selected");
        rightButtonToolBar.add(rightButton);

        left2ButtonToolBar.setBorder(null);
        left2ButtonToolBar.setFloatable(false);

        left2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/left_green_2arrow_24.png"))); // NOI18N
        left2Button.setToolTipText("Add All");
        left2ButtonToolBar.add(left2Button);

        leftButtonToolBar.setBorder(null);
        leftButtonToolBar.setFloatable(false);

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/left_green_arrow_24.png"))); // NOI18N
        leftButton.setToolTipText("Add Selected");
        leftButtonToolBar.add(leftButton);

        ungroupPanel.setLayout(new javax.swing.BoxLayout(ungroupPanel, javax.swing.BoxLayout.PAGE_AXIS));

        ungroupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ungroupLabel.setText("No group device(s)");
        ungroupLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ungroupLabel.setMaximumSize(new java.awt.Dimension(3000, 20));
        ungroupLabel.setMinimumSize(new java.awt.Dimension(3000, 20));
        ungroupLabel.setPreferredSize(new java.awt.Dimension(3000, 20));
        ungroupPanel.add(ungroupLabel);

        jScrollPane2.setViewportView(ungroupedList);

        ungroupPanel.add(jScrollPane2);

        jLabel4.setText(" ");
        ungroupPanel.add(jLabel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButtonToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(right2ButtonToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(left2ButtonToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButtonToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(ungroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ungroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(groupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(right2ButtonToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightButtonToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(leftButtonToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(left2ButtonToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel6.setText("Device Group Name");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.setText("Cancel");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jLabel8.setText("Department");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupNameField)
                            .addComponent(groupIDField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aiButton)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(208, 208, 208))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(undoButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(applyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(groupIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aiButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(groupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(undoButton)
                    .addComponent(cancelButton)
                    .addComponent(applyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setNextID()
    {
        groupIDField.setText(DGP.DIF.MF.HDC.getNextIncrement("device_group"));
    }

    public void setComboBox()
    {
        departmentComboBox.removeAllItems();
        if (DGP.DIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem(defaultComboBox);
            Enumeration enu = DGP.DIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(DGP.DIF.MF.HDC.query0("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') "
                    + "FROM department WHERE depart_id = '"+DGP.DIF.MF.SD.loginDepartment+"';"));
        }
    }
    
    private void setListVector()
    {
        ListModel LM = ungroupedList.getModel();
        ungroupedVector = new Vector();
        for (int i=0; i<LM.getSize();i++)
        {
            ungroupedVector.add(LM.getElementAt(i));
        }

        ListModel LM2 = groupedList.getModel();
        groupedVector = new Vector();
        for (int i=0; i<LM2.getSize();i++)
        {
            groupedVector.add(LM2.getElementAt(i));
        }
    }

    private void setGroupList()
    {
        Vector v = DGP.DIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE device_group_id = '"+groupIDField.getText()+"';");
        Object[] str = v.toArray();
        groupedList.setListData(str);
        groupedList.setSelectedIndex(0);
        groupedList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void setUngroupList()
    {
        Vector v = DGP.DIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (',device_id+0, ')') FROM device WHERE (device_group_id IS NULL OR device_group_id = '');");
        Object[] str2 = v.toArray();
        ungroupedList.setListData(str2);
        ungroupedList.setSelectedIndex(0);
        ungroupedList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private void apply()
    {
        String did = (String) departmentComboBox.getSelectedItem();
        if (did != null && !did.equals(defaultComboBox))
        {
            did = "'"+HydeFormat.parseID(did)+"'";
        }
        else
        {
            did = "null";
        }
        if ( DGP.DIF.MF.HDC.query0("SELECT device_group_id FROM device_group WHERE device_group_id = '"+groupIDField.getText()+"';") != null)
        {
            String deviceIDs = " WHERE false ";
            for(int i=0;i<groupedVector.size();i++)
            {
                String id = (String) groupedVector.elementAt(i);
                id = HydeFormat.parseID(id);
                deviceIDs += "OR device_id = '"+id+"' ";
            }
            boolean b1 = DGP.DIF.MF.HDC.customUpdate("UPDATE device SET device_group_id = "+groupIDField.getText()+deviceIDs+";");

            deviceIDs = " WHERE false ";
            for(int i=0;i<ungroupedVector.size();i++)
            {
                String id = (String) ungroupedVector.elementAt(i);
                id = HydeFormat.parseID(id);
                deviceIDs += "OR device_id = '"+id+"' ";
            }
            boolean b2 = DGP.DIF.MF.HDC.customUpdate("UPDATE device SET device_group_id = NULL "+deviceIDs+";");
            if (b1 && b2)
            {
                DGP.DIF.MF.HDC.customUpdate("UPDATE device_group SET "
                        + "device_group_name = '"+groupNameField.getText()+"', "
                        + "depart_id = "+did+" WHERE device_group_id = '"+groupIDField.getText()+"';");
                DGP.setComboBox();
                DGP.deviceGroupComboBox.setSelectedItem(groupNameField.getText()+" ("+groupIDField.getText()+")");
                DGP.setList();
                JOptionPane.showMessageDialog(this, "Device group has been updated.", "Device Management",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cannot update device group !", "Device Management",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            boolean b = DGP.DIF.MF.HDC.customUpdate("INSERT INTO device_group "
                    + "(device_group_id, device_group_name, depart_id) VALUES ("
                    + "'"+groupIDField.getText()+"', "
                    + "'"+groupNameField.getText()+"', "
                    + ""+did+" "
                    + ");");
            if (b)
            {
                String deviceIDs = " WHERE false ";
                for(int i=0;i<groupedVector.size();i++)
                {
                    String id = (String) groupedVector.elementAt(i);
                    id = HydeFormat.parseID(id);
                    deviceIDs += "OR device_id = '"+id+"' ";
                }
                boolean b1 = DGP.DIF.MF.HDC.customUpdate("UPDATE device SET device_group_id = "+groupIDField.getText()+deviceIDs+";");

                deviceIDs = " WHERE false ";
                for(int i=0;i<ungroupedVector.size();i++)
                {
                    String id = (String) ungroupedVector.elementAt(i);
                    id = HydeFormat.parseID(id);
                    deviceIDs += "OR device_id = '"+id+"' ";
                }
                boolean b2 = DGP.DIF.MF.HDC.customUpdate("UPDATE device SET device_group_id = NULL "+deviceIDs+";");
                if (b1 && b2)
                {
                    JOptionPane.showMessageDialog(this, "Device group has been created.", "Device Management",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Cannot create device group !", "Device Management",JOptionPane.ERROR_MESSAGE);
                }
                DGP.setComboBox();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cannot create device group !", "Device Management",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JTextField groupIDField;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JTextField groupNameField;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JList groupedList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton left2Button;
    private javax.swing.JToolBar left2ButtonToolBar;
    private javax.swing.JButton leftButton;
    private javax.swing.JToolBar leftButtonToolBar;
    private javax.swing.JButton right2Button;
    private javax.swing.JToolBar right2ButtonToolBar;
    private javax.swing.JButton rightButton;
    private javax.swing.JToolBar rightButtonToolBar;
    private javax.swing.JButton undoButton;
    private javax.swing.JLabel ungroupLabel;
    private javax.swing.JPanel ungroupPanel;
    private javax.swing.JList ungroupedList;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();

        if (src == aiButton)
        {
            setNextID();
        }
        else if (src == undoButton)
        {
            setGroupList();
            setUngroupList();
            setListVector();
        }
        else if (src == applyButton)
        {
            apply();
        }
        else if (src == cancelButton)
        {
            dispose();
        }
        else if (src == leftButton)
        {
            Object[] ungroupSelected = ungroupedList.getSelectedValues();
            if (ungroupSelected != null)
            {
                for (int i=0;i<ungroupSelected.length;i++)
                {
                    ungroupedVector.remove(ungroupSelected[i]);
                    groupedVector.add(ungroupSelected[i]);
                }

                ungroupedList.removeAll();
                ungroupedList.setListData(ungroupedVector.toArray());
                groupedList.removeAll();
                groupedList.setListData(groupedVector.toArray());
            }
        }
        else if (src == left2Button)
        {
            for (int i=0;i<ungroupedVector.size();i++)
            {
                groupedVector.add(ungroupedVector.elementAt(i));
            }
            ungroupedVector.removeAllElements();

            ungroupedList.removeAll();
            ungroupedList.setListData(ungroupedVector.toArray());
            groupedList.removeAll();
            groupedList.setListData(groupedVector.toArray());
        }
        else if (src == rightButton)
        {
            Object[] groupSelected = groupedList.getSelectedValues();
            if (groupSelected != null)
            {
                for (int i=0;i<groupSelected.length;i++)
                {   
                    ungroupedVector.add(groupSelected[i]);
                    groupedVector.remove(groupSelected[i]);
                }

                ungroupedList.removeAll();
                ungroupedList.setListData(ungroupedVector.toArray());
                groupedList.removeAll();
                groupedList.setListData(groupedVector.toArray());
            }
        }
        else if (src == right2Button)
        {
            for (int i=0;i<groupedVector.size();i++)
            {
                ungroupedVector.add(groupedVector.elementAt(i));
            }
            groupedVector.removeAllElements();

            ungroupedList.removeAll();
            ungroupedList.setListData(ungroupedVector.toArray());
            groupedList.removeAll();
            groupedList.setListData(groupedVector.toArray());
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        int clickCount = e.getClickCount();
        Object src = e.getSource();
        switch (clickCount)
        {
            case 2:
                if (src == groupedList)
                {
                    ungroupedVector.add(groupedList.getSelectedValue());
                    groupedVector.remove(groupedList.getSelectedValue());
                    ungroupedList.removeAll();
                    ungroupedList.setListData(ungroupedVector.toArray());
                    groupedList.removeAll();
                    groupedList.setListData(groupedVector.toArray());
                }
                else if (src == ungroupedList)
                {
                    groupedVector.add(ungroupedList.getSelectedValue());
                    ungroupedVector.remove(ungroupedList.getSelectedValue());
                    ungroupedList.removeAll();
                    ungroupedList.setListData(ungroupedVector.toArray());
                    groupedList.removeAll();
                    groupedList.setListData(groupedVector.toArray());
                }
                break;
        }
    }
}
