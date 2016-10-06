package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.HostPanel;
import ETM.DEVICE.PANEL.LocationPanel;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import HydeModule.SCP.HydeSCP;
import HydeModule.TCPFileTransfer.FileSender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;


public class LocationModifyDialog extends javax.swing.JDialog implements ActionListener
{
    private LocationPanel LP;

    private static int imageWidth = 360;
    private static int imageHeight = 240;

    public static int LOCATION_NEW = 0;
    public static int LOCATION_EDIT = 1;
    
    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultLocationComboBox = "Select a location type...";

    private String any = "1111";
    private int mode;

    public LocationModifyDialog(LocationPanel LP, int mode)
    {
        this.LP = LP;
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
        idField.setText(LP.idField.getText());
        nameField.setText(LP.nameField.getText());
        descriptionArea.setText(LP.descriptionField.getText());
        if (LP.departmentField.getText().equals("-"))
        {
            departmentComboBox.setSelectedItem(defaultDepartmentComboBox);
        }
        else
        {
            departmentComboBox.setSelectedItem(LP.departmentField.getText());
        }

        //HI.selectedImagePath = LP.HI.root+"/image/location/"+LP.HI.imageName;
        //HI.setImage(HI.selectedImagePath, picLabel, picPanel, 360, 240);
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(LP.DMIF.MF.SD.urlImgPath+"/image/location/"+idField.getText()+".jpg", picLabel, picPanel, imageWidth, imageHeight,HydeImage.HEIGHT_PRIORITY);

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
        deviceIDLabel3 = new javax.swing.JLabel();
        deviceIDLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jToolBar2 = new javax.swing.JToolBar();
        aiButton = new javax.swing.JButton();
        applyButton = new javax.swing.JButton();
        hostInformationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Location Info");
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

        deviceIDLabel4.setText("Description");
        deviceIDLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deviceIDLabel4.setMaximumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setMinimumSize(new java.awt.Dimension(63, 10));
        deviceIDLabel4.setOpaque(true);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(applyButton)
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deviceIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, 0, 180, Short.MAX_VALUE)
                        .addGap(31, 31, 31)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deviceIDLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deviceIDLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(applyButton)
                .addContainerGap())
        );

        hostInformationLabel.setText("Location Information");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                    .addComponent(hostInformationLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem(defaultDepartmentComboBox);
            Enumeration enu;
            Vector v = LP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') FROM department;");
            enu = v.elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(LP.DMIF.MF.HDC.query0("SELECT CONCAT(depart_name, ' (', depart_id+0, ')') "
                    + "FROM department WHERE depart_id = '"+LP.DMIF.MF.SD.loginDepartment+"';"));
        }
    }

    private void setNextID()
    {
        idField.setText(LP.DMIF.MF.HDC.getNextIncrement("location"));
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
        if ( LP.DMIF.MF.HDC.query0("SELECT location_id FROM location WHERE location_id = '"+idField.getText()+"';") != null)
        {
            boolean b = LP.DMIF.MF.HDC.customUpdate("UPDATE location SET "
                    + "location_name = '"+nameField.getText()+"', "
                    + "location_description = '"+descriptionArea.getText()+"', "
                    + "depart_id = "+depart+" "
                    + "WHERE location_id = '"+idField.getText()+"';");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/location");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/location/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    //LP.DMIF.MF.HI.resizeImageFileToFile(selectedImage, LP.DMIF.MF.mainPath+"temp.jpg", imageWidth, imageHeight);
                    if (LP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", LP.DMIF.MF.SD.serverPassword, LP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, LP.DMIF.MF.SD.serverImgPath+"/image/location/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        System.out.println(LP.DMIF.MF.SD.serverIP);
                        System.out.println(LP.DMIF.MF.SD.FILE_SERVER_PORT);
                        System.out.println(selectedImage);
                        System.out.println(LP.DMIF.MF.SD.serverImgPath+"/image/location/"+idField.getText()+".jpg");
                        FileSender.send(LP.DMIF.MF.SD.serverIP, LP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, LP.DMIF.MF.SD.serverImgPath+"/image/location/"+idField.getText()+".jpg");
                    }
                }
                LP.setLocationList();
                LP.setInfo(nameField.getText()+" ("+idField.getText()+")");
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
            boolean b = LP.DMIF.MF.HDC.customUpdate("INSERT INTO location (location_id, location_name, location_description, depart_id) VALUES ("
                    + "'"+idField.getText()+"', "
                    + "'"+nameField.getText()+"', "
                    + "'"+descriptionArea.getText()+"', "
                    + ""+depart+" "
                    + ");");
            if (b)
            {
                //HydeFileManager.createDirectory(HI.root+"/image/location");
                //HydeFileManager.copy(HI.selectedImagePath, HI.root+"/image/location/"+HI.imageName);
                if(!selectedImage.equals(""))
                {
                    if (LP.DMIF.MF.SD.upload.toLowerCase().equals("scp"))
                    {  
                        HydeSCP HSCP = new HydeSCP();
                        HSCP.createSession("root", LP.DMIF.MF.SD.serverPassword, LP.DMIF.MF.SD.serverIP);
                        boolean bb =HSCP.scpTo(selectedImage, LP.DMIF.MF.SD.serverImgPath+"/image/location/"+idField.getText()+".jpg");
                    }
                    else
                    {
                        FileSender.send(LP.DMIF.MF.SD.serverIP, LP.DMIF.MF.SD.FILE_SERVER_PORT, selectedImage, LP.DMIF.MF.SD.serverImgPath+"/image/location/"+idField.getText()+".jpg");
                    }
                }
                LP.setLocationList();
                LP.setInfo(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") has been inserted.", "Host Management", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Host "+nameField.getText()+"("+idField.getText()+") cannot be insert !!", "Host Management", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean checkInput()
    {
        if (idField.getText().length() == 0) return false;
        if (nameField.getText().length() == 0) return false;
        if (departmentComboBox.getSelectedIndex() == 0) return false;
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aiButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JTextArea descriptionArea;
    public javax.swing.JLabel deviceIDLabel;
    public javax.swing.JLabel deviceIDLabel1;
    public javax.swing.JLabel deviceIDLabel3;
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
            HI.setImage(selectedImage, picLabel, picPanel, 360, 240, HydeImage.HEIGHT_PRIORITY);
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
