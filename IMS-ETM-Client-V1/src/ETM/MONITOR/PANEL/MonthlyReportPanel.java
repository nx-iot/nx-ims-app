/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MonthlyReportPanel.java
 *
 * Created on Feb 10, 2012, 2:44:34 PM
 */

package ETM.MONITOR.PANEL;

import ETM.MONITOR.MonitorIF;
import ETM.Util.HydeFormat;
import HydeModule.Table.HydeDataSet;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

public class MonthlyReportPanel extends javax.swing.JPanel implements ActionListener
{
    public MonitorIF MIF;
    private DecimalFormat DF = new DecimalFormat("#00");
    public SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String defaultDepartmentComboBox = "Select a department...";
    public static String defaultDeviceGroupComboBox = "Select a group...";

    public int month = 1;
    public int year = 2000;

    public int gapMonth = 2;
    public String any = "1111";

    public MonthlyReportPanel(MonitorIF MIF)
    {
        this.MIF = MIF;
        initComponents();
        extendComponents();
        actionComponents();
    }
    
    private void extendComponents()
    {

        yearComboBox.removeAllItems();
        for (int i=1970;i<=2100;i++)
        {
            yearComboBox.addItem(i+"");
        }
        Date d = new Date();
        yearComboBox.setSelectedItem((d.getYear()+1900)+"");

        year = Integer.parseInt( (String)yearComboBox.getSelectedItem());

        setDepartmentComboBox();
        chartToggleButton.doClick();
    }

    private void actionComponents()
    {
        janToggleButton.addActionListener(this);
        febToggleButton.addActionListener(this);
        marToggleButton.addActionListener(this);
        aprToggleButton.addActionListener(this);
        mayToggleButton.addActionListener(this);
        junToggleButton.addActionListener(this);
        julToggleButton.addActionListener(this);
        augToggleButton.addActionListener(this);
        sepToggleButton.addActionListener(this);
        octToggleButton.addActionListener(this);
        novToggleButton.addActionListener(this);
        decToggleButton.addActionListener(this);

        chartToggleButton.addActionListener(this);
        sumToggleButton.addActionListener(this);

        yearComboBox.addActionListener(this);
        departmentComboBox.addActionListener(this);
        deviceGroupComboBox.addActionListener(this);
        //mostAlarmButton.addActionListener(this);
    }

