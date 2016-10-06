/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ETM.DEVICE;

import ETM.Util.HydeDatabaseConnector;
import HydeModule.Table.HydeDataSet;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Hyde
 */
public class DeviceResourceControl
{
    private DeviceManagementIF DMIF;
    private HydeDatabaseConnector HDC;
    private DefaultMutableTreeNode root;

    // Resource for use
    public JTree deviceTree;
    public JTree deviceTree2;
    public JTree deviceTree3;
    
    public int currentPanel;
    public String rootNodeName;
    
    public DeviceResourceControl(DeviceManagementIF DMIF)
    {
        this.DMIF = DMIF;
        this.HDC = DMIF.MF.HDC;
        currentPanel = 0;
        rootNodeName = "Default";
        root = new DefaultMutableTreeNode(rootNodeName);

        deviceTree = new JTree();
        deviceTree.setModel(new DefaultTreeModel(root));
        deviceTree2 = new JTree();
        deviceTree2.setModel(new DefaultTreeModel(root));
        deviceTree3 = new JTree();
        deviceTree3.setModel(new DefaultTreeModel(root));
    }

    /*public void setTree()
    {
        deviceTree = new JTree();
        //deviceTree.setCellRenderer(new HydeTreeRenderer1());
        deviceTree.setModel(dTM);
    }

    */
    
    public Vector catVector;
    public DefaultTreeModel buildDeviceTree(String dpid, String gid, String searchFor)
    {
        String opt = "";
        if (gid != null && gid.length() > 0 && !gid.equals("All"))
        {
            if (gid.equals("No group..."))
            {
                opt += " AND (device_group_id IS NULL OR device_group_id = '') ";
            }
            else
            {
                opt += " AND device_group_id = '"+gid+"' ";
            }
        }
        /*if (dpid != null && dpid.length() > 0 && !dpid.equals("All"))
        {
            opt += " AND depart_id = '"+dpid+"' ";
        }*/
        Vector v = HDC.queryAll("SELECT device_name, equipment_level, device_parent, equipment_probe "
                + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment "
                + "WHERE TRUE "+opt+" "+searchFor+" AND last_config IS NOT NULL "
                + "ORDER BY device_name ASC;");
        int catLevel;
        try
        {
            catLevel = Integer.parseInt(HDC.query0("SELECT MAX(equipment_level) FROM device NATURAL JOIN equipment;"));
        }
        catch (NumberFormatException e)
        {
            catLevel = 0;
        }
        if (v != null)
        {
            //HydeDataSet HDS = new HydeDataSet(v);
            catVector = new Vector();
            root = new DefaultMutableTreeNode(rootNodeName);
            for (int i=1;i<=catLevel;i++)
            {
                Vector subVector = HDC.queryAll("SELECT "
                        + "device_name, equipment_level, device_parent, device_id, equipment_probe, "
                        + "device_link, equipment_id "
                        + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment NATURAL JOIN device_group "
                        + "WHERE equipment_level = '"+i+"' "+opt+" "+searchFor+" AND last_config IS NOT NULL "
                        + "ORDER BY device_name ASC;");
                
                HydeDataSet HDS = new HydeDataSet(subVector);
                Vector row = HDS.getRowVector();
                Enumeration enu = row.elements();
                while(enu.hasMoreElements())
                {
                    Vector data = (Vector) enu.nextElement();
                    String id = (String) data.elementAt(3);
                    int probeAvail = Integer.parseInt((String) data.elementAt(4));
                    
                    String prefix = "";
                    if (data.elementAt(6).equals("1"))
                    {
                        prefix = "[B] ";
                    }
                    else if (data.elementAt(6).equals("2"))
                    {
                        prefix = "[R] ";
                    }
                    else if (data.elementAt(6).equals("3"))
                    {
                        prefix = "[T] ";
                    }
                    else if (data.elementAt(6).equals("5"))
                    {
                        prefix = "[E] ";
                    }
                    String name = prefix+ data.elementAt(0)+" ("+id+") <"+data.elementAt(5)+">";
                    String parent = HDC.query0("SELECT device_name FROM device WHERE device_id = '"+data.elementAt(2)+"' ORDER BY device_name ASC;");
                    DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(name);
                    
                    if (probeAvail > 0)
                    {
                        Vector probes = HDC.queryColumn("SELECT CONCAT('[CH:',channel,'] ',channel_name) FROM device_channel WHERE device_id = '"+id+"' AND channel_enable = '1';");
                        Enumeration probeEnu = probes.elements();
                        while (probeEnu.hasMoreElements())
                        {
                            String probeName = (String) probeEnu.nextElement();
                            dmt.add(new DefaultMutableTreeNode(probeName));
                        }
                    }
                    
                    if (i == 1)
                    {
                        root.add(dmt);
                    }
                    else
                    {
                        Enumeration treeEnu = root.depthFirstEnumeration();
                        while (treeEnu.hasMoreElements())
                        {
                            DefaultMutableTreeNode traversing = (DefaultMutableTreeNode) treeEnu.nextElement();
                            String targetNode = traversing.toString();
                            if (targetNode.equals(parent))
                            {
                                traversing.add(dmt);
                            }
                        }
                    }
                    
                }
            }
        }
        return new DefaultTreeModel(root);
    }
    
