/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PermissionPanel.java
 *
 * Created on Jun 1, 2012, 6:43:02 PM
 */

package ETM.USER.PANEL;

import ETM.USER.DIALOG.PermissionModifyDialog;
import ETM.USER.UserManagementIF;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Hyde
 */
public class PermissionPanel extends javax.swing.JPanel implements ActionListener
{
    public UserManagementIF UMIF;

    public ImageIcon yes = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    public ImageIcon no = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    public ImageIcon na = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"));

    private static String defaultComboBox = "Select a profile...";

    public PermissionPanel(UserManagementIF UMIF)
    {
        this.UMIF = UMIF;
        
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setComboBox();
    }

    private void actionComponents()
    {
        newButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        permissionComboBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        permissionComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        manageUser = new javax.swing.JLabel();
        manageDevice = new javax.swing.JLabel();
        manageHost = new javax.swing.JLabel();
        viewLog = new javax.swing.JLabel();
        viewFloorplan = new javax.swing.JLabel();
        dataPresentation = new javax.swing.JLabel();
        crossDepartment = new javax.swing.JLabel();
        manageMessage = new javax.swing.JLabel();
        manageDepartment = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jToolBar5 = new javax.swing.JToolBar();
        editButton = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        jToolBar6 = new javax.swing.JToolBar();
        deleteButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jToolBar7 = new javax.swing.JToolBar();
        assignButton = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Permission Profile");

        jLabel2.setText("Profile Name : ");

        permissionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a profile..." }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("State"));

        manageUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageUser.setText("Manage User : Other account modification, permission control.");

        manageDevice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageDevice.setText("Manage Device : Add/Modify/Remove Device");

        manageHost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageHost.setText("Manage Host / Location / Floorplan");

        viewLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        viewLog.setText("View Log");

        viewFloorplan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        viewFloorplan.setText("View Floorplan");

        dataPresentation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        dataPresentation.setText("Data presentation : Data Graph, Data Table, Alarm Statistics");

        crossDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        crossDepartment.setText("See other department");

        manageMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageMessage.setText("Manage SMS / Email notification message");

        manageDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N
        manageDepartment.setText("Manage Department");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageUser)
                    .addComponent(manageDevice)
                    .addComponent(manageHost)
                    .addComponent(viewLog)
                    .addComponent(viewFloorplan)
                    .addComponent(dataPresentation)
                    .addComponent(crossDepartment)
                    .addComponent(manageMessage)
                    .addComponent(manageDepartment))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(manageUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageDepartment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageDevice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageHost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewFloorplan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataPresentation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crossDepartment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Member who use this profile...");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        userList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(userList);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(permissionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(permissionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel5);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 2147483647));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 300));
        modifyButtonGroup.setPreferredSize(new java.awt.Dimension(32, 300));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel4.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel4.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel4.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel4);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator4);

        jToolBar5.setFloatable(false);
        jToolBar5.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar5.setMinimumSize(new java.awt.Dimension(32, 40));
        jToolBar5.setPreferredSize(new java.awt.Dimension(32, 40));

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        editButton.setToolTipText("Modify Profile");
        editButton.setEnabled(false);
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setMaximumSize(new java.awt.Dimension(32, 40));
        editButton.setMinimumSize(new java.awt.Dimension(32, 40));
        editButton.setPreferredSize(new java.awt.Dimension(32, 40));
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(editButton);

        modifyButtonGroup.add(jToolBar5);

        jToolBar4.setFloatable(false);
        jToolBar4.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar4.setMinimumSize(new java.awt.Dimension(32, 40));
        jToolBar4.setPreferredSize(new java.awt.Dimension(32, 40));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_new_32.png"))); // NOI18N
        newButton.setToolTipText("Add New Profile");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setMaximumSize(new java.awt.Dimension(32, 40));
        newButton.setMinimumSize(new java.awt.Dimension(32, 40));
        newButton.setPreferredSize(new java.awt.Dimension(32, 40));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(newButton);

        modifyButtonGroup.add(jToolBar4);

        jToolBar6.setFloatable(false);
        jToolBar6.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar6.setMinimumSize(new java.awt.Dimension(32, 40));
        jToolBar6.setPreferredSize(new java.awt.Dimension(32, 40));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_delete_32.png"))); // NOI18N
        deleteButton.setToolTipText("Delete Profile");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(32, 40));
        deleteButton.setMinimumSize(new java.awt.Dimension(32, 40));
        deleteButton.setPreferredSize(new java.awt.Dimension(32, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(deleteButton);

        modifyButtonGroup.add(jToolBar6);
        modifyButtonGroup.add(jSeparator2);

        jToolBar7.setFloatable(false);
        jToolBar7.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar7.setMinimumSize(new java.awt.Dimension(32, 40));
        jToolBar7.setPreferredSize(new java.awt.Dimension(32, 40));

        assignButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/user_apply_32.png"))); // NOI18N
        assignButton.setToolTipText("Apply this profile to user(s)");
        assignButton.setFocusable(false);
        assignButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        assignButton.setMaximumSize(new java.awt.Dimension(32, 40));
        assignButton.setMinimumSize(new java.awt.Dimension(32, 40));
        assignButton.setPreferredSize(new java.awt.Dimension(32, 40));
        assignButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(assignButton);

        modifyButtonGroup.add(jToolBar7);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup);
    }// </editor-fold>//GEN-END:initComponents

    public void setInfo(String pmid)
    {
        if (pmid.equals(defaultComboBox))
        {
            manageUser.setIcon(na);
            manageDevice.setIcon(na);
            manageHost.setIcon(na);
            viewLog.setIcon(na);
            viewFloorplan.setIcon(na);
            dataPresentation.setIcon(na);
            crossDepartment.setIcon(na);
            manageMessage.setIcon(na);
            manageDepartment.setIcon(na);

            editButton.setEnabled(false);
            deleteButton.setEnabled(false);
            return;
        }
        
        Vector permissionInfo = UMIF.MF.HDC.queryRow("SELECT "
                + "MANAGE_USER, MANAGE_DEVICE, MANAGE_HOST, VIEW_LOG, VIEW_FLOORPLAN, "
                + "DATA_PRESENTATION, CROSS_DEPARTMENT, MANAGE_MESSAGE, MANAGE_DEPARTMENT "
                + "FROM permission WHERE permission_id = '"+HydeFormat.parseID(pmid)+"';");
        
        if (permissionInfo != null)
        {
            manageUser.setIcon(permissionInfo.elementAt(0).equals("1") ? yes : no);
            manageDevice.setIcon(permissionInfo.elementAt(1).equals("1") ? yes : no);
            manageHost.setIcon(permissionInfo.elementAt(2).equals("1") ? yes : no);
            viewLog.setIcon(permissionInfo.elementAt(3).equals("1") ? yes : no);
            viewFloorplan.setIcon(permissionInfo.elementAt(4).equals("1") ? yes : no);
            dataPresentation.setIcon(permissionInfo.elementAt(5).equals("1") ? yes : no);
            crossDepartment.setIcon(permissionInfo.elementAt(6).equals("1") ? yes : no);
            manageMessage.setIcon(permissionInfo.elementAt(7).equals("1") ? yes : no);
            manageDepartment.setIcon(permissionInfo.elementAt(8).equals("1") ? yes : no);
        }

        Vector user = UMIF.MF.HDC.queryColumn("SELECT user_username FROM user WHERE permission_id = '"+HydeFormat.parseID(pmid)+"';");
        if (user != null)
        {
            Object[] obj = user.toArray();
            userList.setListData(obj);
            userList.setSelectedIndex(0);
            userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }

        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }
    
    public void setComboBox()
    {
        Enumeration enu;
        enu = UMIF.MF.HDC.queryColumn("SELECT CONCAT(permission_name,' (',permission_id,')') FROM permission;").elements();
        permissionComboBox.removeAllItems();
        permissionComboBox.addItem(defaultComboBox);
        while (enu.hasMoreElements())
        {
            permissionComboBox.addItem(enu.nextElement());
        }
    }

    private void deletePermissionProfile()
    {
        String apf = (String) permissionComboBox.getSelectedItem();
        if (apf != null && !apf.equals(defaultComboBox))
        {
            UMIF.MF.HDC.customUpdate("DELETE FROM permission WHERE permission_id = '"+HydeFormat.parseID(apf)+"';");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignButton;
    private javax.swing.JPanel buttonGroup;
    public javax.swing.JLabel crossDepartment;
    public javax.swing.JLabel dataPresentation;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    public javax.swing.JLabel manageDepartment;
    public javax.swing.JLabel manageDevice;
    public javax.swing.JLabel manageHost;
    public javax.swing.JLabel manageMessage;
    public javax.swing.JLabel manageUser;
    private javax.swing.JPanel modifyButtonGroup;
    private javax.swing.JButton newButton;
    public javax.swing.JComboBox permissionComboBox;
    private javax.swing.JList userList;
    public javax.swing.JLabel viewFloorplan;
    public javax.swing.JLabel viewLog;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == newButton)
        {
            PermissionModifyDialog PMD = new PermissionModifyDialog(this, PermissionModifyDialog.PERMISSION_PANEL_NEW);
        }
        else if(src == editButton)
        {
            PermissionModifyDialog PMD = new PermissionModifyDialog(this, PermissionModifyDialog.PERMISSION_PANEL_EDIT);
        }
        else if(src == deleteButton)
        {
             int inp = JOptionPane.showConfirmDialog(this, "You want to delete this profile ?", "Are you sure ?", JOptionPane.YES_NO_OPTION);
             if (inp == 1)
             {
                 deletePermissionProfile();
             }
        }
        else if(src == permissionComboBox && permissionComboBox.getSelectedItem() != null)
        {
            setInfo((String) permissionComboBox.getSelectedItem());
        }
    }

}
