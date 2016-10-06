/*
 * HydeeAudio Module
 *  Version 0.3 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.tools.jar.Main;

public class HydeAudio
{
    public void play(String file) throws IOException
    {
        try
        {
            //FileInputStream in = new FileInputStream(file);
            //AudioStream as = new AudioStream(in);
            //AudioPlayer.player.start(as);
            
        }
        catch (Exception e)
        {
            System.out.println("HydeAudio/play : "+e);
            e.printStackTrace();
        }
    }

    public static synchronized void playSound(final String url)
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                try
                {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(url));
                    clip.open(inputStream);
                    clip.start();
                    Thread.sleep(5000);
                    clip.stop();
                    clip.close();
                    clip = null;
                }
                catch (Exception e)
                {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }
}
