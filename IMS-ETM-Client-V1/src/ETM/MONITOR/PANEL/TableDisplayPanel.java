package ETM.MONITOR.PANEL;

import ETM.MONITOR.DIALOG.PrintDialog2;
import ETM.MONITOR.DIALOG.ProbeSelectDialog;
import ETM.MONITOR.MonitorIF;
import ETM.MONITOR.QueryDialog;
import ETM.MONITOR.QueryThread;
import ETM.STRUCTURE.TableData;
import ETM.Util.HydeFormat;
import ETM.Util.HydeMath;
import HydeModule.Table.HydeDataSet;
import HydeModule.Table.HydeTable;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import java.util.Random;
import javax.swing.JTable;

public class TableDisplayPanel extends javax.swing.JPanel implements ActionListener
{
    public MonitorIF MIF;

    public JDateChooser JDC1;
    public JDateChooser JDC2;

    public TableData TD;
    public Object[] selectedProbe;

    public JTable dataTable;
    public JTable alarmCurrentTable;
    public JTable alarmTable;

    public TableDisplayPanel(MonitorIF MIF)
    {
        this.MIF = MIF;

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
        defaultDate.setTime(defaultDate.getTime()-(86400000L));
        JDC1.setDate(defaultDate);
        fromHourComboBox.setSelectedItem(defaultDate.getHours()+"");
        fromMinComboBox.setSelectedItem(defaultDate.getMinutes()+"");

        Date d = new Date();
        JDC2.setDate(d);
        toHourComboBox.setSelectedItem(d.getHours()+"");
        toMinComboBox.setSelectedItem(d.getMinutes()+"");

        //JDC1.setDateFormatString("Jan 1, 2011");

        fromCalendar.add(JDC1);
        toCalendar.add(JDC2);

        selectedProbe = new Object[0]; 
        TD = new TableData();

        dataTable = new JTable();
        dataTable.setAutoCreateRowSorter(true);
        dataTable.setCellSelectionEnabled(true);

        alarmCurrentTable = new JTable();
        alarmCurrentTable.setAutoCreateRowSorter(true);
        alarmCurrentTable.setCellSelectionEnabled(true);

        alarmTable = new JTable();
        alarmTable.setAutoCreateRowSorter(true);
        alarmTable.setCellSelectionEnabled(true);

        mainTableScroll.setViewportView(dataTable);
        alarmCurrentTableScroll.setViewportView(alarmCurrentTable);
        alarmTableScroll.setViewportView(alarmTable);

    }

    private void actionComponents()
    {
        runButton.addActionListener(this);
        exportButton.addActionListener(this);
        printButton.addActionListener(this);
        probeSelectButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tempAlarmTab = new javax.swing.JTabbedPane();
        mainTableScroll = new javax.swing.JScrollPane();
        alarmCurrentTableScroll = new javax.swing.JScrollPane();
        alarmTableScroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        runButton = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        exportButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        fromCalendar = new javax.swing.JPanel();
        fromHourComboBox = new javax.swing.JComboBox();
        fromMinComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        toCalendar = new javax.swing.JPanel();
        toHourComboBox = new javax.swing.JComboBox();
        toMinComboBox = new javax.swing.JComboBox();
        realtimeCheckBox = new javax.swing.JCheckBox();
        loggingCheckBox = new javax.swing.JCheckBox();
        savedCheckBox = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jToolBar6 = new javax.swing.JToolBar();
        probeSelectButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(0, 0));

        tempAlarmTab.addTab("Temperature", mainTableScroll);
        tempAlarmTab.addTab("Currently Alarm", alarmCurrentTableScroll);
        tempAlarmTab.addTab("Acknowledged Alarm", alarmTableScroll);

