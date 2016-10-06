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
import javax.swing.table.DefaultTableModel;

public class ModifyLogPanel extends javax.swing.JPanel implements ActionListener, MouseListener
{
    private LogManagementIF LMIF;
    private DefaultTableModel warningTableModel;

    public JDateChooser JDC1;
    public JDateChooser JDC2;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultDeviceGroupComboBox = "Select a group...";

    public ModifyLogPanel(LogManagementIF LMIF)
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
        changeTable.addMouseListener(this);
        refreshButton.addActionListener(this);
        exportButton.addActionListener(this);

        departmentComboBox.addActionListener(this);
        //deviceGroupComboBox.addActionListener(this);

        addCheckBox.addActionListener(this);
        updateCheckBox.addActionListener(this);
        removeCheckBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        summaryTab = new javax.swing.JPanel();
        changeTableScroll = new javax.swing.JScrollPane();
        changeTable = new javax.swing.JTable();
        groupPanel = new javax.swing.JPanel();
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
        addCheckBox = new javax.swing.JCheckBox();
        updateCheckBox = new javax.swing.JCheckBox();
        removeCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        summaryTab.setLayout(new java.awt.GridLayout(1, 0));

        changeTable.setAutoCreateRowSorter(true);
        changeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        changeTableScroll.setViewportView(changeTable);

        summaryTab.add(changeTableScroll);

        groupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(departmentComboBox)
            .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Filter : ");

        fromCalendar.setLayout(new java.awt.GridLayout(1, 0));

        toCalendar.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("to");

        addCheckBox.setSelected(true);
        addCheckBox.setText("Insert");

        updateCheckBox.setSelected(true);
        updateCheckBox.setText("Modify");

        removeCheckBox.setSelected(true);
        removeCheckBox.setText("Remove");

        jLabel5.setText("Date");

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
                .addComponent(addCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(fromCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(toCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(addCheckBox)
                .addComponent(updateCheckBox)
                .addComponent(removeCheckBox))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(summaryTab, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groupPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(summaryTab, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
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

     /*private void setDeviceGroupComboBox()
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
    }*/

    private void updateTable()
    {
        String groupFilter = "(FALSE";

        String depart = (String) departmentComboBox.getSelectedItem();
        /*String group = (String) deviceGroupComboBox.getSelectedItem();
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
        groupFilter += ") AND ";*/
        if (depart.equals("All"))
        {
            groupFilter = "(TRUE";
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            groupFilter = "(depart_id = '"+HydeFormat.parseID(depart) +"'";
        }
        groupFilter += ") AND ";
        String selected = "(";
        if (addCheckBox.isSelected())
        {
            selected += "log_id = '104' OR ";
        }
        if (updateCheckBox.isSelected())
        {
            selected += "log_id = '105' OR ";
        }
        if (removeCheckBox.isSelected())
        {
            selected += "log_id = '106' OR ";
        }
        selected += "FALSE) AND ";
        Date f = JDC1.getDate();
        Date t = JDC2.getDate();
        String between = " (modify_timestamp BETWEEN '"+LMIF.MF.HDC.formatDateTime(f)+"' AND '"+LMIF.MF.HDC.formatDateTime(t)+"')";
        Vector v = LMIF.MF.HDC.queryAll("SELECT "
                + "modify_log_id AS 'Log ID', "
                + "CONCAT(device_name,' (',device_id,')') AS 'Device ID', "
                + "log_name AS 'Type', "
                + "user_username AS 'By', "
                + "description AS 'Description', "
                + "modify_timestamp AS 'Timestamp' "
                + "FROM "+LMIF.MF.HDC.database+"_log.modify_log NATURAL JOIN "+LMIF.MF.HDC.database+"_log.log_type NATURAL JOIN user "
                + "NATURAL JOIN ("+LMIF.MF.HDC.database+".device NATURAL JOIN "+LMIF.MF.HDC.database+".equipment) "
                + "WHERE "+groupFilter+selected+between+" "
                + ";");
        if (v != null)
        {
            HydeDataSet HDS = new HydeDataSet(v);
            HDS.generateTable(changeTable);
            summaryTab.repaint();
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox addCheckBox;
    private javax.swing.JTable changeTable;
    private javax.swing.JScrollPane changeTableScroll;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel fromCalendar;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JCheckBox removeCheckBox;
    private javax.swing.JPanel summaryTab;
    private javax.swing.JPanel toCalendar;
    private javax.swing.JCheckBox updateCheckBox;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if ((src == refreshButton || src == addCheckBox || src == updateCheckBox || src == removeCheckBox))
        {
            updateTable();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            //setDeviceGroupComboBox();
            updateTable();
        }
        else if (src == exportButton)
        {
            try
            {
                HydeTable.exportTableGUI(this,changeTable);
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
        /*if (clickCount == 2)
        {
            if (src == changeTable)
            {
                
            }
        }*/
    }


}
