package ETM.MAIN.DIALOG;

import ETM.MAIN.LoginFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NewPasswordDialog extends javax.swing.JDialog implements ActionListener, KeyListener
{
    private LoginFrame LF;
    private String username;

    public NewPasswordDialog(LoginFrame LF, String username)
    {
        super(LF, true);
        this.LF = LF;
        this.username = username;
        initComponents();
        extendComponents();
        actionComponents();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        
    }

    private void actionComponents()
    {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);

        passField.addKeyListener(this);
        passField2.addKeyListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        check1Icon = new javax.swing.JLabel();
        check2Icon = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        passField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enter new password");
        setAlwaysOnTop(true);

        jLabel1.setText("New Password");

        jLabel2.setText("Confirm Password");

        check1Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N

        check2Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/neutral_16.png"))); // NOI18N

        cancelButton.setText("Cancel");

        okButton.setText("OK");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setText("*Must be more than 8 charactors");

        passField.setDocument(new ETM.Util.HydeJTextFieldLimit(20,0));

        passField2.setDocument(new ETM.Util.HydeJTextFieldLimit(20,0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passField2)
                                    .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check1Icon)
                            .addComponent(check2Icon)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(check1Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check2Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel check1Icon;
    private javax.swing.JLabel check2Icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passField;
    private javax.swing.JPasswordField passField2;
    // End of variables declaration//GEN-END:variables

    private ImageIcon OK = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    private ImageIcon NO = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));

    public void checkInputPassword()
    {
        if (passField.getText().length() >= 8)
        {
            check1Icon.setIcon(OK);
        }
        else
        {
            check1Icon.setIcon(NO);
        }
        if (passField.getText().equals(passField2.getText()) && passField2.getText().length() >= 8)
        {
            check2Icon.setIcon(OK);
        }
        else
        {
            check2Icon.setIcon(NO);
        }
    }

    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e)
    {
        Object src = e.getSource();
        if (src == passField || src == passField2)
        {
            checkInputPassword();
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == okButton)
        {
            if (passField.getText().equals(passField2.getText()) && passField2.getText().length() >= 8)
            {
                JOptionPane.showMessageDialog(this, "Your password has been set.","Password Reset",JOptionPane.QUESTION_MESSAGE);
                LF.setNewPassword(username, passField.getText());
                dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong input password...", "Reset Password", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }

}
