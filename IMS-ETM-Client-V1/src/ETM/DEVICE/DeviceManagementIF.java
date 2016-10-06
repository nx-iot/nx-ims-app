/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeviceManagementIF.java
 *
 * Created on Jun 1, 2012, 7:55:10 PM
 */

package ETM.DEVICE;

import ETM.DEVICE.PANEL.*;
import ETM.MAIN.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Hyde
 */
public class DeviceManagementIF extends javax.swing.JInternalFrame implements ActionListener
{
    public MainFrame MF;
    public DeviceResourceControl DRC;

    public DeviceListPanel DLP;
    public DeviceModifyPanel DMP;
    public DeviceGroupPanel DGP;
    public HostPanel HP;
    public LocationPanel LP;
    public DepartmentPanel DP;

    public DeviceManagementIF(MainFrame MF)
    {
        this.MF = MF;
        initComponents();
        extendComponents();
        actionComponents();
        setVisible(true);
    }
    
    private void extendComponents()
    {
        if (!MF.SD.permissionManageDepartment.equals("1")) 
        {
            departButton.setEnabled(false);
        }
        if (!MF.SD.permissionManageDevice.equals("1")) 
        {
            modifyButton.setEnabled(false);
            groupButton.setEnabled(false);
        }
        if (!MF.SD.permissionManageHost.equals("1")) 
        {
            hostButton.setEnabled(false);
            locationButton.setEnabled(false);
        }
        
        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/device_16.png"));
        this.setFrameIcon(IC);

        DRC = new DeviceResourceControl(this);
        DMP = new DeviceModifyPanel(this);
        DRC.buildDeviceTree("0","0","");

        DLP = new DeviceListPanel(this);
    }

    private void actionComponents()
    {
        listButton.addActionListener(this);
        groupButton.addActionListener(this);
        modifyButton.addActionListener(this);
        hostButton.addActionListener(this);
        locationButton.addActionListener(this);
        departButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        listButton = new javax.swing.JButton();
        groupButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        hostButton = new javax.swing.JButton();
        locationButton = new javax.swing.JButton();
        departButton = new javax.swing.JButton();
        workScroll = new javax.swing.JScrollPane();
        workPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Device Management");

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar2.setMinimumSize(new java.awt.Dimension(40, 44));

        listButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_list_32.png"))); // NOI18N
        listButton.setToolTipText("Device List");
        listButton.setFocusable(false);
        listButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listButton.setMaximumSize(new java.awt.Dimension(40, 42));
        listButton.setMinimumSize(new java.awt.Dimension(40, 44));
        listButton.setPreferredSize(new java.awt.Dimension(40, 44));
        listButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(listButton);

        groupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_group_32.png"))); // NOI18N
        groupButton.setToolTipText("Device Group");
        groupButton.setFocusable(false);
        groupButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        groupButton.setMaximumSize(new java.awt.Dimension(40, 42));
        groupButton.setMinimumSize(new java.awt.Dimension(40, 44));
        groupButton.setPreferredSize(new java.awt.Dimension(40, 44));
        groupButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(groupButton);

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_modify_32.png"))); // NOI18N
        modifyButton.setToolTipText("Device Configuration");
        modifyButton.setFocusable(false);
        modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyButton.setMaximumSize(new java.awt.Dimension(40, 42));
        modifyButton.setMinimumSize(new java.awt.Dimension(40, 44));
        modifyButton.setPreferredSize(new java.awt.Dimension(40, 44));
        modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(modifyButton);

        buttonPanel.add(jToolBar2);

        jToolBar3.setRollover(true);
        jToolBar3.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar3.setMinimumSize(new java.awt.Dimension(40, 44));

        hostButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/host.png"))); // NOI18N
        hostButton.setToolTipText("Host Management");
        hostButton.setFocusable(false);
        hostButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hostButton.setMaximumSize(new java.awt.Dimension(40, 42));
        hostButton.setMinimumSize(new java.awt.Dimension(40, 44));
        hostButton.setPreferredSize(new java.awt.Dimension(40, 44));
        hostButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(hostButton);

        locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/location_32.png"))); // NOI18N
        locationButton.setToolTipText("Location Management");
        locationButton.setFocusable(false);
        locationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        locationButton.setMaximumSize(new java.awt.Dimension(40, 42));
        locationButton.setMinimumSize(new java.awt.Dimension(40, 44));
        locationButton.setPreferredSize(new java.awt.Dimension(40, 44));
        locationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(locationButton);

        departButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/building_32.png"))); // NOI18N
        departButton.setToolTipText("Department Management");
        departButton.setFocusable(false);
        departButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        departButton.setMaximumSize(new java.awt.Dimension(40, 42));
        departButton.setMinimumSize(new java.awt.Dimension(40, 44));
        departButton.setPreferredSize(new java.awt.Dimension(40, 44));
        departButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(departButton);

        buttonPanel.add(jToolBar3);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.NORTH);

        workPanel.setLayout(new java.awt.GridLayout(1, 0));
        workScroll.setViewportView(workPanel);

        getContentPane().add(workScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton departButton;
    private javax.swing.JButton groupButton;
    private javax.swing.JButton hostButton;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton listButton;
    private javax.swing.JButton locationButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JScrollPane workScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == listButton)
        {
            workPanel.removeAll();
            workPanel.add(DLP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == modifyButton)
        {
            workPanel.removeAll();
            workPanel.add(DMP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == groupButton)
        {
            if (DGP == null)
            {
                DGP = new DeviceGroupPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(DGP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == hostButton)
        {
            if (HP == null)
            {
                HP = new HostPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(HP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == locationButton)
        {
            if (LP == null)
            {
                LP = new LocationPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(LP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == departButton)
        {
            if (DP == null)
            {
                DP = new DepartmentPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(DP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
    }

}
