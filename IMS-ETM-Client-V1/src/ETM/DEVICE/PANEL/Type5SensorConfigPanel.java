/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.DEVICE.PANEL;

import ETM.Util.HydeFormat;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class Type5SensorConfigPanel extends javax.swing.JPanel implements ActionListener
{
    private DeviceModifyPanel DMP;
    private String ID;
    private String CH;
    private String NAME;
    
    private static String defaultProfileComboBox = "Select a profile...";
    
    public Type5SensorConfigPanel(DeviceModifyPanel DMP, String id, String name, String ch) 
    {
        this.DMP = DMP;
        this.ID = id;
        this.NAME = name;
        this.CH = ch;
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setInfo();
        setProfileComboBox();
    }
    
    private void actionComponents()
    {
        profileComboBox.addActionListener(this);
        profileSetButton.addActionListener(this);
        profileSaveButton.addActionListener(this);
        profileNewButton.addActionListener(this);
        profileDeleteButton.addActionListener(this);
    }
    
    public void setProfileComboBox()
    {
        profileComboBox.removeAllItems();
        profileComboBox.addItem(defaultProfileComboBox);
        Enumeration enu = DMP.DMIF.MF.HDC.queryColumn("SELECT CONCAT(profile_name,' (',profile_id+0,')') FROM device_channel_profile;").elements();
        while (enu.hasMoreElements())
        {
            profileComboBox.addItem(enu.nextElement());
        }
    }
    
    public void setInfo()
    {
        Vector form1 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "channel_name, probe_type_name, sampling, working_type, day_on_work, "
                + "from_time, to_time, reoccur, lower_limit, lower_extreme_limit, "
                + "lower_time_limit, upper_limit, upper_extreme_limit, upper_time_limit, channel_enable, "
                + "level_enable "
                + "FROM device_channel NATURAL JOIN probe_type WHERE device_id = '"+ID+"' AND channel = '"+CH+"';");
        if (form1 != null && form1.size() >= 14)
        {
            samplingField.setText((String) form1.elementAt(2));
            workingTimeRB.setSelected(form1.elementAt(3).equals("1") ? true : false);
            
            sunCHB.setSelected(((String)form1.elementAt(4)).charAt(0) == '1' ? true : false);
            monCHB.setSelected(((String)form1.elementAt(4)).charAt(1) == '1' ? true : false);
            tueCHB.setSelected(((String)form1.elementAt(4)).charAt(2) == '1' ? true : false);
            wedCHB.setSelected(((String)form1.elementAt(4)).charAt(3) == '1' ? true : false);
            thuCHB.setSelected(((String)form1.elementAt(4)).charAt(4) == '1' ? true : false);
            friCHB.setSelected(((String)form1.elementAt(4)).charAt(5) == '1' ? true : false);
            satCHB.setSelected(((String)form1.elementAt(4)).charAt(6) == '1' ? true : false);
            
            String from = (String)form1.elementAt(5);
            String to   = (String)form1.elementAt(6);
            String[] fromA = from.split(":");
            String[] toA = to.split(":");
            fromHourCB.setSelectedItem(fromA[0]);
            fromMinCB.setSelectedItem(fromA[1]);
            toHourCB.setSelectedItem(toA[0]);
            toMinCB.setSelectedItem(toA[1]);
            
            onceRB.setSelected(form1.elementAt(7).equals("1") ? true : false);
            lowerField.setText((String)form1.elementAt(8));
            lowerExtremeField.setText((String)form1.elementAt(9));
            lowerTimeField.setText((String)form1.elementAt(10));
            upperField.setText((String)form1.elementAt(11));
            upperExtremeField.setText((String)form1.elementAt(12));
            upperTimeField.setText((String)form1.elementAt(13));
            
            checkCB.setSelected(form1.elementAt(15).equals("1") ? true : false);
        }
    }
    
    public void modify()
    {
        int workingType = alwaysOnRB.isSelected() ? 0 : 1;
        int reoccur = repeatRB.isSelected() ? 0 : 1;  // 0 = Repeat 1 = occur once
        String dayOnWork = ""
                + (sunCHB.isSelected() ? 1 : 0)
                + (monCHB.isSelected() ? 1 : 0)
                + (tueCHB.isSelected() ? 1 : 0)
                + (wedCHB.isSelected() ? 1 : 0)
                + (thuCHB.isSelected() ? 1 : 0)
                + (friCHB.isSelected() ? 1 : 0)
                + (satCHB.isSelected() ? 1 : 0);
        int level = checkCB.isSelected() ? 1 : 0;
        String fromTime = fromHourCB.getSelectedItem()+":"+fromMinCB.getSelectedItem();
        String toTime = toHourCB.getSelectedItem()+":"+toMinCB.getSelectedItem();
        boolean b = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_channel SET "
                + "sampling = '"+samplingField.getText()+"', "
                + "working_type = '"+workingType+"', "
                + "day_on_work = '"+dayOnWork+"', "
                + "from_time = '"+fromTime+"', "
                + "to_time = '"+toTime+"', "
                + "reoccur = '"+reoccur+"', "
                + "lower_limit = '"+lowerField.getText()+"', "
                + "lower_extreme_limit = '"+lowerExtremeField.getText()+"', "
                + "lower_time_limit = '"+lowerTimeField.getText()+"', "
                + "upper_limit = '"+upperField.getText()+"', "
                + "upper_extreme_limit = '"+upperExtremeField.getText()+"', "
                + "upper_time_limit = '"+upperTimeField.getText()+"', "
                + "level_enable = '"+level+"' "
                + "WHERE device_id = '"+ID+"' AND channel = '"+CH+"'"
                + ";");
        if (b)
        {
            DMP.DMIF.MF.HDC.customUpdate("UPDATE device_status SET last_config_complete = 0 WHERE device_id = '"+ID+"';");
            DMP.loadDeviceData(NAME+" ("+ID+")");
            JOptionPane.showMessageDialog(this, "Modify pending, waiting for device acknowledge");
            IMSProtocolStructure IPS = new IMSProtocolStructure();
            IPS.setFrameType(IMSClientProtocol.SENSOR_CONFIG_CMD);
            IPS.setDeviceID(ID);
            IPS.setChannel(CH);
            IPS.setAccessDirection(IMSClientProtocol.ACCD_WRITE);
            DMP.DMIF.MF.FC.findBufferByID("0000000000000000",DMP.DMIF.MF.SD.serverIP,DMP.DMIF.MF.SD.SERVER_PORT).addFrame(IPS);
            
            DMP.DMIF.MF.HDC.customUpdate("INSERT INTO "+DMP.DMIF.MF.HDC.database+"_log.modify_log SET "
                + "device_id = '"+ID+"', "
                + "log_id = '105', "
                + "description = 'Modify sensor "+CH+" configuration', "
                + "user_username = '"+DMP.DMIF.MF.SD.loginUser+"' "
                + ";");
        }
    }
    
    public void read()
    {
        //DMP.DMIF.MF.HDC.customUpdate("UPDATE device_status SET last_config_complete = 0 WHERE device_id = '"+ID+"';");
        JOptionPane.showMessageDialog(this, "Modify pending, waiting for device acknowledge");
        setInfo();
        IMSProtocolStructure IPS = new IMSProtocolStructure();
        IPS.setFrameType(IMSClientProtocol.SENSOR_CONFIG_CMD);
        IPS.setDeviceID(ID);
        IPS.setChannel(CH);
        IPS.setAccessDirection(IMSClientProtocol.ACCD_READ);
        DMP.DMIF.MF.FC.findBufferByID("0000000000000000",DMP.DMIF.MF.SD.serverIP,DMP.DMIF.MF.SD.SERVER_PORT).addFrame(IPS);
        
        DMP.DMIF.MF.HDC.customUpdate("INSERT INTO "+DMP.DMIF.MF.HDC.database+"_log.modify_log SET "
                + "device_id = '"+ID+"', "
                + "log_id = '105', "
                + "description = 'Read configuration from sensor channel "+CH+"', "
                + "user_username = '"+DMP.DMIF.MF.SD.loginUser+"' "
                + ";");
    }
    
    public void applyConfigProfile(String profileID)
    {
        Vector form1 = DMP.DMIF.MF.HDC.queryRow("SELECT "
                + "sampling, working_type, day_on_work, from_time, to_time, "
                + "reoccur, lower_limit, lower_extreme_limit, lower_time_limit, upper_limit, "
                + "upper_extreme_limit, upper_time_limit, level_enable "
                + "FROM device_channel_profile WHERE profile_id = '"+profileID+"' ;");
        if (form1 != null && form1.size() >= 12)
        {
            samplingField.setText((String) form1.elementAt(0));
            alwaysOnRB.setSelected(form1.elementAt(1).equals("0") ? true : false);
            workingTimeRB.setSelected(form1.elementAt(1).equals("1") ? true : false);
            
            sunCHB.setSelected(((String)form1.elementAt(2)).charAt(0) == '1' ? true : false);
            monCHB.setSelected(((String)form1.elementAt(2)).charAt(1) == '1' ? true : false);
            tueCHB.setSelected(((String)form1.elementAt(2)).charAt(2) == '1' ? true : false);
            wedCHB.setSelected(((String)form1.elementAt(2)).charAt(3) == '1' ? true : false);
            thuCHB.setSelected(((String)form1.elementAt(2)).charAt(4) == '1' ? true : false);
            friCHB.setSelected(((String)form1.elementAt(2)).charAt(5) == '1' ? true : false);
            satCHB.setSelected(((String)form1.elementAt(2)).charAt(6) == '1' ? true : false);
            
            String from = (String)form1.elementAt(3);
            String to   = (String)form1.elementAt(4);
            String[] fromA = from.split(":");
            String[] toA = to.split(":");
            fromHourCB.setSelectedItem(fromA[0]);
            fromMinCB.setSelectedItem(fromA[1]);
            toHourCB.setSelectedItem(toA[0]);
            toMinCB.setSelectedItem(toA[1]);
            
            repeatRB.setSelected(form1.elementAt(5).equals("0") ? true : false);
            onceRB.setSelected(form1.elementAt(5).equals("1") ? true : false);
            lowerField.setText((String)form1.elementAt(6));
            lowerExtremeField.setText((String)form1.elementAt(7));
            lowerTimeField.setText((String)form1.elementAt(8));
            upperField.setText((String)form1.elementAt(9));
            upperExtremeField.setText((String)form1.elementAt(10));
            upperTimeField.setText((String)form1.elementAt(11));
            
            checkCB.setSelected(form1.elementAt(12).equals("1") ? true : false);
        }
    }
    
    public void createConfigProfile(String profileName)
    {
        int workingType = alwaysOnRB.isSelected() ? 0 : 1;
        int reoccur = repeatRB.isSelected() ? 0 : 1;
        String dayOnWork = ""
                + (sunCHB.isSelected() ? 1 : 0)
                + (monCHB.isSelected() ? 1 : 0)
                + (tueCHB.isSelected() ? 1 : 0)
                + (wedCHB.isSelected() ? 1 : 0)
                + (thuCHB.isSelected() ? 1 : 0)
                + (friCHB.isSelected() ? 1 : 0)
                + (satCHB.isSelected() ? 1 : 0);
        int level = checkCB.isSelected() ? 1 : 0;
        String fromTime = fromHourCB.getSelectedItem()+":"+fromMinCB.getSelectedItem();
        String toTime = toHourCB.getSelectedItem()+":"+toMinCB.getSelectedItem();
        boolean b = DMP.DMIF.MF.HDC.customUpdate("INSERT INTO device_channel_profile SET "
                + "profile_name = '"+profileName+"', "
                + "sampling = '"+samplingField.getText()+"', "
                + "working_type = '"+workingType+"', "
                + "day_on_work = '"+dayOnWork+"', "
                + "from_time = '"+fromTime+"', "
                + "to_time = '"+toTime+"', "
                + "reoccur = '"+reoccur+"', "
                + "lower_limit = '"+lowerField.getText()+"', "
                + "lower_extreme_limit = '"+lowerExtremeField.getText()+"', "
                + "lower_time_limit = '"+lowerTimeField.getText()+"', "
                + "upper_limit = '"+upperField.getText()+"', "
                + "upper_extreme_limit = '"+upperExtremeField.getText()+"', "
                + "upper_time_limit = '"+upperTimeField.getText()+"', "
                + "level_enable = '"+level+"' "
                + ";");
        if (b)
        {
            JOptionPane.showMessageDialog(this, "Profile has been created");
        }
    }
    
    public void updateConfigProfile(String profileID)
    {
        int workingType = alwaysOnRB.isSelected() ? 0 : 1;
        int reoccur = repeatRB.isSelected() ? 0 : 1;
        String dayOnWork = ""
                + (sunCHB.isSelected() ? 1 : 0)
                + (monCHB.isSelected() ? 1 : 0)
                + (tueCHB.isSelected() ? 1 : 0)
                + (wedCHB.isSelected() ? 1 : 0)
                + (thuCHB.isSelected() ? 1 : 0)
                + (friCHB.isSelected() ? 1 : 0)
                + (satCHB.isSelected() ? 1 : 0);
        int level = checkCB.isSelected() ? 1 : 0;
        String fromTime = fromHourCB.getSelectedItem()+":"+fromMinCB.getSelectedItem();
        String toTime = toHourCB.getSelectedItem()+":"+toMinCB.getSelectedItem();
        boolean b = DMP.DMIF.MF.HDC.customUpdate("UPDATE device_channel_profile SET "
                + "sampling = '"+samplingField.getText()+"', "
                + "working_type = '"+workingType+"', "
                + "day_on_work = '"+dayOnWork+"', "
                + "from_time = '"+fromTime+"', "
                + "to_time = '"+toTime+"', "
                + "reoccur = '"+reoccur+"', "
                + "lower_limit = '"+lowerField.getText()+"', "
                + "lower_extreme_limit = '"+lowerExtremeField.getText()+"', "
                + "lower_time_limit = '"+lowerTimeField.getText()+"', "
                + "upper_limit = '"+upperField.getText()+"', "
                + "upper_extreme_limit = '"+upperExtremeField.getText()+"', "
                + "upper_time_limit = '"+upperTimeField.getText()+"', "
                + "level_enable = '"+level+"' "
                + "WHERE profile_id = '"+profileID+"' "
                + ";");
        if (b)
        {
            JOptionPane.showMessageDialog(this, "Profile has been saved");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        sensorScroll = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        operatePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        samplingField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        alwaysOnRB = new javax.swing.JRadioButton();
        workingTimeRB = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        friCHB = new javax.swing.JCheckBox();
        fromLabel = new javax.swing.JLabel();
        toHourCB = new javax.swing.JComboBox();
        tueCHB = new javax.swing.JCheckBox();
        toLabel = new javax.swing.JLabel();
        monCHB = new javax.swing.JCheckBox();
        onceRB = new javax.swing.JRadioButton();
        repeatRB = new javax.swing.JRadioButton();
        fromMinCB = new javax.swing.JComboBox();
        toMinCB = new javax.swing.JComboBox();
        thuCHB = new javax.swing.JCheckBox();
        sunCHB = new javax.swing.JCheckBox();
        wedCHB = new javax.swing.JCheckBox();
        fromHourCB = new javax.swing.JComboBox();
        satCHB = new javax.swing.JCheckBox();
        levelPanel = new javax.swing.JPanel();
        lowerLabel = new javax.swing.JLabel();
        lowerExtremeLabel = new javax.swing.JLabel();
        lowerTimeLabel = new javax.swing.JLabel();
        secondsLabel1 = new javax.swing.JLabel();
        lowerField = new javax.swing.JTextField();
        lowerExtremeField = new javax.swing.JTextField();
        lowerTimeField = new javax.swing.JTextField();
        upperLabel = new javax.swing.JLabel();
        upperExtremeLabel = new javax.swing.JLabel();
        upperTimeLabel = new javax.swing.JLabel();
        secondsLabel2 = new javax.swing.JLabel();
        upperField = new javax.swing.JTextField();
        upperExtremeField = new javax.swing.JTextField();
        upperTimeField = new javax.swing.JTextField();
        checkCB = new javax.swing.JCheckBox();
        jToolBar8 = new javax.swing.JToolBar();
        profileSetButton = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        profileSaveButton = new javax.swing.JButton();
        profileNewButton = new javax.swing.JButton();
        profileDeleteButton = new javax.swing.JButton();
        profileLabel = new javax.swing.JLabel();
        profileComboBox = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        operatePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Operate"));

        jLabel7.setText("Sampling Rate");

        jLabel9.setText("Seconds");

        buttonGroup1.add(alwaysOnRB);
        alwaysOnRB.setSelected(true);
        alwaysOnRB.setText("Always on");

        buttonGroup1.add(workingTimeRB);
        workingTimeRB.setText("Working Time");

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        friCHB.setText("Fri");

        fromLabel.setText("From : ");

        toHourCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        tueCHB.setText("Tue");

        toLabel.setText("To     : ");

        monCHB.setText("Mon");

        buttonGroup2.add(onceRB);
        onceRB.setText("Occur once");

        buttonGroup2.add(repeatRB);
        repeatRB.setSelected(true);
        repeatRB.setText("Repeat");

        fromMinCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        toMinCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));

        thuCHB.setText("Thu");

        sunCHB.setText("Sun");

        wedCHB.setText("Wed");

        fromHourCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        satCHB.setText("Sat");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toMinCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(fromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromMinCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(repeatRB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(onceRB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(sunCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tueCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(wedCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(thuCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(friCHB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(satCHB)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sunCHB)
                    .addComponent(monCHB)
                    .addComponent(tueCHB)
                    .addComponent(wedCHB)
                    .addComponent(thuCHB)
                    .addComponent(friCHB)
                    .addComponent(satCHB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromLabel)
                    .addComponent(fromHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromMinCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(repeatRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel)
                    .addComponent(toHourCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toMinCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(onceRB))
                .addContainerGap())
        );

        javax.swing.GroupLayout operatePanelLayout = new javax.swing.GroupLayout(operatePanel);
        operatePanel.setLayout(operatePanelLayout);
        operatePanelLayout.setHorizontalGroup(
            operatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operatePanelLayout.createSequentialGroup()
                .addGroup(operatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(operatePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(operatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(workingTimeRB)
                            .addComponent(alwaysOnRB)
                            .addGroup(operatePanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(samplingField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9))))
                    .addGroup(operatePanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        operatePanelLayout.setVerticalGroup(
            operatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operatePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(operatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(samplingField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addComponent(alwaysOnRB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(workingTimeRB)
                .addGap(2, 2, 2)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        levelPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Level"));

        lowerLabel.setText("Lower");

        lowerExtremeLabel.setText("Lower Extreme");

        lowerTimeLabel.setText("Lower Time Delay");

        secondsLabel1.setText("Seconds");

        lowerField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lowerField.setText("0.000");
        lowerField.setMaximumSize(new java.awt.Dimension(35, 20));
        lowerField.setMinimumSize(new java.awt.Dimension(35, 20));
        lowerField.setPreferredSize(new java.awt.Dimension(35, 20));
        lowerField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,ETM.Util.HydeJTextFieldLimit.MODE_FLOATING_1POINT_WITH_LIMIT));

        lowerExtremeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lowerExtremeField.setText("0.000");
        lowerExtremeField.setMaximumSize(new java.awt.Dimension(35, 20));
        lowerExtremeField.setMinimumSize(new java.awt.Dimension(35, 20));
        lowerExtremeField.setPreferredSize(new java.awt.Dimension(35, 20));
        lowerExtremeField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,ETM.Util.HydeJTextFieldLimit.MODE_FLOATING_1POINT_WITH_LIMIT));

        lowerTimeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lowerTimeField.setText("0");
        lowerTimeField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,1));

        upperLabel.setText("Upper");

        upperExtremeLabel.setText("Upper Extreme");

        upperTimeLabel.setText("Upper Time Delay");

        secondsLabel2.setText("Seconds");

        upperField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        upperField.setText("0.000");
        upperField.setMaximumSize(new java.awt.Dimension(35, 20));
        upperField.setMinimumSize(new java.awt.Dimension(35, 20));
        upperField.setPreferredSize(new java.awt.Dimension(35, 20));
        upperField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,ETM.Util.HydeJTextFieldLimit.MODE_FLOATING_1POINT_WITH_LIMIT));

        upperExtremeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        upperExtremeField.setText("0.000");
        upperExtremeField.setMaximumSize(new java.awt.Dimension(35, 20));
        upperExtremeField.setMinimumSize(new java.awt.Dimension(35, 20));
        upperExtremeField.setPreferredSize(new java.awt.Dimension(35, 20));
        upperExtremeField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,ETM.Util.HydeJTextFieldLimit.MODE_FLOATING_1POINT_WITH_LIMIT));

        upperTimeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        upperTimeField.setText("0");
        lowerTimeField.setDocument(new ETM.Util.HydeJTextFieldLimit(10,1));

        checkCB.setText("Enable Level Check");

        javax.swing.GroupLayout levelPanelLayout = new javax.swing.GroupLayout(levelPanel);
        levelPanel.setLayout(levelPanelLayout);
        levelPanelLayout.setHorizontalGroup(
            levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(levelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(levelPanelLayout.createSequentialGroup()
                        .addComponent(lowerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lowerTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel1))
                    .addGroup(levelPanelLayout.createSequentialGroup()
                        .addComponent(lowerExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lowerExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(levelPanelLayout.createSequentialGroup()
                        .addComponent(upperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upperField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(upperTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upperTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondsLabel2))
                    .addGroup(levelPanelLayout.createSequentialGroup()
                        .addComponent(upperExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upperExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkCB))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        levelPanelLayout.setVerticalGroup(
            levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, levelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkCB)
                .addGap(18, 18, 18)
                .addGroup(levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowerLabel)
                    .addComponent(lowerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lowerTimeLabel)
                    .addComponent(lowerTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondsLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowerExtremeLabel)
                    .addComponent(lowerExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upperLabel)
                    .addComponent(upperField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperTimeLabel)
                    .addComponent(upperTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondsLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(levelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upperExtremeLabel)
                    .addComponent(upperExtremeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar8.setFloatable(false);
        jToolBar8.setRollover(true);

        profileSetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/download_16.png"))); // NOI18N
        profileSetButton.setToolTipText("Apply Profile");
        profileSetButton.setEnabled(false);
        profileSetButton.setFocusable(false);
        profileSetButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileSetButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar8.add(profileSetButton);

        jToolBar5.setFloatable(false);

        profileSaveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/save_16.png"))); // NOI18N
        profileSaveButton.setToolTipText("Modify Selected Profile");
        profileSaveButton.setEnabled(false);
        profileSaveButton.setFocusable(false);
        profileSaveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileSaveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileSaveButton);

        profileNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/new_16.png"))); // NOI18N
        profileNewButton.setToolTipText("Add New Profile");
        profileNewButton.setFocusable(false);
        profileNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileNewButton);

        profileDeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/cancel_16.png"))); // NOI18N
        profileDeleteButton.setToolTipText("Delete Selected Profile");
        profileDeleteButton.setEnabled(false);
        profileDeleteButton.setFocusable(false);
        profileDeleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        profileDeleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(profileDeleteButton);

        profileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profileLabel.setText("Profile");

        profileComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a profile..." }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(levelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
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
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jToolBar8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(profileComboBox)
                        .addComponent(profileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(operatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        sensorScroll.setViewportView(jPanel11);

        add(sensorScroll, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alwaysOnRB;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkCB;
    private javax.swing.JCheckBox friCHB;
    private javax.swing.JComboBox fromHourCB;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JComboBox fromMinCB;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar8;
    private javax.swing.JPanel levelPanel;
    private javax.swing.JTextField lowerExtremeField;
    private javax.swing.JLabel lowerExtremeLabel;
    private javax.swing.JTextField lowerField;
    private javax.swing.JLabel lowerLabel;
    private javax.swing.JTextField lowerTimeField;
    private javax.swing.JLabel lowerTimeLabel;
    private javax.swing.JCheckBox monCHB;
    private javax.swing.JRadioButton onceRB;
    private javax.swing.JPanel operatePanel;
    private javax.swing.JComboBox profileComboBox;
    private javax.swing.JButton profileDeleteButton;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JButton profileNewButton;
    private javax.swing.JButton profileSaveButton;
    private javax.swing.JButton profileSetButton;
    private javax.swing.JRadioButton repeatRB;
    private javax.swing.JTextField samplingField;
    private javax.swing.JCheckBox satCHB;
    private javax.swing.JLabel secondsLabel1;
    private javax.swing.JLabel secondsLabel2;
    private javax.swing.JScrollPane sensorScroll;
    private javax.swing.JCheckBox sunCHB;
    private javax.swing.JCheckBox thuCHB;
    private javax.swing.JComboBox toHourCB;
    private javax.swing.JLabel toLabel;
    private javax.swing.JComboBox toMinCB;
    private javax.swing.JCheckBox tueCHB;
    private javax.swing.JTextField upperExtremeField;
    private javax.swing.JLabel upperExtremeLabel;
    private javax.swing.JTextField upperField;
    private javax.swing.JLabel upperLabel;
    private javax.swing.JTextField upperTimeField;
    private javax.swing.JLabel upperTimeLabel;
    private javax.swing.JCheckBox wedCHB;
    private javax.swing.JRadioButton workingTimeRB;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == profileNewButton)
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
                DMP.DMIF.MF.HDC.customUpdate("DELETE FROM device_channel_profile WHERE profile_id = '"+pid+"';");
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
}
