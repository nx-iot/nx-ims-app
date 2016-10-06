/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on May 28, 2012, 12:41:40 PM
 */

package ETM.MAIN;

import ETM.DEVICE.DeviceManagementIF;
import ETM.LOG.LogManagementIF;
import ETM.MAIN.DIALOG.ErrorCancelDialog;
import ETM.MAIN.DIALOG.HydeAbout;
import ETM.MAIN.POPUP.ErrorPopUp;
import ETM.MONITOR.MonitorIF;
import ETM.STRUCTURE.SessionData;
import ETM.USER.UserManagementIF;
import HydeModule.File.HydeFileConfig;
import HydeModule.File.HydeFileManager;
import ETM.Util.HydeDatabaseConnector;
import HydeModule.HydeSocket.UDP.HydeUDPSocketServer;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.LoadingDialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame implements ActionListener, MouseListener
{
    public static boolean debug = true;
    public LoginFrame LF;

    public SessionData SD;
    public HydeDatabaseConnector HDC;
    public ServerSocket server;
    public DatagramSocket UDPserver;
    
    public HydeUDPSocketServer[] HUSS;
    public Thread[] UDPThread;
    

    public ReconnectDialog RD;
    public ErrorCancelDialog ECD;

    public HydeServerChecker HSC;
    public Thread checkerThread;

    public AlarmCurrentClock ACC;
    private Thread accThread;

    public Vector<ErrorPopUp> VEPU;
    
    public MonitorIF MIF;
    public UserManagementIF UMIF;
    public DeviceManagementIF DMIF;
    public LogManagementIF LMIF;

    public boolean alarmPopup = true;

    public FrameController FC;
    public Thread FCT;
    
    public UpdateAliveClock UAC;
    public Thread UACT;
    
    public void genData()
    {
        /*Date d = new Date();
        d.setYear(2012-1900);
        d.setMonth(7);
        d.setDate(17);
        d.setHours(18);
        d.setMinutes(33);*/
        for (int i=0;i<1000;i++)
        {
            Random r = new Random();
            int hour = (i/60)%24;
            int min = i%59;
            HDC.customUpdate("INSERT INTO data SET device_id = 10110002, "
                + "CHANNEL = 1, DATA_VALUE = 2"+r.nextInt(3)+"."+r.nextInt(100)+", "
                    + "DATA_TYPE_ID = 101, DATA_TIMESTAMP = '2011-10-14 "+hour+":"+min+":00';");
            
        }
    }
    
    public MainFrame(HydeDatabaseConnector HDC, LoginFrame LF, SessionData SD)
    {
        this.HDC = HDC;
        this.SD = SD;
        this.LF = LF;
        
        initComponents();
        extendComponents();
        actionComponents();

        setPreferredSize(new Dimension(1240,600));
        setLocationRelativeTo(null);
        setVisible(true);
        //genData();
    }

    private void extendComponents()
    {
        setTitle("IMS : Intelligent Monitoring System (Ethernet Model) : Client "+LoginFrame.VERSION);


        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/logo-01-mini.png"));
        Image img = IC.getImage();
        this.setIconImage(img);

        nameLabel.setText(SD.loginUser);

        VEPU = new Vector<ErrorPopUp>();

        String sound = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "sound");
        alarmSoundTButton.setSelected(sound.toUpperCase().equals("ON"));
        
        String popup = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "popup");
        alarmPopupTButton.setSelected(popup.toUpperCase().equals("ON"));
       
        checkFloorPlan();
        setServerSocket();
        openServer();
        
        alertScroll2.setVisible(false);
        frameScroll.setVisible(false);

        HSC = new HydeServerChecker(this);
        checkerThread = new Thread(HSC);
        checkerThread.start();

        ACC = new AlarmCurrentClock(this);
        accThread = new Thread(ACC);
        accThread.start();
        
        UAC = new UpdateAliveClock(this);
        UACT = new Thread(UAC);
        UACT.start();
        
        initFrameController();
        setServerSocket();
        openServer();
    }

    private void actionComponents()
    {
        countLabel.addMouseListener(this);
        sendingIcon.addMouseListener(this);
                
        monitorButton.addActionListener(this);
        deviceButton.addActionListener(this);
        userButton.addActionListener(this);
        dbButton.addActionListener(this);

        refreshButton.addActionListener(this);
        alarmPopupTButton.addActionListener(this);
        alarmSoundTButton.addActionListener(this);

        logoutMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);
        aboutMenuItem.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        frameScroll = new javax.swing.JScrollPane();
        frameTabPanel = new javax.swing.JPanel();
        alertScroll2 = new javax.swing.JScrollPane();
        alertTabPanel2 = new javax.swing.JPanel();
        sendingField = new javax.swing.JPanel();
        sendingIcon = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        blank1 = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        monitorButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        deviceButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        dbButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jToolBar2 = new javax.swing.JToolBar();
        refreshButton = new javax.swing.JButton();
        alarmPopupTButton = new javax.swing.JToggleButton();
        alarmSoundTButton = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu1 = new javax.swing.JMenu();
        logoutMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMS ETM");
        setBackground(new java.awt.Color(153, 153, 153));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        desktopPane.setBackground(new java.awt.Color(204, 204, 204));
        desktopPane.setPreferredSize(new java.awt.Dimension(1240, 600));
        desktopPane.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                desktopPaneComponentResized(evt);
            }
        });

        frameScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        frameScroll.setPreferredSize(new java.awt.Dimension(300, 300));

        frameTabPanel.setBackground(new java.awt.Color(204, 204, 204));
        frameTabPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                frameTabPanelComponentMoved(evt);
            }
        });
        frameTabPanel.setLayout(new java.awt.GridLayout(0, 1));
        frameScroll.setViewportView(frameTabPanel);

        frameScroll.setBounds(590, 410, 170, 20);
        desktopPane.add(frameScroll, javax.swing.JLayeredPane.POPUP_LAYER);

        alertScroll2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        alertScroll2.setPreferredSize(new java.awt.Dimension(300, 300));

        alertTabPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                alertTabPanel2ComponentMoved(evt);
            }
        });
        alertTabPanel2.setLayout(new java.awt.GridLayout(0, 1));
        alertScroll2.setViewportView(alertTabPanel2);

        alertScroll2.setBounds(20, 420, 160, 20);
        desktopPane.add(alertScroll2, javax.swing.JLayeredPane.POPUP_LAYER);

        sendingField.setMinimumSize(new java.awt.Dimension(64, 16));
        sendingField.setPreferredSize(new java.awt.Dimension(64, 16));
        sendingField.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                sendingFieldComponentMoved(evt);
            }
        });
        sendingField.setLayout(new java.awt.GridLayout(1, 0));

        sendingIcon.setBackground(new java.awt.Color(204, 204, 204));
        sendingIcon.setText("     ");
        sendingIcon.setOpaque(true);
        sendingField.add(sendingIcon);

        sendingField.setBounds(700, 430, 64, 16);
        desktopPane.add(sendingField, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(desktopPane);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setMaximumSize(new java.awt.Dimension(300000, 32));
        jPanel1.setMinimumSize(new java.awt.Dimension(311, 34));
        jPanel1.setPreferredSize(new java.awt.Dimension(658, 34));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        blank1.setText("   ");
        blank1.setMaximumSize(new java.awt.Dimension(9, 32));
        blank1.setMinimumSize(new java.awt.Dimension(9, 32));
        blank1.setOpaque(true);
        blank1.setPreferredSize(new java.awt.Dimension(9, 32));
        jPanel1.add(blank1);

        countLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        countLabel.setForeground(new java.awt.Color(0, 153, 51));
        countLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Label32/bell_32.png"))); // NOI18N
        countLabel.setText("  0/0");
        countLabel.setToolTipText("Currently Alarm");
        countLabel.setMaximumSize(new java.awt.Dimension(100, 32));
        countLabel.setMinimumSize(new java.awt.Dimension(100, 32));
        countLabel.setOpaque(true);
        countLabel.setPreferredSize(new java.awt.Dimension(100, 32));
        jPanel1.add(countLabel);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setMaximumSize(new java.awt.Dimension(10, 32));
        jSeparator1.setMinimumSize(new java.awt.Dimension(10, 32));
        jSeparator1.setPreferredSize(new java.awt.Dimension(10, 32));
        jPanel1.add(jSeparator1);

        jToolBar1.setFloatable(false);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jToolBar1.setMaximumSize(new java.awt.Dimension(30000, 34));
        jToolBar1.setMinimumSize(new java.awt.Dimension(331, 35));
        jToolBar1.setPreferredSize(new java.awt.Dimension(331, 35));

        monitorButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/mbStats2.png"))); // NOI18N
        monitorButton.setToolTipText("Statistics Module");
        monitorButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 255)));
        monitorButton.setFocusable(false);
        monitorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        monitorButton.setMaximumSize(new java.awt.Dimension(80, 32));
        monitorButton.setMinimumSize(new java.awt.Dimension(80, 32));
        monitorButton.setPreferredSize(new java.awt.Dimension(80, 32));
        monitorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(monitorButton);

        jLabel5.setText(" ");
        jToolBar1.add(jLabel5);

        deviceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/mbDevice2.png"))); // NOI18N
        deviceButton.setToolTipText("Device Management");
        deviceButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        deviceButton.setFocusable(false);
        deviceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deviceButton.setMaximumSize(new java.awt.Dimension(80, 32));
        deviceButton.setMinimumSize(new java.awt.Dimension(80, 32));
        deviceButton.setPreferredSize(new java.awt.Dimension(80, 32));
        deviceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(deviceButton);

        jLabel4.setText(" ");
        jToolBar1.add(jLabel4);

        userButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/mbUser2.png"))); // NOI18N
        userButton.setToolTipText("User Management");
        userButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204)));
        userButton.setFocusable(false);
        userButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userButton.setMaximumSize(new java.awt.Dimension(80, 32));
        userButton.setMinimumSize(new java.awt.Dimension(80, 32));
        userButton.setPreferredSize(new java.awt.Dimension(80, 32));
        userButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(userButton);

        jLabel3.setText(" ");
        jToolBar1.add(jLabel3);

        dbButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/mbDatabase2.png"))); // NOI18N
        dbButton.setToolTipText("Database & Log");
        dbButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 153)));
        dbButton.setFocusable(false);
        dbButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dbButton.setMaximumSize(new java.awt.Dimension(80, 32));
        dbButton.setMinimumSize(new java.awt.Dimension(80, 32));
        dbButton.setPreferredSize(new java.awt.Dimension(80, 32));
        dbButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(dbButton);

        jPanel1.add(jToolBar1);

        jLabel6.setText("     ");
        jPanel1.add(jLabel6);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Login as : ");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 102, 0));
        jPanel1.add(nameLabel);

        jLabel2.setText("  ");
        jPanel1.add(jLabel2);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMaximumSize(new java.awt.Dimension(10, 32));
        jSeparator2.setMinimumSize(new java.awt.Dimension(10, 32));
        jSeparator2.setPreferredSize(new java.awt.Dimension(10, 32));
        jPanel1.add(jSeparator2);

        jToolBar2.setFloatable(false);

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshButton.setToolTipText("Refresh Alarm");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(refreshButton);

        alarmPopupTButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/popup_16.png"))); // NOI18N
        alarmPopupTButton.setSelected(true);
        alarmPopupTButton.setToolTipText("Popup ON/OFF");
        alarmPopupTButton.setFocusable(false);
        alarmPopupTButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmPopupTButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(alarmPopupTButton);

        alarmSoundTButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/sound_16.png"))); // NOI18N
        alarmSoundTButton.setToolTipText("Sound ON/OFF");
        alarmSoundTButton.setFocusable(false);
        alarmSoundTButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        alarmSoundTButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(alarmSoundTButton);

        jPanel1.add(jToolBar2);

        getContentPane().add(jPanel1);

        fileMenu1.setText("System");

        logoutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/logout_16.png"))); // NOI18N
        logoutMenuItem.setText("Logout");
        fileMenu1.add(logoutMenuItem);
        fileMenu1.add(jSeparator3);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/exit_16.png"))); // NOI18N
        exitMenuItem.setText("Exit");
        fileMenu1.add(exitMenuItem);

        menuBar.add(fileMenu1);

        helpMenu.setText("Help");

        aboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/info_16.png"))); // NOI18N
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alertTabPanel2ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_alertTabPanel2ComponentMoved
        alertScroll2.repaint();
}//GEN-LAST:event_alertTabPanel2ComponentMoved

    private void desktopPaneComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_desktopPaneComponentResized
        if (ACC != null)
        {
            int tabSize = ACC.alarmTabVector.size()*25;
            if (tabSize > (desktopPane.getHeight()/2 -20))
            {
                tabSize = desktopPane.getHeight()/2 -20;
            }
            alertScroll2.setBounds(0,desktopPane.getHeight()-tabSize,250,tabSize);
        }
        sendingField.setBounds(desktopPane.getWidth()-65,desktopPane.getHeight()-17,64,16);
    }//GEN-LAST:event_desktopPaneComponentResized

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logout();
    }//GEN-LAST:event_formWindowClosing

    private void sendingFieldComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_sendingFieldComponentMoved
        sendingField.repaint();
    }//GEN-LAST:event_sendingFieldComponentMoved

    private void frameTabPanelComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_frameTabPanelComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_frameTabPanelComponentMoved

    public void showMessage(String msg)
    {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void checkFloorPlan()
    {
        Vector fp = HDC.queryAll("SELECT floorplan_id, last_update FROM floorplan");
        if (fp != null)
        {
            boolean b = HydeFileManager.checkDirectory(SD.DIR+"\\floorplan");
            if (!b)
            {
                HydeFileManager.createDirectory(SD.DIR+"\\floorplan");
            }

            FloorPlanDownloader FPDL = new FloorPlanDownloader(fp, SD.DIR, SD.urlImgPath);
            Thread t = new Thread(FPDL);
            t.start();

            LoadingDialog LD = new LoadingDialog(this, "Downloading...", true);
            if (FPDL != null)
            {
                FPDL.setLoadingDialog(LD);
            }
            LD.dispose();
        }
    }
    
    private void initFrameController()
    {
        FC = new FrameController(this);
        FrameBuffer fb;
        fb = new FrameBuffer("0000000000000000",SD.serverIP,SD.SERVER_PORT, SD.serialNumber); 
        FC.addFrameBuffer(fb);
        
        FCT = new Thread(FC);
        FCT.start();
    }
    
    
    private void setServerSocket()
    {
        HUSS = new HydeUDPSocketServer[SD.MAXIMUM_APPLICATION_THREAD];
        UDPThread = new Thread[SD.MAXIMUM_APPLICATION_THREAD];
        
        try
        {
            UDPserver = new DatagramSocket(SD.APPLICATION_PORT);
        }
        catch (Exception x)
        {
            if (debug) System.out.println("TMSD/openServer : error : \n" + x);
        }
        
        for (int i=0;i<SD.MAXIMUM_APPLICATION_THREAD;i++)
        {
            HUSS[i] = new HydeUDPSocketServer(UDPserver, this);
            //HUSS[i].setTMS2(this);
            //HUSS[i].setDatabaseConnector(HDC);
            UDPThread[i] = new Thread(HUSS[i],"Server"+i);
        }
    }

    private void openServer()
    {
        for (int i=0;i<SD.MAXIMUM_APPLICATION_THREAD;i++)
        {
            UDPThread[i].start();
        }
    }
    
    private void stopServer()
    {
        for (int i=0;i<SD.MAXIMUM_APPLICATION_THREAD;i++)
        {
            HUSS[i].stopServer();
        }
        try
        {
            UDPserver.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        FC.terminate();
    }

    public void popUpError(String alarmID, boolean userClick)
    {
        try
        {
            if (alarmPopup == true || userClick == true)
            {
                Enumeration enu = VEPU.elements();
                while(enu.hasMoreElements())
                {
                    ErrorPopUp EPUtest = (ErrorPopUp) enu.nextElement();
                    if (EPUtest.getAlarmID().equals(alarmID))
                    {
                        EPUtest.requestFocus();
                        return;
                    }
                }
                String errCode = HDC.query0("SELECT error_code FROM alarm_current WHERE alarm_id = '"+alarmID+"';");
                if (errCode != null)
                {
                    char errCodeType1 = errCode.charAt(0);
                    char errCodeType2 = errCode.charAt(1);
                    char errCodeType3 = errCode.charAt(2);
                    char errCodeType4 = errCode.charAt(3);
                    boolean allow = false;
                    if (userClick == true)
                    {
                        allow = true;
                    }
                    else if (SD.popup.equals("1"))
                    {
                        allow = true;
                        switch (errCodeType1)
                        {
                            case '1': // CONNECTION
                                if (SD.popupConnection.equals("0")) allow = false;
                                break;
                            case '2': // DEVICE ERROR
                                if (SD.popupDevice.equals("0")) allow = false;
                                break;
                            case '3': // PROBE & TEMP
                                switch (errCodeType2)
                                {
                                    case '0' : // UPPER
                                        switch (errCodeType4)
                                        {
                                            case '1' : // ER
                                                if (SD.popupUpper.equals("0")) allow = false;
                                                break;
                                            case '2' : // TIME
                                                if (SD.popupUpperTime.equals("0")) allow = false;
                                                break;
                                            case '3' : // EXTREME
                                                if (SD.popupUpperExtreme.equals("0")) allow = false;
                                                break;
                                        }
                                        break;
                                    case '1' : // LOWER
                                        switch (errCodeType4)
                                        {
                                            case '1' : // ER
                                                if (SD.popupLower.equals("0")) allow = false;
                                                break;
                                            case '2' : // TIME
                                                if (SD.popupLowerTime.equals("0")) allow = false;
                                                break;
                                            case '3' : // EXTREME
                                                if (SD.popupLowerExtreme.equals("0")) allow = false;
                                                break;
                                        }
                                        break;
                                    case '2' : // PROBE ERROR
                                        if (SD.popupProbe.equals("0")) allow = false;
                                        break;
                                }
                                break;
                            case '4': // GSM
                                break;
                            case '5': // DIO / AIO
                                break;
                        }
                    }
                    
                    if (allow)
                    {
                        ErrorPopUp EPU = new ErrorPopUp(this, alarmID);
                        VEPU.add(EPU);
                    }
                }
            }
            if (MIF != null)
            {
                MIF.setBalloonParameter();
                if (MIF.FPP != null)
                {
                // MIF.FPP.refreshDetailPanel();///// refresh ALARM
                }
            }
        }
        catch (Exception e)
        {
                JOptionPane.showMessageDialog(null, "f  "+e.toString());
        }
    }

    public void stopAlarm(String alarmID)
    {
        Enumeration enu = VEPU.elements();
        while(enu.hasMoreElements())
        {
            ErrorPopUp EPU = (ErrorPopUp) enu.nextElement();
            if (EPU.getAlarmID().equals(alarmID))
            {
                EPU.close();
                enu = VEPU.elements();
            }
        }
        doRefreshButton();
        if (MIF != null)
        {
            MIF.setBalloonParameter();
            if (MIF.FPP != null)
            {
                //MIF.FPP.refreshDetailPanel();
            }
        }
    }
    
    public void refreshAllAlarm()
    {
        Vector currentAlarmID = new Vector();
        if (SD.permissionCrossDepartment.equals("1"))
        {
            currentAlarmID = HDC.queryColumn("SELECT alarm_id FROM alarm_current;");
        }
        else
        {
            currentAlarmID = HDC.queryColumn("SELECT alarm_id FROM alarm_current WHERE depart_id = '"+SD.loginDepartment+"' ;");
        }
        Enumeration enu = VEPU.elements();
        while(enu.hasMoreElements())
        {
            ErrorPopUp EPU = (ErrorPopUp) enu.nextElement();
            String alarmID = EPU.getAlarmID();
            if (currentAlarmID.indexOf(alarmID) == -1)
            {
                EPU.close();
                enu = VEPU.elements();
            }
            else
            {
                EPU.setInfo();
            }
        }
        doRefreshButton();
    }
    
    public void logout()
    {
        logoutLog();
        HSC.stopClock();
        ACC.stopClock();
        UAC.stopClock();
        if (MIF != null) MIF.close();
        stopServer();
        HDC.closeDB();
        LF.launching = false;
        LF.setVisible(true);
        dispose();
    }

    private void logoutLog()
    {
        Date d = new Date();
        String now = d.getYear()+1900 + "-" + (d.getMonth()+1) + "-" + d.getDate() + " "
                    + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
        //ACC.stopClock();

        HDC.changeDatabase(HDC.database+"_log");
        HDC.customUpdate("INSERT INTO user_log (user_username, log_id, user_log_timestamp) VALUES ("
                + "'"+SD.loginUser+"', "
                + ""+102+", "
                + "'"+now+"');");
        HDC.changeDatabase(HDC.database);
        HDC.customUpdate("UPDATE pc SET user_username = NULL WHERE pc_name = '"+SD.computerName+"';");
    }


    public void logoutCommunication()
    {
        HSC.stopClock();
        ACC.stopClock();
        if (MIF != null) MIF.close();
        stopServer();
        HDC.closeDB();
        LF.setVisible(true);
        dispose();
    }
    
    boolean sending = false;
    public void setSending(boolean b)
    {
        if (sending != b)
        {
            sending = b;
            if (sending)
            {
                sendingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Animate/sending.gif")));
            }
            else
            {
                sendingIcon.setIcon(null);
            }
        }
    }

    public void setReconnectDialog(ReconnectDialog RD)
    {
        this.RD = RD;
        RD.setLocationRelativeTo(null);
        RD.setVisible(true);
    }
    
    public void doRefreshButton()
    {
        alertScroll2.getHorizontalScrollBar().setValue(0);
        alertTabPanel2.removeAll();
        alertTabPanel2.repaint();
        ACC.resetAlarmTab();
        alertTabPanel2.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JToggleButton alarmPopupTButton;
    private javax.swing.JToggleButton alarmSoundTButton;
    public javax.swing.JScrollPane alertScroll2;
    public javax.swing.JPanel alertTabPanel2;
    public javax.swing.JLabel blank1;
    public javax.swing.JLabel countLabel;
    private javax.swing.JButton dbButton;
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton deviceButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu1;
    public javax.swing.JScrollPane frameScroll;
    public javax.swing.JPanel frameTabPanel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem logoutMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton monitorButton;
    private javax.swing.JLabel nameLabel;
    public javax.swing.JButton refreshButton;
    public javax.swing.JPanel sendingField;
    private javax.swing.JLabel sendingIcon;
    private javax.swing.JButton userButton;
    // End of variables declaration//GEN-END:variables

    Random rnd = new Random();
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == monitorButton)
        {
            if (MIF == null || !MIF.isVisible())
            {
                MIF = new MonitorIF(this);
                MIF.setBounds(rnd.nextInt(100), rnd.nextInt(80), 850, 510);
                desktopPane.add(MIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                try { MIF.setSelected(true); }
                catch (Exception ee) { }
            }
            else
            {
                try { MIF.setSelected(true); }
                catch (Exception ee) { }
            }
        }
        else if (src == deviceButton)
        {
            if (DMIF == null || !DMIF.isVisible())
            {
                DMIF = new DeviceManagementIF(this);
                DMIF.setBounds(rnd.nextInt(100), rnd.nextInt(80), 850, 510);
                desktopPane.add(DMIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                try { DMIF.setSelected(true); }
                catch (Exception ee) { }
            }
            else
            {
                try { DMIF.setSelected(true); }
                catch (Exception ee) { }
            }
        }
        else if (src == userButton)
        {
            if (UMIF == null || !UMIF.isVisible())
            {
                UMIF = new UserManagementIF(this);
                UMIF.setBounds(rnd.nextInt(100), rnd.nextInt(80), 850, 510);
                desktopPane.add(UMIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                try { UMIF.setSelected(true); }
                catch (Exception ee) { }
            }
            else
            {
                try { UMIF.setSelected(true); }
                catch (Exception ee) { }
            }
        }
        else if (src == dbButton)
        {
            if (LMIF == null || !LMIF.isVisible())
            {
                LMIF = new LogManagementIF(this);
                LMIF.setBounds(rnd.nextInt(100), rnd.nextInt(80), 850, 510);
                desktopPane.add(LMIF, javax.swing.JLayeredPane.DEFAULT_LAYER);
                try { LMIF.setSelected(true); }
                catch (Exception ee) { }
            }
            else
            {
                try { LMIF.setSelected(true); }
                catch (Exception ee) { }
            }
        }
        else if (src == alarmSoundTButton)
        {
            String sound;
            sound = (alarmSoundTButton.isSelected() ? "on" : "off");
            HydeFileConfig.writeConfig(SD.DIR+"conf.ini", "other", "sound",sound);
        }
        else if (src == alarmPopupTButton)
        {
            String popup;
            popup = (alarmPopupTButton.isSelected() ? "on" : "off");
            HydeFileConfig.writeConfig(SD.DIR+"conf.ini", "other", "popup",popup);
            alarmPopup = (alarmPopupTButton.isSelected() ? true : false);
        }
        else if (src == refreshButton)
        {
            refreshAllAlarm();
            //doRefreshButton();
            //countLabel.setText("Checking...");
        }
        else if (src == aboutMenuItem)
        {
            HydeAbout HA = new HydeAbout(this);
        }
        else if(src == logoutMenuItem)
        {
            logout();
        }
        else if (src == exitMenuItem)
        {
            System.exit(0);
        }
    }

    boolean alarmScrollEnable = false;
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        if (src == countLabel)
        {
            if (alertScroll2.isVisible())
            {
                alertScroll2.setVisible(false);
                //alertCountPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
            }
            else
            {
                alertScroll2.setVisible(true);
                int tabSize = ACC.alarmTabVector.size()*25;
                if (tabSize > (desktopPane.getHeight()/2 -20))
                {
                    tabSize = desktopPane.getHeight()/2 -20;
                }
                else if (tabSize < 20)
                {
                    tabSize = 20;
                }
                alertScroll2.setBounds(0,desktopPane.getHeight()-tabSize,ACC.width,tabSize);
                //alertCountPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));
            }
        }
        else if (src == sendingIcon)
        {
            if (frameScroll.isVisible())
            {
                frameTabPanel.removeAll();
                frameScroll.setVisible(false);
            }
            else
            {
                int size = 0;
                String label = "";
                Vector allFrame = FC.getFrameInfo();
                //System.out.println(allFrame);
                if (allFrame.size() > 0)
                {
                    Enumeration aenu = allFrame.elements();
                    while (aenu.hasMoreElements())
                    {
                        size++;
                        Vector frame = (Vector)aenu.nextElement();
                        String dest = (String)frame.elementAt(0);
                        String fid = ""+frame.elementAt(1);
                        String ftype = ""+frame.elementAt(2);
                        int destInt = Integer.parseInt(dest,16);
                        if (destInt == 0 ) dest = "SERVER";
                        ftype = IMSClientProtocol.getFrameTypeName((byte)(Integer.parseInt(ftype)&0xFF));
                        label = ">"+dest+":"+ftype+" ("+fid+")";
                        frameTabPanel.add(new JLabel(label));
                    }
                }
                int tabHeight = (size*16)+17;
                frameScroll.setVisible(true);
                frameScroll.setBounds(desktopPane.getWidth()-(label.length()*6),desktopPane.getHeight()-tabHeight,(label.length()*6),tabHeight-17);
                //alertCountPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 80, 80)));
            }
        }
    }
}