    public DefaultTreeModel buildUnknownList()
    {
        Vector v = HDC.queryAll("SELECT device_name, equipment_level, device_parent "
                + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment "
                + "WHERE last_config IS NULL "
                + "ORDER BY device_name ASC;");
        int catLevel;
        try
        {
            catLevel = Integer.parseInt(HDC.query0("SELECT MAX(equipment_level) FROM device NATURAL JOIN equipment;"));
        }
        catch (NumberFormatException e)
        {
            catLevel = 0;
        }
        if (v != null)
        {
            //HydeDataSet HDS = new HydeDataSet(v);
            catVector = new Vector();
            root = new DefaultMutableTreeNode(rootNodeName);
            for (int i=1;i<=catLevel;i++)
            {
                Vector subVector = HDC.queryAll("SELECT "
                        + "device_name, equipment_level, device_parent, device_id, equipment_probe, "
                        + "device_link ,equipment_id "
                        + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment "
                        + "WHERE last_config IS NULL "
                        + "ORDER BY device_name ASC;");
                HydeDataSet HDS = new HydeDataSet(subVector);
                Vector row = HDS.getRowVector();
                Enumeration enu = row.elements();
                while(enu.hasMoreElements())
                {
                    Vector data = (Vector) enu.nextElement();
                    String id = (String) data.elementAt(3);
                    int probeAvail = Integer.parseInt((String) data.elementAt(4));
                    String prefix = "";
                    if (data.elementAt(6).equals("1"))
                    {
                        prefix = "[B] ";
                    }
                    else if (data.elementAt(6).equals("2"))
                    {
                        prefix = "[R] ";
                    }
                    else if (data.elementAt(6).equals("3"))
                    {
                        prefix = "[T] ";
                    }
                    else if (data.elementAt(6).equals("5"))
                    {
                        prefix = "[E] ";
                    }
                    String name = prefix+ data.elementAt(0)+" ("+id+") <"+data.elementAt(5)+">";
                    String parent = HDC.query0("SELECT device_name FROM device WHERE device_id = '"+data.elementAt(2)+"' ORDER BY device_name ASC;");
                    
                    
                    if (i == 1)
                    {
                        root.add(new DefaultMutableTreeNode(name));
                    }
                    else
                    {
                        root.add(new DefaultMutableTreeNode(name));
                    }
                    /*if (probeAvail > 0)
                    {
                        Vector probes = HDC.queryColumn("SELECT CONCAT('[CH:',channel,'] ',channel_name) FROM device_channel WHERE device_id = '"+id+"' AND channel_enable = '1';");
                        Enumeration probeEnu = probes.elements();
                        while (probeEnu.hasMoreElements())
                        {
                            String probeName = (String) probeEnu.nextElement();
                            root.add(new DefaultMutableTreeNode(probeName));
                        }
                    }*/
                }
            }
        }
        return new DefaultTreeModel(root);
    }

