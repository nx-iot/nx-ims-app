/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeviceManagementIF.java
 *
 * Created on Jun 1, 2012, 7:55:10 PM
 */

package ETM.LOG;

import ETM.DEVICE.DeviceResourceControl;
import ETM.LOG.PANEL.*;
import ETM.MAIN.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class LogManagementIF extends javax.swing.JInternalFrame implements ActionListener
{
    public MainFrame MF;
    public DeviceResourceControl DRC;

    public CurrentAlarmLogPanel CAP;
    public AlarmLogPanel ALP;
    public CommuLogPanel CLP;
    public ModifyLogPanel MLP;
    public UserLogPanel ULP;
    public SMSLogPanel SLP;
    public EmailLogPanel ELP;

    public LogManagementIF(MainFrame MF)
    {
        this.MF = MF;
        initComponents();
        extendComponents();
        actionComponents();
        setVisible(true);
    }
    
    private void extendComponents()
    {
        if (!MF.SD.permissionViewLog.equals("1")) 
        {
            alarmingButton.setEnabled(false);
            alarmLogButton.setEnabled(false);
            commuLogButton.setEnabled(false);
            modifyLogButton.setEnabled(false);
            userLogButton.setEnabled(false);
            smsLogButton.setEnabled(false);
            mailLogButton.setEnabled(false);
        }
        
        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/database_16.png"));
        this.setFrameIcon(IC);
    }

    private void actionComponents()
    {
        alarmingButton.addActionListener(this);
        alarmLogButton.addActionListener(this);
        commuLogButton.addActionListener(this);
        modifyLogButton.addActionListener(this);
        userLogButton.addActionListener(this);
        databaseExportButton.addActionListener(this);
        smsLogButton.addActionListener(this);
        mailLogButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        alarmingButton = new javax.swing.JButton();
        alarmLogButton = new javax.swing.JButton();
        commuLogButton = new javax.swing.JButton();
        modifyLogButton = new javax.swing.JButton();
        userLogButton = new javax.swing.JButton();
        smsLogButton = new javax.swing.JButton();
        mailLogButton = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        databaseExportButton = new javax.swing.JButton();
        workScroll = new javax.swing.JScrollPane();
        workPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Database & Log ");

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar2.setMinimumSize(new java.awt.Dimension(40, 44));

        alarmingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarming_32.png"))); // NOI18N
        alarmingButton.setToolTipText("Currently Alarm");
        alarmingButton.setFocusable(false);
        alarmingButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmingButton.setMaximumSize(new java.awt.Dimension(40, 42));
        alarmingButton.setMinimumSize(new java.awt.Dimension(40, 44));
        alarmingButton.setPreferredSize(new java.awt.Dimension(40, 44));
        alarmingButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(alarmingButton);

        alarmLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/log_alarm_32.png"))); // NOI18N
        alarmLogButton.setToolTipText("Alarm Log");
        alarmLogButton.setFocusable(false);
        alarmLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        alarmLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        alarmLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        alarmLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(alarmLogButton);

        commuLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/log_commu_32.png"))); // NOI18N
        commuLogButton.setToolTipText("Communication State Log");
        commuLogButton.setFocusable(false);
        commuLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        commuLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        commuLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        commuLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        commuLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(commuLogButton);

        modifyLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/log_modify.png"))); // NOI18N
        modifyLogButton.setToolTipText("Modify Log");
        modifyLogButton.setFocusable(false);
        modifyLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        modifyLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        modifyLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        modifyLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(modifyLogButton);

        userLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/book_user_32.png"))); // NOI18N
        userLogButton.setToolTipText("User Log");
        userLogButton.setFocusable(false);
        userLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        userLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        userLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        userLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(userLogButton);

        smsLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/book_sms.png"))); // NOI18N
        smsLogButton.setToolTipText("SMS log");
        smsLogButton.setFocusable(false);
        smsLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        smsLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        smsLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        smsLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        smsLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(smsLogButton);

        mailLogButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/book_email.png"))); // NOI18N
        mailLogButton.setToolTipText("Mail log");
        mailLogButton.setFocusable(false);
        mailLogButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mailLogButton.setMaximumSize(new java.awt.Dimension(40, 42));
        mailLogButton.setMinimumSize(new java.awt.Dimension(40, 44));
        mailLogButton.setPreferredSize(new java.awt.Dimension(40, 44));
        mailLogButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(mailLogButton);

        buttonPanel.add(jToolBar2);

        jToolBar3.setRollover(true);
        jToolBar3.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar3.setMinimumSize(new java.awt.Dimension(40, 44));

        databaseExportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/database_export_32.png"))); // NOI18N
        databaseExportButton.setToolTipText("Export Database");
        databaseExportButton.setEnabled(false);
        databaseExportButton.setFocusable(false);
        databaseExportButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        databaseExportButton.setMaximumSize(new java.awt.Dimension(40, 42));
        databaseExportButton.setMinimumSize(new java.awt.Dimension(40, 44));
        databaseExportButton.setPreferredSize(new java.awt.Dimension(40, 44));
        databaseExportButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(databaseExportButton);

        buttonPanel.add(jToolBar3);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.NORTH);

        workPanel.setLayout(new java.awt.GridLayout(1, 0));
        workScroll.setViewportView(workPanel);

        getContentPane().add(workScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alarmLogButton;
    private javax.swing.JButton alarmingButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton commuLogButton;
    private javax.swing.JButton databaseExportButton;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton mailLogButton;
    private javax.swing.JButton modifyLogButton;
    private javax.swing.JButton smsLogButton;
    private javax.swing.JButton userLogButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JScrollPane workScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == alarmingButton)
        {
            if (CAP == null)
            {
                CAP = new CurrentAlarmLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(CAP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == alarmLogButton)
        {
            if (ALP == null)
            {
                ALP = new AlarmLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(ALP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == commuLogButton)
        {
            if (CLP == null)
            {
                CLP = new CommuLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(CLP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == modifyLogButton)
        {
            if (MLP == null)
            {
                MLP = new ModifyLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(MLP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == userLogButton)
        {
            if (ULP == null)
            {
                ULP = new UserLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(ULP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == smsLogButton)
        {
            if (SLP == null)
            {
                SLP = new SMSLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(SLP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == mailLogButton)
        {
            if (ELP == null)
            {
                ELP = new EmailLogPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(ELP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
    }

}
