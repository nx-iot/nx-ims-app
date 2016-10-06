package ETM.MONITOR.PANEL;

import ETM.MAIN.MainFrame;
import ETM.STRUCTURE.FloorPlanIndex;
import java.awt.Dimension;
import java.util.Enumeration;
import java.util.Vector;

public class FloorPlanPlus extends javax.swing.JFrame
{
    private MainFrame MF;
    private int panelID;
    private FloorPlanIndex thisFloorPlanIndex;

    public FloorPlanPlus(MainFrame MF, String selectedFloor)
    {
        this.MF = MF;
        initComponents();
        extendComponents();

        FloorplanPanel FPP = new FloorplanPanel(MF.MIF,panelID);
        monitorPanel.add(FPP);
        //FPP.organizationComboBox.setSelectedItem(selectedOrg);
        FPP.floorComboBox.setSelectedItem(selectedFloor);
        pack();
        setPreferredSize(new Dimension(400,300));
        setVisible(true);
        
    }

    private void extendComponents()
    {
        Enumeration enu = MF.MIF.floorPlanData.elements();
        int availID = 0;
        Vector vi = new Vector();
        while(enu.hasMoreElements())
        {
            FloorPlanIndex FPI = (FloorPlanIndex) enu.nextElement();
            vi.add(FPI.getFloorPlanID());
        }
        while(vi.indexOf(availID) > -1)
        {
            availID++;
        }

        panelID = availID;
        setTitle("Floor Plan ("+panelID+")");
        FloorPlanIndex FPI = new FloorPlanIndex(panelID);
        thisFloorPlanIndex = FPI;
        MF.MIF.floorPlanData.add(FPI);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monitorPanelScroll = new javax.swing.JScrollPane();
        monitorPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        monitorPanel.setLayout(new java.awt.GridLayout(1, 0));
        monitorPanelScroll.setViewportView(monitorPanel);

        getContentPane().add(monitorPanelScroll);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        MF.MIF.floorPlanData.remove(thisFloorPlanIndex);
        System.out.println(thisFloorPlanIndex.getFloorPlanID() + " Removed !!");
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel monitorPanel;
    private javax.swing.JScrollPane monitorPanelScroll;
    // End of variables declaration//GEN-END:variables

}
