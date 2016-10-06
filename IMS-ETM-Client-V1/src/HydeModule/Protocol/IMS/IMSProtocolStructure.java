/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HydeModule.Protocol.IMS;

import ETM.Util.HydeFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Hyde
 */
public class IMSProtocolStructure 
{
    private byte frameID;
    private byte frameType;
    private byte accm;
    private byte accd;
    private byte requestStatus;
    private byte eventID;
    private byte stat;
    private Vector configSector;
    private Vector configSectorCompleted;
    private byte deviceCH;
    
    private String deviceType;
    private String deviceName;
    private String firmwareVersion;
    private String locationName;
    private String locationID;
    
    private byte[] src;
    private byte[] dest;
    private byte[] nID;
    private byte[] intv;
    private byte[] timeStamp;
    private byte[] timeSync;
    private byte[] alarmID;
    private byte[] deviceID;
    
    private String id;
    private String ip;
    private int port;
    private IMSProtocolStructure fromClient;
    
    private boolean sent;
    private boolean ackType;
    private long timeSent;
    
    private byte dataType;
    private byte timezone;
    private byte[] data;
    private byte[] sampling;
    
    private byte cnfg;
    private byte errorID;
    private byte[] reoccur;
    
    private byte fromHour;
    private byte fromMin;
    private byte toHour;
    private byte toMin;
    
    private byte[] deviceState;
    private byte[] battery;
    private byte[] memory;
    private byte[] lostComDelay;
    private byte powerSource;
    private byte digitalInput1;
    private byte digitalInput2;
    private byte digitalOutput1;
    private byte digitalOutput2;
    
    private byte deviceAlarmEnable;
    private byte deviceEnable;
    private byte operateMode;
    private byte sensor1Enable;
    private byte sensor2Enable;
    private byte sensor3Enable;
    private byte sensor4Enable;
    private byte sensor5Enable;
    
    private byte clearList;
    private byte alarmEnable;
    private byte[] lower;
    private byte[] lowerTime;
    private byte[] lowerExtreme;
    private byte[] upper;
    private byte[] upperTime;
    private byte[] upperExtreme;
    private byte[] outputEnable;
    private byte[] inputEnable;
    private byte[][] inputDelay;
    private byte[][] inputTrig;
    private byte[] outputNormally;
    
    private Vector eventBinder;
    private int retransmitCount;
    
    private byte manageCMD;
    
    private long bornTime;
    private byte eventTrigger;
    private byte remote;
    private byte[] remoteValue;
    
    public IMSProtocolStructure()
    {
        frameID = 1;
        bornTime = new Date().getTime();
        retransmitCount = 0;
    }
    
    public void prepareSend()
    {
        sent = true;
        timeSent = new Date().getTime();
    }
    
    public void retransmit()
    {
        sent = false;
        timeSent = 0;
        retransmitCount++;
    }
    
    public int getRetransmitCount()
    {
        return retransmitCount;
    }
    
    public long getBornTime()
    {
        return bornTime;
    }
    
    public int getChannelEnableState(int ch)
    {
        switch (ch)
        {
            case 1 : return ((deviceState[1] >> 4) & 1);
            case 2 : return ((deviceState[1] >> 3) & 1);
            case 3 : return ((deviceState[1] >> 2) & 1);
            case 4 : return ((deviceState[1] >> 1) & 1);
            case 5 : return ((deviceState[1]     ) & 1);
            default: return 0;
        }
    }
    
    public int getWorkingType()
    {
        if ( ((reoccur[1] >> 7) & 1) == 1)
        {
            return 0;
        }
        else
        {
            return 1;
        }    
    }
    
    public int getReoccur()
    {
        if ( ((reoccur[1] >> 5) & 1) == 1) // occur everyday
        {
            return 0;
        }
        else if ( ((reoccur[1] >> 6) & 1) == 1) // orrcur once
        {
            return 1;
        }
        else
        {
            return 0;
        }    
    }
    
