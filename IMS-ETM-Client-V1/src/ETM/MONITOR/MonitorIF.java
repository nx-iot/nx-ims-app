/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DeviceManagementIF.java
 *
 * Created on Jun 1, 2012, 7:55:10 PM
 */

package ETM.MONITOR;

import ETM.LOG.PANEL.CommuLogPanel;
import ETM.LOG.PANEL.ModifyLogPanel;
import ETM.MAIN.MainFrame;
import ETM.MONITOR.PANEL.FloorplanManagementPanel;
import ETM.MONITOR.PANEL.FloorplanPanel;
import ETM.MONITOR.PANEL.GraphDisplayPanel;
import ETM.MONITOR.PANEL.MonthlyReportPanel;
import ETM.MONITOR.PANEL.TableDisplayPanel;
import ETM.STRUCTURE.Balloon;
import ETM.STRUCTURE.FloorPlanIndex;
import ETM.STRUCTURE.Zone;
import HydeModule.GraphEngine.GraphPanel;
import HydeModule.GraphEngine.ScopeDriver;
import ETM.Util.HydeFormat;
import HydeModule.Table.HydeDataSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author Hyde
 */
public class MonitorIF extends javax.swing.JInternalFrame implements ActionListener
{
    public MainFrame MF;
    public FloorplanPanel FPP;
    public FloorplanManagementPanel FMP;
    public MonthlyReportPanel MRP;

    public GraphDisplayPanel GDP;
    public TableDisplayPanel TDP;

    public CommuLogPanel CLP;
    public ModifyLogPanel MLP;
    public MonitorClock MC;

    public Vector<FloorPlanIndex> floorPlanData;
    public String department;

    public Vector<ScopeDriver> VSD;
    public GraphPanel GP;

    public MonitorIF(MainFrame MF)
    {
        this.MF = MF;
        initComponents();
        extendComponents();
        actionComponents();
        setVisible(true);

        MC = new MonitorClock(this);
        Thread T = new Thread(MC);
        T.start();
    }
    
    private void extendComponents()
    {
        if (!MF.SD.permissionViewFloorPlan.equals("1")) 
        {
            floorplanButton.setEnabled(false);
        }
        if (!MF.SD.permissionDataPresentation.equals("1")) 
        {
            graphButton.setEnabled(false);
            tableButton.setEnabled(false);
            monthlyButton.setEnabled(false);
        }
        if (!MF.SD.permissionManageHost.equals("1")) 
        {
            floorplanEditButton.setEnabled(false);
        }
        
        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/stats_16.png"));
        this.setFrameIcon(IC);

        floorPlanData = new Vector();
        floorPlanData.add(new FloorPlanIndex(0));

        /*if (any.charAt(0) == '0')
        {
            department = MF.HDC.query0("SELECT "
                    + "CONCAT(organization_name,' (',organization_id+0,')') "
                    + "FROM organization WHERE organization_id = '"+MF.SD.loginDepartment+"';");
            floorPlanData.elementAt(0).setDepartmentName(department);
        }
        else
        {
            department = "No organization selected...";
            floorPlanData.elementAt(0).setDepartmentName("No organization selected...");
        }*/

        VSD = new Vector<ScopeDriver>();
        GP = new GraphPanel();
        GP.enableGrid(true);
        GP.enableAxis(true);
        GP.enableLegend(true);
    }

    private void actionComponents()
    {
        floorplanButton.addActionListener(this);
        graphButton.addActionListener(this);
        tableButton.addActionListener(this);
        monthlyButton.addActionListener(this);
        floorplanEditButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        floorplanButton = new javax.swing.JButton();
        graphButton = new javax.swing.JButton();
        tableButton = new javax.swing.JButton();
        monthlyButton = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        floorplanEditButton = new javax.swing.JButton();
        workScroll = new javax.swing.JScrollPane();
        workPanel = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Monitoring");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar2.setMinimumSize(new java.awt.Dimension(40, 44));

        floorplanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/floorplan_32.png"))); // NOI18N
        floorplanButton.setToolTipText("Floor Plan");
        floorplanButton.setFocusable(false);
        floorplanButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        floorplanButton.setMaximumSize(new java.awt.Dimension(40, 42));
        floorplanButton.setMinimumSize(new java.awt.Dimension(40, 44));
        floorplanButton.setPreferredSize(new java.awt.Dimension(40, 44));
        floorplanButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(floorplanButton);

        graphButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/graph_32.png"))); // NOI18N
        graphButton.setToolTipText("Graph Report");
        graphButton.setFocusable(false);
        graphButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        graphButton.setMaximumSize(new java.awt.Dimension(40, 42));
        graphButton.setMinimumSize(new java.awt.Dimension(40, 44));
        graphButton.setPreferredSize(new java.awt.Dimension(40, 44));
        graphButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(graphButton);

        tableButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/table_32.png"))); // NOI18N
        tableButton.setToolTipText("Table Report");
        tableButton.setFocusable(false);
        tableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tableButton.setMaximumSize(new java.awt.Dimension(40, 42));
        tableButton.setMinimumSize(new java.awt.Dimension(40, 44));
        tableButton.setPreferredSize(new java.awt.Dimension(40, 44));
        tableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(tableButton);

        monthlyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/bar_32.png"))); // NOI18N
        monthlyButton.setToolTipText("Alarm Report");
        monthlyButton.setFocusable(false);
        monthlyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        monthlyButton.setMaximumSize(new java.awt.Dimension(40, 42));
        monthlyButton.setMinimumSize(new java.awt.Dimension(40, 44));
        monthlyButton.setPreferredSize(new java.awt.Dimension(40, 44));
        monthlyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(monthlyButton);

        buttonPanel.add(jToolBar2);

        jToolBar3.setRollover(true);
        jToolBar3.setMaximumSize(new java.awt.Dimension(30000, 42));
        jToolBar3.setMinimumSize(new java.awt.Dimension(40, 44));

        floorplanEditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/floorplan_edit_32.png"))); // NOI18N
        floorplanEditButton.setToolTipText("Floor Plan Management");
        floorplanEditButton.setFocusable(false);
        floorplanEditButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        floorplanEditButton.setMaximumSize(new java.awt.Dimension(40, 42));
        floorplanEditButton.setMinimumSize(new java.awt.Dimension(40, 44));
        floorplanEditButton.setPreferredSize(new java.awt.Dimension(40, 44));
        floorplanEditButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(floorplanEditButton);

        buttonPanel.add(jToolBar3);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.NORTH);

