package ETM.DEVICE.DIALOG;

import ETM.DEVICE.PANEL.DeviceModifyPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewDeviceDialog extends javax.swing.JDialog implements ActionListener
{
    private DeviceModifyPanel DMP;
    private static String defaultGroupComboBox = "Select a group...";
    
    public NewDeviceDialog(DeviceModifyPanel DMP) 
    {
        this.DMP = DMP;
        initComponents();
        actionComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void actionComponents()
    {
        autoButton.addActionListener(this);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        autoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Select device type ");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ethernet Transmitter" }));

        idLabel.setText("Device ID");

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/ok_16.png"))); // NOI18N

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        autoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/auto_16.png"))); // NOI18N
        autoButton.setToolTipText("Auto ID");
        autoButton.setFocusable(false);
        autoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        autoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(autoButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(typeComboBox, 0, 176, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autoButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == autoButton)
        {
            idField.setText(DMP.DMIF.MF.HDC.getNextIncrement("device"));
        }
        else if (src == okButton)
        {
            if (idField.getText().length() != 0)
            {
                if (typeComboBox.getSelectedItem().equals("Ethernet Transmitter"))
                {
                    DMP.newDevice("5",idField.getText());
                    dispose();
                }
            }
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }
}
