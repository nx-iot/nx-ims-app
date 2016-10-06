package ETM.MONITOR.PANEL;

import ETM.MAIN.FullFrame;
import ETM.MONITOR.DIALOG.BalloonEditDialog;
import ETM.MONITOR.DIALOG.BalloonOptionDialog;
import ETM.MONITOR.DIALOG.ZoneEditDialog;
import ETM.MONITOR.FloorPlanClock;
import ETM.STRUCTURE.Balloon;
import ETM.STRUCTURE.Zone;
import ETM.Util.HydeFormat;
import HydeModule.Image.HydeResizeImage;
import HydeModule.Table.HydeDataSet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.ImageIcon;

public final class FloorplanEffectPanel extends javax.swing.JPanel implements MouseListener, MouseMotionListener
{
    private int zone = 999;

    public String depart;
    public FloorplanPanel FPP;
    private FloorPlanClock FPC;

    private HydeResizeImage HRI = new HydeResizeImage();
    public BalloonOptionDialog BOD;

    public boolean fullSize = false;
    private boolean layer0 = false;
    private boolean layer1 = false;
    private boolean layer2 = false;
    private boolean layer3 = false;
    private boolean layer4 = false;
    private boolean displayZone = false;
    private boolean anyFloor = false;
    
    private boolean optionLayer = false;

    private String displayZoneText = "-";
    private int displayZoneX1;
    private int displayZoneX2;
    private int displayZoneY1;
    private int displayZoneY2;

    private int balloonMode = 10;
    private int zoneMode = 10;

    public boolean blankPage = true;

    public int scale = 1;
    public Image[] balloonAlert = new Image[5];
    public Image[] balloonBaseOn = new Image[5];
    public Image[] balloonBaseOff = new Image[5];
    public Image[] balloonBaseNA = new Image[5];
    public Image[] balloonTransmitterOn = new Image[5];
    public Image[] balloonTransmitterOff = new Image[5];
    public Image[] balloonTransmitterNA = new Image[5];
    public Image[] balloonRepeater = new Image[5];
    public Image[] balloonNeutral = new Image[5];
    public Image[] balloonSelect = new Image[5];

    public Image[] system = new Image[5];
    public Image[] user = new Image[5];

    public ImageIcon previous = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/left_green_arrow_24.png"));
    public ImageIcon next = new javax.swing.ImageIcon(getClass().getResource("/Picz/Button24/right_green_arrow_24.png"));
    public ImageIcon error = new javax.swing.ImageIcon(getClass().getResource("/Picz/Animate/error.gif"));


    String any;

    public FloorplanEffectPanel(FloorplanPanel FPP, String depart)
    {
        this.FPP = FPP;
        this.depart = depart;

        any = "1111111111111";
        if (any == null)
        {
            any = "0000";
        }
        if (any.charAt(1) == '0')
        {
            anyFloor = false;
        }
        else
        {
            anyFloor = true;
        }

        initComponents();
        extendComponents();
        actionComponents();
    }

