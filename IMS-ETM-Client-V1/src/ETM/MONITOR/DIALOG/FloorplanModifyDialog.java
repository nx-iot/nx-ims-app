package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.FloorplanManagementPanel;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import HydeModule.SCP.HydeSCP;
import HydeModule.TCPFileTransfer.FileSender;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;


public class FloorplanModifyDialog extends javax.swing.JDialog implements ActionListener
{
    private FloorplanManagementPanel FMP;

    private static int imageWidth = 360;
    private static int imageHeight = 240;

    public static int FLOORPLAN_NEW = 0;
    public static int FLOORPLAN_EDIT = 1;
    
    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultFloorplanComboBox = "Select a floorplan type...";

    private String any = "1111";
    private int mode;

    public FloorplanModifyDialog(FloorplanManagementPanel FMP, int mode)
    {
        this.FMP = FMP;
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
        idField.setText(FMP.idField.getText());
        nameField.setText(FMP.nameField.getText());
        departmentComboBox.setSelectedItem( FMP.departmentField.getText().equals(FloorplanManagementPanel.defaultDepartmentComboBox) ? defaultDepartmentComboBox : FMP.departmentField.getText());
        
        //HI.selectedImagePath = HP.HI.root+"/image/floorplan/"+HP.HI.imageName;
        //HI.setImage(HI.selectedImagePath, picLabel, picPanel, 360, 240);
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(FMP.MIF.MF.SD.urlImgPath+"/image/floorplan/"+idField.getText()+".jpg", picLabel, picPanel, imageWidth, imageHeight,HydeImage.HEIGHT_PRIORITY);

        aiButton.setEnabled(false);
        idField.setEnabled(false);
    }

    private void actionComponents()
    {
        applyButton.addActionListener(this);
        aiButton.addActionListener(this);
        fullButton.addActionListener(this);
        halfButton.addActionListener(this);
        quarterButton.addActionListener(this);
        resizeCheckBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        picLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        aiButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        deviceIDLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        deviceIDLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        departmentComboBox = new javax.swing.JComboBox();
        deviceIDLabel3 = new javax.swing.JLabel();
        imageBrowsePanel = new javax.swing.JPanel();
        fullPanel = new javax.swing.JPanel();
        fullField = new javax.swing.JTextField();
        fullLabel = new javax.swing.JLabel();
        jToolBar5 = new javax.swing.JToolBar();
        fullButton = new javax.swing.JButton();
        halfPanel = new javax.swing.JPanel();
        halfField = new javax.swing.JTextField();
        halfLabel = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        halfButton = new javax.swing.JButton();
        quarterPanel = new javax.swing.JPanel();
        quarterField = new javax.swing.JTextField();
        quarterLabel = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        quarterButton = new javax.swing.JButton();
        resizeCheckBox = new javax.swing.JCheckBox();
        hostInformationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Floorplan Info");
        setAlwaysOnTop(true);
        setResizable(false);

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(picLabel);

        javax.swing.GroupLayout picPanelLayout = new javax.swing.GroupLayout(picPanel);
        picPanel.setLayout(picPanelLayout);
        picPanelLayout.setHorizontalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );
        picPanelLayout.setVerticalGroup(
            picPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar2.setFloatable(false);

        aiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/auto_16.png"))); // NOI18N
        aiButton.setToolTipText("Auto ID");
        aiButton.setFocusable(false);
        aiButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aiButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(aiButton);

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText(" Save Floorplan Info.");

        jPanel3.setLayout(new java.awt.BorderLayout());

        deviceIDLabel.setText("ID");
        deviceIDLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel.setMaximumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel.setMinimumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel.setOpaque(true);
        deviceIDLabel.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel3.add(deviceIDLabel, java.awt.BorderLayout.WEST);
        jPanel3.add(idField, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(nameField, java.awt.BorderLayout.CENTER);

        deviceIDLabel1.setText("Name");
        deviceIDLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel1.setMaximumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel1.setMinimumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel1.setOpaque(true);
        deviceIDLabel1.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel4.add(deviceIDLabel1, java.awt.BorderLayout.WEST);

        jPanel5.setLayout(new java.awt.BorderLayout());

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));
        jPanel5.add(departmentComboBox, java.awt.BorderLayout.CENTER);

