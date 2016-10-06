package HydeModule.Protocol;


public class LoadingDialog extends javax.swing.JDialog
{

    public LoadingDialog(javax.swing.JDialog parent, String message, boolean b)
    {
        super(parent,b);
        initComponents();
        messageLabel.setText(message);
        //cancelButton.addActionListener(this);
        //setLocationRelativeTo(null);
        //setAlwaysOnTop(true);
        //setModal(true);
        //setVisible(true);
    }

    public LoadingDialog(javax.swing.JFrame parent, String message, boolean b)
    {
        super(parent,b);
        initComponents();
        messageLabel.setText(message);
        //cancelButton.addActionListener(this);
        //setLocationRelativeTo(null);
        //setAlwaysOnTop(true);
        //setModal(true);
        //setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connecting...");
        setAlwaysOnTop(true);

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addGap(11, 11, 11)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setMessage(String message)
    {
        messageLabel.setText(message);
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel messageLabel;
    public javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables


  /*  public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == cancelButton)
        {
            if (HSC != null)
            {
                HSC.endConnection();
            }
        }
    }*/


}
