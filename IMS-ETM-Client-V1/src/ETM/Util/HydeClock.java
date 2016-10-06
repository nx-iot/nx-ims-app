/*
 * HydeClock Module
 *  Version 1.61 (21/09/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import java.util.*;
import java.text.*;
import javax.swing.JLabel;

public abstract class HydeClock implements Runnable
{
    private Date date;
    private DecimalFormat DF;
    private String clock;
    private String[] day = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    private JLabel clockLabel;
    private boolean clockLabelFlag = false;

    private long interval;
    private boolean running = true;
    private boolean pause = false;

    public static int PROCESS_FIRST = 0;
    public static int INTERVAL_FIRST = 1;

    private int first;

    public HydeClock()
    {
        first = PROCESS_FIRST;
        interval = 1000;
        DF = new DecimalFormat("#00.###");
        DF.setDecimalSeparatorAlwaysShown(false);
    }

    public void setFirst(int process_or_interval_first)
    {
        first = process_or_interval_first;
    }

    public void enableClockLabel(JLabel jl)
    {
        clockLabel = jl;
        clockLabelFlag = true;
    }

    public void setInterval(long interval)
    {
        this.interval = interval;
    }

    public void stopClock()
    {
        running = false;
    }

    public void pauseClock()
    {
        pause = true;
    }

    public void resumeClock()
    {
        pause = false;
    }

    public void run()
    {
        while (running)
        {
            if (clockLabelFlag)
            {
                date = new Date();
                clock =	  DF.format(date.getHours())	+ ":"
                            + DF.format(date.getMinutes())	+ ":"
                            + DF.format(date.getSeconds())	+ " "
                            + day[date.getDay()]            + " "
                            + date.getDate()                + " "
                            + month[date.getMonth()]        + " "
                            + (date.getYear() + 1900)       ;
                clockLabel.setText(clock);
            }
            if (!pause && first == PROCESS_FIRST) clockProcess();
            try { Thread.sleep(interval);}
            catch (Exception e)
            {
                System.out.println("Error : HC TimerThread \n" + e + "\n");
                running = false;
            }
            if (!pause && first == INTERVAL_FIRST) clockProcess();
        }
    }

    public abstract void clockProcess();
}