        deviceIDLabel3.setText("Department");
        deviceIDLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel3.setMaximumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel3.setMinimumSize(new java.awt.Dimension(70, 20));
        deviceIDLabel3.setOpaque(true);
        deviceIDLabel3.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel5.add(deviceIDLabel3, java.awt.BorderLayout.WEST);

        imageBrowsePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Browse Image"));

        fullPanel.setLayout(new java.awt.BorderLayout());
        fullPanel.add(fullField, java.awt.BorderLayout.CENTER);

        fullLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fullLabel.setText("Full Size");
        fullLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fullLabel.setMaximumSize(new java.awt.Dimension(70, 20));
        fullLabel.setMinimumSize(new java.awt.Dimension(70, 20));
        fullLabel.setOpaque(true);
        fullLabel.setPreferredSize(new java.awt.Dimension(70, 20));
        fullPanel.add(fullLabel, java.awt.BorderLayout.WEST);

        jToolBar5.setFloatable(false);
        jToolBar5.setMaximumSize(new java.awt.Dimension(20, 20));
        jToolBar5.setMinimumSize(new java.awt.Dimension(20, 20));

        fullButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/find_16.png"))); // NOI18N
        fullButton.setToolTipText("Browse");
        fullButton.setFocusable(false);
        fullButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fullButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(fullButton);

        fullPanel.add(jToolBar5, java.awt.BorderLayout.EAST);

        halfPanel.setLayout(new java.awt.BorderLayout());
        halfPanel.add(halfField, java.awt.BorderLayout.CENTER);

        halfLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        halfLabel.setText("Half Size");
        halfLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        halfLabel.setMaximumSize(new java.awt.Dimension(70, 20));
        halfLabel.setMinimumSize(new java.awt.Dimension(70, 20));
        halfLabel.setOpaque(true);
        halfLabel.setPreferredSize(new java.awt.Dimension(70, 20));
        halfPanel.add(halfLabel, java.awt.BorderLayout.WEST);

        jToolBar4.setFloatable(false);
        jToolBar4.setMaximumSize(new java.awt.Dimension(20, 20));
        jToolBar4.setMinimumSize(new java.awt.Dimension(20, 20));

        halfButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/find_16.png"))); // NOI18N
        halfButton.setToolTipText("Browse");
        halfButton.setFocusable(false);
        halfButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        halfButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(halfButton);

        halfPanel.add(jToolBar4, java.awt.BorderLayout.EAST);

        quarterPanel.setLayout(new java.awt.BorderLayout());
        quarterPanel.add(quarterField, java.awt.BorderLayout.CENTER);

        quarterLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        quarterLabel.setText("Quarter Size");
        quarterLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quarterLabel.setMaximumSize(new java.awt.Dimension(70, 20));
        quarterLabel.setMinimumSize(new java.awt.Dimension(70, 20));
        quarterLabel.setOpaque(true);
        quarterLabel.setPreferredSize(new java.awt.Dimension(70, 20));
        quarterPanel.add(quarterLabel, java.awt.BorderLayout.WEST);

        jToolBar3.setFloatable(false);
        jToolBar3.setMaximumSize(new java.awt.Dimension(20, 20));
        jToolBar3.setMinimumSize(new java.awt.Dimension(20, 20));

        quarterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/find_16.png"))); // NOI18N
        quarterButton.setToolTipText("Browse");
        quarterButton.setFocusable(false);
        quarterButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        quarterButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(quarterButton);

        quarterPanel.add(jToolBar3, java.awt.BorderLayout.EAST);

        resizeCheckBox.setText(" Resize Full to other size");

