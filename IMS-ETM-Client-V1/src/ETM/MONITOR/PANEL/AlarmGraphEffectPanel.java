/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AlarmGraphEffectPanel.java
 *
 * Created on Feb 10, 2012, 3:54:44 PM
 */

package ETM.MONITOR.PANEL;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author Hyde
 */
public class AlarmGraphEffectPanel extends javax.swing.JPanel
{
    public String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

    int monthIndex = 0;
    int yearIndex = 0;

    public MonthlyReportPanel MRP;
    public int[][] data;

    private int size;
    private int gap;
    private int wScale;
    private double yScale;
    private int maxY;

    private int wScale4;

    public AlarmGraphEffectPanel(MonthlyReportPanel MRP, int month, int year, int[][] data)
    {
        this.MRP = MRP;
        this.data = data;
        monthIndex = month;
        yearIndex = year;
        initComponents();
        extendComponents();
        setVisible(true);
        repaint();
    }

    private void extendComponents()
    {
        size = data.length;
        gap = (size-1)/2;
        maxY = 0;
        for (int i=0;i<size;i++)
        {
            maxY = data[i][0] > maxY ? data[i][0] : maxY;
        }
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

	Dimension d = getSize();
        wScale = (d.width-20)/(size+1);
        wScale4 = wScale/4;
        yScale = (d.height-40.0)/(maxY+1.0);
        

        g2d.setColor(new Color(250,250,250));
        g2d.fillRect(0, 0, d.width, d.height);

        g2d.setColor(new Color(0,0,0));
        //g2d.drawLine(20, 20, 20, d.height-20);
        g2d.drawLine(20, d.height-19, d.width-20, d.height-19);

        drawMonthLabel(g2d, d);
        drawGraph(g2d, d);

        drawLabel(g2d, d);
    }

    private void drawMonthLabel(Graphics offgraphics, Dimension d)
    {
        int selectedMonth = monthIndex-1;
        int pos = 0;
        for (int i = selectedMonth; i<size+selectedMonth;i++)
        {
            int index = i-gap;
            if (index < 0)
            {
                index = 12+index;
            }
            else if (index > 11)
            {
                index = index-12;
            }
            offgraphics.drawString(month[index], wScale*(1+pos)-8, d.height-9);
            pos++;
        }
    }

    private void drawLabel(Graphics offgraphics, Dimension d)
    {
        offgraphics.setColor(new Color(222,0,0,100));
        offgraphics.fillRect(d.width-80, 5, 25, 10);
        offgraphics.setColor(new Color(222,0,0));
        offgraphics.drawRect(d.width-80, 5, 25, 10);
        offgraphics.drawString("All Alarm", d.width-45, 14);

        offgraphics.setColor(new Color(180,180,0,100));
        offgraphics.fillRect(d.width-80, 16, 25, 10);
        offgraphics.setColor(new Color(180,180,0));
        offgraphics.drawRect(d.width-80, 16, 25, 10);
        offgraphics.drawString("Event", d.width-45, 25);

        offgraphics.setColor(new Color(180,0,180,100));
        offgraphics.fillRect(d.width-80, 27, 25, 10);
        offgraphics.setColor(new Color(180,0,180));
        offgraphics.drawRect(d.width-80, 27, 25, 10);
        offgraphics.drawString("Alert", d.width-45, 36);

        offgraphics.setColor(new Color(0,180,180,100));
        offgraphics.fillRect(d.width-80, 38, 25, 10);
        offgraphics.setColor(new Color(0,180,180));
        offgraphics.drawRect(d.width-80, 38, 25, 10);
        offgraphics.drawString("Warning", d.width-45, 47);

    }

    private void drawGraph(Graphics offgraphics, Dimension d)
    {
            //System.out.println("yScale = "+yScale);
            //System.out.println("d.height = "+d.height);
        for (int i=0;i<size;i++)
        {
            int max = data[i][0];
            int slen = ((max+"").length()+1)/2;
            offgraphics.setColor(new Color(222,0,0,100));
            offgraphics.fillRect((wScale*(1+i))-(wScale4*2), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            offgraphics.setColor(new Color(222,0,0));
            offgraphics.drawRect((wScale*(1+i))-(wScale4*2), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            if (max > 0)offgraphics.drawString(max+"", (wScale*(1+i))-(wScale4*2)+(wScale4/2-slen*4), (d.height-((int)(max*yScale))-10)-20);

            max = data[i][1];
            slen = ((max+"").length()+1)/2;
            offgraphics.setColor(new Color(180,180,0,100));
            offgraphics.fillRect((wScale*(1+i))-(wScale4), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            offgraphics.setColor(new Color(180,180,0));
            offgraphics.drawRect((wScale*(1+i))-(wScale4), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            if (max > 0)offgraphics.drawString(max+"", (wScale*(1+i))-(wScale4*1)+(wScale4/2-slen*4), (d.height-((int)(max*yScale))-10)-20);

            max = data[i][2];
            slen = ((max+"").length()+1)/2;
            offgraphics.setColor(new Color(180,0,180,100));
            offgraphics.fillRect((wScale*(1+i)), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            offgraphics.setColor(new Color(180,0,180));
            offgraphics.drawRect((wScale*(1+i)), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            if (max > 0)offgraphics.drawString(max+"", (wScale*(1+i))+(wScale4/2-slen*4), (d.height-((int)(max*yScale))-10)-20);

            max = data[i][3];
            slen = ((max+"").length()+1)/2;
            offgraphics.setColor(new Color(0,180,180,100));
            offgraphics.fillRect((wScale*(1+i))+(wScale4), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            offgraphics.setColor(new Color(0,180,180));
            offgraphics.drawRect((wScale*(1+i))+(wScale4), (d.height-((int)(max*yScale)))-20, wScale4-1, (int)(max*yScale));
            if (max > 0)offgraphics.drawString(max+"", (wScale*(1+i))+(wScale4)+(wScale4/2-slen*4), (d.height-((int)(max*yScale))-10)-20);

        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
