
package ETM.MAIN;

import HydeModule.File.HydeFileConfig;
import ETM.Util.HydeAudio;
import ETM.Util.HydeClock;
import HydeModule.Table.HydeDataSet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Enumeration;
import java.util.Vector;

public class AlarmCurrentClock extends HydeClock
{
    private MainFrame MF;
    public Vector alarmTabVector;

    private int accInterval = 10;
    private int intervalCount = 3;
    private boolean alarming = false;
    private int currentSize = 0;

    private int doRefreshCounter;

    public AlarmCurrentClock(MainFrame MF)
    {
        this.MF = MF;
        //username = MF.SD.loginUser;
        doRefreshCounter = 0;
        alarmTabVector = new Vector();
        setInterval(1000);

    }

    public void resetAlarmTab()
    {
        alarmTabVector = new Vector();
        doRefreshCounter = 0;
        prepareAlarm();
    }

    public void prepareAlarm()
    {
        Vector v = null, v2 = null;
        String depart_id = MF.SD.loginDepartment;
        if (MF.SD.permissionCrossDepartment.equals("1"))
        {
            v = MF.HDC.queryAll("SELECT "
                + "alarm_id, device_id, device_name, error_name, alarm_source, "
                + "alarm_timestamp, error_priority, user_fix, user_username, user_timestamp, "
                + "system_fix, system_timestamp, device_link "
                + "FROM alarm_current NATURAL JOIN device NATURAL JOIN error "
                + "ORDER BY system_fix, user_fix ASC, error_priority DESC, device_name ASC;");
                //+ "WHERE user_fix = '0' OR system_fix = '0' ORDER BY error_priority DESC;");
            v2 = MF.HDC.queryAll("SELECT "
                + "alarm_id "
                + "FROM alarm_current NATURAL JOIN device NATURAL JOIN error "
                + "WHERE (user_fix = '1' OR system_fix = '1') "
                + "ORDER BY system_fix, user_fix ASC, error_priority DESC, device_name ASC;");
                //+ "WHERE (user_fix = '1' OR system_fix = '1') AND NOT (user_fix = '1' AND system_fix = '1') ORDER BY error_priority DESC;");
        }
        else
        {
            v = MF.HDC.queryAll("SELECT "
                + "alarm_id, device_id, device_name, error_name, alarm_source, "
                + "alarm_timestamp, error_priority, user_fix, user_username, user_timestamp, "
                + "system_fix, system_timestamp, device_link "
                + "FROM alarm_current NATURAL JOIN device NATURAL JOIN device_group NATURAL JOIN error "
                + "WHERE depart_id = '"+depart_id+"' "
                + "ORDER BY system_fix, user_fix ASC, error_priority DESC, device_name ASC;");
                //+ "WHERE user_fix = '0' OR system_fix = '0' ORDER BY error_priority DESC;");
            v2 = MF.HDC.queryAll("SELECT "
                + "alarm_id "
                + "FROM alarm_current NATURAL JOIN device NATURAL JOIN device_group NATURAL JOIN error "
                + "WHERE depart_id = '"+depart_id+"' "
                + "AND (user_fix = '1' OR system_fix = '1') "
                + "ORDER BY system_fix, user_fix ASC, error_priority DESC, device_name ASC;");
        }
        if (v != null)
        {
            if (v2 != null)
            {
                currentSize = v.size() - v2.size();
                if (currentSize < 0) currentSize = 0;
            }
            HydeDataSet HDS = new HydeDataSet(v);
            Vector rv = HDS.getRowVector();
            Enumeration enu = rv.elements();
            while (enu.hasMoreElements())
            {
                Vector rowData = (Vector)enu.nextElement();
                //currentSize = rv.size();
                int count = 0;
                Enumeration alarmTabEnu = alarmTabVector.elements();
                while (alarmTabEnu.hasMoreElements())
                {
                    Vector checkVector = (Vector)alarmTabEnu.nextElement();
                    if (checkVector.elementAt(0).equals(rowData.elementAt(0)))
                    {
                        break;
                    }
                    count++;
                }
                if (count >= alarmTabVector.size())
                {
                    alarmTabVector.add(rowData);
                }
                /*if (rowData.elementAt(7).equals("1") && rowData.elementAt(10).equals("1")) // user && system
                {
                    MF.HDC.customUpdate("UPDATE balloon SET alarm_type = '0' WHERE device_id = '"+rowData.elementAt(1)+"';");
                }
                else if (rowData.elementAt(7).equals("1") && rowData.elementAt(10).equals("0"))
                {
                    MF.HDC.customUpdate("UPDATE balloon SET alarm_type = '1' WHERE device_id = '"+rowData.elementAt(1)+"';");
                }
                else if (rowData.elementAt(7).equals("0") && rowData.elementAt(10).equals("1"))
                {
                    MF.HDC.customUpdate("UPDATE balloon SET alarm_type = '2' WHERE device_id = '"+rowData.elementAt(1)+"';");
                }
                else if (rowData.elementAt(7).equals("0") && rowData.elementAt(10).equals("0"))
                {
                    MF.HDC.customUpdate("UPDATE balloon SET alarm_type = '3' WHERE device_id = '"+rowData.elementAt(1)+"';");
                }*/
            }
        }
        int userNotFixCount = 0;
        if (alarmTabVector != null)
        {
            Enumeration enu = alarmTabVector.elements();
            while (enu.hasMoreElements())
            {
                Vector atv = (Vector) enu.nextElement();
                if (atv.elementAt(7).equals("0"))
                {
                    userNotFixCount++;
                }
            }
        }
        if (alarmTabVector.size() > 0)
        {
            alarming = true;
            try
            {
                String sound = HydeFileConfig.readConfig(MF.SD.DIR+"conf.ini", "other", "sound");
                if (sound.toUpperCase().equals("ON") && userNotFixCount > 0)
                {
                    HydeAudio.playSound("/Soundz/FireAlarm.wav");
                }
            }
            catch (Exception e)
            {
                System.out.println("NAO!!" + e);
            }
            MF.countLabel.setText(currentSize+"");
           // MF.alertTabPanel2.setPreferredSize(new Dimension((alarmTabVector.size()+14)*120,25));
            //MF.alertTabPanel2.setPreferredSize(new Dimension(200,(alarmTabVector.size())*25));
            int tabSize = alarmTabVector.size()*25;
            if (tabSize > (MF.desktopPane.getHeight()/2 -20))
            {
                tabSize = MF.desktopPane.getHeight()/2 -20;
            }
            else if (tabSize < 20)
            {
                tabSize = 20;
            }
            Component[] com = MF.alertTabPanel2.getComponents();
            Enumeration enu = alarmTabVector.elements();
            while (enu.hasMoreElements())
            {
                Vector alarm = (Vector) enu.nextElement();

                int newWidth = (int) (((((String) (alarm.elementAt(2))).length() + ((String) (alarm.elementAt(3))).length()) * 8.3) + 30);
                if (width < newWidth)
                {
                    width = newWidth;
                }
                int currentSize2 = com.length;
                int count = 0;
                for (int i=0;i<com.length;i++)
                {
                    if (((AlertMiniPanel)com[i]).getAlarmID().equals(alarm.elementAt(0)))
                    {
                        break;
                    }
                    count++;
                }
                if (count >= currentSize2)
                {
                    MF.alertTabPanel2.add(new AlertMiniPanel(MF, alarm, MF.alertTabPanel2.getComponentCount()+1));
                    MF.alertTabPanel2.setPreferredSize(new Dimension(width,(alarmTabVector.size()*25)));
                    MF.alertTabPanel2.revalidate();
                }
            }
            MF.alertScroll2.setBounds(0,MF.desktopPane.getHeight()-tabSize,width,tabSize);
            MF.alertScroll2.revalidate();
            MF.alertTabPanel2.revalidate();
        }
        else
        {
            MF.alertScroll2.setBounds(0,MF.desktopPane.getHeight()-20,width,20);
            width = 200;
        }
        if (currentSize <= 0)
        {
            alarming = false;
        }
        MF.countLabel.setText(currentSize+"/"+alarmTabVector.size());
        intervalCount = 0;
    }
    public int width = 200;

