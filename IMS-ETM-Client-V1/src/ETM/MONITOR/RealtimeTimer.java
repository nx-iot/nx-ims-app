package ETM.MONITOR;

import ETM.MONITOR.PANEL.GraphDisplayPanel;
import ETM.Util.HydeClock;

public class RealtimeTimer extends HydeClock
{
    private GraphDisplayPanel GDP;

    public RealtimeTimer(GraphDisplayPanel GDP)
    {
        this.GDP = GDP;
        this.setInterval(1000);
    }
    
    @Override
    public void clockProcess()
    {
        GDP.addPoint();
    }


}
