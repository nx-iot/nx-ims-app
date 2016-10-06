/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MONITOR;

import ETM.Util.HydeClock;
import java.util.Date;
import javax.swing.JDialog;

/**
 *
 * @author Hyde
 */
public class QueryDialogDelay extends HydeClock
{
    private JDialog LD;
    private Date create;
    private int timer;
    
    public QueryDialogDelay(JDialog LD)
    {
        setInterval(100);
        setFirst(INTERVAL_FIRST);
        
        this.LD = LD;
        create = new Date();
        
    }

    @Override
    public void clockProcess() 
    {
       timer++;
       if (timer == 15)
       {
           ((QueryDialog) LD).cancelButton.setEnabled(true);
       }
    }
    
}
