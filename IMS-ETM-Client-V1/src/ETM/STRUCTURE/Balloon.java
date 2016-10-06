package ETM.STRUCTURE;

import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Vector;

public class Balloon
{
    private String id;
    private int x;
    private int y;
    
    private String floorID;
    private String floorName;
    //private String department;
    private String organization;
    private String deviceID;
    private String status;
    private String type;
    private String alarmType;

    public String[] probe;
    public String[] probeData;
    public String[] probeTimeStamp;

    private static int PROBE_NUMBER = 5;

    public Vector subx;
    public Vector suby;
    public Vector subType;

    public Balloon()
    {
        this.id = null;
        this.floorID = null;
        this.floorName = null;
        this.organization = null;
        this.status = null;
        this.deviceID = null;
        this.alarmType = null;
        this.type = "0";

        this.probe = new String[PROBE_NUMBER];
        this.probeData = new String[PROBE_NUMBER];
        this.probeTimeStamp = new String[PROBE_NUMBER];
        Arrays.fill(probe, "");
        Arrays.fill(probeData, "-");
        Arrays.fill(probeTimeStamp, "-");

        subx = new Vector();
        suby = new Vector();
        subType = new Vector();
    }

    public boolean hasProbe()
    {
        for (int i=0; i<PROBE_NUMBER ;i++)
        {
            if (!probe[i].equals(""))
            {
                return true;
            }
        }
        return false;
    }

    public void setProbe(String[] str)
    {
        if (str.length >= PROBE_NUMBER)
        {
            for (int i=0;i<PROBE_NUMBER;i++)
            {
                probe[i] = str[i];
            }
        }
    }
    public void setProbeTimeStamp(String[] str)
    {
        if (str.length >= PROBE_NUMBER)
        {
            for (int i=0;i<PROBE_NUMBER;i++)
            {
                probeTimeStamp[i] = str[i];
            }
        }
    }
    public void setAlarmType(String at)
    {
        alarmType = at;
    }

    public String getID()
    {
        return id;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String getFloorID()
    {
        return floorID;
    }
    public String getFloorName()
    {
        return floorName;
    }
    /*public String getDepartment()
    {
        return department;
    }*/
    public String getOrganization()
    {
        return organization;
    }
    public String getDeviceID()
    {
        return deviceID;
    }
    public String getType()
    {
        return type;
    }
    public String getAlarmType()
    {
        return alarmType;
    }
    public String getStatus()
    {
        return status;
    }

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setID(String id)
    {
        this.id = id;
    }
    public void setFloorID(String floorID)
    {
        this.floorID = floorID;
    }
    public void setFloorName(String floorName)
    {
        this.floorName = floorName;
    }
    /*public void setDepartment(String dep)
    {
        department = dep;
    }*/
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }
    public void setDeviceID(String deviceID)
    {
        this.deviceID = deviceID;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    public void setType(String type)
    {
        if (type == null)
        {
            this.type = "0";
        }
        else
        {
            this.type = type;
        }
    }
    public void addPoint(String x, String y, String type)
    {
        subx.add(x);
        suby.add(y);
        subType.add(type);
    }
    public Vector getSubX()
    {
        return subx;
    }
    public Vector getSubY()
    {
        return suby;
    }
    public Vector getSubType()
    {
        return subType;
    }

    public boolean balloonIsHere(int posx, int posy, int bound)
    {
        if (posx > (x-bound) && posx < (x+bound))
        {
            if (posy > (y-bound) && posy < (y+bound))
            {
                return true;
            }
        }
        return false;
    }

}