    public String getDayOnWork()
    {
        String ret = "";
        ret += (reoccur[0] >> 7 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 6 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 5 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 4 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 3 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 2 & 1) == 1 ? "1" : "0";
        ret += (reoccur[0] >> 1 & 1) == 1 ? "1" : "0";
        //ret += (reoccur[0]      & 1) == 1 ? "1" : "0"; RESERVED
        return ret;
    }
    
    public int getOperatingModeState()
    {
        if ( ((deviceState[0] >> 2) & 3) == 2)
        {
            return 0;
        }
        else if ( ((deviceState[0] >> 2) & 3) == 1)
        {
            return 1;
        }
        else
        {
            return 0;
        }    
    }
    
    public int getAlarmDetetor()
    {
        if ( ((deviceState[0]) & 3) == 2)
        {
            return 1;
        }
        else
        {
            return 0;
        }  
    }
    
    public String getDigitalInput()
    {
        String dgip = "";
        if (digitalInput1 == 1)
        {
            dgip += "1";
        }
        else
        {
            dgip += "0";
        }
        if (digitalInput2 == 1)
        {
            dgip += "1";
        }
        else
        {
            dgip += "0";
        }
        return dgip+"00000000000000";
    }
    
    public String getDigitalOutput()
    {
        String dgip = "";
        if (digitalOutput1 == 1)
        {
            dgip += "1";
        }
        else
        {
            dgip += "0";
        }
        if (digitalOutput2 == 1)
        {
            dgip += "1";
        }
        else
        {
            dgip += "0";
        }
        return dgip+"00000000000000";
    }
    
    public byte[] getDeviceType()       
    { 
        if (deviceType.length() > 20)
        {
            deviceType = deviceType.substring(0, 20);
        }
        byte[] b = new byte[20];
        System.arraycopy(deviceType.getBytes(), 0, b, 0, deviceType.length());
        return b;
    }
    
    public byte[] getDeviceName()       
    { 
        if (deviceName.length() > 40)
        {
            deviceName = deviceName.substring(0, 40);
        }
        byte[] b = new byte[40];
        System.arraycopy(deviceName.getBytes(), 0, b, 0, deviceName.length());
        return b;
    }
    public byte[] getFirmwareVersion()  
    { 
        if (firmwareVersion.length() > 20)
        {
            firmwareVersion = firmwareVersion.substring(0, 20);
        }
        byte[] b = new byte[20];
        System.arraycopy(firmwareVersion.getBytes(), 0, b, 0, firmwareVersion.length());
        return b;
    }
    public byte[] getLocationName()         
    { 
        if (locationName == null)return new byte[40];
        if (locationName.length() > 40)
        {
            locationName = locationName.substring(0, 40);
        }
        byte[] b = new byte[40];
        System.arraycopy(locationName.getBytes(), 0, b, 0, locationName.length());
        return b;
    }
    public byte[] getLocationID()           
    { 
        if (locationID == null) return new byte[20];
        if (locationID.length() > 20)
        {
            locationID = locationID.substring(0, 20);
        }
        byte[] b = new byte[20];
        System.arraycopy(locationID.getBytes(), 0, b, 0, locationID.length());
        return b;
    }
    public byte[] getDeviceIDString()
    {
        String did = ""+HydeFormat.byteArrayToInt(deviceID);
        if (did.length() > 20)
        {
            did = did.substring(0, 20);
        }
        byte[] b = new byte[20];
        System.arraycopy(did.getBytes(), 0, b, 0, did.length());
        return b;
    }
    
    public int getDeviceID()    { return HydeFormat.byteArrayToInt(deviceID); }
    public int getAlarmID()     { return HydeFormat.byteArrayToInt(alarmID); }
    public int getMemory()
    {
        int l = ((memory[0]&0xFF) << 8)+ ((memory[1]&0xFF)  );
        return l;
    }
    
    public int getLostComDelay()
    {
        int l = ((lostComDelay[0]&0xFF) << 8)+ ((lostComDelay[1]&0xFF)  );
        return l;
    }
    
    public byte getTimeZone()   {return timezone; }
    
