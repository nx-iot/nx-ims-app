package ETM.MAIN;

import ETM.MAIN.DIALOG.DatabaseConfigDialog;
import ETM.MAIN.DIALOG.NewPasswordDialog;
import ETM.STRUCTURE.SessionData;
import HydeModule.File.HydeFileConfig;
import ETM.Util.HydeCrypto;
import ETM.Util.HydeDatabaseConnector;
import ETM.Util.HydeOS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import javax.crypto.SecretKey;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class LoginFrame extends javax.swing.JFrame implements ActionListener, KeyListener
{
    public static String VERSION = "0.86a";

    private DatabaseConfigDialog DF;
    private MainFrame MF;
    public String[] dbParams;

    // PASS TO MainFrame
    public HydeDatabaseConnector HDC;
    public SessionData SD;

    public String loginOS;

    public LoginFrame()
    {
        /*HydeEmail HE = new HydeEmail("gmail", "peranitti", "xjqphqj9");
        HE.sendMailSsl("tung@gmail.com", "peranitti@gmail.com", "Test MF", "TEST TEST TEST");*/
		/*Date d = new Date();
		long ddd = 1327380272;
		d.setTime(ddd*1000);
		System.out.println(d);*/
        selectLookAndFeel(4);
        initComponents();
        extendComponents();
        actionComponents();
        //test();
    }

    public void test()
    {
        try
        {
            //HydeCrypto.createKey(56,"C:/key2.key","Blowfish");
            SecretKey SK = HydeCrypto.loadKey("C:/key1.key", "Blowfish");
            System.out.println(HydeCrypto.loadKeyToString("C:/key1.key"));
            //System.out.println(HydeCrypto.encryptToString("mugvH,gvl", SK, "Blowfish"));
            System.out.println(HydeCrypto.encryptToString("password", SK, "Blowfish"));

            //SecretKey SK2 = HydeCrypto.loadKey("C:/key1.key", "Blowfish");
            //System.out.println(HydeCrypto.decryptFromString(a, SK2, "Blowfish"));

            // password = 4DF8C7E674A4426DFCF8E91304E3CA98
            // MF = 557C5A1C8D7C9FCB
        }
        catch(Exception e)
        {
            
        }
    }

    private void extendComponents()
    {
        
        setTitle("IMS-ETM : Intelligent Monitoring System .ETM : "+VERSION);

        ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/logo-01-mini.png"));
        Image img = IC.getImage();
        this.setIconImage(img);

        SD = new SessionData();
        setMainPath();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;
        
        this.setLocation(x, y);
        
        dbParams = new String[4];
        Arrays.fill(dbParams, "");

        //ImageIcon IC = new javax.swing.ImageIcon(getClass().getResource("/Picz/BD_logo_full.png"));
        //Image BDlogo = IC.getImage();
        //setIconImage(new ImageIcon(BDlogo).getImage());

        getComputerProperties();

        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
        if (new File(SD.DIR+"conf.ini").exists())
        {
            String px = 
                    "proxy_enable = no\r\n"+
                    "proxy_ip = 192.168.1.100\r\n"+
                    "proxy_port = 8080\r\n"+
                    "proxy_user = \r\n"+
                    "proxy_pass = \r\n";
            HydeFileConfig.checkConfigByContext("proxy", px, SD.DIR+"conf.ini");
            dbParams = new String[4];
            dbParams[0] = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "database", "ip");
            dbParams[1] = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "database", "database");
            dbParams[2] = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "database", "user");
            dbParams[3] = HydeCrypto.decryptFromString(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "database", "pass"), SK, "Blowfish");
            userField.setText(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "last_user"));
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Config file (conf.ini) is missing !!\nThe system will automatically generate a new default config file.","MF", JOptionPane.ERROR_MESSAGE);
            createDefaultConfig();
        }
    }



    private void actionComponents()
    {
        dbButton.addActionListener(this);
        okButton.addActionListener(this);
        forgetButton.addActionListener(this);
        

        userField.addKeyListener(this);
        passField.addKeyListener(this);
    }

    private void selectLookAndFeel(int choice)
    {
        try
        {
            String lookAndFeel = "";
            switch (choice)
            {
                case 0 : lookAndFeel = UIManager.getSystemLookAndFeelClassName();
                         break;
                case 1 : lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
                         break;
                case 2 : lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                         break;
                case 3 : lookAndFeel = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
                         break;
                case 4 : lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                         break;
            }
            UIManager.setLookAndFeel(lookAndFeel);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    private void createDefaultConfig()
    {
        StringBuilder SB = new StringBuilder();
        SB.append("[database]\r\n");
        SB.append("ip = 127.0.0.1\r\n");
        SB.append("database = ims_etm\r\n");
        SB.append("user = root\r\n"); //ims_etm
        SB.append("pass = \r\n");
        SB.append("server_pass = \r\n");
        SB.append("\r\n");
        SB.append("[proxy]\r\n");
        SB.append("proxy_enable = no\r\n");
        SB.append("proxy_ip = 192.168.1.100\r\n");
        SB.append("proxy_port = 8080\r\n");
        SB.append("proxy_user = \r\n");
        SB.append("proxy_pass = \r\n");
        SB.append("\r\n");
        SB.append("[socket]\r\n");
        SB.append("app_server = 1\r\n");
        SB.append("app_client = 1\r\n");
        SB.append("app_port = 10000\r\n");
        SB.append("server_port = 10010\r\n");
        SB.append("file_server_port = 6100\r\n");
        SB.append("\r\n");
        SB.append("[map]\r\n");
        SB.append("scale = 4\r\n");
        SB.append("\r\n");
        SB.append("[other]\r\n");
        if (HydeOS.isWindows()) SB.append("server_os = windows\r\n");
        else SB.append("server_os = linux\r\n");
        SB.append("image_method = tcp\r\n");
        if (HydeOS.isWindows()) SB.append("server_image_path = C:/xampp/htdocs/ims_etm\r\n");
        else SB.append("server_image_path = /var/www/html/ims_etm\r\n");
        SB.append("local_image_path = C:/\r\n");
        SB.append("url_image_path = http://127.0.0.1/ims_etm\r\n");
        SB.append("last_user = \r\n");
        SB.append("sound = off\r\n");
        SB.append("popup = on\r\n");
        SB.append("last_update_floorplan = 1901-01-01 01:01:01\r\n");
        SB.append("serial_number = \r\n");
        
        if (HydeFileConfig.createConfig(SD.DIR+"conf.ini", SB.toString()))
        {
            JOptionPane.showMessageDialog(this, "Default config file has been created.", "MF", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Cannot create config file...\nPlease contact the system administrator.", "MF", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        dbButton = new javax.swing.JButton();
        forgetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMS : Intelligent Monitoring System : Client - ");
        setResizable(false);

        logoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 255)));
        logoPanel.setPreferredSize(new java.awt.Dimension(470, 220));
        logoPanel.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Other/ims_banner.png"))); // NOI18N
        logoPanel.add(jLabel1);

        userLabel.setText("Username : ");

        passLabel.setText("Password :");

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/ok_16.png"))); // NOI18N
        okButton.setToolTipText("Login");

        dbButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/wrench_16.png"))); // NOI18N
        dbButton.setToolTipText("Connection Config");

        forgetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/question_16.png"))); // NOI18N
        forgetButton.setToolTipText("Forget password ?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(userLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(passLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forgetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dbButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(forgetButton, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                        .addComponent(userField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(passField, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dbButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean loadDB()
    {
        try
        {
            HDC = new HydeDatabaseConnector();
            if (HDC.connect(dbParams,true))
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Cannot connect to database.",
                    "Database connector",
                    JOptionPane.ERROR_MESSAGE);
                dbButton.setBackground(Color.red);
                //userField.setEnabled(false);
                //passField.setEnabled(false);
                return false;
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(
                    null,
                    "Cannot find configuration file...",
                    "MF",
                    JOptionPane.ERROR_MESSAGE);
                dbButton.setBackground(Color.red);
                //userField.setEnabled(false);
                //passField.setEnabled(false);
                return false;
        }

    }

    private void setMainPath()
    {
        SD.DIR = new HydeFileConfig().getMainPath();
    }

    public void getComputerProperties()
    {
        try
        {
            SD.computerName = InetAddress.getLocalHost().getHostName();
            SD.computerIP = InetAddress.getLocalHost().getHostAddress();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private boolean checkUserLogin(String username)
    {
        String str = HDC.query0("SELECT CONCAT(pc_name, ' (', pc_ip, ')') FROM pc WHERE user_username = '"+username+"';");
        if (str != null)
        {
            int choice = JOptionPane.showConfirmDialog(null, "Username is currently logged in... ("+str+")\nDo you want to login anyway ?", "IMS", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (choice == 0 ) return true;
            else return false;
        }
        else
        {
            return true;
        }
    }
    
    /*private boolean checkSerialLogin(String serial)
    {
        String str = HDC.query0("SELECT CONCAT(pc_name, ' (', pc_ip, ')') FROM pc WHERE pc_id = '"+serial+"';");
        if (str != null)
        {
            int choice = JOptionPane.showConfirmDialog(null, "Username is currently logged in... ("+str+")\nDo you want to login anyway ?", "IMS", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (choice == 0 ) return true;
            else return false;
        }
        else
        {
            return true;
        }
    }*/

    public boolean recordComputerProperties()
    {
        String id = HDC.query0("SELECT pc_id FROM pc WHERE pc_id = '"+SD.serialNumber+"';");
        if (id != null)
        {
            HDC.customUpdate("UPDATE pc SET "
                    + "user_username = '"+SD.loginUser+"', "
                    + "pc_name = '"+SD.computerName+"', "
                    + "pc_ip = '"+SD.computerIP+"', "
                    + "pc_port = '"+SD.APPLICATION_PORT+"' "
                    + "WHERE pc_id = '"+SD.serialNumber+"';");
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Invalid Serial Number");
            /*HDC.customUpdate("INSERT INTO pc (pc_name, pc_ip, user_username) VALUES ("
                    + "'"+name+"', "
                    + "'"+ip+"', "
                    + "'"+username+"' "
                    + ");");*/
            return false;
        }
    }

    public boolean launching = false;
    public void launchMF()
    {
        try
        {
            System.out.println(launching);
            launching = true;
            HydeFileConfig.writeConfig(SD.DIR+"conf.ini", "other", "last_user", userField.getText());
            SD.loginUser = userField.getText();
            String pw = passField.getText();
            String pwdb = HDC.query0("SELECT user_password FROM user WHERE user_username = '"+SD.loginUser+"';");
            //SecretKey SK = HC.loadKey("C:/key1.key", "Blowfish");
            //String keyString = HDC.query0("SELECT secret_key FROM secret WHERE secret_id = 1;");
            //SecretKey SK = HydeCrypto.loadStringToKey(keyString, "Blowfish");
            SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
            String pwdc = HydeCrypto.decryptFromString(pwdb, SK, "Blowfish");

            Date d = new Date();
            String now = d.getYear()+1900 + "-" + (d.getMonth()+1) + "-" + d.getDate() + " "
                    + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

            if (pw.length() > 0 && pwdc.length() > 0 && pw.equals(pwdc))
            {
                HDC.changeDatabase(HDC.database+"_log");
                HDC.customUpdate("INSERT INTO user_log (user_username, log_id, user_log_timestamp) VALUES ("
                        + "'"+SD.loginUser+"', "
                        + ""+101+", "
                        + "'"+now+"');");
                HDC.changeDatabase(HDC.database);

                SD.upload = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "image_method");
                SD.serverType = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "server_os");
                SD.loginDepartment = HDC.query0("SELECT depart_id FROM user WHERE user_username = '"+SD.loginUser+"';");
                SD.loginUserPassword = pw;

                SD.serverPassword = HydeCrypto.decryptFromString(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "database", "server_pass"), SK, "Blowfish");
                SD.serverImgPath = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "server_image_path");
                SD.urlImgPath = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "url_image_path");
                
                SD.serialNumber = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "other", "serial_number");
                
                SD.MAXIMUM_APPLICATION_THREAD = Integer.parseInt(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "socket", "app_server"));
                SD.MAXIMUM_CLIENT_THREAD = Integer.parseInt(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "socket", "app_client"));
                SD.APPLICATION_PORT = Integer.parseInt(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "socket", "app_port"));
                SD.SERVER_PORT = Integer.parseInt(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "socket", "server_port"));
                SD.FILE_SERVER_PORT = Integer.parseInt(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "socket", "file_server_port"));

                
                SD.defaultDatabase = HDC.database;
                SD.serverIP = dbParams[0];
                
                SD.userPermission = HDC.query0("SELECT permission_id FROM user WHERE user_username = '"+SD.loginUser+"';");
                Vector v = HDC.queryRow("SELECT "
                        + "manage_user, manage_device, manage_host, view_log, view_floorplan, "
                        + "data_presentation, cross_department, manage_message, manage_department "
                        + "FROM permission WHERE permission_id = '"+SD.userPermission+"';");
                if (v != null && v.size() >= 8)
                {
                    SD.permissionManageUser = (String)v.elementAt(0);
                    SD.permissionManageDevice = (String)v.elementAt(1);
                    SD.permissionManageHost = (String)v.elementAt(2);
                    SD.permissionViewLog = (String)v.elementAt(3);
                    SD.permissionViewFloorPlan = (String)v.elementAt(4);
                    SD.permissionDataPresentation = (String)v.elementAt(5);
                    SD.permissionCrossDepartment = (String)v.elementAt(6);
                    SD.permissionManageMessage = (String)v.elementAt(7);
                    SD.permissionManageDepartment = (String)v.elementAt(8);
                }
                
                Vector alarmInfo = HDC.queryRow("SELECT "
                    + "M_POPUP, M_SMS, M_EMAIL, A_UPPER, A_UPPERTIME, "
                    + "A_UPPEREXTREME, A_LOWER, A_LOWERTIME, A_LOWEREXTREME, A_PROBE, "
                    + "A_DEVICE, A_CONNECTION "
                    + "FROM user_alarm WHERE user_username = '"+SD.loginUser+"';");
                if (alarmInfo != null && alarmInfo.size() >= 12)
                {
                    SD.popup = (String)alarmInfo.elementAt(0);
                    SD.sms = (String)alarmInfo.elementAt(1);
                    SD.email = (String)alarmInfo.elementAt(2);
                    SD.popupUpper = (String)alarmInfo.elementAt(3);
                    SD.popupUpperTime = (String)alarmInfo.elementAt(4);
                    SD.popupUpperExtreme = (String)alarmInfo.elementAt(5);
                    SD.popupLower = (String)alarmInfo.elementAt(6);
                    SD.popupLowerTime = (String)alarmInfo.elementAt(7);
                    SD.popupLowerExtreme = (String)alarmInfo.elementAt(8);
                    SD.popupProbe = (String)alarmInfo.elementAt(9);
                    SD.popupDevice = (String)alarmInfo.elementAt(10);
                    SD.popupConnection = (String)alarmInfo.elementAt(11);
                }

                if (checkUserLogin(SD.loginUser))
                {

                    if (HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_enable").toLowerCase().equals("yes"))
                    {
                        SD.proxyEnable = "yes";
                        SD.proxyIP = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_ip");
                        SD.proxyPort = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_port");
                        SD.proxyUser = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_user");
                        SD.proxyPass = HydeCrypto.decryptFromString(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_pass"), SK, "Blowfish");

                        setProxy();
                    }
                    getComputerProperties();
                    if (SD.serverIP.toLowerCase().equals("localhost") || SD.serverIP.equals("127.0.0.1"))
                    {
                        SD.serverIP = SD.computerIP;
                    }
                    if (recordComputerProperties())
                    {
                        MF = new MainFrame(HDC, this, SD);
                        setVisible(false);
                        return;
                    }
                }
            }
            else if (pwdc.length() > 0)
            {
                HDC.changeDatabase(HDC.database+"_log");
                HDC.customUpdate("INSERT INTO user_log (user_username, log_id, user_log_timestamp) VALUES ("
                        + "'"+SD.loginUser+"', "
                        + ""+103+", "
                        + "'"+now+"');");
                HDC.changeDatabase(HDC.database);
                JOptionPane.showMessageDialog(
                    null,
                    "Wrong password !!",
                    "MF",
                    JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(
                    null,
                    "Username not found !!",
                    "MF",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        launching = false;
    }

    public void getQuestionAnswer()
    {
        String un = HDC.query0("SELECT user_username FROM user WHERE user_username = '"+userField.getText()+"';");
        if (un == null)
        {
            JOptionPane.showMessageDialog(this, "User not found...", "Password Reset", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String question = HDC.query0("SELECT user_question_text FROM user NATURAL JOIN user_question WHERE user_username = '"+userField.getText()+"';");
            String answer = HDC.query0("SELECT user_question_answer FROM user WHERE user_username = '"+un+"';");
            String ans = JOptionPane.showInputDialog(this, question, "Password Reset", JOptionPane.QUESTION_MESSAGE);
            if (ans != null && ans.toLowerCase().equals(answer.toLowerCase()))
            {
                NewPasswordDialog NPD = new NewPasswordDialog(this, un);
            }
        }
        
    }

    public void setNewPassword(String username, String newPass)
    {
        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
        String newPass2 = HydeCrypto.encryptToString(newPass, SK, "Blowfish");
        HDC.customUpdate("UPDATE user SET user_password = '"+newPass2+"' WHERE user_username = '"+username+"';");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dbButton;
    private javax.swing.JButton forgetButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == dbButton)
        {
            DF = new DatabaseConfigDialog(this,dbParams);
        }
        else if (src == okButton)
        {
            if (loadDB())
            {
                if (!launching) launchMF();
            }
        }
        else if (src == forgetButton)
        {
            if (loadDB())
            {
                getQuestionAnswer();
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == 10)
        {
            if (loadDB())
            {
                if (!launching) launchMF();
            }
        }
    }
    
    private boolean setProxy()
    {
        SD = new SessionData();
        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");
        if (HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_enable").toLowerCase().equals("yes"))
        {
            SD.proxyEnable = "yes";
            SD.proxyIP = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_ip");
            SD.proxyPort = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_port");
            SD.proxyUser = HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_user");
            SD.proxyPass = HydeCrypto.decryptFromString(HydeFileConfig.readConfig(SD.DIR+"conf.ini", "proxy", "proxy_pass"), SK, "Blowfish");
            
            Authenticator authenticator = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return (new PasswordAuthentication(SD.proxyUser,
                            SD.proxyPass.toCharArray()));
                }
            };
            Authenticator.setDefault(authenticator);
            
            System.setProperty("http.proxyHost", SD.proxyIP);
            System.setProperty("http.proxyPort", SD.proxyPort);
            System.setProperty("http.proxyUser", SD.proxyUser);
            System.setProperty("http.proxyPassword", SD.proxyPass);
            System.setProperty("https.proxyHost", SD.proxyIP);
            System.setProperty("https.proxyPort", SD.proxyPort);
            System.setProperty("https.proxyUser", SD.proxyUser);
            System.setProperty("https.proxyPassword", SD.proxyPass);
            /*String encoded = Base64.encode((SD.proxyUser + ":" + SD.proxyPass).getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
            Authenticator.setDefault(new ProxyAuth(SD.proxyUser, SD.proxyPass));*/
            
            return true;
        }
        else
        {
            return false;
        }
    }

}