        workPanel.setLayout(new java.awt.GridLayout(1, 0));
        workScroll.setViewportView(workPanel);

        getContentPane().add(workScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        if (FPP != null && FPP.FEP != null & FPP.FEP.BOD != null) FPP.FEP.BOD.dispose();
    }//GEN-LAST:event_formInternalFrameClosed

    public Vector zoneVector;
    public void setZoneParameter()
    {
        try
        {
            zoneVector = new Vector();
            Vector zData = MF.HDC.queryAll("SELECT "
                    + "floor_zone_id, floor_zone_x1, floor_zone_y1, floor_zone_x2, floor_zone_y2, "
                    + "floorplan_id, organization_id, floor_zone.location_id, floorplan_name, location_name "
                    + "FROM floor_zone NATURAL JOIN floorplan LEFT JOIN location ON floor_zone.location_id "
                    + "WHERE floor_zone.location_id IS NULL OR floor_zone.location_id = location.location_id ;");
            HydeDataSet HDS = new HydeDataSet(zData);
            Vector data = HDS.getRowVector();

            Enumeration enu = data.elements();
            while (enu.hasMoreElements())
            {
                Vector zoneData = (Vector) enu.nextElement();
                Zone z = new Zone();
                z.setID((String) zoneData.elementAt(0));
                z.setX1(Integer.parseInt((String) zoneData.elementAt(1)));
                z.setY1(Integer.parseInt((String) zoneData.elementAt(2)));
                z.setX2(Integer.parseInt((String) zoneData.elementAt(3)));
                z.setY2(Integer.parseInt((String) zoneData.elementAt(4)));
                z.setFloorID((String) zoneData.elementAt(5));
                z.setOrganization((String) zoneData.elementAt(6));
                z.setLocationID((String) zoneData.elementAt(7));
                z.setFloorName((String) zoneData.elementAt(8));
                z.setLocationName((String) zoneData.elementAt(9));

                zoneVector.add(z);
            }
        }
        catch (Exception e)
        {

        }
    }