    public DefaultTreeModel buildDeviceList(String dpid, String gid, String searchFor)
    {
        String opt = "";
        if (gid != null && gid.length() > 0 && !gid.equals("All"))
        {
            if (gid.equals("No group..."))
            {
                opt += " AND (device_group_id IS NULL OR device_group_id = '') ";
            }
            else
            {
                opt += " AND device_group_id = '"+gid+"' ";
            }
        }
        if (dpid != null && dpid.length() > 0 && !dpid.equals("All"))
        {
            opt += " AND depart_id = '"+dpid+"' ";
        }


        Vector v = HDC.queryAll("SELECT device_name, equipment_level, device_parent "
                + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment NATURAL JOIN device_group "
                + "WHERE TRUE "+opt+" "+searchFor+" AND last_config IS NOT NULL "
                + "ORDER BY device_name ASC;");
        int catLevel = Integer.parseInt(HDC.query0("SELECT MAX(equipment_level) FROM device NATURAL JOIN equipment;"));
        if (v != null)
        {
            //HydeDataSet HDS = new HydeDataSet(v);
            catVector = new Vector();
            root = new DefaultMutableTreeNode(rootNodeName);
            for (int i=1;i<=catLevel;i++)
            {
                Vector subVector = HDC.queryAll("SELECT "
                        + "device_name, equipment_level, device_parent, device_id, equipment_probe, "
                        + "device_link, equipment_id "
                        + "FROM device NATURAL JOIN device_status NATURAL JOIN equipment NATURAL JOIN device_group "
                        + "WHERE equipment_level = '"+i+"' "+opt+" "+searchFor+" AND last_config IS NOT NULL "
                        + "ORDER BY device_name ASC;");
                HydeDataSet HDS = new HydeDataSet(subVector);
                Vector row = HDS.getRowVector();
                Enumeration enu = row.elements();
                while(enu.hasMoreElements())
                {
                    Vector data = (Vector) enu.nextElement();
                    String id = (String) data.elementAt(3);
                    int probeAvail = Integer.parseInt((String) data.elementAt(4));
                    String prefix = "";
                    if (data.elementAt(6).equals("1"))
                    {
                        prefix = "[B] ";
                    }
                    else if (data.elementAt(6).equals("2"))
                    {
                        prefix = "[R] ";
                    }
                    else if (data.elementAt(6).equals("3"))
                    {
                        prefix = "[T] ";
                    }
                    else if (data.elementAt(6).equals("5"))
                    {
                        prefix = "[E] ";
                    }
                    String name = prefix+ data.elementAt(0)+" ("+id+") <"+data.elementAt(5)+">";
                    String parent = HDC.query0("SELECT device_name FROM device WHERE device_id = '"+data.elementAt(2)+"' ORDER BY device_name ASC;");
                    if (i == 1)
                    {
                        root.add(new DefaultMutableTreeNode(name));
                    }
                    else
                    {
                        root.add(new DefaultMutableTreeNode(name));
                    }
                    if (probeAvail > 0)
                    {
                        Vector probes = HDC.queryColumn("SELECT CONCAT('[CH:',channel,'] ',channel_name) FROM device_channel WHERE device_id = '"+id+"' AND channel_enable = '1';");
                        Enumeration probeEnu = probes.elements();
                        while (probeEnu.hasMoreElements())
                        {
                            String probeName = (String) probeEnu.nextElement();
                            root.add(new DefaultMutableTreeNode(probeName));
                        }
                    }
                }
            }
        }
        return new DefaultTreeModel(root);
    }

}
