package ETM.MAIN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.ImageIcon;

public class AlertMiniPanel extends javax.swing.JPanel implements MouseListener
{
    private MainFrame MF;
    private Vector alarmInfo;
    private int width;
    private int height;

    /*
     alarm_id
     device_id
     device_name
     error_name
     alarm_source

     alarm_timestamp
     error_priority
     user_fix
     user_username
     user_timestamp

     system_fix
     system_timestamp
     */

    public int panelIndex = 0;
    
    public AlertMiniPanel(MainFrame MF, Vector alarmInfo, int index)
    {
        this.MF = MF;
        this.alarmInfo = alarmInfo;
        panelIndex = index;
        initComponents();
        addMouseListener(this);
        //this.setToolTipText("<HTML>Alarm ID : " + alarmInfo.elementAt(0) + "<BR>Device : "+alarmInfo.elementAt(2)+" ("+alarmInfo.elementAt(1)+")</HTML>");
        
        width = (((String)(alarmInfo.elementAt(2))).length()*7)+30;
        height = 20;
        this.setMinimumSize(new Dimension(width,height));
        this.setMaximumSize(new Dimension(width,height));
        this.setPreferredSize(new Dimension(width,height));
        repaint();
    }

    public String getAlarmID()
    {
        return (String) alarmInfo.elementAt(0);
    }

    private ImageIcon etc = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/etc.png")));

    private ImageIcon userFixIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/user_fix_16.png")));
    private ImageIcon systemFixIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/system_fix_16.png")));
    private ImageIcon fixedIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/fixed.png")));

    private ImageIcon upperIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/upper.png")));
    private ImageIcon upperTimeIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/upper.png")));
    private ImageIcon upperExtremeIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/upper.png")));
    private ImageIcon lowerIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/lower.png")));
    private ImageIcon lowerTimeIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/lower.png")));
    private ImageIcon lowerExtremeIcon = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/lower.png")));
    private ImageIcon lost = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Status/lost.png")));

    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Default", Font.BOLD, 12));
        String ti = (String)alarmInfo.elementAt(2);
        String ai = (String)alarmInfo.elementAt(3);

        width = ti.length()*10;

        if(alarmInfo.elementAt(7).equals("1") && alarmInfo.elementAt(10).equals("1"))
        {
            g2d.drawImage(fixedIcon.getImage(), 4, height-18, this);
            g2d.setColor(new Color(0,200,0));
        }
        else if(alarmInfo.elementAt(7).equals("1"))
        {
            g2d.drawImage(userFixIcon.getImage(), 4, height-18, this);
            g2d.setColor(new Color(220,170,10));
        }
        else if (alarmInfo.elementAt(10).equals("1"))
        {
            g2d.drawImage(systemFixIcon.getImage(), 4, height-18, this);
            g2d.setColor(new Color(220,170,10));
        }
        else
        {
            g2d.setColor(Color.RED);
            if (ai.equals("Upper"))
            {
                g2d.drawImage(upperIcon.getImage(), 4, height-18, this);
            }
            else if(ai.equals("Upper-Time"))
            {
                g2d.drawImage(upperTimeIcon.getImage(), 4, height-18, this);
            }
            else if(ai.equals("Upper-Extreme"))
            {
                //g2d.setColor(new Color(255,155,155));
                //g2d.fillRect(0, 0, width, height);
                g2d.drawImage(upperExtremeIcon.getImage(), 4, height-18, this);
                //g2d.drawRect(1, 1, width-3, height-3);
                //.setColor(new Color(255,100,100));
                //g2d.drawRect(2, 2, width-5, height-5);
            }
            else if(ai.equals("Lower"))
            {
                g2d.drawImage(lowerIcon.getImage(), 4, height-18, this);
            }
            else if(ai.equals("Lower-Time"))
            {
                g2d.drawImage(lowerTimeIcon.getImage(), 4, height-18, this);
            }
            else if(ai.equals("Lower-Extreme"))
            {
                //g2d.setColor(new Color(255,155,155));
                //g2d.fillRect(0, 0, width, height);
                g2d.drawImage(lowerExtremeIcon.getImage(), 4, height-18, this);
                //g2d.drawRect(1, 1, width-3, height-3);
                //g2d.setColor(new Color(255,100,100));
                //g2d.drawRect(2, 2, width-5, height-5);
            }
            else if(ai.equals("Connection Lost"))
            {
                g2d.drawImage(lost.getImage(), 4, height-18, this);
            }
            else
            {
                g2d.drawImage(etc.getImage(), 4, height-18, this);
            }
            g2d.setColor(Color.RED);
        }
        g2d.drawString(" "+panelIndex+": "+ti + "  <" + ai+">", 21, height-4);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        setMaximumSize(new java.awt.Dimension(240, 20));
        setMinimumSize(new java.awt.Dimension(240, 20));
        setPreferredSize(new java.awt.Dimension(240, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e)
    {
        MF.popUpError((String)alarmInfo.elementAt(0),true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
