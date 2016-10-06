package HydeModule.Protocol.IMS;

import ETM.Util.HydeCrypto;
import java.util.Date;

public class IMSClientProtocol
{
    public static final byte DELIMITER = 0x7E;
    
    public static final byte STATUS_REQUEST_CMD = 0x1A;
    public static final byte STATUS_REQUEST_ACK = 0x1B;
    public static final byte STATUS_REPORT_CMD = 0x2A;
    public static final byte STATUS_REPORT_ACK = 0x2B;
    public static final byte EVENT_REPORT_CMD = 0x3A;
    public static final byte EVENT_REPORT_ACK = 0x3B;
    public static final byte CONFIG_CMD = 0x4A;
    public static final byte CONFIG_ACK = 0x4B;
    public static final byte DATA_REPORT_CMD = 0x5A;
    public static final byte DATA_REPORT_ACK = 0x5B;
    public static final byte LOG_CMD = 0x6A;
    public static final byte LOG_ACK = 0x6B;
    public static final byte NETWORK_CMD = 0x7A;
    public static final byte NETWORK_ACK = 0x7B;
    public static final byte REMOTE_CMD = (byte) 0x8A;
    public static final byte REMOTE_ACK = (byte) 0x8B;
    public static final byte ERROR_ACK = (byte) 0xEB;
    
    public static final byte MANAGEMENT_CMD = (byte) 0x9A;
    public static final byte MANAGEMENT_ACK = (byte) 0x9B;
    
    public static final byte SENSOR_CONFIG_CMD = (byte) 0xA0;
    public static final byte SENSOR_CONFIG_ACK = (byte) 0xA1;    
    public static final byte DEVICE_CONFIG_CMD = (byte) 0xA2;
    public static final byte DEVICE_CONFIG_ACK = (byte) 0xA3;   
    public static final byte REMOTE_CONTROL_CMD = (byte) 0xA4;
    public static final byte REMOTE_CONTROL_ACK = (byte) 0xA5;
    public static final byte REMOVE_DEVICE_CMD = (byte) 0xAE;
    public static final byte REMOVE_DEVICE_ACK = (byte) 0xAF;
    public static final byte EVENT_TRIGGER_CMD = (byte) 0xB0;
    public static final byte EVENT_TRIGGER_ACK = (byte) 0xB1;
    
    public static final byte READ_SINGLE = 0x10;
    public static final byte READ_MULTIPLE1 = 0x20;
    public static final byte READ_MULTIPLE2 = 0x21;
    public static final byte READ_MULTIPLE3 = 0x22;
    public static final byte READ_MULTIPLE4 = 0x23;
    public static final byte READ_MULTIPLE5 = 0x24;
    public static final byte READ_EVERY = 0x30;
    public static final byte READ_STOP = 0x40;
    
    public static final byte EID_MTNC = 0x10;
    public static final byte MTNC_NORMAL = 0x00;
    public static final byte MTNC_PROGRESS = 0x01;
    
    public static final byte EID_GSM = 0x20;
    public static final byte GSM_NORMAL = 0x00;
    public static final byte GSM_LOW = 0x01;
    public static final byte GSM_EXPIRED = 0x02;
    public static final byte GSM_NO_OPERATOR = 0x04;
    public static final byte GSM_TOP_UP = 0x10;
    
    public static final byte EID_GSM_CREDIT = 0x21;
    public static final byte GSM_CREDIT_NORMAL = 0x00;
    public static final byte GSM_CREDIT_LOW = 0x01;
    
    public static final byte EID_PWR = 0x50;
    public static final byte PWR_NORMAL = 0x00;
    public static final byte PWR_DOWN = 0x01;
    
    public static final byte EID_BATTERY = 0x51;
    public static final byte BATTERY_NORMAL = 0x00;
    public static final byte BATTERY_LOW = 0x01;
    
    public static final byte EID_MEMORY = 0x70;
    public static final byte MEMORY_NORMAL = 0x00;
    public static final byte MEMORY_LOW = 0x01;
    
