/*
 * ScopeDriver Module (Modified by Hyde - From telos demo software)
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.GraphEngine;

import ETM.Util.HydeDatabaseConnector;
import java.util.Hashtable;
import java.awt.geom.*;

public class ScopeDriver
{
    public HydeDatabaseConnector HDC;

    GraphPanel panel;

    static int NUM_READINGS = 10;
    Hashtable t = new Hashtable();

    public boolean ex;
    public int  channeID;
    public String name;

    public ScopeDriver(GraphPanel panel,String name, int channelType)
    {
       // mote = _mote;
        this.panel = panel;
        this.channeID = channelType;
        this.name = name;
        ex = false;
    }

    public String lastUpdate = "2000-01-01 00:00:00";
    public void setLastUpdate(String lastUpdate)
    {
        this.lastUpdate = lastUpdate;
    }
    public String getLastUpdate()
    {
        return lastUpdate;
    }

    public String getID()
    {
        return name;
    }

    public String makeLegendString(String name)
    {
        /*String channelName = "";
        switch (ChannelID)
        {
            case 0  : channelName = "Temperature";  break;
            case 1  : channelName = "Humidity";  break;
            case 2  : channelName = "Light";  break;
            default : channelName = "Unknown";
        }*/
        return name;
    }

    public Channel findChannel(String hydeID, int ChannelID)
    {
        boolean foundPlot = false;
        int i;
        String legend = makeLegendString(hydeID);
        Channel c = (Channel)t.get(legend);
        if (c == null)
        {
            System.out.println("Creating Channel for "+legend);
            c = new Channel();
            c.setGraphPanel(panel);
            c.setDataLegend(legend);
            c.setActive(true);
            //if (panel.getNumChannels() == 0)
            //{
                c.setMaster(true);
            //}
            t.put(legend,c);
            panel.addChannel(c);
        }
        return c;
    }

    public void oscopeClear()
    {
        int channelID = channeID;
        Channel channel = findChannel(name, channelID);
        channel.clear();
    }

    public void setCenterData(String name)
    {
        Channel channel = findChannel(name, channeID);
        channel.setCenterData();
    }

    public long lastPacketNumber;
    public double lastData;
    public int lastYear;
    public void oscopeReceived(String name, long packetNumber, double data)
    {
        boolean foundPlot = false;
        lastPacketNumber = packetNumber;
        lastData = data;
        //lastYear = year;

        int channelID = channeID;
        long packetNum = packetNumber;

        Channel channel = findChannel(name, channelID);
        if (channel.getLastPoint() == -1)
        {
            channel.setLastPoint(packetNum);
        }
        long packetLoss = packetNum - channel.getLastPoint() - NUM_READINGS;
        for(int j = 0; j < packetLoss; j++)
        {
            // Add "NUM_READINGS" blank points for each lost packet
            for(int i = 0; i < NUM_READINGS; i++)
            {
                channel.addPoint(null);
            }
        }
        Point2D newPoint;
        double val = (data)*100;//hmsg.getAmplitude();
        channel.setLastPoint(packetNum);
        //channel.setYear(year);
        newPoint = new Point2D.Double( packetNum, val );
        channel.addPoint(newPoint);
    } 

}