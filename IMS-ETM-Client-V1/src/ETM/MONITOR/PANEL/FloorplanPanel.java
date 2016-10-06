
/*
 * FloorplanPanel.java
 *
 * Created on Jun 12, 2012, 1:04:56 PM
 */

package ETM.MONITOR.PANEL;

import ETM.MONITOR.DIALOG.BalloonListDialog;
import ETM.MONITOR.MonitorIF;
import ETM.Util.HydeFormat;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;

public class FloorplanPanel extends javax.swing.JPanel implements ActionListener
{
    public MonitorIF MIF;
    public FloorplanEffectPanel FEP;

    public String floor = "";
    public String floorName = "";
    public int panelIndex;
    public String depart = "";

    private static String defaultdepartComboBox = "Select a department...";
    private static String defaultFloorComboBox = "Select a floor...";

    private String any = "11111";
    private int panelID = 0;

    public FloorplanPanel(MonitorIF MIF)
    {
        this.MIF = MIF;
        this.panelID = 0;
        initComponents();
        extendComponents();
        actionComponents();
    }

    public FloorplanPanel(MonitorIF MIF, int panelID)
    {
        this.MIF = MIF;
        this.panelID = panelID;
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setdepartComboBox();
        setFloorComboBox();
        MIF.setBalloonParameter();
        
        FEP = new FloorplanEffectPanel(this, (String)departComboBox.getSelectedItem());
        //floorScroll.add(FEP);
        //floorScroll.validate();
        floorScroll.setViewportView(FEP);
        panelIndex = 0;

    }