    public Vector alertSign;
    public Vector<Balloon> balloonVector;
    public void setBalloonParameter()
    {
        try
        {
            //updateBalloonStatus();
            alertSign = new Vector();
            balloonVector = new Vector();
            Vector bData;
            if (MF.SD.permissionCrossDepartment.equals("1"))
            {
                bData = MF.HDC.queryAll("SELECT "
                    + "balloon_id, balloon_x, balloon_y, floorplan_id, organization_id, "
                    + "balloon.device_id, floorplan_name, equipment_id, device_link "
                    + "FROM balloon NATURAL JOIN floorplan LEFT JOIN device ON balloon.device_id LEFT JOIN device_group ON device.device_group_id "
                    + "WHERE balloon.device_id IS NULL OR balloon.device_id = device.device_id "
                    + "AND (device.device_group_id = device_group.device_group_id OR device.device_group_id IS NULL)"
                    + ";");
            }
            else
            {
                bData = MF.HDC.queryAll("SELECT "
                    + "balloon_id, balloon_x, balloon_y, floorplan_id, organization_id, "
                    + "balloon.device_id, floorplan_name, equipment_id, device_link "
                    + "FROM balloon NATURAL JOIN floorplan LEFT JOIN device ON balloon.device_id LEFT JOIN device_group ON device.device_group_id "
                    + "WHERE balloon.device_id IS NULL OR balloon.device_id = device.device_id "
                    + "AND (device.device_group_id = device_group.device_group_id OR device.device_group_id IS NULL) "
                    + "AND (depart_id = '"+MF.SD.loginDepartment+"' OR depart_id IS NULL)"
                    + ";");
            }

                   //+ "floorplan_id = '"+floor+"'");

            HydeDataSet HDS = new HydeDataSet(bData);
            Vector data = HDS.getRowVector();

            Enumeration enu = data.elements();
            while (enu.hasMoreElements())
            {
                Vector rowData = (Vector) enu.nextElement();
                Balloon b = new Balloon();
                b.setID((String)rowData.elementAt(0));
                b.setX(Integer.parseInt((String)rowData.elementAt(1)));
                b.setY(Integer.parseInt((String)rowData.elementAt(2)));
                b.setFloorID((String)rowData.elementAt(3));
                b.setOrganization((String)rowData.elementAt(4));
                b.setDeviceID((String)rowData.elementAt(5));
                b.setFloorName((String) rowData.elementAt(6));
                b.setType((String) rowData.elementAt(7));
                b.setStatus((String) rowData.elementAt(8));
                /*if (rowData.elementAt(9) != null)
                {
                    b.setDepartment((String) rowData.elementAt(9));
                }
                else
                {
                    b.setDepartment("");
                }*/
                b.setAlarmType("0");

                if (b.getDeviceID() != null && b.getDeviceID().length() > 0)
                {
                    Vector v = MF.HDC.queryRow("SELECT user_fix, system_fix FROM alarm_current WHERE device_id = '"+b.getDeviceID()+"' ORDER by user_fix, system_fix ASC;");
                    if (v != null && v.size() >= 2)
                    {
                        if (v.elementAt(0).equals("1") && v.elementAt(1).equals("1")) // user && system
                        {
                            b.setAlarmType("0");
                        }
                        else if (v.elementAt(0).equals("1") && v.elementAt(1).equals("0"))
                        {
                            b.setAlarmType("1");
                        }
                        else if (v.elementAt(0).equals("0") && v.elementAt(1).equals("1"))
                        {
                            b.setAlarmType("2");
                        }
                        else if (v.elementAt(0).equals("0") && v.elementAt(1).equals("0"))
                        {
                            b.setAlarmType("3");
                        }
                    }
                }

                if (b.getType().equals("1"))//base
                {
                    Vector xy = MF.HDC.queryAll("SELECT balloon_x, balloon_y, equipment_id "
                            + "FROM balloon NATURAL JOIN device "
                            + "WHERE device_parent = '"+b.getDeviceID()+"' "
                            + "AND floorplan_id = '"+b.getFloorID()+"' "
                            + "AND organization_id = '"+b.getOrganization()+"';");
                    if (xy != null)
                    {
                        HydeDataSet HDSxy = new HydeDataSet(xy);
                        Vector rv = HDSxy.getRowVector();

                        Enumeration cenu = rv.elements();
                        while(cenu.hasMoreElements())
                        {
                            Vector rd = (Vector) cenu.nextElement();
                            b.addPoint((String)rd.elementAt(0), (String)rd.elementAt(1), (String)rd.elementAt(2));
                        }
                    }
                }

                //Balloon b = new Balloon(id, positionX, positionY, bfloor, bfloorName, department, deviceID, deviceType, alarmType);
                /*Vector v = MF.HDC.queryColumn("SELECT probe_id FROM probe WHERE device_id = '"+rowData.elementAt(5)+"';");
                if (v != null && v.size() >= 5)
                {
                    String[] s = new String[5];
                    for (int i=0; i<5;i++)
                    {
                        if (v.elementAt(i) != null)
                        {
                            s[i] = (String) v.elementAt(i);
                        }
                        else
                        {
                            s[i] = "";
                        }
                    }
                    b.setProbe(s);
                }*/
                balloonVector.add(b);
                String fn = b.getFloorName()+" ("+b.getFloorID()+")";
                if (b.getAlarmType().equals("3") && b.getOrganization().equals(HydeFormat.parseID(department)) && alertSign.indexOf(fn) == -1)
                {
                    alertSign.add(fn);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("MonitorIF/setBalloonParameter : Error \n"+e);
        }
    }

    public void close()
    {
        dispose();
        MC.stopClock();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton floorplanButton;
    private javax.swing.JButton floorplanEditButton;
    public javax.swing.JButton graphButton;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton monthlyButton;
    public javax.swing.JButton tableButton;
    private javax.swing.JPanel workPanel;
    private javax.swing.JScrollPane workScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == floorplanButton)
        {
            if (FPP == null)
            {
                FPP = new FloorplanPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(FPP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == floorplanEditButton)
        {
            if (FMP == null)
            {
                FMP = new FloorplanManagementPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(FMP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == tableButton)
        {
            if (TDP == null)
            {
                TDP = new TableDisplayPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(TDP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == graphButton)
        {
            if (GDP == null)
            {
                GDP = new GraphDisplayPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(GDP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
        else if (src == monthlyButton)
        {
            if (MRP == null)
            {
                MRP = new MonthlyReportPanel(this);
            }
            workPanel.removeAll();
            workPanel.add(MRP);
            workPanel.validate();
            workScroll.validate();
            workPanel.repaint();
        }
    }

}
