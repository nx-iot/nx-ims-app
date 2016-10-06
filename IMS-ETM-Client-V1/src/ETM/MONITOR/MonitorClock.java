package ETM.MONITOR;

import ETM.STRUCTURE.Balloon;
import ETM.Util.HydeClock;
import java.util.Enumeration;

public class MonitorClock extends HydeClock
{
    public MonitorIF MIF;

    public MonitorClock(MonitorIF MIF)
    {
        this.MIF = MIF;
        this.setInterval(660000); // 60000 !!!!
    }

    private void MIFProcess()
    {
        Enumeration enu = MIF.balloonVector.elements();
        while (enu.hasMoreElements())
        {
            Balloon b = (Balloon) enu.nextElement();
            if (b.hasProbe())
            {
                for (int i=0;i<5;i++)
                {
                    String value = MIF.MF.HDC.query0("SELECT probe_data FROM probe WHERE probe_id = '"+b.probe[i]+"';");
                    String value2 = MIF.MF.HDC.query0("SELECT probe_data_timestamp FROM probe WHERE probe_id = '"+b.probe[i]+"';");
                    if (value == null || value.equals("null") || value.equals(""))
                    {
                        b.probeData[i] = "-";
                        b.probeTimeStamp[i] = "-";
                    }
                    else
                    {
                        b.probeData[i] = value;
                        b.probeTimeStamp[i] = value2;
                    }
                }
            }
        }
    }

    @Override
    public void clockProcess()
    {
        //MIFProcess();
        
    }


}
