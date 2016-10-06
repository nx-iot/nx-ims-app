/*
 * HydeDefaultTableModel Module
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.Table;

import javax.swing.table.DefaultTableModel;

public class HydeDefaultTableModel extends DefaultTableModel
{
    public HydeDefaultTableModel()
    {
        super();
    }
    
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }
}