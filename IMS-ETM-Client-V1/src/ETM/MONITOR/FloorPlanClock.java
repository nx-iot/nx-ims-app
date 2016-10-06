package ETM.MONITOR;

import ETM.MONITOR.PANEL.FloorplanEffectPanel;
import ETM.Util.HydeClock;

public class FloorPlanClock extends HydeClock
{
    private FloorplanEffectPanel FEP;

    public FloorPlanClock(FloorplanEffectPanel FEP)
    {
        this.FEP = FEP;
        this.setInterval(100);
    }

    @Override
    public void clockProcess()
    {
        FEP.repaint();
    }

}
