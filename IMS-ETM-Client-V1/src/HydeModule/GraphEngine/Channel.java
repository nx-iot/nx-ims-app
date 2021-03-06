/*
 * Channel Module (Modified by Hyde - From telos demo software)
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.GraphEngine;

import java.util.Vector;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.io.IOException;
import java.io.Writer;

public class Channel  {
    static int colorIndex = 0;
    static Color plotColors[];


    static {
	plotColors    = new Color[10];
	plotColors[0] = Color.green;
	plotColors[1] = new Color(200,200,200);
	plotColors[2] = new Color(255,30,100);
	plotColors[3] = Color.magenta;
	plotColors[4] = Color.orange;
	plotColors[5] = Color.yellow;
	plotColors[6] = Color.cyan;
	plotColors[7] = Color.pink;
	plotColors[8] = Color.green;
	plotColors[9] = Color.white;
//        plotColors    = new Color[8];
//	plotColors[0] = Color.green;
//	//plotColors[1] = Color.red;
//	//plotColors[2] = Color.blue;
//	plotColors[1] = Color.magenta;
//	plotColors[2] = Color.orange;
//	plotColors[3] = Color.yellow;
//	plotColors[4] = Color.cyan;
//	plotColors[5] = Color.pink;
//	plotColors[6] = Color.green;
//	plotColors[7] = Color.white;
    }

    long lastPoint;

    String dataLegend;

    boolean active;

    Color plotColor;

    Vector data;

    GraphPanel graphPanel;

    int maxLength;
    boolean master;

    Stroke plotStroke;

    /*public int year = 1900;

    public void setYear(int year)
    {
        this.year = year;
    }
    public int getYear()
    {
        return year;
    }*/

    /**
     * Get the PlotStroke value.
     * @return the PlotStroke value.
     */
    public Stroke getPlotStroke() {
	return plotStroke;
    }

    /**
     * Set the PlotStroke value.
     * @param newPlotStroke The new PlotStroke value.
     */
    public void setPlotStroke(Stroke newPlotStroke) {
	this.plotStroke = newPlotStroke;
    }


    /**
     * Get the Master value.
     * @return the Master value.
     */
    public boolean isMaster() {
	return master;
    }

    /**
     * Set the Master value.
     * @param newMaster The new Master value.
     */
    public void setMaster(boolean newMaster) {
	this.master = newMaster;
    }


    /**
     * Get the LastPoint value.
     * @return the LastPoint value.
     */
    public long getLastPoint() {
	return lastPoint;
    }

    /**
     * Set the LastPoint value.
     * @param newLastPoint The new LastPoint value.
     */
    public void setLastPoint(long newLastPoint) {
	this.lastPoint = newLastPoint;
    }

    /**
     * Get the DataLegend value.
     * @return the DataLegend value.
     */
    public String getDataLegend() {
	return dataLegend;
    }

    /**
     * Set the DataLegend value.
     * @param newDataLegend The new DataLegend value.
     */
    public void setDataLegend(String newDataLegend) {
	this.dataLegend = newDataLegend;
    }

    /**
     * Get the Active value.
     * @return the Active value.
     */
    public boolean isActive() {
	return active;
    }

    /**
     * Set the Active value.
     * @param newActive The new Active value.
     */
    public void setActive(boolean newActive) {
	this.active = newActive;
    }

    /**
     * Get the PlotColor value.
     * @return the PlotColor value.
     */
    public Color getPlotColor() {
	return plotColor;
    }

    /**
     * Set the PlotColor value.
     * @param newPlotColor The new PlotColor value.
     */
    public void setPlotColor(Color newPlotColor) {
	this.plotColor = newPlotColor;
    }

    /**
     * Get the Data value.
     * @return the Data value.
     */
    public Vector getData() {
	return data;
    }

    /**
     * Get the GraphPanel value.
     * @return the GraphPanel value.
     */
    public GraphPanel getGraphPanel() {
	return graphPanel;
    }

    /**
     * Set the GraphPanel value.
     * @param newGraphPanel The new GraphPanel value.
     */
    public void setGraphPanel(GraphPanel newGraphPanel) {
	this.graphPanel = newGraphPanel;
    }

    /**
     * Get the MaxLength value.
     * @return the MaxLength value.
     */
    public int getMaxLength() {
	return maxLength;
    }

    /**
     * Set the MaxLength value.
     * @param newMaxLength The new MaxLength value.
     */
    public void setMaxLength(int newMaxLength) {
	this.maxLength = newMaxLength;
    }

    /**
     * Create a channel.  The channel starts out without a legend, and in an
     * inactive state.  Its last point is -1.
     */

    public Channel() {
	data = new Vector();
	dataLegend = "";
	active = false;
	lastPoint = -1;
	maxLength = 0x3fffffff;
	master = false;
	plotStroke = new BasicStroke(2.0f);
	synchronized(Channel.class) {
	    plotColor = plotColors[colorIndex];
	    colorIndex = (colorIndex + 1) % 10;
	}
    }

    public synchronized void trim() {
	if (data.size() > maxLength) {
	    Vector tmp = new Vector(maxLength/10);
	    for (int i = data.size()-(maxLength/10); i < data.size(); i++) {
		tmp.add(data.get(i));
	    }
	    data = tmp;
	}
    }

    public Point2D findNearestX(Point2D test) {
	try {
	    double xval = Math.round(test.getX());
	    for (int i = 0; i < data.size(); i++) {
		Point2D pt = (Point2D)data.get(i);
		if (pt == null) continue;
		if (Math.round(pt.getX()) == xval) { return pt; }
	    }
	    return null;
	} catch (Exception e) {
	    return null;
	}
    }

    public synchronized void clear()
    {
	data.clear();
    }

    public double lastY;
    public synchronized void addPoint(Point2D val)
    {
	if (val == null)
	    return;
        if (isMaster())
        {
            if(graphPanel.isSliding() &&
               ((val.getX() > (graphPanel.getEnd() )) || (val.getX() < graphPanel.getStart())))
            {
                int xdiff = graphPanel.getEnd() - graphPanel.getStart();
                int xend = (int)val.getX();
                int xstart = xend - xdiff;
                graphPanel.setXBounds(xstart, xend);


                /*double height = graphPanel.getTop() - graphPanel.getBottom();
                double ycenter = graphPanel.getTop() - (height/2);
                double ydata = (double)val.getY();
                double ycenter2 = ycenter - ydata;
                double newTop =(ycenter2+(height/2))-((ycenter2+(height/2))%100);
                graphPanel.setYBounds(newTop, newTop-height);*/

	//top -= 100+((height/100)-((height/100)%100));
            }
	}
        lastY = val.getY();
	data.add(val);
	trim();
	graphPanel.repaint(100);
        
    }

    public void setCenterData()
    {
        graphPanel.moveToData(lastY);
    }

    public synchronized void saveData(Writer dataOut) throws IOException {
	if (data.size() > 0) {
	    dataOut.write("# BEGIN CHANNEL DATA: "+ data.size() +" SAMPLES\n");
	    dataOut.write("# "+getDataLegend()+"\n");
	    for(int n=0;n<data.size();n++ ) {
		Point2D sample;
		sample = (Point2D) data.get(n);
		if (sample != null) {
		    dataOut.write(""+sample.getX() +" " + sample.getY());
		    dataOut.write( "\n" );
		}
	    }
	}
    }
}