package ETM.LOG.PANEL;

import ETM.LOG.LogManagementIF;
import ETM.Util.HydeFormat;
import HydeModule.Table.HydeDataSet;
import HydeModule.Table.HydeTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class AlarmLogPanel extends javax.swing.JPanel implements ActionListener, MouseListener
{
    public LogManagementIF LMIF;

    public JDateChooser JDC1;
    public JDateChooser JDC2;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultDeviceGroupComboBox = "Select a group...";
    

    public AlarmLogPanel(LogManagementIF LMIF)
    {
        this.LMIF = LMIF;
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        JCalendar JC = new JCalendar();
        JDC1 = new JDateChooser();
        JDC2 = new JDateChooser();

        Date defaultDate = new Date();
        defaultDate.setTime(defaultDate.getTime()-(86400*7*1000));
        JDC1.setDate(defaultDate);

        Date d = new Date();
        JDC2.setDate(d);

        fromCalendar.add(JDC1);
        toCalendar.add(JDC2);

        setDepartmentComboBox();
        updateTable();
    }

    private void actionComponents()
    {
        userFixCheckBox.addActionListener(this);
        systemFixCheckBox.addActionListener(this);
        refreshButton.addActionListener(this);
        exportButton.addActionListener(this);

        departmentComboBox.addActionListener(this);
        deviceGroupComboBox.addActionListener(this);

        summaryTable.addMouseListener(this);
        alertTable.addMouseListener(this);
        warningTable.addMouseListener(this);
        eventTable.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deviceStatusTabPane = new javax.swing.JTabbedPane();
        summaryTab = new javax.swing.JPanel();
        summaryTableScroll = new javax.swing.JScrollPane();
        summaryTable = new javax.swing.JTable();
        alertTab = new javax.swing.JPanel();
        alertTableScroll = new javax.swing.JScrollPane();
        alertTable = new javax.swing.JTable();
        warningTab = new javax.swing.JPanel();
        warningTableScroll = new javax.swing.JScrollPane();
        warningTable = new javax.swing.JTable();
        eventTab = new javax.swing.JPanel();
        eventTableScroll = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        groupPanel = new javax.swing.JPanel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        groupLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        jToolBar1 = new javax.swing.JToolBar();
        refreshButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        viewPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fromCalendar = new javax.swing.JPanel();
        toCalendar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userFixCheckBox = new javax.swing.JCheckBox();
        systemFixCheckBox = new javax.swing.JCheckBox();

        deviceStatusTabPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Change(evt);
            }
        });

        summaryTab.setLayout(new java.awt.GridLayout(1, 0));

        summaryTable.setAutoCreateRowSorter(true);
        summaryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alarm ID", "Alarm Type", "Status", "Alarm-Time", "Recover-Time", "Comment"
            }
        ));
        summaryTableScroll.setViewportView(summaryTable);
        summaryTable.getColumnModel().getColumn(1).setHeaderValue("Alarm Type");

        summaryTab.add(summaryTableScroll);

        deviceStatusTabPane.addTab("Summary", summaryTab);

        alertTab.setLayout(new java.awt.GridLayout(1, 0));

        alertTable.setAutoCreateRowSorter(true);
        alertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alarm ID", "Status", "Alarm-Time", "Recover-Time", "Comment"
            }
        ));
        alertTableScroll.setViewportView(alertTable);

        alertTab.add(alertTableScroll);

        deviceStatusTabPane.addTab("Alert", alertTab);

        warningTab.setLayout(new java.awt.GridLayout(1, 0));

        warningTable.setAutoCreateRowSorter(true);
        warningTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alarm ID", "Status", "Alarm-Time", "Recover-Time", "Comment"
            }
        ));
        warningTableScroll.setViewportView(warningTable);

        warningTab.add(warningTableScroll);

        deviceStatusTabPane.addTab("Warning", warningTab);

        eventTab.setLayout(new java.awt.GridLayout(1, 0));

        eventTable.setAutoCreateRowSorter(true);
        eventTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alarm ID", "Status", "Alarm-Time", "Recover-Time", "Comment"
            }
        ));
        eventTableScroll.setViewportView(eventTable);

        eventTab.add(eventTableScroll);

        deviceStatusTabPane.addTab("Event", eventTab);

        groupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        groupLabel.setText("Device Group");

        departmentLabel.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        jToolBar1.setFloatable(false);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshButton.setToolTipText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(refreshButton);

        exportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/excel_16.png"))); // NOI18N
        exportButton.setToolTipText("Export to CSV");
        jToolBar1.add(exportButton);

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createSequentialGroup()
                .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(departmentComboBox)
            .addComponent(deviceGroupComboBox)
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(groupLabel))
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Filter : ");

        fromCalendar.setLayout(new java.awt.GridLayout(1, 0));

        toCalendar.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("to");

        jLabel5.setText("Date");

        userFixCheckBox.setText("User Fix");

        systemFixCheckBox.setText("System Fix");

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userFixCheckBox)
                .addGap(0, 0, 0)
                .addComponent(systemFixCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(fromCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(toCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(userFixCheckBox)
                .addComponent(jLabel1))
            .addComponent(systemFixCheckBox)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deviceStatusTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groupPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deviceStatusTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setDepartmentComboBox()
    {
        Enumeration enu;
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
        if (LMIF.MF.SD.permissionCrossDepartment.equals("1"))
        {
            departmentComboBox.addItem("All");
            enu = LMIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(LMIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+LMIF.MF.SD.loginDepartment+"';"));
        }
    }

    private void setDeviceGroupComboBox()
    {
        Enumeration enu;
        if (departmentComboBox.getSelectedItem() != null)
        {
            String department = (String) departmentComboBox.getSelectedItem();
            if (department.equals("All"))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = LMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group;").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else if (!department.equals(defaultDepartmentComboBox))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = LMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group WHERE depart_id = '"+HydeFormat.parseID(department)+"';").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
            }
        }
    }

    private void updateTable()
    {
        String groupFilter = "(FALSE";
        
        String depart = (String) departmentComboBox.getSelectedItem();
        String group = (String) deviceGroupComboBox.getSelectedItem();
        if (depart.equals("All"))
        {
            if (group.equals("All"))
            {
                groupFilter = "(TRUE";
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
            else
            {

            }
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            if (group.equals("All"))
            {
                depart = HydeFormat.parseID(depart);
                //groupFilter += " depart_id = '"+depart+"' ";
                Vector g = LMIF.MF.HDC.queryColumn("SELECT device_group_id FROM device_group WHERE depart_id = '"+depart+"';");
                if (g != null)
                {
                    Enumeration enu = g.elements();
                    while (enu.hasMoreElements())
                    {
                        String gid = (String)enu.nextElement();
                        groupFilter += " OR device_group_id = '"+gid+"' ";
                    }
                }
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
        }
        groupFilter += ") AND ";
        String selected = "(";
        if (userFixCheckBox.isSelected())
        {
            selected += "user_fix = '1' AND ";
        }
        if (systemFixCheckBox.isSelected())
        {
            selected += "system_fix = '1' AND ";
        }
        selected += "TRUE) AND ";
        Date f = JDC1.getDate();
        Date t = JDC2.getDate();
        String between = " (alarm_timestamp BETWEEN '"+LMIF.MF.HDC.formatDateTime(f)+"' AND '"+LMIF.MF.HDC.formatDateTime(t)+"')";
        if (deviceStatusTabPane.getSelectedIndex() == 0)
        {
           Vector v = LMIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_name AS 'Device', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device  "
                + "WHERE "+groupFilter+selected+between+" "
                /*+ "UNION "
                + "SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Device ID', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE "+between+""*/
                + ";");
           HydeDataSet HDS = new HydeDataSet(v);
           HDS.generateTable(summaryTable);
           summaryTab.repaint();
        }
        else if (deviceStatusTabPane.getSelectedIndex() == 1)
        {
           Vector v = LMIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_name AS 'Device', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE "+groupFilter+selected+between+" AND error_type = 'Alert' "
                /*+ "UNION "
                + "SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Device ID', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE error_type = 'Alert' "*/
                + ";");
           HydeDataSet HDS = new HydeDataSet(v);
           HDS.generateTable(alertTable);
        }
        else if (deviceStatusTabPane.getSelectedIndex() == 2)
        {
           Vector v = LMIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_name AS 'Device', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE "+groupFilter+selected+between+" AND error_type = 'Warning' "
                /*+ "UNION "
                + "SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Device ID', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE error_type = 'Warning' "*/
                + ";");
           HydeDataSet HDS = new HydeDataSet(v);
           HDS.generateTable(warningTable);
        }
        else if (deviceStatusTabPane.getSelectedIndex() == 3)
        {
           Vector v = LMIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_name AS 'Device', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE "+groupFilter+selected+between+" AND error_type = 'Event' "
                /*+ "UNION "
                + "SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Device ID', error_name AS 'Error' , alarm_source AS 'Report from', "
                + "alarm_timestamp  AS 'Alarm-Time', system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User' "
                + "FROM "+LMIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                + "WHERE error_type = 'Event' "*/
                + ";");
           HydeDataSet HDS = new HydeDataSet(v);
           HDS.generateTable(eventTable);
        }
    }
    
    private void Change(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Change
        Object src = evt.getSource();
        if (src == deviceStatusTabPane && JDC1 != null)
        {
            updateTable();
        }
    }//GEN-LAST:event_Change


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertTab;
    private javax.swing.JTable alertTable;
    private javax.swing.JScrollPane alertTableScroll;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    public javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JTabbedPane deviceStatusTabPane;
    private javax.swing.JPanel eventTab;
    private javax.swing.JTable eventTable;
    private javax.swing.JScrollPane eventTableScroll;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel fromCalendar;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JPanel summaryTab;
    private javax.swing.JTable summaryTable;
    private javax.swing.JScrollPane summaryTableScroll;
    private javax.swing.JCheckBox systemFixCheckBox;
    private javax.swing.JPanel toCalendar;
    private javax.swing.JCheckBox userFixCheckBox;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JPanel warningTab;
    private javax.swing.JTable warningTable;
    private javax.swing.JScrollPane warningTableScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if ((src == userFixCheckBox || src == systemFixCheckBox || src == refreshButton || src == deviceGroupComboBox) && deviceGroupComboBox.getSelectedItem() != null)
        {
            updateTable();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setDeviceGroupComboBox();
            updateTable();
        }
        else if (src == exportButton)
        {
            try
            {
                if (deviceStatusTabPane.getSelectedIndex() == 0)
                {
                    HydeTable.exportTableGUI(this,summaryTable);
                }
                else if (deviceStatusTabPane.getSelectedIndex() == 1)
                {
                    HydeTable.exportTableGUI(this,alertTable);
                }
                else if (deviceStatusTabPane.getSelectedIndex() == 2)
                {
                    HydeTable.exportTableGUI(this,warningTable);
                }
                else if (deviceStatusTabPane.getSelectedIndex() == 3)
                {
                    HydeTable.exportTableGUI(this,eventTable);
                }
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        int clickCount = e.getClickCount();
        if (clickCount == 2)
        {
            if (src == alertTable)
            {
                int row = alertTable.getSelectedRow();
                int maxColumn = alertTable.getColumnCount();
                for (int i=0;i<maxColumn;i++)
                {
                    String cname = alertTable.getModel().getColumnName(i);
                    if (cname.toUpperCase().equals("ALARM ID"))
                    {
                        String alarmID = (String) alertTable.getValueAt(row, i);
                        //SuggestionDialog SD = new SuggestionDialog(LMIF.MF, alarmID);
                    }
                }
            }
            else if (src == eventTable)
            {
                int row = eventTable.getSelectedRow();
                int maxColumn = eventTable.getColumnCount();
                for (int i=0;i<maxColumn;i++)
                {
                    String cname = eventTable.getModel().getColumnName(i);
                    if (cname.toUpperCase().equals("ALARM ID"))
                    {
                        String alarmID = (String) eventTable.getValueAt(row, i);
                        //SuggestionDialog SD = new SuggestionDialog(LMIF.MF, alarmID);
                    }
                }
            }
            else if (src == warningTable)
            {
                int row = warningTable.getSelectedRow();
                int maxColumn = warningTable.getColumnCount();
                for (int i=0;i<maxColumn;i++)
                {
                    String cname = warningTable.getModel().getColumnName(i);
                    if (cname.toUpperCase().equals("ALARM ID"))
                    {
                        String alarmID = (String) warningTable.getValueAt(row, i);
                        //SuggestionDialog SD = new SuggestionDialog(LMIF.MF, alarmID);
                    }
                }
            }
            else if (src == summaryTable)
            {
                int row = summaryTable.getSelectedRow();
                int maxColumn = summaryTable.getColumnCount();
                for (int i=0;i<maxColumn;i++)
                {
                    String cname = summaryTable.getModel().getColumnName(i);
                    if (cname.toUpperCase().equals("ALARM ID"))
                    {
                        String alarmID = (String) summaryTable.getValueAt(row, i);
                        //SD = new SuggestionDialog(LMIF.MF, alarmID);
                    }
                }
            }
        }
    }

}
