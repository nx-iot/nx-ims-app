package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.FloorplanEffectPanel;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ZoneEditDialog extends javax.swing.JDialog implements ActionListener
{
    private FloorplanEffectPanel FEP;
    private String id;

    private String any;

    private static String defaultComboBox = "Select a location...";
    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultNoComboBox = "No location...";

    public ZoneEditDialog(FloorplanEffectPanel FEP, String id)
    {
        this.FEP = FEP;
        this.id = id;

        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        any = "1111";
        if (any == null)
        {
            any = "0000";
        }

        idField.setText(id);
        setComboBox();
    }

    private void actionComponents()
    {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        departmentComboBox.addActionListener(this);
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
        locationComboBox = new javax.swing.JComboBox();
        nameLabel3 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Map device to balloon");
        setModal(true);
        setResizable(false);

        nameLabel1.setText("Zone ID");
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

        nameLabel2.setText("Location ID");
        nameLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameLabel2.setMaximumSize(new java.awt.Dimension(63, 10));
        nameLabel2.setMinimumSize(new java.awt.Dimension(63, 10));
        nameLabel2.setOpaque(true);

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a location..." }));

        nameLabel3.setText("Department");
        nameLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nameLabel3.setMaximumSize(new java.awt.Dimension(63, 10));
        nameLabel3.setMinimumSize(new java.awt.Dimension(63, 10));
        nameLabel3.setOpaque(true);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationComboBox, 0, 178, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentComboBox, 0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                                .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setComboBox()
    {
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
        Enumeration enu;
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem("All");
            enu = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(FEP.FPP.MIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+FEP.FPP.MIF.MF.SD.loginDepartment+"';"));
        }
        setLocationComboBox();
    }

    public void setLocationComboBox()
    {
        String depart = (String) departmentComboBox.getSelectedItem();
        if (depart != null && !depart.equals(""))
        {
            locationComboBox.removeAllItems();
            locationComboBox.addItem(defaultComboBox);
            Enumeration enu;
            Vector v;
            if (depart.equals("All"))
            {
                v = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (', location_id+0, ')') FROM location;");
            }
            else
            {
                v = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (', location_id+0, ')') FROM location "
                        + "WHERE depart_id = '"+HydeFormat.parseID(depart)+"';");
            }
            enu = v.elements();
            while (enu.hasMoreElements())
            {
                locationComboBox.addItem(enu.nextElement());
            }

            Vector idb;
            if (depart.equals("All"))
            {
                idb = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (', location_id+0, ')') FROM floor_zone NATURAL JOIN location;");
            }
            else
            {
                idb = FEP.FPP.MIF.MF.HDC.queryColumn("SELECT CONCAT(location_name, ' (', location_id+0, ')') FROM floor_zone NATURAL JOIN location "
                    + "WHERE depart_id = '"+HydeFormat.parseID(depart)+"';");
            }
            if (idb != null)
            {
                Enumeration enu2 = idb.elements();
                while (enu2.hasMoreElements())
                {
                    locationComboBox.removeItem(enu2.nextElement());
                }
            }
            locationComboBox.addItem(defaultNoComboBox);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.ButtonGroup deviceTypeButtonGroup;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox locationComboBox;
    public javax.swing.JLabel nameLabel1;
    public javax.swing.JLabel nameLabel2;
    public javax.swing.JLabel nameLabel3;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if(src == cancelButton)
        {
            dispose();
        }
        else if(src == departmentComboBox)
        {
            setLocationComboBox();
        }
        else if (src == okButton)
        {
            String locationID = (String) locationComboBox.getSelectedItem();
            if (locationID != null && !locationID.equals(defaultComboBox))
            {
                if (locationID.equals(defaultNoComboBox))
                {
                    locationID = "";
                    if (FEP.FPP.MIF.MF.HDC.customUpdate("UPDATE floor_zone SET location_id = NULL WHERE floor_zone_id = '"+id+"';"))
                    {
                        JOptionPane.showMessageDialog(this, "Zone id["+id+"]'s link has been removed", "Zone Management", JOptionPane.INFORMATION_MESSAGE);
                        FEP.FPP.MIF.setZoneParameter();
                        FEP.repaint();
                        dispose();
                    }
                }
                else
                {
                    locationID = HydeFormat.parseID(locationID);
                    if (FEP.FPP.MIF.MF.HDC.customUpdate("UPDATE floor_zone SET location_id = '"+locationID+"' WHERE floor_zone_id = '"+id+"';"))
                    {
                        JOptionPane.showMessageDialog(this, "Zone id["+id+"] has been linked to location["+locationID+"]", "Zone Management", JOptionPane.INFORMATION_MESSAGE);
                        FEP.FPP.MIF.setZoneParameter();
                        FEP.repaint();
                        dispose();
                    }
                }
                
            }
        }
    }


}