    public static final byte EID_COMMU = (byte) 0x80;
    public static final byte COMMU_NORMAL = 0x00;
    public static final byte COMMU_POOR = 0x01;
    public static final byte COMMU_LOST = 0x02;
    
    public static final byte EID_DIN_1 = (byte) 0xC0;
    public static final byte EID_DIN_2 = (byte) 0xC1;
    public static final byte EID_DIN_3 = (byte) 0xC2;
    public static final byte EID_DIN_4 = (byte) 0xC3;
    public static final byte EID_DIN_5 = (byte) 0xC4;
    
    public static final byte FALLING_EDGE = 0x00;
    public static final byte RISING_EDGE = 0x01;
    public static final byte UNKNOWN = (byte) 0xFF;
    
    public static final byte EID_AIN_1 = (byte) 0xD0;
    public static final byte EID_AIN_2 = (byte) 0xD1;
    public static final byte EID_AIN_3 = (byte) 0xD2;
    public static final byte EID_AIN_4 = (byte) 0xD3;
    public static final byte EID_AIN_5 = (byte) 0xD4;
    
    public static final byte ANALOG_LOW = 0x00;
    public static final byte ANALOG_HIGH = 0x01;
    
    public static final byte EID_SEN_1 = (byte) 0xE0;
    public static final byte EID_SEN_2 = (byte) 0xE1;
    public static final byte EID_SEN_3 = (byte) 0xE2;
    public static final byte EID_SEN_4 = (byte) 0xE3;
    public static final byte EID_SEN_5 = (byte) 0xE4;
    
    public static final byte SENSOR_NORMAL = 0x00;
    public static final byte SENSOR_LOWER = 0x01;
    public static final byte SENSOR_LOWER_TIME = 0x11;
    public static final byte SENSOR_LOWER_EXTREME = 0x02;
    public static final byte SENSOR_UPPER = 0x04;
    public static final byte SENSOR_UPPER_TIME = 0x14;
    public static final byte SENSOR_UPPER_EXTREME = 0x08;
    public static final byte SENSOR_ERROR_LOWER = 0x20;
    public static final byte SENSOR_ERROR_UPPER = 0x21;
    public static final byte SENSOR_ERROR_DISCONNECT = (byte) 0x84;
    public static final byte SENSOR_ERROR_SHORT = (byte) 0x90;
    
    public static final byte ACCD_READ = 0x10;
    public static final byte ACCD_WRITE = 0x20;
    public static final byte ACCD_CONFIRM = 0x30;
    
    public static final byte CONFIG_PROPERTIES = 0x10;
    public static final byte CONFIG_OPERATE = 0x20;
    public static final byte CONFIG_SENSOR_1 = 0x30;
    public static final byte CONFIG_SENSOR_2 = 0x31;
    public static final byte CONFIG_SENSOR_3 = 0x32;
    public static final byte CONFIG_SENSOR_4 = 0x33;
    public static final byte CONFIG_SENSOR_5 = 0x34;
    public static final byte CONFIG_DIGITAL_INPUT_1 = 0x40;
    public static final byte CONFIG_DIGITAL_INPUT_2 = 0x41;
    public static final byte CONFIG_DIGITAL_INPUT_3 = 0x42;
    public static final byte CONFIG_DIGITAL_INPUT_4 = 0x43;
    public static final byte CONFIG_DIGITAL_INPUT_5 = 0x44;
    public static final byte CONFIG_DIGITAL_OUTPUT_1 = 0x50;
    public static final byte CONFIG_DIGITAL_OUTPUT_2 = 0x51;
    public static final byte CONFIG_DIGITAL_OUTPUT_3 = 0x52;
    public static final byte CONFIG_DIGITAL_OUTPUT_4 = 0x53;
    public static final byte CONFIG_DIGITAL_OUTPUT_5 = 0x54;
    public static final byte CONFIG_BUZZER = (byte) 0x80;
    public static final byte CONFIG_ENVIRONMENT_ALARM = (byte) 0x90;
    public static final byte CONFIG_STATUS_REPORT = (byte) 0xA0;
    
