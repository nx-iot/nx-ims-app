package HydeModule.HydeSocket.UDP;

import ETM.MAIN.FrameBuffer;
import ETM.MAIN.MainFrame;
import ETM.Util.HydeCrypto;
import HydeModule.Protocol.IMS.IMSClientProtocol;
import HydeModule.Protocol.IMS.IMSProtocolStructure;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.swing.JOptionPane;

public class HydeUDPSocketServer implements Runnable
{

    public boolean accept;
    public boolean retryFlag;
    public boolean serverFlag;
    public boolean actionFlag;

    public String threadIndex;

    public DatagramSocket serverSocket;
    public MainFrame MF;
    
    private boolean debug;

    public HydeUDPSocketServer(DatagramSocket socket, MainFrame MF)
    {
        this.serverSocket = socket;
        this.MF = MF;
        this.debug = MainFrame.debug;
        
        accept = false;
        retryFlag = true;
        serverFlag = true;
        actionFlag = false;
    }

    @Override
    public void run()
    {
        boolean start = true;
        threadIndex = Thread.currentThread().getName();
        /*byte[] bb = hexStringToByteArray("7E00081B01C0A80B0A300036");
        processData(bb);*/
        while (retryFlag)
        {
            if (debug) System.out.println("Open UDP Server ("+threadIndex+")...\n");
            try
            {
                serverFlag = true;
                byte[] receiveData = new byte[1024];
                //byte[] sendData = new byte[1024];

                while (serverFlag)
                {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    String ip = MF.SD.computerIP;
                    int port = 0;
                    if (!receivePacket.getAddress().getHostAddress().equals("127.0.0.1"))
                    {
                        ip = receivePacket.getAddress().getHostAddress();
                        port = receivePacket.getPort();
                    }
                    try
                    {
                        processData(receivePacket.getData(),ip,port);
                    }
                    catch (NullPointerException e)
                    {
                        if (debug) System.out.println("Frame Controller not found !! ("+ip+")");
                        e.printStackTrace();
                    }
                    //sendUDP("TEST", receivePacket.getAddress(), receivePacket.getPort());
                }
            }
            catch (SocketException e)
            {
                if (debug) System.out.println("SOCKET CLOSED");
                endConnection();
            }
            catch (Exception e)
            {
                if (debug) e.printStackTrace();
                if (debug) System.out.println("HydeSocketServer/run : error : \n" + e);
                endConnection();
            }
        }
    }

    public void stopServer()
    {
        endConnection();
    }
    
