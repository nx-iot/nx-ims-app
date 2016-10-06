package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.DepartmentPanel;
import HydeModule.Image.HydeImage;
import HydeModule.SCP.HydeSCP;
import HydeModule.TCPFileTransfer.FileSender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class DepartmentModifyDialog extends javax.swing.JDialog implements ActionListener
{
    private DepartmentPanel DP;

    private static int imageWidth = 360;
    private static int imageHeight = 240;

    public static int DEPART_NEW = 0;
    public static int DEPART_EDIT = 1;

    private int mode;

    public DepartmentModifyDialog(DepartmentPanel DP, int mode)
    {
        this.DP = DP;
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
        idField.setText(DP.idField.getText());
        nameField.setText(DP.nameField.getText());
        descriptionArea.setText(DP.descriptionField.getText());

        //HI.selectedImagePath = DP.HI.root+"/image/department/"+DP.HI.imageName;
        //HI.setImage(HI.selectedImagePath, picLabel, picPanel, 360, 240);
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(DP.DMIF.MF.SD.urlImgPath+"/image/department/"+idField.getText()+".jpg", picLabel, picPanel, imageWidth, imageHeight,HydeImage.HEIGHT_PRIORITY);

        aiButton.setEnabled(false);
        idField.setEnabled(false);
    }

    private void actionComponents()
    {
        browseButton.addActionListener(this);
        applyButton.addActionListener(this);
        aiButton.addActionListener(this);
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
        deviceIDLabel4 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        aiButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        hostInformationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Department Info");
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
        browseButton.setText("Browse");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        deviceIDLabel4.setText("Address");
        deviceIDLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel4.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setOpaque(true);

        jToolBar2.setFloatable(false);

        aiButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/auto_16.png"))); // NOI18N
        aiButton.setToolTipText("Auto ID");
        aiButton.setFocusable(false);
        aiButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aiButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(aiButton);

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText(" Save Department Info.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(deviceIDLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deviceIDLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(applyButton, javax.swing.GroupLayout.Alignment.TRAILING))
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
                    .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hostInformationLabel.setText("Department Information");

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


    private void setNextID()
    {
        idField.setText(DP.DMIF.MF.HDC.getNextIncrement("department"));
    }

    private void apply()
    {
        if ( DP.DMIF.MF.HDC.query0("SELECT depart_id FROM department WHERE depart_id = '"+idField.getText()+"';") != null)
        {
            boolean b = DP.DMIF.MF.HDC.customUpdate("UPDATE department SET "
                    + "depart_name = '"+nameField.getText()+"', "
                    + "depart_address = '"+descriptionArea.getText()+"' "
                    + "WHERE depart_id = '"+idField.getText()+"';");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/department");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/department/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    //DP.DMIF.MF.HI.resizeImageFileToFile(selectedImage, DP.DMIF.MF.mainPath+"temp.jpg", imageWidth, imageHeight);
                    if (DP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", DP.DMIF.MF.SD.serverPassword, DP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, DP.DMIF.MF.SD.serverImgPath+"/image/department/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        System.out.println(DP.DMIF.MF.SD.serverIP);
                        System.out.println(DP.DMIF.MF.SD.FILE_SERVER_PORT);
                        System.out.println(selectedImage);
                        System.out.println(DP.DMIF.MF.SD.serverImgPath+"/image/department/"+idField.getText()+".jpg");
                        FileSender.send(DP.DMIF.MF.SD.serverIP, DP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, DP.DMIF.MF.SD.serverImgPath+"/image/department/"+idField.getText()+".jpg");
                    }
                }
                DP.setDeviceList();
                DP.setGroupList();
                DP.setUserList();
                DP.setDepartmentComboBox();
                DP.departmentComboBox.setSelectedItem(nameField.getText()+" ("+idField.getText()+")");
                DP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Department "+nameField.getText()+"("+idField.getText()+") has been saved.", "Department Management", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Department "+nameField.getText()+"("+idField.getText()+") cannot be save !!", "Department Management", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            boolean b = DP.DMIF.MF.HDC.customUpdate("INSERT INTO department (depart_id, depart_name, depart_address) VALUES ("
                    + "'"+idField.getText()+"', "
                    + "'"+nameField.getText()+"', "
                    + "'"+descriptionArea.getText()+"' "
                    + ");");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/department");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/department/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    if (DP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {  
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", DP.DMIF.MF.SD.serverPassword, DP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, DP.DMIF.MF.SD.serverImgPath+"/image/department/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        FileSender.send(DP.DMIF.MF.SD.serverIP, DP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, DP.DMIF.MF.SD.serverImgPath+"/image/department/"+idField.getText()+".jpg");
                    }
                }
                DP.setDeviceList();
                DP.setGroupList();
                DP.setUserList();
                DP.setDepartmentComboBox();
                DP.departmentComboBox.setSelectedItem(nameField.getText()+" ("+idField.getText()+")");
                DP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Department "+nameField.getText()+"("+idField.getText()+") has been inserted.", "Department Management", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Department "+nameField.getText()+"("+idField.getText()+") cannot be insert !!", "Department Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checkInput()
    {
        if (idField.getText().length() == 0) return false;
        if (nameField.getText().length() == 0) return false;
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JTextArea descriptionArea;
    public javax.swing.JLabel deviceIDLabel;
    public javax.swing.JLabel deviceIDLabel1;
    public javax.swing.JLabel deviceIDLabel4;
    private javax.swing.JLabel hostInformationLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
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
            HI.setImage(selectedImage, picLabel, picPanel, 99, 99, HydeImage.HEIGHT_PRIORITY);
        }
        else if (src == applyButton)
        {
            if (checkInput())
            {
                apply();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Please fill in the blank", "Department Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
