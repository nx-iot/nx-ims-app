/*
 * HydeResizeImage Module
 *  Version 1.0 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.Image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class HydeResizeImage
{
    public static BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight, boolean preserveAlpha)
    {
        int imageType = BufferedImage.TYPE_INT_RGB;//preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if (preserveAlpha)
        {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    public static BufferedImage createResizedCopyWidthPrior(Image originalImage, int scaledWidth, boolean preserveAlpha)
    {
        int imageType = BufferedImage.TYPE_INT_RGB;//preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        int owidth = originalImage.getWidth(null);
        int oheight = originalImage.getHeight(null);
        double widthRatio = (double)owidth/(double)scaledWidth;
        int scaledHeight = 0;
        if (widthRatio > 0)
        {
            scaledHeight = (int) ((double)oheight / widthRatio);
        }
        else
        {
            scaledHeight = scaledWidth*2;
        }
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if (preserveAlpha)
        {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }

    public static BufferedImage createResizedCopyHeightPrior(Image originalImage, int scaledHeight, boolean preserveAlpha)
    {
        int imageType = BufferedImage.TYPE_INT_RGB;//preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        int owidth = originalImage.getWidth(null);
        int oheight = originalImage.getHeight(null);
        double heightRatio = (double)oheight/(double)scaledHeight;
        int scaledWidth = 0;
        if (heightRatio > 0)
        {
            scaledWidth = (int) ((double)owidth / heightRatio);
        }
        else
        {
            scaledWidth = scaledHeight*2;
        }
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if (preserveAlpha)
        {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g.dispose();
        return scaledBI;
    }
    

    /* Usage
     *
     *  ImageIcon II = new javax.swing.ImageIcon(getClass().getResource("/Picz/actPlan.jpg"));
     *  BufferedImage BI = HydeResizeImage.createResizedCopy(II.getImage(), d.width, d.height, false);
     *  mapLabel.setIcon(new ImageIcon(BI));
     *
     */
    
}
