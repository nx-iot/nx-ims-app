package ETM.MONITOR.PANEL;

import ETM.MONITOR.DIALOG.FloorplanModifyDialog;
import ETM.MONITOR.MonitorIF;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

public class FloorplanManagementPanel extends javax.swing.JPanel implements ActionListener, MouseListener
{
    public MonitorIF MIF;

    public static String defaultDepartmentComboBox = "Select a department...";

    private String any = "1111";

    public FloorplanManagementPanel(MonitorIF MIF)
    {
        this.MIF = MIF;
        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        setdepartmentComboBox();
    }

    private void actionComponents()
    {
        departmentComboBox.addActionListener(this);
        modifyButton.addActionListener(this);
        newButton.addActionListener(this);
        deleteButton.addActionListener(this);

        fpList.addMouseListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        availPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fpList = new javax.swing.JList();
        departPanel = new javax.swing.JPanel();
        departLabel = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox();
        availLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        picPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        picLabel = new javax.swing.JLabel();
        floorplanManagementLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        departmentField = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        idField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        lastUpdateLabel = new javax.swing.JLabel();
        lastUpdateField = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        departmentField2 = new javax.swing.JLabel();
        buttonGroup = new javax.swing.JPanel();
        modifyButtonGroup = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jToolBar6 = new javax.swing.JToolBar();
        modifyButton = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        newButton = new javax.swing.JButton();
        jToolBar7 = new javax.swing.JToolBar();
        deleteButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        availPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        availPanel.setLayout(new java.awt.BorderLayout());

        fpList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(fpList);

        availPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        departPanel.setMinimumSize(new java.awt.Dimension(100, 20));
        departPanel.setPreferredSize(new java.awt.Dimension(100, 20));
        departPanel.setLayout(new javax.swing.BoxLayout(departPanel, javax.swing.BoxLayout.LINE_AXIS));

        departLabel.setText(" Depart. ");
        departPanel.add(departLabel);

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a department..." }));
        departPanel.add(departmentComboBox);

        availPanel.add(departPanel, java.awt.BorderLayout.PAGE_END);

        availLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        availLabel.setText("Available Floor Plan");
        availLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        availPanel.add(availLabel, java.awt.BorderLayout.PAGE_START);

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Floorplan Preview"));
        picPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        picPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        picLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane2.setViewportView(picLabel);

        picPanel.add(jScrollPane2);

        floorplanManagementLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        floorplanManagementLabel.setText("Floorplan Management");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        departmentField.setText("-");

        idLabel.setText("Floorplan ID");

        nameLabel.setText("Floorplan Name");

        departmentLabel.setText("Department");

        idField.setText("-");

        nameField.setText("-");

        lastUpdateLabel.setText("Last Update");

        lastUpdateField.setText("-");

        jLabel1.setText("Number of node");

        departmentField2.setText("-");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lastUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departmentField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastUpdateField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lastUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lastUpdateField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(departmentField2)))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(floorplanManagementLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(availPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(floorplanManagementLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(availPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);

        buttonGroup.setMaximumSize(new java.awt.Dimension(40, 5000));
        buttonGroup.setMinimumSize(new java.awt.Dimension(40, 300));
        buttonGroup.setPreferredSize(new java.awt.Dimension(40, 300));
        buttonGroup.setLayout(new java.awt.BorderLayout());

        modifyButtonGroup.setMaximumSize(new java.awt.Dimension(32, 10000));
        modifyButtonGroup.setMinimumSize(new java.awt.Dimension(32, 130));
        modifyButtonGroup.setLayout(new javax.swing.BoxLayout(modifyButtonGroup, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel4.setMaximumSize(new java.awt.Dimension(3, 31));
        jLabel4.setMinimumSize(new java.awt.Dimension(3, 31));
        jLabel4.setPreferredSize(new java.awt.Dimension(3, 31));
        modifyButtonGroup.add(jLabel4);

        jSeparator4.setMaximumSize(new java.awt.Dimension(32767, 1));
        jSeparator4.setPreferredSize(new java.awt.Dimension(0, 1));
        modifyButtonGroup.add(jSeparator4);

        jToolBar6.setFloatable(false);
        jToolBar6.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar6.setMinimumSize(new java.awt.Dimension(32, 40));

        modifyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_edit_32.png"))); // NOI18N
        modifyButton.setToolTipText("Modify Floor Plan");
        modifyButton.setEnabled(false);
        modifyButton.setFocusable(false);
        modifyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modifyButton.setMaximumSize(new java.awt.Dimension(32, 40));
        modifyButton.setMinimumSize(new java.awt.Dimension(32, 40));
        modifyButton.setPreferredSize(new java.awt.Dimension(32, 40));
        modifyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar6.add(modifyButton);

        modifyButtonGroup.add(jToolBar6);

        jToolBar5.setFloatable(false);
        jToolBar5.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar5.setMinimumSize(new java.awt.Dimension(32, 40));

        newButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_new_32.png"))); // NOI18N
        newButton.setToolTipText("Add Noew Floor Plan");
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setMaximumSize(new java.awt.Dimension(32, 40));
        newButton.setMinimumSize(new java.awt.Dimension(32, 40));
        newButton.setPreferredSize(new java.awt.Dimension(32, 40));
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar5.add(newButton);

        modifyButtonGroup.add(jToolBar5);

        jToolBar7.setFloatable(false);
        jToolBar7.setMaximumSize(new java.awt.Dimension(32, 40));
        jToolBar7.setMinimumSize(new java.awt.Dimension(32, 40));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/profile_delete_32.png"))); // NOI18N
        deleteButton.setToolTipText("Delete Floor Plan");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setMaximumSize(new java.awt.Dimension(32, 40));
        deleteButton.setMinimumSize(new java.awt.Dimension(32, 40));
        deleteButton.setPreferredSize(new java.awt.Dimension(32, 40));
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar7.add(deleteButton);

        modifyButtonGroup.add(jToolBar7);

        buttonGroup.add(modifyButtonGroup, java.awt.BorderLayout.NORTH);

        add(buttonGroup, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    public void setdepartmentComboBox()
    {
        departmentComboBox.removeAllItems();
        departmentComboBox.addItem(defaultDepartmentComboBox);
        if (any.charAt(1) == '1')
        {
            departmentComboBox.addItem("All");
            Vector v = MIF.MF.HDC.queryRow("SELECT "
                    + "CONCAT(depart_name,' (',depart_id+0,')') "
                    + "FROM department;");
            if (v != null)
            {
                Enumeration enu = v.elements();
                while (enu.hasMoreElements())
                {
                    departmentComboBox.addItem(enu.nextElement());
                }
            }
        }
        else
        {
           departmentComboBox.addItem(MIF.MF.HDC.query0("SELECT "
                    + "CONCAT(depart_name,' (',depart_id+0,')') "
                    + "FROM department WHERE depart_id = '"+MIF.MF.SD.loginDepartment+"';"));
        }
    }


    public void setFloorplanList()
    {
        String str = (String) departmentComboBox.getSelectedItem();
        if (str != null && !str.equals(defaultDepartmentComboBox))
        {
            Vector v;
            if (str.equals("All"))
            {
               v = MIF.MF.HDC.queryColumn("SELECT CONCAT(floorplan_name, ' (',floorplan_id+0, ')') FROM floorplan;");
            }
            else
            {
                String gid = HydeFormat.parseID(str);
               v = MIF.MF.HDC.queryColumn("SELECT CONCAT(floorplan_name, ' (',floorplan_id+0, ')') FROM floorplan WHERE depart_id = "+gid+";");
            }
            Object[] obj = v.toArray();
            fpList.setListData(obj);
            fpList.setSelectedIndex(0);
            fpList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        else
        {
            Object[] obj = new Object[0];
            fpList.setListData(obj);
        }
        clearInfo();
    }

    public void setInfo(String fp)
    {
        if (fp != null)
        {
            HydeImage HI = new HydeImage();
            Vector v = MIF.MF.HDC.queryRow("SELECT floorplan_name, CONCAT(depart_name,' (',depart_id,')'), last_update "
                    + "FROM floorplan NATURAL JOIN department "
                    + "WHERE floorplan_id = '"+HydeFormat.parseID(fp)+"';");
            if (v != null && v.size() >= 3)
            {
                idField.setText(HydeFormat.parseID(fp));
                nameField.setText((String)v.elementAt(0));
                departmentField.setText((String)v.elementAt(1));
                lastUpdateField.setText((String)v.elementAt(2));
                HI.setImageFromUrl(MIF.MF.SD.urlImgPath+"/image/floorplan/"+idField.getText()+"_4.jpg", picLabel, picPanel, 1150, 1150,HydeImage.NO_SCALED);

                modifyButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }
            else
            {
                idField.setText("Not found...");
                nameField.setText("Not found...");
                departmentField.setText("Not found...");
                lastUpdateField.setText("Not found...");
                HI.setImage(picLabel, picPanel);
            }
        }
    }

    public void clearInfo()
    {
        HydeImage HI = new HydeImage();
        idField.setText("-");
        nameField.setText("-");
        departmentField.setText("-");
        lastUpdateField.setText("-");
        HI.setImage(picLabel, picPanel);

        modifyButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availLabel;
    private javax.swing.JPanel availPanel;
    private javax.swing.JPanel buttonGroup;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel departLabel;
    private javax.swing.JPanel departPanel;
    private javax.swing.JComboBox departmentComboBox;
    public javax.swing.JLabel departmentField;
    public javax.swing.JLabel departmentField2;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JLabel floorplanManagementLabel;
    private javax.swing.JList fpList;
    public javax.swing.JLabel idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JToolBar jToolBar6;
    private javax.swing.JToolBar jToolBar7;
    public javax.swing.JLabel lastUpdateField;
    private javax.swing.JLabel lastUpdateLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton modifyButton;
    private javax.swing.JPanel modifyButtonGroup;
    public javax.swing.JLabel nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel picLabel;
    private javax.swing.JPanel picPanel;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == modifyButton)
        {
            FloorplanModifyDialog FMD = new FloorplanModifyDialog(this,FloorplanModifyDialog.FLOORPLAN_EDIT);
        }
        else if (src == newButton)
        {
            FloorplanModifyDialog FMD = new FloorplanModifyDialog(this,FloorplanModifyDialog.FLOORPLAN_NEW);
        }
        else if (src == deleteButton)
        {
            int inp = JOptionPane.showConfirmDialog(this, "You want to delete this floorplan ?", "Are you sure ?", JOptionPane.YES_NO_OPTION);
            if (inp == 0)
            {
                String str = (String) fpList.getSelectedValue();
                if (str != null)
                {
                    boolean success = MIF.MF.HDC.customUpdate("DELETE FROM floorplan WHERE floorplan_id = '"+idField.getText()+"';");
                    if (success)
                    {
                        setFloorplanList();
                        JOptionPane.showMessageDialog(this, "Floorplan has been deleted...");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Floorplan cannot be deleted...");
                    }
                }
            }
        }
        else if (src == departmentComboBox && departmentComboBox.getSelectedItem() != null)
        {
            setFloorplanList();
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        if (src == fpList)
        {
            setInfo((String) fpList.getSelectedValue());
        }
    }

}
