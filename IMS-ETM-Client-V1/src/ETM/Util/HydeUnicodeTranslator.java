/*
 * HydeUnicodeTranslator Module
 *  Version 1.0 (01/11/2010)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

public class HydeUnicodeTranslator
{
    public HydeUnicodeTranslator()
    {
    }
    
    public String toUnicode(String ascii)
    {
	String ss = "";
        int len = ascii.length();
        byte[] b = new byte[len*2];
        for (int i=0;i<len*2;i+=2)
        {
            //b[i] = (byte) (ascii.codePointAt(i/2)/256);
            //b[i+1] = (byte) (ascii.codePointAt(i/2)%256);
            ss += toHexString((byte) (ascii.codePointAt(i/2)/256));
            ss += toHexString((byte) (ascii.codePointAt(i/2)%256));
        }
        return ss;
    }

    public byte[] unicodeToString(String uni)
    {
        try
        {
            int len = uni.length();
            byte[] b = new byte[len/2];
            for (int i=0;i<len;i+=2)
            {
                b[i/2] = (byte)((Integer.parseInt(uni.charAt(i)+"",16)*16) + (Integer.parseInt(uni.charAt(i+1)+"",16)));
            }
            return b;
        }
        catch (Exception e)
        {
            return uni.getBytes();
        }
    }

    public String toHexString(int d)
    {
        String s = (Integer.toHexString(d)).toUpperCase();
        if (s.length() == 1) s = "0"+s;
        return s;
    }

}
