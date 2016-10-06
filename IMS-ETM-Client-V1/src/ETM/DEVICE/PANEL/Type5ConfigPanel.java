package ETM.DEVICE.PANEL;

import ETM.Util.HydeFormat;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import HydeModule.Table.HydeDataSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Type5ConfigPanel extends javax.swing.JPanel implements ActionListener, MouseListener
{

    private ImageIcon remove = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/temp_remove_16.png"));
    private ImageIcon add = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/temp_add_16.png"));

    
    private static String defaultGroupComboBox = "Select a group...";
    private static String defaultLocationComboBox = "Select a location...";
    private static String defaultHostComboBox = "Select a host...";
    private static String defaultProfileComboBox = "Select a profile...";
    
    private String ID;
    private DeviceModifyPanel DMP;
    private String originalIP = "127.0.0.1";
    private String originalPort = "10000";
    
    public int[] enable = new int[5];
    
    public Type5ConfigPanel(DeviceModifyPanel DMP, String ID) 
    {
        this.ID = ID;
        this.DMP = DMP;
        initComponents();
        extendComponents();
        actionComponents();
    }
    
    private void extendComponents()
    {
        setComboBoxes();
        setInfo();
    }
    
    private void actionComponents()
    {
        probeEnable1.addActionListener(this);
        probeEnable2.addActionListener(this);
        probeEnable3.addActionListener(this);
        probeEnable4.addActionListener(this);
        probeEnable5.addActionListener(this);
        
        probeDisable1.addActionListener(this);
        probeDisable2.addActionListener(this);
        probeDisable3.addActionListener(this);
        probeDisable4.addActionListener(this);
        probeDisable5.addActionListener(this);
        
        sensor1_1.addMouseListener(this);
        profileComboBox.addActionListener(this);
        profileSetButton.addActionListener(this);
        profileSaveButton.addActionListener(this);
        profileNewButton.addActionListener(this);
        profileDeleteButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buzzerGroup1 = new javax.swing.ButtonGroup();
        buzzerGroup2 = new javax.swing.ButtonGroup();
        digitalGroup1 = new javax.swing.ButtonGroup();
        digitalGroup2 = new javax.swing.ButtonGroup();
        digitalGroup3 = new javax.swing.ButtonGroup();
        digitalGroup4 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        channelsPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jToolBar4 = new javax.swing.JToolBar();
        probeEnable3 = new javax.swing.JButton();
        probeDisable3 = new javax.swing.JButton();
        jToolBar7 = new javax.swing.JToolBar();
        probeEnable5 = new javax.swing.JButton();
        probeDisable5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        probeEnable1 = new javax.swing.JButton();
        probeDisable1 = new javax.swing.JButton();
        jToolBar6 = new javax.swing.JToolBar();
        probeEnable4 = new javax.swing.JButton();
        probeDisable4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        probeTypeCB1 = new javax.swing.JComboBox();
        probeTypeCB2 = new javax.swing.JComboBox();
        probeTypeCB3 = new javax.swing.JComboBox();
        probeTypeCB4 = new javax.swing.JComboBox();
        probeTypeCB5 = new javax.swing.JComboBox();
        probeName1 = new javax.swing.JTextField();
        probeName2 = new javax.swing.JTextField();
        probeName3 = new javax.swing.JTextField();
        probeName4 = new javax.swing.JTextField();
        probeName5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar3 = new javax.swing.JToolBar();
        probeEnable2 = new javax.swing.JButton();
        probeDisable2 = new javax.swing.JButton();
        hostComboBox1 = new javax.swing.JComboBox();
        hostComboBox2 = new javax.swing.JComboBox();
        hostComboBox3 = new javax.swing.JComboBox();
        hostComboBox4 = new javax.swing.JComboBox();
        hostComboBox5 = new javax.swing.JComboBox();
        informationPanel = new javax.swing.JPanel();
        idField = new javax.swing.JTextField();
        serialField = new javax.swing.JTextField();
        typeCB = new javax.swing.JComboBox();
        locationLabel = new javax.swing.JLabel();
        groupCB = new javax.swing.JComboBox();
        nameLabel = new javax.swing.JLabel();
        serialLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        locationButton = new javax.swing.JButton();
        typeLabel = new javax.swing.JLabel();
        locationCB = new javax.swing.JComboBox();
        nameField = new javax.swing.JTextField();
        operatingPanel = new javax.swing.JPanel();
        realtimeModeRadioButton = new javax.swing.JRadioButton();
        loogerModeRadioButton = new javax.swing.JRadioButton();
        deviceEnableCheckBox = new javax.swing.JCheckBox();
        alarmEnableCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        portField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jToolBar5 = new javax.swing.JToolBar();
        profileSaveButton = new javax.swing.JButton();
        profileNewButton = new javax.swing.JButton();
        profileDeleteButton = new javax.swing.JButton();
        profileComboBox = new javax.swing.JComboBox();
        profileLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        connectionLostField = new javax.swing.JTextField();
        batteryField = new javax.swing.JTextField();
        memoryField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        connectionMethodCB = new javax.swing.JCheckBox();
        batteryMethodCB = new javax.swing.JCheckBox();
        memoryMethodCB = new javax.swing.JCheckBox();
        methodDetailsPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        buzzerDetailScroll = new javax.swing.JScrollPane();
        buzzerDetailPanel = new javax.swing.JPanel();
        error1CB = new javax.swing.JCheckBox();
        acPowerCB = new javax.swing.JCheckBox();
        di1CB = new javax.swing.JCheckBox();
        rising1RB = new javax.swing.JRadioButton();
        falling1RB = new javax.swing.JRadioButton();
        di2CB = new javax.swing.JCheckBox();
        rising2RB = new javax.swing.JRadioButton();
        falling2RB = new javax.swing.JRadioButton();
        batteryCB = new javax.swing.JCheckBox();
        memoryCB = new javax.swing.JCheckBox();
        connectionCB = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        sensor1_1 = new javax.swing.JLabel();
        sensor2_1 = new javax.swing.JLabel();
        error2CB = new javax.swing.JCheckBox();
        sensor3_1 = new javax.swing.JLabel();
        error3CB = new javax.swing.JCheckBox();
        sensor4_1 = new javax.swing.JLabel();
        error4CB = new javax.swing.JCheckBox();
        sensor5_1 = new javax.swing.JLabel();
        error5CB = new javax.swing.JCheckBox();
        maCB = new javax.swing.JCheckBox();
        sensor1_2 = new javax.swing.JLabel();
        sensor1UpperOP = new javax.swing.JComboBox();
        sensor2UpperOP = new javax.swing.JComboBox();
        sensor3UpperOP = new javax.swing.JComboBox();
        sensor4UpperOP = new javax.swing.JComboBox();
        sensor5UpperOP = new javax.swing.JComboBox();
        sensor1_3 = new javax.swing.JLabel();
        sensor1LowerOP = new javax.swing.JComboBox();
        sensor2LowerOP = new javax.swing.JComboBox();
        sensor3LowerOP = new javax.swing.JComboBox();
        sensor4LowerOP = new javax.swing.JComboBox();
        sensor5LowerOP = new javax.swing.JComboBox();
        memerrorCB = new javax.swing.JCheckBox();
        buzzerDetailScroll1 = new javax.swing.JScrollPane();
        buzzerDetailPanel1 = new javax.swing.JPanel();
        error1CB1 = new javax.swing.JCheckBox();
        acPowerCB1 = new javax.swing.JCheckBox();
        di1CB1 = new javax.swing.JCheckBox();
        rising1RB1 = new javax.swing.JRadioButton();
        falling1RB1 = new javax.swing.JRadioButton();
        di2CB1 = new javax.swing.JCheckBox();
        rising2RB1 = new javax.swing.JRadioButton();
        falling2RB1 = new javax.swing.JRadioButton();
        batteryCB1 = new javax.swing.JCheckBox();
        memoryCB1 = new javax.swing.JCheckBox();
        connectionCB1 = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        sensor1_4 = new javax.swing.JLabel();
        sensor2_2 = new javax.swing.JLabel();
        error2CB1 = new javax.swing.JCheckBox();
        sensor3_2 = new javax.swing.JLabel();
        error3CB1 = new javax.swing.JCheckBox();
        sensor4_2 = new javax.swing.JLabel();
        error4CB1 = new javax.swing.JCheckBox();
        sensor5_2 = new javax.swing.JLabel();
        error5CB1 = new javax.swing.JCheckBox();
        maCB1 = new javax.swing.JCheckBox();
        sensor1_5 = new javax.swing.JLabel();
        sensor1UpperOP1 = new javax.swing.JComboBox();
        sensor2UpperOP1 = new javax.swing.JComboBox();
        sensor3UpperOP1 = new javax.swing.JComboBox();
        sensor4UpperOP1 = new javax.swing.JComboBox();
        sensor5UpperOP1 = new javax.swing.JComboBox();
        sensor1_6 = new javax.swing.JLabel();
        sensor1LowerOP1 = new javax.swing.JComboBox();
        sensor2LowerOP1 = new javax.swing.JComboBox();
        sensor3LowerOP1 = new javax.swing.JComboBox();
        sensor4LowerOP1 = new javax.swing.JComboBox();
        sensor5LowerOP1 = new javax.swing.JComboBox();
        normally1 = new javax.swing.JCheckBox();
        memerrorCB1 = new javax.swing.JCheckBox();
        buzzerDetailScroll2 = new javax.swing.JScrollPane();
        buzzerDetailPanel2 = new javax.swing.JPanel();
        error1CB2 = new javax.swing.JCheckBox();
        acPowerCB2 = new javax.swing.JCheckBox();
        di1CB2 = new javax.swing.JCheckBox();
        rising1RB2 = new javax.swing.JRadioButton();
        falling1RB2 = new javax.swing.JRadioButton();
        di2CB2 = new javax.swing.JCheckBox();
        rising2RB2 = new javax.swing.JRadioButton();
        falling2RB2 = new javax.swing.JRadioButton();
        batteryCB2 = new javax.swing.JCheckBox();
        memoryCB2 = new javax.swing.JCheckBox();
        connectionCB2 = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        sensor1_7 = new javax.swing.JLabel();
        sensor2_3 = new javax.swing.JLabel();
        error2CB2 = new javax.swing.JCheckBox();
        sensor3_3 = new javax.swing.JLabel();
        error3CB2 = new javax.swing.JCheckBox();
        sensor4_3 = new javax.swing.JLabel();
        error4CB2 = new javax.swing.JCheckBox();
        sensor5_3 = new javax.swing.JLabel();
        error5CB2 = new javax.swing.JCheckBox();
        maCB2 = new javax.swing.JCheckBox();
        sensor1_8 = new javax.swing.JLabel();
        sensor1UpperOP2 = new javax.swing.JComboBox();
        sensor2UpperOP2 = new javax.swing.JComboBox();
        sensor3UpperOP2 = new javax.swing.JComboBox();
        sensor4UpperOP2 = new javax.swing.JComboBox();
        sensor5UpperOP2 = new javax.swing.JComboBox();
        sensor1_9 = new javax.swing.JLabel();
        sensor1LowerOP2 = new javax.swing.JComboBox();
        sensor2LowerOP2 = new javax.swing.JComboBox();
        sensor3LowerOP2 = new javax.swing.JComboBox();
        sensor4LowerOP2 = new javax.swing.JComboBox();
        sensor5LowerOP2 = new javax.swing.JComboBox();
        normally2 = new javax.swing.JCheckBox();
        memerrorCB2 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        alarmMethod0 = new javax.swing.JCheckBox();
        alarmMethod1 = new javax.swing.JCheckBox();
        alarmMethod2 = new javax.swing.JCheckBox();
        di1Enable = new javax.swing.JCheckBox();
        di2Enable = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        di1DelayField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        di2DelayField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jToolBar8 = new javax.swing.JToolBar();
        profileSetButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        channelsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Channels"));

        jLabel5.setText("Probe Channel 4 : ");

        jToolBar4.setFloatable(false);
        jToolBar4.setRollover(true);

        probeEnable3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        probeEnable3.setToolTipText("Enable");
        probeEnable3.setFocusable(false);
        probeEnable3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeEnable3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(probeEnable3);

        probeDisable3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        probeDisable3.setToolTipText("Disable");
        probeDisable3.setEnabled(false);
        probeDisable3.setFocusable(false);
        probeDisable3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeDisable3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar4.add(probeDisable3);

        jToolBar7.setFloatable(false);
        jToolBar7.setRollover(true);

        probeEnable5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        probeEnable5.setToolTipText("Enable");
        probeEnable5.setFocusable(false);
        probeEnable5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeEnable5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(probeEnable5);

        probeDisable5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        probeDisable5.setToolTipText("Disable");
        probeDisable5.setEnabled(false);
        probeDisable5.setFocusable(false);
        probeDisable5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeDisable5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(probeDisable5);

        jLabel3.setText("Probe Channel 2 : ");

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        probeEnable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        probeEnable1.setToolTipText("Enable");
        probeEnable1.setFocusable(false);
        probeEnable1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeEnable1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(probeEnable1);

        probeDisable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        probeDisable1.setToolTipText("Disable");
        probeDisable1.setEnabled(false);
        probeDisable1.setFocusable(false);
        probeDisable1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeDisable1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(probeDisable1);

        jToolBar6.setFloatable(false);
        jToolBar6.setRollover(true);

        probeEnable4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        probeEnable4.setToolTipText("Enable");
        probeEnable4.setFocusable(false);
        probeEnable4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeEnable4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(probeEnable4);

        probeDisable4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        probeDisable4.setToolTipText("Disable");
        probeDisable4.setEnabled(false);
        probeDisable4.setFocusable(false);
        probeDisable4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeDisable4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(probeDisable4);

        jLabel1.setText("Probe Channel 1 : ");

        probeTypeCB1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TMEC", "PT100", "Type-K" }));

        probeTypeCB2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TMEC", "PT100", "Type-K" }));

        probeTypeCB3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TMEC", "PT100", "Type-K" }));

        probeTypeCB4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TMEC", "PT100", "Type-K" }));

        probeTypeCB5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TMEC", "PT100", "Type-K" }));

        jLabel6.setText("Probe Channel 5 : ");

        jLabel4.setText("Probe Channel 3 : ");

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);

        probeEnable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"))); // NOI18N
        probeEnable2.setToolTipText("Enable");
        probeEnable2.setFocusable(false);
        probeEnable2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeEnable2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(probeEnable2);

        probeDisable2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        probeDisable2.setToolTipText("Disable");
        probeDisable2.setEnabled(false);
        probeDisable2.setFocusable(false);
        probeDisable2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        probeDisable2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(probeDisable2);

        hostComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host..." }));

        hostComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host..." }));

        hostComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host..." }));

        hostComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host..." }));

        hostComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a host..." }));

        javax.swing.GroupLayout channelsPanelLayout = new javax.swing.GroupLayout(channelsPanel);
        channelsPanel.setLayout(channelsPanelLayout);
        channelsPanelLayout.setHorizontalGroup(
            channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(channelsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(channelsPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeTypeCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeName2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hostComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(channelsPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeTypeCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeName1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hostComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(channelsPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeTypeCB3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeName3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hostComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(channelsPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeTypeCB4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeName4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hostComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(channelsPanelLayout.createSequentialGroup()
                        .addComponent(jToolBar7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeTypeCB5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(probeName5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hostComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        channelsPanelLayout.setVerticalGroup(
            channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(channelsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probeTypeCB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(probeName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probeTypeCB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(probeName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probeTypeCB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(probeName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probeTypeCB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(probeName4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(channelsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(probeTypeCB5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(probeName5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hostComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));

        idField.setEnabled(false);

        typeCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ethernet Transmitter" }));
        typeCB.setEnabled(false);

        locationLabel.setText("Location");

        groupCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        nameLabel.setText("Device Name");

        serialLabel.setText("Product Serial");

        groupLabel.setText("Device Group");

        jLabel2.setText("Device ID");

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/view_16.png"))); // NOI18N
        locationButton.setFocusable(false);
        locationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        locationButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(locationButton);

        typeLabel.setText("Device Type");

        locationCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a location..." }));

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(serialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serialField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addComponent(groupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupCB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(groupLabel)
                            .addComponent(groupCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(locationCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(locationLabel))))
                    .addGroup(informationPanelLayout.createSequentialGroup()
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(serialLabel)
                            .addComponent(serialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        operatingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Operate"));

        buttonGroup1.add(realtimeModeRadioButton);
        realtimeModeRadioButton.setSelected(true);
        realtimeModeRadioButton.setText("Realtime Mode");

        buttonGroup1.add(loogerModeRadioButton);
        loogerModeRadioButton.setText("Logger Mode");
        loogerModeRadioButton.setEnabled(false);

        deviceEnableCheckBox.setSelected(true);
        deviceEnableCheckBox.setText("Device Enable");

        alarmEnableCheckBox.setSelected(true);
        alarmEnableCheckBox.setText("Alarm Enable");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 204));
        jLabel11.setText("*The IP which IMS server use to communicate with");

        jLabel12.setText("Device IP");

        jLabel7.setText("Port");

        portField.setDocument(new ETM.Util.HydeJTextFieldLimit(5,1));

        javax.swing.GroupLayout operatingPanelLayout = new javax.swing.GroupLayout(operatingPanel);
        operatingPanel.setLayout(operatingPanelLayout);
        operatingPanelLayout.setHorizontalGroup(
            operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operatingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(operatingPanelLayout.createSequentialGroup()
                        .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(realtimeModeRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loogerModeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deviceEnableCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(alarmEnableCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        operatingPanelLayout.setVerticalGroup(
            operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operatingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deviceEnableCheckBox)
                    .addComponent(jLabel12)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(operatingPanelLayout.createSequentialGroup()
                        .addComponent(realtimeModeRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loogerModeRadioButton))
                    .addGroup(operatingPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(operatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alarmEnableCheckBox)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(channelsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operatingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operatingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("General Info.", jScrollPane1);

        jToolBar5.setFloatable(false);

        profileSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        profileSaveButton.setEnabled(false);
        profileSaveButton.setFocusable(false);
        profileSaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileSaveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileSaveButton);

        profileNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/new_16.png"))); // NOI18N
        profileNewButton.setFocusable(false);
        profileNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileNewButton);

        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        profileDeleteButton.setEnabled(false);
        profileDeleteButton.setFocusable(false);
        profileDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileDeleteButton);

        profileComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a profile..." }));

        profileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profileLabel.setText("Profile");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Threshold"));

        connectionLostField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        connectionLostField.setText("0");

        batteryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        batteryField.setText("0");

        memoryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        memoryField.setText("0");

        jLabel15.setText("%");

        jLabel13.setText("Seconds");

        jLabel18.setText("%");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 153, 255));
        jLabel14.setText("*Lower/Upper limit can be set at 'Operate Info'.");

        connectionMethodCB.setText("Connection lost more than");

        batteryMethodCB.setText("Battery power lower than");

        memoryMethodCB.setText("Memory lower than");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memoryMethodCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(batteryMethodCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connectionMethodCB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(memoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(batteryField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(connectionLostField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectionLostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(connectionMethodCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batteryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(batteryMethodCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(memoryMethodCB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        methodDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Method Details"));
        methodDetailsPanel.setLayout(new java.awt.GridLayout(1, 0));

        error1CB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        acPowerCB.setText("AC Power");

        di1CB.setText("Digital Input 1");

        buzzerGroup1.add(rising1RB);
        rising1RB.setSelected(true);
        rising1RB.setText("Rising");

        buzzerGroup1.add(falling1RB);
        falling1RB.setText("Falling");

        di2CB.setText("Digital Input 2");

        buzzerGroup2.add(rising2RB);
        rising2RB.setSelected(true);
        rising2RB.setText("Rising");

        buzzerGroup2.add(falling2RB);
        falling2RB.setText("Falling");

        batteryCB.setText("Battery Low");

        memoryCB.setText("Memory Low");

        connectionCB.setText("Connection");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Sensor Error Output");

        sensor1_1.setText("Sensor 1");

        sensor2_1.setText("Sensor 2");

        error2CB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor3_1.setText("Sensor 3");

        error3CB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor4_1.setText("Sensor 4");

        error4CB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor5_1.setText("Sensor 5");

        error5CB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        maCB.setText("Maintenance in Progress");

        sensor1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_2.setText("Upper Limit Output");

        sensor1UpperOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor2UpperOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor3UpperOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor4UpperOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor5UpperOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_3.setText("Lower Limit Output");

        sensor1LowerOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor2LowerOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor3LowerOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor4LowerOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor5LowerOP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        memerrorCB.setText("Memory Error");

        javax.swing.GroupLayout buzzerDetailPanelLayout = new javax.swing.GroupLayout(buzzerDetailPanel);
        buzzerDetailPanel.setLayout(buzzerDetailPanelLayout);
        buzzerDetailPanelLayout.setHorizontalGroup(
            buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(batteryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(connectionCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(acPowerCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maCB))
                            .addComponent(memoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di1CB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling1RB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising1RB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di2CB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling2RB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising2RB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE))
                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memerrorCB)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor2_1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor3_1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4_1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5_1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor3UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor2UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                        .addComponent(sensor4LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error4CB, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                        .addComponent(sensor5LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error5CB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sensor2LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sensor3LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(error2CB, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(error3CB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sensor1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, buzzerDetailPanelLayout.createSequentialGroup()
                                        .addComponent(sensor1_1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sensor1UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                        .addComponent(sensor1LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error1CB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                        .addComponent(sensor1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanelLayout.setVerticalGroup(
            buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acPowerCB)
                            .addComponent(maCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batteryCB)
                            .addComponent(connectionCB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(memoryCB))
                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(di1CB)
                            .addComponent(di2CB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(rising1RB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling1RB))
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(rising2RB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling2RB)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memerrorCB)
                .addGap(15, 15, 15)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1_3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error1CB, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(error2CB, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor2_1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor3_1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error3CB, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor4_1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error4CB, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor5LowerOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5_1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5UpperOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error5CB, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        buzzerDetailScroll.setViewportView(buzzerDetailPanel);

        jTabbedPane2.addTab("Buzzer", buzzerDetailScroll);

        error1CB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        acPowerCB1.setText("AC Power");

        di1CB1.setText("Digital Input 1");

        digitalGroup1.add(rising1RB1);
        rising1RB1.setSelected(true);
        rising1RB1.setText("Rising");

        digitalGroup1.add(falling1RB1);
        falling1RB1.setText("Falling");

        di2CB1.setText("Digital Input 2");

        digitalGroup2.add(rising2RB1);
        rising2RB1.setSelected(true);
        rising2RB1.setText("Rising");

        digitalGroup2.add(falling2RB1);
        falling2RB1.setText("Falling");

        batteryCB1.setText("Battery Low");

        memoryCB1.setText("Memory Low");

        connectionCB1.setText("Connection");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Sensor Error Output");

        sensor1_4.setText("Sensor 1");

        sensor2_2.setText("Sensor 2");

        error2CB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor3_2.setText("Sensor 3");

        error3CB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor4_2.setText("Sensor 4");

        error4CB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor5_2.setText("Sensor 5");

        error5CB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        maCB1.setText("Maintenance in Progress");

        sensor1_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_5.setText("Upper Limit Output");

        sensor1UpperOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor2UpperOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor3UpperOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor4UpperOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor5UpperOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor1_6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_6.setText("Lower Limit Output");

        sensor1LowerOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor2LowerOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor3LowerOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor4LowerOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor5LowerOP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        normally1.setText("Normally Open");

        memerrorCB1.setText("Memory Error");

        javax.swing.GroupLayout buzzerDetailPanel1Layout = new javax.swing.GroupLayout(buzzerDetailPanel1);
        buzzerDetailPanel1.setLayout(buzzerDetailPanel1Layout);
        buzzerDetailPanel1Layout.setHorizontalGroup(
            buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memerrorCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor2_2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor3_2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4_2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5_2, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor3UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor2UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addComponent(sensor4LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error4CB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addComponent(sensor5LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error5CB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sensor2LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sensor3LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(error2CB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(error3CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sensor1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addComponent(sensor1_4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sensor1UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addComponent(sensor1LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error1CB1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                        .addComponent(sensor1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(memoryCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(normally1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(batteryCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(connectionCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(acPowerCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maCB1)))
                        .addGap(18, 18, 18)
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di1CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling1RB1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising1RB1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di2CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling2RB1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising2RB1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanel1Layout.setVerticalGroup(
            buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acPowerCB1)
                            .addComponent(maCB1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batteryCB1)
                            .addComponent(connectionCB1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(memoryCB1)
                            .addComponent(normally1)))
                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(di1CB1)
                            .addComponent(di2CB1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(rising1RB1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling1RB1))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(rising2RB1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling2RB1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memerrorCB1)
                .addGap(15, 15, 15)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_5, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1_6, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_4, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error1CB1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(error2CB1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor2_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor3_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error3CB1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor4_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error4CB1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor5LowerOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5_2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5UpperOP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error5CB1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        buzzerDetailScroll1.setViewportView(buzzerDetailPanel1);

        jTabbedPane2.addTab("Digital Output 1", buzzerDetailScroll1);

        error1CB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        acPowerCB2.setText("AC Power");

        di1CB2.setText("Digital Input 1");

        digitalGroup3.add(rising1RB2);
        rising1RB2.setSelected(true);
        rising1RB2.setText("Rising");

        digitalGroup3.add(falling1RB2);
        falling1RB2.setText("Falling");

        di2CB2.setText("Digital Input 2");

        digitalGroup4.add(rising2RB2);
        rising2RB2.setSelected(true);
        rising2RB2.setText("Rising");

        digitalGroup4.add(falling2RB2);
        falling2RB2.setText("Falling");

        batteryCB2.setText("Battery Low");

        memoryCB2.setText("Memory Low");

        connectionCB2.setText("Connection");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Sensor Error Output");

        sensor1_7.setText("Sensor 1");

        sensor2_3.setText("Sensor 2");

        error2CB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor3_3.setText("Sensor 3");

        error3CB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor4_3.setText("Sensor 4");

        error4CB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sensor5_3.setText("Sensor 5");

        error5CB2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        maCB2.setText("Maintenance in Progress");

        sensor1_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_8.setText("Upper Limit Output");

        sensor1UpperOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor2UpperOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor3UpperOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor4UpperOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor5UpperOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Upper Level", "Upper-Time Level", "Upper Extreme Level" }));

        sensor1_9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1_9.setText("Lower Limit Output");

        sensor1LowerOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor2LowerOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor3LowerOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor4LowerOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        sensor5LowerOP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Output", "Lower Level", "Lower-Time Level", "Lower Extreme Level" }));

        normally2.setText("Normally Open");

        memerrorCB2.setText("Memory Error");

        javax.swing.GroupLayout buzzerDetailPanel2Layout = new javax.swing.GroupLayout(buzzerDetailPanel2);
        buzzerDetailPanel2.setLayout(buzzerDetailPanel2Layout);
        buzzerDetailPanel2Layout.setHorizontalGroup(
            buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buzzerDetailPanel2Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(memoryCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(normally2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(batteryCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(connectionCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(acPowerCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(maCB2)))
                                .addGap(18, 18, 18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di1CB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling1RB2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising1RB2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di2CB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(falling2RB2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rising2RB2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(97, 97, 97))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memerrorCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor2_3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor3_3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4_3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5_3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sensor3UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor2UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor4UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sensor5UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(sensor4LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error4CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(sensor5LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error5CB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sensor2LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sensor3LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(error2CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(error3CB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sensor1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(sensor1_7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sensor1UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(sensor1LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(error1CB2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                        .addComponent(sensor1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanel2Layout.setVerticalGroup(
            buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(acPowerCB2)
                            .addComponent(maCB2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batteryCB2)
                            .addComponent(connectionCB2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(memoryCB2)
                            .addComponent(normally2)))
                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(di1CB2)
                            .addComponent(di2CB2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(rising1RB2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling1RB2))
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(rising2RB2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(falling2RB2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(memerrorCB2)
                .addGap(15, 15, 15)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_8, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1_9, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor1_7, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor1LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error1CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(error2CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor2_3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor2LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor3_3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor3LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error3CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor4_3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor4LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error4CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sensor5LowerOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5_3, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sensor5UpperOP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(error5CB2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        buzzerDetailScroll2.setViewportView(buzzerDetailPanel2);

        jTabbedPane2.addTab("Digital Output 2", buzzerDetailScroll2);

        methodDetailsPanel.add(jTabbedPane2);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));

        alarmMethod0.setText("Buzzer");

        alarmMethod1.setText("Digital Output 1");

        alarmMethod2.setText("Digital Output 2");

        di1Enable.setText("Digital Input 1");

        di2Enable.setText("Digital Input 2");

        jLabel16.setText("Delay");

        di1DelayField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        di1DelayField.setText("0");

        jLabel19.setText("s.");

        jLabel17.setText("Delay");

        di2DelayField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        di2DelayField.setText("0");

        jLabel20.setText("s.");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alarmMethod0, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alarmMethod1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alarmMethod2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(di1Enable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(di2Enable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(di2DelayField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel20))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(di1DelayField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alarmMethod0)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alarmMethod1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alarmMethod2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(di1Enable)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(di1DelayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(di2Enable)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(di2DelayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);

        profileSetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/download_16.png"))); // NOI18N
        profileSetButton.setEnabled(false);
        profileSetButton.setFocusable(false);
        profileSetButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileSetButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar8.add(profileSetButton);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(methodDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(profileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(profileComboBox)
                        .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(methodDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel3);

        jTabbedPane1.addTab("Alarm Info.", jScrollPane3);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void setProbeComboBox()
    {
        probeTypeCB1.removeAllItems();
        probeTypeCB2.removeAllItems();
        probeTypeCB3.removeAllItems();
        probeTypeCB4.removeAllItems();
        probeTypeCB5.removeAllItems();
        Enumeration enu = DMP.DMIF.MF.HDC.queryColumn("SELECT probe_type_name FROM probe_type;").elements();
        while (enu.hasMoreElements())
        {
            String str = (String) enu.nextElement();
            probeTypeCB1.addItem(str);
            probeTypeCB2.addItem(str);
            probeTypeCB3.addItem(str);
            probeTypeCB4.addItem(str);
            probeTypeCB5.addItem(str);
        }
    }
    
    public void setHostComboBox()
    {
        hostComboBox1.removeAllItems();
        hostComboBox2.removeAllItems();
        hostComboBox3.removeAllItems();
        hostComboBox4.removeAllItems();
        hostComboBox5.removeAllItems();
        hostComboBox1.addItem(defaultHostComboBox);
        hostComboBox2.addItem(defaultHostComboBox);
        hostComboBox3.addItem(defaultHostComboBox);
        hostComboBox4.addItem(defaultHostComboBox);
        hostComboBox5.addItem(defaultHostComboBox);
        Enumeration enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(host_name, ' (', host_id,')') FROM host;").elements();
        while (enu.hasMoreElements())
        {
            String str = (String) enu.nextElement();
            hostComboBox1.addItem(str);
            hostComboBox2.addItem(str);
            hostComboBox3.addItem(str);
            hostComboBox4.addItem(str);
            hostComboBox5.addItem(str);
        }
    }
    
    public void setComboBoxes()
    {
        groupCB.removeAllItems();
        groupCB.addItem(defaultGroupComboBox);
        Enumeration enu;
        enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group;").elements();
        while (enu.hasMoreElements())
        {
            groupCB.addItem(enu.nextElement());
        }
        
        locationCB.removeAllItems();
        locationCB.addItem(defaultLocationComboBox);
        enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(location_name,' (',location_id+0,')') FROM location;").elements();
        while (enu.hasMoreElements())
        {
            locationCB.addItem(enu.nextElement());
        }
        
        setProbeComboBox();
        setProfileComboBox();
        setHostComboBox();
        /*typeCB.removeAllItems();
        typeCB.addItem(defaultTypeComboBox);
        enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(equipment_name,' (',euipment_id+0,')') FROM equipment;").elements();
        while (enu.hasMoreElements())
        {
            typeCB.addItem(enu.nextElement());
        }*/
    }
    
    public void setProfileComboBox()
    {
        profileComboBox.removeAllItems();
        profileComboBox.addItem(defaultProfileComboBox);
        Enumeration enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(profile_name,' (',profile_id+0,')') FROM device_alarm_profile;").elements();
        while (enu.hasMoreElements())
        {
            profileComboBox.addItem(enu.nextElement());
        }
    }
    
    public void setInfo()
    {
        Vector form1 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "device_name, device_serial, device_product_serial, equipment_type, device_link, "
                + "device_group_id, location_id, device_firmware "
                + "FROM device NATURAL JOIN equipment WHERE device_id = '"+ID+"';");
        if (form1 != null && form1.size() >= 7)
        {
            idField.setText(ID);
            nameField.setText((String) form1.elementAt(0));
            serialField.setText((String) form1.elementAt(1));
            
            String group = DMP.DMIF.MF.HDC.query0("SELECT CONCAT(device_group_name, ' (', device_group_id, ')') "
                    + "FROM device_group WHERE device_group_id = '"+form1.elementAt(5)+"';");
            String location = DMP.DMIF.MF.HDC.query0("SELECT CONCAT(location_name, ' (', location_id, ')') "
                    + "FROM location WHERE location_id = '"+form1.elementAt(6)+"';");
            
            groupCB.setSelectedItem( group == null ? defaultGroupComboBox : group );
            locationCB.setSelectedItem( location == null ? defaultLocationComboBox : location );
        }
        
        Vector form2 = DMP.DMIF.MF.HDC.queryAll("SELECT "
                + "channel_enable, channel_name, probe_type_id, CONCAT(host_name, ' (',device_channel.host_id,')') "
                + "FROM device_channel NATURAL JOIN host WHERE device_id = '"+ID+"' ORDER BY channel ASC;");
        HydeDataSet HDS = new HydeDataSet(form2);
        Vector data = HDS.getRowVector();
        if (data != null && data.size() >=5 )
        {
            Vector channel1 = (Vector) data.elementAt(0);
            Vector channel2 = (Vector) data.elementAt(1);
            Vector channel3 = (Vector) data.elementAt(2);
            Vector channel4 = (Vector) data.elementAt(3);
            Vector channel5 = (Vector) data.elementAt(4);
            
            enable[0] = channel1.elementAt(0).equals("1") ? 1 : 0;
            enable[1] = channel2.elementAt(0).equals("1") ? 1 : 0;
            enable[2] = channel3.elementAt(0).equals("1") ? 1 : 0;
            enable[3] = channel4.elementAt(0).equals("1") ? 1 : 0;
            enable[4] = channel5.elementAt(0).equals("1") ? 1 : 0;
            
            probeEnable1.setEnabled(channel1.elementAt(0).equals("0") ? true : false);
            probeEnable2.setEnabled(channel2.elementAt(0).equals("0") ? true : false);
            probeEnable3.setEnabled(channel3.elementAt(0).equals("0") ? true : false);
            probeEnable4.setEnabled(channel4.elementAt(0).equals("0") ? true : false);
            probeEnable5.setEnabled(channel5.elementAt(0).equals("0") ? true : false);
            
            probeDisable1.setEnabled(channel1.elementAt(0).equals("1") ? true : false);
            probeDisable2.setEnabled(channel2.elementAt(0).equals("1") ? true : false);
            probeDisable3.setEnabled(channel3.elementAt(0).equals("1") ? true : false);
            probeDisable4.setEnabled(channel4.elementAt(0).equals("1") ? true : false);
            probeDisable5.setEnabled(channel5.elementAt(0).equals("1") ? true : false);
            
            probeName1.setText((String)channel1.elementAt(1));
            probeName2.setText((String)channel2.elementAt(1));
            probeName3.setText((String)channel3.elementAt(1));
            probeName4.setText((String)channel4.elementAt(1));
            probeName5.setText((String)channel5.elementAt(1));
            
            probeTypeCB1.setSelectedIndex(Integer.parseInt((String)channel1.elementAt(2)));
            probeTypeCB2.setSelectedIndex(Integer.parseInt((String)channel2.elementAt(2)));
            probeTypeCB3.setSelectedIndex(Integer.parseInt((String)channel3.elementAt(2)));
            probeTypeCB4.setSelectedIndex(Integer.parseInt((String)channel4.elementAt(2)));
            probeTypeCB5.setSelectedIndex(Integer.parseInt((String)channel5.elementAt(2)));
            
            hostComboBox1.setSelectedItem(channel1.elementAt(3) == null ? defaultHostComboBox : channel1.elementAt(3));
            hostComboBox2.setSelectedItem(channel2.elementAt(3) == null ? defaultHostComboBox : channel2.elementAt(3));
            hostComboBox3.setSelectedItem(channel3.elementAt(3) == null ? defaultHostComboBox : channel3.elementAt(3));
            hostComboBox4.setSelectedItem(channel4.elementAt(3) == null ? defaultHostComboBox : channel4.elementAt(3));
            hostComboBox5.setSelectedItem(channel5.elementAt(3) == null ? defaultHostComboBox : channel5.elementAt(3));
        }
        
        Vector form3 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "alarm_method, upper_method, lower_method, probe_error_method, ac_method, "
                + "battery_method, connection_method, digital1_method, digital2_method, ac_timeout, "
                + "connection_timeout, battery_limit, memory_limit, memory_method, digital_input_enable, "
                + "digital_input_delay, normally_output, memerror_method "
                + "FROM device_alarm WHERE device_id = '"+ID+"';");
        if (form3 != null && form3.size() >= 13)
        {
            setForm(form3);
        }  
        
        Vector form4 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "device_enable, alarm_enable "
                + "FROM device_status WHERE device_id = '"+ID+"';");
        if (form4 != null && form4.size() >= 2)
        {
            deviceEnableCheckBox.setSelected(form4.elementAt(0).equals("1") ? true : false);
            alarmEnableCheckBox.setSelected(form4.elementAt(1).equals("1") ? true : false);
        } 
        
        Vector ipp = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "device_ip, device_port "
                + "FROM device_network WHERE device_id = '"+ID+"' "
                + ";");
        if (ipp != null)
        {
            originalIP = (String) ipp.elementAt(0);
            ipField.setText(originalIP);
            originalPort = (String) ipp.elementAt(1);
            portField.setText(originalPort);
            /*String[] ipa = ip.split("\\.");
            if (ipa.length >= 4)
            {
                ipField1.setText(ipa[0]);
                ipField2.setText(ipa[1]);
                ipField3.setText(ipa[2]);
                ipField4.setText(ipa[3]);
            }*/
        }  
    }
    
    public void setForm(Vector form3)
    {
            String am = (String) form3.elementAt(0);
            alarmMethod0.setSelected( am.charAt(0) == '1' ? true : false );
            alarmMethod1.setSelected( am.charAt(1) == '1' ? true : false );
            alarmMethod2.setSelected( am.charAt(2) == '1' ? true : false );
           // acMethodCB.setSelected( am.charAt(20) == '1' ? true : false );
            connectionMethodCB.setSelected( am.charAt(21) == '1' ? true : false );
            batteryMethodCB.setSelected( am.charAt(22) == '1' ? true : false );
            memoryMethodCB.setSelected( am.charAt(23) == '1' ? true : false );
            
            am = (String) form3.elementAt(1); //upper
            sensor1UpperOP.setSelectedIndex(Integer.parseInt(am.charAt(0)+""));
            sensor2UpperOP.setSelectedIndex(Integer.parseInt(am.charAt(1)+""));
            sensor3UpperOP.setSelectedIndex(Integer.parseInt(am.charAt(2)+""));
            sensor4UpperOP.setSelectedIndex(Integer.parseInt(am.charAt(3)+""));
            sensor5UpperOP.setSelectedIndex(Integer.parseInt(am.charAt(4)+""));
            
            sensor1UpperOP1.setSelectedIndex(Integer.parseInt(am.charAt(5)+""));
            sensor2UpperOP1.setSelectedIndex(Integer.parseInt(am.charAt(6)+""));
            sensor3UpperOP1.setSelectedIndex(Integer.parseInt(am.charAt(7)+""));
            sensor4UpperOP1.setSelectedIndex(Integer.parseInt(am.charAt(8)+""));
            sensor5UpperOP1.setSelectedIndex(Integer.parseInt(am.charAt(9)+""));
            
            sensor1UpperOP2.setSelectedIndex(Integer.parseInt(am.charAt(10)+""));
            sensor2UpperOP2.setSelectedIndex(Integer.parseInt(am.charAt(11)+""));
            sensor3UpperOP2.setSelectedIndex(Integer.parseInt(am.charAt(12)+""));
            sensor4UpperOP2.setSelectedIndex(Integer.parseInt(am.charAt(13)+""));
            sensor5UpperOP2.setSelectedIndex(Integer.parseInt(am.charAt(14)+""));
            //upper1CB.setSelected( am.charAt(0) == '1' ? true : false );
            
            am = (String) form3.elementAt(2); 
            sensor1LowerOP.setSelectedIndex(Integer.parseInt(am.charAt(0)+""));
            sensor2LowerOP.setSelectedIndex(Integer.parseInt(am.charAt(1)+""));
            sensor3LowerOP.setSelectedIndex(Integer.parseInt(am.charAt(2)+""));
            sensor4LowerOP.setSelectedIndex(Integer.parseInt(am.charAt(3)+""));
            sensor5LowerOP.setSelectedIndex(Integer.parseInt(am.charAt(4)+""));
            
            sensor1LowerOP1.setSelectedIndex(Integer.parseInt(am.charAt(5)+""));
            sensor2LowerOP1.setSelectedIndex(Integer.parseInt(am.charAt(6)+""));
            sensor3LowerOP1.setSelectedIndex(Integer.parseInt(am.charAt(7)+""));
            sensor4LowerOP1.setSelectedIndex(Integer.parseInt(am.charAt(8)+""));
            sensor5LowerOP1.setSelectedIndex(Integer.parseInt(am.charAt(9)+""));
            
            sensor1LowerOP2.setSelectedIndex(Integer.parseInt(am.charAt(10)+""));
            sensor2LowerOP2.setSelectedIndex(Integer.parseInt(am.charAt(11)+""));
            sensor3LowerOP2.setSelectedIndex(Integer.parseInt(am.charAt(12)+""));
            sensor4LowerOP2.setSelectedIndex(Integer.parseInt(am.charAt(13)+""));
            sensor5LowerOP2.setSelectedIndex(Integer.parseInt(am.charAt(14)+""));
            
            am = (String) form3.elementAt(3); //probe error
            error1CB.setSelected( am.charAt(0) == '1' ? true : false );
            error2CB.setSelected( am.charAt(1) == '1' ? true : false );
            error3CB.setSelected( am.charAt(2) == '1' ? true : false );
            error4CB.setSelected( am.charAt(3) == '1' ? true : false );
            error5CB.setSelected( am.charAt(4) == '1' ? true : false );
            
            error1CB1.setSelected( am.charAt(5) == '1' ? true : false );
            error2CB1.setSelected( am.charAt(6) == '1' ? true : false );
            error3CB1.setSelected( am.charAt(7) == '1' ? true : false );
            error4CB1.setSelected( am.charAt(8) == '1' ? true : false );
            error5CB1.setSelected( am.charAt(9) == '1' ? true : false );
            
            error1CB2.setSelected( am.charAt(10) == '1' ? true : false );
            error2CB2.setSelected( am.charAt(11) == '1' ? true : false );
            error3CB2.setSelected( am.charAt(12) == '1' ? true : false );
            error4CB2.setSelected( am.charAt(13) == '1' ? true : false );
            error5CB2.setSelected( am.charAt(14) == '1' ? true : false );
            
            am = (String) form3.elementAt(4); // AC
            acPowerCB.setSelected( am.charAt(0) == '1' ? true : false );
            acPowerCB1.setSelected( am.charAt(1) == '1' ? true : false );
            acPowerCB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(5); // battery
            batteryCB.setSelected( am.charAt(0) == '1' ? true : false );
            batteryCB1.setSelected( am.charAt(1) == '1' ? true : false );
            batteryCB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(6); // connection
            connectionCB.setSelected( am.charAt(0) == '1' ? true : false );
            connectionCB1.setSelected( am.charAt(1) == '1' ? true : false );
            connectionCB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(13); // memory
            memoryCB.setSelected( am.charAt(0) == '1' ? true : false );
            memoryCB1.setSelected( am.charAt(1) == '1' ? true : false );
            memoryCB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(17); // memory
            memerrorCB.setSelected( am.charAt(0) == '1' ? true : false );
            memerrorCB1.setSelected( am.charAt(1) == '1' ? true : false );
            memerrorCB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(7); // digital 1
            di1CB.setSelected( am.charAt(0) > 0x30 ? true : false );
            di1CB1.setSelected( am.charAt(1) > 0x30 ? true : false );
            di1CB2.setSelected( am.charAt(2) > 0x30 ? true : false );
            
            am = (String) form3.elementAt(8); // digital 2
            di2CB.setSelected( am.charAt(0) > 0x30 ? true : false );
            di2CB1.setSelected( am.charAt(1) > 0x30 ? true : false );
            di2CB2.setSelected( am.charAt(2) > 0x30 ? true : false );
            
            am = (String) form3.elementAt(7); // digital 1
            rising1RB.setSelected( am.charAt(0) == '1' ? true : false );
            rising1RB1.setSelected( am.charAt(1) == '1' ? true : false );
            rising1RB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(8); // digital 1
            rising2RB.setSelected( am.charAt(0) == '1' ? true : false );
            rising2RB1.setSelected( am.charAt(1) == '1' ? true : false );
            rising2RB2.setSelected( am.charAt(2) == '1' ? true : false );
            
            am = (String) form3.elementAt(7); // digital 1
            falling1RB.setSelected( am.charAt(0) == '2' ? true : false );
            falling1RB1.setSelected( am.charAt(1) == '2' ? true : false );
            falling1RB2.setSelected( am.charAt(2) == '2' ? true : false );
            
            am = (String) form3.elementAt(8); // digital 2
            falling2RB.setSelected( am.charAt(0) == '2' ? true : false );
            falling2RB1.setSelected( am.charAt(1) == '2' ? true : false );
            falling2RB2.setSelected( am.charAt(2) == '2' ? true : false );
            
           // acPowerField.setText((String) form3.elementAt(9));
            connectionLostField.setText((String) form3.elementAt(10));
            batteryField.setText((String) form3.elementAt(11));
            memoryField.setText((String) form3.elementAt(12));
            
            am = (String) form3.elementAt(14); // digital input enable
            di1Enable.setSelected(am.charAt(0) == '1' ? true:false);
            di2Enable.setSelected(am.charAt(1) == '1' ? true:false);
            
            am = (String) form3.elementAt(15); // digital input delay
            di1DelayField.setText(Integer.parseInt(am.substring(0,4),16)+"");
            di2DelayField.setText(Integer.parseInt(am.substring(4,8),16)+"");
            
            am = (String) form3.elementAt(16); // normally output
            normally1.setSelected(am.charAt(0) == '1' ? true:false);
            normally2.setSelected(am.charAt(1) == '1' ? true:false);
    }
    
    public void applyConfigProfile(String profileID)
    {
        Vector form3 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "alarm_method, upper_method, lower_method, probe_error_method, ac_method, "
                + "battery_method, connection_method, digital1_method, digital2_method, ac_timeout, "
                + "connection_timeout, battery_limit, memory_limit, memory_method, digital_input_enable, "
                + "digital_input_delay, normally_output, memerror_method "
                + "FROM device_alarm_profile WHERE profile_id = '"+profileID+"';");
        if (form3 != null && form3.size() >= 13)
        {
            setForm(form3);
        }        
    }
    
    
    String alarmMethod = "";
    String upperMethod = "";
    String lowerMethod = "";
    String probeErrorMethod = "";
    String acMethod = "";
    String connectionMethod = "";
    String batteryMethod = "";
    String memoryMethod = "";
    String memerrorMethod = "";
    String digital1Method = "";
    String digital2Method = "";
    String maMethod = "";
    String diEnable = "";
    String diDelay = "";
    String normallyOutput = "";
    public void loadForm()
    {
        boolean b3 = false;
        alarmMethod = (alarmMethod0.isSelected() ? "1":"0")
                +(alarmMethod1.isSelected() ? "1":"0")
                +(alarmMethod2.isSelected() ? "1":"0")
                +"00000000000000000"  // RESERVED
                //+(acMethodCB.isSelected() ? "1":"0")
                +"1"
                +(connectionMethodCB.isSelected() ? "1":"0")
                +(batteryMethodCB.isSelected() ? "1":"0")
                +(memoryMethodCB.isSelected() ? "1":"0")
                +"000000";  // RESERVED
        upperMethod = sensor1UpperOP.getSelectedIndex()+""
                +sensor2UpperOP.getSelectedIndex()+""
                +sensor3UpperOP.getSelectedIndex()+""
                +sensor4UpperOP.getSelectedIndex()+""
                +sensor5UpperOP.getSelectedIndex()+""
                +sensor1UpperOP1.getSelectedIndex()+""
                +sensor2UpperOP1.getSelectedIndex()+""
                +sensor3UpperOP1.getSelectedIndex()+""
                +sensor4UpperOP1.getSelectedIndex()+""
                +sensor5UpperOP1.getSelectedIndex()+""
                +sensor1UpperOP2.getSelectedIndex()+""
                +sensor2UpperOP2.getSelectedIndex()+""
                +sensor3UpperOP2.getSelectedIndex()+""
                +sensor4UpperOP2.getSelectedIndex()+""
                +sensor5UpperOP2.getSelectedIndex()+""
                +"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        lowerMethod = sensor1LowerOP.getSelectedIndex()+""
                +sensor2LowerOP.getSelectedIndex()+""
                +sensor3LowerOP.getSelectedIndex()+""
                +sensor4LowerOP.getSelectedIndex()+""
                +sensor5LowerOP.getSelectedIndex()+""
                +sensor1LowerOP1.getSelectedIndex()+""
                +sensor2LowerOP1.getSelectedIndex()+""
                +sensor3LowerOP1.getSelectedIndex()+""
                +sensor4LowerOP1.getSelectedIndex()+""
                +sensor5LowerOP1.getSelectedIndex()+""
                +sensor1LowerOP2.getSelectedIndex()+""
                +sensor2LowerOP2.getSelectedIndex()+""
                +sensor3LowerOP2.getSelectedIndex()+""
                +sensor4LowerOP2.getSelectedIndex()+""
                +sensor5LowerOP2.getSelectedIndex()+""
                +"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        probeErrorMethod = (error1CB.isSelected() ? "1":"0")
                +(error2CB.isSelected() ? "1":"0")
                +(error3CB.isSelected() ? "1":"0")
                +(error4CB.isSelected() ? "1":"0")
                +(error5CB.isSelected() ? "1":"0")
                +(error1CB1.isSelected() ? "1":"0")
                +(error2CB1.isSelected() ? "1":"0")
                +(error3CB1.isSelected() ? "1":"0")
                +(error4CB1.isSelected() ? "1":"0")
                +(error5CB1.isSelected() ? "1":"0")
                +(error1CB2.isSelected() ? "1":"0")
                +(error2CB2.isSelected() ? "1":"0")
                +(error3CB2.isSelected() ? "1":"0")
                +(error4CB2.isSelected() ? "1":"0")
                +(error5CB2.isSelected() ? "1":"0")
                +"0000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        acMethod = (acPowerCB.isSelected() ? "1":"0")
                +(acPowerCB1.isSelected() ? "1":"0")
                +(acPowerCB2.isSelected() ? "1":"0")
                +"0000000000000";
        connectionMethod = (connectionCB.isSelected() ? "1":"0")
                +(connectionCB1.isSelected() ? "1":"0")
                +(connectionCB2.isSelected() ? "1":"0")
                +"0000000000000";
        batteryMethod = (batteryCB.isSelected() ? "1":"0")
                +(batteryCB1.isSelected() ? "1":"0")
                +(batteryCB2.isSelected() ? "1":"0")
                +"0000000000000";
        memoryMethod = (memoryCB.isSelected() ? "1":"0")
                +(memoryCB1.isSelected() ? "1":"0")
                +(memoryCB2.isSelected() ? "1":"0")
                +"0000000000000";
        memerrorMethod = (memerrorCB.isSelected() ? "1":"0")
                +(memerrorCB1.isSelected() ? "1":"0")
                +(memerrorCB2.isSelected() ? "1":"0")
                +"0000000000000";
        digital1Method = (di1CB.isSelected() ? (rising1RB.isSelected() ? "1":"2") :"0")
                +(di1CB1.isSelected() ? (rising1RB1.isSelected() ? "1":"2") :"0")
                +(di1CB2.isSelected() ? (rising1RB2.isSelected() ? "1":"2") :"0")
                +"0000000000000";
        digital2Method = (di2CB.isSelected() ? (rising2RB.isSelected() ? "1":"2") :"0")
                +(di2CB1.isSelected() ? (rising2RB1.isSelected() ? "1":"2") :"0")
                +(di2CB2.isSelected() ? (rising2RB2.isSelected() ? "1":"2") :"0")
                +"0000000000000";
        maMethod = (maCB.isSelected() ? "1":"0")
                +(maCB.isSelected() ? "1":"0")
                +(maCB.isSelected() ? "1":"0")
                +"0000000000000";
        diEnable = (di1Enable.isSelected() == true ? "1" : "0")
                + (di2Enable.isSelected() == true ? "1" : "0")
                +"00000000000000";
        diDelay = HydeFormat.prefixZeroAppend(Integer.toHexString(Integer.parseInt(di1DelayField.getText())),4)
                +HydeFormat.prefixZeroAppend(Integer.toHexString(Integer.parseInt(di2DelayField.getText())),4)
                +"00000000000000000000000000000000000000000000000000000000";
        normallyOutput = (normally1.isSelected() == true ? "1" : "0")
                + (normally2.isSelected() == true ? "1" : "0")
                +"00000000000000";
    }
    
    public void updateConfigProfile(String profileID)
    {
        loadForm();
        boolean b3 = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_alarm_profile SET "
                + "alarm_method = '"+alarmMethod+"', "
                + "upper_method = '"+upperMethod+"', "
                + "lower_method = '"+lowerMethod+"', "
                + "probe_error_method = '"+probeErrorMethod+"', "
                + "ac_method = '"+acMethod+"', "
                + "battery_method = '"+batteryMethod+"', "
                + "memory_method = '"+memoryMethod+"', "
                + "memerror_method = '"+memerrorMethod+"', "
                + "connection_method = '"+connectionMethod+"', "
                + "digital1_method = '"+digital1Method+"', "
                + "digital2_method = '"+digital2Method+"', "
                + "digital_input_enable = '"+diEnable+"', "
                + "digital_input_delay = '"+diDelay+"', "
                + "maintenance_method = '"+maMethod+"', "
               // + "ac_timeout = '"+acPowerField.getText()+"', "
                + "connection_timeout = '"+connectionLostField.getText()+"', "
                + "battery_limit = '"+batteryField.getText()+"', "
                + "memory_limit = '"+memoryField.getText()+"', "
                + "normally_output = '"+normallyOutput+"' "
                + "WHERE profile_id = '"+profileID+"'"
                + ";");
        
        if (b3)
        {
            JOptionPane.showMessageDialog(this, "Profile has been updated");
        }
    }
    
    public void createConfigProfile(String profileName)
    {
        loadForm();
        boolean b3 = DMP.DMIF.MF.HDC.customUpdate("INSERT INTO device_alarm_profile SET "
                + "profile_name = '"+profileName+"', "
                + "alarm_method = '"+alarmMethod+"', "
                + "upper_method = '"+upperMethod+"', "
                + "lower_method = '"+lowerMethod+"', "
                + "probe_error_method = '"+probeErrorMethod+"', "
                + "ac_method = '"+acMethod+"', "
                + "battery_method = '"+batteryMethod+"', "
                + "memory_method = '"+memoryMethod+"', "
                + "memerror_method = '"+memerrorMethod+"', "
                + "connection_method = '"+connectionMethod+"', "
                + "digital1_method = '"+digital1Method+"', "
                + "digital2_method = '"+digital2Method+"', "
                + "digital_input_enable = '"+diEnable+"', "
                + "digital_input_delay = '"+diDelay+"', "
                + "maintenance_method = '"+maMethod+"', "
               // + "ac_timeout = '"+acPowerField.getText()+"', "
                + "connection_timeout = '"+connectionLostField.getText()+"', "
                + "battery_limit = '"+batteryField.getText()+"', "
                + "memory_limit = '"+memoryField.getText()+"', "
                + "normally_output = '"+normallyOutput+"' "
                + ";");
        
        if (b3)
        {
            setProfileComboBox();
            JOptionPane.showMessageDialog(this, "Profile has been created");
        }
    }
    
    public boolean verify()
    {
        //String ipExists = DMP.DMIF.MF.HDC.query0("SELECT device_ip FROM device_network "
        //            + "WHERE device_ip = '"+ipField1.getText()+"."+ipField2.getText()+"."+ipField3.getText()+"."+ipField4.getText()+"';");
        String exists = DMP.DMIF.MF.HDC.query0("SELECT device_id FROM device_network "
                    + "WHERE device_ip = '"+ipField.getText()+"' AND device_port = '"+portField.getText()+"' AND device_id != '"+idField.getText()+"';");
        if (exists != null && exists.length() > 0)
        {
            JOptionPane.showMessageDialog(this, "IP and PORT are currently in used, please select another address or port...");
            return false;
        }
        return true;
    }
    
    public void read()
    {
        JOptionPane.showMessageDialog(this, "Modify pending, waiting for device acknowledge");

        IMSProtocolStructure IPS = new IMSProtocolStructure();
        IPS.setFrameType(IMSClientProtocol.DEVICE_CONFIG_CMD);
        IPS.setDeviceID(ID);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_PROPERTIES);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_OPERATE);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_BUZZER);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_INPUT_1);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_INPUT_2);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_OUTPUT_1);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_OUTPUT_2);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_ENVIRONMENT_ALARM);
        IPS.addConfigSector(IMSClientProtocol.CONFIG_BUZZER);
        IPS.setAccessDirection(IMSClientProtocol.ACCD_READ);
        DMP.DMIF.MF.FC.findBufferByID("0000000000000000",DMP.DMIF.MF.SD.serverIP,DMP.DMIF.MF.SD.SERVER_PORT).addFrame(IPS);
        
        DMP.DMIF.MF.HDC.customUpdate("INSERT INTO "+DMP.DMIF.MF.HDC.database+"_log.modify_log SET "
                + "device_id = '"+ID+"', "
                + "log_id = '105', "
                + "description = 'Read configuration from device', "
                + "user_username = '"+DMP.DMIF.MF.SD.loginUser+"' "
                + ";");
    }
    
    public void modify()
    {
        if (verify())
        {
            String group = (groupCB.getSelectedItem() != null && !groupCB.getSelectedItem().equals(defaultGroupComboBox)) ? 
                    "'"+HydeFormat.parseID((String)groupCB.getSelectedItem())+"'" : "NULL";
            String location = (locationCB.getSelectedItem() != null && !locationCB.getSelectedItem().equals(defaultLocationComboBox)) ? 
                    "'"+HydeFormat.parseID((String)locationCB.getSelectedItem())+"'" : "NULL";

            boolean b1 = DMP.DMIF.MF.HDC.customUpdate("UPDATE device SET "
                    + "device_name = '"+nameField.getText()+"', "
                    + "device_serial = '"+serialField.getText()+"', "
                    + "device_group_id = "+group+", "
                    + "location_id = "+location+" "
                    + "WHERE device_id = '"+idField.getText()+"'"
                    + ";");

            boolean b4 = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_status SET "
                    + "operate_mode = '"+(realtimeModeRadioButton.isSelected()? 0:1)+"', "
                    + "device_enable = '"+(deviceEnableCheckBox.isSelected()? 1:0)+"', "
                    + "alarm_enable = '"+(alarmEnableCheckBox.isSelected()? 1:0)+"' "
                    + "WHERE device_id = '"+idField.getText()+"'"
                    + ";");

            JTextField[] jtf = new JTextField[5];
            jtf[0] = probeName1;
            jtf[1] = probeName2;
            jtf[2] = probeName3;
            jtf[3] = probeName4;
            jtf[4] = probeName5;

            JComboBox[] jcb = new JComboBox[5];
            jcb[0] = probeTypeCB1;
            jcb[1] = probeTypeCB2;
            jcb[2] = probeTypeCB3;
            jcb[3] = probeTypeCB4;
            jcb[4] = probeTypeCB5;

            String[] host = new String[5];
            host[0] = hostComboBox1.getSelectedIndex() == 0 ?  "NULL" : "'"+HydeFormat.parseID((String)hostComboBox1.getSelectedItem())+"'";
            host[1] = hostComboBox2.getSelectedIndex() == 0 ?  "NULL" : "'"+HydeFormat.parseID((String)hostComboBox2.getSelectedItem())+"'";
            host[2] = hostComboBox3.getSelectedIndex() == 0 ?  "NULL" : "'"+HydeFormat.parseID((String)hostComboBox3.getSelectedItem())+"'";
            host[3] = hostComboBox4.getSelectedIndex() == 0 ?  "NULL" : "'"+HydeFormat.parseID((String)hostComboBox4.getSelectedItem())+"'";
            host[4] = hostComboBox5.getSelectedIndex() == 0 ?  "NULL" : "'"+HydeFormat.parseID((String)hostComboBox5.getSelectedItem())+"'";

            boolean b2 = false;
            for (int i=0;i<5;i++)
            {
                b2 = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_channel SET "
                        + "channel_name = '"+jtf[i].getText()+"', "
                        + "probe_type_id = '"+(jcb[i].getSelectedIndex())+"', "
                        + "host_id = "+host[i]+", "
                        + "channel_enable = '"+enable[i]+"' "
                        + "WHERE "
                        + "device_id = '"+idField.getText()+"' AND "
                        + "channel = '"+(i+1)+"'"
                        + ";");
            }

            boolean b3 = false;
            loadForm();
            b3 = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_alarm SET "
                    + "alarm_method = '"+alarmMethod+"', "
                    + "upper_method = '"+upperMethod+"', "
                    + "lower_method = '"+lowerMethod+"', "
                    + "probe_error_method = '"+probeErrorMethod+"', "
                    + "ac_method = '"+acMethod+"', "
                    + "battery_method = '"+batteryMethod+"', "
                    + "memory_method = '"+memoryMethod+"', "
                    + "memerror_method = '"+memerrorMethod+"', "
                    + "connection_method = '"+connectionMethod+"', "
                    + "digital1_method = '"+digital1Method+"', "
                    + "digital2_method = '"+digital2Method+"', "
                    + "digital_input_enable = '"+diEnable+"', "
                    + "digital_input_delay = '"+diDelay+"', "
                    + "maintenance_method = '"+maMethod+"', "
                  //  + "ac_timeout = '"+acPowerField.getText()+"', "
                    + "connection_timeout = '"+connectionLostField.getText()+"', "
                    + "battery_limit = '"+batteryField.getText()+"', "
                    + "memory_limit = '"+memoryField.getText()+"', "
                    + "normally_output = '"+normallyOutput+"' "
                    + "WHERE device_id = '"+idField.getText()+"'"
                    + ";");

            DMP.DMIF.MF.HDC.customUpdate("UPDATE device_network SET "
                    + "device_ip = '"+ipField.getText()+"', "
                    + "device_port = '"+portField.getText()+"' "
                    + "WHERE device_id = '"+idField.getText()+"'"
                    + ";");

            if (b1 && b2 && b3)
            {
                DMP.DMIF.MF.HDC.customUpdate("UPDATE device_status SET last_config_complete = 0 WHERE device_id = '"+idField.getText()+"';");
                DMP.loadDeviceData(nameField.getText()+" ("+idField.getText()+")");
                JOptionPane.showMessageDialog(this, "Modify pending, waiting for device acknowledge");

                IMSProtocolStructure IPS = new IMSProtocolStructure();
                IPS.setFrameType(IMSClientProtocol.DEVICE_CONFIG_CMD);
                IPS.setDeviceID(ID);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_PROPERTIES);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_OPERATE);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_BUZZER);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_INPUT_1);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_INPUT_2);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_OUTPUT_1);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_DIGITAL_OUTPUT_2);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_ENVIRONMENT_ALARM);
                IPS.addConfigSector(IMSClientProtocol.CONFIG_BUZZER);
                IPS.setAccessDirection(IMSClientProtocol.ACCD_WRITE);
                DMP.DMIF.MF.FC.findBufferByID("0000000000000000",DMP.DMIF.MF.SD.serverIP,DMP.DMIF.MF.SD.SERVER_PORT).addFrame(IPS);
                
                DMP.DMIF.MF.HDC.customUpdate("INSERT INTO "+DMP.DMIF.MF.HDC.database+"_log.modify_log SET "
                    + "device_id = '"+ID+"', "
                    + "log_id = '105', "
                    + "description = 'Modify device configuration', "
                    + "user_username = '"+DMP.DMIF.MF.SD.loginUser+"' "
                    + ";");
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox acPowerCB;
    private javax.swing.JCheckBox acPowerCB1;
    private javax.swing.JCheckBox acPowerCB2;
    private javax.swing.JCheckBox alarmEnableCheckBox;
    private javax.swing.JCheckBox alarmMethod0;
    private javax.swing.JCheckBox alarmMethod1;
    private javax.swing.JCheckBox alarmMethod2;
    private javax.swing.JCheckBox batteryCB;
    private javax.swing.JCheckBox batteryCB1;
    private javax.swing.JCheckBox batteryCB2;
    private javax.swing.JTextField batteryField;
    private javax.swing.JCheckBox batteryMethodCB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel buzzerDetailPanel;
    private javax.swing.JPanel buzzerDetailPanel1;
    private javax.swing.JPanel buzzerDetailPanel2;
    private javax.swing.JScrollPane buzzerDetailScroll;
    private javax.swing.JScrollPane buzzerDetailScroll1;
    private javax.swing.JScrollPane buzzerDetailScroll2;
    private javax.swing.ButtonGroup buzzerGroup1;
    private javax.swing.ButtonGroup buzzerGroup2;
    private javax.swing.JPanel channelsPanel;
    private javax.swing.JCheckBox connectionCB;
    private javax.swing.JCheckBox connectionCB1;
    private javax.swing.JCheckBox connectionCB2;
    private javax.swing.JTextField connectionLostField;
    private javax.swing.JCheckBox connectionMethodCB;
    private javax.swing.JCheckBox deviceEnableCheckBox;
    private javax.swing.JCheckBox di1CB;
    private javax.swing.JCheckBox di1CB1;
    private javax.swing.JCheckBox di1CB2;
    private javax.swing.JTextField di1DelayField;
    private javax.swing.JCheckBox di1Enable;
    private javax.swing.JCheckBox di2CB;
    private javax.swing.JCheckBox di2CB1;
    private javax.swing.JCheckBox di2CB2;
    private javax.swing.JTextField di2DelayField;
    private javax.swing.JCheckBox di2Enable;
    private javax.swing.ButtonGroup digitalGroup1;
    private javax.swing.ButtonGroup digitalGroup2;
    private javax.swing.ButtonGroup digitalGroup3;
    private javax.swing.ButtonGroup digitalGroup4;
    private javax.swing.JCheckBox error1CB;
    private javax.swing.JCheckBox error1CB1;
    private javax.swing.JCheckBox error1CB2;
    private javax.swing.JCheckBox error2CB;
    private javax.swing.JCheckBox error2CB1;
    private javax.swing.JCheckBox error2CB2;
    private javax.swing.JCheckBox error3CB;
    private javax.swing.JCheckBox error3CB1;
    private javax.swing.JCheckBox error3CB2;
    private javax.swing.JCheckBox error4CB;
    private javax.swing.JCheckBox error4CB1;
    private javax.swing.JCheckBox error4CB2;
    private javax.swing.JCheckBox error5CB;
    private javax.swing.JCheckBox error5CB1;
    private javax.swing.JCheckBox error5CB2;
    private javax.swing.JRadioButton falling1RB;
    private javax.swing.JRadioButton falling1RB1;
    private javax.swing.JRadioButton falling1RB2;
    private javax.swing.JRadioButton falling2RB;
    private javax.swing.JRadioButton falling2RB1;
    private javax.swing.JRadioButton falling2RB2;
    private javax.swing.JComboBox groupCB;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JComboBox hostComboBox1;
    private javax.swing.JComboBox hostComboBox2;
    private javax.swing.JComboBox hostComboBox3;
    private javax.swing.JComboBox hostComboBox4;
    private javax.swing.JComboBox hostComboBox5;
    private javax.swing.JTextField idField;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JButton locationButton;
    private javax.swing.JComboBox locationCB;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JRadioButton loogerModeRadioButton;
    private javax.swing.JCheckBox maCB;
    private javax.swing.JCheckBox maCB1;
    private javax.swing.JCheckBox maCB2;
    private javax.swing.JCheckBox memerrorCB;
    private javax.swing.JCheckBox memerrorCB1;
    private javax.swing.JCheckBox memerrorCB2;
    private javax.swing.JCheckBox memoryCB;
    private javax.swing.JCheckBox memoryCB1;
    private javax.swing.JCheckBox memoryCB2;
    private javax.swing.JTextField memoryField;
    private javax.swing.JCheckBox memoryMethodCB;
    private javax.swing.JPanel methodDetailsPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JCheckBox normally1;
    private javax.swing.JCheckBox normally2;
    private javax.swing.JPanel operatingPanel;
    private javax.swing.JTextField portField;
    private javax.swing.JButton probeDisable1;
    private javax.swing.JButton probeDisable2;
    private javax.swing.JButton probeDisable3;
    private javax.swing.JButton probeDisable4;
    private javax.swing.JButton probeDisable5;
    private javax.swing.JButton probeEnable1;
    private javax.swing.JButton probeEnable2;
    private javax.swing.JButton probeEnable3;
    private javax.swing.JButton probeEnable4;
    private javax.swing.JButton probeEnable5;
    private javax.swing.JTextField probeName1;
    private javax.swing.JTextField probeName2;
    private javax.swing.JTextField probeName3;
    private javax.swing.JTextField probeName4;
    private javax.swing.JTextField probeName5;
    private javax.swing.JComboBox probeTypeCB1;
    private javax.swing.JComboBox probeTypeCB2;
    private javax.swing.JComboBox probeTypeCB3;
    private javax.swing.JComboBox probeTypeCB4;
    private javax.swing.JComboBox probeTypeCB5;
    private javax.swing.JComboBox profileComboBox;
    private javax.swing.JButton profileDeleteButton;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JButton profileNewButton;
    private javax.swing.JButton profileSaveButton;
    private javax.swing.JButton profileSetButton;
    private javax.swing.JRadioButton realtimeModeRadioButton;
    private javax.swing.JRadioButton rising1RB;
    private javax.swing.JRadioButton rising1RB1;
    private javax.swing.JRadioButton rising1RB2;
    private javax.swing.JRadioButton rising2RB;
    private javax.swing.JRadioButton rising2RB1;
    private javax.swing.JRadioButton rising2RB2;
    private javax.swing.JComboBox sensor1LowerOP;
    private javax.swing.JComboBox sensor1LowerOP1;
    private javax.swing.JComboBox sensor1LowerOP2;
    private javax.swing.JComboBox sensor1UpperOP;
    private javax.swing.JComboBox sensor1UpperOP1;
    private javax.swing.JComboBox sensor1UpperOP2;
    private javax.swing.JLabel sensor1_1;
    private javax.swing.JLabel sensor1_2;
    private javax.swing.JLabel sensor1_3;
    private javax.swing.JLabel sensor1_4;
    private javax.swing.JLabel sensor1_5;
    private javax.swing.JLabel sensor1_6;
    private javax.swing.JLabel sensor1_7;
    private javax.swing.JLabel sensor1_8;
    private javax.swing.JLabel sensor1_9;
    private javax.swing.JComboBox sensor2LowerOP;
    private javax.swing.JComboBox sensor2LowerOP1;
    private javax.swing.JComboBox sensor2LowerOP2;
    private javax.swing.JComboBox sensor2UpperOP;
    private javax.swing.JComboBox sensor2UpperOP1;
    private javax.swing.JComboBox sensor2UpperOP2;
    private javax.swing.JLabel sensor2_1;
    private javax.swing.JLabel sensor2_2;
    private javax.swing.JLabel sensor2_3;
    private javax.swing.JComboBox sensor3LowerOP;
    private javax.swing.JComboBox sensor3LowerOP1;
    private javax.swing.JComboBox sensor3LowerOP2;
    private javax.swing.JComboBox sensor3UpperOP;
    private javax.swing.JComboBox sensor3UpperOP1;
    private javax.swing.JComboBox sensor3UpperOP2;
    private javax.swing.JLabel sensor3_1;
    private javax.swing.JLabel sensor3_2;
    private javax.swing.JLabel sensor3_3;
    private javax.swing.JComboBox sensor4LowerOP;
    private javax.swing.JComboBox sensor4LowerOP1;
    private javax.swing.JComboBox sensor4LowerOP2;
    private javax.swing.JComboBox sensor4UpperOP;
    private javax.swing.JComboBox sensor4UpperOP1;
    private javax.swing.JComboBox sensor4UpperOP2;
    private javax.swing.JLabel sensor4_1;
    private javax.swing.JLabel sensor4_2;
    private javax.swing.JLabel sensor4_3;
    private javax.swing.JComboBox sensor5LowerOP;
    private javax.swing.JComboBox sensor5LowerOP1;
    private javax.swing.JComboBox sensor5LowerOP2;
    private javax.swing.JComboBox sensor5UpperOP;
    private javax.swing.JComboBox sensor5UpperOP1;
    private javax.swing.JComboBox sensor5UpperOP2;
    private javax.swing.JLabel sensor5_1;
    private javax.swing.JLabel sensor5_2;
    private javax.swing.JLabel sensor5_3;
    private javax.swing.JTextField serialField;
    private javax.swing.JLabel serialLabel;
    private javax.swing.JComboBox typeCB;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == probeEnable1)
        {
            probeEnable1.setEnabled(false);
            probeDisable1.setEnabled(true);
            enable[0] = 1;
        }
        else if (src == probeEnable2)
        {
            probeEnable2.setEnabled(false);
            probeDisable2.setEnabled(true);
            enable[1] = 1;
        }
        else if (src == probeEnable3)
        {
            probeEnable3.setEnabled(false);
            probeDisable3.setEnabled(true);
            enable[2] = 1;
        }
        else if (src == probeEnable4)
        {
            probeEnable4.setEnabled(false);
            probeDisable4.setEnabled(true);
            enable[3] = 1;
        }
        else if (src == probeEnable5)
        {
            probeEnable5.setEnabled(false);
            probeDisable5.setEnabled(true);
            enable[4] = 1;
        }
        
        else if (src == probeDisable1)
        {
            probeEnable1.setEnabled(true);
            probeDisable1.setEnabled(false);
            enable[0] = 0;
        }
        else if (src == probeDisable2)
        {
            probeEnable2.setEnabled(true);
            probeDisable2.setEnabled(false);
            enable[1] = 0;
        }
        else if (src == probeDisable3)
        {
            probeEnable3.setEnabled(true);
            probeDisable3.setEnabled(false);
            enable[2] = 0;
        }
        else if (src == probeDisable4)
        {
            probeEnable4.setEnabled(true);
            probeDisable4.setEnabled(false);
            enable[3] = 0;
        }
        else if (src == probeDisable5)
        {
            probeEnable5.setEnabled(true);
            probeDisable5.setEnabled(false);
            enable[4] = 0;
        }
        else if (src == profileNewButton)
        {
            String pname = JOptionPane.showInputDialog(null, "Insert profile name...");
            if (pname != null && pname.length()>0)
            {
                createConfigProfile(pname);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Please insert profile name...", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (src == profileSaveButton)
        {
            String pid = HydeFormat.parseID((String)profileComboBox.getSelectedItem());
            updateConfigProfile(pid);
        }
        else if (src == profileDeleteButton)
        {
            int conf = JOptionPane.showConfirmDialog(null, "You want to delete this profile ?", "Message", JOptionPane.YES_NO_OPTION);
            if (conf == 0)
            {
                String pid = HydeFormat.parseID((String)profileComboBox.getSelectedItem());
                DMP.DMIF.MF.HDC.customUpdate("DELETE FROM device_alarm_profile WHERE profile_id = '"+pid+"';");
                setProfileComboBox();
                JOptionPane.showMessageDialog(null, "Profile has been deleted");
            }
        }
        else if (src == profileSetButton)
        {
            String pid = HydeFormat.parseID((String)profileComboBox.getSelectedItem());
            applyConfigProfile(pid);
        }
        else if (src == profileComboBox && profileComboBox.getSelectedItem() != null)
        {
            if (profileComboBox.getSelectedIndex() != 0)
            {
                profileSetButton.setEnabled(true);
                profileSaveButton.setEnabled(true);
                profileDeleteButton.setEnabled(true);
            }
            else
            {
                profileSetButton.setEnabled(false);
                profileSaveButton.setEnabled(false);
                profileDeleteButton.setEnabled(false);
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
        if (src == sensor1_1)
        {
            
        }
    }


}
