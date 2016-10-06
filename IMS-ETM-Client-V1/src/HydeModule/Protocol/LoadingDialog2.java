package HydeModule.Protocol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadingDialog2 extends javax.swing.JDialog implements ActionListener
{
    public int skip = 0;
    public LoadingDialog2(javax.swing.JDialog parent, String message, boolean b)
    {
        super(parent,b);
        initComponents();
        actionComponents();
        messageLabel.setText(message);
        //cancelButton.addActionListener(this);
        //setLocationRelativeTo(null);
        //setAlwaysOnTop(true);
        //setModal(true);
        //setVisible(true);
    }

    public LoadingDialog2(javax.swing.JFrame parent, String message, boolean b)
    {
        super(parent,b);
        initComponents();
        actionComponents();
        messageLabel.setText(message);
        //cancelButton.addActionListener(this);
        //setLocationRelativeTo(null);
        //setAlwaysOnTop(true);
        //setModal(true);
        //setVisible(true);
    }

    private void actionComponents()
    {
        skipButton.addActionListener(this);
        skipAllButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        skipAllButton = new javax.swing.JButton();
        skipButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connecting...");
        setAlwaysOnTop(true);

        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messageLabel.setText("message");

        skipAllButton.setText("Skip All");

        skipButton.setText("Skip");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addComponent(messageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(skipButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(skipAllButton)
                        .addGap(100, 100, 100))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addGap(11, 11, 11)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(skipButton)
                    .addComponent(skipAllButton))
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
    private javax.swing.JButton skipAllButton;
    private javax.swing.JButton skipButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == skipButton)
        {
            skip = 1;
            dispose();
        }
        else if (src == skipAllButton)
        {
            skip = 2;
            dispose();
        }
    }


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
