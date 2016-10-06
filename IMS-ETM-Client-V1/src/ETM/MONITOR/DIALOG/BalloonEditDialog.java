package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.FloorplanEffectPanel;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class BalloonEditDialog extends javax.swing.JDialog implements ActionListener
{
    private FloorplanEffectPanel FPEP;
    private String id;
    private ButtonGroup BG;

    private ImageIcon baseIcon = new ImageIcon(getClass().getResource("/Picz/Balloon/base_na_2.png"));
    private ImageIcon repeaterIcon = new ImageIcon(getClass().getResource("/Picz/Balloon/repeater_2.png"));
    private ImageIcon transmitterIcon = new ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_na_2.png"));

    public BalloonEditDialog(FloorplanEffectPanel FPEP, String id)
    {
        this.FPEP = FPEP;
        this.id = id;

        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        idField.setText(id);
        setDeviceIDComboBox("Base");
    }

    private void actionComponents()
    {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        typeComboBox.addActionListener(this);

        /*baseRadioButton.addActionListener(this);
        repeaterRadioButton.addActionListener(this);
        transmitterRadioButton.addActionListener(this);

        transmitterRadioButton.doClick();*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deviceTypeButtonGroup = new javax.swing.ButtonGroup();
        nameLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameLabel2 = new javax.swing.JLabel();
        deviceIDComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Map device to balloon");
        setModal(true);
        setResizable(false);

        nameLabel1.setText("Balloon ID");
        nameLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameLabel1.setMaximumSize(new java.awt.Dimension(63, 10));
        nameLabel1.setMinimumSize(new java.awt.Dimension(63, 10));
        nameLabel1.setOpaque(true);

        idField.setBackground(new java.awt.Color(240, 240, 240));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/ok_16.png"))); // NOI18N
        okButton.setText(" OK");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.setText(" Cancel");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));

        nameLabel2.setText("Device ID");
        nameLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameLabel2.setMaximumSize(new java.awt.Dimension(63, 10));
        nameLabel2.setMinimumSize(new java.awt.Dimension(63, 10));
        nameLabel2.setOpaque(true);

        jLabel1.setText("Device Type");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Base", "Repeater", "Transmitter", "Eth-Transmitter", "Server", "Client" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(nameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceIDComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deviceIDComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                            .addComponent(nameLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setDeviceIDComboBox(String deviceType)
    {
        int type = 0;
        if (deviceType.equals("Base")) type = 1;
        else  if (deviceType.equals("Repeater")) type = 2;
        else  if (deviceType.equals("Transmitter")) type = 3;
        else  if (deviceType.equals("Eth-Transmitter")) type = 5;
        else  if (deviceType.equals("Server")) type = 101;
        else  if (deviceType.equals("Client")) type = 102;
        Vector ids = FPEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (', device_id+0, ')') FROM device WHERE equipment_id = "+type+";");
        if (ids != null)
        {
            deviceIDComboBox.removeAllItems();
            deviceIDComboBox.addItem("Select Device...");
            Enumeration enu = ids.elements();
            while (enu.hasMoreElements())
            {
                deviceIDComboBox.addItem(enu.nextElement());
            }
        }
        Vector idb = FPEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(device.device_name, ' (', balloon.device_id+0, ')') FROM balloon NATURAL JOIN device WHERE equipment_id = "+type+";");
        if (idb != null)
        {
            Enumeration enu2 = idb.elements();
            while (enu2.hasMoreElements())
            {
                deviceIDComboBox.removeItem(enu2.nextElement());
            }
        }
        deviceIDComboBox.addItem("No Device...");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox deviceIDComboBox;
    private javax.swing.ButtonGroup deviceTypeButtonGroup;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel nameLabel1;
    public javax.swing.JLabel nameLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == typeComboBox)
        {
            setDeviceIDComboBox((String)typeComboBox.getSelectedItem());
            //typeIcon.setIcon(baseIcon);
        }
        else if(src == cancelButton)
        {
            dispose();
        }
        else if (src == okButton)
        {
            String deviceID = (String) deviceIDComboBox.getSelectedItem();
            if (!deviceID.equals("Select Device..."))
            {
                if (deviceID.equals("No Device..."))
                {
                    deviceID = "";
                    if (FPEP.FPP.MIF.MF.HDC.customUpdate("UPDATE balloon SET device_id = NULL WHERE balloon_id = '"+id+"';"))
                    {
                        JOptionPane.showMessageDialog(this, "Balloon id["+id+"]'s link has been removed", "Balloon Management", JOptionPane.INFORMATION_MESSAGE);
                        FPEP.FPP.MIF.setBalloonParameter();
                        FPEP.repaint();
                        dispose();
                    }
                }
                else
                {
                    deviceID = HydeFormat.parseID(deviceID);
                    if (FPEP.FPP.MIF.MF.HDC.customUpdate("UPDATE balloon SET device_id = '"+deviceID+"' WHERE balloon_id = '"+id+"';"))
                    {
                        JOptionPane.showMessageDialog(this, "Balloon id["+id+"] has been linked to device["+deviceID+"]", "Balloon Management", JOptionPane.INFORMATION_MESSAGE);
                        FPEP.FPP.MIF.setBalloonParameter();
                        FPEP.repaint();
                        dispose();
                    }
                }
                
            }
        }
    }


}
