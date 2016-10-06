/*
 * HydeLoadImageThread Module
 *  Version 1.0 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.Image;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HydeLoadImageThread implements Runnable
{
    JLabel picLabel;
    JPanel picPanel;
    String targetURL;
    int imageWidth;
    int imageHeight;
    int prior = 0;

    public static final int NO_PRIORITY = 0;
    public static final int HEIGHT_PRIORITY = 1;
    public static final int WIDTH_PRIORITY = 2;
    public static final int NO_SCALED = 3;

    public HydeLoadImageThread(String targetURL, JLabel picLabel, JPanel picPanel, int imageWidth, int imageHeight)
    {
        this.picLabel = picLabel;
        this.picPanel = picPanel;
        this.targetURL = targetURL;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public HydeLoadImageThread(String targetURL, JLabel picLabel, JPanel picPanel, int imageWidth, int imageHeight, int priorMode)
    {
        this.picLabel = picLabel;
        this.picPanel = picPanel;
        this.targetURL = targetURL;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.prior = priorMode;
    }

    public void run()
    {
        try
        {
            URL uurrll = new URL(targetURL);
            URLConnection urlc = uurrll.openConnection();
            urlc.setConnectTimeout(10000);
            urlc.setReadTimeout(10000);
            Image imgUrl = java.awt.Toolkit.getDefaultToolkit().createImage(uurrll);
            ImageIcon Iics = new ImageIcon(imgUrl);
            BufferedImage BI = null;
            switch (prior)
            {
                case HEIGHT_PRIORITY :
                    BI = HydeResizeImage.createResizedCopyHeightPrior(imgUrl, imageHeight, false);
                    break;
                case WIDTH_PRIORITY :
                    BI = HydeResizeImage.createResizedCopyHeightPrior(imgUrl, imageWidth, false);
                    break;
                case NO_SCALED :
                    picLabel.setIcon(Iics);
                    picPanel.setPreferredSize(new Dimension(Iics.getIconWidth(),Iics.getIconHeight()));
                    picPanel.validate();
                    break;
                default:
                    BI = HydeResizeImage.createResizedCopy(imgUrl, imageWidth, imageHeight, false);
                    break;
            }
            if (prior != NO_SCALED)
            {
                ImageIcon II = new ImageIcon(BI);
                picLabel.setIcon(II);
                //picLabel.setPreferredSize(new Dimension(II.getIconWidth(),II.getIconHeight()));
                picPanel.validate();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
