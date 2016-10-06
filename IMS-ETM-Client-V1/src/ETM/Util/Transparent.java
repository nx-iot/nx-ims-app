/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ETM.Util;

/**
 *
 * @author Hyde
 */
import java.awt.*;
import java.awt.image.*;

public class Transparent
{
  public static Image makeColorTransparent (Image im, final Color color)
  {
    ImageFilter filter = new RGBImageFilter()
    {
      public int markerRGB = color.getRGB() | 0xFF000000;

      public final int filterRGB(int x, int y, int rgb)
      {
        if ( ( rgb | 0xFF000000 ) == markerRGB ) 
        {
            //System.out.println("Marker");
          // Mark the alpha bits as zero - transparent
          return 0x00FFFFFF & rgb;
          }
        else {
          // nothing to do
            //System.out.println("Nothing");
          return rgb;
          }
        }
      };

    ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
