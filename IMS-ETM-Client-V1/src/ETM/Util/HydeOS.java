/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.Util;

/**
 *
 * @author Hyde
 */
public class HydeOS 
{
    public static boolean isWindows() 
    {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("win") >= 0);
    }

    public static boolean isMac() 
    {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("mac") >= 0);
    }

    public static boolean isUnix() 
    {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public static boolean isSolaris() 
    {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("sunos") >= 0);
    }
}
