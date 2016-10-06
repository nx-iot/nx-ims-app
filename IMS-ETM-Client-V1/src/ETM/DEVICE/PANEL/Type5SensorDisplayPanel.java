package ETM.DEVICE.PANEL;

import ETM.MAIN.FullFrame;
import HydeModule.Image.HydeImage;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ImageIcon;

public class Type5SensorDisplayPanel extends javax.swing.JPanel implements MouseListener
{
    private DeviceListPanel DLP;
    private String ID;
    private String CH;
    private String NAME;
    
    private ImageIcon ON = new ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    private ImageIcon OFF = new ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    
    public Type5SensorDisplayPanel(DeviceListPanel DLP, String name, String id, String ch) 
    {
        this.DLP = DLP;
        ID = id;
        CH = ch;
        NAME = name;
        initComponents();
        extendComponents();
    }

    private void extendComponents()
    {
        setInfo();
        picLabel.addMouseListener(this);
    }
    
    public void setInfo()
    {
        Vector form1 = DLP.DMIF.MF.HDC.queryRow("SELECT "
                + "channel_name, probe_type_name, sampling, working_type, day_on_work, "
                + "from_time, to_time, reoccur, lower_limit, lower_extreme_limit, "
                + "lower_time_limit, upper_limit, upper_extreme_limit, upper_time_limit, channel_enable, "
                + "level_enable, host_id "
                + "FROM device_channel NATURAL JOIN probe_type WHERE device_id = '"+ID+"' AND channel = '"+CH+"';");
        if (form1 != null && form1.size() >= 15)
        {
            parentField.setText(NAME + " ("+ID+")");
            channelField.setText(CH);
            nameField.setText((String) form1.elementAt(0));
            typeField.setText("Type : "+form1.elementAt(1));
            samplingField.setText((String) form1.elementAt(2));
            
            alwaysOnIcon.setEnabled(form1.elementAt(3).equals("0") ? true : false);
            boolean workingTimeEnable = form1.elementAt(3).equals("1") ?  true : false;
            workingTimeIcon.setEnabled(workingTimeEnable);
            sun.setEnabled(workingTimeEnable);
            mon.setEnabled(workingTimeEnable);
            tue.setEnabled(workingTimeEnable);
            wed.setEnabled(workingTimeEnable);
            thu.setEnabled(workingTimeEnable);
            fri.setEnabled(workingTimeEnable);
            sat.setEnabled(workingTimeEnable);
            fromToLabel.setEnabled(workingTimeEnable);
            fromToField.setEnabled(workingTimeEnable);
            repeatField.setEnabled(workingTimeEnable);
            dayPanel.setEnabled(workingTimeEnable);
            
            sun.setIcon(((String)form1.elementAt(4)).charAt(0) == '1' ? ON : OFF);
            mon.setIcon(((String)form1.elementAt(4)).charAt(1) == '1' ? ON : OFF);
            tue.setIcon(((String)form1.elementAt(4)).charAt(2) == '1' ? ON : OFF);
            wed.setIcon(((String)form1.elementAt(4)).charAt(3) == '1' ? ON : OFF);
            thu.setIcon(((String)form1.elementAt(4)).charAt(4) == '1' ? ON : OFF);
            fri.setIcon(((String)form1.elementAt(4)).charAt(5) == '1' ? ON : OFF);
            sat.setIcon(((String)form1.elementAt(4)).charAt(6) == '1' ? ON : OFF);
            
            fromToField.setText(form1.elementAt(5)+" - "+form1.elementAt(6));
            repeatField.setText(form1.elementAt(7).equals("1") ? "(Repeat)" : "(Occur Once)");
            
            lowerField.setText((String)form1.elementAt(8));
            lowerExtremeField.setText((String)form1.elementAt(9));
            lowerTimeField.setText((String)form1.elementAt(10));
            upperField.setText((String)form1.elementAt(11));
            upperExtremeField.setText((String)form1.elementAt(12));
            upperTimeField.setText((String)form1.elementAt(13));
            
            checkIcon.setIcon(form1.elementAt(15).equals("1") ? ON : OFF);
            
            if (form1.elementAt(16) != null)
            {
                String hostID = (String) form1.elementAt(16);
                Vector host = DLP.DMIF.MF.HDC.queryRow("SELECT "
                        + "host_name, host_type_name, host_description "
                        + "FROM host NATURAL JOIN host_type "
                        + "WHERE host_id = '"+hostID+"'"
                        + ";");
                if( host != null)
                {
                    hostField.setText(hostID);
                    hostNameField.setText((String)host.elementAt(0));
                    hostTypeField.setText((String)host.elementAt(1));
                    hostDescriptionField.setText((String)host.elementAt(2));
                    HydeImage HI = new HydeImage();
                    HI.setImageFromUrl(DLP.DMIF.MF.SD.urlImgPath+"/image/host/"+hostID+".jpg", picLabel, picPanel, 360, 240,HydeImage.NO_SCALED);
                
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        checkIcon = new javax.swing.JLabel();
        lowerLabel = new javax.swing.JLabel();
        lowerTimeLabel = new javax.swing.JLabel();
        lowerExtremeLabel = new javax.swing.JLabel();
        secondsLabel = new javax.swing.JLabel();
        lowerField = new javax.swing.JTextField();
        lowerTimeField = new javax.swing.JTextField();
        lowerExtremeField = new javax.swing.JTextField();
        upperLabel = new javax.swing.JLabel();
        upperTimeLable = new javax.swing.JLabel();
        upperExtremeLabel = new javax.swing.JLabel();
        secondsLabel1 = new javax.swing.JLabel();
        upperField = new javax.swing.JTextField();
        upperTimeField = new javax.swing.JTextField();
        upperExtremeField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        samplingField = new javax.swing.JTextField();
        unitLabel = new javax.swing.JLabel();
        samplingLabel = new javax.swing.JLabel();
        alwaysOnIcon = new javax.swing.JLabel();
        workingTimeIcon = new javax.swing.JLabel();
        dayPanel = new javax.swing.JPanel();
        sun = new javax.swing.JLabel();
        mon = new javax.swing.JLabel();
        tue = new javax.swing.JLabel();
        wed = new javax.swing.JLabel();
        thu = new javax.swing.JLabel();
        fri = new javax.swing.JLabel();
        sat = new javax.swing.JLabel();
        fromToLabel = new javax.swing.JLabel();
        fromToField = new javax.swing.JLabel();
        repeatField = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        parentLabel = new javax.swing.JLabel();
        parentField = new javax.swing.JLabel();
        channelLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        channelField = new javax.swing.JLabel();
        locationScroll = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        hostLabel = new javax.swing.JLabel();
        hostField = new javax.swing.JLabel();
        hostName = new javax.swing.JLabel();
        hostNameField = new javax.swing.JLabel();
        hostTypeField = new javax.swing.JLabel();
        hostDescriptionField = new javax.swing.JLabel();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Level"));

        checkIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        checkIcon.setText("Enable Level Checker");

        lowerLabel.setText("Lower");

        lowerTimeLabel.setText("Lower-time delay");

        lowerExtremeLabel.setText("Lower Extreme");

        secondsLabel.setText("Seconds");

        lowerField.setEditable(false);
        lowerField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lowerTimeField.setEditable(false);
        lowerTimeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lowerExtremeField.setEditable(false);
        lowerExtremeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        upperLabel.setText("Upper");

        upperTimeLable.setText("Upper-time delay");

        upperExtremeLabel.setText("Upper Extreme");

        secondsLabel1.setText("Seconds");

        upperField.setEditable(false);
        upperField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        upperTimeField.setEditable(false);
        upperTimeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        upperExtremeField.setEditable(false);
        upperExtremeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkIcon)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lowerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lowerField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lowerTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lowerTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lowerExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lowerExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(upperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(upperField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(upperTimeLable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(upperTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(upperExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(upperExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkIcon)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowerLabel)
                    .addComponent(lowerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerTimeLabel)
                    .addComponent(lowerTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowerExtremeLabel)
                    .addComponent(lowerExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upperLabel)
                    .addComponent(upperField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperTimeLable)
                    .addComponent(upperTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondsLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upperExtremeLabel)
                    .addComponent(upperExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Operate"));

        samplingField.setEditable(false);
        samplingField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        unitLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        unitLabel.setText("Seconds");

        samplingLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        samplingLabel.setText("Sampling Rate");

        alwaysOnIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alwaysOnIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/always_32.png"))); // NOI18N
        alwaysOnIcon.setBorder(javax.swing.BorderFactory.createTitledBorder("Always on mode"));

        workingTimeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        workingTimeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/stopwatch_start_32.png"))); // NOI18N
        workingTimeIcon.setBorder(javax.swing.BorderFactory.createTitledBorder("Working time mode"));
        workingTimeIcon.setEnabled(false);

        dayPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Working time mode details"));
        dayPanel.setEnabled(false);

        sun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sun.setText("SUN");
        sun.setEnabled(false);

        mon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        mon.setText("MON");
        mon.setEnabled(false);

        tue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        tue.setText("TUE");
        tue.setEnabled(false);

        wed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        wed.setText("WED");
        wed.setEnabled(false);

        thu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        thu.setText("THU");
        thu.setEnabled(false);

        fri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        fri.setText("FRI");
        fri.setEnabled(false);

        sat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sat.setText("SAT");
        sat.setEnabled(false);

        fromToLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fromToLabel.setText("From-To : ");
        fromToLabel.setEnabled(false);

        fromToField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fromToField.setText("00:00 - 00:00");
        fromToField.setEnabled(false);

        repeatField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        repeatField.setText("(Repeat)");
        repeatField.setEnabled(false);

        javax.swing.GroupLayout dayPanelLayout = new javax.swing.GroupLayout(dayPanel);
        dayPanel.setLayout(dayPanelLayout);
        dayPanelLayout.setHorizontalGroup(
            dayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dayPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fromToLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fromToField)
                        .addGap(18, 18, 18)
                        .addComponent(repeatField))
                    .addGroup(dayPanelLayout.createSequentialGroup()
                        .addComponent(sun, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tue, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wed, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        dayPanelLayout.setVerticalGroup(
            dayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dayPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sun)
                    .addComponent(mon)
                    .addComponent(tue)
                    .addComponent(wed)
                    .addComponent(thu)
                    .addComponent(fri)
                    .addComponent(sat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromToLabel)
                    .addComponent(fromToField)
                    .addComponent(repeatField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(samplingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(samplingField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(alwaysOnIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(workingTimeIcon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(samplingLabel)
                    .addComponent(samplingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitLabel))
                .addGap(18, 18, 18)
                .addComponent(alwaysOnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(workingTimeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Info"));

        parentLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        parentLabel.setText("Parent Device : ");

        parentField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        channelLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        channelLabel.setText("Channel #");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameField.setText("Test Probe...");

        typeField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeField.setText("Type : ");

        channelField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        channelField.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(parentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(parentField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(channelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(channelField)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parentLabel)
                    .addComponent(parentField, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(channelLabel)
                    .addComponent(channelField)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeField)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Operate Mode", jScrollPane1);

        hostLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hostLabel.setText("Host ID : ");

        hostField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hostField.setText("-");

        hostName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hostName.setText("Host Name : ");

        hostNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hostNameField.setText("-");

        hostTypeField.setText("-");

        hostDescriptionField.setText("-");

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Photo"));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));
        picPanel.add(picLabel);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostField, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(hostName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hostNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostTypeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hostDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostLabel)
                    .addComponent(hostField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hostName)
                    .addComponent(hostNameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hostTypeField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostDescriptionField)
                .addGap(19, 19, 19)
                .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        locationScroll.setViewportView(jPanel5);

        jTabbedPane1.addTab("Host", locationScroll);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alwaysOnIcon;
    private javax.swing.JLabel channelField;
    private javax.swing.JLabel channelLabel;
    private javax.swing.JLabel checkIcon;
    private javax.swing.JPanel dayPanel;
    private javax.swing.JLabel fri;
    private javax.swing.JLabel fromToField;
    private javax.swing.JLabel fromToLabel;
    private javax.swing.JLabel hostDescriptionField;
    private javax.swing.JLabel hostField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JLabel hostName;
    private javax.swing.JLabel hostNameField;
    private javax.swing.JLabel hostTypeField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane locationScroll;
    private javax.swing.JTextField lowerExtremeField;
    private javax.swing.JLabel lowerExtremeLabel;
    private javax.swing.JTextField lowerField;
    private javax.swing.JLabel lowerLabel;
    private javax.swing.JTextField lowerTimeField;
    private javax.swing.JLabel lowerTimeLabel;
    private javax.swing.JLabel mon;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel parentField;
    private javax.swing.JLabel parentLabel;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JLabel repeatField;
    private javax.swing.JTextField samplingField;
    private javax.swing.JLabel samplingLabel;
    private javax.swing.JLabel sat;
    private javax.swing.JLabel secondsLabel;
    private javax.swing.JLabel secondsLabel1;
    private javax.swing.JLabel sun;
    private javax.swing.JLabel thu;
    private javax.swing.JLabel tue;
    private javax.swing.JLabel typeField;
    private javax.swing.JLabel unitLabel;
    private javax.swing.JTextField upperExtremeField;
    private javax.swing.JLabel upperExtremeLabel;
    private javax.swing.JTextField upperField;
    private javax.swing.JLabel upperLabel;
    private javax.swing.JTextField upperTimeField;
    private javax.swing.JLabel upperTimeLable;
    private javax.swing.JLabel wed;
    private javax.swing.JLabel workingTimeIcon;
    // End of variables declaration//GEN-END:variables

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
            if (src == picLabel)
            {
                FullFrame FPD = new FullFrame(DLP.DMIF.MF.SD.urlImgPath+"/image/host/"+hostField.getText()+".jpg");
            }
        }
    }

}
