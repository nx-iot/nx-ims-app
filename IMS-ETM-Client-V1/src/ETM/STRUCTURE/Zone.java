package ETM.STRUCTURE;

public class Zone
{
    private String id;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    
    private String floorID;
    private String floorName;
    private String organization;
    private String locationID;
    private String locationName;

    public Zone()
    {
        this.id = null;
        this.locationID = null;
        this.locationName = null;
        this.floorID = null;
        this.floorName = null;
        this.organization = null;
    }

    public String getID()
    {
        return id;
    }
    public int getX1()
    {
        return x1;
    }
    public int getY1()
    {
        return y1;
    }
    public int getX2()
    {
        return x2;
    }
    public int getY2()
    {
        return y2;
    }

    public String getFloorID()
    {
        return floorID;
    }
    public String getFloorName()
    {
        return floorName;
    }
    public String getOrganization()
    {
        return organization;
    }
    public String getLocationID()
    {
        return locationID;
    }
    public String getLocationName()
    {
        return locationName;
    }
    public void setX1(int x1)
    {
        this.x1 = x1;
    }
    public void setY1(int y1)
    {
        this.y1 = y1;
    }
    public void setX2(int x2)
    {
        this.x2 = x2;
    }
    public void setY2(int y2)
    {
        this.y2 = y2;
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
    public void setOrganization(String organization)
    {
        this.organization = organization;
    }
    public void setLocationID(String locationID)
    {
        this.locationID = locationID;
    }
    public void setLocationName(String locationName)
    {
        this.locationName = locationName;
    }
    public boolean zoneIsHere(int posx, int posy)
    {
        if (posx > x1 && posx < x2)
        {
            if (posy > y1 && posy < y2)
            {
                return true;
            }
        }
        return false;
    }

}
