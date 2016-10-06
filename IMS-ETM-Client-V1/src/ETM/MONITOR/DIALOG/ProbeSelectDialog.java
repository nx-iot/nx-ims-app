package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.GraphDisplayPanel;
import ETM.MONITOR.PANEL.TableDisplayPanel;
import ETM.Util.HydeDatabaseConnector;
import ETM.Util.HydeFormat;
import ETM.Util.HydeTreeRenderer1;
import HydeModule.Table.HydeDataSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


public class ProbeSelectDialog extends javax.swing.JDialog implements ActionListener, MouseListener, TreeSelectionListener, ListSelectionListener
{
    private Object Parent;

    private Vector selectedInList = new Vector();
    private String selectingProbe = "";

    private int parentMode;
    private HydeDatabaseConnector HDC;
    
    public ProbeSelectDialog(GraphDisplayPanel GDP)
    {
        this.Parent = GDP;
        parentMode = 0;
        this.HDC = ((GraphDisplayPanel)Parent).MIF.MF.HDC;
        initComponents();
        extendComponents();
        actionListener();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public ProbeSelectDialog(TableDisplayPanel TDP)
    {
        this.Parent = TDP;
        parentMode = 1;
        this.HDC = ((TableDisplayPanel)Parent).MIF.MF.HDC;
        initComponents();
        extendComponents();
        actionListener();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void extendComponents()
    {
        probeTree.setCellRenderer(new HydeTreeRenderer1());
        addCurrentlySelected();
        DefaultTreeModel DTM = null;
        switch (parentMode)
        {
            case 0 : 
                DTM = buildDeviceTree(((GraphDisplayPanel)Parent).MIF.MF.SD.loginDepartment);
                break;
            case 1 : 
                DTM = buildDeviceTree(((TableDisplayPanel)Parent).MIF.MF.SD.loginDepartment);
                break;
        }
        probeTree.setModel(DTM);
    }

    private void actionListener()
    {
        probeTree.addMouseListener(this);
        probeTree.addTreeSelectionListener(this);

        probeList.addListSelectionListener(this);
        probeList.addMouseListener(this);

        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    public Vector catVector;
    public String rootNodeName = "Device Group...";
    private DefaultMutableTreeNode root;
    public DefaultTreeModel buildDeviceTree(String dpid)
    {
        String opt = "";
        if (dpid != null && dpid.length() > 0 && !dpid.equals("All"))
        {
            opt += " AND depart_id = '"+dpid+"' ";
        }

        Vector v = HDC.queryAll("SELECT device_name, equipment_level, device_parent, equipment_probe FROM device NATURAL JOIN equipment NATURAL JOIN device_group "
                + "WHERE TRUE "+opt+" "
                + "ORDER BY device_name ASC;");
        int catLevel = Integer.parseInt(HDC.query0("SELECT MAX(equipment_level) FROM device NATURAL JOIN equipment;"));
        if (v != null)
        {
            //HydeDataSet HDS = new HydeDataSet(v);
            catVector = new Vector();
            root = new DefaultMutableTreeNode(rootNodeName);
            for (int i=1;i<=catLevel;i++)
            {
                Vector subVector = HDC.queryAll("SELECT device_name, equipment_level, device_parent, device_id, equipment_probe FROM device NATURAL JOIN equipment NATURAL JOIN device_group "
                        + "WHERE equipment_level = '"+i+"' "+opt+" "
                        + "ORDER BY device_name ASC;");
                
                HydeDataSet HDS = new HydeDataSet(subVector);
                Vector row = HDS.getRowVector();
                Enumeration enu = row.elements();
                while(enu.hasMoreElements())
                {
                    Vector data = (Vector) enu.nextElement();
                    String id = (String) data.elementAt(3);
                    String name = (String) data.elementAt(0)+" ("+id+")";
                    int probeAvail = Integer.parseInt((String) data.elementAt(4));
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        probeTreeHeaderLabel = new javax.swing.JLabel();
        probeTreeScroll = new javax.swing.JScrollPane();
        probeTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        probeListHeaderLabel = new javax.swing.JLabel();
        probeListScroll = new javax.swing.JScrollPane();
        probeList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select probe(s)");

        okButton.setText("OK");

        cancelButton.setText("Cancel");

        jSplitPane1.setDividerLocation(240);
        jSplitPane1.setDividerSize(20);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(500, 400));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(500, 236));

        jPanel1.setLayout(new java.awt.BorderLayout());

        probeTreeHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        probeTreeHeaderLabel.setText("Probe List");
        probeTreeHeaderLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        probeTreeHeaderLabel.setMaximumSize(new java.awt.Dimension(6000, 2000));
        probeTreeHeaderLabel.setMinimumSize(new java.awt.Dimension(60, 20));
        probeTreeHeaderLabel.setOpaque(true);
        jPanel1.add(probeTreeHeaderLabel, java.awt.BorderLayout.PAGE_START);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        probeTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        probeTree.setMaximumSize(new java.awt.Dimension(0, 0));
        probeTreeScroll.setViewportView(probeTree);

        jPanel1.add(probeTreeScroll, java.awt.BorderLayout.CENTER);

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());

        probeListHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        probeListHeaderLabel.setText("Selected probes");
        probeListHeaderLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        probeListHeaderLabel.setMaximumSize(new java.awt.Dimension(63, 10));
        probeListHeaderLabel.setMinimumSize(new java.awt.Dimension(63, 10));
        probeListHeaderLabel.setOpaque(true);
        jPanel2.add(probeListHeaderLabel, java.awt.BorderLayout.PAGE_START);

        probeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        probeListScroll.setViewportView(probeList);

        jPanel2.add(probeListScroll, java.awt.BorderLayout.CENTER);

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(6, 6, 6)
                .addComponent(cancelButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JList probeList;
    private javax.swing.JLabel probeListHeaderLabel;
    private javax.swing.JScrollPane probeListScroll;
    private javax.swing.JTree probeTree;
    private javax.swing.JLabel probeTreeHeaderLabel;
    private javax.swing.JScrollPane probeTreeScroll;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == okButton)
        {
            switch (parentMode)
            {
                case 0 : 
                    ((GraphDisplayPanel)Parent).setSelectedProbe(selectedInList.toArray());
                    break;
                case 1 : 
                    ((TableDisplayPanel)Parent).setSelectedProbe(selectedInList.toArray());
                    break;
            }
            dispose();
        }
        else if (src == cancelButton)
        {
            dispose();
        }
    }
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        int clickCount = e.getClickCount();
        Object src = e.getSource();
        switch (clickCount)
        {
            case 2:
                if (src == probeTree)
                {
                    addToList(selectingProbe);
                }
                else if (src == probeList)
                {
                    removeFromList(selectedProbe);
                }
                break;
        }
    }
    private void removeFromList(String se)
    {
        selectedInList.remove(se);
        probeList.removeAll();
        probeList.setListData(selectedInList.toArray());
    }

    private void addCurrentlySelected()
    {
        switch (parentMode)
        {
            case 0 : 
                for (int i=0; i<((GraphDisplayPanel)Parent).selectedProbe.length;i++)
                {
                    String se = (String) ((GraphDisplayPanel)Parent).selectedProbe[i];
                    selectedInList.add(se);
                    probeList.removeAll();
                    probeList.setListData(selectedInList.toArray());
                }
                break;
            case 1 : 
                for (int i=0; i<((TableDisplayPanel)Parent).selectedProbe.length;i++)
                {
                    String se = (String) ((TableDisplayPanel)Parent).selectedProbe[i];
                    selectedInList.add(se);
                    probeList.removeAll();
                    probeList.setListData(selectedInList.toArray());
                }
                break;
        }
        
    }

    private void addToList(String se)
    {
        if (se.indexOf("[CH:") != -1)
        {
            char ch = se.charAt(4);
            String selectedDevice = "";
            String[] spath = selectingProbePath.toString().split(",");
            if (spath.length >= 2)
            {
                selectedDevice = spath[spath.length-2];
                selectedInList.add(se.substring(0,6) + " of"+selectedDevice);
                probeList.removeAll();
                probeList.setListData(selectedInList.toArray());
            }
            /*se = se.substring(5);
            if (selectedInList.indexOf(se) < 0)
            {
                selectedInList.add(se);
                probeList.removeAll();
                probeList.setListData(selectedInList.toArray());
            }*/
        }
    }

    public TreePath selectingProbePath;
    public void valueChanged(TreeSelectionEvent e)
    {
        TreePath[] paths = e.getPaths();
        String target = "";
        for (int i=0; i<paths.length; i++) {
            if (e.isAddedPath(i)) 
            {
                selectingProbePath = paths[i];
                selectingProbe = paths[i].getLastPathComponent().toString();
                break;
            }
        }
    }

    private String selectedProbe = "";
    public void valueChanged(ListSelectionEvent e)
    {
        Object src = e.getSource();
        if (src == probeList)
        {
            selectedProbe = (String) probeList.getSelectedValue();
        }
    }

}