        jScrollPane1.setViewportView(tempAlarmTab);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 60));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(527, 60));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 52));
        jPanel3.setPreferredSize(new java.awt.Dimension(70, 52));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);
        jToolBar1.setMaximumSize(new java.awt.Dimension(60, 32));
        jToolBar1.setMinimumSize(new java.awt.Dimension(60, 32));
        jToolBar1.setPreferredSize(new java.awt.Dimension(60, 30));

        runButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/load_database_24.png"))); // NOI18N
        runButton.setToolTipText("Load Data");
        runButton.setMaximumSize(new java.awt.Dimension(49, 25));
        runButton.setMinimumSize(new java.awt.Dimension(49, 25));
        runButton.setPreferredSize(new java.awt.Dimension(49, 25));
        jToolBar1.add(runButton);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/print_24.png"))); // NOI18N
        printButton.setToolTipText("Print This Table");
        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printButton.setMaximumSize(new java.awt.Dimension(30, 26));
        printButton.setMinimumSize(new java.awt.Dimension(30, 26));
        printButton.setPreferredSize(new java.awt.Dimension(30, 26));
        printButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(printButton);

        jPanel3.add(jToolBar1);

        jPanel1.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Export"));
        jPanel4.setMaximumSize(new java.awt.Dimension(50, 52));
        jPanel4.setMinimumSize(new java.awt.Dimension(50, 52));
        jPanel4.setPreferredSize(new java.awt.Dimension(50, 52));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);
        jToolBar2.setMaximumSize(new java.awt.Dimension(60, 30));
        jToolBar2.setMinimumSize(new java.awt.Dimension(60, 30));

        exportButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/excel_16.png"))); // NOI18N
        exportButton.setToolTipText("Export to CSV");
        exportButton.setMaximumSize(new java.awt.Dimension(30, 23));
        exportButton.setMinimumSize(new java.awt.Dimension(30, 23));
        exportButton.setPreferredSize(new java.awt.Dimension(30, 23));
        jToolBar2.add(exportButton);

        jPanel4.add(jToolBar2);

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanel5.setPreferredSize(new java.awt.Dimension(823, 30));

        fromCalendar.setLayout(new java.awt.GridLayout(1, 0));

        fromHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        fromHourComboBox.setBorder(null);

        fromMinComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        jLabel4.setText("~");

        toCalendar.setLayout(new java.awt.GridLayout(1, 0));

        toHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        toMinComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        realtimeCheckBox.setSelected(true);
        realtimeCheckBox.setText("RT");

        loggingCheckBox.setSelected(true);
        loggingCheckBox.setText("LG");

        savedCheckBox.setSelected(true);
        savedCheckBox.setText("SV");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        probeSelectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/temp_16.png"))); // NOI18N
        probeSelectButton.setText("Select Probe...");
        probeSelectButton.setToolTipText("");
        probeSelectButton.setFocusable(false);
        probeSelectButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        probeSelectButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        probeSelectButton.setMaximumSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setMinimumSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setPreferredSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(probeSelectButton);

        jLabel5.setText(":");

        jLabel6.setText(":");

        jLabel8.setText("Date-Time : ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realtimeCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loggingCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savedCheckBox)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fromCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fromMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(realtimeCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loggingCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savedCheckBox, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(toCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fromCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fromHourComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fromMinComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel5, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    DecimalFormat df = new DecimalFormat("#.###");
    public void summary(String name)
    {
        if (HDS != null)
        {
            Vector rowVector = HDS.getRowVector();
            if (rowVector != null && rowVector.size()>0)
            {
                Enumeration row = rowVector.elements();
                //double[] doubleData = new double[rowVector.size()];
                Vector vd = new Vector();
                int i=0;
                while(row.hasMoreElements())
                {
                    Vector data = (Vector) row.nextElement();
                    if (data.elementAt(0).equals(name))
                    {
                        vd.add((String)data.elementAt(1));
                        i++;
                    }
                }
                double[] doubleData = new double[i];
                Enumeration ddEnu = vd.elements();
                int j=0;
                while(ddEnu.hasMoreElements())
                {
                    doubleData[j] = Double.parseDouble((String)ddEnu.nextElement());
                    j++;
                }
                if (i > 0)
                {
                    TD.tableTotalData = i;
                    TD.tableAverage = Double.valueOf(df.format(HydeMath.average(doubleData)));
                    TD.tableSTD = Double.valueOf(df.format(HydeMath.standardDeviationCalculate(doubleData)));
                    TD.tableMax = HydeMath.findMax(doubleData);
                    TD.tableMin = HydeMath.findMin(doubleData);
                    if (HDS2 != null) TD.tableAlarm = HDS2.getRowVector().size();
                    if (HDS3 != null) TD.tableFixed = HDS3.getRowVector().size();
                }
                else
                {
                    TD.tableTotalData = 0;
                    TD.tableAverage = 0.0;
                    TD.tableSTD = 0.0;
                    TD.tableMax = 0.0;
                    TD.tableMin = 0.0;
                    TD.tableAlarm = 0;
                    TD.tableFixed = 0;
                }
            }
        }
   }

    public HydeDataSet HDS;
    public QueryDialog LD;
    public Vector<Vector> dataSet = new Vector<Vector>();
    public void returnedDataSet(Vector<Vector> ds)
    {
        dataSet = ds;
    }
    
    private void setTable()
    {
        //MIF.tableProbeComboBox.removeAllItems();
        //MIF.tableProbeComboBox.addItem(MIF.defaultComboBox);
        String from = getFromTime();
        String to = getToTime();
        String pid = "(";
        for (int i=0;i<selectedProbe.length;i++ )
        {
            try
            {
                String str = (String) selectedProbe[i];
                String deviceID = HydeFormat.parseID(str);
                char ch = str.charAt(4);
                pid += "(data.device_id = '"+deviceID+"' AND data.channel = '"+ch+"') OR ";
            }
            catch (Exception ee)
            {
                System.out.println("TemperatureGraphPanel/setTable error : "+ee);
            }
        }
        pid += "false) AND ";
        String dataType = "(";
        if (realtimeCheckBox.isSelected())
        {
            dataType += "data.DATA_TYPE_ID = 101 OR ";
        }
        if (loggingCheckBox.isSelected())
        {
            dataType += "data.DATA_TYPE_ID = 102 OR ";
        }
        if (savedCheckBox.isSelected())
        {
            dataType += "data.DATA_TYPE_ID = 103 OR ";
        }
        dataType += "false) AND ";
        String dataRange = "( data_timestamp BETWEEN '"+from+"' AND '"+to+"' ) AND ";

        String sql = ("SELECT "
                + "CONCAT(device_name,' (',device_id,')') AS 'Device', "
                + "channel AS 'Channel', "
                + "channel_name AS 'Channel Name', "
                + "data_value AS 'Data', "
                + "channel_unit AS 'Unit', "
                + "data_timestamp AS 'Timestamp', "
                + "data_type_name AS 'Type' "
                + "FROM data NATURAL JOIN device_channel NATURAL JOIN device NATURAL JOIN data_type "
                + "WHERE "+pid+dataType+dataRange
                + "true ORDER BY data_timestamp ASC;");
        
        /*QueryThread QGT = new QueryThread(sql,MIF.MF.HDC,this);
        Thread t = new Thread(QGT);
        t.start();
        LD = new QueryDialog(MIF.MF,"Loading data from database...",false,QGT);
        QGT.setLoadingScreen(LD);
        */
        
        Vector<Vector> dataSet;
        dataSet = MIF.MF.HDC.queryAll(sql);
        
        HDS = new HydeDataSet(dataSet);
        
        Vector rv = HDS.getRowVector();
        Enumeration enu = rv.elements();
        while(enu.hasMoreElements())
        {
            Vector data1 = (Vector) enu.nextElement();
            if (data1.elementAt(2).equals("K"))
            {
                double data = Double.parseDouble((String)data1.elementAt(1));
                double d = ((int)(data*100))+27315;
                data1.setElementAt(d/100.0+"", 1);
            }
            else if (data1.elementAt(2).equals("F"))
            {
                double data = Double.parseDouble((String)data1.elementAt(1));
                double d = data*9.0/5.0;
                d = ((int)(d*100))+3200;
                data1.setElementAt(d/100.0+"", 1);
            }
        }
        HDS.generateTable(dataTable);
    }

    HydeDataSet HDS2;
    private void setAlarmCurrentTable()
    {
        String from = getFromTime();
        String to = getToTime();
        String pid = "(";
        for (int i=0;i<selectedProbe.length;i++ )
        {
            try
            {
                String str = (String) selectedProbe[i];
                str = str.substring(10);
                String id = HydeFormat.parseID(str);
                //id = id.substring(0,id.length()-1);
                pid += "device_id = '"+id+"' OR ";
            }
            catch (Exception ee)
            {
                System.out.println("TemperatureGraphPanel/setTable error : "+ee);
            }
        }
        pid += "false) AND ";
        Vector v = MIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Report Device', error_name AS 'Type', alarm_source AS 'Target', "
                + "alarm_timestamp AS 'Start Alarm',system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User', Note "
                + "FROM alarm_current NATURAL JOIN error "
                + "WHERE "+pid+" alarm_timestamp BETWEEN '"+from+"' AND '"+to+"';");
        HDS2 = new HydeDataSet(v);
        HDS2.generateTable(alarmCurrentTable);
    }

    HydeDataSet HDS3;
    private void setAlarmTable()
    {
        String from = getFromTime();
        String to = getToTime();
        String pid = "(";
        for (int i=0;i<selectedProbe.length;i++ )
        {
            try
            {
                String str = (String) selectedProbe[i];
                str = str.substring(10);
                String id = HydeFormat.parseID(str);
                pid += "device_id = '"+id+"' OR ";
            }
            catch (Exception ee)
            {
                System.out.println("TemperatureGraphPanel/setTable error : "+ee);
            }
        }
        pid += "false) AND ";
        Vector v = MIF.MF.HDC.queryAll("SELECT "
                + "alarm_id AS 'Alarm ID', device_id AS 'Report Device', error_name AS 'Type', alarm_source AS 'Target', "
                + "alarm_timestamp AS 'Start Alarm',system_timestamp AS 'System Fix', user_timestamp AS 'User Fix', user_username AS 'User', Note "
                + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN "+MIF.MF.SD.defaultDatabase+".error "
                + "WHERE "+pid+" alarm_timestamp BETWEEN '"+from+"' AND '"+to+"';");
        HDS3 = new HydeDataSet(v);
        HDS3.generateTable(alarmTable);
    }
    
    public void setSelectedProbe(Object[] obj)
    {
        selectedProbe = obj;
    }

    public String getFromTime()
    {
        Date d1 = JDC1.getDate();
        d1.setHours(Integer.parseInt((String)fromHourComboBox.getSelectedItem()));
        d1.setMinutes(Integer.parseInt((String)fromMinComboBox.getSelectedItem()));
        //d1.setSeconds(Integer.parseInt((String)fromSecComboBox.getSelectedItem()));
        return HydeFormat.SDF.format(d1);
    }

    public String getToTime()
    {
        Date d2 = JDC2.getDate();
        d2.setHours(Integer.parseInt((String)toHourComboBox.getSelectedItem()));
        d2.setMinutes(Integer.parseInt((String)toMinComboBox.getSelectedItem()));
        //d2.setSeconds(Integer.parseInt((String)toSecComboBox.getSelectedItem()));
        return HydeFormat.SDF.format(d2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane alarmCurrentTableScroll;
    private javax.swing.JScrollPane alarmTableScroll;
    private javax.swing.JButton exportButton;
    private javax.swing.JPanel fromCalendar;
    private javax.swing.JComboBox fromHourComboBox;
    private javax.swing.JComboBox fromMinComboBox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar6;
    public javax.swing.JCheckBox loggingCheckBox;
    private javax.swing.JScrollPane mainTableScroll;
    private javax.swing.JButton printButton;
    private javax.swing.JButton probeSelectButton;
    public javax.swing.JCheckBox realtimeCheckBox;
    private javax.swing.JButton runButton;
    public javax.swing.JCheckBox savedCheckBox;
    private javax.swing.JTabbedPane tempAlarmTab;
    private javax.swing.JPanel toCalendar;
    private javax.swing.JComboBox toHourComboBox;
    private javax.swing.JComboBox toMinComboBox;
    // End of variables declaration//GEN-END:variables

    private void genData()
    {
        for (int i=0;i<1400;i+=5)
        {
            int hour = (i/60)%24;
            int min = i%59;
            Random rand = new Random();
            MIF.MF.HDC.customUpdate("INSERT INTO data (PROBE_ID, DATA_VALUE, DATA_TIMESTAMP, DATA_TYPE_ID) "
                    + "VALUES ("
                    + "1010000041, "
                    + "'"+(rand.nextInt(10)+40)+"."+rand.nextInt(100)+"', "
                    + "'2011-10-14 "+hour+":"+min+":00', "
                    + "'102');");
            /*MIF.MF.HDC.customUpdate("INSERT INTO data (PROBE_ID, DATA_VALUE, DATA_TIMESTAMP, DATA_TYPE_ID) "
                    + "VALUES ("
                    + "1000181, "
                    + "'"+(rand.nextInt(10))+"."+rand.nextInt(100)+"', "
                    + "'2011-07-20 "+hour+":"+min+":00', "
                    + "'102');");*/
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == runButton)
        {
            //genData();
            setTable();
            setAlarmCurrentTable();
            setAlarmTable();
            summary("0 ()");
            //setSummary();
        }
        else if (src == printButton)
        {
            if (selectedProbe.length > 0)
            {

                String dep = "Unknown";
                String org = "Unknown";
                String[] depID = new String[selectedProbe.length];
                String departs = " FALSE ";
                for (int i=0;i<selectedProbe.length;i++ )
                {
                    String str = (String) selectedProbe[i];
                    String deviceID = HydeFormat.parseID(str);
                    char ch = str.charAt(4);
                    depID[i] = MIF.MF.HDC.query0("SELECT depart_id FROM device_group WHERE device_group_id = "
                            + "(SELECT device_group_id FROM device WHERE device_id = '"+deviceID+"') "
                            + ";");
                    departs += " OR depart_id = '"+depID[i]+"'";
                }
                Vector depVector = MIF.MF.HDC.queryColumn("SELECT DISTINCT depart_name FROM department WHERE "+departs+";");
                //Vector orgVector = MIF.MF.HDC.queryColumn("SELECT DISTINCT organization_name FROM department NATURAL JOIN organization WHERE "+departs+";");
                if (depVector.size() > 0)
                {
                    dep = "";
                    Enumeration enu = depVector.elements();
                    while (enu.hasMoreElements())
                    {
                        dep += enu.nextElement() + ", ";
                    }
                    dep = dep.substring(0, dep.length()-2);
                }
                /*if (orgVector.size() > 0)
                {
                    org = "";
                    Enumeration enu = orgVector.elements();
                    while (enu.hasMoreElements())
                    {
                        org += enu.nextElement() + ", ";
                    }
                    org = org.substring(0, org.length()-2);
                }*/
                
                String from = getFromTime();
                String to = getToTime();

                int rs = dataTable.getRowCount();
                TablePrintFormatter[] TPF = new TablePrintFormatter[(rs/40)+1];
                for (int i=0; i<rs; i+=40)
                {
                    Vector d = new Vector();
                    for (int j=0; j<rs-i;j++)
                    {
                        Vector v = new Vector();
                        for (int k=0;k<5;k++)
                        {
                            v.add(dataTable.getValueAt(i+j, k));
                        }
                        d.add(v);
                        if (j >= 39) break;
                    }
                    TPF[i/40] = new TablePrintFormatter(dep,from+" - "+to,d);
                }

                PrintDialog2 PD2 = new PrintDialog2(TPF);
            }
        }
        else if (src == exportButton)
        {
            try
            {
                if (tempAlarmTab.getSelectedIndex() == 0)
                {
                    HydeTable.exportTableGUI(this, dataTable);
                }
                else if (tempAlarmTab.getSelectedIndex() == 1)
                {
                    HydeTable.exportTableGUI(this, alarmCurrentTable);
                }
                else if (tempAlarmTab.getSelectedIndex() == 2)
                {
                    HydeTable.exportTableGUI(this, alarmTable);
                }
            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }
        }
        else if (src == probeSelectButton)
        {
            ProbeSelectDialog PSD = new ProbeSelectDialog(this);
        }
    }

}
