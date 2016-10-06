package ETM.MONITOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryDialog extends javax.swing.JDialog implements ActionListener//, Runnable
{
    public String message;
    public QueryThread qt;

    public QueryDialog(java.awt.Frame parent, String message, boolean b,QueryThread qt)
    {
        super(parent,b);
        this.message = message;
        this.qt = qt;
        initComponents();
        messageLabel.setText(message);
        //logoutButton.addActionListener(this);
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        messageLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connecting...");
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("message");

        messageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/loading.gif"))); // NOI18N

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(cancelButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(messageLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(messageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (qt.LD != null)
        {
            qt.LD.setModal(false);
        }
        if (qt.LD != null)
        {
            qt.LD.dispose();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    public void setMessage(String message)
    {
        messageLabel.setText(message);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton cancelButton;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel messageLabel1;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
    }

    public void run() 
    {
    }


}
