package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.LocationPanel;
import ETM.Util.HydeFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class LocationToDeviceDialog extends javax.swing.JDialog implements ActionListener, MouseListener
{
    private LocationPanel LP;
    private String wid;

    private String any;

    public LocationToDeviceDialog(LocationPanel LP)
    {
        this.LP = LP;
        initComponents();
        extendComponents();
        actionComponents();

        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        wid = LP.nameField.getText()+" ("+ LP.idField.getText()+")";
        profileField.setText(wid);
        wid = HydeFormat.parseID(wid);
        setComboBox();
        setList();
    }

    private void actionComponents()
    {
        selectAllButton.addActionListener(this);
        applyButton.addActionListener(this);
        cancelButton.addActionListener(this);
        deviceList.addMouseListener(this);

        departmentComboBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        applyButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        profileField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        deviceListScroll = new javax.swing.JScrollPane();
        deviceList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        groupLabel = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        selectAllButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Location->Device");
        setAlwaysOnTop(true);

        applyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        applyButton.setText("Save");

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.setText("Cancel");

        jLabel1.setText("Location : ");

        departmentLabel.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        deviceListScroll.setViewportView(deviceList);

        jPanel1.add(deviceListScroll, java.awt.BorderLayout.CENTER);

        groupLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        groupLabel.setText("Device list");
        groupLabel.setMaximumSize(new java.awt.Dimension(100, 20));
        groupLabel.setMinimumSize(new java.awt.Dimension(100, 20));
        groupLabel.setPreferredSize(new java.awt.Dimension(100, 20));

        jToolBar2.setFloatable(false);

        selectAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/all_16.png"))); // NOI18N
        selectAllButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar2.add(selectAllButton);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, 0, 0, Short.MAX_VALUE)
            .addComponent(groupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(departmentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmentComboBox, 0, 183, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(applyButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setComboBox()
    {
        Enumeration enu;
        departmentComboBox.removeActionListener(this);
        departmentComboBox.removeAllItems();

        if (LP.DMIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem("All");
            enu = LP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(LP.DMIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+LP.DMIF.MF.SD.loginDepartment+"';"));
        }

        departmentComboBox.addActionListener(this);
    }

    private void setList()
    {
        String did = (String) departmentComboBox.getSelectedItem();
        if (did != null && !did.equals("All"))
        {
            groupLabel.setText("Device(s) in "+HydeFormat.parseName(did));
            did = " WHERE depart_id = '"+HydeFormat.parseID(did)+"'";
        }
        else
        {
            groupLabel.setText("Device list");
            did = "";
        }
        Vector v = new Vector();
        v = LP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_name, ' (', device_id+0, ')') FROM device NATURAL JOIN device_group "+did+";");
        Object[] str = v.toArray();
        deviceList.removeAll();
        deviceList.setListData(str);
        deviceList.setSelectedIndex(0);
        deviceList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JList deviceList;
    private javax.swing.JScrollPane deviceListScroll;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel profileField;
    private javax.swing.JButton selectAllButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == selectAllButton)
        {
            deviceList.setSelectionInterval(0, deviceList.getModel().getSize() -1);
            selected = deviceList.getSelectedValues();
        }
        else if (src == applyButton)
        {
            String deviceIDs = " WHERE false ";
            Object[] obj = deviceList.getSelectedValues();
            for(int i=0;i<obj.length;i++)
            {
                String id = (String) obj[i];
                id = HydeFormat.parseID(id);
                deviceIDs += "OR device_id = '"+id+"' ";
            }
            boolean b1 = LP.DMIF.MF.HDC.customUpdate("UPDATE device SET location_id = "+wid+deviceIDs+";");
            if (b1)
            {
                JOptionPane.showMessageDialog(this, "Location has been set to selected devices.", "Location Management",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cannot set Location to selected devices !", "Location Management",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (src == departmentComboBox)
        {
            setList();
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }

    Object selected[];
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        if (src == deviceList)
        {
            selected = deviceList.getSelectedValues();
        }
    }
}
