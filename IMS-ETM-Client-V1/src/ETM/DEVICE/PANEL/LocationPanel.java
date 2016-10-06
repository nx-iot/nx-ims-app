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

import ETM.DEVICE.DIALOG.LocationModifyDialog;
import ETM.DEVICE.DIALOG.LocationToDeviceDialog;
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

/**
 *
 * @author Hyde
 */
public class LocationPanel extends javax.swing.JPanel implements ActionListener, ListSelectionListener, MouseListener
{
    private static String defaultComboBox = "Select a department...";
    public DeviceManagementIF DMIF;


    public LocationPanel(DeviceManagementIF DMIF)
    {
        this.DMIF = DMIF;
        
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setDepartmentComboBox();
        setLocationList();
    }

    private void actionComponents()
    {
        departmentComboBox.addActionListener(this);
        
        modifyButton.addActionListener(this);
        newButton.addActionListener(this);
        deleteButton.addActionListener(this);
        toDeviceButton.addActionListener(this);
        
        locationList.addListSelectionListener(this);
        locationList.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        headerLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        departmentField = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
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
        jToolBar8 = new javax.swing.JToolBar();
        toDeviceButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Available Locations");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        locationList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(locationList);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setMinimumSize(new java.awt.Dimension(100, 20));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setText(" Depart. ");
        jPanel5.add(jLabel3);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));
        jPanel5.add(departmentComboBox);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        headerLabel.setText("Location Management");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        departmentField.setText("-");

        idLabel.setText("Location ID");

        nameLabel.setText("Location Name");

        departmentLabel.setText("Department");

        descriptionField.setBackground(new java.awt.Color(240, 240, 240));
        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        descriptionField.setBorder(null);
        jScrollPane2.setViewportView(descriptionField);

        idField.setText("-");

        nameField.setText("-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        picPanel.setMaximumSize(new java.awt.Dimension(362, 242));
        picPanel.setMinimumSize(new java.awt.Dimension(362, 242));
        picPanel.setPreferredSize(new java.awt.Dimension(362, 242));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picPanel.add(picLabel);

        jScrollPane3.setViewportView(picPanel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addComponent(headerLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, Short.MAX_VALUE))
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
        modifyButton.setToolTipText("Modify Location");
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
        newButton.setToolTipText("Add New Location");
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
        deleteButton.setToolTipText("Delete Location");
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

        jToolBar8.setFloatable(false);
        jToolBar8.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar8.setMinimumSize(new java.awt.Dimension(32, 40));

        toDeviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_access_32.png"))); // NOI18N
        toDeviceButton.setToolTipText("Apply to Device(s)");
        toDeviceButton.setFocusable(false);
        toDeviceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toDeviceButton.setMaximumSize(new java.awt.Dimension(32, 40));
        toDeviceButton.setMinimumSize(new java.awt.Dimension(32, 40));
        toDeviceButton.setPreferredSize(new java.awt.Dimension(32, 40));
        toDeviceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar8.add(toDeviceButton);

        modifyButtonGroup.add(jToolBar8);

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

    public void setLocationList()
    {
        String str = (String) departmentComboBox.getSelectedItem();
        if (str != null && !str.equals(defaultComboBox))
        {
            Vector v;
            if (str.equals("All"))
            {
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (',location_id+0, ')') FROM location;");
            }
            else
            {
                String gid = HydeFormat.parseID(str);
               v = DMIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (',location_id+0, ')') FROM location WHERE depart_id = "+gid+";");
            }
            Object[] obj = v.toArray();
            locationList.setListData(obj);
            locationList.setSelectedIndex(0);
            locationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            locationList.setListData(obj);
        }
        clearInfo();
    }

    public void setInfo(String location)
    {
        if (location != null)
        {
            HydeImage HI = new HydeImage();
            Vector v = DMIF.MF.HDC.queryRow("SELECT location_name, location_description, CONCAT(depart_name,' (',depart_id,')') "
                    + "FROM location NATURAL JOIN department "
                    + "WHERE location_id = '"+HydeFormat.parseID(location)+"';");
            if (v != null && v.size() >= 3)
            {
                idField.setText(HydeFormat.parseID(location));
                nameField.setText((String)v.elementAt(0));
                descriptionField.setText((String)v.elementAt(1));
                departmentField.setText((String)v.elementAt(2));
                HI.setImageFromUrl(DMIF.MF.SD.urlImgPath+"/image/location/"+idField.getText()+".jpg", picLabel, picPanel, 360, 240,HydeImage.NO_SCALED);
                
                modifyButton.setEnabled(true);
                deleteButton.setEnabled(true);
                toDeviceButton.setEnabled(true);
            }
            else
            {
                idField.setText("Not found...");
                nameField.setText("Not found...");
                descriptionField.setText("Not found...");
                departmentField.setText("Not found...");
                HI.setImage(picLabel, picPanel);
            }
        }
    }

    public void clearInfo()
    {
        HydeImage HI = new HydeImage();
        idField.setText("-");
        nameField.setText("-");
        descriptionField.setText("-");
        departmentField.setText("-");
        HI.setImage(picLabel, picPanel);

        modifyButton.setEnabled(false);
        deleteButton.setEnabled(false);
        toDeviceButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox departmentComboBox;
    public javax.swing.JLabel departmentField;
    private javax.swing.JLabel departmentLabel;
    public javax.swing.JTextArea descriptionField;
    private javax.swing.JLabel headerLabel;
    public javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JList locationList;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel modifyButtonGroup;
    public javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JButton toDeviceButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == modifyButton)
        {
            LocationModifyDialog HAD = new LocationModifyDialog(this, LocationModifyDialog.LOCATION_EDIT);
        }
        else if (src == newButton)
        {
            LocationModifyDialog HAD = new LocationModifyDialog(this, LocationModifyDialog.LOCATION_NEW);
        }
        else if (src == deleteButton)
        {
            int inp = JOptionPane.showConfirmDialog(this, "You want to delete this location ?", "Are you sure ?", JOptionPane.YES_NO_OPTION);
            if (inp == 0)
            {
                String str = (String) locationList.getSelectedValue();
                if (str != null)
                {
                    boolean success = DMIF.MF.HDC.customUpdate("DELETE FROM location WHERE location_id = '"+idField.getText()+"';");
                    if (success)
                    {
                        setLocationList();
                        JOptionPane.showMessageDialog(this, "location has been deleted...");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "location cannot be deleted...");
                    }
                }
            }
        }
        else if (src == toDeviceButton)
        {
            LocationToDeviceDialog LTDD = new LocationToDeviceDialog(this);
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setLocationList();
        }
    }

    private String selectedlocation = "";
    public void valueChanged(ListSelectionEvent e)
    {
        Object src = e.getSource();
        if (src == locationList)
        {
            //selectedlocation = (String) locationList.getSelectedValue();
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
        if (src == locationList)
        {
            setInfo((String) locationList.getSelectedValue());
        }
    }

}