    public boolean getAckType() { return ackType; }
    public boolean isSent()     { return sent; }
    
    public float getBattery()   { return HydeFormat.byteArrayToFloat(battery); }
    public float getData()      { return HydeFormat.byteArrayToFloat(data); }
    
    public long getTimeStamp()  { return HydeFormat.byteArrayToLongDate(timeStamp); }
    public long getSentTimestamp() { return timeSent; }
    
    public byte getDeviceChannel(){ return deviceCH; }
    public byte getFrameType()  { return frameType; }
    public byte getStat()       { return stat; }
    public byte getDataType()   { return dataType; }
    public byte getPowerSource(){ return powerSource; }
    public byte getCNFG()       { return cnfg; }
    public byte getAlarmEnable(){ return alarmEnable; }
    
    public byte getFrameID()    { return frameID; }
    public byte getEventID()    { return eventID; }
    public byte getErrorID()    { return errorID; }
    
    public byte getFromHour()   { return fromHour; }
    public byte getFromMin()    { return fromMin; }
    public byte getToHour()     { return toHour; }
    public byte getToMin()      { return toMin; }
    
    public byte getAccessMethod()   { return accm; }
    public byte getAccessDirection(){ return accd; }
    
    public byte getClearList()          { return clearList; }
    public byte getDeviceAlarmEnable()  { return deviceAlarmEnable; }
    public byte getDeviceEnable()       { return deviceEnable; }
    public byte getOperateMode()        { return operateMode; }
    public byte getSensor1Enable()      { return sensor1Enable; }
    public byte getSensor2Enable()      { return sensor2Enable; }
    public byte getSensor3Enable()      { return sensor3Enable; }
    public byte getSensor4Enable()      { return sensor4Enable; }
    public byte getSensor5Enable()      { return sensor5Enable; }
    public byte getOutputEnable(int i)  { return outputEnable[i]; }
    public byte getInputEnable(int i)   { return inputEnable[i]; }
    public byte getOutputNormally(int i){ return outputNormally[i]; }
    
    public byte[] getInputDelayByte(int i)  { return inputDelay[i]; }
    public byte[] getIntervalByte()     { return intv; }
    public byte[] getSourceByte()       { return src; }
    public byte[] getDestinationByte()  { return dest; }
    public byte[] getAlarmIDByte()      { return alarmID; }
    public byte[] getDeviceIDByte()     { return deviceID; }
    public byte[] getNIDByte()          { return nID; }
    public String getNIDString()        
    { 
        return HydeFormat.byteArrayToLongString(nID); 
    }
    
    public byte[] getSamplingByte()     { return sampling; }
    public byte[] getReoccurByte()      { return reoccur; }
    public byte[] getBatteryByte()      { return battery; }
    public byte[] getMemoryByte()       { return memory; }
    public byte[] getLostComDelayByte() { return lostComDelay; }
    
    public byte[] getLowerByte()        { return lower; }
    public byte[] getLowerExtremeByte() { return lowerExtreme; }
    public byte[] getLowerTimeByte()    { return lowerTime; }
    public byte[] getUpperByte()        { return upper; }
    public byte[] getUpperExtremeByte() { return upperExtreme; }
    public byte[] getUpperTimeByte()    { return upperTime; }
    
    public int getConfiguredState()     { return ((deviceState[0] >> 7) & 1); }
    public int getDeviceEnableState()   { return ((deviceState[0] >> 6) & 1); }
    
    public IMSProtocolStructure getFromClient()       { return fromClient; }
    public String getID()               { return id; }
    public String getIP()               { return ip; }
    public int getPort()                { return port; }
    
    public Vector getEventBinder()      { return eventBinder; }
    public Vector getConfigSector()     { return configSector; }
    
    public byte getManageCMD()          {return manageCMD;}
    
    public void addConfigSector(byte cs)
    {
        if(configSector == null) configSector = new Vector();
        configSector.add(cs);
    }
    
