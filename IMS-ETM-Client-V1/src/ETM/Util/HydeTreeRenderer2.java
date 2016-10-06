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

public class HydeTreeRenderer2 extends DefaultTreeCellRenderer
{
    ImageIcon group;

    public HydeTreeRenderer2()
    {        
        group = new ImageIcon(getClass().getResource("/Picz/Other/chip_16.png"));
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel,boolean expanded,boolean leaf, int row,boolean hasFocus)
    {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        Object nodeObj = ((DefaultMutableTreeNode)value).getUserObject();

        String nodeName = value.toString();
        if ( nodeName != null && row > 0)
        {
            setIcon(group);
        }
        return this;
    }
}
