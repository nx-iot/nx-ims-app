package ETM.STRUCTURE;

public class FloorPlanIndex
{
    public int floorPlanID;
    public int floorIndex;
    public int departmentIndex;
    public String floorID;
    public String floorName;
    public String departmentName;

    public FloorPlanIndex(int id)
    {
        floorPlanID = id;
        departmentIndex = 0;
        floorIndex = 0;
        floorID = "0";
        departmentName = "No department selected...";
        floorName = "No plan selected...";
    }

    public void setFloorPlanID(int fp)
    {
        floorPlanID = fp;
    }
    public void setDepartmentIndex(int oi)
    {
        departmentIndex = oi;
    }
    public void setFloorIndex(int fi)
    {
        floorIndex = fi;
    }
    public void setFloorID(String fid)
    {
        floorID = fid;
    }
    public void setFloorName(String fn)
    {
        floorName = fn;
    }
    public void setDepartmentName(String on)
    {
        departmentName = on;
    }

    public int getFloorPlanID()
    {
        return floorPlanID;
    }
    public int getDepartmentIndex()
    {
        return departmentIndex;
    }
    public int getFloorIndex()
    {
        return floorIndex;
    }
    public String getFloorID()
    {
        return floorID;
    }
    public String getFloorName()
    {
        return floorName;
    }
    public String getDepartmentName()
    {
        return departmentName;
    }

}
