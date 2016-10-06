/*
 * GraphPanel Module (Modified by Hyde - From telos demo software)
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package HydeModule.GraphEngine;

import ETM.STRUCTURE.AlarmGraphData;
import ETM.Util.HydeFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
//import java.sql.Time;

public class GraphPanel extends JPanel implements MouseListener, MouseMotionListener {

    // If true, verbosely report received packet contents
    //Graphics g;
    // If true, log data to a file called LOG_FILENAME
    private static final boolean LOG = false;
    private static final String LOG_FILENAME = "log";

    // Set the number of channels to display and the number of readings
    // per packet.  2 channels and 4 reading means 2 readings per packet
    // per channel.

    private static final double _DEFAULT_BOTTOM = 0.0;
    private static final double _DEFAULT_TOP = 6000.0;
    private static final int _DEFAULT_START = 0;
    private static final int _DEFAULT_END =6000;
    private static final double X_AXIS_POSITION = 0.1;
    private static final double Y_AXIS_POSITION = 0.1;

    private double DEFAULT_BOTTOM;
    private double DEFAULT_TOP;
    private int DEFAULT_START;
    private int DEFAULT_END;
    boolean sliding = true;
    boolean legendEnabled = true;
    boolean connectPoints = true;
    boolean valueTest = false;
    int valueX, valueY;
    Channel testChannel = null;
    boolean hexAxis = false;

    public boolean  enableGrid   = false,
                    enableAxis   = false,
                    enableLegend = false,
                    reverseColor = true,
                    enableAlarmIcon = true,
                    limitLine = false;

    public double[] limitSet;

    //output stream for logging the data to.
    PrintWriter log_os;

    public double bottom, top;
    public int start, end;
    public int maximum_x = 0, minimum_x = Integer.MAX_VALUE;
    Vector cutoff;
    Point highlight_start, highlight_end;

    Vector channels;
    Vector agdVector;
    Vector agdFixedVector;
    double upper_x ;
    double upper_y ;
    double lower_x ;
    double lower_y ;
    
   
    
    final static float dash1[] = {10.0f};
    final static BasicStroke dashed = new BasicStroke(2.0f,
                                          BasicStroke.CAP_ROUND,
                                          BasicStroke.JOIN_ROUND,
                                          10.0f, dash1, 0.0f);

    final static BasicStroke alarmStroke = new BasicStroke(1.0f,
                                          BasicStroke.CAP_ROUND,
                                          BasicStroke.JOIN_ROUND);

    final static BasicStroke defaultStroke = new BasicStroke();

    private DecimalFormat dF = new DecimalFormat("#00");

    Image alarmingIcon = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/graph_alarming_24.gif")).getImage();
    Image alarmIcon = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/graph_alarm_24.png")).getImage();
    Image alarmFixedIcon = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/graph_alarm_fixed_24.png")).getImage();
    Image alertIcon = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/graph_alert_24.png")).getImage();
    Image eventIcon = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/graph_event_24.png")).getImage();

    public void enableLimitLine(boolean b, double[] l)
    {
        limitLine = b;
        limitSet = l;
        repaint(100);
    }
    public void enableGrid(boolean b)
    {
        enableGrid   = b;
        repaint(100);
    }
    public void enableAlarmIcon(boolean b)
    {
        enableAlarmIcon = b;
        repaint(100);
    }
    public void enableAxis(boolean b)   { enableAxis   = b; }
    public void enableLegend(boolean b) 
    {
        enableLegend = b;
        repaint(100);
    }

    public boolean isConnectPoints()
    {
	return connectPoints;
    }
    
    public void setConnectPoints(boolean b)
    {
	connectPoints = b;
	repaint(100);
    }

    public boolean isHexAxis()
    {
	return hexAxis;
    }

    public void setHexAxis(boolean newHexAxis)
    {
	this.hexAxis = newHexAxis;
	repaint(100);
    }

    public boolean isSliding()
    {
	return sliding;
    }

    public void setSliding(boolean _sliding)
    {
	sliding = _sliding;
	repaint(100);
    }

    public void setReverseColor(boolean b)
    {
        reverseColor = b;
        repaint(100);
    }

    public boolean isLegendEnabled() {
	return legendEnabled;
    }

    public void setLegendEnabled(boolean newLegendEnabled)
    {
	this.legendEnabled = newLegendEnabled;
	repaint(100);
    }

    public void setAlarmGraphData(Vector agd)
    {
        this.agdVector = agd;
    }

    public void setAlarmFixedGraphData(Vector agd)
    {
        this.agdFixedVector = agd;
    }

    private String xLabel;
    String getXLabel()
    {
	return xLabel;
    }

    public void setXLabel(String newXLabel)
    {
	this.xLabel = newXLabel;
    }

    private String yLabel;
    public String getYLabel()
    {
	return yLabel;
    }

    public void setYLabel(String newYLabel) {
	this.yLabel = newYLabel;
    }

    public GraphPanel() {
	this(_DEFAULT_START, _DEFAULT_BOTTOM, _DEFAULT_END, _DEFAULT_TOP);
    }

    public GraphPanel(int _start, double _bottom, int _end, double _top) {
	super();
	setBackground(Color.white);
	addMouseListener(this);
	addMouseMotionListener(this);
        this.setMinimumSize(new Dimension(600,400));
	cutoff = new Vector();
	//create an array to hold the data sets.
	channels = new Vector();
        agdVector = new Vector();
        agdFixedVector = new Vector();

	try{
	  //create a file for logging data to.
	  FileOutputStream f = new FileOutputStream(LOG_FILENAME);
	  log_os = new PrintWriter(f);
	} catch (Exception e) {
	  e.printStackTrace();
	}
	DEFAULT_BOTTOM = _bottom;
	bottom = _bottom;
	DEFAULT_TOP = _top;
	top = _top;
	DEFAULT_START = _start;
	start = _start;
	DEFAULT_END = _end;
	end = _end;
    }

    public double getBottom() {
	return bottom;
    }

    public double getTop() {
	return top;
    }

    public int getEnd() {
	return end;
    }

    public int getStart() {
	return start;
    }

    public void setXBounds(int _start, int _end) {
	start = _start;
	end = _end;
    }

    public void setYBounds(double _top, double _bottom) {

	//top -= 100+((height/100)-((height/100)%100));
	top = _top;
	bottom = _bottom;
    }

    public void addChannel(Channel c) {
	channels.add(c);
    }

    public void removeChannel(Channel c) {
	channels.remove(c);
    }

    public void removeAllChannels() {
	channels.removeAllElements();
    }

    public Vector getChannels() {
	return (Vector)channels.clone();// return a copy rather than the object
    }

    public int getNumChannels() {
	return channels.size();
    }

    public Channel getChannel(int numChannel) {
	return (Channel)channels.elementAt(numChannel);
    }

    public void mouseMoved(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e)
    {
      /*Dimension d = getSize();

      if (valueTest) {
	Point2D virt_drag = screenToVirtual(new Point2D.Double(e.getX(), e.getY()));
	Point2D dp = findNearestX(testChannel, virt_drag);
	if (dp != null) {
	    valueX = (int)Math.round(dp.getX());
	    valueY = (int)Math.round(dp.getY());
	}

      } else if (highlight_start != null) {
	highlight_end.x = e.getX();
     	highlight_end.y = e.getY();
      }
      repaint(100);
      e.consume();*/
    }
    /* Set zoom to selected rectangle. */
    public void mouseReleased(MouseEvent e)
    {
	/*removeMouseMotionListener(this);
	if( highlight_start != null )
	    set_zoom();
	valueTest = false;
	testChannel = null;
	highlight_start = null;
	highlight_end = null;
	e.consume();
	repaint(100);*/
    }

    public void mousePressed(MouseEvent e)
    {
      /*addMouseMotionListener(this);

      // Check to see if mouse clicked near plot
      Dimension d = getSize();
      double  xVal,yVal;
      Point2D virt_click = screenToVirtual(new Point2D.Double(e.getX(), e.getY()));
      for(Enumeration i = channels.elements(); i.hasMoreElements();) {
	  Channel data = (Channel) i.nextElement();
	  Point2D dp = findNearestX(data, virt_click);
	  if (dp != null) {
	      if (Math.abs(dp.getY() - virt_click.getY()) <= (top-bottom)/10) {
		  valueTest = true;
		  testChannel = data;
		  valueX = (int)dp.getX();
		  valueY = (int)dp.getY();
	      }
	  }
      }

      if (!valueTest) {
	highlight_start = new Point();
	highlight_end = new Point();
	highlight_start.x = e.getX();
	highlight_start.y = e.getY();
	highlight_end.x = e.getX();
	highlight_end.y = e.getY();
      }
      repaint(100);
      e.consume();*/
    }

    public void start() {}
    public void stop() {}

    //double buffer the graphics.
    private Image offscreen;
    private Dimension offscreensize;
    private Graphics offgraphics;
    private Graphics g;
    private int year = new Date().getYear()+1900;

    public void setMinimumX(int x)
    {
        minimum_x = x;
    }

    public void setMaximumX(int x)
    {
        maximum_x = x;
    }

    public synchronized void paintComponent(Graphics g)
    {
	//get the size of the window.
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
	Dimension d = getSize();
	//get the end value of the window.
	int end = this.end;
	//blank the screen.
	if (reverseColor)
        {
            g2d.setColor(Color.black);
        }
        else
        {
            g2d.setColor(Color.white);
        }
	g2d.fillRect(0, 0, d.width, d.height);

	// Draw axes
	Point2D origin;

	// Prevent tics from being too small
        //System.out.println(start+" / "+end);
        double xTicSpacing = ((end - start)/20.00);
	double yTicSpacing = ((top - bottom)/20.00);
        origin = new Point2D.Double(Math.floor(start + ((end - start) * X_AXIS_POSITION)),
				    Math.floor(bottom + ((top - bottom) * Y_AXIS_POSITION)));
        //origin = new Point2D.Double(0.0, 300.0);

	Color xColor,yColor;
        if (reverseColor)
        {
            xColor = Color.white;
            yColor = Color.white;
        }
        else
        {
            xColor = Color.blue;
            yColor = Color.blue;
        }


	for (Enumeration i = channels.elements(); i.hasMoreElements(); )
        {
	    Channel c = (Channel) i.nextElement();
            if (c.isActive())
            {
                //year = c.getYear();
		g2d.setColor(c.getPlotColor());
		draw_data(g2d, c, start, end);
	    }
	}
        
	if (enableGrid) drawGridLines(g2d, origin, xTicSpacing, yTicSpacing);
	if (enableAxis) drawAxisAndTics(g2d, origin, start, end, top, bottom, xTicSpacing, yTicSpacing, xColor, yColor);
        if (limitLine) drawLimit(g2d, origin);
	//draw the highlight box if there is one.
	draw_highlight(g2d);

	//draw the input channels.
        
	// Draw the value tester line if needed
	if (valueTest)
        {
          g2d.setFont(new Font("Default", Font.PLAIN, 12));
	  g2d.setColor(new Color((float)0.9, (float)0.9, (float)1.0));
	  Point2D vt = virtualToScreen(new Point2D.Double((double)valueX, (double)valueY));
	  g2d.drawLine((int)vt.getX(), 0, (int)vt.getY(), d.height);
	  g2d.drawRect((int)vt.getX() - 3, (int)vt.getY() - 3, 6, 6);
	  if (isHexAxis())
          {
	      g2d.drawString("["+valueX+",0x"+Integer.toHexString(valueY)+"]", (int)vt.getX()+15, (int)vt.getY()-15);
	  } 
          else
          {
	      g2d.drawString("["+valueX+","+valueY+"]", (int)vt.getX()+15, (int)vt.getY()-15);
	  }
	}

        if (enableAlarmIcon)
        {
            drawAlarm(g2d, origin, agdVector, start, end);
            drawFixedAlarm(g2d, origin, agdFixedVector, start, end);
        }
	if (enableLegend) drawLegend(g2d);

	//transfer the constructed image to the screen.
	//	g.drawImage(offscreen, 0, 0, null);
    }

    // Draw the grid lines
    public void drawGridLines(Graphics offgraphics, Point2D origin,
	double xTicSpacing, double yTicSpacing )
    {
        if (reverseColor)
        {
            offgraphics.setColor(new Color((float)0.08, (float)0.25, (float)0.08));
        }
        else
        {
            offgraphics.setColor(new Color((float)0.75, (float)0.95, (float)0.75));
        }

      int i = 0;
      Point2D.Double virt, screen;

      virt = (Point2D.Double) origin.clone();//new Point2D(origin.x, origin.y);
      screen = virtualToScreen(virt);
      // draw X axis negative
      while (screen.x < getSize().width)
      {
	offgraphics.drawLine((int)screen.x, 0, (int)screen.x, getSize().height);
	virt.setLocation(virt.getX()+xTicSpacing,virt.getY());
	screen = virtualToScreen(virt);
      }
      // draw X axis positive
      virt =  (Point2D.Double) origin.clone();
      screen = virtualToScreen(virt);
      while (screen.x >= 0)
      {
	offgraphics.drawLine((int)screen.x, 0, (int)screen.x, getSize().height);
	virt.setLocation(virt.getX() - xTicSpacing, virt.getY());
	screen = (Point2D.Double)virtualToScreen(virt);
      }

      // draw Y axis negative
      virt =  (Point2D.Double) origin.clone();
      screen = (Point2D.Double)virtualToScreen(virt);
      while (screen.y < getSize().height)
      {
	offgraphics.drawLine(0, (int)screen.y, getSize().width, (int)screen.y);
	virt.setLocation(virt.getX(), virt.getY() - yTicSpacing);
	screen = (Point2D.Double)virtualToScreen(virt);
      }
      // draw Y axis positive
      virt = (Point2D.Double) origin.clone();
      screen = (Point2D.Double)virtualToScreen(virt);
      while (screen.y >= 0)
      {
	offgraphics.drawLine(0, (int)screen.y, getSize().width, (int)screen.y);
	virt.setLocation(virt.getX(), virt.getY() + yTicSpacing);
	screen = (Point2D.Double)virtualToScreen(virt);
      }
    }

    

    void drawLimit(Graphics offgraphics, Point2D origin)
    {
        Point2D virt = new Point2D.Double(origin.getX(), origin.getY());
	Point2D screen = virtualToScreen(virt);
        int c = 0;
        offgraphics.setColor(new Color((float)1,(float)0,(float)0));
        Graphics2D g2d = (Graphics2D) offgraphics;
	while (c <= 6)
        {
            switch (c)
            {
                case 0:
                    g2d.setColor(new Color(55,255,55,185));
                    break;
                case 1:
                case 4:
                    g2d.setColor(new Color(255,180,30,185));
                    break;
                case 2:
                case 5:
                    g2d.setColor(new Color(255,100,0,185));
                    break;
                case 3:
                case 6:
                    g2d.setColor(new Color(255,0,0,255));
                    break;
            }
            virt.setLocation(end,(limitSet[c])*100.0);
	    screen = virtualToScreen(virt);
            g2d.setStroke(dashed);
            //offgraphics.drawLine(0, (int)screen.getY(), (int)screen.getX(), (int)screen.getY());
            g2d.drawLine(0, (int)screen.getY(), (int)screen.getX(), (int)screen.getY());
            c++;
	}
        g2d.setStroke(defaultStroke);
    }

    void drawAxisAndTics(Graphics offgraphics, Point2D origin,
			 int start, int end, double top, double bottom,
			 double xTicSpacing, double yTicSpacing,
			 Color xColor, Color yColor)
    {

	int i;

	// Draw axis lines
	Point2D origin_screen = virtualToScreen(origin);
	offgraphics.setColor(xColor);
	offgraphics.drawLine(0, (int)origin_screen.getY(), getSize().width, (int)origin_screen.getY());
	offgraphics.setColor(yColor);
	offgraphics.drawLine((int)origin_screen.getX(), 0, (int)origin_screen.getX(), getSize().height);

	// Draw the tic marks and numbers
	offgraphics.setFont(new Font("Default", Font.PLAIN, 10));
	offgraphics.setColor(yColor);

	Point2D virt, screen;
	boolean label;

	// Y axis /////////////////////////////////////////////////////////////////
	label = true;
	virt = (Point2D) origin.clone();//new Point2D(origin.getX(), origin.y);
	screen = virtualToScreen(virt);
	while (screen.getY() < getSize().height)
        {
	    offgraphics.drawLine((int)screen.getX() - 5, (int)screen.getY(), (int)screen.getX() + 5, (int)screen.getY());
	    if (label)
            {
		offgraphics.drawLine((int)screen.getX() - 5, (int)screen.getY()+1, (int)screen.getX() + 5, (int)screen.getY()+1);
		String tickstr;
		int xsub;
		if (isHexAxis())
                {
		    int tmp = (int)(virt.getY());
		    tickstr = "0x"+Integer.toHexString(tmp);
		    xsub = 40;
		} 
                else
                {
		    tickstr = new Double(virt.getY()/100.0).toString();
		    xsub = 25;
		}
		offgraphics.drawString(tickstr, (int)screen.getX()-xsub, (int)screen.getY()-2);
		label = false;
	    } 
            else
            {
		label = true;
	    }
	    virt.setLocation(virt.getX(), virt.getY() - yTicSpacing);
	    screen = virtualToScreen(virt);
	}

	label = false;
	virt = new Point2D.Double(origin.getX(), origin.getY() + yTicSpacing);
	screen = virtualToScreen(virt);
	while (screen.getY() >= 0)
        {
            if (reverseColor)
            {
                offgraphics.setColor(new Color((float)1,(float)1,(float)1));
            }
            else
            {
                offgraphics.setColor(Color.blue);
            }
	    offgraphics.drawLine((int)screen.getX() - 5, (int)screen.getY(), (int)screen.getX() + 5, (int)screen.getY());
	    if (label)
            {
                if (reverseColor)
                {
                    offgraphics.setColor(new Color(255,255,0));
                }
                else
                {
                    offgraphics.setColor(Color.blue);
                }
		offgraphics.drawLine((int)screen.getX() - 5, (int)screen.getY()+1, (int)screen.getX() + 5, (int)screen.getY()+1);
                //offgraphics.setColor(new Color(255,255,255));

                String tickstr;
		int xsub;
		if (isHexAxis()) {
		    int tmp = (int)(virt.getY());
		    tickstr = "0x"+Integer.toHexString(tmp);
		    xsub = 40;
		} else {
		    tickstr = new Double(virt.getY()/100.0).toString();
                    //System.out.println(virt.getY()+"/"+100.0+" = "+tickstr);
		    xsub = 25;
		}
		offgraphics.drawString(tickstr, (int)screen.getX()-xsub, (int)screen.getY()-2);
		label = false;
	    } 
            else
            {
		label = true;
	    }
	    virt.setLocation(virt.getX(), virt.getY() + yTicSpacing);
	    screen = virtualToScreen(virt);
	}

	// X axis /////////////////////////////////////////////////////////////////
	label = true;
	virt = (Point2D)origin.clone();//new Point2D(origin.getX(), origin.getY());
	screen = virtualToScreen(virt);
        int hold = 2;
        //int xx = (int) (getSize().width / xTicSpacing);
        //if (xx < 15) hold = 2;
        //else if (xx < 200) hold = 1;
        int holder = hold;
        int displayYear = year;
        int offsetDay = 0;
	while (screen.getX() < getSize().width)
        {
	    
            if (reverseColor)
            {
                offgraphics.setColor(new Color((float)1,(float)1,(float)1));
            }
            else
            {
                offgraphics.setColor(Color.blue);
            }
            offgraphics.drawLine((int)screen.getX(), (int)screen.getY() - 5, (int)screen.getX(), (int)screen.getY() + 5);
	    if (label)
            {
                if (reverseColor)
                {
                    offgraphics.setColor(new Color(255,255,0));
                }
                else
                {
                    offgraphics.setColor(Color.blue);
                }
                offgraphics.drawLine((int)screen.getX()+1, (int)screen.getY() - 5, (int)screen.getX()+1, (int)screen.getY() + 5);
                //offgraphics.setColor(new Color(255,255,255));
                //System.out.println("OFFSETDAY = "+offsetDay);
                //System.out.println("virt.getX = "+virt.getX());

                /*int totalDay = (int) (((virt.getX()/60) /60) /24) - offsetDay;
                int hour =(int) (((virt.getX()/60) /60) %24);
                int min = (int) ((virt.getX() /60) %60);
                int sec = (int) (virt.getX() %60);
                if (displayYear%4 == 0 && (totalDay) > 366)
                {
                    displayYear += 1;
                    offsetDay += 366;
                    totalDay -= offsetDay;
                }
                else if(displayYear % 4 != 0 && (totalDay) > 365)
                {
                    displayYear += 1;
                    offsetDay += 365;
                    totalDay -= offsetDay;
                }
                int day = HydeFormat.dateFilter(totalDay,displayYear);
                int month = HydeFormat.monthFilter(totalDay,displayYear);*/
                Date d = new Date();
                d.setTime((long) virt.getX()*1000);
		String tickstr = "["+(d.getMonth()+1)+"/"+d.getDate()+"] "+dF.format(d.getHours())+":"+dF.format(d.getMinutes())+":"+dF.format(d.getSeconds());
		//String tickstr = "["+month+"/"+day+"] "+dF.format(hour)+":"+dF.format(min)+":"+dF.format(sec);
		offgraphics.drawString(tickstr, (int)screen.getX()-30, (int)screen.getY()+15);
		label = false;
	    } 
            else
            {
                
                if (holder <= 0)
                {
                    label = true;
                    holder = hold;
                    //System.out.println("hold = "+hold);
                }
                else
                {
                    holder--;
                }
	    }
	    virt.setLocation(virt.getX()+ xTicSpacing, virt.getY());
	    screen = virtualToScreen(virt);
	}

        // Minus axis
	/*label = false;
	virt = new Point2D.Double(origin.getX() - xTicSpacing, origin.getY());
	screen = virtualToScreen(virt);
	while (screen.getX() >= 0)
        {
	    offgraphics.drawLine((int)screen.getX(), (int)screen.getY() - 5, (int)screen.getX(), (int)screen.getY() + 5);
	    if (label)
            {
                int day = (int) (((virt.getX()/60) /60) /24);
		int hour = (int) ((virt.getX() / 60) /60);
                int min = (int) ((virt.getX() / 60) %60);
                int sec = (int) (virt.getX() %60);
		String tickstr = "["+day+"] "+dF.format(hour)+":"+dF.format(min)+":"+dF.format(sec);
		offgraphics.drawString(tickstr, (int)screen.getX()-15, (int)screen.getY()+15);
		label = false;
	    } 
            else
            {
		label = true;
	    }
	    virt.setLocation(virt.getX() - xTicSpacing, virt.getY());
	    screen = virtualToScreen(virt);
	}*/

	Graphics2D g2d = (Graphics2D) offgraphics;
	AffineTransform at = g2d.getTransform();
	Font f = g2d.getFont();
	offgraphics.setFont(new Font("Default", Font.BOLD, 12));
	FontMetrics fm = g2d.getFontMetrics();
	screen = virtualToScreen((Point2D) origin);
	if (getYLabel() != null)
        {
	    int lWidth = fm.stringWidth(getYLabel());
	    int ypos = (int) (screen.getY() + lWidth)/2 ;
	    int xpos = (int) (screen.getX() - 30 - fm.getHeight()/2);
	    //	    System.out.println("XPosition: " + xpos+ "YPosition"+ypos);
	    AffineTransform at1 = new AffineTransform();
	    at1.setToRotation(-Math.PI/2.0, xpos, ypos);
	    g2d.setTransform(at1);
	    g2d.drawString(getYLabel(), xpos, ypos);
	}
	g2d.setTransform(at);

	if (getXLabel() != null) {
	    int lWidth = fm.stringWidth(getXLabel());
	    int xpos = (int) (screen.getX() + getWidth() -lWidth)/2;
	    int ypos = (int) (screen.getY() + fm.getHeight()/2 + 30);
	    g2d.drawString(getXLabel(), xpos, ypos);
	}
	g2d.setFont(f);
    }


    public void drawLegend( Graphics offgraphics )
    {
	Channel c;
	Graphics2D g2d = (Graphics2D) offgraphics;
	// Draw the legend
	if( isLegendEnabled() ) {
	    FontMetrics fm = g2d.getFontMetrics();
	    int width = 10;
	    int _width;
	    int activeChannels=0,curChan=0;
	    for (Enumeration i = channels.elements(); i.hasMoreElements(); ) {
		c = (Channel)i.nextElement();
		if (c.isActive()) {
		    activeChannels++;
		    _width = fm.stringWidth(c.getDataLegend());
		    if (_width > width)
			width = _width;

		}
	    }

	    if( activeChannels == 0 )
		return;

	    int h = fm.getHeight();
	    activeChannels++; //add a font height to the legend box.

	    if (reverseColor)
            {
                offgraphics.setColor(Color.black);
            }
            else
            {
                offgraphics.setColor(Color.white);
            }
	    offgraphics.fillRect( getSize().width-20-40-width, /*getSize().height-20-h*activeChannels*/20, width+40, h*activeChannels );
	    if (reverseColor)
            {
                offgraphics.setColor(Color.white);
            }
            else
            {
                offgraphics.setColor(Color.black);
            }
	    offgraphics.drawRect( getSize().width-20-40-width, /*getSize().height-20-h*activeChannels*/20, width+40, h*activeChannels );
	    Line2D l = new Line2D.Double();
            int order = 1;
	    for (Enumeration i = channels.elements(); i.hasMoreElements(); )
            {
		c = (Channel) i.nextElement();
		if( c.isActive() )
                {
		    if (reverseColor)
                    {
                        offgraphics.setColor(Color.white);
                    }
                    else
                    {
                        offgraphics.setColor(Color.black);
                    }
                    offgraphics.drawString( order+":"+c.getDataLegend(), getSize().width-20-10-width, /*getSize().height-20 - h/2-h*curChan*/20+h/2+h*(curChan+1) );
                    offgraphics.setColor(c.getPlotColor());
                    g2d.setStroke(c.getPlotStroke());
                    l.setLine(getSize().width-20-35-width, /*getSize().height-20-h*(curChan+1)+h/4*/20+h*(curChan+1)+h/4, getSize().width-20-15-width, /*getSize().height-20-h*(curChan+1)+h/4*/20+h*(curChan+1)+h/4);
                    g2d.draw( l  );
                    curChan++;
                    order++;
		}
	    }
	}
    }

    //return the difference between the two input vectors.

    public Vector diff(Iterator a, Iterator b){
	Vector vals = new Vector();
	while(a.hasNext() && b.hasNext()){
	    vals.add(new Double((((Double)b.next()).doubleValue() - ((Double)a.next()).doubleValue())));
	}
	return vals;
    }

    //draw the highlight box.
    public void draw_highlight(Graphics g){
    	if(highlight_start == null) return;
	int x, y, h, l;
	x = Math.min(highlight_start.x, highlight_end.x);
	y = Math.min(highlight_start.y, highlight_end.y);
	l = Math.abs(highlight_start.x - highlight_end.x);
	h = Math.abs(highlight_start.y - highlight_end.y);
	g.setColor(Color.white);
	g.fillRect(x,y,l,h);
    }

    public String alarmIconIsHere(int posx, int posy)
    {
      Point2D virt = new Point2D.Double();
      Point2D screen = new Point2D.Double();
      for(int i = 0; i < agdVector.size(); i ++)
      {
	AlarmGraphData agd = (AlarmGraphData) agdVector.elementAt(i);
	if( agd != null)
        {
	  if (agd.alarmTimeLong >= start && agd.alarmTimeLong < end)
          {
              virt.setLocation(agd.alarmTimeLong, top);
              screen = virtualToScreen(virt);
              if (posy >= 10 && posy <= (10+alarmingIcon.getHeight(this)))
              {
                  if (posx >= (int)screen.getX()-(alarmingIcon.getWidth(this)/2) && posx <= (int)screen.getX()+(alarmingIcon.getWidth(this)/2))
                  {
                      return "ac"+agd.alarmID;
                  }
              }
	  }
	}
      }
      for(int i = 0; i < agdFixedVector.size(); i ++)
      {
	AlarmGraphData agd = (AlarmGraphData) agdFixedVector.elementAt(i);
	if( agd != null)
        {
	  if (agd.alarmTimeLong >= start && agd.alarmTimeLong < end)
          {
              virt.setLocation(agd.alarmTimeLong, top);
              screen = virtualToScreen(virt);
              if (posy >= 10 && posy <= (10+alarmingIcon.getHeight(this)))
              {
                  if (posx >= (int)screen.getX()-(alarmingIcon.getWidth(this)/2) && posx <= (int)screen.getX()+(alarmingIcon.getWidth(this)/2))
                  {
                      return "fs"+agd.alarmID;
                  }
              }
	  }
          if (agd.alarmFixedTimeLong >= start && agd.alarmFixedTimeLong < end)
          {
              virt.setLocation(agd.alarmFixedTimeLong, top);
              screen = virtualToScreen(virt);
              if (posy >= 10 && posy <= (10+alarmingIcon.getHeight(this)))
              {
                  if (posx >= (int)screen.getX()-(alarmingIcon.getWidth(this)/2) && posx <= (int)screen.getX()+(alarmingIcon.getWidth(this)/2))
                  {
                      return "fe"+agd.alarmID;
                  }
              }
          }
	}
      }
      return null;
    }

    public void drawAlarm(Graphics g, Point2D origin, Vector _data, int start, int end)
    {
      Point2D virt = new Point2D.Double(origin.getX(), origin.getY());
      Point2D screen = virtualToScreen(virt);
      Vector data = _data;
      Graphics2D g2d = (Graphics2D) g;
      for(int i = 0; i < data.size(); i ++)
      {
	AlarmGraphData agd = (AlarmGraphData) data.elementAt(i);
	if( agd != null)
        {
	  if (agd.alarmTimeLong >= start && agd.alarmTimeLong < end)
          {
            virt.setLocation(agd.alarmTimeLong, top);
            screen = virtualToScreen(virt);
            g2d.setColor(new Color((float)1,(float)0,(float)0));
            g2d.setStroke(alarmStroke);
            g2d.drawLine((int)screen.getX(), 0, (int)screen.getX(), getWidth());
            g2d.drawImage(alarmingIcon, (int)screen.getX()-(alarmingIcon.getWidth(this)/2), 10,this);
	  }
	}
      }
      g2d.setStroke(defaultStroke);
    }

    public void drawFixedAlarm(Graphics g, Point2D origin, Vector _data, int start, int end)
    {

      Point2D virt = new Point2D.Double(origin.getX(), origin.getY());
      Point2D screen = virtualToScreen(virt);
      Vector data = _data;
      Graphics2D g2d = (Graphics2D) g;
      for(int i = 0; i < data.size(); i ++)
      {
	AlarmGraphData agd = (AlarmGraphData) data.elementAt(i);
	if( agd != null)
        {
	  if (agd.alarmTimeLong >= start && agd.alarmTimeLong < end)
          {
            virt.setLocation(agd.alarmTimeLong, top);
            screen = virtualToScreen(virt);
            g2d.setColor(new Color((float)1,(float)0.5,(float)0.2));
            g2d.setStroke(alarmStroke);
            g2d.drawLine((int)screen.getX(), 0, (int)screen.getX(), getWidth());
            g2d.drawImage(alarmIcon, (int)screen.getX()-(alarmIcon.getWidth(this)/2), 10,this);
	  }
          if (agd.alarmFixedTimeLong >= start && agd.alarmFixedTimeLong < end)
          {
            virt.setLocation(agd.alarmFixedTimeLong, top);
            screen = virtualToScreen(virt);
            g2d.setColor(new Color((float)0.3,(float)0.8,(float)0.3));
            g2d.setStroke(alarmStroke);
            g2d.drawLine((int)screen.getX(), 0, (int)screen.getX(), getWidth());
            g2d.drawImage(alarmFixedIcon, (int)screen.getX()-(alarmFixedIcon.getWidth(this)/2), 10,this);
	  }
	}
      }
      g2d.setStroke(defaultStroke);
    }

    public void draw_data(Graphics g, Channel data, int start, int end)
    {
    	draw_data(g,data, start, end, 1);
    }

    //scale multiplies a signal by a constant factor.
    public void draw_data(Graphics g, Channel _data, int start, int end, int scale)
    {
      Point2D screen = null, screen2 = null;
      boolean noplot=true;  // Used for line plotting
      Vector data = _data.getData();
      
      //      System.out.println("Will plot " + data.size() +" points");
      Graphics2D g2d = (Graphics2D) g;
      Stroke savedStroke = g2d.getStroke();
      g2d.setStroke(_data.getPlotStroke());
      for(int i = 0; i < data.size(); i ++){
	Point2D virt;
	Line2D l = new Line2D.Double();
	//map each point to a x,y position on the screen.
	if((virt = (Point2D)data.get(i)) != null) {
             //System.out.println("virt1 "+virt);
           //System.out.println("virtualToScreen(virt); "+virtualToScreen(virt));  
	  screen = virtualToScreen(virt);
	  if (screen.getX() >= 0 && screen.getX() < getSize().width) {
	      if(connectPoints && !noplot) {
		  l.setLine(screen, screen2);

		  g2d.draw(l);
		  //	      g.drawLine((int)screen2.getX(),
		  //	      (int)screen2.getY(), (int)screen.getX(),
		  //	      (int)screen.getY());
              
	      }
	    else if( !connectPoints )
	      g.drawRect((int)screen.getX(), (int)screen.getY(), 1, 1);
              //g.drawRect((int)screen.getX(), (int)screen.getY(), 1, 1);
	    if (noplot) noplot = false;
	  } else {
	    noplot = true;
	  }
          
	}
	screen2 = screen;
        
        
      }
            Line2D l2 = new Line2D.Double();
            Line2D l3 = new Line2D.Double();
            
            double yoff = upper_y - bottom;
            double ypos = yoff / (top*1.0 - bottom*1.0);
            double screen_ypos = getSize().height - (ypos * getSize().height);
            g2d.setColor(Color.RED);
            //g2d.drawLine(upper_x, (int)screen_ypos,upper_x+1300,(int) screen_ypos);
            l2.setLine(upper_x,screen_ypos,upper_x+1500,screen_ypos);
            g2d.draw(l2);
            g2d.drawString("Upper : "+Double.toString(upper_y/100), (float) upper_x + 35, (float) screen_ypos - 5);
            
            
            double yoff2 = lower_y - bottom;
            double ypos2 = yoff2 / (top*1.0 - bottom*1.0);
            double screen_ypos2 = getSize().height - (ypos2 * getSize().height);
            g2d.setColor(Color.blue);
            //g2d.drawLine(lower_x, (int) screen_ypos2,lower_x+1300,(int) screen_ypos2);
            l3.setLine(lower_x,screen_ypos2,lower_x+1500,screen_ypos2);
            g2d.draw(l3);
            g2d.drawString("Lower : "+Double.toString(lower_y/100), (float) lower_x + 35, (float) screen_ypos2 - 5);
         
        
        
     g2d.setStroke(savedStroke);    
        
       
         
    }
    public int get_height(){
        return getSize().height;
    }
    //functions for controlling zooming.
    public void move_up()
    {
	double height = top - bottom;
	//bottom += height/4;
	//top += height/4;
	bottom += 100+((height/100)-((height/100)%100));
	top += 100+((height/100)-((height/100)%100));
        
        
      
    }

    public void move_down()
    {
	double height = top - bottom;
	//bottom -= height/4;
	//top -= height/4;
	bottom -= 100+((height/100)-((height/100)%100));
	top -= 100+((height/100)-((height/100)%100));
        
    }

    public void move_right()
    {
	int width = end - start;
	//start += width/4;
	//end += width/4;
	start += 300+((width/30)-((width/30)%300));
	end += 300+((width/30)-((width/30)%300));
    }

    public void move_left()
    {
	int width = end - start;
	//start -= width/4;
	//end -= width/4;
	start -= 300+((width/30)-((width/30)%300));
	end -= 300+((width/30)-((width/30)%300));
    }

    public double lastMove = 0;
    public void moveToData(double ydata)
    {
        //if (lastMove != ydata)
        //{
            double height = top - bottom;
            /*System.out.println("YDATA = "+ydata);
            double ycenter = top - (height/2);
            System.out.println("TOP = "+top);
            System.out.println("ycenter = "+ycenter);
            if (ydata < 0) ydata *= -1;
            double ycenter2 = ycenter - ydata;
            System.out.println("ycenter2 = "+ycenter2);
            double newTop =(ycenter2+(height/2))-((ycenter2+(height/2))%100);
            System.out.println("newTop = "+newTop);*/

            double newTop = (ydata+(height/2))-((ydata+(height/2))%100);
            setYBounds(newTop, newTop-height);
            
            System.out.println("newtop "+newTop);
            //lastMove = ydata;
        //}
    }

    public void zoom_out_x()
    {
	int width = end - start;
	//start -= 6+((width/6)-((width/6)%6));
	//end += 6+((width/6)-((width/6)%6));
        if (width >= 12000)
        {
            start -= 600+((width/60)-((width/60)%600));
            end += 600+((width/60)-((width/60)%600));
        }
        else if(width >= 1200)
        {
            start -= 600;
            end += 600;
        }
        else if(width >= 120)
        {
            start -= 60;
            end += 60;
        }
        else if (width >= 12)
        {
            start -= 6;
            end += 6;
        }
    }

    public void zoom_out_y()
    {
	double height = top - bottom;
	//bottom -= height/2;
	//top += height/2;
        System.out.println("Top "+top);
         System.out.println("Buttom "+bottom);
         System.out.println("height "+height);   
        if (height >= 10000)
        {
            bottom -= 5000;
            top += 5000;
         
        }
        else if(height >= 1000)
        {
            bottom -= 500;
            top += 500;

        }
        else if(height >= 100)
        {
            bottom -= 50;
            top += 50;

        }
        else if (height >= 10)
        {
            bottom -= 5;
            top += 5;

        }

         System.out.println("Top2 "+top);
         System.out.println("Buttom2 "+bottom);
         System.out.println("height2 "+height);   
    }

    public void zoom_in_x()
    {
	int width = end - start;
	//start += 6+((width/6)-((width/6)%6));
	//end -= 6+((width/6)-((width/6)%6));
        if (width <= 12){}
        else if(width <= 120)
        {
            start += 6;
            end -= 6;
        }
        else if (width <= 1200)
        {
            start += 60;
            end -= 60;
        }
        else if (width <= 12000)
        {
            start += 600;
            end -= 600;
        }
        else
        {
            start += 600+((width/60)-((width/60)%600));
            end -= 600+((width/60)-((width/60)%600));
        }
    }

    public void zoom_in_y()
    {
	double height = top - bottom;
	//bottom += height/4;
        //top -= height/4;
        if (height <= 10){}
        else if(height <= 100)
        {
            bottom += 5;
            top -= 5;

        }
        else if (height <= 1000)
        {
            bottom += 50;
            top -= 50;

        }
        else if (height <= 10000)
        {
            bottom += 500;
            top -= 500;

        }
        else
        {
            bottom += 5000;
            top -= 5000;

        }
    }

    public void reset(){
	bottom = DEFAULT_BOTTOM;
	top = DEFAULT_TOP;
	start = DEFAULT_START;
	end = DEFAULT_END;
    }

    public void setOrigin(int start, int end)
    {
        DEFAULT_START = start;
        DEFAULT_END = end;
    }


    void set_zoom()
    {
	int base = getSize().height;
	int x_start = Math.min(highlight_start.x, highlight_end.x);
	int x_end = Math.max(highlight_start.x, highlight_end.x);
	int y_start = Math.min(highlight_start.y, highlight_end.y);
	int y_end = Math.max(highlight_start.y, highlight_end.y);

	if(Math.abs(x_start - x_end) < 10) return;
	if(Math.abs(y_start - y_end) < 10) return;

	Point2D topleft = screenToVirtual(new Point2D.Double((double)x_start, (double)y_start));
	Point2D botright = screenToVirtual(new Point2D.Double((double)x_end, (double)y_end));

	start = (int)topleft.getX();
	end = (int)botright.getX();
	top = topleft.getY();
	bottom = botright.getY();
    }

    /** Convert from virtual coordinates to screen coordinates. */
    Point2D.Double virtualToScreen(Point2D virt)
    {   
	double xoff = virt.getX() - start;
	double xpos = xoff / (end*1.0 - start*1.0);
	double screen_xpos = xpos * getSize().width;


	double yoff = virt.getY() - bottom;
	double ypos = yoff / (top*1.0 - bottom*1.0);
	double screen_ypos = getSize().height - (ypos * getSize().height);

	return new Point2D.Double(screen_xpos, screen_ypos);
    }

    Double virtualToScreenX(long getX)
    {
	double xoff = getX - start;
	double xpos = xoff / (end*1.0 - start*1.0);
	double screen_xpos = xpos * getSize().width;

	return screen_xpos;
    }

    /** Convert from screen coordinates to virtual coordinates. */
    Point2D screenToVirtual(Point2D screen) {
	double xoff = screen.getX();
	double xpos = xoff / (getSize().width * 1.0);
	double virt_xpos = start + (xpos * (end*1.0 - start*1.0));

	double yoff = screen.getY();
	double ypos = yoff / (getSize().height * 1.0);
	double virt_ypos = top - (ypos * (top*1.0 - bottom*1.0));

	return new Point2D.Double(virt_xpos, virt_ypos);
    }

    /** Find nearest point in 'data' to x-coordinate of given point. */
    Point2D findNearestX(Channel data, Point2D test)
    {
	return data.findNearestX(test);
    }
    
    public void trimGraph(int primary)
    {
        Channel c = (Channel) (channels.elementAt(primary));
        Point2D start = (Point2D) c.data.elementAt(0);
        Point2D end = (Point2D) c.data.elementAt(c.data.size()-1);
        int diff = (int) (end.getX() - start.getX());
        this.start = (int) start.getX();
        this.end = (int) end.getX();
        repaint(100);
    }

    public void clear_data()
    {
	int i;
	for (Enumeration e = channels.elements(); e.hasMoreElements(); ) {
	    Channel c = (Channel) e.nextElement();
	    c.clear();
	}
    }

    void save_data()
    {
	JFileChooser	file_chooser = new JFileChooser();
	File		savedFile;
	FileWriter	dataOut;
	int		retval,i,n;

	retval = file_chooser.showSaveDialog(null);
	if( retval == JFileChooser.APPROVE_OPTION ) {
	    try {
		savedFile = file_chooser.getSelectedFile();
		System.out.println( "Saved file: "+savedFile.getName() );
		dataOut = new FileWriter( savedFile );
		dataOut.write( "# Test Data File\n" );
		dataOut.write( "# "+(new Date())+"\n" );
		for (Enumeration e = channels.elements(); e.hasMoreElements(); ) {
		    Channel c =(Channel) e.nextElement();
		    c.saveData(dataOut);
		}
		dataOut.close();
	    } catch( IOException e ) {
		System.out.println( e );
	    }
	}
    }
//    Graphics g;
//    public void paintLine() {
//        super.paintComponent(g);
//            Graphics2D g2d = (Graphics2D) g;
//            //Point2D vt = virtualToScreen(new Point2D.Double(10, 10));
//            
//            g.setColor(Color.RED);
//            //g.drawLine(2, 90, 1000, 10);
//            g2d.drawLine(10, 10, 100, 10);
//        //}
//    }

    public void set_upper(double x,double y) {
         upper_x = x;
         upper_y = y;
    }
    public void set_lower(double x,double y) {
         lower_x = x;
         lower_y = y;
    }
}
	