    public static final byte ERROR_INVALID_LENGTH = 0X10;
    public static final byte ERROR_UNKNOWN_FRAME_TYPE = 0x20;
    public static final byte ERROR_INVALID_PARAMETER = 0x30;
    public static final byte ERROR_PARAMETER_VALUE_OUT_RANGE = 0x40;
    public static final byte ERROR_ENDPOINT_NOT_READY = 0x50;
    public static final byte ERROR_UNKNOWN = (byte) 0xFF;
    
    public static int xbCheckSumCreator(byte[] b)
    {
        int sum = 0;
        for (int i=3; i<b.length; i++)
        {
            sum += b[i] & 0xFF;
        }
        int sumByte = sum & 0xFF;
        return 0xFF - sumByte;
    }
    
    public static boolean xbCheckSum(byte[] b)
    {
        int sum = b[0];
        for (int i=1; i<b.length; i++)
        {
            sum += b[i];
        }
        int sumByte = (sum - 0xFF) & 0xFF;
        if (sumByte == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static byte[] assemblyPacket(byte[] frameData)
    {
        byte[] b = new byte[1024];
        int c = 0;
        b[c++] = DELIMITER;

        int totalLength = frameData.length;
        b[c++] = (byte) (totalLength / 256);
        b[c++] = (byte) (totalLength % 256);

        for (int i=0;i<frameData.length;i++)
        {
            b[c++] = frameData[i];
        }
        int sum = xbCheckSumCreator(b);
        b[c++] = (byte) (sum & 0xFF);
        return HydeCrypto.trimByte(b,totalLength+4);
    }
    
    public static byte[] process(byte[] input)
    {
        byte[] out;
        int len = 0;
        try
        {
            if (input[0] == 0x7E)
            {
                len  = input[1]*256;
                len += input[2];
                out = new byte[len+1];
                for (int i=0;i<len+1;i++)
                {
                    out[i] = (byte) (input[3+i] & 0xFF);
                }
                if (xbCheckSum(out))
                {
                    return out;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isInputACK(byte frameType)
    {
        switch (frameType)
        {
            case STATUS_REPORT_ACK :
            case EVENT_REPORT_ACK :
            case DATA_REPORT_ACK :
            case CONFIG_ACK :
            case LOG_ACK :
            case NETWORK_ACK :
            case REMOTE_ACK :
                return true;
        }
        return false;
    }
    
    public static boolean isOutputACK(byte frameType)
    {
        switch (frameType)
        {
            case STATUS_REQUEST_ACK :
            case CONFIG_ACK :
            case STATUS_REQUEST_CMD :
            case ERROR_ACK :
                return true;
        }
        return false;
    }
    
    public static int getErrorID(byte eventID, byte statusCode)
    {
        if (statusCode == UNKNOWN)
        {
            return 1;
        }
        else if (statusCode == 0x00)
        {
            return 0;
        }
        switch (eventID)
        {
            case EID_MTNC : 
                switch (statusCode)
                {
                    case MTNC_PROGRESS : return 9001;
                }
                break;
            case EID_GSM : 
                switch (statusCode)
                {
                    case GSM_LOW : return 4001;
                    case GSM_EXPIRED : return 4002;
                    case GSM_NO_OPERATOR : return 4003;
                    case GSM_TOP_UP : return 4004;
                }
                break;
            case EID_GSM_CREDIT : 
                switch (statusCode)
                {
                    case GSM_CREDIT_LOW : return 4005;
                }
                break;
            case EID_PWR : 
                switch (statusCode)
                {
                    case PWR_DOWN : return 2001;
                }
                break;
            case EID_BATTERY : 
                switch (statusCode)
                {
                    case BATTERY_LOW : return 2002;
                }
                break;
            case EID_MEMORY : 
                switch (statusCode)
                {
                    case MEMORY_LOW : return 2003;
                }
                break;
            case EID_COMMU : 
                switch (statusCode)
                {
                    case COMMU_POOR : return 1001;
                    case COMMU_LOST : return 1002;
                }
                break;
            case EID_DIN_1 : 
            case EID_DIN_2 :
            case EID_DIN_3 :
            case EID_DIN_4 :
            case EID_DIN_5 :
                switch (statusCode)
                {
                    case FALLING_EDGE : return 5101;
                    case RISING_EDGE : return 5102;
                }
                break;
            case EID_AIN_1 : 
            case EID_AIN_2 :
            case EID_AIN_3 :
            case EID_AIN_4 :
            case EID_AIN_5 :
                switch (statusCode)
                {
                    case ANALOG_LOW : return 5001;
                    case ANALOG_HIGH : return 5002;
                }
                break;
            case EID_SEN_1 : 
            case EID_SEN_2 :
            case EID_SEN_3 :
            case EID_SEN_4 :
            case EID_SEN_5 :
                switch (statusCode)
                {
                    case SENSOR_UPPER : return 3001;
                    case SENSOR_UPPER_TIME : return 3002;
                    case SENSOR_UPPER_EXTREME : return 3003;
                    case SENSOR_LOWER : return 3101;
                    case SENSOR_LOWER_TIME : return 3102;
                    case SENSOR_LOWER_EXTREME : return 3103;
                    case SENSOR_ERROR_UPPER : return 3201;
                    case SENSOR_ERROR_LOWER : return 3202;
                }
                break;
        }
        return 1;
    }
    
    public static String getFrameTypeName(byte frameType)
    {
        switch (frameType)
        {
            case MANAGEMENT_CMD :       return "Management CMD";
            case SENSOR_CONFIG_CMD :    return "Sensor Read/Config CMD";
            case DEVICE_CONFIG_CMD :    return "Device Read/Config CMD";
            case MANAGEMENT_ACK :       return "Management ACK";
            case EVENT_TRIGGER_CMD :    return "Event Trigger CMD";
            case EVENT_TRIGGER_ACK :    return "Event Trigger ACK";
            case REMOTE_CONTROL_CMD :   return "Remote CMD";
            case REMOVE_DEVICE_CMD :    return "Remove Device CMD";
                
//            case SENSOR_CONFIG_ACK :
//            case DEVICE_CONFIG_ACK :
//            case REMOTE_ACK :
//            case REMOTE_CONTROL_ACK :
//            case REMOVE_DEVICE_ACK :
        }
        return "Unknown";
    }
    
    public static String getErrorSource(byte eventID)
    {
        switch (eventID)
        {
            case EID_GSM : 
            case EID_GSM_CREDIT : return "GSM";
            case EID_MTNC :
            case EID_PWR : 
            case EID_BATTERY : 
            case EID_MEMORY : 
            case EID_COMMU : return "Device";
            case EID_DIN_1 : return "Digital Input 1";
            case EID_DIN_2 : return "Digital Input 2";
            case EID_DIN_3 : return "Digital Input 3";
            case EID_DIN_4 : return "Digital Input 4";
            case EID_DIN_5 : return "Digital Input 5";
            case EID_AIN_1 : return "Analog Input 1";
            case EID_AIN_2 : return "Analog Input 2";
            case EID_AIN_3 : return "Analog Input 3";
            case EID_AIN_4 : return "Analog Input 4";
            case EID_AIN_5 : return "Analog Input 5";
            case EID_SEN_1 : return "Sensor 1";
            case EID_SEN_2 : return "Sensor 2";
            case EID_SEN_3 : return "Sensor 3";
            case EID_SEN_4 : return "Sensor 4";
            case EID_SEN_5 : return "Sensor 5";
            default : return "Unknown";
        }
    }
    
    public static IMSProtocolStructure processType(byte[] data)
    {
        IMSProtocolStructure IMSPS = new IMSProtocolStructure();
        switch (data[1])
        {
            case MANAGEMENT_CMD :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setManageCMD(data[10]);
                return IMSPS;
            case MANAGEMENT_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setManageCMD(data[10]);
                IMSPS.setStat(data[11]);
                return IMSPS;
            case SENSOR_CONFIG_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setStat(data[10]);
                IMSPS.setAccessDirection(data[11]);
                return IMSPS;
            case DEVICE_CONFIG_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setStat(data[10]);
                IMSPS.setAccessDirection(data[11]);
                int size = data[12];
                for (int i=0;i<size;i++)
                {
                    IMSPS.addConfigSector(data[13+i]);
                }
                return IMSPS;
            case EVENT_TRIGGER_CMD :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setAlarmID(data,10);
                IMSPS.setTriggerDirection(data[14]);
                return IMSPS;
            case EVENT_TRIGGER_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                return IMSPS;
            case REMOTE_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setRemoteType(data[10]);
                IMSPS.setStat(data[11]);
                return IMSPS;
                
            case REMOTE_CONTROL_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setRemoteType(data[10]);
                IMSPS.setStat(data[11]);
                return IMSPS;
                
            case REMOVE_DEVICE_ACK :
                IMSPS.setFrameID(data[0]);
                IMSPS.setFrameType(data[1]);
                IMSPS.setNID(data,2);
                IMSPS.setStat(data[10]);
                IMSPS.setAccessDirection(data[11]);
                return IMSPS;
        }
        return null;
    }
    
    public static byte[] createPacket(IMSProtocolStructure IMSPS)
    {
        byte[] b;
        Date now = new Date();
        switch (IMSPS.getFrameType())
        {
            case MANAGEMENT_CMD :
                b = new byte[11];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                b[10] = IMSPS.getManageCMD();
                return assemblyPacket(b);
            case SENSOR_CONFIG_CMD :
                b = new byte[16];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                System.arraycopy(IMSPS.getDeviceIDByte(), 0, b, 10, 4);
                b[14] = IMSPS.getDeviceChannel();
                b[15] = IMSPS.getAccessDirection();
                return assemblyPacket(b);
            case DEVICE_CONFIG_CMD :
                int size = IMSPS.getConfigSector().size();
                b = new byte[16+size];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                System.arraycopy(IMSPS.getDeviceIDByte(), 0, b, 10, 4);
                b[14] = IMSPS.getAccessDirection();
                b[15] = (byte) size;
                for (int i=0;i<size;i++)
                {
                    b[16+i] = (byte)(Integer.parseInt(IMSPS.getConfigSector().elementAt(i)+"")&0xFF);
                }
                return assemblyPacket(b);
                
            case MANAGEMENT_ACK :
                b = new byte[12];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                b[10] = IMSPS.getManageCMD();
                b[11] = IMSPS.getStat();
                return assemblyPacket(b);
            case EVENT_TRIGGER_CMD :
                b = new byte[15];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                System.arraycopy(IMSPS.getAlarmIDByte(), 0, b, 10, 4);
                b[14] = IMSPS.getTriggerDirection();
                return assemblyPacket(b);
            case EVENT_TRIGGER_ACK :
                b = new byte[10];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                return assemblyPacket(b);
            case REMOTE_CONTROL_CMD :
                b = new byte[23];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                System.arraycopy(IMSPS.getAlarmIDByte(), 0, b, 10, 4);
                System.arraycopy(IMSPS.getDeviceIDByte(), 0, b, 14, 4);
                b[18] = IMSPS.getRemoteType();
                System.arraycopy(IMSPS.getRemoteValueByte(), 0, b, 19, 4);
                return assemblyPacket(b);
                
            case REMOVE_DEVICE_CMD :
                b = new byte[15];
                b[0] = IMSPS.getFrameID();
                b[1] = IMSPS.getFrameType();
                System.arraycopy(IMSPS.getNIDByte(), 0, b, 2, 8);
                System.arraycopy(IMSPS.getDeviceIDByte(), 0, b, 10, 4);
                b[14] = IMSPS.getAccessDirection();
                return assemblyPacket(b);
        }
        return null;
    }
}