    public void setDeviceID(String did)
    {
        int number = Integer.parseInt(did);
        deviceID = new byte[]
        {
            (byte)((number >> 24) & 0xff),
            (byte)((number >> 16) & 0xff),
            (byte)((number >>  8) & 0xff),
            (byte)((number      ) & 0xff)
        };
    }
    
    public void setAlarmID(String aid)
    {
        int number = Integer.parseInt(aid);
        alarmID = new byte[]
        {
            (byte)((number >> 24) & 0xff),
            (byte)((number >> 16) & 0xff),
            (byte)((number >> 8) & 0xff),
            (byte)((number >> 0) & 0xff)
        };
    }
    
    public void setChannel(String ch)       { deviceCH = (byte)Integer.parseInt(ch); }
    public void setAckType(boolean b)       { ackType = b; }
    public void setTimeZone(byte tz)       { timezone = tz; }
    public void setFromClient(IMSProtocolStructure imsps){ fromClient = imsps; }
    
    public void setID(String idaddr)    { id = idaddr; }
    public void setIP(String ipaddr)    { ip = ipaddr; }
    public void setPort(int p)          { port = p; }
    
    public void setFrameID(byte b)      { frameID = b; }
    public void setFrameType(byte b)    { frameType = b; }
    public void setDataType(byte d)     { dataType = d; }
    public void setEventID(byte e)      { eventID = e; }
    public void setStat(byte s)         { stat = s; }
    
    public void setRequestStatus(byte r) { requestStatus = r; }
    public void setDigitalInput1(byte d) { digitalInput1 = d; }
    public void setDigitalInput2(byte d) { digitalInput2 = d; }
    public void setDigitalOutput1(byte d){ digitalOutput1 = d;}
    public void setDigitalOutput2(byte d){ digitalOutput2 = d;}
    
    public void setAccessMethod(byte acc)   { accm = acc; }
    public void setAccessDirection(byte acc){ accd = acc; }
    public void setPowerSource(byte ps)     { powerSource = ps; }
    public void setConfig(byte cnf)         { cnfg = cnf; }
    public void setErrorID(byte ec)         { errorID = ec; }
    
    public void setFromHour(byte set)   { fromHour = set; }
    public void setFromMin(byte set)    { fromMin = set; }
    public void setToHour(byte set)     { toHour = set; }
    public void setToMin(byte set)      { toMin = set; }
    
    public void setDeviceType(String str)       { deviceType = str; }
    public void setDeviceName(String str)       { deviceName = str; }
    public void setFirmwareVersion(String str)  { firmwareVersion = str; }
    public void setHostName(String str)         { locationName = str; }
    public void setHostID(String str)           { locationID = str; }
    
    public void setDeviceAlarmEnable(byte b)    { deviceAlarmEnable = b;}
    public void setDeviceEnable(byte b)         
    {
        deviceEnable = b;
    }
    
    public void setClearList(byte b)            { clearList = b; }
    public void setOperateMode(byte b)          { operateMode = b; }
    public void setSensor1Enable(byte b)        { sensor1Enable = b; }
    public void setSensor2Enable(byte b)        { sensor2Enable = b; }
    public void setSensor3Enable(byte b)        { sensor3Enable = b; }
    public void setSensor4Enable(byte b)        { sensor4Enable = b; }
    public void setSensor5Enable(byte b)        { sensor5Enable = b; }
    
    public void setEventBinder(Vector v)        { eventBinder = v; }
    public void setManageCMD(byte b)            { manageCMD = b; }
    
    public void setOutputEnable(byte b, int i)  
    { 
        if (outputEnable == null) outputEnable = new byte[20];
        outputEnable[i] = b;
    }
    public void setInputEnable(byte b, int i)  
    { 
        if (inputEnable == null) inputEnable = new byte[20];
        inputEnable[i] = b;
    }
    public void setOutputNormally(byte b, int i)  
    { 
        if (outputNormally == null) outputNormally = new byte[20];
        outputNormally[i] = b;
    }
    public void setInputDelay(int delay, int i)  
    { 
        if (inputDelay == null) inputDelay = new byte[20][2];
        inputDelay[i][0] = (byte) (delay      & 0xFF);
        inputDelay[i][1] = (byte) (delay >> 8 & 0xFF);
    }
    public void setInputDelay(byte[] input, int start, int i) 
    { 
        if (inputDelay == null) inputDelay = new byte[20][2];
        inputDelay[i][0] = input[start];
        inputDelay[i][1] = input[start+1];
    }
    