        javax.swing.GroupLayout imageBrowsePanelLayout = new javax.swing.GroupLayout(imageBrowsePanel);
        imageBrowsePanel.setLayout(imageBrowsePanelLayout);
        imageBrowsePanelLayout.setHorizontalGroup(
            imageBrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageBrowsePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imageBrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resizeCheckBox, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fullPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quarterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(halfPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        imageBrowsePanelLayout.setVerticalGroup(
            imageBrowsePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageBrowsePanelLayout.createSequentialGroup()
                .addComponent(fullPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(halfPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quarterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resizeCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(applyButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(imageBrowsePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToolBar2, 0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageBrowsePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hostInformationLabel.setText("Floorplan Information");

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
                        .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hostInformationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComboBox()
    {
        departmentComboBox.removeAllItems();
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem(defaultDepartmentComboBox);
            Enumeration enu;
            Vector v = FMP.MIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') FROM department;");
            enu = v.elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(FMP.MIF.MF.HDC.query0("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') "
                    + "FROM department WHERE depart_id = '"+FMP.MIF.MF.SD.loginDepartment+"';"));
        }
    }

    private void setNextID()
    {
        idField.setText(FMP.MIF.MF.HDC.getNextIncrement("floorplan"));
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
        if ( FMP.MIF.MF.HDC.query0("SELECT floorplan_id FROM floorplan WHERE floorplan_id = '"+idField.getText()+"';") != null)
        {
            boolean b = FMP.MIF.MF.HDC.customUpdate("UPDATE floorplan SET "
                    + "floorplan_name = '"+nameField.getText()+"', "
                    + "depart_id = "+depart+", "
                    + "last_update = '"+FMP.MIF.MF.HDC.getCurrentDateTime()+"' "
                    + "WHERE floorplan_id = '"+idField.getText()+"';");
            if (b)
            {
                if (FMP.MIF.MF.SD.upload.toLowerCase().equals("scp"))
                {
                    HydeSCP HSCP = new HydeSCP();
                    HSCP.createSession("root", FMP.MIF.MF.SD.serverPassword, FMP.MIF.MF.SD.serverIP);
                    HSCP.scpTo(selectedImage4, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_4.jpg");
                    if (!resizeCheckBox.isSelected())
                    {
                        HSCP.scpTo(selectedImage2, FMP.MIF.MF.SD.serverImgPath + "/image/floorplan/"+idField.getText() + "_2.jpg");
                        HSCP.scpTo(selectedImage1, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                    else
                    {
                        HydeImage HI = new HydeImage();
                        Dimension dim = HI.getImageFileDimension(selectedImage4);
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", (int)(dim.getWidth() / 2), (int)(dim.getHeight() / 2));
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", (int)(dim.getWidth() / 4), (int)(dim.getHeight() / 4));
                        HSCP.scpTo(FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", FMP.MIF.MF.SD.serverImgPath + "/image/floorplan/"+idField.getText() + "_2.jpg");
                        HSCP.scpTo(FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                }
                else
                {
                    FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage4, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_4.jpg");
                    if (!resizeCheckBox.isSelected())
                    {
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage2, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_2.jpg");
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage1, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                    else
                    {
                        HydeImage HI = new HydeImage();
                        Dimension dim = HI.getImageFileDimension(selectedImage4);
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", (int)(dim.getWidth() / 2), (int)(dim.getHeight() / 2));
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", (int)(dim.getWidth() / 4), (int)(dim.getHeight() / 4));
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_2.jpg");
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                }
                FMP.setFloorplanList();
                FMP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Floorplan has been updated.", "Floorplan Management", JOptionPane.INFORMATION_MESSAGE);
                FMP.MIF.MF.checkFloorPlan();
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Floorplan cannot be updated !!", "Floorplan Management", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            boolean b = FMP.MIF.MF.HDC.customUpdate("INSERT INTO floorplan "
                    + "(floorplan_id, floorplan_name, depart_id, last_update) VALUES ("
                    + "'"+idField.getText()+"', "
                    + "'"+nameField.getText()+"', "
                    + ""+depart+", "
                    + "'"+FMP.MIF.MF.HDC.getCurrentDateTime()+"' "
                    + ");");
            if (b)
            {
                if (FMP.MIF.MF.SD.upload.toLowerCase().equals("scp"))
                {
                    HydeSCP HSCP = new HydeSCP();
                    HSCP.createSession("root", FMP.MIF.MF.SD.serverPassword, FMP.MIF.MF.SD.serverIP);
                    HSCP.scpTo(selectedImage4, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_4.jpg");
                    if (!resizeCheckBox.isSelected())
                    {
                        HSCP.scpTo(selectedImage2, FMP.MIF.MF.SD.serverImgPath + "/image/floorplan/"+idField.getText() + "_2.jpg");
                        HSCP.scpTo(selectedImage1, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                    else
                    {
                        HydeImage HI = new HydeImage();
                        Dimension dim = HI.getImageFileDimension(selectedImage4);
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", (int)(dim.getWidth() / 2), (int)(dim.getHeight() / 2));
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", (int)(dim.getWidth() / 4), (int)(dim.getHeight() / 4));
                        HSCP.scpTo(FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", FMP.MIF.MF.SD.serverImgPath + "/image/floorplan/"+idField.getText() + "_2.jpg");
                        HSCP.scpTo(FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                }
                else
                {
                    FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage4, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_4.jpg");
                    if (!resizeCheckBox.isSelected())
                    {
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage2, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_2.jpg");
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, selectedImage1, FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                    else
                    {
                        HydeImage HI = new HydeImage();
                        Dimension dim = HI.getImageFileDimension(selectedImage4);
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", (int)(dim.getWidth() / 2), (int)(dim.getHeight() / 2));
                        HI.resizeImageFileToFile(selectedImage4, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", (int)(dim.getWidth() / 4), (int)(dim.getHeight() / 4));
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, FMP.MIF.MF.SD.DIR+"/temp_resized2.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_2.jpg");
                        FileSender.send(FMP.MIF.MF.SD.serverIP, FMP.MIF.MF.SD.FILE_SERVER_PORT, FMP.MIF.MF.SD.DIR+"/temp_resized1.jpg", FMP.MIF.MF.SD.serverImgPath+"/image/floorplan/"+idField.getText()+"_1.jpg");
                    }
                }
                FMP.setFloorplanList();
                FMP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Floorplan "+nameField.getText()+"("+idField.getText()+") has been inserted.", "Floorplan Management", JOptionPane.INFORMATION_MESSAGE);
                FMP.MIF.MF.checkFloorPlan();
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Floorplan "+nameField.getText()+"("+idField.getText()+") cannot be insert !!", "Floorplan Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checkInput()
    {
        if (idField.getText().length() == 0) return false;
        if (nameField.getText().length() == 0) return false;
        if (departmentComboBox.getSelectedIndex() == 0) return false;
        if (fullField.getText().length() == 0) return false;
        if (!resizeCheckBox.isSelected() && mode != 1)
        {
            if (halfField.getText().length() == 0) return false;
            if (quarterField.getText().length() == 0) return false;
        }
        return checkImage();
    }

    private boolean checkImage()
    {
        boolean ret = true;
        if (!new File(fullField.getText()).exists()) ret = false;
        if (!resizeCheckBox.isSelected())
        {
            if (!new File(halfField.getText()).exists()) ret = false;
            if (!new File(quarterField.getText()).exists()) ret = false;
        }
        return ret;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JComboBox departmentComboBox;
    public javax.swing.JLabel deviceIDLabel;
    public javax.swing.JLabel deviceIDLabel1;
    public javax.swing.JLabel deviceIDLabel3;
    private javax.swing.JButton fullButton;
    private javax.swing.JTextField fullField;
    public javax.swing.JLabel fullLabel;
    private javax.swing.JPanel fullPanel;
    private javax.swing.JButton halfButton;
    private javax.swing.JTextField halfField;
    public javax.swing.JLabel halfLabel;
    private javax.swing.JPanel halfPanel;
    private javax.swing.JLabel hostInformationLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel imageBrowsePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JButton quarterButton;
    private javax.swing.JTextField quarterField;
    public javax.swing.JLabel quarterLabel;
    private javax.swing.JPanel quarterPanel;
    private javax.swing.JCheckBox resizeCheckBox;
    // End of variables declaration//GEN-END:variables

    public String selectedImage4 = "";
    public String selectedImage2 = "";
    public String selectedImage1 = "";
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == aiButton)
        {
            setNextID();
        }
        else if(src == fullButton)
        {
            HydeImage HI = new HydeImage();
            selectedImage4 = HI.browseImage(this, idField.getText());
            fullField.setText(selectedImage4);
            HI.setImage(selectedImage4, picLabel, picPanel, 360, 240, HydeImage.HEIGHT_PRIORITY);
        }
        else if(src == halfButton)
        {
            HydeImage HI = new HydeImage();
            selectedImage2 = HI.browseImage(this, idField.getText());
            halfField.setText(selectedImage2);
        }
        else if(src == quarterButton)
        {
            HydeImage HI = new HydeImage();
            selectedImage1 = HI.browseImage(this, idField.getText());
            quarterField.setText(selectedImage1);
        }
        else if (src == resizeCheckBox)
        {
            if (resizeCheckBox.isSelected())
            {
                halfField.setEnabled(false);
                quarterField.setEnabled(false);
            }
            else
            {
                halfField.setEnabled(true);
                quarterField.setEnabled(true);
            }
        }
        else if (src == applyButton)
        {
            if (checkInput())
            {
                apply();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please fill in the blank", "Floorplan Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
