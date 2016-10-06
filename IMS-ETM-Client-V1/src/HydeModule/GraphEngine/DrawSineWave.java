/*
 * DrawSineWave Module
 *  Version 1.0 (01/07/2009)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */
package HydeModule.GraphEngine;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawSineWave extends JPanel
{
  private static final int SCALEFACTOR = 200;
  private int cycles;
  private int points;
  private double[] sines;
  private int[] pts;

  public DrawSineWave(int Cycles)
  {
      setBackground(Color.black);
      setCycles(Cycles);
  }

  public void setCycles(int newCycles)
  {
    cycles = newCycles;
    points = SCALEFACTOR * cycles * 2;
    sines = new double[points];
    for (int i = 0; i < points; i++) {
      double radians = (Math.PI / SCALEFACTOR) * i;
      sines[i] = Math.sin(radians);
    }
    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int maxWidth = getWidth();
    double hstep = (double) maxWidth / (double) points;
    int maxHeight = getHeight();
    pts = new int[points];
    for (int i = 0; i < points; i++)
      pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
    g.setColor(Color.RED);
    for (int i = 1; i < points; i++) {
      int x1 = (int) ((i - 1) * hstep);
      int x2 = (int) (i * hstep);
      int y1 = pts[i - 1];
      int y2 = pts[i];
      g.drawLine(x1, y1, x2, y2);
    }
  }
}