    private void setDepartmentComboBox()
    {
        Enumeration enu;
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem("All");
            enu = MIF.MF.HDC.queryColumn("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department;").elements();
            while (enu.hasMoreElements())
            {
                departmentComboBox.addItem(enu.nextElement());
            }
        }
        else
        {
            departmentComboBox.addItem(MIF.MF.HDC.query0("SELECT CONCAT(depart_name,' (',depart_id+0,')') FROM department WHERE depart_id = '"+MIF.MF.SD.loginDepartment+"';"));
        }
    }

    private void setDeviceGroupComboBox()
    {
        Enumeration enu;
        if (departmentComboBox.getSelectedItem() != null)
        {
            String department = (String) departmentComboBox.getSelectedItem();
            if (department.equals("All"))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = MIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group;").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else if (!department.equals(defaultDepartmentComboBox))
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
                deviceGroupComboBox.addItem("All");
                enu = MIF.MF.HDC.queryColumn("SELECT CONCAT(device_group_name,' (',device_group_id+0,')') FROM device_group WHERE depart_id = '"+HydeFormat.parseID(department)+"';").elements();
                while (enu.hasMoreElements())
                {
                    deviceGroupComboBox.addItem(enu.nextElement());
                }
                deviceGroupComboBox.addItem("No group...");
            }
            else
            {
                deviceGroupComboBox.removeAllItems();
                deviceGroupComboBox.addItem(defaultDeviceGroupComboBox);
            }
        }
    }

    private String[] alarmCount;
    public void setDataSummary()
    {
        String depart = (String) departmentComboBox.getSelectedItem();
        String group = (String) deviceGroupComboBox.getSelectedItem();

        String groupFilter = "(FALSE";
        if (depart.equals("All"))
        {
            if (group.equals("All"))
            {
                groupFilter = "(TRUE";
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
            else
            {

            }
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            if (group.equals("All"))
            {
                depart = HydeFormat.parseID(depart);
                //groupFilter += " depart_id = '"+depart+"' ";
                Vector g = MIF.MF.HDC.queryColumn("SELECT device_group_id FROM device_group WHERE depart_id = '"+depart+"';");
                if (g != null)
                {
                    Enumeration enu = g.elements();
                    while (enu.hasMoreElements())
                    {
                        String gid = (String)enu.nextElement();
                        groupFilter += " OR device_group_id = '"+gid+"' ";
                    }
                }
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
        }
        groupFilter += ") AND ";
        String selected = "(";
        /*if (userFixCheckBox.isSelected())
        {
            selected += "user_fix = '1' AND ";
        }
        if (systemFixCheckBox.isSelected())
        {
            selected += "system_fix = '1' AND ";
        }*/
        selected += "TRUE) AND ";
        int monthIndex = this.month;
        int yearIndex = year;
        int emonthIndex = monthIndex+1;
        int eyearIndex = yearIndex;
        if (emonthIndex > 12)
        {
            emonthIndex = emonthIndex-12;
            eyearIndex++;
        }
        String from = yearIndex+"-"+DF.format(monthIndex)+"-00";
        String to = eyearIndex+"-"+DF.format(emonthIndex)+"-00";
        String between = " (alarm_timestamp BETWEEN '"+from+"' AND '"+to+"')";
        //System.out.println(from + " ~ "+to);
        Vector v = MIF.MF.HDC.queryRow("SELECT DISTINCT "
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=9001), " //0 Maintenenace
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=1001), " //1 POOR
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=1002), " //2 LOST
                //+"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=1003), "
                //+"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=1004), "

                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=2001), " //3 Main Power Lost
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=2002), " //4 Low Battery
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=2003), " //5 Low Memory
                //+"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=2004), "

                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3001), " //6 Upper
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3002), " //7
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3003), " //8
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3101), " //9 Lower
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3102), " //10
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3103), " //11
                
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3200),  " //12 Probe Error (Other)
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3201),  " //13 Probe Error (Upper bound)
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3202),  " //14 Probe Error (Lower bound)
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3203),  " //15 Probe Error (Disconnect)
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=3204),  " //16 Probe Error (Short)
                
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=4001),  " //17 GSM Low Signal
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=4002),  " //18 GSM Date Expired
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=4003),  " //19 GSM No Operator
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=4004),  " //20 GSM Top Up
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=4005),  " //21 GSM Low Credit
                
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=5001),  " //22 Analog Lower
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=5002),  " //23 Analog Upper
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=5101),  " //24 Digital Falling
                +"(SELECT COUNT(alarm_id) FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device WHERE "+groupFilter+selected+between+" AND error_code=5102)  " //25 Digital Rising
                +"FROM "+MIF.MF.HDC.database+"_log.alarm_log;");
        if (v != null)
        {
            mtLabel.setText((String)v.elementAt(0) + " of Poor Connection");
            poorLabel.setText((String)v.elementAt(1) + " of Poor Connection");
            lostLabel.setText((String)v.elementAt(2) + " of Lost Connection");

            mainPowerLostLabel.setText((String)v.elementAt(3) + " of Main Power Lost");
            lowBatteryLabel.setText((String)v.elementAt(4) + " of Low Battery");
            lowMemoryLabel.setText((String)v.elementAt(5) + " of Low Memory");

            upperLabel.setText((String)v.elementAt(6) + " of Upper");
            upperTimeLabel.setText((String)v.elementAt(7) + " of Upper Time");
            upperExtremeLabel.setText((String)v.elementAt(8) + " of Upper Extreme");
            lowerLabel.setText((String)v.elementAt(9) + " of Lower");
            lowerTimeLabel.setText((String)v.elementAt(10) + " of Lower Time");
            lowerExtremeLabel.setText((String)v.elementAt(11) + " of Lower Extreme");

            probeOtherLabel.setText((String)v.elementAt(12) + " of Probe Error");
            probeUpperLabel.setText((String)v.elementAt(13) + " of Probe Error (Upper bound)");
            probeLowerLabel.setText((String)v.elementAt(14) + " of Probe Error (Lower bound)");
            probeDisconnectLabel.setText((String)v.elementAt(15) + " of Probe Error (Disconnect)");
            probeShortLabel.setText((String)v.elementAt(16) + " of Probe Error (Short)");
            
            gsmLowSignalLabel.setText((String)v.elementAt(17) + " of GSM Low Signal");
            lowCreditLabel.setText((String)v.elementAt(21) + " of GSM Low Credt Balance");
            gsmDateLabel.setText((String)v.elementAt(18) + " of GSM Date Expired");
            
            
            if (!v.elementAt(1).equals("0")) poorLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(2).equals("0")) lostLabel.setForeground(new Color(200,0,0));

            if (!v.elementAt(3).equals("0")) mainPowerLostLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(4).equals("0")) lowBatteryLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(5).equals("0")) lowMemoryLabel.setForeground(new Color(200,0,0));
            
            if (!v.elementAt(6).equals("0")) upperLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(7).equals("0")) upperTimeLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(8).equals("0")) upperExtremeLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(9).equals("0")) lowerLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(10).equals("0")) lowerTimeLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(11).equals("0")) lowerExtremeLabel.setForeground(new Color(200,0,0));

            if (!v.elementAt(12).equals("0")) probeOtherLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(13).equals("0")) probeUpperLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(14).equals("0")) probeLowerLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(15).equals("0")) probeDisconnectLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(16).equals("0")) probeShortLabel.setForeground(new Color(200,0,0));
            
            if (!v.elementAt(17).equals("0")) gsmLowSignalLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(21).equals("0")) lowCreditLabel.setForeground(new Color(200,0,0));
            if (!v.elementAt(18).equals("0")) gsmDateLabel.setForeground(new Color(200,0,0));
        }

        Vector mostAlarm = MIF.MF.HDC.queryRow("SELECT "
                + "device_name, COUNT(device_id) "
                + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device "
                + "WHERE "+groupFilter+selected+between+" "
                + "GROUP BY device_id ORDER BY COUNT(device_id) DESC;");

        if (mostAlarm != null && mostAlarm.size() >= 2)
        {
            mostAlarmButton.setText(mostAlarm.elementAt(0)+" ("+mostAlarm.elementAt(1)+" times)");
        }
        else
        {
            mostAlarmButton.setText("-");
        }

        /*Vector v2 = MIF.MF.HDC.queryRow("SELECT DISTINCT "
                +"(SELECT COUNT(device_id) FROM device WHERE "+groupFilter+selected+" equipment_id=1), "
                +"(SELECT COUNT(device_id) FROM device WHERE "+groupFilter+selected+" equipment_id=2), "
                +"(SELECT COUNT(device_id) FROM device WHERE "+groupFilter+selected+" equipment_id=3) "
                +"FROM device;");
        if (v2 != null)
        {
            baseField.setText((String)v2.elementAt(0));
            repeaterField.setText((String)v2.elementAt(1));
            transmitterField.setText((String)v2.elementAt(2));
        }*/
    }

    public void setDataGraph()
    {
        String depart = (String) departmentComboBox.getSelectedItem();
        String group = (String) deviceGroupComboBox.getSelectedItem();

        String groupFilter = "(FALSE";
        if (depart.equals("All"))
        {
            if (group.equals("All"))
            {
                groupFilter = "(TRUE";
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
            else
            {

            }
        }
        else if (!depart.equals(defaultDepartmentComboBox))
        {
            if (group.equals("All"))
            {
                depart = HydeFormat.parseID(depart);
                //groupFilter += " depart_id = '"+depart+"' ";
                Vector g = MIF.MF.HDC.queryColumn("SELECT device_group_id FROM device_group WHERE depart_id = '"+depart+"';");
                if (g != null)
                {
                    Enumeration enu = g.elements();
                    while (enu.hasMoreElements())
                    {
                        String gid = (String)enu.nextElement();
                        groupFilter += " OR device_group_id = '"+gid+"' ";
                    }
                }
            }
            else if (group.equals("No Group..."))
            {
                groupFilter += " OR device_group_id = IS NULL ";
            }
            else if (!group.equals(defaultDeviceGroupComboBox))
            {
                group = HydeFormat.parseID(group);
                groupFilter += " OR device_group_id = '"+group+"' ";
            }
        }
        groupFilter += ") AND ";
        String selected = "(";
        /*if (userFixCheckBox.isSelected())
        {
            selected += "user_fix = '1' AND ";
        }
        if (systemFixCheckBox.isSelected())
        {
            selected += "system_fix = '1' AND ";
        }*/
        selected += "TRUE) AND ";

        int gMonth = (gapMonth*2)+1;
        //Vector data[] = new Vector[gMonth];
        int data[][] = new int[gMonth][];
        for (int i=0;i<gMonth;i++)
        {
            data[i] = new int[4];
        }

        int selectedMonth = month;
        int selectedYear = year;
        int vindex = 0;

        if (chartToggleButton.isSelected())
        {
            for (int i = selectedMonth; i<gMonth+selectedMonth;i++)
            {
                int monthIndex = i-gapMonth;
                int yearIndex = year;
                if (monthIndex < 1)
                {
                    monthIndex = 12+monthIndex;
                    yearIndex--;
                }
                else if (monthIndex > 12)
                {
                    monthIndex = monthIndex-12;
                    yearIndex++;
                }

                int emonthIndex = monthIndex+1;
                int eyearIndex = yearIndex;
                if (emonthIndex > 12)
                {
                    emonthIndex = emonthIndex-12;
                    eyearIndex++;
                }

                String from = yearIndex+"-"+DF.format(monthIndex)+"-00";
                String to = eyearIndex+"-"+DF.format(emonthIndex)+"-00";
                String between = " (alarm_timestamp BETWEEN '"+from+"' AND '"+to+"')";
                //System.out.println(from + " ~ "+to);
                data[vindex][0] = Integer.parseInt(MIF.MF.HDC.query0("SELECT COUNT(alarm_id) "
                        + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device "
                        + "WHERE "+groupFilter+selected+between+" "
                        + ";"));
                data[vindex][1] = Integer.parseInt(MIF.MF.HDC.query0("SELECT COUNT(alarm_id) "
                        + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                        + "WHERE "+groupFilter+selected+between+" AND error_type = 'Event' "
                        + ";"));
                data[vindex][2] = Integer.parseInt(MIF.MF.HDC.query0("SELECT COUNT(alarm_id) "
                        + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                        + "WHERE "+groupFilter+selected+between+" AND error_type = 'Alert' "
                        + ";"));
                data[vindex][3] = Integer.parseInt(MIF.MF.HDC.query0("SELECT COUNT(alarm_id) "
                        + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN error NATURAL JOIN device "
                        + "WHERE "+groupFilter+selected+between+" AND error_type = 'Warning' "
                        + ";"));
                vindex++;
            }

            statPanel.removeAll();
            AlarmGraphEffectPanel AGP = new AlarmGraphEffectPanel(this,month,year,data);
            statPanel.add(AGP);
            statPanel.validate();
        }
        else if (sumToggleButton.isSelected())
        {
            int monthIndex = selectedMonth;
            int yearIndex = selectedYear;
            
            int emonthIndex = monthIndex+1;
            int eyearIndex = yearIndex;
            if (emonthIndex > 12)
            {
                emonthIndex = emonthIndex-12;
                eyearIndex++;
            }
            
            String from = yearIndex+"-"+DF.format(monthIndex)+"-00";
            String to = eyearIndex+"-"+DF.format(emonthIndex)+"-00";
            String between = " (alarm_timestamp BETWEEN '"+from+"' AND '"+to+"')";
            Vector v = MIF.MF.HDC.queryAll("SELECT "
                    + "error_name AS 'Alarm', "
                    + "device_name AS 'Device', "
                    + "alarm_timestamp AS 'Start', "
                    + "system_timestamp AS 'System Ack', "
                    + "user_timestamp AS 'User Ack' "
                   // + "TIMEDIFF(system_timestamp,alarm_timestamp) AS 'Alarm Length' "
                    + "FROM "+MIF.MF.HDC.database+"_log.alarm_log NATURAL JOIN device NATURAL JOIN error "
                    + "WHERE "+groupFilter+selected+between+" "
                    + ";");
            if (v != null)
            {
                statPanel.removeAll();
                HydeDataSet HDS = new HydeDataSet(v);
                Vector vv = HDS.getRowVector();
                Vector cv = HDS.getColumnVector();
                cv.add("Alarm Length");
                Enumeration enu = vv.elements();
                while (enu.hasMoreElements())
                {
                    Vector timeInRow = (Vector) enu.nextElement();
                    String s1 = (String) timeInRow.elementAt(2);
                    String s2 = (String) timeInRow.elementAt(3);
                    Date d1,d2;
                    long ds;
                    try
                    {
                        d1 = SDF.parse(s1);
                        d2 = SDF.parse(s2);
                        ds = (d2.getTime()-d1.getTime())/1000;
                        long day = ds/86400;
                        long hour = (ds%86400)/3600;
                        long min = ((ds%86400)%3600)/60;
                        long sec = ((ds%86400)%3600)%60;
                        timeInRow.add(day+"d "+DF.format(hour)+"h "+DF.format(min)+"m "+DF.format(sec)+"s");
                    }
                    catch (Exception e)
                    {

                    }
                }
                statPanel.removeAll();
                statPanel.add(new AlarmTimeTablePanel(HDS));
                statPanel.repaint();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monthButtonGroup = new javax.swing.ButtonGroup();
        functionButtonGroup = new javax.swing.ButtonGroup();
        yearComboBox = new javax.swing.JComboBox();
        statPanel = new javax.swing.JPanel();
        groupPanel = new javax.swing.JPanel();
        deviceGroupComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        exportPanel = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        refreshButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        dummy2 = new javax.swing.JButton();
        chartToggleButton = new javax.swing.JToggleButton();
        dummy1 = new javax.swing.JButton();
        sumToggleButton = new javax.swing.JToggleButton();
        monthToolBar = new javax.swing.JToolBar();
        janToggleButton = new javax.swing.JToggleButton();
        febToggleButton = new javax.swing.JToggleButton();
        marToggleButton = new javax.swing.JToggleButton();
        aprToggleButton = new javax.swing.JToggleButton();
        mayToggleButton = new javax.swing.JToggleButton();
        junToggleButton = new javax.swing.JToggleButton();
        julToggleButton = new javax.swing.JToggleButton();
        augToggleButton = new javax.swing.JToggleButton();
        sepToggleButton = new javax.swing.JToggleButton();
        octToggleButton = new javax.swing.JToggleButton();
        novToggleButton = new javax.swing.JToggleButton();
        decToggleButton = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sumTabbedPane = new javax.swing.JTabbedPane();
        eventScroll = new javax.swing.JScrollPane();
        eventPanel = new javax.swing.JPanel();
        poorLabel = new javax.swing.JLabel();
        lostLabel = new javax.swing.JLabel();
        gsmLowSignalLabel = new javax.swing.JLabel();
        mtLabel = new javax.swing.JLabel();
        lowCreditLabel = new javax.swing.JLabel();
        gsmDateLabel = new javax.swing.JLabel();
        alertScroll = new javax.swing.JScrollPane();
        alertPanel = new javax.swing.JPanel();
        mainPowerLostLabel = new javax.swing.JLabel();
        lowBatteryLabel = new javax.swing.JLabel();
        lowMemoryLabel = new javax.swing.JLabel();
        probeUpperLabel = new javax.swing.JLabel();
        probeLowerLabel = new javax.swing.JLabel();
        probeDisconnectLabel = new javax.swing.JLabel();
        probeShortLabel = new javax.swing.JLabel();
        probeOtherLabel = new javax.swing.JLabel();
        warningScroll = new javax.swing.JScrollPane();
        warningPanel = new javax.swing.JPanel();
        upperLabel = new javax.swing.JLabel();
        upperTimeLabel = new javax.swing.JLabel();
        upperExtremeLabel = new javax.swing.JLabel();
        lowerLabel = new javax.swing.JLabel();
        lowerTimeLabel = new javax.swing.JLabel();
        lowerExtremeLabel = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        mostAlarmButton = new javax.swing.JButton();

        yearComboBox.setMaximumSize(new java.awt.Dimension(70, 18));
        yearComboBox.setMinimumSize(new java.awt.Dimension(70, 18));
        yearComboBox.setPreferredSize(new java.awt.Dimension(70, 18));

        statPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        statPanel.setLayout(new java.awt.GridLayout(0, 1));

        groupPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        deviceGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a group..." }));

        jLabel3.setText("Device Group");

        jLabel4.setText("Department");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));

        javax.swing.GroupLayout groupPanelLayout = new javax.swing.GroupLayout(groupPanel);
        groupPanel.setLayout(groupPanelLayout);
        groupPanelLayout.setHorizontalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createSequentialGroup()
                .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(groupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(departmentComboBox, 0, 227, Short.MAX_VALUE))
                    .addGroup(groupPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deviceGroupComboBox, 0, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );
        groupPanelLayout.setVerticalGroup(
            groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupPanelLayout.createSequentialGroup()
                .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(groupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(deviceGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        exportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        exportPanel.setLayout(new javax.swing.BoxLayout(exportPanel, javax.swing.BoxLayout.LINE_AXIS));

        jToolBar2.setFloatable(false);
        jToolBar2.setMaximumSize(new java.awt.Dimension(300, 40));
        jToolBar2.setMinimumSize(new java.awt.Dimension(300, 40));
        jToolBar2.setPreferredSize(new java.awt.Dimension(300, 40));

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/refresh_16.png"))); // NOI18N
        refreshButton.setText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        refreshButton.setMaximumSize(new java.awt.Dimension(60, 40));
        refreshButton.setMinimumSize(new java.awt.Dimension(60, 40));
        refreshButton.setPreferredSize(new java.awt.Dimension(60, 40));
        refreshButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(refreshButton);
        jToolBar2.add(jSeparator1);

        dummy2.setEnabled(false);
        dummy2.setFocusable(false);
        dummy2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dummy2.setMaximumSize(new java.awt.Dimension(10, 10));
        dummy2.setMinimumSize(new java.awt.Dimension(10, 10));
        dummy2.setPreferredSize(new java.awt.Dimension(10, 10));
        dummy2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(dummy2);

        functionButtonGroup.add(chartToggleButton);
        chartToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/chart_bar_16.png"))); // NOI18N
        chartToggleButton.setText("Chart");
        chartToggleButton.setFocusable(false);
        chartToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chartToggleButton.setMaximumSize(new java.awt.Dimension(60, 40));
        chartToggleButton.setMinimumSize(new java.awt.Dimension(60, 40));
        chartToggleButton.setPreferredSize(new java.awt.Dimension(60, 40));
        chartToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(chartToggleButton);

        dummy1.setEnabled(false);
        dummy1.setFocusable(false);
        dummy1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dummy1.setMaximumSize(new java.awt.Dimension(10, 10));
        dummy1.setMinimumSize(new java.awt.Dimension(10, 10));
        dummy1.setPreferredSize(new java.awt.Dimension(10, 10));
        dummy1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(dummy1);

        functionButtonGroup.add(sumToggleButton);
        sumToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/table_sum_16.png"))); // NOI18N
        sumToggleButton.setSelected(true);
        sumToggleButton.setText("Sum Table");
        sumToggleButton.setFocusable(false);
        sumToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sumToggleButton.setMaximumSize(new java.awt.Dimension(60, 40));
        sumToggleButton.setMinimumSize(new java.awt.Dimension(60, 40));
        sumToggleButton.setPreferredSize(new java.awt.Dimension(60, 40));
        sumToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(sumToggleButton);

        exportPanel.add(jToolBar2);

        monthToolBar.setBorder(null);
        monthToolBar.setFloatable(false);
        monthToolBar.setRollover(true);

        monthButtonGroup.add(janToggleButton);
        janToggleButton.setSelected(true);
        janToggleButton.setText("Jan");
        janToggleButton.setToolTipText("Balloon description");
        janToggleButton.setFocusable(false);
        janToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        janToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        janToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        janToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        janToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(janToggleButton);

        monthButtonGroup.add(febToggleButton);
        febToggleButton.setText("Feb");
        febToggleButton.setToolTipText("Balloon description");
        febToggleButton.setFocusable(false);
        febToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        febToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        febToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        febToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        febToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(febToggleButton);

        monthButtonGroup.add(marToggleButton);
        marToggleButton.setText("Mar");
        marToggleButton.setToolTipText("Balloon description");
        marToggleButton.setFocusable(false);
        marToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        marToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        marToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        marToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        marToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(marToggleButton);

        monthButtonGroup.add(aprToggleButton);
        aprToggleButton.setText("Apr");
        aprToggleButton.setToolTipText("Balloon description");
        aprToggleButton.setFocusable(false);
        aprToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aprToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        aprToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        aprToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        aprToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(aprToggleButton);

        monthButtonGroup.add(mayToggleButton);
        mayToggleButton.setText("May");
        mayToggleButton.setToolTipText("Balloon description");
        mayToggleButton.setFocusable(false);
        mayToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mayToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        mayToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        mayToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        mayToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(mayToggleButton);

        monthButtonGroup.add(junToggleButton);
        junToggleButton.setText("Jun");
        junToggleButton.setToolTipText("Balloon description");
        junToggleButton.setFocusable(false);
        junToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        junToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        junToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        junToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        junToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(junToggleButton);

        monthButtonGroup.add(julToggleButton);
        julToggleButton.setText("Jul");
        julToggleButton.setToolTipText("Balloon description");
        julToggleButton.setFocusable(false);
        julToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        julToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        julToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        julToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        julToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(julToggleButton);

        monthButtonGroup.add(augToggleButton);
        augToggleButton.setText("Aug");
        augToggleButton.setToolTipText("Balloon description");
        augToggleButton.setFocusable(false);
        augToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        augToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        augToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        augToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        augToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(augToggleButton);

        monthButtonGroup.add(sepToggleButton);
        sepToggleButton.setText("Sep");
        sepToggleButton.setToolTipText("Balloon description");
        sepToggleButton.setFocusable(false);
        sepToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sepToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        sepToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        sepToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        sepToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(sepToggleButton);

        monthButtonGroup.add(octToggleButton);
        octToggleButton.setText("Oct");
        octToggleButton.setToolTipText("Balloon description");
        octToggleButton.setFocusable(false);
        octToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        octToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        octToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        octToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        octToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(octToggleButton);

        monthButtonGroup.add(novToggleButton);
        novToggleButton.setText("Nov");
        novToggleButton.setToolTipText("Balloon description");
        novToggleButton.setFocusable(false);
        novToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        novToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        novToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        novToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        novToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(novToggleButton);

        monthButtonGroup.add(decToggleButton);
        decToggleButton.setText("Dec");
        decToggleButton.setToolTipText("Balloon description");
        decToggleButton.setFocusable(false);
        decToggleButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        decToggleButton.setMaximumSize(new java.awt.Dimension(40, 25));
        decToggleButton.setMinimumSize(new java.awt.Dimension(40, 25));
        decToggleButton.setPreferredSize(new java.awt.Dimension(40, 25));
        decToggleButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        monthToolBar.add(decToggleButton);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("The most alarm device");

        eventPanel.setPreferredSize(new java.awt.Dimension(100, 121));

        poorLabel.setText("0 of Poor Connection");
        poorLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        poorLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        poorLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        lostLabel.setText("0 of Lost Connection");
        lostLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        lostLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        lostLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        gsmLowSignalLabel.setText("0 of GSM Low Signal");
        gsmLowSignalLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        gsmLowSignalLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        gsmLowSignalLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        mtLabel.setText("0 of Maintenance");
        mtLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        mtLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        mtLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        lowCreditLabel.setText("0 of GSM Low Credit");
        lowCreditLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        lowCreditLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        lowCreditLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        gsmDateLabel.setText("0 of GSM Date Expired");

        javax.swing.GroupLayout eventPanelLayout = new javax.swing.GroupLayout(eventPanel);
        eventPanel.setLayout(eventPanelLayout);
        eventPanelLayout.setHorizontalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lowCreditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mtLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gsmLowSignalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(poorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gsmDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        eventPanelLayout.setVerticalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(poorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowCreditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gsmLowSignalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gsmDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        eventScroll.setViewportView(eventPanel);

        sumTabbedPane.addTab("Event", eventScroll);

        alertPanel.setPreferredSize(new java.awt.Dimension(100, 121));

        mainPowerLostLabel.setText("0 of Main power lost");
        mainPowerLostLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        mainPowerLostLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        mainPowerLostLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        lowBatteryLabel.setText("0 of Low Battery");
        lowBatteryLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        lowBatteryLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        lowBatteryLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        lowMemoryLabel.setText("0 of Low Memory");
        lowMemoryLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        lowMemoryLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        lowMemoryLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        probeUpperLabel.setText("0 of Probe Error (Upper bound)");
        probeUpperLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        probeUpperLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        probeUpperLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        probeLowerLabel.setText("0 of Probe Error (Lower bound)");
        probeLowerLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        probeLowerLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        probeLowerLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        probeDisconnectLabel.setText("0 of Probe Error (Disconnect)");
        probeDisconnectLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        probeDisconnectLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        probeDisconnectLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        probeShortLabel.setText("0 of Probe Error (Short)");
        probeShortLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        probeShortLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        probeShortLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        probeOtherLabel.setText("0 of Probe Error (Other)");
        probeOtherLabel.setMaximumSize(new java.awt.Dimension(74, 14));
        probeOtherLabel.setMinimumSize(new java.awt.Dimension(74, 14));
        probeOtherLabel.setPreferredSize(new java.awt.Dimension(74, 14));

        javax.swing.GroupLayout alertPanelLayout = new javax.swing.GroupLayout(alertPanel);
        alertPanel.setLayout(alertPanelLayout);
        alertPanelLayout.setHorizontalGroup(
            alertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(probeUpperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probeLowerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probeDisconnectLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probeShortLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowMemoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowBatteryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPowerLostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(probeOtherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        alertPanelLayout.setVerticalGroup(
            alertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPowerLostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowBatteryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowMemoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probeUpperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probeLowerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probeDisconnectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probeShortLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probeOtherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        alertScroll.setViewportView(alertPanel);

        sumTabbedPane.addTab("Alert", alertScroll);

        warningPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        warningPanel.setPreferredSize(new java.awt.Dimension(100, 150));

        upperLabel.setText("0 of Upper");
        upperLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        upperLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        upperLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        upperTimeLabel.setText("0 of Upper-Time");
        upperTimeLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        upperTimeLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        upperTimeLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        upperExtremeLabel.setText("0 of Upper-Extreme");
        upperExtremeLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        upperExtremeLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        upperExtremeLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        lowerLabel.setText("0 of Lower");
        lowerLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        lowerLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        lowerLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        lowerTimeLabel.setText("0 of Lower-Time");
        lowerTimeLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        lowerTimeLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        lowerTimeLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        lowerExtremeLabel.setText("0 of Lower-Extreme");
        lowerExtremeLabel.setMaximumSize(new java.awt.Dimension(75, 14));
        lowerExtremeLabel.setMinimumSize(new java.awt.Dimension(75, 14));
        lowerExtremeLabel.setPreferredSize(new java.awt.Dimension(75, 14));

        javax.swing.GroupLayout warningPanelLayout = new javax.swing.GroupLayout(warningPanel);
        warningPanel.setLayout(warningPanelLayout);
        warningPanelLayout.setHorizontalGroup(
            warningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(warningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upperLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(upperTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upperExtremeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowerTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lowerExtremeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        warningPanelLayout.setVerticalGroup(
            warningPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(warningPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upperTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upperExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowerExtremeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        warningScroll.setViewportView(warningPanel);

        sumTabbedPane.addTab("Warning", warningScroll);

        jToolBar1.setFloatable(false);

        mostAlarmButton.setForeground(new java.awt.Color(255, 0, 0));
        mostAlarmButton.setText("-");
        mostAlarmButton.setFocusable(false);
        mostAlarmButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        mostAlarmButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(mostAlarmButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sumTabbedPane)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(sumTabbedPane)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(groupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monthToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(statPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(exportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertPanel;
    private javax.swing.JScrollPane alertScroll;
    public javax.swing.JToggleButton aprToggleButton;
    public javax.swing.JToggleButton augToggleButton;
    private javax.swing.JToggleButton chartToggleButton;
    public javax.swing.JToggleButton decToggleButton;
    public javax.swing.JComboBox departmentComboBox;
    public javax.swing.JComboBox deviceGroupComboBox;
    private javax.swing.JButton dummy1;
    private javax.swing.JButton dummy2;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JScrollPane eventScroll;
    private javax.swing.JPanel exportPanel;
    public javax.swing.JToggleButton febToggleButton;
    private javax.swing.ButtonGroup functionButtonGroup;
    private javax.swing.JPanel groupPanel;
    private javax.swing.JLabel gsmDateLabel;
    private javax.swing.JLabel gsmLowSignalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    public javax.swing.JToggleButton janToggleButton;
    public javax.swing.JToggleButton julToggleButton;
    public javax.swing.JToggleButton junToggleButton;
    private javax.swing.JLabel lostLabel;
    private javax.swing.JLabel lowBatteryLabel;
    private javax.swing.JLabel lowCreditLabel;
    private javax.swing.JLabel lowMemoryLabel;
    private javax.swing.JLabel lowerExtremeLabel;
    private javax.swing.JLabel lowerLabel;
    private javax.swing.JLabel lowerTimeLabel;
    private javax.swing.JLabel mainPowerLostLabel;
    public javax.swing.JToggleButton marToggleButton;
    public javax.swing.JToggleButton mayToggleButton;
    private javax.swing.ButtonGroup monthButtonGroup;
    private javax.swing.JToolBar monthToolBar;
    private javax.swing.JButton mostAlarmButton;
    private javax.swing.JLabel mtLabel;
    public javax.swing.JToggleButton novToggleButton;
    public javax.swing.JToggleButton octToggleButton;
    private javax.swing.JLabel poorLabel;
    private javax.swing.JLabel probeDisconnectLabel;
    private javax.swing.JLabel probeLowerLabel;
    private javax.swing.JLabel probeOtherLabel;
    private javax.swing.JLabel probeShortLabel;
    private javax.swing.JLabel probeUpperLabel;
    private javax.swing.JButton refreshButton;
    public javax.swing.JToggleButton sepToggleButton;
    private javax.swing.JPanel statPanel;
    private javax.swing.JTabbedPane sumTabbedPane;
    private javax.swing.JToggleButton sumToggleButton;
    private javax.swing.JLabel upperExtremeLabel;
    private javax.swing.JLabel upperLabel;
    private javax.swing.JLabel upperTimeLabel;
    private javax.swing.JPanel warningPanel;
    private javax.swing.JScrollPane warningScroll;
    private javax.swing.JComboBox yearComboBox;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == janToggleButton) month = 1;
        else if (src == febToggleButton) month = 2;
        else if (src == marToggleButton) month = 3;
        else if (src == aprToggleButton) month = 4;
        else if (src == mayToggleButton) month = 5;
        else if (src == junToggleButton) month = 6;
        else if (src == julToggleButton) month = 7;
        else if (src == augToggleButton) month = 8;
        else if (src == sepToggleButton) month = 9;
        else if (src == octToggleButton) month = 10;
        else if (src == novToggleButton) month = 11;
        else if (src == decToggleButton) month = 12;
        else if (src == yearComboBox && yearComboBox.getSelectedItem() != null)
        {
            year = Integer.parseInt( (String)yearComboBox.getSelectedItem());
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setDeviceGroupComboBox();
        }
        else if (src == chartToggleButton || src == sumToggleButton)
        {
            setDataGraph();
        }
        if (departmentComboBox.getSelectedItem() != null && 
                yearComboBox.getSelectedItem() != null &&
                deviceGroupComboBox.getSelectedItem() != null)
        {
            setDataGraph();
            setDataSummary();
        }

    }

}
