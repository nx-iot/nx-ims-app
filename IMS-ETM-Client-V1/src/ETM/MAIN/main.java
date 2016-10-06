/*
 * Hyde Peranitti (peranitti@gmail.com)
 * MEST Lab - Intelenics Co.,Ltd.
 *
 */

package ETM.MAIN;

public class main
{
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
                //new TMSFrame().setVisible(true);
            }
        });
    }
}
