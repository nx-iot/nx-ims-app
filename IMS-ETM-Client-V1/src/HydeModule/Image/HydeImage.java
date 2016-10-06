/*
 * HydeImage Module
 *  Version 1.0 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.Image;

import HydeModule.File.HydeFileFilter;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HydeImage
{
    private String selectedImagePath;
    private String img;
    private String suffix;
    private String imageName;

    public BufferedImage toBufferedImage(Image src)
    {
        int w = src.getWidth(null);
        int h = src.getHeight(null);
        int type = BufferedImage.TYPE_INT_RGB;  // other options
        BufferedImage dest = new BufferedImage(w, h, type);
        Graphics2D g2 = dest.createGraphics();
        g2.drawImage(src, 0, 0, null);
        g2.dispose();
        return dest;
    }

    public void imageFileToFile(String imageSource, String fileName)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File(imageSource));
            ImageIO.write(image, "jpg",new File(fileName));
            Thread.sleep(300);
        }
        catch (Exception e)
        {

        }
    }

    public void imageToFile(Image img, String fileName)
    {
        try
        {
            BufferedImage image = toBufferedImage(img);
            ImageIO.write(image, "jpg",new File(fileName));
            Thread.sleep(300);
        }
        catch (Exception e)
        {

        }
    }

    public void imageURLToFile(String url, String fileName)
    {
        try
        {
            URL imageURL = new URL(url);
            BufferedImage image = ImageIO.read(imageURL);
            ImageIO.write(image, "jpg",new File(fileName));
            Thread.sleep(300);
        }
        catch (Exception e)
        {

        }
    }

    public Dimension getImageFileDimension(String src)
    {
        File F = new File(src);
        if (F.exists())
        {
            ImageIcon II = new javax.swing.ImageIcon(src);
            return new Dimension(II.getIconWidth(),II.getIconHeight());
        }
        else
        {
            return null;
        }
    }

    public boolean resizeImageFileToFile(String src, String fileName, int width, int height)
    {
        File F = new File(src);
        if (F.exists())
        {
            try
            {
                ImageIcon II = new javax.swing.ImageIcon(src);
                BufferedImage BI = HydeResizeImage.createResizedCopy(II.getImage(), width, height, false);
                ImageIO.write(BI, "jpg",new File(fileName));
                Thread.sleep(300);
                return true;
            }
            catch (Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }


    public static final int NO_PRIORITY = 0;
    public static final int HEIGHT_PRIORITY = 1;
    public static final int WIDTH_PRIORITY = 2;
    public static final int NO_SCALED = 3;
    public void setImageFromUrl(String url, JLabel picLabel, JPanel picPanel, int width, int height, int mode)
    {
        try
        {
            URL targetURL = new URL(url);
            setLoading(picLabel, picPanel);
            HydeLoadImageThread HLIT = null;
            switch (mode)
            {
                case HEIGHT_PRIORITY:
                    HLIT = new HydeLoadImageThread(url, picLabel, picPanel, width, height, HEIGHT_PRIORITY);
                    break;
                case WIDTH_PRIORITY:
                    HLIT = new HydeLoadImageThread(url, picLabel, picPanel, width, height, WIDTH_PRIORITY);
                    break;
                case NO_SCALED:
                    HLIT = new HydeLoadImageThread(url, picLabel, picPanel, width, height, NO_SCALED);
                    break;
                default:
                    HLIT = new HydeLoadImageThread(url, picLabel, picPanel, width, height);
                    break;
            }
            
            new Thread(HLIT).start();
        }
        catch (MalformedURLException e)
        {
             e.printStackTrace();
             setImage(picLabel, picPanel);
        }
    }

    public void setImage(String src, JLabel picLabel, JPanel picPanel, int width, int height, int mode)
    {
        try
        {
            File F = new File(src);
            if (F.exists())
            {
                ImageIcon II = new javax.swing.ImageIcon(src);
                BufferedImage BI = null;
                switch (mode)
                {
                    case HEIGHT_PRIORITY:
                        BI = HydeResizeImage.createResizedCopyHeightPrior(II.getImage(), height, false);
                        break;
                    case WIDTH_PRIORITY:
                        BI = HydeResizeImage.createResizedCopyWidthPrior(II.getImage(), width, false);
                        break;
                    default:
                        BI = HydeResizeImage.createResizedCopy(II.getImage(), width, height, false);
                        break;
                }
                picLabel.setIcon(new ImageIcon(BI));
                picPanel.validate();
            }
            else
            {
                setImage(picLabel, picPanel);
            }
        }
        catch (Exception e)
        {
            setImage(picLabel, picPanel);
        }
    }

    public void setLoading(JLabel picLabel, JPanel picPanel)
    {
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HydeModule/Image/loading_mini.gif")));
        picPanel.validate();
    }

    public void setImage(JLabel picLabel, JPanel picPanel)
    {
        picLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/HydeModule/Image/missing.png")));
        picPanel.validate();
    }

    public String browseImage(Component comp, String newName)
    {
        JFileChooser jFC = new JFileChooser();
        jFC.setFileFilter(new HydeFileFilter(HydeFileFilter.IMAGE_TYPE));
        int returnVal = jFC.showOpenDialog(comp);
        if (returnVal == jFC.APPROVE_OPTION)
        {
            selectedImagePath = jFC.getSelectedFile().getAbsolutePath();
            //img = (jFC.getSelectedFile().getName());
            //setImageName(img, newName);
            return selectedImagePath;
        }
        return "";
    }

    public void setImageName(String imageWithSuffix, String newName)
    {
        /*suffix = ".jpg";
        if (imageWithSuffix.length() - imageWithSuffix.lastIndexOf("png") == 3 )
        {
            suffix = ".png";
        }
        imageName = newName+suffix;*/
        imageName = newName+".jpg";
    }

    public String getImageName(String fullPath)
    {
        if (fullPath == null || fullPath.length() == 0)
        {
            return "";
        }
        return fullPath.substring(fullPath.lastIndexOf("/")+1,fullPath.length());
    }
}
