/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HydeModule.HydeSocket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Hyde
 */
public class HydeUDPSocketSender implements Runnable
{
    String destIP;
    int port;
    byte[] data;
    DatagramSocket udpSocket;
    
    public HydeUDPSocketSender(String destIP, int destport, DatagramSocket udpSocket, byte[] data)
    {
        this.destIP = destIP;
        this.port = destport;
        this.udpSocket = udpSocket;
        this.data = data;
    }
    
    public void send()
    {
        try
        {
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getByName(destIP), port);
            sendPacket.setPort(port);
            
            //sendPacket.setAddress(InetAddress.getLocalHost());
            //DatagramSocket clientSocket = new DatagramSocket();
            udpSocket.send(sendPacket);
            
            System.out.print(InetAddress.getByName(destIP)+":"+port+" >>> ");
            for (int i=0;i<data.length;i++)
            {
                System.out.print(Integer.toHexString(data[i]&0xFF)+" ");
            }
            System.out.println("...");
        }
        catch (IOException e)
        {
            System.out.println("HydeUDPSocketClient/sendUDP : error : \n"+e);
        }
    }
    
    public static byte[] hexStringToByteArray(String s) 
    {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) 
        {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public void run() 
    {
        send();
    }
}
