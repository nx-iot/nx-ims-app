/*
 * HydeFormat Module
 *  Version 1.7 (25/08/2012)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HydeFormat
{
    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static DecimalFormat dF = new DecimalFormat("#0000");

    public static Date formatDate(String DateTime) throws ParseException
    {
        Date date = SDF.parse(DateTime);
        return date;
    }
    public static long dateToInteger(Date d)
    {
        int date = d.getDate();
        int month = d.getMonth();
        int year = d.getYear()+1900;
        int hour = d.getHours();
        int min = d.getMinutes();
        int sec = d.getSeconds();
        long sum = 0;
        int totalDay = 0;
        for (int i=0;i<month;i++)
        {
            totalDay += getMonthDay((i+1),year);
        }
        sum = sec + (min*60) + (hour*60*60) + (date*60*60*24) + (totalDay*60*60*24);

        return sum;
    }

    public static int dateFilter(int totalDay,int year)
    {
        int td = totalDay;
        if (td == 0)
        {
            td = 1;
        }
        int startMonth = 1;
        while (td > (getMonthDay(startMonth,year)))
        {
            td -= getMonthDay(startMonth,year);
            startMonth++;
        }
        return td;
    }

    public static int monthFilter(int totalDay, int year)
    {
        int td = totalDay;
        int startMonth = 1;
        while (td > (getMonthDay(startMonth,year)))
        {
            td -= getMonthDay(startMonth,year);
            startMonth++;
        }
        return startMonth;
    }

    public static int getMonthDay(int month, int year)
    {
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (year % 4 == 0)
                {
                    return 29;
                }
                return 28;
        }
        return 0;
    }

    public boolean isRealString(String str)
    {
        if (str.indexOf("#") != -1) return false;
        if (str.indexOf("$") != -1) return false;
        if (str.indexOf("\r") != -1) return false;
        if (str.indexOf("\n") != -1) return false;
        return true;
    }

    public static String parseName(String sid)
    {
        try
        {
            return sid.substring(0, sid.lastIndexOf("(")-1);
        }
        catch(Exception e)
        {
            return "";
        }
    }

    public static String parseID(String sid)
    {
        try
        {
            return sid.substring(sid.lastIndexOf("(")+1, sid.lastIndexOf(")"));
        }
        catch(Exception e)
        {
            return "";
        }
    }
    
    public static byte[] doubleToByteArray(double d) 
    {
        long dl = Double.doubleToRawLongBits(d);
        return new byte[] 
        {
            (byte)((dl >> 0) & 0xff),
            (byte)((dl >> 8) & 0xff),
            (byte)((dl >> 16) & 0xff),
            (byte)((dl >> 24) & 0xff),
            (byte)((dl >> 32) & 0xff),
            (byte)((dl >> 40) & 0xff),
            (byte)((dl >> 48) & 0xff),
            (byte)((dl >> 56) & 0xff)
        };
    }

    public static byte[] floatToByteArray(float d) 
    {
        int fl = Float.floatToRawIntBits(d);
        return new byte[] 
        {
            (byte)((fl >> 0) & 0xff),
            (byte)((fl >> 8) & 0xff),
            (byte)((fl >> 16) & 0xff),
            (byte)((fl >> 24) & 0xff)
        };
    }
    
    public static double byteArrayToDouble(byte[] b) 
    {
        String lbs = 
            stringFrontZeroAppend(Integer.toBinaryString(b[7]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[6]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[5]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[4]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[3]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[2]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[1]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[0]&0xFF),8);
	long lb = Long.parseLong(lbs,2);
		//System.out.println("after = "+lb);
        return Double.longBitsToDouble(lb);
    }
    
    public static double byteArrayInvertToDouble(byte[] b) 
    {
        String lbs = 
            stringFrontZeroAppend(Integer.toBinaryString(b[0]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[1]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[2]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[3]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[4]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[5]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[6]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[7]&0xFF),8);
	long lb = Long.parseLong(lbs,2);
		//System.out.println("after = "+lb);
        return Double.longBitsToDouble(lb);
    }
    
    public static float byteArrayToFloat(byte[] b) 
    {
        String fbs = 
            stringFrontZeroAppend(Integer.toBinaryString(b[3]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[2]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[1]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[0]&0xFF),8);
		//System.out.println("after = "+lb);
        long l = Long.parseLong(fbs,2);
	int fb = (int)(l);
        return Float.intBitsToFloat(fb);
    }
    
    public static float byteArrayInvertToFloat(byte[] b) 
    {
        String fbs = 
            stringFrontZeroAppend(Integer.toBinaryString(b[0]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[1]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[2]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[3]&0xFF),8);
        long l = Long.parseLong(fbs,2);
	int fb = (int)(l);
        return Float.intBitsToFloat(fb);
    }

    public static String stringFrontZeroAppend(String str, int length)
    {
        int strLength = str.length();
        String retStr = str;
        for (int i=strLength;i<length;i++)
        {
                retStr = "0"+retStr;
        }
        return retStr;
    }
    
    public static long byteArrayToLongDate(byte[] b)
    {
        String longString = 
            stringFrontZeroAppend(Integer.toBinaryString(b[3]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[2]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[1]&0xFF),8) + 
            stringFrontZeroAppend(Integer.toBinaryString(b[0]&0xFF),8);
        long ld = Long.parseLong(longString,2);
        return ld*1000L;
    }
    
    public static byte[] longDateToByteArray(long longDate)
    {
        long longDateTrim = longDate / 1000L;
        return new byte[] 
        {
            (byte)((longDateTrim >> 0) & 0xff),
            (byte)((longDateTrim >> 8) & 0xff),
            (byte)((longDateTrim >> 16) & 0xff),
            (byte)((longDateTrim >> 24) & 0xff)
        };
    }
    
    public static byte[] byteStringToByteArray8(String bs)
    {
        if (bs.length() < 16)
        {
            bs = stringFrontZeroAppend(bs,16);
        }
        return new byte[] 
        {
            (byte)(Integer.parseInt(bs.substring(0,2), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(2,4), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(4,6), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(6,8), 16)&0xFF),
            
            (byte)(Integer.parseInt(bs.substring(8,10), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(10,12), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(12,14), 16)&0xFF),
            (byte)(Integer.parseInt(bs.substring(14,16), 16)&0xFF)
        };
    }
    
    public static byte[] intToByteArray(int number)
    {
        return new byte[] 
        {
            (byte)((number >> 0) & 0xff),
            (byte)((number >> 8) & 0xff),
            (byte)((number >> 16) & 0xff),
            (byte)((number >> 24) & 0xff)
        };
    }
    
    public static int byteArrayToInt(byte[] b)
    {
        int did = 
                ((b[0]&0xFF) << 24)+
                ((b[1]&0xFF) << 16)+
                ((b[2]&0xFF) << 8)+
                ( b[3]&0xFF);
        return did;
    }
    
    public static int byteArrayInvertToInt(byte[] b)
    {
        int did = 
                ((b[3]&0xFF) << 24)+
                ((b[2]&0xFF) << 16)+
                ((b[1]&0xFF) << 8)+
                ( b[0]&0xFF);
        return did;
    }
    
    public static int byteArrayToInt2(byte[] b)
    {
        int did = 
                ((b[0]&0xFF) << 8)+
                ( b[1]&0xFF);
        return did;
    }
    
    public static int byteArrayInvertToInt2(byte[] b)
    {
        int did = 
                ((b[1]&0xFF) << 8)+
                ( b[0]&0xFF);
        return did;
    }
    
    public static long byteArrayToLong(byte[] b)
    {
        long lid = 
                ((long)(b[0]&0xFF) << 56)+
                ((long)(b[1]&0xFF) << 48)+
                ((long)(b[2]&0xFF) << 40)+
                ((long)(b[3]&0xFF) << 32)+
                ((long)(b[4]&0xFF) << 24)+
                ((long)(b[5]&0xFF) << 16)+
                ((long)(b[6]&0xFF) << 8)+
                ((long) b[7]&0xFF);
        return lid;
    }
    
    public static String byteArrayToLongString(byte[] b)
    {
        
        String lid = stringFrontZeroAppend(Integer.toHexString(b[0]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[1]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[2]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[3]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[4]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[5]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[6]&0xFF),2)+
                     stringFrontZeroAppend(Integer.toHexString(b[7]&0xFF),2);
        return lid;
    }
    
    public static String stringFromByteArray(byte[] b, int start, int size)
    {
        byte[] nb = new byte[size];
        System.arraycopy(b, start, nb, 0, size);
        nb = HydeCrypto.trimByte(nb);
        return new String(nb);
    }
    
    public static String prefixZeroAppend(String str, int len)
    {
        while(str.length() < len)
        {
            str = "0"+str;
        }
        return str;
    }
}
