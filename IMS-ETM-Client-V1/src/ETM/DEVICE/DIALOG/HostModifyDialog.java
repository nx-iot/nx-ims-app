package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.HostPanel;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import HydeModule.SCP.HydeSCP;
import HydeModule.TCPFileTransfer.FileSender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;


public class HostModifyDialog extends javax.swing.JDialog implements ActionListener
{
    private HostPanel HP;

    private static int imageWidth = 360;
    private static int imageHeight = 240;

    public static int HOST_NEW = 0;
    public static int HOST_EDIT = 1;
    
    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultHostComboBox = "Select a host type...";

    private int mode;

    public HostModifyDialog(HostPanel HP, int mode)
    {
        this.HP = HP;
        this.mode = mode;
        initComponents();
        extendComponents();
        actionComponents();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        //setNextID();
        setComboBox();
        setTypeComboBox();
        checkComboBox();

        switch (mode)
        {
            case 0:
                break;
            case 1:
                initData();
                break;
        }
    }

    private void initData()
    {
        idField.setText(HP.idField.getText());
        nameField.setText(HP.nameField.getText());
        descriptionArea.setText(HP.descriptionField.getText());
        if (HP.typeField.getText().equals("-"))
        {
            typeComboBox.setSelectedItem(defaultHostComboBox);
        }
        else
        {
            typeComboBox.setSelectedItem(HP.typeField.getText());
        }
        if (HP.departmentField.getText().equals("-"))
        {
            departmentComboBox.setSelectedItem(defaultDepartmentComboBox);
        }
        else
        {
            departmentComboBox.setSelectedItem(HP.departmentField.getText());
        }

        //HI.selectedImagePath = HP.HI.root+"/image/host/"+HP.HI.imageName;
        //HI.setImage(HI.selectedImagePath, picLabel, picPanel, 360, 240);
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(HP.DMIF.MF.SD.urlImgPath+"/image/host/"+idField.getText()+".jpg", picLabel, picPanel, imageWidth, imageHeight,HydeImage.HEIGHT_PRIORITY);

        aiButton.setEnabled(false);
        idField.setEnabled(false);
    }

    private void actionComponents()
    {
        browseButton.addActionListener(this);
        applyButton.addActionListener(this);
        aiButton.addActionListener(this);
        newTypeButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteTypeButton.addActionListener(this);
        typeComboBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        browseButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        idField = new javax.swing.JTextField();
        deviceIDLabel1 = new javax.swing.JLabel();
        deviceIDLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        deviceIDLabel3 = new javax.swing.JLabel();
        deviceIDLabel2 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        deviceIDLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        editButton = new javax.swing.JButton();
        newTypeButton = new javax.swing.JButton();
        deleteTypeButton = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        aiButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        hostInformationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Host Info");
        setAlwaysOnTop(true);
        setResizable(false);

        picPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picPanel.setMaximumSize(new java.awt.Dimension(360, 240));
        picPanel.setMinimumSize(new java.awt.Dimension(360, 240));
        picPanel.setPreferredSize(new java.awt.Dimension(360, 240));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picPanel.add(picLabel);

        browseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/find_16.png"))); // NOI18N
        browseButton.setText(" Browse new image");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(browseButton)
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deviceIDLabel1.setText("Name");
        deviceIDLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel1.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel1.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel1.setOpaque(true);

        deviceIDLabel.setText("ID");
        deviceIDLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel.setOpaque(true);

        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        jScrollPane1.setViewportView(descriptionArea);

        deviceIDLabel3.setText("Department");
        deviceIDLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel3.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel3.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel3.setOpaque(true);

        deviceIDLabel2.setText("Type");
        deviceIDLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel2.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel2.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel2.setOpaque(true);

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host type..." }));

        deviceIDLabel4.setText("Description");
        deviceIDLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel4.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setOpaque(true);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);

        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/edit_16.png"))); // NOI18N
        editButton.setToolTipText("Edit Type");
        editButton.setFocusable(false);
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(editButton);

        newTypeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/new_16.png"))); // NOI18N
        newTypeButton.setToolTipText("Add New Type");
        newTypeButton.setFocusable(false);
        newTypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newTypeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(newTypeButton);

        deleteTypeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/delete_16.png"))); // NOI18N
        deleteTypeButton.setToolTipText("Delete Type");
        deleteTypeButton.setFocusable(false);
        deleteTypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteTypeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(deleteTypeButton);

        jToolBar2.setFloatable(false);

        aiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/auto_16.png"))); // NOI18N
        aiButton.setToolTipText("Auto ID");
        aiButton.setFocusable(false);
        aiButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aiButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(aiButton);

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText(" Save Host Info.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(applyButton)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(deviceIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(departmentComboBox, 0, 180, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(deviceIDLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deviceIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(deviceIDLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameField)
                                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deviceIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviceIDLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviceIDLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deviceIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyButton)
                .addContainerGap())
        );

        hostInformationLabel.setText("Host Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(hostInformationLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hostInformationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComboBox()
    {
        departmentComboBox.removeAllItems();
        if (HP.DMIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem(defaultDepartmentComboBox);
            Enumeration enu;
            Vector v = HP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') FROM department;");
            enu = v.elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(HP.DMIF.MF.HDC.query0("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') "
                    + "FROM department WHERE depart_id = '"+HP.DMIF.MF.SD.loginDepartment+"';"));
        }
    }

    private void setTypeComboBox()
    {
        typeComboBox.removeAllItems();
        typeComboBox.addItem(defaultHostComboBox);
        Enumeration enu;
        Vector v = HP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(host_type_name, ' (', host_type_id+0, ')') FROM host_type ORDER BY host_type_name ASC;");
        enu = v.elements();
        while (enu.hasMoreElements())
        {
            typeComboBox.addItem(enu.nextElement());
        }
    }

    private void setNextID()
    {
        idField.setText(HP.DMIF.MF.HDC.getNextIncrement("host"));
    }

    private void apply()
    {
        String depart = (String) departmentComboBox.getSelectedItem();
        if (depart == null || depart.equals(defaultDepartmentComboBox))
        {
            depart = "null";
        }
        else
        {
            depart = "'"+HydeFormat.parseID(depart)+"'";
        }
        String hType = (String) typeComboBox.getSelectedItem();
        if (hType == null || hType.equals(defaultHostComboBox))
        {
            hType = "null";
        }
        else
        {
            hType = "'"+HydeFormat.parseID(hType)+"'";
        }
        if ( HP.DMIF.MF.HDC.query0("SELECT host_id FROM host WHERE host_id = '"+idField.getText()+"';") != null)
        {
            boolean b = HP.DMIF.MF.HDC.customUpdate("UPDATE host SET "
                    + "host_name = '"+nameField.getText()+"', "
                    + "host_description = '"+descriptionArea.getText()+"', "
                    + "host_type_id = "+hType+", "
                    + "depart_id = "+depart+" "
                    + "WHERE host_id = '"+idField.getText()+"';");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/host");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/host/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    //HP.DMIF.MF.HI.resizeImageFileToFile(selectedImage, HP.DMIF.MF.mainPath+"temp.jpg", imageWidth, imageHeight);
                    if (HP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", HP.DMIF.MF.SD.serverPassword, HP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, HP.DMIF.MF.SD.serverImgPath+"/image/host/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        System.out.println(HP.DMIF.MF.SD.serverIP);
                        System.out.println(HP.DMIF.MF.SD.FILE_SERVER_PORT);
                        System.out.println(selectedImage);
                        System.out.println(HP.DMIF.MF.SD.serverImgPath+"/image/host/"+idField.getText()+".jpg");
                        FileSender.send(HP.DMIF.MF.SD.serverIP, HP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, HP.DMIF.MF.SD.serverImgPath+"/image/host/"+idField.getText()+".jpg");
                    }
                }
                HP.setHostList();
                HP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") has been saved.", "Host Management", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") cannot be save !!", "Host Management", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            boolean b = HP.DMIF.MF.HDC.customUpdate("INSERT INTO host (host_id, host_name, host_description, host_type_id, depart_id) VALUES ("
                    + "'"+idField.getText()+"', "
                    + "'"+nameField.getText()+"', "
                    + "'"+descriptionArea.getText()+"', "
                    + ""+hType+", "
                    + ""+depart+" "
                    + ");");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/host");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/host/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    if (HP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {  
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", HP.DMIF.MF.SD.serverPassword, HP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, HP.DMIF.MF.SD.serverImgPath+"/image/host/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        FileSender.send(HP.DMIF.MF.SD.serverIP, HP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, HP.DMIF.MF.SD.serverImgPath+"/image/host/"+idField.getText()+".jpg");
                    }
                }
                HP.setHostList();
                HP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") has been inserted.", "Host Management", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") cannot be insert !!", "Host Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void checkComboBox()
    {
        if (typeComboBox.getSelectedItem() != null && typeComboBox.getSelectedItem().equals(defaultHostComboBox))
        {
            editButton.setEnabled(false);
            deleteTypeButton.setEnabled(false);
        }
        else
        {
            editButton.setEnabled(true);
            deleteTypeButton.setEnabled(true);
        }
    }

    private boolean checkInput()
    {
        if (idField.getText().length() == 0) return false;
        if (nameField.getText().length() == 0) return false;
        if (typeComboBox.getSelectedIndex() == 0) return false;
        if (departmentComboBox.getSelectedIndex() == 0) return false;
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton deleteTypeButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JTextArea descriptionArea;
    public javax.swing.JLabel deviceIDLabel;
    public javax.swing.JLabel deviceIDLabel1;
    public javax.swing.JLabel deviceIDLabel2;
    public javax.swing.JLabel deviceIDLabel3;
    public javax.swing.JLabel deviceIDLabel4;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel hostInformationLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton newTypeButton;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables

    public String selectedImage = "";
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == aiButton)
        {
            setNextID();
        }
        else if(src == browseButton)
        {
            HydeImage HI = new HydeImage();
            selectedImage = HI.browseImage(this, idField.getText());
            HI.setImage(selectedImage, picLabel, picPanel, 360, 240, HydeImage.HEIGHT_PRIORITY);
        }
        else if(src == newTypeButton)
        {
            String str = JOptionPane.showInputDialog(this, "Insert type name.", "Host Management", JOptionPane.PLAIN_MESSAGE);
            if (str != null && str.length() > 0)
            {
                HP.DMIF.MF.HDC.customUpdate("INSERT INTO host_type SET "
                        + "host_type_name = '"+str+"';");
                setTypeComboBox();
                JOptionPane.showMessageDialog(this, "Host type inserted.", "Host Management",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(src == deleteTypeButton)
        {
            int a = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this host type ?", "Host Management", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a == 0)
            {
                String htid = HydeFormat.parseID((String) typeComboBox.getSelectedItem());
                HP.DMIF.MF.HDC.customUpdate("DELETE FROM host_type WHERE host_type_id = '"+htid+"';");
                setTypeComboBox();
                JOptionPane.showMessageDialog(this, "Host type deleted.", "Host Management",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(src == editButton)
        {
            JOptionPane JOP = new JOptionPane();
            String str = JOP.showInputDialog(this, "Edit type name.", HydeFormat.parseName((String) typeComboBox.getSelectedItem()));
            if (str != null && str.length() > 0)
            {
                String htid = HydeFormat.parseID((String) typeComboBox.getSelectedItem());
                HP.DMIF.MF.HDC.customUpdate("UPDATE host_type SET host_type_name = '"+str+"' WHERE host_type_id = '"+htid+"';");
                setTypeComboBox();
                JOptionPane.showMessageDialog(this, "Host type edited.", "Host Management",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (src == typeComboBox && typeComboBox.getSelectedItem() != null)
        {
            checkComboBox();
        }
        else if (src == applyButton)
        {
            if (checkInput())
            {
                apply();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please fill in the blank", "Host Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
