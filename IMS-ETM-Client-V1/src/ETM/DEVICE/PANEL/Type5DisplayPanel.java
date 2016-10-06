package ETM.DEVICE.PANEL;

import ETM.MAIN.FullFrame;
import HydeModule.Image.HydeImage;
import HydeModule.Table.HydeDataSet;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Type5DisplayPanel extends javax.swing.JPanel implements MouseListener
{
    private String ID;
    private DeviceListPanel DLP;
    
    private ImageIcon ON = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/accept_16.png"));
    private ImageIcon OFF = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"));
    
    private ImageIcon REALTIME = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/realtime_32.png"));
    private ImageIcon DATALOGGER = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/data_log_32.png"));
    
    private ImageIcon DEV_ENABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_enable_32.png"));
    private ImageIcon DEV_DISABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_disable_32.png"));
    
    private ImageIcon ALARM_ENABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_enable_32.png"));
    private ImageIcon ALARM_DISABLE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_disable_32.png"));
    
    private ImageIcon CHARGE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_charge_32.png"));
    private ImageIcon UNCHARGE = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_uncharge_32.png"));
    
    private ImageIcon LIGHT_ON = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_24.png"));
    private ImageIcon LIGHT_OFF = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"));
    
    public Type5DisplayPanel(DeviceListPanel DLP, String ID) 
    {
        this.ID = ID;
        this.DLP = DLP;
        initComponents();
        extendComponents();
    }
    
    private void extendComponents()
    {
        setInfo();
        setStatus();
        picLabel.addMouseListener(this);
    }
    
    public void setInfo()
    {
        Vector form1 = DLP.DMIF.MF.HDC.queryRow("SELECT "
                + "device_name, device_serial, device_product_serial, equipment_type, device_link, "
                + "device_group_id, location_id, device_firmware "
                + "FROM device NATURAL JOIN equipment WHERE device_id = '"+ID+"';");
        if (form1 != null && form1.size() >= 7)
        {
            idField.setText(ID);
            nameField.setText((String) form1.elementAt(0));
            serialField.setText((String) form1.elementAt(1));
            
            String group = DLP.DMIF.MF.HDC.query0("SELECT CONCAT(device_group_name, ' (', device_group_id, ')') "
                    + "FROM device_group WHERE device_group_id = '"+form1.elementAt(5)+"';");
            groupField.setText(group);
            
            Vector location = DLP.DMIF.MF.HDC.queryRow("SELECT location_name, location_description, CONCAT(depart_name,' (',location.depart_id,')') "
                    + "FROM location LEFT JOIN department ON location.depart_id WHERE location_id = '"+form1.elementAt(6)+"';");
            
            if (location != null && location.size() >= 2)
            {
                locationField.setText((String)form1.elementAt(6));
                locationNameField.setText((String)location.elementAt(0));
                departField.setText((String)location.elementAt(2));
                locationDescriptionField.setText((String)location.elementAt(1));
            
                HydeImage HI = new HydeImage();
                HI.setImageFromUrl(DLP.DMIF.MF.SD.urlImgPath+"/image/location/"+form1.elementAt(6)+".jpg", picLabel, picPanel, 360, 240,HydeImage.NO_SCALED);
            }
        }
        
        Vector form2 = DLP.DMIF.MF.HDC.queryAll("SELECT "
                + "channel_enable, channel_name, probe_type_name, last_data, last_data_timestamp "
                + "FROM device_channel NATURAL JOIN probe_type WHERE device_id = '"+ID+"' ORDER BY channel ASC;");
        HydeDataSet HDS = new HydeDataSet(form2);
        Vector data = HDS.getRowVector();
        if (data != null && data.size() >=5 )
        {
            Vector channel1 = (Vector) data.elementAt(0);
            Vector channel2 = (Vector) data.elementAt(1);
            Vector channel3 = (Vector) data.elementAt(2);
            Vector channel4 = (Vector) data.elementAt(3);
            Vector channel5 = (Vector) data.elementAt(4);
            
            Color enableColor = new java.awt.Color(0, 204, 0);
            Color disableColor = new java.awt.Color(204, 204, 204);
            Color errorColor = new java.awt.Color(204, 0, 0);

            probe1.setBorder(javax.swing.BorderFactory.createLineBorder(channel1.elementAt(0).equals("1") ? enableColor : disableColor, 3));
            probe2.setBorder(javax.swing.BorderFactory.createLineBorder(channel2.elementAt(0).equals("1") ? enableColor : disableColor, 3));
            probe3.setBorder(javax.swing.BorderFactory.createLineBorder(channel3.elementAt(0).equals("1") ? enableColor : disableColor, 3));
            probe4.setBorder(javax.swing.BorderFactory.createLineBorder(channel4.elementAt(0).equals("1") ? enableColor : disableColor, 3));
            probe5.setBorder(javax.swing.BorderFactory.createLineBorder(channel5.elementAt(0).equals("1") ? enableColor : disableColor, 3));

            dataField1.setForeground(channel1.elementAt(0).equals("1") ? enableColor : disableColor);
            dataField2.setForeground(channel2.elementAt(0).equals("1") ? enableColor : disableColor);
            dataField3.setForeground(channel3.elementAt(0).equals("1") ? enableColor : disableColor);
            dataField4.setForeground(channel4.elementAt(0).equals("1") ? enableColor : disableColor);
            dataField5.setForeground(channel5.elementAt(0).equals("1") ? enableColor : disableColor);
            
//            dataField1.setForeground(channel1.elementAt(0).equals("1") ? enableColor : disableColor);
//            dataField2.setForeground(channel2.elementAt(0).equals("1") ? enableColor : disableColor);
//            dataField3.setForeground(channel3.elementAt(0).equals("1") ? enableColor : disableColor);
//            dataField4.setForeground(channel4.elementAt(0).equals("1") ? enableColor : disableColor);
//            dataField5.setForeground(channel5.elementAt(0).equals("1") ? enableColor : disableColor);
            
            probeField1.setText((String)channel1.elementAt(1));
            probeField2.setText((String)channel2.elementAt(1));
            probeField3.setText((String)channel3.elementAt(1));
            probeField4.setText((String)channel4.elementAt(1));
            probeField5.setText((String)channel5.elementAt(1));

            probeTypeField1.setText((String)channel1.elementAt(2));
            probeTypeField2.setText((String)channel2.elementAt(2));
            probeTypeField3.setText((String)channel3.elementAt(2));
            probeTypeField4.setText((String)channel4.elementAt(2));
            probeTypeField5.setText((String)channel5.elementAt(2));
            
            dataField1.setText(channel1.elementAt(3) + "   @"+channel1.elementAt(4));
            dataField2.setText(channel2.elementAt(3) + "   @"+channel2.elementAt(4));
            dataField3.setText(channel3.elementAt(3) + "   @"+channel3.elementAt(4));
            dataField4.setText(channel4.elementAt(3) + "   @"+channel4.elementAt(4));
            dataField5.setText(channel5.elementAt(3) + "   @"+channel5.elementAt(4));
        }
        
        Vector form3 = DLP.DMIF.MF.HDC.queryRow("SELECT "
                + "alarm_method, upper_method, lower_method, probe_error_method, ac_method, "
                + "battery_method, connection_method, digital1_method, digital2_method, ac_timeout, "
                + "connection_timeout, battery_limit, memory_limit, memory_method, digital_input_enable, "
                + "digital_input_delay, normally_output "
                + "FROM device_alarm WHERE device_id = '"+ID+"';");
        if (form3 != null && form3.size() >= 13)
        {
            setForm(form3);
        }  
        
        Vector ipp = DLP.DMIF.MF.HDC.queryRow("SELECT device_ip, device_port FROM device_network WHERE device_id = '"+ID+"';");
        if (ipp != null && ipp.size() >= 2)
        {
            ipField.setText((String)ipp.elementAt(0) + ":"+ipp.elementAt(1));
        }
    }
    
    public void setStatus()
    {
        Vector form = DLP.DMIF.MF.HDC.queryRow("SELECT "
                + "power_source, battery, device_enable, operate_mode, alarm_detector, "
                + "digital_output, digital_input "
                + "FROM device_status WHERE device_id = '"+ID+"'"
                + ";");
        if (form != null && form.size() >= 6)
        {
            acIcon.setIcon( form.elementAt(0).equals("0") ? CHARGE : UNCHARGE );
            deviceEnableIcon.setIcon( form.elementAt(2).equals("1") ? DEV_ENABLE : DEV_DISABLE );
            operatingIcon.setIcon( form.elementAt(3).equals("0") ? REALTIME : DATALOGGER );
            alarmDetectIcon.setIcon( form.elementAt(4).equals("1") ? ALARM_ENABLE : ALARM_DISABLE );
            
            String am = (String) form.elementAt(5);
            do1.setIcon( am.charAt(0) == '1' ? LIGHT_ON : LIGHT_OFF );
            do2.setIcon( am.charAt(1) == '1' ? LIGHT_ON : LIGHT_OFF );
            
            am = (String) form.elementAt(6);
            di1.setIcon( am.charAt(0) == '1' ? LIGHT_ON : LIGHT_OFF );
            di2.setIcon( am.charAt(1) == '1' ? LIGHT_ON : LIGHT_OFF );
            
            double d = Double.parseDouble((String) form.elementAt(1));
            if (d <= 3.0)
            {
                batteryBar.setValue(0);
            }
            else
            {
                int batteryLevel = (int)(( (d-3d)*100d) / 1.2d);
                batteryBar.setValue(batteryLevel);
            }
        }
    }
    
    private String[] lowerLevelText = new String[]{"No output", "Lower Level", "Lower-Time Level", "Lower Extreme Level"};
    private String[] upperLevelText = new String[]{"No output", "Upper Level", "Upper-Time Level", "Upper Extreme Level"};
    private String[] trigText = new String[]{"Trig : Disable", "Trig : Rising Edge", "Trig : Falling Edge"};
    public void setForm(Vector form3)
    {
            String am = (String) form3.elementAt(0);
            alarmMethod0.setIcon( am.charAt(0) == '1' ? ON : OFF );
            alarmMethod1.setIcon( am.charAt(1) == '1' ? ON : OFF );
            alarmMethod2.setIcon( am.charAt(2) == '1' ? ON : OFF );
            acMethod.setIcon( am.charAt(20) == '1' ? ON : OFF );
            connectionMethod.setIcon( am.charAt(21) == '1' ? ON : OFF );
            batteryMethod.setIcon( am.charAt(22) == '1' ? ON : OFF );
            memoryMethod.setIcon( am.charAt(23) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(1); //upper
            sensor1UpperOP.setText(upperLevelText[Integer.parseInt(am.charAt(0)+"")]);
            sensor2UpperOP.setText(upperLevelText[Integer.parseInt(am.charAt(1)+"")]);
            sensor3UpperOP.setText(upperLevelText[Integer.parseInt(am.charAt(2)+"")]);
            sensor4UpperOP.setText(upperLevelText[Integer.parseInt(am.charAt(3)+"")]);
            sensor5UpperOP.setText(upperLevelText[Integer.parseInt(am.charAt(4)+"")]);
            
            sensor1UpperOP1.setText(upperLevelText[Integer.parseInt(am.charAt(5)+"")]);
            sensor2UpperOP1.setText(upperLevelText[Integer.parseInt(am.charAt(6)+"")]);
            sensor3UpperOP1.setText(upperLevelText[Integer.parseInt(am.charAt(7)+"")]);
            sensor4UpperOP1.setText(upperLevelText[Integer.parseInt(am.charAt(8)+"")]);
            sensor5UpperOP1.setText(upperLevelText[Integer.parseInt(am.charAt(9)+"")]);
            
            sensor1UpperOP2.setText(upperLevelText[Integer.parseInt(am.charAt(10)+"")]);
            sensor2UpperOP2.setText(upperLevelText[Integer.parseInt(am.charAt(11)+"")]);
            sensor3UpperOP2.setText(upperLevelText[Integer.parseInt(am.charAt(12)+"")]);
            sensor4UpperOP2.setText(upperLevelText[Integer.parseInt(am.charAt(13)+"")]);
            sensor5UpperOP2.setText(upperLevelText[Integer.parseInt(am.charAt(14)+"")]);
            //upper1CB.setSelected( am.charAt(0) == '1' ? true : false );
            
            am = (String) form3.elementAt(2); 
            sensor1LowerOP.setText(lowerLevelText[Integer.parseInt(am.charAt(0)+"")]);
            sensor2LowerOP.setText(lowerLevelText[Integer.parseInt(am.charAt(1)+"")]);
            sensor3LowerOP.setText(lowerLevelText[Integer.parseInt(am.charAt(2)+"")]);
            sensor4LowerOP.setText(lowerLevelText[Integer.parseInt(am.charAt(3)+"")]);
            sensor5LowerOP.setText(lowerLevelText[Integer.parseInt(am.charAt(4)+"")]);
            
            sensor1LowerOP1.setText(lowerLevelText[Integer.parseInt(am.charAt(5)+"")]);
            sensor2LowerOP1.setText(lowerLevelText[Integer.parseInt(am.charAt(6)+"")]);
            sensor3LowerOP1.setText(lowerLevelText[Integer.parseInt(am.charAt(7)+"")]);
            sensor4LowerOP1.setText(lowerLevelText[Integer.parseInt(am.charAt(8)+"")]);
            sensor5LowerOP1.setText(lowerLevelText[Integer.parseInt(am.charAt(9)+"")]);
            
            sensor1LowerOP2.setText(lowerLevelText[Integer.parseInt(am.charAt(10)+"")]);
            sensor2LowerOP2.setText(lowerLevelText[Integer.parseInt(am.charAt(11)+"")]);
            sensor3LowerOP2.setText(lowerLevelText[Integer.parseInt(am.charAt(12)+"")]);
            sensor4LowerOP2.setText(lowerLevelText[Integer.parseInt(am.charAt(13)+"")]);
            sensor5LowerOP2.setText(lowerLevelText[Integer.parseInt(am.charAt(14)+"")]);
            
            am = (String) form3.elementAt(3); //probe error
            sensor1Error.setIcon( am.charAt(0) == '1' ? ON : OFF );
            sensor2Error.setIcon( am.charAt(1) == '1' ? ON : OFF );
            sensor2Error.setIcon( am.charAt(2) == '1' ? ON : OFF );
            sensor4Error.setIcon( am.charAt(3) == '1' ? ON : OFF );
            sensor5Error.setIcon( am.charAt(4) == '1' ? ON : OFF );
            
            sensor1Error1.setIcon( am.charAt(5) == '1' ? ON : OFF );
            sensor2Error1.setIcon( am.charAt(6) == '1' ? ON : OFF );
            sensor2Error1.setIcon( am.charAt(7) == '1' ? ON : OFF );
            sensor4Error1.setIcon( am.charAt(8) == '1' ? ON : OFF );
            sensor5Error1.setIcon( am.charAt(9) == '1' ? ON : OFF );
            
            sensor1Error2.setIcon( am.charAt(10) == '1' ? ON : OFF );
            sensor2Error2.setIcon( am.charAt(11) == '1' ? ON : OFF );
            sensor3Error2.setIcon( am.charAt(12) == '1' ? ON : OFF );
            sensor4Error2.setIcon( am.charAt(13) == '1' ? ON : OFF );
            sensor5Error2.setIcon( am.charAt(14) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(4); // AC
            acPower.setIcon( am.charAt(0) == '1' ? ON : OFF );
            acPower1.setIcon( am.charAt(1) == '1' ? ON : OFF );
            acPower2.setIcon( am.charAt(2) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(5); // battery
            battery.setIcon( am.charAt(0) == '1' ? ON : OFF );
            battery1.setIcon( am.charAt(1) == '1' ? ON : OFF );
            battery2.setIcon( am.charAt(2) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(6); // connection
            connection.setIcon( am.charAt(0) == '1' ? ON : OFF );
            connection1.setIcon( am.charAt(1) == '1' ? ON : OFF );
            connection2.setIcon( am.charAt(2) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(13); // connection
            memory.setIcon( am.charAt(0) == '1' ? ON : OFF );
            memory1.setIcon( am.charAt(1) == '1' ? ON : OFF );
            memory2.setIcon( am.charAt(2) == '1' ? ON : OFF );
            
            am = (String) form3.elementAt(7); // digital 1
            digital1Input.setIcon( am.charAt(0) > 0x30 ? ON : OFF );
            digital1Input1.setIcon( am.charAt(1) > 0x30 ? ON : OFF );
            digital1Input2.setIcon( am.charAt(2) > 0x30 ? ON : OFF );
            
            am = (String) form3.elementAt(8); // digital 2
            digital2Input.setIcon( am.charAt(0) > 0x30 ? ON : OFF );
            digital2Input1.setIcon( am.charAt(1) > 0x30 ? ON : OFF );
            digital2Input2.setIcon( am.charAt(2) > 0x30 ? ON : OFF );
            
            am = (String) form3.elementAt(7); // digital 1
            digital1InputTrig.setText(trigText[Integer.parseInt(am.charAt(0)+"")]);
            digital1InputTrig1.setText(trigText[Integer.parseInt(am.charAt(1)+"")]);
            digital1InputTrig2.setText(trigText[Integer.parseInt(am.charAt(2)+"")]);
            
            am = (String) form3.elementAt(8); // digital 2
            digital2InputTrig.setText(trigText[Integer.parseInt(am.charAt(0)+"")]);
            digital2InputTrig1.setText(trigText[Integer.parseInt(am.charAt(1)+"")]);
            digital2InputTrig2.setText(trigText[Integer.parseInt(am.charAt(2)+"")]);
            
            acPowerField.setText((String) form3.elementAt(9));
            connectionLostField.setText((String) form3.elementAt(10));
            batteryField.setText((String) form3.elementAt(11));
            memoryField.setText((String) form3.elementAt(12));
            
            am = (String) form3.elementAt(14); // digital input enable
            di1Enable.setIcon(am.charAt(0) == '1' ? ON : OFF);
            di2Enable.setIcon(am.charAt(1) == '1' ? ON : OFF);
            
            am = (String) form3.elementAt(15); // digital input delay
            di1Delay.setText("Delay : "+Integer.parseInt(am.substring(0,4),16)+" s.");
            di2Delay.setText("Delay : "+Integer.parseInt(am.substring(4,8),16)+" s.");
            
            am = (String) form3.elementAt(16); // normally output
            normally1.setIcon(am.charAt(0) == '1' ? ON : OFF);
            normally2.setIcon(am.charAt(0) == '1' ? ON : OFF);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        infoScroll = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        serialLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        typeField = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        serialField = new javax.swing.JLabel();
        groupField = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        probe1 = new javax.swing.JPanel();
        channelLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        dataField1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        probeField1 = new javax.swing.JLabel();
        probeTypeField1 = new javax.swing.JLabel();
        probe2 = new javax.swing.JPanel();
        channelLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        dataField2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        probeField2 = new javax.swing.JLabel();
        probeTypeField2 = new javax.swing.JLabel();
        probe3 = new javax.swing.JPanel();
        channelLabe3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        dataField3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        probeField3 = new javax.swing.JLabel();
        probeTypeField3 = new javax.swing.JLabel();
        probe4 = new javax.swing.JPanel();
        channelLabel4 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        dataField4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        probeField4 = new javax.swing.JLabel();
        probeTypeField4 = new javax.swing.JLabel();
        probe5 = new javax.swing.JPanel();
        channelLabe5 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        dataField5 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        probeField5 = new javax.swing.JLabel();
        probeTypeField5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        batteryBar = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        do1 = new javax.swing.JLabel();
        do2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        di1 = new javax.swing.JLabel();
        di2 = new javax.swing.JLabel();
        acIcon = new javax.swing.JLabel();
        currentStateLabel = new javax.swing.JLabel();
        operatingIcon = new javax.swing.JLabel();
        alarmDetectIcon = new javax.swing.JLabel();
        deviceEnableIcon = new javax.swing.JLabel();
        do3 = new javax.swing.JLabel();
        do4 = new javax.swing.JLabel();
        do5 = new javax.swing.JLabel();
        do6 = new javax.swing.JLabel();
        do7 = new javax.swing.JLabel();
        do8 = new javax.swing.JLabel();
        di3 = new javax.swing.JLabel();
        di4 = new javax.swing.JLabel();
        di5 = new javax.swing.JLabel();
        di6 = new javax.swing.JLabel();
        di7 = new javax.swing.JLabel();
        di8 = new javax.swing.JLabel();
        locationScroll = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        locationLabel = new javax.swing.JLabel();
        locationField = new javax.swing.JLabel();
        locationNameLabel = new javax.swing.JLabel();
        locationNameField = new javax.swing.JLabel();
        departField = new javax.swing.JLabel();
        locationDescriptionField = new javax.swing.JLabel();
        picPanel = new javax.swing.JPanel();
        picLabel = new javax.swing.JLabel();
        alarmScroll = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        alarmMethod0 = new javax.swing.JLabel();
        alarmMethod1 = new javax.swing.JLabel();
        alarmMethod2 = new javax.swing.JLabel();
        di1Enable = new javax.swing.JLabel();
        di2Enable = new javax.swing.JLabel();
        di1Delay = new javax.swing.JLabel();
        di2Delay = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        acPowerField = new javax.swing.JTextField();
        connectionLostField = new javax.swing.JTextField();
        batteryField = new javax.swing.JTextField();
        memoryField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        acMethod = new javax.swing.JLabel();
        connectionMethod = new javax.swing.JLabel();
        batteryMethod = new javax.swing.JLabel();
        memoryMethod = new javax.swing.JLabel();
        methodDetailsPanel = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        buzzerDetailScroll = new javax.swing.JScrollPane();
        buzzerDetailPanel = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        acPower = new javax.swing.JLabel();
        battery = new javax.swing.JLabel();
        memory = new javax.swing.JLabel();
        connection = new javax.swing.JLabel();
        digital1Input = new javax.swing.JLabel();
        digital2Input = new javax.swing.JLabel();
        digital1InputTrig = new javax.swing.JLabel();
        digital2InputTrig = new javax.swing.JLabel();
        maintenance = new javax.swing.JLabel();
        sensor1Panel = new javax.swing.JPanel();
        sensor1Label = new javax.swing.JLabel();
        sensor1UpperOP = new javax.swing.JLabel();
        sensor1LowerOP = new javax.swing.JLabel();
        sensor1Error = new javax.swing.JLabel();
        sensor2Panel = new javax.swing.JPanel();
        sensor2Label = new javax.swing.JLabel();
        sensor2UpperOP = new javax.swing.JLabel();
        sensor2LowerOP = new javax.swing.JLabel();
        sensor2Error = new javax.swing.JLabel();
        sensor3Panel = new javax.swing.JPanel();
        sensor3Label = new javax.swing.JLabel();
        sensor3UpperOP = new javax.swing.JLabel();
        sensor3LowerOP = new javax.swing.JLabel();
        sensor3Error = new javax.swing.JLabel();
        sensor4Panel = new javax.swing.JPanel();
        sensor4Label = new javax.swing.JLabel();
        sensor4UpperOP = new javax.swing.JLabel();
        sensor4LowerOP = new javax.swing.JLabel();
        sensor4Error = new javax.swing.JLabel();
        sensor5Panel = new javax.swing.JPanel();
        sensor5Label = new javax.swing.JLabel();
        sensor5UpperOP = new javax.swing.JLabel();
        sensor5LowerOP = new javax.swing.JLabel();
        sensor5Error = new javax.swing.JLabel();
        sensorHeaderPanel = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        buzzerDetailScroll1 = new javax.swing.JScrollPane();
        buzzerDetailPanel1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        acPower1 = new javax.swing.JLabel();
        battery1 = new javax.swing.JLabel();
        memory1 = new javax.swing.JLabel();
        connection1 = new javax.swing.JLabel();
        digital1Input1 = new javax.swing.JLabel();
        digital2Input1 = new javax.swing.JLabel();
        digital1InputTrig1 = new javax.swing.JLabel();
        digital2InputTrig1 = new javax.swing.JLabel();
        maintenance1 = new javax.swing.JLabel();
        sensor1Panel1 = new javax.swing.JPanel();
        sensor1Label1 = new javax.swing.JLabel();
        sensor1UpperOP1 = new javax.swing.JLabel();
        sensor1LowerOP1 = new javax.swing.JLabel();
        sensor1Error1 = new javax.swing.JLabel();
        sensor2Panel1 = new javax.swing.JPanel();
        sensor2Label1 = new javax.swing.JLabel();
        sensor2UpperOP1 = new javax.swing.JLabel();
        sensor2LowerOP1 = new javax.swing.JLabel();
        sensor2Error1 = new javax.swing.JLabel();
        sensor3Panel1 = new javax.swing.JPanel();
        sensor3Label1 = new javax.swing.JLabel();
        sensor3UpperOP1 = new javax.swing.JLabel();
        sensor3LowerOP1 = new javax.swing.JLabel();
        sensor3Error1 = new javax.swing.JLabel();
        sensor4Panel1 = new javax.swing.JPanel();
        sensor4Label1 = new javax.swing.JLabel();
        sensor4UpperOP1 = new javax.swing.JLabel();
        sensor4LowerOP1 = new javax.swing.JLabel();
        sensor4Error1 = new javax.swing.JLabel();
        sensor5Panel1 = new javax.swing.JPanel();
        sensor5Label1 = new javax.swing.JLabel();
        sensor5UpperOP1 = new javax.swing.JLabel();
        sensor5LowerOP1 = new javax.swing.JLabel();
        sensor5Error1 = new javax.swing.JLabel();
        sensorHeaderPanel1 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        normally1 = new javax.swing.JLabel();
        buzzerDetailScroll2 = new javax.swing.JScrollPane();
        buzzerDetailPanel2 = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        acPower2 = new javax.swing.JLabel();
        battery2 = new javax.swing.JLabel();
        memory2 = new javax.swing.JLabel();
        connection2 = new javax.swing.JLabel();
        digital1Input2 = new javax.swing.JLabel();
        digital2Input2 = new javax.swing.JLabel();
        digital1InputTrig2 = new javax.swing.JLabel();
        digital2InputTrig2 = new javax.swing.JLabel();
        maintenance2 = new javax.swing.JLabel();
        sensor1Panel2 = new javax.swing.JPanel();
        sensor1Label2 = new javax.swing.JLabel();
        sensor1UpperOP2 = new javax.swing.JLabel();
        sensor1LowerOP2 = new javax.swing.JLabel();
        sensor1Error2 = new javax.swing.JLabel();
        sensor2Panel2 = new javax.swing.JPanel();
        sensor2Label2 = new javax.swing.JLabel();
        sensor2UpperOP2 = new javax.swing.JLabel();
        sensor2LowerOP2 = new javax.swing.JLabel();
        sensor2Error2 = new javax.swing.JLabel();
        sensor3Panel2 = new javax.swing.JPanel();
        sensor3Label2 = new javax.swing.JLabel();
        sensor3UpperOP2 = new javax.swing.JLabel();
        sensor3LowerOP2 = new javax.swing.JLabel();
        sensor3Error2 = new javax.swing.JLabel();
        sensor4Panel2 = new javax.swing.JPanel();
        sensor4Label2 = new javax.swing.JLabel();
        sensor4UpperOP2 = new javax.swing.JLabel();
        sensor4LowerOP2 = new javax.swing.JLabel();
        sensor4Error2 = new javax.swing.JLabel();
        sensor5Panel2 = new javax.swing.JPanel();
        sensor5Label2 = new javax.swing.JLabel();
        sensor5UpperOP2 = new javax.swing.JLabel();
        sensor5LowerOP2 = new javax.swing.JLabel();
        sensor5Error2 = new javax.swing.JLabel();
        sensorHeaderPanel2 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        normally2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("General Info"));

        serialLabel.setText("Serial");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idLabel.setText("Device ID");

        typeLabel.setText("Type");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setText("Device Name");

        groupLabel.setText("Group");

        typeField.setForeground(new java.awt.Color(0, 153, 0));
        typeField.setText("-");

        idField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idField.setForeground(new java.awt.Color(0, 153, 0));
        idField.setText("-");

        nameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 153, 0));
        nameField.setText("-");

        serialField.setForeground(new java.awt.Color(0, 153, 0));
        serialField.setText("-");

        groupField.setForeground(new java.awt.Color(0, 153, 0));
        groupField.setText("-");

        ipLabel.setText("IP");

        ipField.setForeground(new java.awt.Color(0, 153, 0));
        ipField.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idField, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(serialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serialField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(typeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(typeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(groupLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(groupField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ipField, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(typeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(typeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serialLabel)
                    .addComponent(serialField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(groupLabel)
                    .addComponent(groupField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ipLabel)
                    .addComponent(ipField))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Probes"));

        probe1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        probe1.setLayout(new java.awt.BorderLayout());

        channelLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        channelLabel1.setText("  Channel 1 :   ");
        probe1.add(channelLabel1, java.awt.BorderLayout.LINE_START);

        jPanel9.setMaximumSize(new java.awt.Dimension(100, 34));
        jPanel9.setMinimumSize(new java.awt.Dimension(100, 34));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        dataField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataField1.setForeground(new java.awt.Color(0, 102, 0));
        dataField1.setText("-");
        jPanel9.add(dataField1);

        probe1.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel10.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel10.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel10.setLayout(new java.awt.GridLayout(0, 1));

        probeField1.setText("TEST PROBE 01");
        jPanel10.add(probeField1);

        probeTypeField1.setText("TMEC");
        jPanel10.add(probeTypeField1);

        probe1.add(jPanel10, java.awt.BorderLayout.LINE_END);

        probe2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        probe2.setLayout(new java.awt.BorderLayout());

        channelLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        channelLabel2.setText("  Channel 2 :   ");
        probe2.add(channelLabel2, java.awt.BorderLayout.LINE_START);

        jPanel11.setMaximumSize(new java.awt.Dimension(100, 34));
        jPanel11.setMinimumSize(new java.awt.Dimension(100, 34));
        jPanel11.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel11.setLayout(new java.awt.GridLayout(1, 0));

        dataField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataField2.setForeground(new java.awt.Color(0, 102, 0));
        dataField2.setText("-");
        jPanel11.add(dataField2);

        probe2.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel12.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel12.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel12.setLayout(new java.awt.GridLayout(0, 1));

        probeField2.setText("TEST PROBE 01");
        jPanel12.add(probeField2);

        probeTypeField2.setText("TMEC");
        jPanel12.add(probeTypeField2);

        probe2.add(jPanel12, java.awt.BorderLayout.LINE_END);

        probe3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        probe3.setLayout(new java.awt.BorderLayout());

        channelLabe3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        channelLabe3.setText("  Channel 3 :   ");
        probe3.add(channelLabe3, java.awt.BorderLayout.LINE_START);

        jPanel13.setMaximumSize(new java.awt.Dimension(100, 34));
        jPanel13.setMinimumSize(new java.awt.Dimension(100, 34));
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        dataField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataField3.setForeground(new java.awt.Color(0, 102, 0));
        dataField3.setText("-");
        jPanel13.add(dataField3);

        probe3.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel14.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel14.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel14.setLayout(new java.awt.GridLayout(0, 1));

        probeField3.setText("TEST PROBE 01");
        jPanel14.add(probeField3);

        probeTypeField3.setText("TMEC");
        jPanel14.add(probeTypeField3);

        probe3.add(jPanel14, java.awt.BorderLayout.LINE_END);

        probe4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        probe4.setLayout(new java.awt.BorderLayout());

        channelLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        channelLabel4.setText("  Channel 4 :   ");
        probe4.add(channelLabel4, java.awt.BorderLayout.LINE_START);

        jPanel15.setMaximumSize(new java.awt.Dimension(100, 34));
        jPanel15.setMinimumSize(new java.awt.Dimension(100, 34));
        jPanel15.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        dataField4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataField4.setForeground(new java.awt.Color(0, 102, 0));
        dataField4.setText("-");
        jPanel15.add(dataField4);

        probe4.add(jPanel15, java.awt.BorderLayout.CENTER);

        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel16.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel16.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel16.setLayout(new java.awt.GridLayout(0, 1));

        probeField4.setText("TEST PROBE 01");
        jPanel16.add(probeField4);

        probeTypeField4.setText("TMEC");
        jPanel16.add(probeTypeField4);

        probe4.add(jPanel16, java.awt.BorderLayout.LINE_END);

        probe5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 3));
        probe5.setLayout(new java.awt.BorderLayout());

        channelLabe5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        channelLabe5.setText("  Channel 5 :   ");
        probe5.add(channelLabe5, java.awt.BorderLayout.LINE_START);

        jPanel17.setMaximumSize(new java.awt.Dimension(100, 34));
        jPanel17.setMinimumSize(new java.awt.Dimension(100, 34));
        jPanel17.setPreferredSize(new java.awt.Dimension(100, 34));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        dataField5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dataField5.setForeground(new java.awt.Color(0, 102, 0));
        dataField5.setText("-");
        jPanel17.add(dataField5);

        probe5.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel18.setMinimumSize(new java.awt.Dimension(0, 34));
        jPanel18.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel18.setLayout(new java.awt.GridLayout(0, 1));

        probeField5.setText("TEST PROBE 01");
        jPanel18.add(probeField5);

        probeTypeField5.setText("TMEC");
        jPanel18.add(probeTypeField5);

        probe5.add(jPanel18, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(probe1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probe2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probe3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probe4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probe5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(probe1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probe2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probe3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probe4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probe5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Status"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Battery Power");

        batteryBar.setForeground(new java.awt.Color(51, 204, 0));
        batteryBar.setValue(80);
        batteryBar.setString("80% (Plugged in)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Digital Output ");

        do1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N

        do2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Digital Input");

        di1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N

        di2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N

        acIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/laptop_charge_32.png"))); // NOI18N
        acIcon.setBorder(javax.swing.BorderFactory.createTitledBorder("AC Power"));

        currentStateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        currentStateLabel.setText("Current State");
        currentStateLabel.setToolTipText("");

        operatingIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        operatingIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/realtime_32.png"))); // NOI18N
        operatingIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Operating", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        alarmDetectIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alarmDetectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/alarm_enable_32.png"))); // NOI18N
        alarmDetectIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarm Detect", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        deviceEnableIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deviceEnableIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/device_enable_32.png"))); // NOI18N
        deviceEnableIcon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dev. Enable", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0)));

        do3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do3.setEnabled(false);

        do4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do4.setEnabled(false);

        do5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do5.setEnabled(false);

        do6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do6.setEnabled(false);

        do7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do7.setEnabled(false);

        do8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        do8.setEnabled(false);

        di3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di3.setEnabled(false);

        di4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di4.setEnabled(false);

        di5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di5.setEnabled(false);

        di6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di6.setEnabled(false);

        di7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di7.setEnabled(false);

        di8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/lightbulb_off_24.png"))); // NOI18N
        di8.setEnabled(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(di8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(do8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(acIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(operatingIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alarmDetectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deviceEnableIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(batteryBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batteryBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(acIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(currentStateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(operatingIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alarmDetectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deviceEnableIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(do1))
                    .addComponent(do2)
                    .addComponent(do4)
                    .addComponent(do3)
                    .addComponent(do6)
                    .addComponent(do5)
                    .addComponent(do7)
                    .addComponent(do8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di5)
                            .addComponent(di6))
                        .addComponent(di7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(di8, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(di1)
                            .addComponent(di2))
                        .addComponent(di3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(di4, javax.swing.GroupLayout.Alignment.LEADING)))
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        infoScroll.setViewportView(jPanel1);

        jTabbedPane1.addTab("Device Info.", infoScroll);

        locationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationLabel.setText("Location ID : ");

        locationField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationField.setText("-");

        locationNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationNameLabel.setText("Location Name : ");

        locationNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        locationNameField.setText("-");

        departField.setText("-");

        locationDescriptionField.setText("-");

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Photo"));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picPanel.add(picLabel);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(locationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationField, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(locationNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(locationDescriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationLabel)
                    .addComponent(locationField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationNameLabel)
                    .addComponent(locationNameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(departField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationDescriptionField)
                .addGap(19, 19, 19)
                .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        locationScroll.setViewportView(jPanel4);

        jTabbedPane1.addTab("Location", locationScroll);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Method"));

        alarmMethod0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        alarmMethod0.setText("Buzzer");

        alarmMethod1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        alarmMethod1.setText("Digital Output 1");

        alarmMethod2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        alarmMethod2.setText("Digital Output 2");

        di1Enable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        di1Enable.setText("Digital Output 1");

        di2Enable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        di2Enable.setText("Digital Output 2");

        di1Delay.setText("Delay :");

        di2Delay.setText("Delay :");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alarmMethod0)
                    .addComponent(alarmMethod1)
                    .addComponent(alarmMethod2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(di1Enable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(di1Delay))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(di2Enable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(di2Delay)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(di1Enable)
                    .addComponent(di1Delay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(di2Enable)
                    .addComponent(di2Delay))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Threshold"));

        acPowerField.setEditable(false);
        acPowerField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        acPowerField.setText("0");

        connectionLostField.setEditable(false);
        connectionLostField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        connectionLostField.setText("0");

        batteryField.setEditable(false);
        batteryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        batteryField.setText("0");

        memoryField.setEditable(false);
        memoryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        memoryField.setText("0");

        jLabel12.setText("Seconds");

        jLabel15.setText("%");

        jLabel13.setText("Seconds");

        jLabel18.setText("%");

        acMethod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        acMethod.setText("AC power unplugged more than");

        connectionMethod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        connectionMethod.setText("Connection lost more than");

        batteryMethod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        batteryMethod.setText("Battery power lower than");

        memoryMethod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        memoryMethod.setText("Memory lower than");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acMethod)
                    .addComponent(connectionMethod)
                    .addComponent(batteryMethod)
                    .addComponent(memoryMethod))
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(acPowerField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(memoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(batteryField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(connectionLostField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acPowerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(acMethod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connectionLostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(connectionMethod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batteryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(batteryMethod))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memoryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(memoryMethod))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        methodDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Method Details"));
        methodDetailsPanel.setLayout(new java.awt.GridLayout(1, 0));

        acPower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        acPower.setText("AC Power");

        battery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        battery.setText("Battery");

        memory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        memory.setText("Memory");

        connection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        connection.setText("Connection");

        digital1Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital1Input.setText("Digital Input 1");

        digital2Input.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital2Input.setText("Digital Input 2");

        digital1InputTrig.setText("Trig : Falling edge");

        digital2InputTrig.setText("Trig : Falling edge");

        maintenance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        maintenance.setText("Maintenance");

        sensor1Panel.setLayout(new javax.swing.BoxLayout(sensor1Panel, javax.swing.BoxLayout.LINE_AXIS));

        sensor1Label.setText("Sensor 1");
        sensor1Label.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor1Label.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor1Label.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor1Panel.add(sensor1Label);
        sensor1Label.getAccessibleContext().setAccessibleName("");

        sensor1UpperOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1UpperOP.setText("No output");
        sensor1UpperOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel.add(sensor1UpperOP);
        sensor1UpperOP.getAccessibleContext().setAccessibleName("");

        sensor1LowerOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1LowerOP.setText("No output");
        sensor1LowerOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel.add(sensor1LowerOP);
        sensor1LowerOP.getAccessibleContext().setAccessibleName("");

        sensor1Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor1Error.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1Error.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1Error.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel.add(sensor1Error);

        sensor2Panel.setLayout(new javax.swing.BoxLayout(sensor2Panel, javax.swing.BoxLayout.LINE_AXIS));

        sensor2Label.setText("Sensor 2");
        sensor2Label.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor2Label.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor2Label.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor2Panel.add(sensor2Label);

        sensor2UpperOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2UpperOP.setText("No output");
        sensor2UpperOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel.add(sensor2UpperOP);

        sensor2LowerOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2LowerOP.setText("No output");
        sensor2LowerOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel.add(sensor2LowerOP);

        sensor2Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor2Error.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2Error.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2Error.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel.add(sensor2Error);

        sensor3Panel.setLayout(new javax.swing.BoxLayout(sensor3Panel, javax.swing.BoxLayout.LINE_AXIS));

        sensor3Label.setText("Sensor 3");
        sensor3Label.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor3Label.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor3Label.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor3Panel.add(sensor3Label);

        sensor3UpperOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3UpperOP.setText("No output");
        sensor3UpperOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel.add(sensor3UpperOP);

        sensor3LowerOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3LowerOP.setText("No output");
        sensor3LowerOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel.add(sensor3LowerOP);

        sensor3Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor3Error.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3Error.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3Error.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel.add(sensor3Error);

        sensor4Panel.setLayout(new javax.swing.BoxLayout(sensor4Panel, javax.swing.BoxLayout.LINE_AXIS));

        sensor4Label.setText("Sensor 4");
        sensor4Label.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor4Label.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor4Label.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor4Panel.add(sensor4Label);

        sensor4UpperOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4UpperOP.setText("No output");
        sensor4UpperOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel.add(sensor4UpperOP);

        sensor4LowerOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4LowerOP.setText("No output");
        sensor4LowerOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel.add(sensor4LowerOP);

        sensor4Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor4Error.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4Error.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4Error.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel.add(sensor4Error);

        sensor5Panel.setLayout(new javax.swing.BoxLayout(sensor5Panel, javax.swing.BoxLayout.LINE_AXIS));

        sensor5Label.setText("Sensor 5");
        sensor5Label.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor5Label.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor5Label.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor5Panel.add(sensor5Label);

        sensor5UpperOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5UpperOP.setText("No output");
        sensor5UpperOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel.add(sensor5UpperOP);

        sensor5LowerOP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5LowerOP.setText("No output");
        sensor5LowerOP.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel.add(sensor5LowerOP);

        sensor5Error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5Error.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor5Error.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5Error.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5Error.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel.add(sensor5Error);

        sensorHeaderPanel.setLayout(new javax.swing.BoxLayout(sensorHeaderPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel43.setMaximumSize(new java.awt.Dimension(60, 120));
        jLabel43.setMinimumSize(new java.awt.Dimension(60, 120));
        jLabel43.setPreferredSize(new java.awt.Dimension(60, 120));
        sensorHeaderPanel.add(jLabel43);

        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Upper Limit Output");
        jLabel44.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel44.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel44.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel.add(jLabel44);

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Lower Limit Output");
        jLabel45.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel45.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel45.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel.add(jLabel45);

        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Sensor Error Output");
        jLabel46.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel46.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel46.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel.add(jLabel46);

        javax.swing.GroupLayout buzzerDetailPanelLayout = new javax.swing.GroupLayout(buzzerDetailPanel);
        buzzerDetailPanel.setLayout(buzzerDetailPanelLayout);
        buzzerDetailPanelLayout.setHorizontalGroup(
            buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addComponent(sensor1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(sensor2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor3Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor4Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor5Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensorHeaderPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                        .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(connection, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(battery, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital2Input, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital2InputTrig))
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(memory, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                                .addComponent(acPower, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital1Input, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital1InputTrig)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanelLayout.setVerticalGroup(
            buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acPower)
                    .addComponent(digital1Input)
                    .addComponent(digital1InputTrig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery)
                    .addComponent(digital2Input)
                    .addComponent(digital2InputTrig))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memory)
                    .addComponent(maintenance))
                .addGap(11, 11, 11)
                .addComponent(connection)
                .addGap(21, 21, 21)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sensorHeaderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(sensor1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor3Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor4Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor5Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buzzerDetailScroll.setViewportView(buzzerDetailPanel);

        jTabbedPane2.addTab("Buzzer", buzzerDetailScroll);

        acPower1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        acPower1.setText("AC Power");

        battery1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        battery1.setText("Battery");

        memory1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        memory1.setText("Memory");

        connection1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        connection1.setText("Connection");

        digital1Input1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital1Input1.setText("Digital Input 1");

        digital2Input1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital2Input1.setText("Digital Input 2");

        digital1InputTrig1.setText("Trig : Falling edge");

        digital2InputTrig1.setText("Trig : Falling edge");

        maintenance1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        maintenance1.setText("Maintenance");

        sensor1Panel1.setLayout(new javax.swing.BoxLayout(sensor1Panel1, javax.swing.BoxLayout.LINE_AXIS));

        sensor1Label1.setText("Sensor 1");
        sensor1Label1.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor1Label1.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor1Label1.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor1Panel1.add(sensor1Label1);

        sensor1UpperOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1UpperOP1.setText("No output");
        sensor1UpperOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel1.add(sensor1UpperOP1);

        sensor1LowerOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1LowerOP1.setText("No output");
        sensor1LowerOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel1.add(sensor1LowerOP1);

        sensor1Error1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1Error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor1Error1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1Error1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1Error1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel1.add(sensor1Error1);

        sensor2Panel1.setLayout(new javax.swing.BoxLayout(sensor2Panel1, javax.swing.BoxLayout.LINE_AXIS));

        sensor2Label1.setText("Sensor 2");
        sensor2Label1.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor2Label1.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor2Label1.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor2Panel1.add(sensor2Label1);

        sensor2UpperOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2UpperOP1.setText("No output");
        sensor2UpperOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel1.add(sensor2UpperOP1);

        sensor2LowerOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2LowerOP1.setText("No output");
        sensor2LowerOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel1.add(sensor2LowerOP1);

        sensor2Error1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2Error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor2Error1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2Error1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2Error1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel1.add(sensor2Error1);

        sensor3Panel1.setLayout(new javax.swing.BoxLayout(sensor3Panel1, javax.swing.BoxLayout.LINE_AXIS));

        sensor3Label1.setText("Sensor 3");
        sensor3Label1.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor3Label1.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor3Label1.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor3Panel1.add(sensor3Label1);

        sensor3UpperOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3UpperOP1.setText("No output");
        sensor3UpperOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel1.add(sensor3UpperOP1);

        sensor3LowerOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3LowerOP1.setText("No output");
        sensor3LowerOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel1.add(sensor3LowerOP1);

        sensor3Error1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3Error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor3Error1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3Error1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3Error1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel1.add(sensor3Error1);

        sensor4Panel1.setLayout(new javax.swing.BoxLayout(sensor4Panel1, javax.swing.BoxLayout.LINE_AXIS));

        sensor4Label1.setText("Sensor 4");
        sensor4Label1.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor4Label1.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor4Label1.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor4Panel1.add(sensor4Label1);

        sensor4UpperOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4UpperOP1.setText("No output");
        sensor4UpperOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel1.add(sensor4UpperOP1);

        sensor4LowerOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4LowerOP1.setText("No output");
        sensor4LowerOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel1.add(sensor4LowerOP1);

        sensor4Error1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4Error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor4Error1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4Error1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4Error1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel1.add(sensor4Error1);

        sensor5Panel1.setLayout(new javax.swing.BoxLayout(sensor5Panel1, javax.swing.BoxLayout.LINE_AXIS));

        sensor5Label1.setText("Sensor 5");
        sensor5Label1.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor5Label1.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor5Label1.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor5Panel1.add(sensor5Label1);

        sensor5UpperOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5UpperOP1.setText("No output");
        sensor5UpperOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel1.add(sensor5UpperOP1);

        sensor5LowerOP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5LowerOP1.setText("No output");
        sensor5LowerOP1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel1.add(sensor5LowerOP1);

        sensor5Error1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5Error1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor5Error1.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5Error1.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5Error1.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel1.add(sensor5Error1);

        sensorHeaderPanel1.setLayout(new javax.swing.BoxLayout(sensorHeaderPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel47.setMaximumSize(new java.awt.Dimension(60, 120));
        jLabel47.setMinimumSize(new java.awt.Dimension(60, 120));
        jLabel47.setPreferredSize(new java.awt.Dimension(60, 120));
        sensorHeaderPanel1.add(jLabel47);

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Upper Limit Output");
        jLabel48.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel48.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel48.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel1.add(jLabel48);

        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Lower Limit Output");
        jLabel49.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel49.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel49.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel1.add(jLabel49);

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Sensor Error Output");
        jLabel50.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel50.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel50.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel1.add(jLabel50);

        normally1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        normally1.setText("Normally Open");

        javax.swing.GroupLayout buzzerDetailPanel1Layout = new javax.swing.GroupLayout(buzzerDetailPanel1);
        buzzerDetailPanel1.setLayout(buzzerDetailPanel1Layout);
        buzzerDetailPanel1Layout.setHorizontalGroup(
            buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5)
                    .addComponent(sensor1Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(sensor2Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor3Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor4Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor5Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensorHeaderPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(connection1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(normally1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(memory1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maintenance1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(battery1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital2Input1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital2InputTrig1))
                            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                                .addComponent(acPower1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital1Input1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital1InputTrig1)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanel1Layout.setVerticalGroup(
            buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acPower1)
                    .addComponent(digital1Input1)
                    .addComponent(digital1InputTrig1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery1)
                    .addComponent(digital2Input1)
                    .addComponent(digital2InputTrig1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memory1)
                    .addComponent(maintenance1))
                .addGap(11, 11, 11)
                .addGroup(buzzerDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connection1)
                    .addComponent(normally1))
                .addGap(21, 21, 21)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sensorHeaderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(sensor1Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor2Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor3Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor4Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor5Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buzzerDetailScroll1.setViewportView(buzzerDetailPanel1);

        jTabbedPane2.addTab("Digital Output 1", buzzerDetailScroll1);

        acPower2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        acPower2.setText("AC Power");

        battery2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        battery2.setText("Battery");

        memory2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        memory2.setText("Memory");

        connection2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        connection2.setText("Connection");

        digital1Input2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital1Input2.setText("Digital Input 1");

        digital2Input2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        digital2Input2.setText("Digital Input 2");

        digital1InputTrig2.setText("Trig : Falling edge");

        digital2InputTrig2.setText("Trig : Falling edge");

        maintenance2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        maintenance2.setText("Maintenance");

        sensor1Panel2.setLayout(new javax.swing.BoxLayout(sensor1Panel2, javax.swing.BoxLayout.LINE_AXIS));

        sensor1Label2.setText("Sensor 1");
        sensor1Label2.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor1Label2.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor1Label2.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor1Panel2.add(sensor1Label2);

        sensor1UpperOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1UpperOP2.setText("No output");
        sensor1UpperOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1UpperOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel2.add(sensor1UpperOP2);

        sensor1LowerOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1LowerOP2.setText("No output");
        sensor1LowerOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1LowerOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel2.add(sensor1LowerOP2);

        sensor1Error2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor1Error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor1Error2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor1Error2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor1Error2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor1Panel2.add(sensor1Error2);

        sensor2Panel2.setLayout(new javax.swing.BoxLayout(sensor2Panel2, javax.swing.BoxLayout.LINE_AXIS));

        sensor2Label2.setText("Sensor 2");
        sensor2Label2.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor2Label2.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor2Label2.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor2Panel2.add(sensor2Label2);

        sensor2UpperOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2UpperOP2.setText("No output");
        sensor2UpperOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2UpperOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel2.add(sensor2UpperOP2);

        sensor2LowerOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2LowerOP2.setText("No output");
        sensor2LowerOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2LowerOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel2.add(sensor2LowerOP2);

        sensor2Error2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor2Error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor2Error2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor2Error2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor2Error2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor2Panel2.add(sensor2Error2);

        sensor3Panel2.setLayout(new javax.swing.BoxLayout(sensor3Panel2, javax.swing.BoxLayout.LINE_AXIS));

        sensor3Label2.setText("Sensor 3");
        sensor3Label2.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor3Label2.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor3Label2.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor3Panel2.add(sensor3Label2);

        sensor3UpperOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3UpperOP2.setText("No output");
        sensor3UpperOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3UpperOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel2.add(sensor3UpperOP2);

        sensor3LowerOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3LowerOP2.setText("No output");
        sensor3LowerOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3LowerOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel2.add(sensor3LowerOP2);

        sensor3Error2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor3Error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor3Error2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor3Error2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor3Error2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor3Panel2.add(sensor3Error2);

        sensor4Panel2.setLayout(new javax.swing.BoxLayout(sensor4Panel2, javax.swing.BoxLayout.LINE_AXIS));

        sensor4Label2.setText("Sensor 4");
        sensor4Label2.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor4Label2.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor4Label2.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor4Panel2.add(sensor4Label2);

        sensor4UpperOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4UpperOP2.setText("No output");
        sensor4UpperOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4UpperOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel2.add(sensor4UpperOP2);

        sensor4LowerOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4LowerOP2.setText("No output");
        sensor4LowerOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4LowerOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel2.add(sensor4LowerOP2);

        sensor4Error2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor4Error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor4Error2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor4Error2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor4Error2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor4Panel2.add(sensor4Error2);

        sensor5Panel2.setLayout(new javax.swing.BoxLayout(sensor5Panel2, javax.swing.BoxLayout.LINE_AXIS));

        sensor5Label2.setText("Sensor 5");
        sensor5Label2.setMaximumSize(new java.awt.Dimension(60, 120));
        sensor5Label2.setMinimumSize(new java.awt.Dimension(60, 120));
        sensor5Label2.setPreferredSize(new java.awt.Dimension(60, 120));
        sensor5Panel2.add(sensor5Label2);

        sensor5UpperOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5UpperOP2.setText("No output");
        sensor5UpperOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5UpperOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel2.add(sensor5UpperOP2);

        sensor5LowerOP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5LowerOP2.setText("No output");
        sensor5LowerOP2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5LowerOP2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel2.add(sensor5LowerOP2);

        sensor5Error2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sensor5Error2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        sensor5Error2.setMaximumSize(new java.awt.Dimension(120, 120));
        sensor5Error2.setMinimumSize(new java.awt.Dimension(120, 120));
        sensor5Error2.setPreferredSize(new java.awt.Dimension(120, 120));
        sensor5Panel2.add(sensor5Error2);

        sensorHeaderPanel2.setLayout(new javax.swing.BoxLayout(sensorHeaderPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel51.setMaximumSize(new java.awt.Dimension(60, 120));
        jLabel51.setMinimumSize(new java.awt.Dimension(60, 120));
        jLabel51.setPreferredSize(new java.awt.Dimension(60, 120));
        sensorHeaderPanel2.add(jLabel51);

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Upper Limit Output");
        jLabel52.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel52.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel52.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel2.add(jLabel52);

        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Lower Limit Output");
        jLabel53.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel53.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel53.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel2.add(jLabel53);

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Sensor Error Output");
        jLabel54.setMaximumSize(new java.awt.Dimension(120, 120));
        jLabel54.setMinimumSize(new java.awt.Dimension(120, 120));
        jLabel54.setPreferredSize(new java.awt.Dimension(120, 120));
        sensorHeaderPanel2.add(jLabel54);

        normally2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/reject_16.png"))); // NOI18N
        normally2.setText("Normally Open");

        javax.swing.GroupLayout buzzerDetailPanel2Layout = new javax.swing.GroupLayout(buzzerDetailPanel2);
        buzzerDetailPanel2.setLayout(buzzerDetailPanel2Layout);
        buzzerDetailPanel2Layout.setHorizontalGroup(
            buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6)
                    .addComponent(sensor1Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                    .addComponent(sensor2Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor3Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor4Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensor5Panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sensorHeaderPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                        .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(connection2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(normally2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(memory2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maintenance2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(battery2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital2Input2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital2InputTrig2))
                            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                                .addComponent(acPower2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(digital1Input2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(digital1InputTrig2)))
                        .addGap(0, 300, Short.MAX_VALUE)))
                .addContainerGap())
        );
        buzzerDetailPanel2Layout.setVerticalGroup(
            buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buzzerDetailPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acPower2)
                    .addComponent(digital1Input2)
                    .addComponent(digital1InputTrig2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(battery2)
                    .addComponent(digital2Input2)
                    .addComponent(digital2InputTrig2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memory2)
                    .addComponent(maintenance2))
                .addGap(11, 11, 11)
                .addGroup(buzzerDetailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(connection2)
                    .addComponent(normally2))
                .addGap(21, 21, 21)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sensorHeaderPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(sensor1Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor2Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor3Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor4Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sensor5Panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        buzzerDetailScroll2.setViewportView(buzzerDetailPanel2);

        jTabbedPane2.addTab("Digital Output 2", buzzerDetailScroll2);

        methodDetailsPanel.add(jTabbedPane2);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(methodDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(methodDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        alarmScroll.setViewportView(jPanel5);

        jTabbedPane1.addTab("Alarm", alarmScroll);

        add(jTabbedPane1);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acIcon;
    private javax.swing.JLabel acMethod;
    private javax.swing.JLabel acPower;
    private javax.swing.JLabel acPower1;
    private javax.swing.JLabel acPower2;
    private javax.swing.JTextField acPowerField;
    private javax.swing.JLabel alarmDetectIcon;
    private javax.swing.JLabel alarmMethod0;
    private javax.swing.JLabel alarmMethod1;
    private javax.swing.JLabel alarmMethod2;
    private javax.swing.JScrollPane alarmScroll;
    private javax.swing.JLabel battery;
    private javax.swing.JLabel battery1;
    private javax.swing.JLabel battery2;
    private javax.swing.JProgressBar batteryBar;
    private javax.swing.JTextField batteryField;
    private javax.swing.JLabel batteryMethod;
    private javax.swing.JPanel buzzerDetailPanel;
    private javax.swing.JPanel buzzerDetailPanel1;
    private javax.swing.JPanel buzzerDetailPanel2;
    private javax.swing.JScrollPane buzzerDetailScroll;
    private javax.swing.JScrollPane buzzerDetailScroll1;
    private javax.swing.JScrollPane buzzerDetailScroll2;
    private javax.swing.JLabel channelLabe3;
    private javax.swing.JLabel channelLabe5;
    private javax.swing.JLabel channelLabel1;
    private javax.swing.JLabel channelLabel2;
    private javax.swing.JLabel channelLabel4;
    private javax.swing.JLabel connection;
    private javax.swing.JLabel connection1;
    private javax.swing.JLabel connection2;
    private javax.swing.JTextField connectionLostField;
    private javax.swing.JLabel connectionMethod;
    private javax.swing.JLabel currentStateLabel;
    private javax.swing.JLabel dataField1;
    private javax.swing.JLabel dataField2;
    private javax.swing.JLabel dataField3;
    private javax.swing.JLabel dataField4;
    private javax.swing.JLabel dataField5;
    private javax.swing.JLabel departField;
    private javax.swing.JLabel deviceEnableIcon;
    private javax.swing.JLabel di1;
    private javax.swing.JLabel di1Delay;
    private javax.swing.JLabel di1Enable;
    private javax.swing.JLabel di2;
    private javax.swing.JLabel di2Delay;
    private javax.swing.JLabel di2Enable;
    private javax.swing.JLabel di3;
    private javax.swing.JLabel di4;
    private javax.swing.JLabel di5;
    private javax.swing.JLabel di6;
    private javax.swing.JLabel di7;
    private javax.swing.JLabel di8;
    private javax.swing.JLabel digital1Input;
    private javax.swing.JLabel digital1Input1;
    private javax.swing.JLabel digital1Input2;
    private javax.swing.JLabel digital1InputTrig;
    private javax.swing.JLabel digital1InputTrig1;
    private javax.swing.JLabel digital1InputTrig2;
    private javax.swing.JLabel digital2Input;
    private javax.swing.JLabel digital2Input1;
    private javax.swing.JLabel digital2Input2;
    private javax.swing.JLabel digital2InputTrig;
    private javax.swing.JLabel digital2InputTrig1;
    private javax.swing.JLabel digital2InputTrig2;
    private javax.swing.JLabel do1;
    private javax.swing.JLabel do2;
    private javax.swing.JLabel do3;
    private javax.swing.JLabel do4;
    private javax.swing.JLabel do5;
    private javax.swing.JLabel do6;
    private javax.swing.JLabel do7;
    private javax.swing.JLabel do8;
    private javax.swing.JLabel groupField;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JScrollPane infoScroll;
    private javax.swing.JLabel ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel locationDescriptionField;
    private javax.swing.JLabel locationField;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel locationNameField;
    private javax.swing.JLabel locationNameLabel;
    private javax.swing.JScrollPane locationScroll;
    private javax.swing.JLabel maintenance;
    private javax.swing.JLabel maintenance1;
    private javax.swing.JLabel maintenance2;
    private javax.swing.JLabel memory;
    private javax.swing.JLabel memory1;
    private javax.swing.JLabel memory2;
    private javax.swing.JTextField memoryField;
    private javax.swing.JLabel memoryMethod;
    private javax.swing.JPanel methodDetailsPanel;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel normally1;
    private javax.swing.JLabel normally2;
    private javax.swing.JLabel operatingIcon;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    private javax.swing.JPanel probe1;
    private javax.swing.JPanel probe2;
    private javax.swing.JPanel probe3;
    private javax.swing.JPanel probe4;
    private javax.swing.JPanel probe5;
    private javax.swing.JLabel probeField1;
    private javax.swing.JLabel probeField2;
    private javax.swing.JLabel probeField3;
    private javax.swing.JLabel probeField4;
    private javax.swing.JLabel probeField5;
    private javax.swing.JLabel probeTypeField1;
    private javax.swing.JLabel probeTypeField2;
    private javax.swing.JLabel probeTypeField3;
    private javax.swing.JLabel probeTypeField4;
    private javax.swing.JLabel probeTypeField5;
    private javax.swing.JLabel sensor1Error;
    private javax.swing.JLabel sensor1Error1;
    private javax.swing.JLabel sensor1Error2;
    private javax.swing.JLabel sensor1Label;
    private javax.swing.JLabel sensor1Label1;
    private javax.swing.JLabel sensor1Label2;
    private javax.swing.JLabel sensor1LowerOP;
    private javax.swing.JLabel sensor1LowerOP1;
    private javax.swing.JLabel sensor1LowerOP2;
    private javax.swing.JPanel sensor1Panel;
    private javax.swing.JPanel sensor1Panel1;
    private javax.swing.JPanel sensor1Panel2;
    private javax.swing.JLabel sensor1UpperOP;
    private javax.swing.JLabel sensor1UpperOP1;
    private javax.swing.JLabel sensor1UpperOP2;
    private javax.swing.JLabel sensor2Error;
    private javax.swing.JLabel sensor2Error1;
    private javax.swing.JLabel sensor2Error2;
    private javax.swing.JLabel sensor2Label;
    private javax.swing.JLabel sensor2Label1;
    private javax.swing.JLabel sensor2Label2;
    private javax.swing.JLabel sensor2LowerOP;
    private javax.swing.JLabel sensor2LowerOP1;
    private javax.swing.JLabel sensor2LowerOP2;
    private javax.swing.JPanel sensor2Panel;
    private javax.swing.JPanel sensor2Panel1;
    private javax.swing.JPanel sensor2Panel2;
    private javax.swing.JLabel sensor2UpperOP;
    private javax.swing.JLabel sensor2UpperOP1;
    private javax.swing.JLabel sensor2UpperOP2;
    private javax.swing.JLabel sensor3Error;
    private javax.swing.JLabel sensor3Error1;
    private javax.swing.JLabel sensor3Error2;
    private javax.swing.JLabel sensor3Label;
    private javax.swing.JLabel sensor3Label1;
    private javax.swing.JLabel sensor3Label2;
    private javax.swing.JLabel sensor3LowerOP;
    private javax.swing.JLabel sensor3LowerOP1;
    private javax.swing.JLabel sensor3LowerOP2;
    private javax.swing.JPanel sensor3Panel;
    private javax.swing.JPanel sensor3Panel1;
    private javax.swing.JPanel sensor3Panel2;
    private javax.swing.JLabel sensor3UpperOP;
    private javax.swing.JLabel sensor3UpperOP1;
    private javax.swing.JLabel sensor3UpperOP2;
    private javax.swing.JLabel sensor4Error;
    private javax.swing.JLabel sensor4Error1;
    private javax.swing.JLabel sensor4Error2;
    private javax.swing.JLabel sensor4Label;
    private javax.swing.JLabel sensor4Label1;
    private javax.swing.JLabel sensor4Label2;
    private javax.swing.JLabel sensor4LowerOP;
    private javax.swing.JLabel sensor4LowerOP1;
    private javax.swing.JLabel sensor4LowerOP2;
    private javax.swing.JPanel sensor4Panel;
    private javax.swing.JPanel sensor4Panel1;
    private javax.swing.JPanel sensor4Panel2;
    private javax.swing.JLabel sensor4UpperOP;
    private javax.swing.JLabel sensor4UpperOP1;
    private javax.swing.JLabel sensor4UpperOP2;
    private javax.swing.JLabel sensor5Error;
    private javax.swing.JLabel sensor5Error1;
    private javax.swing.JLabel sensor5Error2;
    private javax.swing.JLabel sensor5Label;
    private javax.swing.JLabel sensor5Label1;
    private javax.swing.JLabel sensor5Label2;
    private javax.swing.JLabel sensor5LowerOP;
    private javax.swing.JLabel sensor5LowerOP1;
    private javax.swing.JLabel sensor5LowerOP2;
    private javax.swing.JPanel sensor5Panel;
    private javax.swing.JPanel sensor5Panel1;
    private javax.swing.JPanel sensor5Panel2;
    private javax.swing.JLabel sensor5UpperOP;
    private javax.swing.JLabel sensor5UpperOP1;
    private javax.swing.JLabel sensor5UpperOP2;
    private javax.swing.JPanel sensorHeaderPanel;
    private javax.swing.JPanel sensorHeaderPanel1;
    private javax.swing.JPanel sensorHeaderPanel2;
    private javax.swing.JLabel serialField;
    private javax.swing.JLabel serialLabel;
    private javax.swing.JLabel typeField;
    private javax.swing.JLabel typeLabel;
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
                FullFrame FPD = new FullFrame(DLP.DMIF.MF.SD.urlImgPath+"/image/location/"+locationField.getText()+".jpg");
            }
        }
    }

}
