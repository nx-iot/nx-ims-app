package ETM.MAIN.DIALOG;

import ETM.MAIN.LoginFrame;
import ETM.Util.HydeCrypto;
import HydeModule.File.HydeFileConfig;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class DatabaseConfigDialog extends javax.swing.JDialog  implements ActionListener
{
    private LoginFrame LF;
    private String os;
    private String im;
    private String px;

    public DatabaseConfigDialog(LoginFrame LF, String[] dbParams)
    {
        super(LF,true);
        this.LF = LF;
        initComponents();
        actionComponents();

        ipField.setText(dbParams[0]);
        dbField.setText(dbParams[1]);
        userField.setText(dbParams[2]);
        passField.setText(dbParams[3]);

        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");

        proxyIpField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_ip"));
        proxyPortField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_port"));
        proxyUserField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_user"));
        proxyPassField.setText(HydeCrypto.decryptFromString( HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_pass"),SK, "Blowfish" ));
        px = (HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_enable"));
        if (px == null || px.toLowerCase().equals("yes"))
        {
            proxyCheckBox.setSelected(true);
        }
        else
        {
            proxyCheckBox.setSelected(false);
        }
        
        serverPassField.setText(HydeCrypto.decryptFromString( HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "database", "server_pass"),SK, "Blowfish" ));
        appServerField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "socket", "app_server"));
        appPortField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "socket", "app_port"));
        serverPortField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "socket", "server_port"));
        filePortField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "socket", "file_server_port"));
        serverImagePathField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "other", "server_image_path"));
        urlImagePathField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "other", "url_image_path"));
        serialField.setText(HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "other", "serial_number"));

        
        
        os = (HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "other", "server_os"));
        if (os == null || os.toLowerCase().equals("linux"))
        {
            linuxRadioButton.doClick();
            os = "linux";
        }
        else
        {
            windowsRadioButton.doClick();
            os = "windows";
        }

        im = (HydeFileConfig.readConfig(LF.SD.DIR+"conf.ini", "other", "image_method"));
        if (im == null || im.toLowerCase().equals("scp"))
        {
            scpRadioButton.doClick();
            im = "scp";
        }
        else
        {
            tcpRadioButton.doClick();
            im = "tcp";
        }
        

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actionComponents()
    {
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
        linuxRadioButton.addActionListener(this);
        windowsRadioButton.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        dbLabel = new javax.swing.JLabel();
        dbField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        userField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        userLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        dbIcon = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        appPortLabel = new javax.swing.JLabel();
        appPortField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        headerLabel1 = new javax.swing.JLabel();
        serverPortField = new javax.swing.JTextField();
        serverPortLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        appServerField = new javax.swing.JTextField();
        appServerLabel = new javax.swing.JLabel();
        serverIcon = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        dbLabel3 = new javax.swing.JLabel();
        filePortField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        linuxRadioButton = new javax.swing.JRadioButton();
        windowsRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        proxyCheckBox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        proxyIpField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        proxyPortField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        headerLabel3 = new javax.swing.JLabel();
        serverIcon2 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        proxyUserField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        proxyPassField = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scpRadioButton = new javax.swing.JRadioButton();
        tcpRadioButton = new javax.swing.JRadioButton();
        serverPassField = new javax.swing.JPasswordField();
        ipLabel2 = new javax.swing.JLabel();
        dbLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        serverImagePathField = new javax.swing.JTextField();
        urlImagePathField = new javax.swing.JTextField();
        scpPassLabel = new javax.swing.JLabel();
        serverIcon1 = new javax.swing.JLabel();
        headerLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        scpColonLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        serialField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Server Information");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        dbLabel.setText("Database");

        jLabel5.setText(":");

        jLabel8.setText(":");

        jLabel7.setText(":");

        headerLabel.setText("Database & Server Configuration");

        userLabel.setText("User");

        jLabel6.setText(":");

        passLabel.setText("Password");

        ipLabel.setText("IP");

        dbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/database_16.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dbLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ipField)
                                    .addComponent(userField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(dbField, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dbIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerLabel)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dbIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbLabel)
                    .addComponent(jLabel5)
                    .addComponent(dbField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(jLabel7)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 100));

        appPortLabel.setText("App Port");

        jLabel9.setText(":");

        jLabel10.setText(":");

        headerLabel1.setText("Client to Server Configuration");

        serverPortLabel.setText("Server Port");

        jLabel12.setText(":");

        appServerLabel.setText("#Receive Thread");

        serverIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/server_16.png"))); // NOI18N

        dbLabel3.setText("File Server Port");
        dbLabel3.setMaximumSize(new java.awt.Dimension(55, 14));
        dbLabel3.setMinimumSize(new java.awt.Dimension(55, 14));
        dbLabel3.setPreferredSize(new java.awt.Dimension(55, 14));

        jLabel15.setText(":");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serverPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appPortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(appServerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appPortField)
                            .addComponent(appServerField)
                            .addComponent(serverPortField)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dbLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filePortField))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(serverIcon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(headerLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appServerLabel)
                    .addComponent(appServerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(appPortLabel)
                    .addComponent(jLabel9)
                    .addComponent(appPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverPortLabel)
                    .addComponent(serverPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(filePortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/ok_16.png"))); // NOI18N

        buttonGroup1.add(linuxRadioButton);
        linuxRadioButton.setSelected(true);
        linuxRadioButton.setText("Linux");

        buttonGroup1.add(windowsRadioButton);
        windowsRadioButton.setText("Windows");

        jLabel1.setText("Daemon Server Version : ");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setEnabled(false);

        proxyCheckBox.setText("Use Proxy Server");
        proxyCheckBox.setEnabled(false);

        jLabel4.setText("Proxy IP");
        jLabel4.setEnabled(false);

        proxyIpField.setEnabled(false);

        jLabel11.setText("Port");
        jLabel11.setEnabled(false);

        proxyPortField.setEnabled(false);

        jLabel17.setText("Username ");
        jLabel17.setEnabled(false);

        headerLabel3.setText("Proxy Server Configuration");
        headerLabel3.setEnabled(false);

        serverIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/server_16.png"))); // NOI18N

        jLabel19.setText("Password");
        jLabel19.setEnabled(false);

        proxyUserField.setEnabled(false);

        jLabel21.setText(":");
        jLabel21.setEnabled(false);

        jLabel22.setText(":");
        jLabel22.setEnabled(false);

        jLabel23.setText(":");
        jLabel23.setEnabled(false);

        jLabel24.setText(":");
        jLabel24.setEnabled(false);

        proxyPassField.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proxyIpField))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proxyUserField))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(proxyPortField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(serverIcon2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(headerLabel3))
                            .addComponent(proxyCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(proxyPassField)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(headerLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverIcon2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proxyCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(proxyIpField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel24)
                    .addComponent(proxyPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(proxyUserField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22)
                    .addComponent(proxyPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Upload Image via");

        buttonGroup2.add(scpRadioButton);
        scpRadioButton.setSelected(true);
        scpRadioButton.setText("SCP");

        buttonGroup2.add(tcpRadioButton);
        tcpRadioButton.setText("TCP");

        ipLabel2.setText("Saved Image Path");
        ipLabel2.setMaximumSize(new java.awt.Dimension(55, 14));
        ipLabel2.setMinimumSize(new java.awt.Dimension(55, 14));
        ipLabel2.setPreferredSize(new java.awt.Dimension(55, 14));

        dbLabel2.setText("URL Image Path ");
        dbLabel2.setMaximumSize(new java.awt.Dimension(55, 14));
        dbLabel2.setMinimumSize(new java.awt.Dimension(55, 14));
        dbLabel2.setPreferredSize(new java.awt.Dimension(55, 14));

        jLabel13.setText(":");

        jLabel14.setText(":");

        scpPassLabel.setText("- Password for SCP");
        scpPassLabel.setMaximumSize(new java.awt.Dimension(55, 14));
        scpPassLabel.setMinimumSize(new java.awt.Dimension(55, 14));
        scpPassLabel.setPreferredSize(new java.awt.Dimension(55, 14));

        serverIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/server_16.png"))); // NOI18N

        headerLabel2.setText("Image Configuration");

        jLabel16.setText(":");

        scpColonLabel.setText(":");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(serverIcon1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ipLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serverImagePathField))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dbLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(urlImagePathField))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(scpPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(scpColonLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(scpRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tcpRadioButton))
                                    .addComponent(serverPassField))
                                .addGap(0, 66, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(headerLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(serverIcon1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(urlImagePathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(scpRadioButton)
                    .addComponent(tcpRadioButton)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpPassLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpColonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverImagePathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );

        jLabel3.setText("Software Serial Number :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(serialField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(linuxRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(windowsRadioButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(serialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(linuxRadioButton)
                    .addComponent(windowsRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveConfig()
    {
        SecretKey SK = HydeCrypto.loadStringToKey("B84D4DB967342A", "Blowfish");

        boolean b1 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "database", "ip", ipField.getText());
        boolean b2 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "database", "database", dbField.getText());
        boolean b3 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "database", "user", userField.getText());
        boolean b4 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "database", "pass", HydeCrypto.encryptToString(passField.getText(), SK, "Blowfish"));
        boolean b5 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "database", "server_pass", HydeCrypto.encryptToString(serverPassField.getText(), SK, "Blowfish"));

        boolean s1 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "socket", "app_server", appServerField.getText());
        boolean s2 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "socket", "app_port", appPortField.getText());
        boolean s3 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "socket", "server_port", serverPortField.getText());
        boolean s4 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "socket", "file_server_port", filePortField.getText());

        boolean p0 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_enable", proxyCheckBox.isSelected() ? "yes":"no");
        boolean p1 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_ip", proxyIpField.getText());
        boolean p2 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_port", proxyPortField.getText());
        boolean p3 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_user", proxyUserField.getText());
        boolean p4 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "proxy", "proxy_pass", HydeCrypto.encryptToString(proxyPassField.getText(), SK, "Blowfish"));

        boolean o0 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "other", "server_os", os);
        boolean o1 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "other", "image_method", im);
        boolean o2 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "other", "server_image_path", serverImagePathField.getText());
        boolean o3 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "other", "url_image_path", urlImagePathField.getText());
        boolean o4 = HydeFileConfig.writeConfig(LF.SD.DIR+"conf.ini", "other", "serial_number", serialField.getText());

        if (b1 && b2 && b3 && b4)
        {
            JOptionPane.showMessageDialog(this,"Default server configuration has been saved.","IMS", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
           JOptionPane.showMessageDialog(this,"Cannot save server configuration to config file (conf.ini).","IMS", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appPortField;
    private javax.swing.JLabel appPortLabel;
    private javax.swing.JTextField appServerField;
    private javax.swing.JLabel appServerLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField dbField;
    private javax.swing.JLabel dbIcon;
    private javax.swing.JLabel dbLabel;
    private javax.swing.JLabel dbLabel2;
    private javax.swing.JLabel dbLabel3;
    private javax.swing.JTextField filePortField;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel headerLabel1;
    private javax.swing.JLabel headerLabel2;
    private javax.swing.JLabel headerLabel3;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JLabel ipLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton linuxRadioButton;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel passLabel;
    private javax.swing.JCheckBox proxyCheckBox;
    private javax.swing.JTextField proxyIpField;
    private javax.swing.JPasswordField proxyPassField;
    private javax.swing.JTextField proxyPortField;
    private javax.swing.JTextField proxyUserField;
    private javax.swing.JLabel scpColonLabel;
    private javax.swing.JLabel scpPassLabel;
    private javax.swing.JRadioButton scpRadioButton;
    private javax.swing.JTextField serialField;
    private javax.swing.JLabel serverIcon;
    private javax.swing.JLabel serverIcon1;
    private javax.swing.JLabel serverIcon2;
    private javax.swing.JTextField serverImagePathField;
    private javax.swing.JPasswordField serverPassField;
    private javax.swing.JTextField serverPortField;
    private javax.swing.JLabel serverPortLabel;
    private javax.swing.JRadioButton tcpRadioButton;
    private javax.swing.JTextField urlImagePathField;
    private javax.swing.JTextField userField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JRadioButton windowsRadioButton;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == okButton)
        {
            LF.dbParams[0] = ipField.getText();
            LF.dbParams[1] = dbField.getText();
            LF.dbParams[2] = userField.getText();
            LF.dbParams[3] = passField.getText();

            saveConfig();
            dispose();
        }
        else if (src == cancelButton)
        {
            dispose();
        }
        else if (src == linuxRadioButton)
        {
            os = "linux";
        }
        else if (src == windowsRadioButton)
        {
            os = "windows";
        }
        else if (src == scpRadioButton)
        {
            im = "scp";
        }
        else if (src == tcpRadioButton)
        {
            im = "tcp";
        }
    }
}