    private void actionComponents()
    {
        refreshButton.addActionListener(this);

        zoneToggleButton.addActionListener(this);
        linkToggleButton.addActionListener(this);
        balloonToggleButton.addActionListener(this);

        mapZoomToggleButton.addActionListener(this);
        balloonDetailButton.addActionListener(this);
        balloonEditButton.addActionListener(this);
        balloonAddButton.addActionListener(this);
        balloonDeleteButton.addActionListener(this);
        balloonSearchButton.addActionListener(this);
        plusButton.addActionListener(this);

        zoneDetailButton.addActionListener(this);
        zoneAddButton.addActionListener(this);
        zoneEditButton.addActionListener(this);
        zoneDeleteButton.addActionListener(this);

        departComboBox.addActionListener(this);
        floorComboBox.addActionListener(this);

        zoneToggleButton.doClick();
        linkToggleButton.doClick();
        balloonToggleButton.doClick();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        balloonMode = new javax.swing.ButtonGroup();
        locationMode = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        departComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        floorComboBox = new javax.swing.JComboBox();
        jToolBar4 = new javax.swing.JToolBar();
        plusButton = new javax.swing.JButton();
        floorScroll = new javax.swing.JScrollPane();
        optionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        refreshButton = new javax.swing.JButton();
        mapZoomToggleButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        scaleComboBox = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        balloonToggleButton = new javax.swing.JToggleButton();
        linkToggleButton = new javax.swing.JToggleButton();
        zoneToggleButton = new javax.swing.JToggleButton();
        reservedButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        balloonDetailButton = new javax.swing.JToggleButton();
        balloonEditButton = new javax.swing.JToggleButton();
        balloonAddButton = new javax.swing.JToggleButton();
        balloonDeleteButton = new javax.swing.JToggleButton();
        balloonSearchButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        zoneDetailButton = new javax.swing.JToggleButton();
        zoneEditButton = new javax.swing.JToggleButton();
        zoneAddButton = new javax.swing.JToggleButton();
        zoneDeleteButton = new javax.swing.JToggleButton();

        setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 26));
        jPanel4.setPreferredSize(new java.awt.Dimension(608, 26));

        jLabel2.setText("Deparment");

        departComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jLabel3.setText("Floor");

        floorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a floor..." }));

        jToolBar4.setRollover(true);

        plusButton.setText("+ New Window");
        plusButton.setFocusable(false);
        plusButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plusButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(plusButton);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(floorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(departComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(floorComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(318, 318, 318))
        );

        add(jPanel4, java.awt.BorderLayout.NORTH);

        floorScroll.setMinimumSize(new java.awt.Dimension(0, 0));
        floorScroll.setPreferredSize(new java.awt.Dimension(0, 0));
        add(floorScroll, java.awt.BorderLayout.CENTER);

        optionPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        optionPanel.setMaximumSize(new java.awt.Dimension(65530, 60));
        optionPanel.setMinimumSize(new java.awt.Dimension(0, 60));
        optionPanel.setPreferredSize(new java.awt.Dimension(530, 60));
        optionPanel.setLayout(new javax.swing.BoxLayout(optionPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Other"));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel3.setMinimumSize(new java.awt.Dimension(240, 60));
        jPanel3.setPreferredSize(new java.awt.Dimension(240, 60));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshButton.setToolTipText("Refresh Floor Plan");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(refreshButton);

        mapZoomToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/map_zoom_24.png"))); // NOI18N
        mapZoomToggleButton.setToolTipText("Zoom Map");
        mapZoomToggleButton.setFocusable(false);
        mapZoomToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mapZoomToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        mapZoomToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        mapZoomToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        mapZoomToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(mapZoomToggleButton);

        jLabel1.setText("x ");
        jToolBar3.add(jLabel1);

        scaleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "4" }));
        scaleComboBox.setToolTipText("Zoom Multiplier");
        scaleComboBox.setMaximumSize(new java.awt.Dimension(33, 20));
        scaleComboBox.setMinimumSize(new java.awt.Dimension(33, 20));
        scaleComboBox.setPreferredSize(new java.awt.Dimension(33, 20));
        jToolBar3.add(scaleComboBox);

        jSeparator1.setMinimumSize(new java.awt.Dimension(6, 0));
        jToolBar3.add(jSeparator1);

        balloonToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_map_24.png"))); // NOI18N
        balloonToggleButton.setToolTipText("Balloon layer ON/OFF");
        balloonToggleButton.setFocusable(false);
        balloonToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonToggleButton.setMaximumSize(new java.awt.Dimension(35, 30));
        balloonToggleButton.setMinimumSize(new java.awt.Dimension(35, 30));
        balloonToggleButton.setPreferredSize(new java.awt.Dimension(35, 30));
        balloonToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(balloonToggleButton);

        linkToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_link_24.png"))); // NOI18N
        linkToggleButton.setToolTipText("Link Layer ON/OFF");
        linkToggleButton.setFocusable(false);
        linkToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        linkToggleButton.setMaximumSize(new java.awt.Dimension(35, 30));
        linkToggleButton.setMinimumSize(new java.awt.Dimension(35, 30));
        linkToggleButton.setPreferredSize(new java.awt.Dimension(35, 30));
        linkToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(linkToggleButton);

        zoneToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/layers_24.png"))); // NOI18N
        zoneToggleButton.setToolTipText("Zone Layer ON/OFF");
        zoneToggleButton.setFocusable(false);
        zoneToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoneToggleButton.setMaximumSize(new java.awt.Dimension(35, 30));
        zoneToggleButton.setMinimumSize(new java.awt.Dimension(35, 30));
        zoneToggleButton.setPreferredSize(new java.awt.Dimension(35, 30));
        zoneToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(zoneToggleButton);

        reservedButton3.setEnabled(false);
        reservedButton3.setFocusable(false);
        reservedButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        reservedButton3.setMaximumSize(new java.awt.Dimension(10, 20));
        reservedButton3.setMinimumSize(new java.awt.Dimension(10, 20));
        reservedButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(reservedButton3);

        jPanel3.add(jToolBar3);

        optionPanel.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Balloon Mode"));
        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel2.setMinimumSize(new java.awt.Dimension(180, 60));
        jPanel2.setPreferredSize(new java.awt.Dimension(180, 60));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        balloonMode.add(balloonDetailButton);
        balloonDetailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_24.png"))); // NOI18N
        balloonDetailButton.setSelected(true);
        balloonDetailButton.setToolTipText("Balloon Info Mode");
        balloonDetailButton.setFocusable(false);
        balloonDetailButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonDetailButton.setMaximumSize(new java.awt.Dimension(40, 25));
        balloonDetailButton.setMinimumSize(new java.awt.Dimension(40, 25));
        balloonDetailButton.setPreferredSize(new java.awt.Dimension(40, 25));
        balloonDetailButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(balloonDetailButton);

        balloonMode.add(balloonEditButton);
        balloonEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_edit_24.png"))); // NOI18N
        balloonEditButton.setToolTipText("Balloon Modify Mode");
        balloonEditButton.setFocusable(false);
        balloonEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonEditButton.setMaximumSize(new java.awt.Dimension(35, 25));
        balloonEditButton.setMinimumSize(new java.awt.Dimension(35, 25));
        balloonEditButton.setPreferredSize(new java.awt.Dimension(35, 25));
        balloonEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(balloonEditButton);

        balloonMode.add(balloonAddButton);
        balloonAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_add_24.png"))); // NOI18N
        balloonAddButton.setToolTipText("Add New Balloon");
        balloonAddButton.setFocusable(false);
        balloonAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonAddButton.setMaximumSize(new java.awt.Dimension(35, 25));
        balloonAddButton.setMinimumSize(new java.awt.Dimension(35, 25));
        balloonAddButton.setPreferredSize(new java.awt.Dimension(35, 25));
        balloonAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(balloonAddButton);

        balloonMode.add(balloonDeleteButton);
        balloonDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_delete_24.png"))); // NOI18N
        balloonDeleteButton.setToolTipText("Delete Balloon Mode");
        balloonDeleteButton.setFocusable(false);
        balloonDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonDeleteButton.setMaximumSize(new java.awt.Dimension(35, 25));
        balloonDeleteButton.setMinimumSize(new java.awt.Dimension(35, 25));
        balloonDeleteButton.setPreferredSize(new java.awt.Dimension(35, 25));
        balloonDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(balloonDeleteButton);

        balloonSearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/balloon_zoom_24.png"))); // NOI18N
        balloonSearchButton.setToolTipText("Balloon Search");
        balloonSearchButton.setFocusable(false);
        balloonSearchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        balloonSearchButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(balloonSearchButton);

        jPanel2.add(jToolBar1);

        optionPanel.add(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Location Mode"));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(140, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(140, 60));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setBorder(null);
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        locationMode.add(zoneDetailButton);
        zoneDetailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/zone_24.png"))); // NOI18N
        zoneDetailButton.setToolTipText("Location Info Mode");
        zoneDetailButton.setFocusable(false);
        zoneDetailButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoneDetailButton.setMaximumSize(new java.awt.Dimension(40, 25));
        zoneDetailButton.setMinimumSize(new java.awt.Dimension(40, 25));
        zoneDetailButton.setPreferredSize(new java.awt.Dimension(40, 25));
        zoneDetailButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(zoneDetailButton);

        locationMode.add(zoneEditButton);
        zoneEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/zone_edit_24.png"))); // NOI18N
        zoneEditButton.setToolTipText("Location Modify Mode");
        zoneEditButton.setFocusable(false);
        zoneEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoneEditButton.setMaximumSize(new java.awt.Dimension(35, 25));
        zoneEditButton.setMinimumSize(new java.awt.Dimension(35, 25));
        zoneEditButton.setPreferredSize(new java.awt.Dimension(35, 25));
        zoneEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(zoneEditButton);

        locationMode.add(zoneAddButton);
        zoneAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/zone_add_24.png"))); // NOI18N
        zoneAddButton.setToolTipText("Add New Location");
        zoneAddButton.setFocusable(false);
        zoneAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoneAddButton.setMaximumSize(new java.awt.Dimension(35, 25));
        zoneAddButton.setMinimumSize(new java.awt.Dimension(35, 25));
        zoneAddButton.setPreferredSize(new java.awt.Dimension(35, 25));
        zoneAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(zoneAddButton);

        locationMode.add(zoneDeleteButton);
        zoneDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/zone_delete_24.png"))); // NOI18N
        zoneDeleteButton.setToolTipText("Delete Location Mode");
        zoneDeleteButton.setFocusable(false);
        zoneDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zoneDeleteButton.setMaximumSize(new java.awt.Dimension(35, 25));
        zoneDeleteButton.setMinimumSize(new java.awt.Dimension(35, 25));
        zoneDeleteButton.setPreferredSize(new java.awt.Dimension(35, 25));
        zoneDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(zoneDeleteButton);

        jPanel1.add(jToolBar2);

        optionPanel.add(jPanel1);

        add(optionPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    public void setdepartComboBox()
    {
        departComboBox.removeAllItems();
        if (any.charAt(1) == '1')
        {
            departComboBox.addItem(defaultdepartComboBox);
            Vector v = MIF.MF.HDC.queryRow("SELECT "
                    + "CONCAT(depart_name,' (',depart_id+0,')') "
                    + "FROM department;");
            if (v != null)
            {
                Enumeration enu = v.elements();
                while (enu.hasMoreElements())
                {
                    departComboBox.addItem(enu.nextElement());
                }
            }
        }
        else
        {
           departComboBox.addItem(MIF.MF.HDC.query0("SELECT "
                    + "CONCAT(depart_name,' (',depart_id+0,')') "
                    + "FROM department WHERE depart_id = '"+MIF.MF.SD.loginDepartment+"';"));
        }
    }

    public void setFloorComboBox()
    {
        floorComboBox.removeAllItems();
        if (departComboBox.getSelectedItem() != null)
        {
            String dep = HydeFormat.parseID((String)departComboBox.getSelectedItem());
            floorComboBox.addItem(defaultFloorComboBox);
            Vector v = MIF.MF.HDC.queryRow("SELECT "
                + "CONCAT(floorplan_name,' (',floorplan_id+0,')') "
                + "FROM floorplan "
                + "WHERE depart_id = '"+dep+"'"
                + ";");
            if (v != null)
            {
                Enumeration enu = v.elements();
                while (enu.hasMoreElements())
                {
                    floorComboBox.addItem(enu.nextElement());
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton balloonAddButton;
    private javax.swing.JToggleButton balloonDeleteButton;
    public javax.swing.JToggleButton balloonDetailButton;
    private javax.swing.JToggleButton balloonEditButton;
    private javax.swing.ButtonGroup balloonMode;
    private javax.swing.JButton balloonSearchButton;
    private javax.swing.JToggleButton balloonToggleButton;
    public javax.swing.JComboBox departComboBox;
    public javax.swing.JComboBox floorComboBox;
    public javax.swing.JScrollPane floorScroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToggleButton linkToggleButton;
    private javax.swing.ButtonGroup locationMode;
    private javax.swing.JToggleButton mapZoomToggleButton;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton plusButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton reservedButton3;
    public javax.swing.JComboBox scaleComboBox;
    private javax.swing.JToggleButton zoneAddButton;
    private javax.swing.JToggleButton zoneDeleteButton;
    public javax.swing.JToggleButton zoneDetailButton;
    private javax.swing.JToggleButton zoneEditButton;
    private javax.swing.JToggleButton zoneToggleButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == balloonAddButton)
        {
            FEP.setBalloonMode(1);
        }
        else if (src == balloonDeleteButton)
        {
            FEP.setBalloonMode(2);
        }
        else if (src == balloonDetailButton)
        {
            FEP.setBalloonMode(0);
        }
        else if (src == balloonEditButton)
        {
            FEP.setBalloonMode(3);
        }
        else if (src == zoneAddButton)
        {
            FEP.setZoneMode(1);
        }
        else if (src == zoneDeleteButton)
        {
            FEP.setZoneMode(2);
        }
        else if (src == zoneDetailButton)
        {
            FEP.setZoneMode(0);
        }
        else if (src == zoneEditButton)
        {
            FEP.setZoneMode(3);
        }
        else if (src == balloonSearchButton)
        {
            BalloonListDialog BLD = new BalloonListDialog(this);
        }
        else if (src == mapZoomToggleButton)
        {
            if (mapZoomToggleButton.isSelected())
            {
                //FEP.setScale(Integer.parseInt((String)scaleComboBox.getSelectedItem()));
                FEP.enableLayer(0, true);
            }
            else
            {
                //mapPanel.removeAll();
                //mapPanel.add(FEP);
                scaleComboBox.setEnabled(true);
                FEP.setScale(1);
                FEP.setPreferredSize(new Dimension(550,550));
                FEP.validate();
                floorScroll.getViewport().setViewPosition(new Point(0,0));
                floorScroll.validate();

                FEP.fullSize = false;
                FEP.enableLayer(0, false);
                FEP.repaint();
            }
        }
        else if (src == linkToggleButton)
        {
            if (linkToggleButton.isSelected()) FEP.enableLayer(1, true);
            else FEP.enableLayer(1, false);
        }
        else if (src == balloonToggleButton)
        {
            if (balloonToggleButton.isSelected()) FEP.enableLayer(2, true);
            else FEP.enableLayer(2, false);
        }
        else if (src == zoneToggleButton)
        {
            if (zoneToggleButton.isSelected()) FEP.enableLayer(4, true);
            else FEP.enableLayer(4, false);
        }
        else if (src == refreshButton)
        {
            FEP.FPP.MIF.setBalloonParameter();
            FEP.repaint();
        }
        else if (src == departComboBox && departComboBox.getSelectedItem() != null)
        {
            setFloorComboBox();
            MIF.floorPlanData.elementAt(panelIndex).setDepartmentName((String) departComboBox.getSelectedItem());
            depart = MIF.floorPlanData.elementAt(panelIndex).getDepartmentName();
        }
        else if (src == plusButton)
        {
            FloorPlanPlus FPP = new FloorPlanPlus(MIF.MF, (String) floorComboBox.getSelectedItem());
        }
        if (src == floorComboBox)
        {
            MIF.floorPlanData.elementAt(0).setFloorIndex(floorComboBox.getSelectedIndex());
            if (floorComboBox.getSelectedItem() != null)
            {
                if (floorComboBox.getSelectedItem().equals(defaultFloorComboBox))
                {
                    FEP.blankPage = true;
                    balloonDetailButton.doClick();
                    MIF.floorPlanData.elementAt(0).setFloorName("No plan selected...");
                }
                else
                {
                    FEP.blankPage = false;
                    balloonDetailButton.doClick();
                    MIF.floorPlanData.elementAt(panelIndex).setFloorID(HydeFormat.parseID((String) floorComboBox.getSelectedItem()));
                    MIF.floorPlanData.elementAt(panelIndex).setFloorName((String) floorComboBox.getSelectedItem());
                    floor = MIF.floorPlanData.elementAt(panelIndex).getFloorID();
                    floorName = MIF.floorPlanData.elementAt(panelIndex).getFloorName();
                    MIF.setZoneParameter();
                    MIF.setBalloonParameter();
                    FEP.repaint();
                }
            }
        }
    }

}
