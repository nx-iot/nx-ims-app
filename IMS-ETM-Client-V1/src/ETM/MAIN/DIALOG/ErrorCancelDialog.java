package ETM.MAIN.DIALOG;

import ETM.MAIN.MainFrame;
import ETM.Util.HydeFormat;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ErrorCancelDialog extends javax.swing.JDialog implements ActionListener
{
    private String fixMessage;
    private MainFrame MF;

    private String alarmID;
    private String deviceID;

    public ErrorCancelDialog(MainFrame MF, String alarmID, String fixMessage, String deviceID)
    {
        //super(EPU,true);
        this.MF = MF;
        this.fixMessage = fixMessage;
        this.alarmID = alarmID;
        this.deviceID = deviceID;

        initComponents();

        extendComponents();
        actionComponents();

        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void extendComponents() 
    {
        reasonArea.setText(fixMessage);
    }

    private void actionComponents() 
    {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reasonArea = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        muteCheckBox = new javax.swing.JCheckBox();
        durationField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Please insert cause of problem and countermeasure...");
        setAlwaysOnTop(true);

        jLabel1.setText("Please fill your reason...");

        reasonArea.setColumns(20);
        reasonArea.setLineWrap(true);
        reasonArea.setRows(8);
        reasonArea.setWrapStyleWord(true);
        reasonArea.setDocument(new ETM.Util.HydeJTextFieldLimit(255,0));
        jScrollPane1.setViewportView(reasonArea);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.setText("Cancel");

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/ok_16.png"))); // NOI18N
        okButton.setText("OK");

        muteCheckBox.setText("Also mute alarm from device for");

        durationField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        durationField.setText("5");

        jLabel2.setText("Minutes");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("* mute duration range 5 - 1440 minutes (1 day)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(muteCheckBox)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(okButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(muteCheckBox)
                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField durationField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox muteCheckBox;
    private javax.swing.JButton okButton;
    private javax.swing.JTextArea reasonArea;
    // End of variables declaration//GEN-END:variables

    public int getDuration()
    {
        int dur = Integer.parseInt(durationField.getText());
        if (dur < 5)
        {
            dur = 5;
        }
        return dur*60;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == okButton)
        {
            String reason = reasonArea.getText();
            if (reason == null || reason.length() == 0)
            {
                JOptionPane.showMessageDialog(this, "Please insert cause of problem and countermeasure...", "ALARM",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                reason = reason.replace("'","\\\'");
                okButton.setText("Syncronizing...");
                okButton.setEnabled(false);
                MF.HDC.customUpdate("UPDATE alarm_current SET "
                        + "user_fix = '1', "
                        + "user_username = '"+MF.SD.loginUser+"', "
                        + "user_timestamp = '"+MF.HDC.getCurrentDateTime()+"', "
                        + "note = '"+reason+"' "
                        + "WHERE alarm_id = '"+alarmID+"'"
                        + ";");
                
                IMSProtocolStructure IPS = new IMSProtocolStructure();
                IPS.setFrameType(IMSClientProtocol.EVENT_TRIGGER_CMD);
                IPS.setAlarmID(alarmID);
                IPS.setTriggerDirection((byte)0x00);
                MF.FC.findBufferByID("0000000000000000",MF.SD.serverIP,MF.SD.SERVER_PORT).addFrame(IPS);
                
                if (muteCheckBox.isSelected())
                {
                    IMSProtocolStructure IPS2 = new IMSProtocolStructure();
                    IPS2.setFrameType(IMSClientProtocol.REMOTE_CONTROL_CMD);
                    IPS2.setAlarmID(alarmID);
                    IPS2.setDeviceID(deviceID);
                    IPS2.setRemoteType((byte)0x10);
                    IPS2.setRemoteValue(getDuration());
                    MF.FC.findBufferByID("0000000000000000",MF.SD.serverIP,MF.SD.SERVER_PORT).addFrame(IPS2);
                }
                
                MF.doRefreshButton();
                MF.stopAlarm(alarmID);
                JOptionPane.showMessageDialog(this, "User note has been recorded");
                dispose();
                
                /*HTSC = new HydeTCPSocketClient(TMS2.serverIP, TMS2.SERVER_PORT);
                byte[] b = HydeCrypto.concat(new byte[]{'C','E','A','S'}, "FIX".getBytes());
                b = HydeCrypto.concat(b, new byte[]{0x1f});
                b = HydeCrypto.concat(b, alarmID.getBytes());
                b = HydeCrypto.concat(b, new byte[]{0x1f});
                b = HydeCrypto.concat(b, TMS2.logInUsername.getBytes());
                b = HydeCrypto.concat(b, new byte[]{0x1f});
                b = HydeCrypto.concat(b, reason.getBytes());
                HTSC.setData(HydePacket.assemblyPacket(new byte[]{0x01},b));
                Thread T = new Thread(HTSC);
                T.start();

                LoadingDialog LD = new LoadingDialog(this, "Syncronizing...",true);
                HTSC.setLoadingDialog(LD);
                if (!HTSC.success)
                {
                    JOptionPane.showMessageDialog(this, "Cannot connect back to server...", "TMS", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //dispose();
                }*/
            }
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }



}
