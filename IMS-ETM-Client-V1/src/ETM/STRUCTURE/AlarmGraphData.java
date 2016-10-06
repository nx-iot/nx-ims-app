package ETM.STRUCTURE;

public class AlarmGraphData
{
    public String alarmID;
    public String deviceID;
    public String errorName;
    public String alarmSource;
    public String alarmTimeStamp;
    public String alarmFixedTimeStamp;

    public long alarmTimeLong;
    public long alarmFixedTimeLong;


    public AlarmGraphData()
    {
        alarmID = "";
        deviceID = "";
        errorName = "";
        alarmSource = "";
        alarmTimeStamp = "";
        alarmFixedTimeStamp = "";

        alarmTimeLong = 0;
        alarmFixedTimeLong = 0;
    }


}
