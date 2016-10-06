package ETM.MAIN;

import HydeModule.File.HydeFileConfig;
import HydeModule.Protocol.LoadingDialog;
import HydeModule.Table.HydeDataSet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.imageio.ImageIO;


public class FloorPlanDownloader implements Runnable
{
    private Vector floorPlan;
    private LoadingDialog LD;
    private String mainPath;
    private String urlImagePath;

    private boolean finish;
    public SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public FloorPlanDownloader(Vector floorPlan, String mainPath, String urlImagePath)
    {
        this.floorPlan = floorPlan;
        this.mainPath = mainPath;
        this.urlImagePath = urlImagePath;
        finish = false;
    }

    public void setLoadingDialog(LoadingDialog LD)
    {
        this.LD = LD;
        if (!finish)
        {
            if (LD != null)
            {
                try
                {
                    LD.setTitle("Downloading...");
                    LD.setLocationRelativeTo(null);
                    LD.setModal(true);
                    LD.setVisible(true);
                }
                catch (Exception e)
                {
                    try
                    {
                        LD.setModal(false);
                        LD.dispose();
                    }
                    catch (Exception ee)
                    {

                    }
                }
            }
        }
    }

    public void run()
    {
        Date d1;
        try
        {
            d1 = SDF.parse(HydeFileConfig.readConfig(mainPath+"conf.ini", "other", "last_update_floorplan"));
        }
        catch (Exception e)
        {
            d1 = new Date();
        }
        HydeDataSet HDS = new HydeDataSet(floorPlan);
        Enumeration enu = HDS.getRowVector().elements();
        int count = 0;
        while(enu.hasMoreElements())
        {
            Vector v = (Vector) enu.nextElement();
            String fpid = (String) v.elementAt(0);
            String lastupdate = (String) v.elementAt(1);
            //lastupdate = lastupdate.substring(0,lastupdate.length()-2);
            try
            {
                Date d2 = SDF.parse(lastupdate);
                File f = new File(mainPath+"/floorplan/"+fpid+"_1.jpg");
                if (!f.exists() || d2.getTime() > d1.getTime())
                {
                    if (LD != null) 
                    {
                        LD.setMessage("Loading " + fpid + "_1.jpg ...");
                        LD.progressBar.setValue( count*100/(floorPlan.size()*3) );
                    }
                    URL url = new URL(urlImagePath+"/image/floorplan/"+fpid+"_1.jpg");
                    URLConnection urlc = url.openConnection();
                    urlc.setConnectTimeout(10000);
                    urlc.setReadTimeout(10000);
                    BufferedImage image1 = ImageIO.read(url);
                    ImageIO.write(image1, "jpg",new File(mainPath+"/floorplan/"+fpid+"_1.jpg"));
                }
                count++;
                File f2 = new File(mainPath+"/floorplan/"+fpid+"_2.jpg");
                if (!f2.exists() || d2.getTime() > d1.getTime())
                {
                    if (LD != null)
                    {
                        LD.setMessage("Loading " + fpid + "_2.jpg ...");
                        LD.progressBar.setValue( count*100/(floorPlan.size()*3) );
                    }

                    URL url = new URL(urlImagePath+"/image/floorplan/"+fpid+"_2.jpg");
                    URLConnection urlc = url.openConnection();
                    urlc.setConnectTimeout(10000);
                    urlc.setReadTimeout(10000);
                    BufferedImage image1 = ImageIO.read(url);
                    ImageIO.write(image1, "jpg",new File(mainPath+"/floorplan/"+fpid+"_2.jpg"));
                }
                count++;
                File f4 = new File(mainPath+"/floorplan/"+fpid+"_4.jpg");
                if (!f4.exists() || d2.getTime() > d1.getTime())
                {
                    if (LD != null)
                    {
                        LD.setMessage("Loading " + fpid + "_4.jpg ...");
                        LD.progressBar.setValue( count*100/(floorPlan.size()*3) );
                    }
                    URL url = new URL(urlImagePath+"/image/floorplan/"+fpid+"_4.jpg");
                    URLConnection urlc = url.openConnection();
                    urlc.setConnectTimeout(10000);
                    urlc.setReadTimeout(10000);
                    BufferedImage image1 = ImageIO.read(url);
                    ImageIO.write(image1, "jpg",new File(mainPath+"/floorplan/"+fpid+"_4.jpg"));
                }
                count++;
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        finish = true;
        while (LD == null)
        {
            try
            {
                Thread.sleep(100);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        if (LD != null)
        {
            LD.setModal(false);
            LD.dispose();
        }

        Date d3 = new Date();
        HydeFileConfig.writeConfig(mainPath+"conf.ini", "other", "last_update_floorplan", SDF.format(d3));
    }

}
