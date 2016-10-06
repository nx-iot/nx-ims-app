package ETM.MAIN;

import ETM.Util.HydeClock;
import javax.swing.JOptionPane;

public class HydeServerChecker extends HydeClock
{
    private MainFrame MF;

    public HydeServerChecker(MainFrame MF)
    {
        this.MF = MF;
        this.setInterval(10000);
    }

    public boolean reconnectFlag;
    public int reconnectCount;
    public void reconnect()
    {
        if (MF.ACC != null)
        {
            MF.ACC.pauseClock();
        }
        boolean b = MF.HDC.connect(MF.LF.dbParams,true);
        if (!b)
        {
            try
            {
                Thread.sleep(5000);
                reconnectCount++;
                MF.RD.setMessage("Connection Lost, reconnecting...("+reconnectCount+")");
                if (reconnectFlag) reconnect();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {

            if (MF.RD != null)
            {
                MF.RD.dispose();
            }
            if (MF.ACC != null)
            {
               MF.ACC.resumeClock();
           }
        }
    }

    @Override
    public void clockProcess()
    {
        try
        {
            boolean b = MF.HDC.con.isValid(10000);
            if (!b)
            {
                MF.HDC.closeDB();
                reconnectCount = 0;
                reconnectFlag = true;
                ReconnectDialog RD = new ReconnectDialog(MF, "Connection Lost, reconnecting...",false);
                MF.setReconnectDialog(RD);
                reconnect();
                /*int a = JOptionPane.showConfirmDialog(MF, "Communication between server has been lost...", "TMS", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE, null);
                if (a == 0)
                {
                    MF.logout();
                }*/
            }
        }
        catch (Exception e)
        {
            System.out.println("HydeServerChecker/clockProcess : ");
            e.printStackTrace();
        }
    }

}
