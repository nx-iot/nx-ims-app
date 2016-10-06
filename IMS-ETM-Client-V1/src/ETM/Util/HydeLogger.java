/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ETM.Util;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Hyde
 */
public class HydeLogger
{
    public Logger logger;

    public HydeLogger(String path)
    {
        logger = Logger.getLogger("err_log");
        FileHandler fh;

        try {

          // This block configure the logger with handler and formatter
          fh = new FileHandler(path, true);
          logger.addHandler(fh);
          logger.setLevel(Level.ALL);
          SimpleFormatter formatter = new SimpleFormatter();
          fh.setFormatter(formatter);
        }
        catch (SecurityException e)
        {
          e.printStackTrace();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
    }

    public void log(String str)
    {
        // the following statement is used to log any messages
        logger.log(Level.WARNING,str);
    }

}
