/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MAIN;

import ETM.Util.HydeFormat;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Hyde
 */
public class FrameBuffer 
{
    public Vector<IMSProtocolStructure> frameElements;
    public Vector<IMSProtocolStructure> frameSentHistory;
    public Vector<IMSProtocolStructure> frameReceivedHistory;
    public byte frameCount;
    
    public String id;
    public String ip;
    public int port;
    public boolean waitForACK;
    public String mySerial;
    
    public FrameBuffer(String id, String ip, int port, String mySerial)
    {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.mySerial = mySerial;
        frameCount = 1;
        waitForACK = false;
        frameElements = new Vector();
        frameSentHistory = new Vector();
        frameReceivedHistory = new Vector();
        
        IMSProtocolStructure IPS = new IMSProtocolStructure();
        IPS.setFrameType(IMSClientProtocol.MANAGEMENT_CMD);
        IPS.setManageCMD((byte)0x01);
        addFrame(IPS, (byte)0xFF);
    }
    
    public int getFrameSize()
    {
        return frameElements.size();
    }
    public int getReceivedHistorySize()
    {
        return frameReceivedHistory.size();
    }
    
    public int getSentHistorySize()
    {
        return frameSentHistory.size();
    }
    
    public void addFrame(IMSProtocolStructure IPS)
    {
        byte[] serial = HydeFormat.byteStringToByteArray8(mySerial);
        IPS.setNID(serial,0);
        trimSentHistory();
        synchronized(this)
        {
            int checkID = 0;
            while((checkFrameAvailable(frameCount) || checkSentHistoryAvailable(frameCount)) && checkID < 254)
            {
                frameCount++;
                if (frameCount > 254) frameCount = 1; 
                checkID++;
            }
            IPS.setFrameID(frameCount);
            frameCount++;
            if (frameCount > 254) frameCount = 1; 
            frameElements.add(IPS);
        }
    }
    
    public void addFrame(IMSProtocolStructure IPS, byte frameID)
    {
        byte[] serial = HydeFormat.byteStringToByteArray8(mySerial);
        IPS.setNID(serial,0);
        trimSentHistory();
        synchronized(this)
        {
            IPS.setFrameID(frameID);
            frameElements.add(IPS);
        }
    }
    
    public void trimSentHistory()
    {
        Enumeration enu = frameSentHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            long currentTime = new Date().getTime();
            if (currentTime-IPS.getBornTime()>3600000L)
            {
                synchronized(this)
                {
                    frameSentHistory.remove(IPS);
                }
            }
        }
        while (getSentHistorySize() > 50)
        {
            frameSentHistory.remove(0);
        }
    }
    
    public void trimReceivedHistory()
    {
        Enumeration enu = frameReceivedHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            long currentTime = new Date().getTime();
            if (currentTime-IPS.getBornTime()>3600000L)
            {
                synchronized(this)
                {
                    frameReceivedHistory.remove(IPS);
                }
            }
        }
        while (getReceivedHistorySize() > 50)
        {
            frameReceivedHistory.remove(0);
        }
    }
    
    public void addToReceivedHistory(IMSProtocolStructure IPS)
    {
        trimReceivedHistory();
        frameReceivedHistory.add(IPS);
    }
    
    public void moveToSentHistory(byte frameID)
    {
        trimSentHistory();
        Enumeration enu = frameElements.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                synchronized(this)
                {
                    IPS.retransmit();
                    frameSentHistory.add(IPS);
                    frameElements.remove(IPS);
                }
            }
        }
    }
    
    public void renewSentHistory(byte frameID)
    {
        Enumeration enu = frameSentHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                synchronized(this)
                {
                    IPS.retransmit();
                    frameElements.add(IPS);
                    frameSentHistory.remove(IPS);
                }
            }
        }
    }
    
    public void renewReceivedHistory(byte frameID)
    {
        Enumeration enu = frameReceivedHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                synchronized(this)
                {
                    IPS.retransmit();
                    frameElements.add(IPS);
                    frameReceivedHistory.remove(IPS);
                }
            }
        }
    }
    
    public boolean checkFrameAvailable(byte frameID)
    {
        Enumeration enu = frameElements.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                return true;
            }
        }
        return false;
    }
    
    public IMSProtocolStructure getFrameByID(byte frameID)
    {
        Enumeration enu = frameElements.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                return IPS;
            }
        }
        return null;
    }
    
    public boolean checkSentHistoryAvailable(byte frameID)
    {
        if (frameID == (byte)0xFF)
        {
            return false;
        }
        Enumeration enu = frameSentHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkReceivedHistoryAvailable(byte frameID)
    {
        if (frameID == (byte)0xFF)
        {
            return false;
        }
        Enumeration enu = frameReceivedHistory.elements();
        while (enu.hasMoreElements())
        {
            IMSProtocolStructure IPS = (IMSProtocolStructure) enu.nextElement();
            if (IPS.getFrameID() == frameID)
            {
                return true;
            }
        }
        return false;
    }
    
    public void clearHistory()
    {
        frameSentHistory = new Vector<IMSProtocolStructure>();
        frameReceivedHistory = new Vector<IMSProtocolStructure>();
    }
}
