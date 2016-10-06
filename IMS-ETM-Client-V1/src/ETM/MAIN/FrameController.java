package ETM.MAIN;

import HydeModule.HydeSocket.UDP.HydeUDPSocketSender;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Hyde
 */
public class FrameController implements Runnable
{
    public Vector<FrameBuffer> bufferControl;
    public byte frameCount;
    
    public boolean retryFlag;
    
    private int sleepTime;
    private MainFrame MF;
    
    private int localPort;
    
    public FrameController(MainFrame MF)
    {
        this.MF = MF;
        this.localPort = MF.SD.APPLICATION_PORT;
        retryFlag = true;
        frameCount = 1;
        bufferControl = new Vector();
        
        sleepTime = 60000;
    }
    
    public Vector<Vector> getFrameInfo()
    {
        Vector all = new Vector();
        Enumeration enu = bufferControl.elements();
        while (enu.hasMoreElements())
        {
            FrameBuffer FB = (FrameBuffer) enu.nextElement();
            if (FB.getFrameSize() > 0)
            {
                Enumeration fenu = FB.frameElements.elements();
                while (fenu.hasMoreElements())
                {
                    Vector v = new Vector();
                    IMSProtocolStructure IPS = (IMSProtocolStructure) fenu.nextElement();
                    v.add(FB.id);
                    v.add(IPS.getFrameID());
                    v.add(IPS.getFrameType());
                    all.add(v);
                }
            }
        }
        return all;
    }
    
    public byte getFrameCount()
    {
        return frameCount;
    }
    
    public void addFrameBuffer(FrameBuffer fb)
    {
        synchronized(this)
        {
            bufferControl.add(fb);
        }
    }
    
    public boolean checkBufferIP(String id, String ip, int port)
    {
        Enumeration enu = bufferControl.elements();
        while (enu.hasMoreElements())
        {
            FrameBuffer FB = (FrameBuffer) enu.nextElement();
            if (FB.id != null && FB.id.equals(id))
            {
                if (!FB.ip.equals(ip))
                {
                    FB.ip = ip;
                    FB.port = port;
                    return false;
                }
                else if (FB.port != port)
                {
                    FB.port = port;
                    return false;
                }
            }
        }
        return true;
    }
    
    public FrameBuffer findBufferByID(String id, String ip, int port)
    {
        Enumeration enu = bufferControl.elements();
        while (enu.hasMoreElements())
        {
            FrameBuffer FB = (FrameBuffer) enu.nextElement();
            if (FB.id != null && FB.id.equals(id))
            {
                return FB;
            }
        }
        if (MainFrame.debug) System.out.println("Not found frame buffer for ID = "+id+"...\nCreate new frame buffer !");
        FrameBuffer FB = new FrameBuffer(id, ip, port, MF.SD.serialNumber);
        addFrameBuffer(FB);
        return FB;
    }

    boolean sending = false;
    public void run() 
    {
        while (retryFlag)
        {
            sending = false;
            if (bufferControl.size() > 0)
            {
                Enumeration enu = bufferControl.elements();
                while (enu.hasMoreElements())
                {
                    FrameBuffer FB = (FrameBuffer) enu.nextElement();
                    if (FB.getFrameSize() > 0)
                    {
                        sending = true;
                        try
                        {
                            Enumeration bufferEnu = FB.frameElements.elements();
                            while(bufferEnu.hasMoreElements())
                            {
                                long now = new Date().getTime();
                                IMSProtocolStructure IPS = (IMSProtocolStructure) bufferEnu.nextElement();
                                if (!IPS.isSent())
                                {
                                    IPS.prepareSend();
                                          //  System.out.println("SEND "+FB.ip+" - "+FB.port);
                                    new Thread
                                    (
                                        new HydeUDPSocketSender(FB.ip, FB.port, MF.UDPserver, IMSClientProtocol.createPacket(IPS))
                                    ).start();

                                    if (IPS.getAckType()) 
                                    {
                                        FB.moveToSentHistory(IPS.getFrameID());
                                    }
                                }
                                else if (IPS.getSentTimestamp() != 0 && (now - IPS.getSentTimestamp()) > 40000L)
                                {
                                    IPS.retransmit();
                                    if (IPS.getRetransmitCount() > 2) 
                                    {
                                        
                                        if (IPS.getFrameType() == IMSClientProtocol.DEVICE_CONFIG_CMD ||
                                            IPS.getFrameType() == IMSClientProtocol.SENSOR_CONFIG_CMD)
                                        {
                                            MF.showMessage("No configuration response from system (Device ID : "+IPS.getDeviceID()+")...\n"
                                                    + "Please check the device network status in 'Devices > Device List'\n" );
                                            //FB.moveToSentHistory(IPS.getFrameID());
                                        }
                                        FB.moveToSentHistory(IPS.getFrameID());
                                    }
                                }
                            }
                        }
                        catch (Exception ee)
                        {
                            if (MainFrame.debug) System.out.println("FRAME CONTROLLER ERROR");
                            if (MainFrame.debug) ee.printStackTrace();
                        }
                    }
                }
                sleepTime = 50;
            }
            else
            {
                sleepTime = 500;
            }
            MF.setSending(sending);
            if (!sending)
            {
                sleepTime = 500;
            }
            try {Thread.sleep(sleepTime);}
            catch (Exception e){}
        }
    }
    
    public void terminate()
    {
        retryFlag = false;
    }
}