    public void setSource(long sn)
    {
        src = new byte[4];
        src[0] = (byte) (sn       & 0xFF);
        src[1] = (byte) (sn >> 8  & 0xFF);
        src[2] = (byte) (sn >> 16 & 0xFF);
        src[3] = (byte) (sn >> 24 & 0xFF);
    }
    
    public void setDestination(long dn)
    {
        dest = new byte[4];
        dest[0] = (byte) (dn       & 0xFF);
        dest[1] = (byte) (dn >> 8  & 0xFF);
        dest[2] = (byte) (dn >> 16 & 0xFF);
        dest[3] = (byte) (dn >> 24 & 0xFF);
    }
    
    public void setNID(long nid)
    {
        nID = new byte[8];
        nID[0] = (byte) (nid       & 0xFF);
        nID[1] = (byte) (nid >> 8  & 0xFF);
        nID[2] = (byte) (nid >> 16 & 0xFF);
        nID[3] = (byte) (nid >> 24 & 0xFF);
        nID[4] = (byte) (nid >> 32 & 0xFF);
        nID[5] = (byte) (nid >> 40 & 0xFF);
        nID[6] = (byte) (nid >> 48 & 0xFF);
        nID[7] = (byte) (nid >> 56 & 0xFF);
    }
    
    public void setInterval(int seconds)
    {
        intv = new byte[2];
        intv[0] = (byte) (seconds      & 0xFF);
        intv[1] = (byte) (seconds >> 8 & 0xFF);
    }
    
    public void setReoccur(byte[] input, int start) 
    { 
        reoccur = new byte[2];
        System.arraycopy(input, start, reoccur, 0, 2); 
    }
    public void setReoccur(int rec)
    {
        reoccur = new byte[2];
        reoccur[0] = (byte) (rec      & 0xFF);
        reoccur[1] = (byte) (rec >> 8 & 0xFF);
    }
    
    public void setTimeSync(Date date)
    {
        long dateLong = date.getTime();
        timeSync = new byte[4];
        timeSync[0] = (byte) (dateLong >> 24 & 0xFF);
        timeSync[1] = (byte) (dateLong >> 16 & 0xFF);
        timeSync[2] = (byte) (dateLong >> 8  & 0xFF);
        timeSync[3] = (byte) (dateLong       & 0xFF);
    }
    
    public void setSampling(byte[] input, int start) 
    { 
        sampling = new byte[2];
        System.arraycopy(input, start, sampling, 0, 2); 
    }
    public void setSampling(int samp)
    {
        sampling = new byte[2];
        sampling[0] = (byte) (samp      & 0xFF);
        sampling[1] = (byte) (samp >> 8 & 0xFF);
    }
    
    public void setLowerTime(byte[] input, int start) 
    { 
        lowerTime = new byte[2];
        System.arraycopy(input, start, lowerTime, 0, 2); 
    }
    public void setLowerTime(int lt)
    {
        lowerTime = new byte[2];
        lowerTime[0] = (byte) (lt      & 0xFF);
        lowerTime[1] = (byte) (lt >> 8 & 0xFF);
    }
    
    public void setUpperTime(byte[] input, int start) 
    { 
        upperTime = new byte[2];
        System.arraycopy(input, start, upperTime, 0, 2); 
    }
    public void setUpperTime(int lt)
    {
        upperTime = new byte[2];
        upperTime[0] = (byte) (lt      & 0xFF);
        upperTime[1] = (byte) (lt >> 8 & 0xFF);
    }
    
    public void setNID(byte[] input, int start) 
    { 
        nID = new byte[8];
        System.arraycopy(input, start, nID, 0, 8); 
    }
    
