package ETM.MONITOR.PANEL;

import ETM.MONITOR.DIALOG.GraphBoundDialog;
import ETM.MONITOR.DIALOG.PrintDialog;
import ETM.MONITOR.DIALOG.ProbeSelectDialog;
import ETM.MONITOR.MonitorIF;
import ETM.MONITOR.QueryDialog;
import ETM.MONITOR.QueryThread;
import ETM.MONITOR.RealtimeTimer;
import ETM.STRUCTURE.AlarmGraphData;
import ETM.STRUCTURE.GraphData;
import HydeModule.GraphEngine.Channel;
import HydeModule.GraphEngine.GraphPanel;
import HydeModule.GraphEngine.ScopeDriver;
import ETM.Util.HydeFormat;
import ETM.Util.HydeMath;
import HydeModule.Table.HydeDataSet;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

import javax.swing.border.Border;

public class GraphDisplayPanel extends javax.swing.JPanel implements ActionListener, ItemListener, ChangeListener, MouseListener {

    public Hashtable legendEdit;
    public Hashtable legendFix;

    public MonitorIF MIF;
    private Vector<ScopeDriver> VSD;

    private GraphPanel GP;
    private RealtimeTimer RT;
    private Thread realtimeThread;

    private static String startUpdate = "1901-01-01 01:00:00";
    public Date lastUpdate;

    private ImageIcon playIcon = new ImageIcon(getClass().getResource("/Picz/Button24/play_24.png"));
    private ImageIcon stopIcon = new ImageIcon(getClass().getResource("/Picz/Button24/stop_24.png"));

    public Vector agdVector;
    public Vector agdFixedVector;

    public JDateChooser JDC1;
    public JDateChooser JDC2;

    public HydeDataSet HDS2;
    public HydeDataSet HDS3;

    public Object[] selectedProbe;
    public GraphData GD;

    public ProbeSelectDialog PSD;

    public double upper;
    public double lowwer;
    double upper_y =0;
    double lower_y =0;
    //private Graphics Graphics;
    public Graphics g;
    public GraphDisplayPanel(MonitorIF MIF) {
        this.MIF = MIF;
        initComponents();

        extendComponents();
        graphComponents();

        actionComponents();
        setVisible(true);
    }

    GraphDisplayPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void extendComponents() {
        //showLabelCheckBox.setSelected(GP.isLegendEnabled());
        //connectDataCBox.setSelected(panel.isConnectPoints());
        legendEdit = new Hashtable();
        legendFix = new Hashtable();

        VSD = MIF.VSD;
        GP = MIF.GP;
        GD = new GraphData();

        lastUpdate = new Date();
        selectedProbe = new Object[0];

        JCalendar JC = new JCalendar();
        JDC1 = new JDateChooser();
        JDC2 = new JDateChooser();

        Date defaultDate = new Date();
        defaultDate.setTime(defaultDate.getTime() - (86400 * 1000));
        JDC1.setDate(defaultDate);
        fromHourComboBox.setSelectedItem(defaultDate.getHours() + "");
        fromMinComboBox.setSelectedItem(defaultDate.getMinutes() + "");

        Date d = new Date();
        JDC2.setDate(d);
        toHourComboBox.setSelectedItem(d.getHours() + "");
        toMinComboBox.setSelectedItem(d.getMinutes() + "");

        //JDC1.setDateFormatString("Jan 1, 2011");
        fromCalendar.add(JDC1);
        toCalendar.add(JDC2);
    }

    private void actionComponents() {
        zoomOutXButton.addActionListener(this);
        zoomInXButton.addActionListener(this);
        zoomOutYButton.addActionListener(this);
        zoomInYButton.addActionListener(this);
        trimButton.addActionListener(this);

        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        upButton.addActionListener(this);
        downButton.addActionListener(this);

        labelToggleButton.addActionListener(this);
        gridLineToggleButton.addActionListener(this);
        colorToggleButton.addActionListener(this);
        connectDataToggleButton.addActionListener(this);
        runButton.addActionListener(this);
        alarmIconToggleButton.addActionListener(this);
        printButton.addActionListener(this);
        realtimeButton.addActionListener(this);

        primaryComboBox.addActionListener(this);
        probeSelectButton.addActionListener(this);
        //timeSlider.addChangeListener(this);
        GP.addMouseListener(this);
    }