    private void extendComponents()
    {
        balloonAlert[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/alert_balloon_1.gif"))).getImage();
        balloonAlert[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/alert_balloon_2.gif"))).getImage();
        balloonAlert[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/alert_balloon_4.gif"))).getImage();

        balloonBaseOn[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_on_1.png"))).getImage();
        balloonBaseOn[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_on_2.png"))).getImage();
        balloonBaseOn[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_on_4.png"))).getImage();

        balloonBaseOff[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_off_1.png"))).getImage();
        balloonBaseOff[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_off_2.png"))).getImage();
        balloonBaseOff[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_off_4.png"))).getImage();

        balloonBaseNA[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_na_1.png"))).getImage();
        balloonBaseNA[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_na_2.png"))).getImage();
        balloonBaseNA[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/base_na_4.png"))).getImage();

        balloonRepeater[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/repeater_1.png"))).getImage();
        balloonRepeater[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/repeater_2.png"))).getImage();
        balloonRepeater[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/repeater_4.png"))).getImage();

        balloonTransmitterOn[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_on_1.png"))).getImage();
        balloonTransmitterOn[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_on_2.png"))).getImage();
        balloonTransmitterOn[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_on_4.png"))).getImage();

        balloonTransmitterOff[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_off_1.png"))).getImage();
        balloonTransmitterOff[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_off_2.png"))).getImage();
        balloonTransmitterOff[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_off_4.png"))).getImage();

        balloonTransmitterNA[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_na_1.png"))).getImage();
        balloonTransmitterNA[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_na_2.png"))).getImage();
        balloonTransmitterNA[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/transmitter_na_4.png"))).getImage();

        balloonNeutral[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_1.png"))).getImage();
        balloonNeutral[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_2.png"))).getImage();
        balloonNeutral[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_4.png"))).getImage();

        balloonSelect[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/radial_1.png"))).getImage();
        balloonSelect[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/radial_2.png"))).getImage();
        balloonSelect[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/radial_4.png"))).getImage();

        system[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/system_1.png"))).getImage();
        system[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/system_2.png"))).getImage();
        system[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/system_4.png"))).getImage();

        user[1] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/user_1.png"))).getImage();
        user[2] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/user_2.png"))).getImage();
        user[4] = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/user_4.png"))).getImage();

        FPC = new FloorPlanClock(this);
        Thread T = new Thread(FPC);
        T.start();
    }

    private void actionComponents()
    {
         addMouseListener(this);
         addMouseMotionListener(this);
    }

    public void setScale(int scale)
    {
        this.scale = scale;
    }

    int fullWidth = 2300;
    int fullHeight = 2300;
    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

	Dimension d = getSize();
	//get the end value of the window.
        scrollOffsetX = FPP.floorScroll.getHorizontalScrollBar().getValue();
        scrollOffsetY = FPP.floorScroll.getVerticalScrollBar().getValue();

        if (blankPage)
        {
            //blank the screen.
            g2d.setColor(new Color(240,240,240));
            g2d.fillRect(0, 0, d.width, d.height);
        }
        else
        {
            //blank the screen.
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, d.width, d.height);
            //ImageIcon II = new javax.swing.ImageIcon(getClass().getResource("/Picz/map/"+FPP.MIF.floor+"_"+scale+".jpg"));
            ImageIcon II = new javax.swing.ImageIcon(FPP.MIF.MF.SD.DIR+"/floorplan/"+FPP.floor+"_"+scale+".jpg");
            /*ImageIcon map = new javax.swing.ImageIcon(getClass().getResource("/Picz/map/"+FPP.MIF.floor+".jpg"));
            BufferedImage BI = HydeResizeImage.createResizedCopy(map.getImage(), map.getIconWidth()/(4/scale), map.getIconHeight()/(4/scale), false);
            ImageIcon II = new javax.swing.ImageIcon(BI);*/
            int iheight = II.getImage().getHeight(null);
            int iwidth = II.getImage().getWidth(null);
            fullHeight = iheight;
            fullWidth = iwidth;
            offsetX = (d.width/2)-(iwidth/2);
            offsetY = (d.height/2)-(iheight/2);
            this.setPreferredSize(new Dimension(iwidth,iheight));
            g2d.drawImage(II.getImage(), offsetX, offsetY, this);


            if (zoneMode == 9)
            {
                g2d.setColor(new Color(100,200,100,160));
                g2d.drawRect((zoneScreenX+offsetX), (zoneScreenY+offsetY), cursorX-(zoneScreenX+offsetX), cursorY-(zoneScreenY+offsetY));

                g2d.setColor(new Color(100,200,100,60));
                g2d.fillRect((zoneScreenX+offsetX), (zoneScreenY+offsetY), cursorX-(zoneScreenX+offsetX), cursorY-(zoneScreenY+offsetY));
            }
            
            if (layer4)
            {
                Enumeration enu = FPP.MIF.zoneVector.elements();
                while(enu.hasMoreElements())
                {
                    Zone z = (Zone) enu.nextElement();
                    if (z.getFloorID().equals(FPP.floor))
                    {
                        int absoluteX1 = offsetX + (z.getX1()/(4/scale));
                        int absoluteY1 = offsetY + (z.getY1()/(4/scale));
                        int absoluteX2 = offsetX + (z.getX2()/(4/scale));
                        int absoluteY2 = offsetY + (z.getY2()/(4/scale));

                        if (z.getLocationID() == null)
                        {
                            g2d.setColor(new Color(100,100,100,160));
                            g2d.drawRect(absoluteX1, absoluteY1, absoluteX2-absoluteX1, absoluteY2-absoluteY1);
                            g2d.setColor(new Color(100,100,100,60));
                            g2d.fillRect(absoluteX1, absoluteY1, absoluteX2-absoluteX1, absoluteY2-absoluteY1);
                        }
                        else
                        {
                            g2d.setColor(new Color(200,200,0,150));
                            g2d.drawRect(absoluteX1, absoluteY1, absoluteX2-absoluteX1, absoluteY2-absoluteY1);
                            g2d.setColor(new Color(200,200,0,50));
                            g2d.fillRect(absoluteX1, absoluteY1, absoluteX2-absoluteX1, absoluteY2-absoluteY1);
                        }
                    }
                }
            }

            if (layer0)
            {
                int zoomScale = Integer.parseInt((String)FPP.scaleComboBox.getSelectedItem());
                g2d.setColor(Color.blue);
                g2d.drawRect(cursorX-iheight/(zoomScale*2), cursorY-iwidth/(zoomScale*2), iheight/zoomScale, iwidth/zoomScale);
                g2d.setColor(new Color(0,0,255,30));
                g2d.fillRect(cursorX-iheight/(zoomScale*2), cursorY-iwidth/(zoomScale*2), iheight/zoomScale, iwidth/zoomScale);
            }


            if (layer1)
            {
                Enumeration enu = FPP.MIF.balloonVector.elements();
                while(enu.hasMoreElements())
                {
                    Balloon b = (Balloon) enu.nextElement();
                    if (b.getFloorID().equals(FPP.floor))
                    {
                        int type = Integer.parseInt(b.getType());

                        int absoluteX = offsetX + (b.getX()/(4/scale));
                        int absoluteY = offsetY + (b.getY()/(4/scale));
                        if (type == 1)
                        {
                            Vector subx = b.getSubX();
                            Vector suby = b.getSubY();
                            Vector subType = b.getSubType();
                            Enumeration enux = subx.elements();
                            Enumeration enuy = suby.elements();
                            Enumeration enuType = subType.elements();
                            while (enux.hasMoreElements() && enuy.hasMoreElements() && enuType.hasMoreElements())
                            {
                                try
                                {
                                    int sx = Integer.parseInt((String) enux.nextElement());
                                    int sy = Integer.parseInt((String) enuy.nextElement());
                                    int st = Integer.parseInt((String) enuType.nextElement());
                                    int absoluteX2 = offsetX + (sx/(4/scale));
                                    int absoluteY2 = offsetY + (sy/(4/scale));
                                    g2d.setColor(new Color(180,180,0));
                                    switch (st)
                                    {
                                        case 3:
                                            g2d.setColor(new Color(180,180,0));
                                            break;
                                        case 2:
                                            g2d.setColor(new Color(70,100,180));
                                            break;
                                    }
                                    g2d.drawLine(absoluteX, absoluteY, absoluteX2, absoluteY2);
                                }
                                catch(NumberFormatException e)
                                {

                                }
                            }
                        }
                        
                    }
                }
            }
            if (currentPx != 0 || currentPy != 0)
            {
                int backLightX = offsetX-(balloonSelect[scale].getWidth(this)/2) + (currentPx/(4/scale));
                int backLightY = offsetY-(balloonSelect[scale].getHeight(this)/2) + (currentPy/(4/scale));
                g2d.drawImage(balloonSelect[scale], backLightX, backLightY, null);
            }

            if (layer2)
            {

                Enumeration enu = FPP.MIF.balloonVector.elements();
                while(enu.hasMoreElements())
                {
                    Balloon b = (Balloon) enu.nextElement();
                    if (b.getFloorID().equals(FPP.floor))
                    {
                        int type = Integer.parseInt(b.getType());

                        int absoluteX = offsetX-(balloonNeutral[scale].getWidth(this)/2) + (b.getX()/(4/scale));
                        int absoluteY = offsetY-(balloonNeutral[scale].getHeight(this)/2) + (b.getY()/(4/scale));
                        switch (type)
                        {
                            case 0:
                                g2d.drawImage(balloonNeutral[scale], absoluteX, absoluteY, null);
                                break;
                            case 1: // BASE
                                if (b.getStatus().equals("ON"))
                                {
                                    g2d.drawImage(balloonBaseOn[scale], absoluteX, absoluteY, null);
                                }
                                else if (b.getStatus().equals("OFF"))
                                {
                                    g2d.drawImage(balloonBaseOff[scale], absoluteX, absoluteY, null);
                                }
                                else if (b.getStatus().equals("N/A"))
                                {
                                    g2d.drawImage(balloonBaseNA[scale], absoluteX, absoluteY, null);
                                }
                                break;
                            case 2:
                                g2d.drawImage(balloonRepeater[scale], absoluteX, absoluteY, null);
                                break;
                            case 3:
                            case 5:
                                if (b.getStatus().equals("ON"))
                                {
                                    g2d.drawImage(balloonTransmitterOn[scale], absoluteX, absoluteY, null);
                                }
                                else if (b.getStatus().equals("OFF"))
                                {
                                    g2d.drawImage(balloonTransmitterOff[scale], absoluteX, absoluteY, null);
                                }
                                else if (b.getStatus().equals("N/A"))
                                {
                                    g2d.drawImage(balloonTransmitterNA[scale], absoluteX, absoluteY, null);
                                }
                                break;
                        }

                        int absoluteAlertX = offsetX-(balloonAlert[scale].getWidth(this)/2) + (b.getX()/(4/scale));
                        int absoluteAlertY = offsetY-(balloonAlert[scale].getHeight(this)/2) + (b.getY()/(4/scale));
                        if (b.getAlarmType() != null && b.getAlarmType().length() > 0 && !b.getAlarmType().equals("0"))
                        {
                            if (b.getAlarmType().equals("1"))
                            {
                                g2d.drawImage(user[scale], absoluteX-5, absoluteY-5, null);
                            }
                            else if(b.getAlarmType().equals("2"))
                            {
                                g2d.drawImage(system[scale], absoluteX-5, absoluteY-5, null);
                            }
                            else if(b.getAlarmType().equals("3"))
                            {
                                g2d.drawImage(balloonAlert[scale], absoluteAlertX, absoluteAlertY, null);
                            }
                        }

                    }
                }
            }

            

            /*if (layer3)
            {
                Enumeration enu = FPP.MIF.balloonVector.elements();
                while(enu.hasMoreElements())
                {
                    int sec = new Date().getSeconds()%5;
                    Balloon b = (Balloon) enu.nextElement();
                    int type = Integer.parseInt(b.getType());
                    int absoluteX = offsetX-8 + (b.getX()/(4/scale));
                    int absoluteY = offsetY-8 + (b.getY()/(4/scale));
                    int boxX = absoluteX-13;
                    int boxY = absoluteY-12;
                    if (absoluteY-12 < 12)
                    {
                        boxX = absoluteY+12;
                    }
                    g2d.setColor(new Color(0,200,0,255));
                    switch (type)
                    {
                        case 0:
                        case 1:
                        case 2:
                            break;
                        case 3:
                            g2d.drawRect(boxX, boxY, 51, 13);
                            g2d.setColor(new Color(0,0,0,180));
                            g2d.fillRect(boxX+1, boxY+1, 50, 12);
                            g2d.setColor(new Color(0,255,0,255));
                            g2d.drawString((sec+1)+"|"+b.probeData[sec]+"˚", boxX+2, boxY+11);
                            break;
                    }
                }
            }*/
            

            switch (balloonMode)
            {
                case 1:// Add
                    g2d.setColor(new Color(0,200,0));
                    g2d.drawRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,200,0,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click to add new balloon", cursorX+6, cursorY-6);
                    break;
                case 2:// Delete
                    g2d.setColor(new Color(200,0,0));
                    g2d.drawRect(cursorX+4, cursorY-19, 118, 15);
                    g2d.setColor(new Color(200,0,0,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 118, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click a balloon to delete", cursorX+6, cursorY-6);
                    break;
                case 3:// Edit
                    g2d.setColor(new Color(100,100,100));
                    g2d.drawRect(cursorX+4, cursorY-19, 105, 15);
                    g2d.setColor(new Color(100,100,100,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 105, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click a balloon to edit", cursorX+6, cursorY-6);
                    break;
            }
            switch (zoneMode)
            {
                case 1:// Add
                    g2d.setColor(new Color(0,200,0));
                    g2d.drawRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,200,0,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click to set start point", cursorX+6, cursorY-6);
                    break;
                case 9:// Add
                    g2d.setColor(new Color(0,200,200));
                    g2d.drawRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,200,200,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 120, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click to set end point ", cursorX+6, cursorY-6);
                    break;
                case 2:// Delete
                    g2d.setColor(new Color(200,0,0));
                    g2d.drawRect(cursorX+4, cursorY-19, 112, 15);
                    g2d.setColor(new Color(200,0,0,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 112, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click a zone to delete", cursorX+6, cursorY-6);
                    break;
                case 3:// Edit
                    g2d.setColor(new Color(100,100,100));
                    g2d.drawRect(cursorX+4, cursorY-19, 100, 15);
                    g2d.setColor(new Color(100,100,100,60));
                    g2d.fillRect(cursorX+4, cursorY-19, 100, 15);
                    g2d.setColor(new Color(0,0,0));
                    g2d.drawString("Click a zone to edit", cursorX+6, cursorY-6);
                    break;
            }


            if (displayZone)
            {
                if (cursorX > (displayZoneX1+offsetX) && cursorX < (displayZoneX2+offsetX)
                        && cursorY > (displayZoneY1+offsetY) && cursorY < (displayZoneY2+offsetY))
                {
                    g2d.setFont(new Font("Default",Font.BOLD,13));
                    g2d.setColor(new Color(200,30,200));
                    g2d.drawRect(cursorX+4, cursorY-19, (displayZoneText.length()*7)+10, 16);
                    g2d.setColor(new Color(200,30,200,60));
                    g2d.fillRect(cursorX+4, cursorY-19, (displayZoneText.length()*7)+10, 16);
                    g2d.setColor(new Color(20,20,20));
                    g2d.drawString(displayZoneText, cursorX+6, cursorY-6);
                }
            }
        }

            g2d.setFont(new Font("Default",Font.PLAIN,12));
            if (FPP.MIF.alertSign != null)
            {
                int a = 50;
                Enumeration enu = FPP.MIF.alertSign.elements();
                while (enu.hasMoreElements())
                {
                    String fn = (String) enu.nextElement();
                    g2d.setColor(new Color(255,0,0,30));
                    g2d.fillRect(9+scrollOffsetX, a+scrollOffsetY, 38+(fn.length()*6), 34);
                    g2d.setColor(new Color(255,0,0));
                    g2d.drawRect(9+scrollOffsetX, a+scrollOffsetY, 38+(fn.length()*6), 34);

                    g2d.drawImage(error.getImage(), 11+scrollOffsetX, a+2+scrollOffsetY, this);
                    g2d.drawString("Floor", 46+scrollOffsetX, a+13+scrollOffsetY);
                    g2d.drawString(fn, 46+scrollOffsetX, a+29+scrollOffsetY);
                    a += 50;

                }
            }
            
            if (currentDeviceName != null)
            {
                
                int a = 50;
                int mlen = currentDeviceName.length()*6;
                for (int i=0;i<currentChannelMax;i++)
                {
                    mlen = mlen > currentName[i].length()*6 ? mlen : currentName[i].length()*6;
                }
                g2d.setColor(new Color(0,255,0,30));
                g2d.fillRect(FPP.getWidth()+scrollOffsetX-mlen-38, 9+scrollOffsetY, 10+mlen, 20);
                g2d.setColor(new Color(0,180,0));
                g2d.drawRect(FPP.getWidth()+scrollOffsetX-mlen-38, 9+scrollOffsetY, 10+mlen, 20);
                
                g2d.drawString(currentDeviceName, FPP.getWidth()+scrollOffsetX-mlen-35, 24+scrollOffsetY);
                
                for (int i=0;i<currentChannelMax;i++)
                {
                    if (!currentData[i].equals("-DISABLE-"))
                    {
                        g2d.setColor(new Color(0,255,0,30));
                        g2d.fillRect(FPP.getWidth()+scrollOffsetX-mlen-38, a+scrollOffsetY, 10+mlen, 34);
                        g2d.setColor(new Color(0,180,0));
                        g2d.drawRect(FPP.getWidth()+scrollOffsetX-mlen-38, a+scrollOffsetY, 10+mlen, 34);

                        g2d.drawString(currentName[i], FPP.getWidth()+scrollOffsetX-mlen-35, a+13+scrollOffsetY);
                        g2d.drawString(" >> "+currentData[i], FPP.getWidth()+scrollOffsetX-mlen-35, a+29+scrollOffsetY);
                        a += 50;
                    }
                    else
                    {
                        g2d.setColor(new Color(100,100,100,30));
                        g2d.fillRect(FPP.getWidth()+scrollOffsetX-mlen-38, a+scrollOffsetY, 10+mlen, 34);
                        g2d.setColor(new Color(100,100,100));
                        g2d.drawRect(FPP.getWidth()+scrollOffsetX-mlen-38, a+scrollOffsetY, 10+mlen, 34);

                        g2d.drawString(currentName[i], FPP.getWidth()+scrollOffsetX-mlen-35, a+13+scrollOffsetY);
                        g2d.drawString(" >> "+currentData[i], FPP.getWidth()+scrollOffsetX-mlen-35, a+29+scrollOffsetY);
                        a += 50;
                    }
                }
            }

            int strLength = FPP.depart.length() * 6;
            int strLength2 = FPP.floorName.length() * 6;
            g2d.setColor(new Color(0,255,0,30));
            g2d.fillRect(9+scrollOffsetX, 9+scrollOffsetY, 52+(strLength > strLength2 ? strLength : strLength2), 26);
            g2d.setColor(new Color(0,180,0));
            g2d.drawRect(9+scrollOffsetX, 9+scrollOffsetY, 52, 26);
            g2d.drawRect(61+scrollOffsetX, 9+scrollOffsetY, (strLength > strLength2 ? strLength : strLength2), 26);
            g2d.drawImage(previous.getImage(), 10+scrollOffsetX, 10+scrollOffsetY, this);
            g2d.drawImage(next.getImage(), 36+scrollOffsetX, 10+scrollOffsetY, this);

            g2d.setColor(new Color(0,140,0));
            g2d.drawString(FPP.depart, 65+scrollOffsetX, 20+scrollOffsetY);
            g2d.setColor(new Color(0,184,0));
            g2d.drawString(FPP.floorName, 65+scrollOffsetX, 33+scrollOffsetY);
            

            //System.out.println((offsetX+currentPx-12) +"   "+(offsetY+currentPy-12));
    }


    public int scrollOffsetX;
    public int scrollOffsetY;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(300, 300));
        setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void enableLayer(int i, boolean b)
    {
        switch(i)
        {
            case 0: layer0 = b;
                break;
            case 1: layer1 = b;
                break;
            case 2: layer2 = b;
                break;
            case 3: layer3 = b;
                break;
            case 4: layer4 = b;
                break;
        }
        repaint();
    }

    public void setBalloonMode(int i)
    {
        balloonMode = i;
        zoneMode = 99;
        displayZone = false;
        displayZoneText = "Unknown";
        displayZoneX1 = -1;
        displayZoneX2 = -1;
        displayZoneY1 = -1;
        displayZoneY2 = -1;
    }
    public void setZoneMode(int i)
    {
        zoneMode = i;
        balloonMode = 99;
        displayZone = false;
        displayZoneText = "Unknown";
        displayZoneX1 = -1;
        displayZoneX2 = -1;
        displayZoneY1 = -1;
        displayZoneY2 = -1;
    }

    /*public void setProbeDescriptionPanel(int pxoffset, int pyoffset, int scale)
    {
        Enumeration enu0 = FPP.MIF.balloonVector.elements();
        while(enu0.hasMoreElements())
        {
            Balloon b = (Balloon) enu0.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".jpg")));
            if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth() ))
            {
                String did = b.getDeviceID();
                if (did != null)
                {
                    String type = b.getType();
                    String dname = FPP.MIF.MF.HDC.query0("SELECT device_name FROM device WHERE device_id = '"+did+"';");
                    FPP.headerLabel.setText("Device : "+dname+" ("+did+")");
                    if (type.equals("3"))
                    {
                        FPP.headerLabel.setText("Device : "+dname+" ("+did+")");
                        FPP.eventPanel.removeAll();
                        if (b.hasProbe())
                        {
                            for (int i=0;i<5;i++)
                            {
                                String pname = FPP.MIF.MF.HDC.query0("SELECT probe_name "
                                        + "FROM probe WHERE probe_id = '"+b.probe[i]+"';");
                                FPP.eventPanel.add(new ProbeDescriptionPanel(pname,b.probeData[i],"Normal"));
                            }
                        }
                        FPP.validate();
                    }
                    else
                    {
                        FPP.eventPanel.removeAll();
                        FPP.validate();
                    }
                }
                else
                {
                    FPP.headerLabel.setText("No device selected...");
                    FPP.eventPanel.removeAll();
                    FPP.validate();
                }
            }
        }
    }*/


    private int zoneX1;
    private int zoneX2;
    private int zoneY1;
    private int zoneY2;

    private int zoneScreenX;
    private int zoneScreenY;

    public void zoneAdd(int pxoffset, int pyoffset, int scale)
    {
        zoneX1 = pxoffset*(4/scale);
        zoneY1 = pyoffset*(4/scale);
        zoneScreenX = pxoffset;
        zoneScreenY = pyoffset;
        setZoneMode(9);
    }
    public void zoneAdd2(int pxoffset, int pyoffset, int scale)
    {
        String fpid = HydeFormat.parseID((String)FPP.floorComboBox.getSelectedItem());

        zoneX2 = pxoffset*(4/scale);
        zoneY2 = pyoffset*(4/scale);
        FPP.MIF.MF.HDC.customUpdate("INSERT INTO floor_zone "
                + "(floor_zone_x1, floor_zone_y1, floor_zone_x2, floor_zone_y2, floorplan_id) "
                + "VALUES"
                + "("+zoneX1+","+zoneY1+","+zoneX2+","+zoneY2+","+"'"+fpid+"'"
                + ");");
        FPP.MIF.setZoneParameter();
        setZoneMode(1);
        repaint();
        
    }
    public void zoneEdit(int pxoffset, int pyoffset, int scale)
    {
        Enumeration enu3 = FPP.MIF.zoneVector.elements();
        while(enu3.hasMoreElements())
        {
            Zone z = (Zone) enu3.nextElement();
            if (z.getFloorID().equals(FPP.floor))
            {
                if (z.zoneIsHere( pxoffset*(4/scale), pyoffset*(4/scale)))
                {
                    ZoneEditDialog ZED = new ZoneEditDialog(this, z.getID());
                    ZED.setLocationRelativeTo(this);
                    ZED.setVisible(true);
                    return;
                }
            }
        }
    }
    public void zoneDelete(int pxoffset, int pyoffset, int scale)
    {
        Enumeration enu = FPP.MIF.zoneVector.elements();
        while(enu.hasMoreElements())
        {
            Zone z = (Zone) enu.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (z.getFloorID().equals(FPP.floor))
            {
                if (z.zoneIsHere( pxoffset*(4/scale), pyoffset*(4/scale)))
                {
                    FPP.MIF.MF.HDC.customUpdate("DELETE FROM floor_zone "
                            + "WHERE floor_zone_id = "+z.getID()+";");
                    FPP.MIF.setZoneParameter();
                    repaint();
                    return;
                }
            }
        }
    }
    public void showZone(int pxoffset, int pyoffset)
    {
        Enumeration enu3 = FPP.MIF.zoneVector.elements();
        while(enu3.hasMoreElements())
        {
            Zone z = (Zone) enu3.nextElement();
            if (z.getFloorID().equals(FPP.floor))
            {
                if (z.zoneIsHere( pxoffset*(4/scale), pyoffset*(4/scale)))
                {
                    displayZone = true;
                    displayZoneX1 = z.getX1()/(4/scale);
                    displayZoneX2 = z.getX2()/(4/scale);
                    displayZoneY1 = z.getY1()/(4/scale);
                    displayZoneY2 = z.getY2()/(4/scale);
                    if (z.getLocationID() == null)
                    {
                        displayZoneText = "Unknown Location";
                    }
                    else
                    {
                        displayZoneText = z.getLocationName();
                    }
                    return;
                }
            }
        }
    }
    public void showZoneImage(int pxoffset, int pyoffset)
    {
        Enumeration enu3 = FPP.MIF.zoneVector.elements();
        while(enu3.hasMoreElements())
        {
            Zone z = (Zone) enu3.nextElement();
            if (z.getFloorID().equals(FPP.floor))
            {
                if (z.zoneIsHere( pxoffset*(4/scale), pyoffset*(4/scale)))
                {
                    if (z.getLocationID() != null)
                    {
                        FullFrame FF = new FullFrame(FPP.MIF.MF.SD.urlImgPath+"/image/location/"+z.getLocationID()+".jpg");
                    }
                    return;
                }
            }
        }
    }

    public void balloonAdd(int pxoffset, int pyoffset, int scale)
    {
        String fpid = HydeFormat.parseID((String)FPP.floorComboBox.getSelectedItem());
        String did = HydeFormat.parseID((String)FPP.departComboBox.getSelectedItem());
        
        FPP.MIF.MF.HDC.customUpdate("INSERT INTO balloon (balloon_x, balloon_y, floorplan_id, organization_id) "
                + "VALUES("+((pxoffset*(4/scale)))+","
                + ((pyoffset*(4/scale)))+","
                + "'"+fpid+"',"
                + "'"+did+"'"
                + ");");
        FPP.MIF.setBalloonParameter();
        repaint();
    }

    public void balloonEdit(int pxoffset, int pyoffset, int scale)
    {
        Enumeration enu3 = FPP.MIF.balloonVector.elements();
        while(enu3.hasMoreElements())
        {
            Balloon b = (Balloon) enu3.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (b.getFloorID().equals(FPP.floor))
            {
                if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth()))
                {
                    BalloonEditDialog BEP = new BalloonEditDialog(this, b.getID());
                    BEP.setLocationRelativeTo(null);
                    //BEP.setLocation(px+getX(), py);
                    BEP.setVisible(true);
                    //BEP.setBounds(px+getX(), py, BEP.getWidth(), BEP.getHeight());
                    return;
                }
            }
        }
    }

    public void balloonDelete(int pxoffset, int pyoffset, int scale)
    {
        Enumeration enu = FPP.MIF.balloonVector.elements();
        while(enu.hasMoreElements())
        {
            Balloon b = (Balloon) enu.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (b.getFloorID().equals(FPP.floor))
            {
                if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth()))
                {
                    FPP.MIF.MF.HDC.customUpdate("DELETE FROM balloon "
                            + "WHERE balloon_id = "+b.getID()+";");
                    FPP.MIF.setBalloonParameter();
                    repaint();
                    return;
                }
            }
        }
    }

    public int currentPx;
    public int currentPy;
    public int currentChannelMax;
    public String currentDeviceName;
    public String[] currentName;
    public String[] currentData;
    public String[] currentDataTimestamp;
    
    public void resetBalloonDescription()
    {
        currentDeviceName = null;
        currentChannelMax = 0;
        currentName = new String[0];
        currentData = new String[0];
        currentDataTimestamp = new String[0];
    }
    public void setCurrentBalloon(int pxoffset, int pyoffset)
    {
        resetBalloonDescription();
        Enumeration enu = FPP.MIF.balloonVector.elements();
        while(enu.hasMoreElements())
        {
            Balloon b = (Balloon) enu.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (b.getFloorID().equals(FPP.floor))
            {
                if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth()))
                {
                    currentPx = b.getX();
                    currentPy = b.getY();
                    String did = b.getDeviceID();
                    String eqp = FPP.MIF.MF.HDC.query0("SELECT equipment_probe FROM device NATURAL JOIN equipment WHERE device_id = '"+did+"';");
                    Vector v = FPP.MIF.MF.HDC.queryAll("SELECT "
                            + "device_name, channel, channel_name, last_data, last_data_timestamp, "
                            + "channel_unit, channel_enable "
                            + "FROM device_channel NATURAL JOIN device WHERE device_id = '"+did+"';");
                    HydeDataSet HDS = new HydeDataSet(v);
                    Vector rowData = HDS.getRowVector();
                    if (rowData != null)
                    {
                        currentChannelMax = Integer.parseInt(eqp);
                        currentName = new String[currentChannelMax];
                        currentData = new String[currentChannelMax];
                        currentDataTimestamp = new String[currentChannelMax];
                        int i=0;
                        Enumeration rdenu = rowData.elements();
                        while (rdenu.hasMoreElements())
                        {
                            Vector row = (Vector) rdenu.nextElement();
                            currentDeviceName = (String) row.elementAt(0) + " ("+did+")";
                            if (row.elementAt(6).equals("1"))
                            {
                                currentData[i] = row.elementAt(3)+" "+row.elementAt(5);
                            }
                            else
                            {
                                currentData[i] = "-DISABLE-";
                            }
                            currentName[i] = row.elementAt(1)+": "+row.elementAt(2);
                            currentDataTimestamp[i] = (String)row.elementAt(4);
                            i++;
                        }
                    }
                    break;
                }
            }
        }
    }

    //private BaseLikeDialog BLD;
    /*public void showBalloonDetail(int pxoffset, int pyoffset)
    {
        Enumeration enu = FPP.MIF.balloonVector.elements();
        while(enu.hasMoreElements())
        {
            Balloon b = (Balloon) enu.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (b.getFloorID().equals(FPP.floor))
            {
                if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth()))
                {
                    if (b.getType().equals("1"))
                    {
                        /*Point p = MouseInfo.getPointerInfo().getLocation();
                        BLD = new BaseLikeDialog(this, b.getDeviceID());
                        BLD.setLocation(p);
                        BLD.setVisible(true);
                        repaint();
                        FPP.setDetailPanel(FloorplanPanel.BASE_TYPE, b.getDeviceID());
                    }
                    else if (b.getType().equals("2"))
                    {
                        FPP.setDetailPanel(FloorplanPanel.REPEATER_TYPE, b.getDeviceID());
                    }
                    else if (b.getType().equals("3"))
                    {
                        FPP.setDetailPanel(FloorplanPanel.TRANSMITTER_TYPE, b.getDeviceID());
                    }
                    else
                    {
                        FPP.setDetailPanel(FloorplanPanel.UNKNOWN_TYPE, null);
                    }
                    return;
                }
            }
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    int offsetX = 0;
    int offsetY = 0;

    int cursorX = 0;
    int cursorY = 0;
    
    public Dimension bodDim = new Dimension();
    
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e)
    {
        /*Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage(getClass().getResource("/Picz/Other/zoom_cursor2.jpg"));
        Cursor c = toolkit.createCustomCursor(image , new Point(this.getX(),this.getY()), "img");
        this.setCursor (c);*/
    }
    public void mouseExited(MouseEvent e) 
    {
        if (BOD != null && 
                !((e.getXOnScreen() >= bodDim.getWidth() && e.getXOnScreen() <= bodDim.getWidth()+75)&&
                  (e.getYOnScreen() >= bodDim.getHeight() && e.getYOnScreen() <= bodDim.getHeight()+54))
                ) 
        {
            BOD.dispose();
        }
    }
    public void mouseClicked(MouseEvent e)
    {
        int button = e.getButton();
        int clickCount = e.getClickCount();
        int px = e.getX();
        int py = e.getY();
        int pxoffset = px-offsetX;
        int pyoffset = py-offsetY;
        if (BOD != null) BOD.dispose();
        if (button == 1)
        {
            if (FPP.MIF.alertSign.size() > 0 && px > 10+scrollOffsetX && px < 70+scrollOffsetX)
            {
                int alertRow = ((py-scrollOffsetY)/(50));
                int alertRowMod = (py-scrollOffsetY)%(50);
                if (alertRow > 0 && alertRowMod < 33 && alertRow <= FPP.MIF.alertSign.size())
                {
                    FPP.floorComboBox.setSelectedItem(FPP.MIF.alertSign.elementAt(alertRow-1));
                }
            }
            if (px > 10+scrollOffsetX && px < 34+scrollOffsetX && py > 10+scrollOffsetY && py < 35+scrollOffsetY) // x 10~60, y 10~35
            {
                int select = FPP.floorComboBox.getSelectedIndex()-1;
                if (select > 0)
                {
                    FPP.floorComboBox.setSelectedIndex(select);
                }
            }
            if (px > 36+scrollOffsetX && px < 60+scrollOffsetX && py > 10+scrollOffsetY && py < 35+scrollOffsetY) // x 10~60, y 10~35
            {
                int select = FPP.floorComboBox.getSelectedIndex()+1;
                if (select < FPP.floorComboBox.getModel().getSize())
                {
                    FPP.floorComboBox.setSelectedIndex(select);
                }
            }
            /*if (BLD != null)
            {
                BLD.dispose();
            }*/
            if (layer0 && fullSize == false)
            {
                setScale(Integer.parseInt((String)FPP.scaleComboBox.getSelectedItem()));
                FPP.scaleComboBox.setEnabled(false);
                //FPP.mapPanel.setPreferredSize(new Dimension(fullWidth,fullHeight));
                //FPP.mapPanel.validate();
                setPreferredSize(new Dimension(fullWidth,fullHeight));
                FPP.floorScroll.setViewportView(this);
                validate();
                int expectX = (pxoffset*scale)-(getWidth()/2);
                int expectY = (pyoffset*scale)-(getHeight()/2);
                if (expectX < 0)
                {
                    expectX = 0;
                }
                if (expectY < 0)
                {
                    expectY = 0;
                }
                //fullSize = true;
                layer0 = false;
                repaint();
                FPP.floorScroll.getViewport().setViewPosition(new Point(expectX,expectY));
                FPP.floorScroll.validate();
                Dimension d = new Dimension(fullWidth*scale, fullHeight*scale);
                setPreferredSize(d);

                FPP.floorScroll.getViewport().setViewPosition(new Point(expectX,expectY));
                FPP.floorScroll.validate();
                FPP.floorScroll.getVerticalScrollBar().setValue(expectY);
                FPP.floorScroll.getHorizontalScrollBar().setValue(expectX);
            }
            else
            {
                switch (balloonMode)
                {
                    case 0: //detail
                        //setProbeDescriptionPanel(pxoffset, pyoffset, scale);
                        //showBalloonDetail(pxoffset, pyoffset);
                        setCurrentBalloon(pxoffset, pyoffset);
                        break;
                    case 1: //add
                        balloonAdd(pxoffset, pyoffset, scale);
                        break;
                    case 2: //delete
                        balloonDelete(pxoffset, pyoffset, scale);
                        break;
                    case 3: //edit
                        balloonEdit(pxoffset, pyoffset, scale);
                        break;
                }
                switch (zoneMode)
                {
                    case 0: //detail
                        showZone(pxoffset, pyoffset);
                        if (clickCount == 2)
                        {
                            showZoneImage(pxoffset, pyoffset);
                        }
                        break;
                    case 1: //add
                        zoneAdd(pxoffset, pyoffset, scale);
                        break;
                    case 9: //add
                        zoneAdd2(pxoffset, pyoffset, scale);
                        break;
                    case 2: //delete
                        zoneDelete(pxoffset, pyoffset, scale);
                        break;
                    case 3: //edit
                        zoneEdit(pxoffset, pyoffset, scale);
                        break;
                }
            }
        }
        else if (button == 3)
        {
            setBalloonOption(pxoffset, pyoffset, e.getXOnScreen(), e.getYOnScreen());
        }
    }
    
    public void setBalloonOption(int pxoffset, int pyoffset, int pxos, int pyos)
    {
        resetBalloonDescription();
        Enumeration enu = FPP.MIF.balloonVector.elements();
        while(enu.hasMoreElements())
        {
            Balloon b = (Balloon) enu.nextElement();
            ImageIcon img = (new javax.swing.ImageIcon(getClass().getResource("/Picz/Balloon/neutral_"+scale+".png")));
            if (b.getFloorID().equals(FPP.floor))
            {
                if (b.balloonIsHere( pxoffset*(4/scale), pyoffset*(4/scale), img.getIconWidth()))
                {
                    Dimension dim = new Dimension(pxos+img.getIconWidth()/2, pyos-52-img.getIconHeight()/2);
                    bodDim = dim;
                    BOD = new BalloonOptionDialog(this, dim, b.getDeviceID());
                }
            }
        }
    }

    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
        if (layer0 || balloonMode != 0 || zoneMode != 0)
        {
            cursorX = e.getX();
            cursorY = e.getY();
            repaint();
        }
        
    }
    
}
