package ETM.LOG.PANEL;

import ETM.LOG.LogManagementIF;
import ETM.Util.HydeFormat;
import HydeModule.Table.HydeDataSet;
import HydeModule.Table.HydeTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class EmailLogPanel extends javax.swing.JPanel implements ActionListener
{
    public LogManagementIF LMIF;
    private String searchOption;

    public JDateChooser JDC1;
    public JDateChooser JDC2;

    private static String defaultDepartmentComboBox = "Select a department...";
    private static String defaultUserGroupComboBox = "Select a group...";

  
    public EmailLogPanel(LogManagementIF LMIF)
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

        searchOption = "";
        setDepartmentComboBox();
        setAccessTable();
    }

    private void actionComponents()
    {
        successCheckBox.addActionListener(this);
        failCheckBox.addActionListener(this);

        refreshButton.addActionListener(this);
        exportButton.addActionListener(this);
        departmentComboBox.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accessScroll = new javax.swing.JScrollPane();
        accessTable = new javax.swing.JTable();
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
        successCheckBox = new javax.swing.JCheckBox();
        failCheckBox = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();

        accessTable.setAutoCreateRowSorter(true);
        accessTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        accessScroll.setViewportView(accessTable);

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
            .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(departmentLabel)
                .addComponent(departmentComboBox))
        );

        viewPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        viewPanel.setPreferredSize(new java.awt.Dimension(280, 63));

        jLabel1.setText("Filter : ");

        fromCalendar.setLayout(new java.awt.GridLayout(1, 0));

        toCalendar.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setText("to");

        successCheckBox.setSelected(true);
        successCheckBox.setText("Success");

        failCheckBox.setSelected(true);
        failCheckBox.setText("Fail");

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
                .addComponent(successCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(failCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(successCheckBox)
                .addComponent(failCheckBox))
            .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fromCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(accessScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addComponent(groupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accessScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void setAccessTable()
    {
        String groupFilter = "(FALSE";

        String depart = (String) departmentComboBox.getSelectedItem();
        if (depart.equals("All"))
        {
            groupFilter = "(TRUE";
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            groupFilter = "(depart_id = '"+HydeFormat.parseID(depart) +"'";
        }
        groupFilter += ") AND ";

        String opt = "(email_log.success = 2 ";
        if (successCheckBox.isSelected())
        {
            opt += "OR email_log.success = 1 ";
        }
        if (failCheckBox.isSelected())
        {
            opt += "OR email_log.success = 0 ";
        }
        opt += ") AND ";

        Date f = JDC1.getDate();
        Date t = JDC2.getDate();
        String between = " (timestamp BETWEEN '"+LMIF.MF.HDC.formatDateTime(f)+"' AND '"+LMIF.MF.HDC.formatDateTime(t)+"') AND ";

        String stmt = "SELECT "
                + "email_log.user_username AS 'User', destination AS 'Address', provider_name AS 'Provider', message1 AS 'Text-1', message2 AS 'Text-2', "
                + "timestamp AS 'Send-Time', success AS 'Success' "
                + "FROM "+LMIF.MF.HDC.database+"_log.email_log NATURAL JOIN user "
                + "WHERE "+groupFilter+opt+searchOption+between+" true ORDER BY email_log.timestamp DESC;";
        
        Vector VSS = LMIF.MF.HDC.queryAll(stmt);
        HydeDataSet HDS = new HydeDataSet(VSS);
        HDS.generateTable(accessTable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane accessScroll;
    private javax.swing.JTable accessTable;
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JButton exportButton;
    private javax.swing.JCheckBox failCheckBox;
    private javax.swing.JPanel fromCalendar;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JCheckBox successCheckBox;
    private javax.swing.JPanel toCalendar;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == successCheckBox || src == failCheckBox || src == refreshButton)
        {
            setAccessTable();
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setAccessTable();
        }
        else if (src == exportButton)
        {
            try
            {
                HydeTable.exportTableGUI(this,accessTable);
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
    }

}
