/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MONITOR;

import ETM.MONITOR.PANEL.*;
import ETM.Util.HydeDatabaseConnector;
import java.util.Vector;
import javax.swing.JDialog;

/**
 *
 * @author Hyde
 */
public class QueryThread implements Runnable
{
    private String sql;
    private HydeDatabaseConnector HDC;
    private GraphDisplayPanel GDP;
    private TableDisplayPanel TDP;
    public JDialog LD;
    private int mode;
    
    public QueryThread(String sql, HydeDatabaseConnector HDC,GraphDisplayPanel GDP)
    {
        mode = 0;
        this.sql = sql;
        this.HDC = HDC;
        this.GDP = GDP;
    }
    
    public QueryThread(String sql, HydeDatabaseConnector HDC,TableDisplayPanel TDP)
    {
        mode = 1;
        this.sql = sql;
        this.HDC = HDC;
        this.TDP = TDP;
    }
    
    QueryDialogDelay QDD;
    Thread QDDT;
    public void setLoadingScreen(JDialog LD)
    {
        this.LD = LD;
        if (LD != null)
        {
            LD.setLocationRelativeTo(null);
            LD.setAlwaysOnTop(true);
            LD.setModal(true);
            LD.setVisible(true);
        }
    }
    
    public void run()
    {
        /*QDD = new QueryDialogDelay(LD);
        QDDT = new Thread(QDD);
        QDDT.start();*/
        Vector<Vector> dataSet;
        dataSet = HDC.queryAll(sql);
        //QDD.stopClock();
        if (LD != null)
        {
            LD.setModal(false);
            LD.dispose();
        }
        switch(mode)
        {
            case 0:GDP.returnedDataSet(dataSet);
                break;
            case 1:TDP.returnedDataSet(dataSet);
                break;
        }
    }
}
