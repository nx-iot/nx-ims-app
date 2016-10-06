/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ETM.MAIN.POPUP;

import ETM.MAIN.FullFrame;
import ETM.MAIN.MainFrame;
import HydeModule.Image.HydeImage;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

/**
 *
 * @author Hyde
 */
public class LocationPopup2 extends javax.swing.JFrame implements MouseListener, ActionListener
{
    private MainFrame MF;
    private String deviceID;
    private String locationPicPath;
    private JToggleButton[] JTBA;

    public LocationPopup2(MainFrame MF, String deviceID, int preset) 
    {
        this.MF = MF;
        this.deviceID = deviceID;
        initComponents();
        extendComponents();
        actionComponents();
        setDefault(preset);
        //setInfo(preset);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void extendComponents()
    {
        JTBA = new JToggleButton[]{locationButton,host1Button,host2Button,host3Button,host4Button,host5Button};
        String equipmentProbe = MF.HDC.query0("SELECT equipment_probe "
                + "FROM device NATURAL JOIN equipment "
                + "WHERE device_id = '"+deviceID+"';");
        if (equipmentProbe != null)
        {
            int probes = Integer.parseInt(equipmentProbe);
            for (int i=1;i<probes+1;i++)
            {
                JTBA[i].setEnabled(true);
            }
        }
        
        /*Vector enable = MF.HDC.queryColumn("SELECT channel_enable "
                + "FROM device_channel "
                + "WHERE device_id = '"+deviceID+"'; ");
        if (enable != null)
        {
            int c = 1;
            Enumeration enu = enable.elements();
            while (enu.hasMoreElements())
            {
                if (!enu.nextElement().equals("1"))
                {
                    JTBA[c].setText("-DISABLE-");
                }
                c++;
            }
        }*/
    }
    
    public void setDefault(int choice)
    {
        JTBA[choice].setForeground(new Color(200,0,0));
        JTBA[choice].setFont(new java.awt.Font("Tahoma", 1, 12));
        JTBA[choice].doClick();
    }
    
    public void setInfo(int choice)
    {
        switch (choice)
        {
            case 0 : 
                Vector locationData = MF.HDC.queryRow("SELECT location_id, location_name, location_description "
                    + "FROM device NATURAL JOIN location "
                    + "WHERE device_id = '"+deviceID+"';");
                if (locationData != null && locationData.size() >= 3)
                {
                    //locationField.setText(rowData.elementAt(1) + " ("+rowData.elementAt(0)+")");
                    locationArea.setText(locationData.elementAt(1) + " ("+locationData.elementAt(0)+") :\n\n"
                            +(String)locationData.elementAt(2));
                    locationPicPath = MF.SD.urlImgPath+"/image/location/"+locationData.elementAt(0)+".jpg";
                    HydeImage HI = new HydeImage();
                    HI.setImageFromUrl(locationPicPath, locationPic, picPanel, 320, 240,HydeImage.HEIGHT_PRIORITY);
                }
                else
                {
                    HydeImage HI = new HydeImage();
                    HI.setImage(locationPic, picPanel);
                    locationArea.setText("-NO DATA-");
                }
                break;
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :
                Vector hostData = MF.HDC.queryRow("SELECT host_id, host_name, host_description, host_name "
                    + "FROM device_channel NATURAL JOIN host "
                    + "WHERE device_id = '"+deviceID+"' AND channel = '"+choice+"';");
                if (hostData != null && hostData.size() >= 4)
                {
                    //locationField.setText(rowData.elementAt(1) + " ("+rowData.elementAt(0)+")");
                    locationArea.setText(hostData.elementAt(1) + " ("+hostData.elementAt(0)+") : "
                            + hostData.elementAt(3)+" :\n\n"
                            +(String)hostData.elementAt(2));
                    locationPicPath = MF.SD.urlImgPath+"/image/host/"+hostData.elementAt(0)+".jpg";
                    HydeImage HI = new HydeImage();
                    HI.setImageFromUrl(locationPicPath, locationPic, picPanel, 320, 240,HydeImage.HEIGHT_PRIORITY);
                }
                else
                {
                    HydeImage HI = new HydeImage();
                    HI.setImage(locationPic, picPanel);
                    locationArea.setText("-NO DATA-");
                }
                break;
        }
    }
    
    private void actionComponents()
    {
        locationPic.addMouseListener(this);
        
        locationButton.addActionListener(this);
        host1Button.addActionListener(this);
        host2Button.addActionListener(this);
        host3Button.addActionListener(this);
        host4Button.addActionListener(this);
        host5Button.addActionListener(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        locationArea = new javax.swing.JTextArea(){
            @Override public void setBorder(Border border) {
                // No!
            }
        }
        ;
        jPanel1 = new javax.swing.JPanel();
        picPanel = new javax.swing.JPanel();
        locationPic = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        locationButton = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        host1Button = new javax.swing.JToggleButton();
        host2Button = new javax.swing.JToggleButton();
        host3Button = new javax.swing.JToggleButton();
        host4Button = new javax.swing.JToggleButton();
        host5Button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Location");
        setAlwaysOnTop(true);
        setResizable(false);

        locationArea.setColumns(20);
        locationArea.setEditable(false);
        locationArea.setLineWrap(true);
        locationArea.setRows(5);
        locationArea.setWrapStyleWord(true);
        locationArea.setBorder(null);
        jScrollPane1.setViewportView(locationArea);

        picPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Picture"));
        picPanel.setMaximumSize(new java.awt.Dimension(360, 240));
        picPanel.setMinimumSize(new java.awt.Dimension(360, 240));
        picPanel.setPreferredSize(new java.awt.Dimension(360, 240));
        picPanel.setLayout(new java.awt.GridLayout(1, 0));

        locationPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picPanel.add(locationPic);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Related", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel2.setText(" ");
        jPanel2.add(jLabel2);

        buttonGroup1.add(locationButton);
        locationButton.setText("Dev.Location");
        locationButton.setMaximumSize(new java.awt.Dimension(120, 25));
        locationButton.setMinimumSize(new java.awt.Dimension(120, 25));
        locationButton.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(locationButton);

        jLabel1.setText(" ");
        jPanel2.add(jLabel1);

        buttonGroup1.add(host1Button);
        host1Button.setText("Sensor 1 Host");
        host1Button.setEnabled(false);
        host1Button.setMaximumSize(new java.awt.Dimension(120, 25));
        host1Button.setMinimumSize(new java.awt.Dimension(120, 25));
        host1Button.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(host1Button);

        buttonGroup1.add(host2Button);
        host2Button.setText("Sensor 2 Host");
        host2Button.setEnabled(false);
        host2Button.setMaximumSize(new java.awt.Dimension(120, 25));
        host2Button.setMinimumSize(new java.awt.Dimension(120, 25));
        host2Button.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(host2Button);

        buttonGroup1.add(host3Button);
        host3Button.setText("Sensor 3 Host");
        host3Button.setEnabled(false);
        host3Button.setMaximumSize(new java.awt.Dimension(120, 25));
        host3Button.setMinimumSize(new java.awt.Dimension(120, 25));
        host3Button.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(host3Button);

        buttonGroup1.add(host4Button);
        host4Button.setText("Sensor 4 Host");
        host4Button.setEnabled(false);
        host4Button.setMaximumSize(new java.awt.Dimension(120, 25));
        host4Button.setMinimumSize(new java.awt.Dimension(120, 25));
        host4Button.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(host4Button);

        buttonGroup1.add(host5Button);
        host5Button.setText("Sensor 5 Host");
        host5Button.setEnabled(false);
        host5Button.setMaximumSize(new java.awt.Dimension(120, 25));
        host5Button.setMinimumSize(new java.awt.Dimension(120, 25));
        host5Button.setPreferredSize(new java.awt.Dimension(120, 25));
        jPanel2.add(host5Button);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(picPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(picPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton host1Button;
    private javax.swing.JToggleButton host2Button;
    private javax.swing.JToggleButton host3Button;
    private javax.swing.JToggleButton host4Button;
    private javax.swing.JToggleButton host5Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea locationArea;
    private javax.swing.JToggleButton locationButton;
    private javax.swing.JLabel locationPic;
    private javax.swing.JPanel picPanel;
    // End of variables declaration//GEN-END:variables

    
    
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e)
    {
        Object src = e.getSource();
        int clickCount = e.getClickCount();
        if (clickCount == 2)
        {
            if (src == locationPic)
            {
                FullFrame FPD = new FullFrame(locationPicPath);
            }
            /*else if(src == hostPic1)
            {
                FullFrame FPD = new FullFrame(hostPicPath[0]);
            }
            else if(src == hostPic2)
            {
                FullFrame FPD = new FullFrame(hostPicPath[1]);
            }
            else if (src == hostPic3)
            {
                FullFrame FPD = new FullFrame(hostPicPath[2]);
            }
            else if (src == hostPic4)
            {
                FullFrame FPD = new FullFrame(hostPicPath[3]);
            }
            else if (src == hostPic5)
            {
                FullFrame FPD = new FullFrame(hostPicPath[4]);
            }*/
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Object src = e.getSource();
        if (src == locationButton && locationButton.isSelected())
        {
            setInfo(0);
        }
        else if (src == host1Button && host1Button.isSelected())
        {
            setInfo(1);
        }
        else if (src == host2Button && host2Button.isSelected())
        {
            setInfo(2);
        }
        else if (src == host3Button && host3Button.isSelected())
        {
            setInfo(3);
        }
        else if (src == host4Button && host4Button.isSelected())
        {
            setInfo(4);
        }
        else if (src == host5Button && host5Button.isSelected())
        {
            setInfo(5);
        }
    }
}