    @Override
    public void clockProcess()
    {
        doRefreshCounter++;
        if (doRefreshCounter >= 600)
        {
            doRefreshCounter = 0;
            MF.doRefreshButton();
        }
        if (intervalCount >= accInterval)
        {
            prepareAlarm();
        }
        else
        {
            intervalCount++;
        }
        if (alarming)
        {
            if (MF.countLabel.getBackground().equals(Color.RED))
            {
                MF.blank1.setBackground(new Color(240,240,240));
                MF.countLabel.setBackground(new Color(240,240,240));
                MF.countLabel.setForeground(Color.RED);
                //MF.treeIcon.setBackground(new Color(240,240,240));
                //MF.alertCountPanel.setBackground(new Color(240,240,240));
            }
            else
            {
                MF.blank1.setBackground(Color.RED);
                MF.countLabel.setBackground(Color.RED);
                MF.countLabel.setForeground(Color.WHITE);
                //MF.treeIcon.setBackground(Color.RED);
                //MF.alertCountPanel.setBackground(Color.RED);
            }
        }
        else
        {
            MF.countLabel.setBackground(new Color(240,240,240));
            MF.countLabel.setForeground(new Color(0,153,0));
            //MF.treeIcon.setBackground(new Color(240,240,240));
            //MF.alertCountPanel.setBackground(new Color(240,240,240));
        }
        MF.countLabel.revalidate();
    }
}
