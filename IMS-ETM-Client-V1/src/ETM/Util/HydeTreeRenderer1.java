/*
 * HydeTreeRenderer Module
 *  Version 1.0 (01/05/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class HydeTreeRenderer1 extends DefaultTreeCellRenderer
{
    private ImageIcon transmitterOn;
    private ImageIcon transmitterOff;
    private ImageIcon transmitterNA;
    private ImageIcon repeater;
    private ImageIcon probe;
    private ImageIcon baseOn;
    private ImageIcon baseOff;
    private ImageIcon baseNA;

    public HydeTreeRenderer1()
    {        
        transmitterOn = new ImageIcon(getClass().getResource("/Picz/TreeIcon/transmitter_on_1.png"));
        transmitterOff = new ImageIcon(getClass().getResource("/Picz/TreeIcon/transmitter_off_1.png"));
        transmitterNA = new ImageIcon(getClass().getResource("/Picz/TreeIcon/transmitter_na_1.png"));
        repeater = new ImageIcon(getClass().getResource("/Picz/TreeIcon/repeater_1.png"));
        probe = new ImageIcon(getClass().getResource("/Picz/TreeIcon/probe_16.png"));
        baseOn = new ImageIcon(getClass().getResource("/Picz/TreeIcon/base_on_1.png"));
        baseOff = new ImageIcon(getClass().getResource("/Picz/TreeIcon/base_off_1.png"));
        baseNA = new ImageIcon(getClass().getResource("/Picz/TreeIcon/base_na_1.png"));
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel,boolean expanded,boolean leaf, int row,boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        Object nodeObj = ((DefaultMutableTreeNode)value).getUserObject();

        String nodeName = value.toString();
        if ( nodeName != null )
        {
            if ( nodeName.indexOf("[R]") == 0)
            {
                setIcon(repeater);
            }
            else if(nodeName.indexOf("[P]") == 0 || nodeName.indexOf("[CH") == 0)
            {
                setIcon(probe);
            }

            if ( nodeName.lastIndexOf("<ON>") == nodeName.length()-4)
            {
                this.setForeground(new Color(0,150,0));
                if ( nodeName.indexOf("[B]") == 0)
                {
                    setIcon(baseOn);
                }
                else if ( nodeName.indexOf("[T]") == 0 || nodeName.indexOf("[E]") == 0)
                {
                    setIcon(transmitterOn);
                }
            }
            else if ( nodeName.lastIndexOf("<OFF>") == nodeName.length()-5)
            {
                this.setForeground(new Color(200,0,0));
                if ( nodeName.indexOf("[B]") == 0)
                {
                    setIcon(baseOff);
                }
                else if ( nodeName.indexOf("[T]") == 0 || nodeName.indexOf("[E]") == 0)
                {
                    setIcon(transmitterOff);
                }
            }
            else if ( nodeName.lastIndexOf("<ERR>") == nodeName.length()-5)
            {
                this.setForeground(new Color(200,150,0));
                if ( nodeName.indexOf("[B]") == 0)
                {
                    setIcon(baseOn);
                }
                else if ( nodeName.indexOf("[T]") == 0)
                {
                    setIcon(transmitterOn);
                }
            }
            else if ( nodeName.lastIndexOf("<N/A>") == nodeName.length()-5)
            {
                this.setForeground(new Color(100,100,100));
                if ( nodeName.indexOf("[B]") == 0)
                {
                    setIcon(baseNA);
                }
                else if ( nodeName.indexOf("[T]") == 0 || nodeName.indexOf("[E]") == 0)
                {
                    setIcon(transmitterNA);
                }
            }
        }
        return this;
    }
}