    private void processData(byte[] input, String ip, int port) throws NullPointerException
    {
        if (debug) 
        {
            System.out.print("RECEIVE <<<< ");
            byte[] input2 = HydeCrypto.trimByte(input,(input[2]&0xFF)+3);
            for (int i=0;i<input2.length;i++) System.out.print(Integer.toHexString(input2[i]&0xFF)+" ");
            System.out.println("...");
        }
        byte[] data = IMSClientProtocol.process(input);
        if (data != null)
        {
            IMSProtocolStructure IPS = IMSClientProtocol.processType(data);
            IPS.setIP(ip);
            IPS.setPort(port);
            String nid = IPS.getNIDString();
            boolean b = MF.FC.checkBufferIP(nid, ip, port);
            FrameBuffer FB = MF.FC.findBufferByID(nid,ip,port);
            
            if (IPS.getFrameType() == IMSClientProtocol.EVENT_TRIGGER_CMD)
            {
                if (!FB.checkReceivedHistoryAvailable(IPS.getFrameID()))
                {
                    if (IPS.getTriggerDirection() == 0) // fix
                    {
                        //MF.stopAlarm(IPS.getAlarmID()+"");
                        MF.refreshAllAlarm();
                    }
                    else
                    {
                        if (IPS.getAlarmID() != 0)
                        {
                            String aid = IPS.getAlarmID()+"";
                            MF.refreshAllAlarm();
                            MF.popUpError(aid, false);
                        }
                    }
                }
                else if (debug) System.out.println("DUPLICATE PACKET !! "+IPS.getFrameID());
                IPS.setFrameType(IMSClientProtocol.EVENT_TRIGGER_ACK);
                IPS.setAckType(true);
                FB.addFrame(IPS,IPS.getFrameID());
            }
            
            ///////////////////////// ACK COMMAND /////////////////////////
            else if (IPS.getFrameType() == IMSClientProtocol.SENSOR_CONFIG_ACK)
            {
                if (IPS.getStat() == 0) 
                {
                    if (IPS.getAccessDirection() == IMSClientProtocol.ACCD_READ) JOptionPane.showMessageDialog(null, "Sensor read complete !");
                    else JOptionPane.showMessageDialog(null, "Sensor configuration complete !");
                    if (MF.DMIF !=null)
                    {
                        if (MF.DMIF.DMP != null) MF.DMIF.DMP.select(); 
                        if (MF.DMIF.DLP != null) MF.DMIF.DLP.select(); 
                    }
                } 
                else 
                {
                    if (IPS.getAccessDirection() == IMSClientProtocol.ACCD_READ) JOptionPane.showMessageDialog(null, "Sensor read fail...");
                    else JOptionPane.showMessageDialog(null, "Sensor configuration fail...");
                } 
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.DEVICE_CONFIG_ACK)
            {
                if (IPS.getStat() == 0)
                {
                    if (IPS.getAccessDirection() == IMSClientProtocol.ACCD_READ) JOptionPane.showMessageDialog(null, "Device read complete !");
                    else JOptionPane.showMessageDialog(null, "Device configuration complete !");
                    if (MF.DMIF !=null)
                    {
                        if (MF.DMIF.DMP != null) MF.DMIF.DMP.select(); 
                        if (MF.DMIF.DLP != null) MF.DMIF.DLP.select(); 
                    }
                }
                else
                {
                    if (IPS.getAccessDirection() == IMSClientProtocol.ACCD_READ) JOptionPane.showMessageDialog(null, "Device read fail...");
                    else JOptionPane.showMessageDialog(null, "Device configuration fail...");
                }
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.REMOTE_CONTROL_ACK)
            {
                if (IPS.getStat() == 0)
                {
                    if (IPS.getRemoteType() == 0x10)
                    {
                        JOptionPane.showMessageDialog(null, "Device muted");
                    }
                }
                else
                {
                    if (IPS.getRemoteType() == 0x10)
                    {
                        JOptionPane.showMessageDialog(null, "Mute device alarm fail...");
                    }
                }
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.REMOVE_DEVICE_ACK)
            {
                if (IPS.getStat() == 0)
                {
                    JOptionPane.showMessageDialog(null, "Device has been removed...");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Remove device fail...");
                }
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.MANAGEMENT_ACK)
            {
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.EVENT_TRIGGER_ACK)
            {
                FB.moveToSentHistory(IPS.getFrameID());
            }
            else if (IPS.getFrameType() == IMSClientProtocol.ERROR_ACK)
            {
                if (debug) System.out.println("GOT ERROR ACK !!!!");
                FB.moveToSentHistory(IPS.getFrameID());
            }
            if (debug) System.out.println("RECEIVE OK");
        }
        else
        {
            if (debug) System.out.println("CHECKSUM FAILLLLLLLLLLLLLLLLLLLLLLL");
        }
    }

    public void endConnection()
    {
        try
        {
            accept = false;
            retryFlag = false;
            serverFlag = false;
            //if (serverSocket != null) serverSocket.close();
            
            if (debug) System.out.println("Connection("+threadIndex+") : END CONNECTION ");
            //if (server != null) server.close();
        }
        catch (Exception e)
        {
            if (debug) System.out.println("HydeUDPSocketServer/endConnection()  \n" + e);
        }
    }
}