    public void setTimeStamp(byte[] input, int start) 
    { 
        timeStamp = new byte[4];
        System.arraycopy(input, start, timeStamp, 0, 4); 
    }
    
    public void setDeviceState(byte[] input, int start) 
    { 
        deviceState = new byte[2];
        System.arraycopy(input, start, deviceState, 0, 2); 
    }
    
    public void setBattery(byte[] input, int start) 
    { 
        battery = new byte[4];
        System.arraycopy(input, start, battery, 0, 4); 
    }
    
    public void setMemory(byte[] input, int start) 
    { 
        memory = new byte[2];
        System.arraycopy(input, start, memory, 0, 2); 
    }
    
    public void setLostComDelay(byte[] input, int start) 
    { 
        lostComDelay = new byte[2];
        System.arraycopy(input, start, lostComDelay, 0, 2); 
    }
    
    public void setData(byte[] input, int start) 
    { 
        data = new byte[4];
        System.arraycopy(input, start, data, 0, 4); 
    }
    
    public void setDeviceID(byte[] input, int start) 
    { 
        deviceID = new byte[4];
        System.arraycopy(input, start, deviceID, 0, 4); 
    }
    
    public void setAlarmID(byte[] input, int start) 
    { 
        alarmID = new byte[4];
        System.arraycopy(input, start, alarmID, 0, 4); 
    }
    
    public void setLower(byte[] input, int start) 
    { 
        lower = new byte[4];
        System.arraycopy(input, start, lower, 0, 4); 
    }
    
    public void setLowerExtreme(byte[] input, int start) 
    { 
        lowerExtreme = new byte[4];
        System.arraycopy(input, start, lowerExtreme, 0, 4); 
    }
    
    public void setUpper(byte[] input, int start) 
    { 
        upper = new byte[4];
        System.arraycopy(input, start, upper, 0, 4); 
    }
    
    public void setUpperExtreme(byte[] input, int start) 
    { 
        upperExtreme = new byte[4];
        System.arraycopy(input, start, upperExtreme, 0, 4); 
    }
    
    public void setAlarmEnable(byte d) { alarmEnable = d; }
    public void setDeviceChannel(byte d) { deviceCH = d; }
    
    public Vector getFlagConfigSectorComplete()
    {
        return configSectorCompleted;
    }
    public void addFlagConfigSectorComplete(byte b)
    {
        if (configSectorCompleted == null) configSectorCompleted = new Vector();
        configSectorCompleted.add((byte)(b&0xFF));
    }
    public void setFlagConfigSectorComplete(Vector scb)
    {
        configSectorCompleted = scb;
    }
    public boolean findConfigSector(byte b)
    {
        Enumeration enu = configSector.elements();
        while (enu.hasMoreElements())
        {
            byte csb = (byte)Integer.parseInt(enu.nextElement()+"");
            if (csb == b)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean isConfigSectorCompleted()
    {
        if (configSectorCompleted == null || configSectorCompleted.isEmpty()) return false;
        if (configSectorCompleted.size() < configSector.size()) return false;
        for (int i=0;i<configSector.size();i++)
        {
            byte b = (byte)Integer.parseInt(configSectorCompleted.elementAt(i)+"");
            if (!findConfigSector(b))
            {
                return false;
            }
        }
        return true;
    }
    
    
    
    public void setTriggerDirection(byte b) 
    { 
        eventTrigger = b;
    }
    public byte getTriggerDirection()
    {
        return eventTrigger;
    }
    public void setRemoteType(byte b) 
    { 
        remote = b;
    }
    public byte getRemoteType()
    {
        return remote;
    }
    public void setRemoteValue(byte[] input, int start) 
    { 
        remoteValue = new byte[4];
        System.arraycopy(input, start, remoteValue, 0, 4); 
    }
    public void setRemoteValue(int input) 
    {
        remoteValue = HydeFormat.intToByteArray(input);
    }
    public byte[] getRemoteValueByte() { return remoteValue; }
    public int getRemoteValue()      { return HydeFormat.byteArrayToInt(remoteValue); }
}
