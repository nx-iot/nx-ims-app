/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserManagementIF.java
 *
 * Created on May 29, 2012, 10:35:34 AM
 */

package ETM.USER;

import ETM.MAIN.MainFrame;
import ETM.USER.PANEL.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class UserManagementIF extends javax.swing.JInternalFrame implements ActionListener
{
    public MainFrame MF;

    public AccountPanel AP;
    public MyAccountPanel MP;
    public PermissionPanel PP;
    public SMSPanel SP;
    public EmailPanel EP;

    public UserManagementIF(MainFrame MF)
    {
        this.MF = MF;
        initComponents();
        extendComponents();
        actionComponents();
        setVisible(true);
    }

    private void extendComponents()
    {
        if (!MF.SD.permissionManageUser.equals("1")) 
        {
            accountButton.setEnabled(false);
            permissionButton.setEnabled(false);
        }
        if (!MF.SD.permissionManageMessage.equals("1")) 
        {
            smsButton.setEnabled(false);
            emailButton.setEnabled(false);
        }
        
        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/user_16.png"));
        this.setFrameIcon(IC);
        setPermission();
    }

    private void actionComponents()
    {
        myButton.addActionListener(this);
        accountButton.addActionListener(this);
        permissionButton.addActionListener(this);
        smsButton.addActionListener(this);
        emailButton.addActionListener(this);
    }

    private void setPermission()
    {
        if (MF.SD.permissionManageUser.equals("0"))
        {
            accountButton.setEnabled(false);
            permissionButton.setEnabled(false);
        }
        else if (MF.SD.permissionManageMessage.equals("0"))
        {
            smsButton.setEnabled(false);
            emailButton.setEnabled(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        myButton = new javax.swing.JButton();
        accountButton = new javax.swing.JButton();
        permissionButton = new javax.swing.JButton();
        smsButton = new javax.swing.JButton();
        emailButton = new javax.swing.JButton();
        workScroll = new javax.swing.JScrollPane();
        workPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("User Management");

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar2.setMinimumSize(new java.awt.Dimension(40, 44));
        jToolBar2.setPreferredSize(new java.awt.Dimension(40, 44));

        myButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/my_account_32.png"))); // NOI18N
        myButton.setToolTipText("My account");
        myButton.setFocusable(false);
        myButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myButton.setMaximumSize(new java.awt.Dimension(40, 42));
        myButton.setMinimumSize(new java.awt.Dimension(40, 44));
        myButton.setPreferredSize(new java.awt.Dimension(40, 44));
        myButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(myButton);

        accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/account_32.png"))); // NOI18N
        accountButton.setToolTipText("Account Management");
        accountButton.setFocusable(false);
        accountButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accountButton.setMaximumSize(new java.awt.Dimension(40, 42));
        accountButton.setMinimumSize(new java.awt.Dimension(40, 44));
        accountButton.setPreferredSize(new java.awt.Dimension(40, 44));
        accountButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(accountButton);

        permissionButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/permission_32.png"))); // NOI18N
        permissionButton.setToolTipText("Permission Management");
        permissionButton.setFocusable(false);
        permissionButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        permissionButton.setMaximumSize(new java.awt.Dimension(40, 42));
        permissionButton.setMinimumSize(new java.awt.Dimension(40, 44));
        permissionButton.setPreferredSize(new java.awt.Dimension(40, 44));
        permissionButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(permissionButton);

        smsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/sms_32.png"))); // NOI18N
        smsButton.setToolTipText("SMS Management");
        smsButton.setFocusable(false);
        smsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        smsButton.setMaximumSize(new java.awt.Dimension(40, 42));
        smsButton.setMinimumSize(new java.awt.Dimension(40, 44));
        smsButton.setPreferredSize(new java.awt.Dimension(40, 44));
        smsButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(smsButton);

        emailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/email32.png"))); // NOI18N
        emailButton.setToolTipText("Mail Management");
        emailButton.setFocusable(false);
        emailButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        emailButton.setMaximumSize(new java.awt.Dimension(40, 42));
        emailButton.setMinimumSize(new java.awt.Dimension(40, 44));
        emailButton.setPreferredSize(new java.awt.Dimension(40, 44));
        emailButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(emailButton);

        buttonPanel.add(jToolBar2);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.NORTH);

        workPanel.setLayout(new java.awt.GridLayout(1, 0));
        workScroll.setViewportView(workPanel);

        getContentPane().add(workScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton emailButton;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton myButton;
    private javax.swing.JButton permissionButton;
    private javax.swing.JButton smsButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JScrollPane workScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == myButton)
        {
            MP = new MyAccountPanel(this);
            workPanel.removeAll();
            workPanel.add(MP);
            workPanel.validate();
            workScroll.validate();
        }
        else if(src == accountButton)
        {
            AP = new AccountPanel(this);
            workPanel.removeAll();
            workPanel.add(AP);
            workPanel.validate();
            workScroll.validate();
        }
        else if(src == permissionButton)
        {
            PP = new PermissionPanel(this);
            workPanel.removeAll();
            workPanel.add(PP);
            workPanel.validate();
            workScroll.validate();
        }
        else if(src == smsButton)
        {
            SP = new SMSPanel(this);
            workPanel.removeAll();
            workPanel.add(SP);
            workPanel.validate();
            workScroll.validate();
        }
        else if(src == emailButton)
        {
            EP = new EmailPanel(this);
            workPanel.removeAll();
            workPanel.add(EP);
            workPanel.validate();
            workScroll.validate();
        }
    }

}
