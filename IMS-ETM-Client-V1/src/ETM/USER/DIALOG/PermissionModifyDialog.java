/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PermissionModifyDialog.java
 *
 * Created on Jun 8, 2012, 4:41:05 PM
 */

package ETM.USER.DIALOG;

import ETM.USER.PANEL.PermissionPanel;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PermissionModifyDialog extends javax.swing.JDialog implements ActionListener
{
    public static int PERMISSION_PANEL_NEW = 0;
    public static int PERMISSION_PANEL_EDIT = 1;

    public PermissionPanel PP;
    public int panelType;
    
    public PermissionModifyDialog(PermissionPanel PP, int panelType)
    {
        this.PP = PP;
        this.panelType = panelType;
        
        initComponents();
        extendComponents();
        actionComponents();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        switch (panelType)
        {
            case 0: // PERMISSION_PANEL_NEW
                break;
            case 1: // PERMISSION_PANEL_EDIT
                setInfo();
                idField.setEnabled(false);
                aiButton.setEnabled(false);
                break;
        }
    }

    private void actionComponents()
    {
        applyButton.addActionListener(this);
        aiButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        manageUser = new javax.swing.JCheckBox();
        manageDevice = new javax.swing.JCheckBox();
        manageHost = new javax.swing.JCheckBox();
        viewLog = new javax.swing.JCheckBox();
        viewFloorplan = new javax.swing.JCheckBox();
        dataPresentation = new javax.swing.JCheckBox();
        crossDepartment = new javax.swing.JCheckBox();
        manageMessage = new javax.swing.JCheckBox();
        manageDepartment = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        profileField = new javax.swing.JTextField();
        applyButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jToolBar1 = new javax.swing.JToolBar();
        aiButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Permission Profile");
        setAlwaysOnTop(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("State"));

        manageUser.setText("Manage User : Other account modification, permission control.");

        manageDevice.setText("Manage Device : Add/Modify/Remove Device");

        manageHost.setText("Manage Host / Location");

        viewLog.setText("View Log");

        viewFloorplan.setText("View Floorplan");

        dataPresentation.setText("Data presentation : Data Graph, Data Table, Alarm Statistics");

        crossDepartment.setText("See other department");

        manageMessage.setText("Manage SMS / Email notification message");

        manageDepartment.setText("Manage Department");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageDevice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageHost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewFloorplan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dataPresentation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(crossDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageDepartment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageDevice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageHost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewFloorplan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataPresentation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(crossDepartment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Permission Profile");

        jLabel2.setText("Profile Name");

        applyButton.setText("Apply Change");

        jLabel3.setText("Profile ID");

        jToolBar1.setFloatable(false);

        aiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/auto_16.png"))); // NOI18N
        aiButton.setToolTipText("Auto ID");
        aiButton.setFocusable(false);
        aiButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aiButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(aiButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(applyButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(52, 52, 52)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar1, 0, 0, Short.MAX_VALUE)
                    .addComponent(idField)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setInfo()
    {
        String permission = (String) PP.permissionComboBox.getSelectedItem();
        idField.setText(HydeFormat.parseID(permission));
        profileField.setText(HydeFormat.parseName(permission));

        manageUser.setSelected(PP.manageUser.getIcon().equals(PP.yes) ? true : false);
        manageDevice.setSelected(PP.manageDevice.getIcon().equals(PP.yes) ? true : false);
        manageHost.setSelected(PP.manageHost.getIcon().equals(PP.yes) ? true : false);
        manageMessage.setSelected(PP.manageMessage.getIcon().equals(PP.yes) ? true : false);
        viewLog.setSelected(PP.viewLog.getIcon().equals(PP.yes) ? true : false);
        viewFloorplan.setSelected(PP.viewFloorplan.getIcon().equals(PP.yes) ? true : false);
        dataPresentation.setSelected(PP.dataPresentation.getIcon().equals(PP.yes) ? true : false);
        crossDepartment.setSelected(PP.crossDepartment.getIcon().equals(PP.yes) ? true : false);
        manageDepartment.setSelected(PP.manageDepartment.getIcon().equals(PP.yes) ? true : false);
    }

    private void newPermission()
    {
        if (idField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please insert ID...", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (profileField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please insert profile name...", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success = PP.UMIF.MF.HDC.customUpdate("INSERT INTO permission SET "
                + "permission_id = '"+idField.getText()+"', "
                + "permission_name = '"+profileField.getText()+"', "
                + "manage_user = '"+(manageUser.isSelected() ? 1 : 0)+"', "
                + "manage_device = '"+(manageDevice.isSelected() ? 1 : 0)+"', "
                + "manage_host = '"+(manageHost.isSelected() ? 1 : 0)+"', "
                + "manage_message = '"+(manageMessage.isSelected() ? 1 : 0)+"', "
                + "view_log = '"+(viewLog.isSelected() ? 1 : 0)+"', "
                + "view_floorplan = '"+(viewFloorplan.isSelected() ? 1 : 0)+"', "
                + "data_presentation = '"+(dataPresentation.isSelected() ? 1 : 0)+"', "
                + "cross_department = '"+(crossDepartment.isSelected() ? 1 : 0)+"', "
                + "manage_department = '"+(manageDepartment.isSelected() ? 1 : 0)+"' "
                + ";");
        if (success)
        {
            PP.setComboBox();
            PP.permissionComboBox.setSelectedItem(profileField.getText()+" ("+idField.getText()+")");
            JOptionPane.showMessageDialog(this, "Profile has been inserted...");
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot insert new profile...", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updatePermission()
    {
        if (profileField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please insert profile name...", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        boolean success = PP.UMIF.MF.HDC.customUpdate("UPDATE permission SET "
                + "permission_name = '"+profileField.getText()+"', "
                + "manage_user = '"+(manageUser.isSelected() ? 1 : 0)+"', "
                + "manage_device = '"+(manageDevice.isSelected() ? 1 : 0)+"', "
                + "manage_host = '"+(manageHost.isSelected() ? 1 : 0)+"', "
                + "manage_message = '"+(manageMessage.isSelected() ? 1 : 0)+"', "
                + "view_log = '"+(viewLog.isSelected() ? 1 : 0)+"', "
                + "view_floorplan = '"+(viewFloorplan.isSelected() ? 1 : 0)+"', "
                + "data_presentation = '"+(dataPresentation.isSelected() ? 1 : 0)+"', "
                + "cross_department = '"+(crossDepartment.isSelected() ? 1 : 0)+"', "
                + "manage_department = '"+(manageDepartment.isSelected() ? 1 : 0)+"' "
                + "WHERE permission_id = '"+idField.getText()+"' "
                + ";");
        if (success)
        {
            PP.setComboBox();
            PP.permissionComboBox.setSelectedItem(profileField.getText()+" ("+idField.getText()+")");
            JOptionPane.showMessageDialog(this, "Profile has been updated...");
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot update profile...", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void setNextID()
    {
        idField.setText(PP.UMIF.MF.HDC.getNextIncrement("permission"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JCheckBox crossDepartment;
    private javax.swing.JCheckBox dataPresentation;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JCheckBox manageDepartment;
    private javax.swing.JCheckBox manageDevice;
    private javax.swing.JCheckBox manageHost;
    private javax.swing.JCheckBox manageMessage;
    private javax.swing.JCheckBox manageUser;
    private javax.swing.JTextField profileField;
    private javax.swing.JCheckBox viewFloorplan;
    private javax.swing.JCheckBox viewLog;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == applyButton)
        {
            switch (panelType)
            {
                case 0: // PERMISSION_PANEL_NEW
                    newPermission();
                    break;
                case 1: // PERMISSION_PANEL_EDIT
                    updatePermission();
                    break;
            }
        }
        else if (src == aiButton)
        {
            setNextID();
        }
    }

}