    private void graphComponents() {
        if (graphPanel.getComponentCount() != 0) {
            graphPanel.removeAll();
        }
        graphPanel.add(GP);
        graphPanel.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
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
        jText_Upper = new javax.swing.JTextField();
        jText_Lower = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        runButton = new javax.swing.JButton();
        realtimeButton = new javax.swing.JToggleButton();
        printButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        labelToggleButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        connectDataToggleButton = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        gridLineToggleButton = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        alarmIconToggleButton = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        colorToggleButton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        primaryComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        control = new javax.swing.JToolBar();
        trimButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        xPanel = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        zoomOutXButton = new javax.swing.JButton();
        zoomInXButton = new javax.swing.JButton();
        yPanel = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        zoomOutYButton = new javax.swing.JButton();
        zoomInYButton = new javax.swing.JButton();
        graphScroll = new javax.swing.JScrollPane();
        graphPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 30));

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
        probeSelectButton.setFocusable(false);
        probeSelectButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        probeSelectButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        probeSelectButton.setMaximumSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setMinimumSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setPreferredSize(new java.awt.Dimension(100, 20));
        probeSelectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        probeSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probeSelectButtonActionPerformed(evt);
            }
        });
        jToolBar6.add(probeSelectButton);

        jLabel5.setText(":");

        jLabel6.setText(":");

        jLabel8.setText("Date-Time : ");

        jText_Upper.setText("0.0");
        jText_Upper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_UpperActionPerformed(evt);
            }
        });

        jText_Lower.setText("0.0");
        jText_Lower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jText_LowerActionPerformed(evt);
            }
        });

        jLabel9.setText("Upper :");

        jLabel10.setText("Lower :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jText_Upper, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jText_Lower, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(realtimeCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loggingCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(savedCheckBox, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jSeparator2)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(toHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toMinComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jText_Upper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jText_Lower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10))
                    .addComponent(toCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fromCalendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fromHourComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fromMinComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        controlPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        controlPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        controlPanel.setMinimumSize(new java.awt.Dimension(0, 60));
        controlPanel.setPreferredSize(new java.awt.Dimension(800, 60));
        controlPanel.setLayout(new javax.swing.BoxLayout(controlPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Action"));
        jPanel3.setMaximumSize(new java.awt.Dimension(110, 52));
        jPanel3.setMinimumSize(new java.awt.Dimension(110, 52));
        jPanel3.setPreferredSize(new java.awt.Dimension(110, 52));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar5.setBorder(null);
        jToolBar5.setFloatable(false);
        jToolBar5.setRollover(true);

        runButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/load_database_24.png"))); // NOI18N
        runButton.setToolTipText("Load Data");
        runButton.setMaximumSize(new java.awt.Dimension(30, 30));
        runButton.setMinimumSize(new java.awt.Dimension(30, 30));
        runButton.setPreferredSize(new java.awt.Dimension(30, 30));
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        jToolBar5.add(runButton);

        realtimeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/play_24.png"))); // NOI18N
        realtimeButton.setToolTipText("Run Realtime Mode (Auto Load Data)");
        realtimeButton.setFocusable(false);
        realtimeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        realtimeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(realtimeButton);

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/print_24.png"))); // NOI18N
        printButton.setToolTipText("Print Graph");
        printButton.setFocusable(false);
        printButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        printButton.setMaximumSize(new java.awt.Dimension(30, 30));
        printButton.setMinimumSize(new java.awt.Dimension(30, 30));
        printButton.setPreferredSize(new java.awt.Dimension(30, 30));
        printButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(printButton);

        jPanel3.add(jToolBar5);

        controlPanel.add(jPanel3);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("View"));
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(180, 50));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jToolBar1.setMaximumSize(new java.awt.Dimension(244, 30));
        jToolBar1.setMinimumSize(new java.awt.Dimension(244, 30));
        jToolBar1.setPreferredSize(new java.awt.Dimension(244, 30));

        labelToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/label_16.png"))); // NOI18N
        labelToggleButton.setSelected(true);
        labelToggleButton.setToolTipText("Legend ON/OFF");
        labelToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        labelToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        labelToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(labelToggleButton);

        jLabel1.setMaximumSize(new java.awt.Dimension(5, 10));
        jLabel1.setMinimumSize(new java.awt.Dimension(5, 10));
        jLabel1.setPreferredSize(new java.awt.Dimension(5, 10));
        jToolBar1.add(jLabel1);

        connectDataToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/chart_line_16.png"))); // NOI18N
        connectDataToggleButton.setSelected(true);
        connectDataToggleButton.setToolTipText("Point-to-Point ON/OFF");
        connectDataToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        connectDataToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        connectDataToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        connectDataToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectDataToggleButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(connectDataToggleButton);

        jLabel2.setMaximumSize(new java.awt.Dimension(5, 10));
        jLabel2.setMinimumSize(new java.awt.Dimension(5, 10));
        jLabel2.setPreferredSize(new java.awt.Dimension(5, 10));
        jToolBar1.add(jLabel2);

        gridLineToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/grid_line_16.png"))); // NOI18N
        gridLineToggleButton.setSelected(true);
        gridLineToggleButton.setToolTipText("Grid ON/OFF");
        gridLineToggleButton.setFocusable(false);
        gridLineToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridLineToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        gridLineToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        gridLineToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        gridLineToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(gridLineToggleButton);

        jLabel3.setMaximumSize(new java.awt.Dimension(5, 10));
        jLabel3.setMinimumSize(new java.awt.Dimension(5, 10));
        jLabel3.setPreferredSize(new java.awt.Dimension(5, 10));
        jToolBar1.add(jLabel3);

        alarmIconToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/alarm_bell_16.png"))); // NOI18N
        alarmIconToggleButton.setSelected(true);
        alarmIconToggleButton.setToolTipText("Alarm Icon ON/OFF");
        alarmIconToggleButton.setFocusable(false);
        alarmIconToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmIconToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        alarmIconToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        alarmIconToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        alarmIconToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(alarmIconToggleButton);

        jLabel7.setMaximumSize(new java.awt.Dimension(5, 10));
        jLabel7.setMinimumSize(new java.awt.Dimension(5, 10));
        jLabel7.setPreferredSize(new java.awt.Dimension(5, 10));
        jToolBar1.add(jLabel7);

        colorToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reverse_color_16.png"))); // NOI18N
        colorToggleButton.setSelected(true);
        colorToggleButton.setToolTipText("Invert Color Theme");
        colorToggleButton.setFocusable(false);
        colorToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorToggleButton.setMaximumSize(new java.awt.Dimension(30, 30));
        colorToggleButton.setMinimumSize(new java.awt.Dimension(30, 30));
        colorToggleButton.setPreferredSize(new java.awt.Dimension(30, 30));
        colorToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(colorToggleButton);

        jSeparator1.setMinimumSize(new java.awt.Dimension(10, 0));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 0));
        jToolBar1.add(jSeparator1);

        primaryComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        primaryComboBox.setToolTipText("Primary Limit Line");
        primaryComboBox.setMaximumSize(new java.awt.Dimension(40, 20));
        primaryComboBox.setMinimumSize(new java.awt.Dimension(40, 20));
        primaryComboBox.setPreferredSize(new java.awt.Dimension(40, 20));
        jToolBar1.add(primaryComboBox);

        jPanel1.add(jToolBar1);

        controlPanel.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Control"));
        jPanel2.setMaximumSize(new java.awt.Dimension(155, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(140, 50));
        jPanel2.setPreferredSize(new java.awt.Dimension(140, 50));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        control.setBorder(null);
        control.setFloatable(false);
        control.setRollover(true);

        trimButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/fit_bound_24.png"))); // NOI18N
        trimButton.setToolTipText("Advance Control");
        trimButton.setFocusable(false);
        trimButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        trimButton.setMaximumSize(new java.awt.Dimension(30, 30));
        trimButton.setMinimumSize(new java.awt.Dimension(30, 30));
        trimButton.setPreferredSize(new java.awt.Dimension(30, 30));
        trimButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        control.add(trimButton);

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/arw_left_24.png"))); // NOI18N
        leftButton.setToolTipText("Move Left");
        leftButton.setMaximumSize(new java.awt.Dimension(25, 25));
        leftButton.setMinimumSize(new java.awt.Dimension(25, 25));
        leftButton.setPreferredSize(new java.awt.Dimension(25, 25));
        control.add(leftButton);

        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/arw_right_24.png"))); // NOI18N
        rightButton.setToolTipText("Move Right");
        rightButton.setMaximumSize(new java.awt.Dimension(25, 25));
        rightButton.setMinimumSize(new java.awt.Dimension(25, 25));
        rightButton.setPreferredSize(new java.awt.Dimension(25, 25));
        control.add(rightButton);

        upButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/arw_up_24.png"))); // NOI18N
        upButton.setToolTipText("Move Up");
        upButton.setMaximumSize(new java.awt.Dimension(25, 25));
        upButton.setMinimumSize(new java.awt.Dimension(25, 25));
        upButton.setPreferredSize(new java.awt.Dimension(25, 25));
        control.add(upButton);

        downButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/arw_down_24.png"))); // NOI18N
        downButton.setToolTipText("Move Down");
        downButton.setMaximumSize(new java.awt.Dimension(25, 25));
        downButton.setMinimumSize(new java.awt.Dimension(25, 25));
        downButton.setPreferredSize(new java.awt.Dimension(25, 25));
        control.add(downButton);

        jPanel2.add(control);

        controlPanel.add(jPanel2);

        xPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("X-axis"));
        xPanel.setFocusTraversalPolicyProvider(true);
        xPanel.setMaximumSize(new java.awt.Dimension(70, 50));
        xPanel.setMinimumSize(new java.awt.Dimension(70, 50));
        xPanel.setPreferredSize(new java.awt.Dimension(70, 50));
        xPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar3.setBorder(null);
        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        zoomOutXButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/zoom_out_16.png"))); // NOI18N
        zoomOutXButton.setToolTipText("Zoom Out (X)");
        zoomOutXButton.setMaximumSize(new java.awt.Dimension(30, 30));
        zoomOutXButton.setMinimumSize(new java.awt.Dimension(30, 30));
        zoomOutXButton.setPreferredSize(new java.awt.Dimension(30, 30));
        jToolBar3.add(zoomOutXButton);

        zoomInXButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/zoom_in_16.png"))); // NOI18N
        zoomInXButton.setToolTipText("Zoom In (X)");
        zoomInXButton.setMaximumSize(new java.awt.Dimension(30, 30));
        zoomInXButton.setMinimumSize(new java.awt.Dimension(30, 30));
        zoomInXButton.setPreferredSize(new java.awt.Dimension(30, 30));
        jToolBar3.add(zoomInXButton);

        xPanel.add(jToolBar3);

        controlPanel.add(xPanel);

        yPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Y-axis"));
        yPanel.setFocusTraversalPolicyProvider(true);
        yPanel.setMaximumSize(new java.awt.Dimension(70, 50));
        yPanel.setMinimumSize(new java.awt.Dimension(70, 50));
        yPanel.setPreferredSize(new java.awt.Dimension(70, 50));
        yPanel.setLayout(new java.awt.GridLayout(1, 0));

        jToolBar4.setBorder(null);
        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        zoomOutYButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/zoom_out_16.png"))); // NOI18N
        zoomOutYButton.setToolTipText("Zoom Out (Y)");
        zoomOutYButton.setMaximumSize(new java.awt.Dimension(30, 30));
        zoomOutYButton.setMinimumSize(new java.awt.Dimension(30, 30));
        zoomOutYButton.setPreferredSize(new java.awt.Dimension(30, 30));
        jToolBar4.add(zoomOutYButton);

        zoomInYButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/zoom_in_16.png"))); // NOI18N
        zoomInYButton.setToolTipText("Zoom In (Y)");
        zoomInYButton.setMaximumSize(new java.awt.Dimension(30, 30));
        zoomInYButton.setMinimumSize(new java.awt.Dimension(30, 30));
        zoomInYButton.setName(""); // NOI18N
        zoomInYButton.setNextFocusableComponent(this);
        zoomInYButton.setPreferredSize(new java.awt.Dimension(30, 30));
        jToolBar4.add(zoomInYButton);

        yPanel.add(jToolBar4);

        controlPanel.add(yPanel);

        add(controlPanel, java.awt.BorderLayout.SOUTH);

        graphScroll.setMinimumSize(new java.awt.Dimension(0, 0));
        graphScroll.setPreferredSize(new java.awt.Dimension(0, 0));

        graphPanel.setBackground(new java.awt.Color(0, 0, 0));
        graphPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        graphPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        graphPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        graphPanel.setVerifyInputWhenFocusTarget(false);
        graphPanel.setLayout(new javax.swing.BoxLayout(graphPanel, javax.swing.BoxLayout.LINE_AXIS));
        graphScroll.setViewportView(graphPanel);

        add(graphScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void connectDataToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectDataToggleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_connectDataToggleButtonActionPerformed

    private void jText_UpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_UpperActionPerformed
        // TODO add your handling code here:

        System.out.println(jText_Upper.getText());
        upper_y = parseDouble(jText_Upper.getText());

        upper_y = upper_y*100;
        GP.set_upper(0,upper_y);
        GP.repaint();
        
    }//GEN-LAST:event_jText_UpperActionPerformed
    

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runButtonActionPerformed

    private void probeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probeSelectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_probeSelectButtonActionPerformed

    private void jText_LowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jText_LowerActionPerformed
        // TODO add your handling code here:
        System.out.println(jText_Lower.getText());
        lower_y = parseDouble(jText_Lower.getText());

        lower_y = lower_y*100;
        GP.set_lower(0,lower_y);
        GP.repaint();
    }//GEN-LAST:event_jText_LowerActionPerformed

    DecimalFormat df = new DecimalFormat("#.###");

    public void summary(String name) {
        //String name = HydeFormat.parseName(pid);
        Vector channels = GP.getChannels();
        Enumeration chenu = channels.elements();
        while (chenu.hasMoreElements()) {
            Channel channel = (Channel) chenu.nextElement();
            String legend = channel.getDataLegend();
            if (legend.equals(name)) {
                Vector data = channel.getData();
                Enumeration enu = data.elements();
                double[] doubleData = new double[data.size()];
                int i = 0;
                while (enu.hasMoreElements()) {
                    Point2D p2d = (Point2D) enu.nextElement();
                    doubleData[i] = p2d.getY() / 100.0;
                    i++;
                }
                GD.graphTotalData = data.size();
                GD.graphAverage = Double.valueOf(df.format(HydeMath.average(doubleData)));
                GD.graphSTD = Double.valueOf(df.format(HydeMath.standardDeviationCalculate(doubleData)));
                GD.graphMax = HydeMath.findMax(doubleData);
                GD.graphMin = HydeMath.findMin(doubleData);
                if (HDS2 != null) {
                    GD.graphAlarm = HDS2.getRowVector().size();
                }
                if (HDS3 != null) {
                    GD.graphFixed = HDS3.getRowVector().size();
                }
                return;
            }
        }
        GD.graphTotalData = 0;
        GD.graphAverage = 0;
        GD.graphSTD = 0;
        GD.graphMax = 0;
        GD.graphMin = 0;
        GD.graphAlarm = 0;
        GD.graphFixed = 0;
    }

    public void setSummary() {

    }

    public ScopeDriver findScopeDriver(String name) {
        Enumeration enu = VSD.elements();
        while (enu.hasMoreElements()) {
            ScopeDriver msd = (ScopeDriver) enu.nextElement();
            //System.out.println("> " +msd.getID()+ " vs "+name);
            if (msd.getID().equals(name)) {
                return msd;
            }
        }
        //System.out.println("RETURN NULL JA");
        return null;
    }

    public void addScope(String name, int channelID) {
        VSD.add(new ScopeDriver(GP, name, channelID));
    }

    public void removeAllScopeDriver() {
        VSD.removeAllElements();
        GP.removeAllChannels();
    }

    protected void createLegendEdit(JPanel p) {
        JCheckBox act;
        JTextField leg;
        GridBagLayout g = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        p.setLayout(g);
        if (GP == null) {
            return;
        }
        Vector HydeChannels = GP.getChannels();
        legendFix.clear();
        legendEdit.clear();
        for (int i = 0; i < HydeChannels.size(); i++) {
            Channel c = (Channel) HydeChannels.elementAt(i);
            leg = new JTextField(30);
            leg.setText(c.getDataLegend());
            legendEdit.put(leg, c);
            leg.addActionListener(this);
            act = new JCheckBox("HydeChannel " + (i + 1));
            act.setSelected(c.isActive());
            legendFix.put(act, c);
            act.addChangeListener(this);
            constraints.gridwidth = GridBagConstraints.RELATIVE;
            g.setConstraints(act, constraints);
            p.add(act);
            constraints.gridwidth = GridBagConstraints.REMAINDER;
            g.setConstraints(leg, constraints);
            p.add(leg);
        }
    }

    private void setPrimary() {
        if (primaryComboBox != null && primaryComboBox.getSelectedItem() != null) {
            if (primaryComboBox.getSelectedItem().equals("-")) {
                GP.enableLimitLine(false, null);
            } else {
                int ch = Integer.parseInt((String) primaryComboBox.getSelectedItem()) - 1;
                String chl = GP.getChannel(ch).getDataLegend();
                String probeID = HydeFormat.parseID(chl);
                Vector limitSetVector = MIF.MF.HDC.queryRow("SELECT "
                        + "set_value, lower_limit, lower_time_limit, lower_extreme_limit, upper_limit, "
                        + "upper_time_limit, upper_extreme_limit "
                        + "FROM level_profile "
                        + "WHERE level_profile_id = "
                        + "(SELECT level_profile_id FROM probe WHERE probe_id = '" + probeID + "');");
                if (limitSetVector != null && limitSetVector.size() > 6) {
                    double[] limitSet = {
                        Double.parseDouble((String) limitSetVector.elementAt(0)),
                        Double.parseDouble((String) limitSetVector.elementAt(1)),
                        Double.parseDouble((String) limitSetVector.elementAt(2)),
                        Double.parseDouble((String) limitSetVector.elementAt(3)),
                        Double.parseDouble((String) limitSetVector.elementAt(4)),
                        Double.parseDouble((String) limitSetVector.elementAt(5)),
                        Double.parseDouble((String) limitSetVector.elementAt(6)),};
                    GP.enableLimitLine(true, limitSet);
                }
            }
        }
    }

    public QueryDialog LD;
    public Vector<Vector> dataSet = new Vector<Vector>();

    public void returnedDataSet(Vector<Vector> ds) {
        dataSet = ds;
    }

    public void load(String sql, String name, boolean append, String unit) // 0 = C, 1 = K, 2 = F
    {
        /*QueryThread QGT = new QueryThread(sql,MIF.MF.HDC,this);
         Thread t = new Thread(QGT);
         LD = new QueryDialog(MIF.MF,"Loading data from database...",false,QGT);
         t.start();
         QGT.setLoadingScreen(LD);*/
        Vector<Vector> dataSet;
        dataSet = MIF.MF.HDC.queryAll(sql);
        try {
            HydeDataSet HDS = new HydeDataSet(dataSet);
            int u = 0;
            if (unit.toLowerCase().equals("k")) {
                u = 1;
            } else if (unit.toLowerCase().equals("f")) {
                u = 2;
            }
            if (!append) {
                findScopeDriver(name).oscopeClear();
            }
            if (HDS.getColumnSize() >= 2) {
                Vector v = HDS.getRowVector();
                Enumeration enu = v.elements();
                while (enu.hasMoreElements()) {
                    Vector nv = (Vector) enu.nextElement();
                    String str = (String) nv.elementAt(1);
                    Date d;
                    long data;
                    try {
                        d = HydeFormat.formatDate(str);
                        data = d.getTime();
                        data /= 1000;
                        //System.out.println("Data = "+Double.parseDouble((String)nv.elementAt(0))+"  :  Time = "+data+"/"+d.getTime());
                    } catch (Exception e) {
                        System.out.println("GraphDisplayPanel/load Error : " + e);
                        break;
                    }
                    
                    double value = Double.parseDouble((String) nv.elementAt(0));
                    //System.out.println("value "+value);
                    //System.out.println("data "+data);
                    switch (u) {
                        case 1: // Kelvin
                            value = (((int) (value * 100)) + 27315) / 100.0;
                             
                            break;
                        case 2: // Fahrenheit
                            value = value * 9.0 / 5.0;
                            value = (((int) (value * 100)) + 3200) / 100.0;
                            
                            break;
                             
                    }
                   
                    //packet = HydeFormat.dateToInteger(d);
                    Date LU = MIF.MF.HDC.parseDateTime(str);
                    lastUpdate = LU;
                    //year = d.getYear()+1900;

                    if (LU != null) {
                        LU.setSeconds(LU.getSeconds() + 1);
                        //System.out.println("SET LAST UPDATE : "+MIF.MF.HDC.formatDateTime(LU));
                        findScopeDriver(name).setLastUpdate(MIF.MF.HDC.formatDateTime(LU));
                    }
                    //findScopeDriver(name).oscopeReceived(name,packet,Double.parseDouble((String)nv.elementAt(0)));
                    findScopeDriver(name).oscopeReceived(name, data, value);
                }
            }
            //findScopeDriver(name).setCenterData(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSelectedProbe(Object[] obj) {
        selectedProbe = obj;
    }

    public void addPoint() {
        for (int i = 0; i < selectedProbe.length; i++) {
            int id = 0;
            try {
                String str = (String) selectedProbe[i];
                id = Integer.parseInt(str.charAt(4) + "");
                String strCut = str.substring(10);
                String deviceID = HydeFormat.parseID(strCut);
                String name = HydeFormat.parseName(strCut);
                String unit = " <" + MIF.MF.HDC.query0("SELECT channel_unit FROM device_channel WHERE device_id = '" + deviceID + "' AND channel = '" + id + "';") + ">";
                //addScope(str,id);
                Date nowdate = new Date();
                String to = MIF.MF.HDC.formatDateTime(nowdate);
                String from = findScopeDriver(str).getLastUpdate();
                String dataType = "(";
                if (realtimeCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 101 OR ";
                }
                if (loggingCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 102 OR ";
                }
                if (savedCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 103 OR ";
                }
                dataType += "false) AND ";
                String dataRange = "( data_timestamp BETWEEN '" + from + "' AND '" + to + "' )";
                load("SELECT data_value, data_timestamp FROM data WHERE device_id = '" + deviceID + "' AND channel = '" + id + "' AND " + dataType + dataRange + " ORDER BY data_timestamp ASC;", str, true, unit);
                if (i == 0) {
                    findScopeDriver(str).setCenterData(str);
                }
                //System.out.println("SELECT data_value, data_timestamp FROM data WHERE probe_id = '"+id+"' AND "+dataType+dataRange+" ORDER BY data_timestamp ASC;");
            } catch (Exception ee) {
                System.out.println("TemperatureGraphPanel/actionPerformed/runButton error : " + ee);
                ee.printStackTrace();
                id = 0;
            }
        }
    }

    private void runGraph() {
        removeAllScopeDriver();
        //channelVector = new Vector();
        primaryComboBox.removeActionListener(this);
        primaryComboBox.removeAllItems();
        primaryComboBox.addItem("-");

        for (int i = 0; i < selectedProbe.length; i++) {
            int id = 0;
            try {
                String str = (String) selectedProbe[i];
                id = Integer.parseInt(str.charAt(4) + "");
                String deviceID = HydeFormat.parseID(str);
                String unit = " <" + MIF.MF.HDC.query0("SELECT channel_unit FROM device_channel WHERE device_id = '" + deviceID + "' AND channel = '" + id + "';") + ">";
                addScope(str, id);

                String from = getFromTime();
                String to = getToTime();
                String dataType = "(";
                if (realtimeCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 101 OR ";
                }
                if (loggingCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 102 OR ";
                }
                if (savedCheckBox.isSelected()) {
                    dataType += "data.DATA_TYPE_ID = 103 OR ";
                }
                dataType += "false) AND ";
                String dataRange = "( data_timestamp BETWEEN '" + from + "' AND '" + to + "' )";
                load("SELECT data_value, data_timestamp FROM data WHERE device_id = '" + deviceID + "' AND channel = '" + id + "' AND " + dataType + dataRange + " ORDER BY data_timestamp ASC;", str, false, unit);
                if (i == 0) {
                    findScopeDriver(str).setCenterData(str);
                }
                primaryComboBox.addItem((i + 1) + "");
            } catch (Exception ee) {
                System.out.println("TemperatureGraphPanel/actionPerformed/runButton error : " + ee);
                ee.printStackTrace();
                id = 0;
            }
        }
        primaryComboBox.addActionListener(this);
        drawAlarmCurrent();
        drawAlarm();
        summary("0 ()");
        setSummary();
    }

    private void drawAlarmCurrent() {
        String from = getFromTime();
        String to = getToTime();
        String pid = "(";
        for (int i = 0; i < selectedProbe.length; i++) {
            try {
                String str = (String) selectedProbe[i];
                str = str.substring(10);
                String id = HydeFormat.parseID(str);
                //id = id.substring(0,id.length()-1);
                pid += "device_id = '" + id + "' OR ";
            } catch (Exception ee) {
                System.out.println("GraphDisplayPanel/drawAlarm error : " + ee);
                ee.printStackTrace();
            }
        }
        pid += "false) AND ";
        Vector v = MIF.MF.HDC.queryAll("SELECT "
                + "alarm_id, device_id, error_name, alarm_source, alarm_timestamp "
                + "FROM alarm_current NATURAL JOIN error "
                + "WHERE " + pid + " alarm_timestamp BETWEEN '" + from + "' AND '" + to + "';");

        HDS2 = new HydeDataSet(v);
        Vector rowData = HDS2.getRowVector();
        Enumeration enu = rowData.elements();
        agdVector = new Vector();
        while (enu.hasMoreElements()) {
            try {
                Vector rd = (Vector) enu.nextElement();
                AlarmGraphData AGD = new AlarmGraphData();
                AGD.alarmID = (String) rd.elementAt(0);
                AGD.deviceID = (String) rd.elementAt(1);
                AGD.errorName = (String) rd.elementAt(2);
                AGD.alarmSource = (String) rd.elementAt(3);
                AGD.alarmTimeStamp = (String) rd.elementAt(4);
                Date d = HydeFormat.formatDate((String) rd.elementAt(4));
                Long dataConvert = d.getTime();
                dataConvert /= 1000;
                AGD.alarmTimeLong = dataConvert;
                agdVector.add(AGD);
            } catch (Exception e) {

            }
        }
        GP.setAlarmGraphData(agdVector);
    }

    public void drawAlarm() {
        String from = getFromTime();
        String to = getToTime();
        String pid = "(";
        for (int i = 0; i < selectedProbe.length; i++) {
            try {
                String str = (String) selectedProbe[i];
                str = str.substring(10);
                String id = HydeFormat.parseID(str);
                //id = id.substring(0,id.length()-1);
                pid += "device_id = '" + id + "' OR ";
            } catch (Exception ee) {
                System.out.println("TemperatureGraphPanel/setTable error : " + ee);
            }
        }
        pid += "false) AND ";
        Vector v = MIF.MF.HDC.queryAll("SELECT "
                + "alarm_id, device_id, error_name, alarm_source, alarm_timestamp, "
                + "system_timestamp "
                + "FROM " + MIF.MF.HDC.database + "_log.alarm_log NATURAL JOIN " + MIF.MF.SD.defaultDatabase + ".error "
                + "WHERE " + pid + " alarm_timestamp BETWEEN '" + from + "' AND '" + to + "';");
        HDS3 = new HydeDataSet(v);
        Vector rowData = HDS3.getRowVector();
        Enumeration enu = rowData.elements();
        agdFixedVector = new Vector();
        while (enu.hasMoreElements()) {
            try {
                Vector rd = (Vector) enu.nextElement();
                AlarmGraphData AGD = new AlarmGraphData();
                AGD.alarmID = (String) rd.elementAt(0);
                AGD.deviceID = (String) rd.elementAt(1);
                AGD.errorName = (String) rd.elementAt(2);
                AGD.alarmSource = (String) rd.elementAt(3);
                AGD.alarmTimeStamp = (String) rd.elementAt(4);
                Date d = HydeFormat.formatDate((String) rd.elementAt(4));
                Long dataConvert = d.getTime();
                dataConvert /= 1000;
                AGD.alarmTimeLong = dataConvert;
                AGD.alarmFixedTimeStamp = (String) rd.elementAt(5);
                Date d2 = HydeFormat.formatDate((String) rd.elementAt(5));
                Long dataConvert2 = d2.getTime();
                dataConvert2 /= 1000;
                AGD.alarmFixedTimeLong = dataConvert2;
                agdFixedVector.add(AGD);
            } catch (Exception e) {

            }
        }
        GP.setAlarmFixedGraphData(agdFixedVector);
    }

    public void setGraphBound(double yBottom, double yTop, long timeRange, Date time) {
        GP.top = (yTop * 100);// + (yTop*10 - ((yTop*10)%100));
        GP.bottom = (yBottom * 100);// - (yBottom*10 - ((yBottom*10)%100));
        GP.end = 0;
        GP.start = 0;
        GP.end += (time.getTime() / 1000 + timeRange / 2);
        GP.start += (time.getTime() / 1000 - timeRange / 2);

        //GP.start -= timeRange/2;
        //GP.end += timeRange/2;
        GP.repaint();
    }

    public String getFromTime() {
        Date d1 = JDC1.getDate();
        d1.setHours(Integer.parseInt((String) fromHourComboBox.getSelectedItem()));
        d1.setMinutes(Integer.parseInt((String) fromMinComboBox.getSelectedItem()));
        //d1.setSeconds(Integer.parseInt((String)fromSecComboBox.getSelectedItem()));
        return HydeFormat.SDF.format(d1);
    }

    public String getToTime() {
        Date d2 = JDC2.getDate();
        d2.setHours(Integer.parseInt((String) toHourComboBox.getSelectedItem()));
        d2.setMinutes(Integer.parseInt((String) toMinComboBox.getSelectedItem()));
        //d2.setSeconds(Integer.parseInt((String)toSecComboBox.getSelectedItem()));
        return HydeFormat.SDF.format(d2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton alarmIconToggleButton;
    private javax.swing.JToggleButton colorToggleButton;
    private javax.swing.JToggleButton connectDataToggleButton;
    private javax.swing.JToolBar control;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton downButton;
    private javax.swing.JPanel fromCalendar;
    private javax.swing.JComboBox fromHourComboBox;
    private javax.swing.JComboBox fromMinComboBox;
    public javax.swing.JPanel graphPanel;
    private javax.swing.JScrollPane graphScroll;
    private javax.swing.JToggleButton gridLineToggleButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jText_Lower;
    private javax.swing.JTextField jText_Upper;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToggleButton labelToggleButton;
    private javax.swing.JButton leftButton;
    public javax.swing.JCheckBox loggingCheckBox;
    public javax.swing.JComboBox primaryComboBox;
    private javax.swing.JButton printButton;
    private javax.swing.JButton probeSelectButton;
    private javax.swing.JToggleButton realtimeButton;
    public javax.swing.JCheckBox realtimeCheckBox;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton runButton;
    public javax.swing.JCheckBox savedCheckBox;
    private javax.swing.JPanel toCalendar;
    private javax.swing.JComboBox toHourComboBox;
    private javax.swing.JComboBox toMinComboBox;
    private javax.swing.JButton trimButton;
    private javax.swing.JButton upButton;
    private javax.swing.JPanel xPanel;
    private javax.swing.JPanel yPanel;
    private javax.swing.JButton zoomInXButton;
    private javax.swing.JButton zoomInYButton;
    private javax.swing.JButton zoomOutXButton;
    private javax.swing.JButton zoomOutYButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        //Object c = legendEdit.get(src);
        /*if (c != null) {
         if (c instanceof Channel) {
         ((Channel)c).setDataLegend(((JTextField)src).getText());
         GP.repaint(100);
         }
         }*/
        if (src == labelToggleButton) {
            GP.setLegendEnabled(labelToggleButton.isSelected());
        } else if (src == connectDataToggleButton) {
            GP.setConnectPoints(connectDataToggleButton.isSelected());
        } else if (src == colorToggleButton) {
            GP.setReverseColor(colorToggleButton.isSelected());
            if (colorToggleButton.isSelected()) {
                this.setBackground(Color.black);
            } else {
                this.setBackground(Color.white);
            }
        } else if (src == alarmIconToggleButton) {
            GP.enableAlarmIcon(alarmIconToggleButton.isSelected());
        } else if (src == gridLineToggleButton) {
            GP.enableGrid(gridLineToggleButton.isSelected());
        } else if (src == zoomOutXButton) {
            GP.zoom_out_x();
            GP.repaint();
        } else if (src == zoomInXButton) {
            GP.zoom_in_x();
            GP.repaint();
        } else if (src == zoomOutYButton) {
            GP.zoom_out_y();
            GP.repaint();
        } else if (src == zoomInYButton) {
            GP.zoom_in_y();
            GP.repaint();
        } else if (src == upButton) {
            GP.move_up();
            GP.repaint();
        } else if (src == downButton) {
            GP.move_down();
            GP.repaint();
        } else if (src == rightButton) {
            GP.move_right();
            GP.repaint();
        } else if (src == leftButton) {
            GP.move_left();
            GP.repaint();
        } else if (src == trimButton) {
            GraphBoundDialog GBD = new GraphBoundDialog(this, GP.top, GP.bottom, GP.end - GP.start, lastUpdate);
        } else if (src == primaryComboBox) {
            setPrimary();
        } else if (src == printButton) {
            String dep = "Unknown";
            if (selectedProbe.length > 0) {
                String[] depID = new String[selectedProbe.length];
                String departs = " FALSE ";
                for (int i = 0; i < selectedProbe.length; i++) {
                    String str = (String) selectedProbe[i];
                    String id = HydeFormat.parseID(str);
                    depID[i] = MIF.MF.HDC.query0("SELECT depart_id FROM device_group WHERE device_group_id = "
                            + "(SELECT device_group_id FROM device WHERE device_id = '" + id + "')"
                            + ";");
                    departs += " OR depart_id = '" + depID[i] + "'";
                }
                Vector depVector = MIF.MF.HDC.queryColumn("SELECT DISTINCT depart_name FROM department WHERE " + departs + ";");
                //Vector orgVector = MIF.MF.HDC.queryColumn("SELECT DISTINCT organization_name FROM department NATURAL JOIN organization WHERE "+departs+";");
                if (depVector.size() > 0) {
                    dep = "";
                    Enumeration enu = depVector.elements();
                    while (enu.hasMoreElements()) {
                        dep += enu.nextElement() + ", ";
                    }
                    dep = dep.substring(0, dep.length() - 2);
                }
            }
            String from = getFromTime();
            String to = getToTime();

            Vector statData = new Vector();
            for (int i = 0; i < selectedProbe.length; i++) {
                try {
                    String str = (String) selectedProbe[i];
                    char ch = str.charAt(4);
                    String id = HydeFormat.parseID(str);
                    String unit = " <" + MIF.MF.HDC.query0("SELECT channel_unit FROM device_channel WHERE device_id = '" + id + "' AND channel = '" + ch + "';") + ">";
                    summary(str);
                    Vector v = new Vector();
                    v.add(str + unit);
                    v.add(GD.graphAverage + " : " + GD.graphTotalData);
                    v.add(GD.graphMax);
                    v.add(GD.graphMin);
                    v.add(GD.graphSTD);
                    v.add(GD.graphFixed + " / " + (GD.graphAlarm + GD.graphFixed));
                    statData.add(v);
                } catch (Exception ee) {
                    System.out.println("TemperatureGraphPanel/setTable error : ");
                    ee.printStackTrace();
                }
            }
            summary("0 ()");

            GraphPrintFormatter GPF = new GraphPrintFormatter(GP, dep, from + " - " + to, statData);
            PrintDialog PF = new PrintDialog(GPF, this);
        } else if (src == realtimeButton && realtimeButton.isSelected()) {
            RT = new RealtimeTimer(this);
            realtimeThread = new Thread(RT);
            realtimeThread.start();
            realtimeButton.setIcon(stopIcon);
        } else if (src == realtimeButton && !realtimeButton.isSelected()) {
            RT.stopClock();
            realtimeButton.setIcon(playIcon);
        } else if (src == runButton) {
            runGraph();
            graphPanel.repaint();
        } else if (src == probeSelectButton) {
            ProbeSelectDialog PSD = new ProbeSelectDialog(this);
        }

    }

    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource();
        boolean on = e.getStateChange() == ItemEvent.SELECTED;
        /*if (src == scrollingCBox)
         {
         GP.setSliding(on);
         } */
    }

    public void stateChanged(ChangeEvent e) {
        Object src = e.getSource();
        /*if(src == timeSlider)
         {
         System.out.println(GP.maximum_x - GP.minimum_x);
         double percent = (timeSlider.getValue());
         int diff = GP.end - GP.start;
         GP.end = GP.minimum_x + (int)((GP.maximum_x - GP.minimum_x) * percent);
         GP.start = GP.end - diff;
         }
         /*
         for( int i=0;i<panel.NUM_HydeChannelS;i++ )
         if( src == legendFix[i] )
         panel.legendFix[i] = legendFix[i].isSelected();
         */
        Object c = legendFix.get(src);
        if ((c != null) && (c instanceof Channel)) {
            ((Channel) c).setActive(((javax.swing.JCheckBox) src).isSelected());
        }
        GP.repaint(100);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        int px = e.getX();
        int py = e.getY();
        String alarmID = GP.alarmIconIsHere(px, py);
        if (alarmID != null) {
            if (alarmID.indexOf("ac") == 0) // alarm current
            {
                String aid = alarmID.substring(2, alarmID.length());
                System.out.println(aid);
            } else if (alarmID.indexOf("fs") == 0) // fixed start
            {
                String aid = alarmID.substring(2, alarmID.length());
                System.out.println(aid);
            } else if (alarmID.indexOf("fe") == 0) // fixed end
            {
                String aid = alarmID.substring(2, alarmID.length());
                System.out.println(aid);
            }
        }
    }

//    private void draw_upper() {
//        Graphics2D g2d = (Graphics2D) g;
//        //g2d.setColor(Color.RED);
//        g2d.drawLine(graphPanel.getX(),graphPanel.getY(), graphPanel.getX()+100, graphPanel.getY());
//       
//    }

}


