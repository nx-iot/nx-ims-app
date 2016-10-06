
package ETM.MAIN;

import ETM.Util.HydeClock;

public class UpdateAliveClock extends HydeClock
{
    private MainFrame MF;
    private int currentSize = 0;


    public UpdateAliveClock(MainFrame MF)
    {
        this.MF = MF;
        setInterval(180000);
    }

    @Override
    public void clockProcess()
    {
        boolean b = MF.LF.recordComputerProperties();
        if (!b)
        {
            MF.logout();
        }
        //MF.refreshAllAlarm();
    }
}
