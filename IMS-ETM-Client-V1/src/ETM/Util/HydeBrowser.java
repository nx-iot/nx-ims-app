/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ETM.Util;

import javax.swing.JOptionPane;

/**
 *
 * @author Hyde
 */
public class HydeBrowser
{
    public static void launchWeb(String web)
    {
        java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        if( !desktop.isSupported( java.awt.Desktop.Action.BROWSE ) )
        {
            System.err.println( "Desktop doesn't support the browse action (fatal)" );
        }
        try
        {
            java.net.URI uri = new java.net.URI( web );
            desktop.browse( uri );
        }
        catch ( Exception ee )
        {

        }
    }

}
