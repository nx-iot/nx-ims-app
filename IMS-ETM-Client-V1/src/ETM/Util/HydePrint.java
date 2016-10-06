/*
 * HydePrint Module
 *  Version 1.0 (01/07/2011)
 *
 *  Author Peranitti Tuvaphanthaphiphat (PERANITTI@GMAIL.COM)
 *  Intelenics Co.,Ltd. (www.intelenics.com)
 *
 */

package ETM.Util;

import ETM.MONITOR.DIALOG.PrintDialog2;
import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
import javax.swing.text.Document;

public class HydePrint implements Printable
{
  private Component[] componentToBePrinted;
  private int oriented;
  private int totalPage;
  public static int LANDSCAPE = PageFormat.LANDSCAPE;
  public static int PORTRAIT = PageFormat.PORTRAIT;

  private PrintDialog2 PD2;

  public static void printComponent(Component c, int oriented)
  {
      new HydePrint(c,oriented).print();
  }

  public static void printComponent(Component[] c, int oriented, int page)
  {
      new HydePrint(c,oriented,page).print();
  }

  public static void printComponent(Component[] c, int oriented, int page, PrintDialog2 PD2)
  {
      new HydePrint(c,oriented,page, PD2).print();
  }
  
  public HydePrint(Component componentToBePrinted, int oriented)
  {
      this.oriented = oriented;
      this.componentToBePrinted = new Component[1];
      this.componentToBePrinted[0] = componentToBePrinted;
      totalPage = 1;
  }

  public HydePrint(Component[] componentToBePrinted, int oriented, int page)
  {
      this.oriented = oriented;
      this.componentToBePrinted = componentToBePrinted;
      totalPage = page;
  }
  public HydePrint(Component[] componentToBePrinted, int oriented, int page, PrintDialog2 PD2)
  {
      this.oriented = oriented;
      this.componentToBePrinted = componentToBePrinted;
      totalPage = page;
      this.PD2 = PD2;
  }
  
  public void print()
  {
    PrinterJob printJob = PrinterJob.getPrinterJob();
    printJob.setPrintable(this);

    PageFormat PF = printJob.defaultPage();
    PF.setOrientation(oriented);
    Paper p = new Paper();
    p.setSize(595, 842);
    p.setImageableArea(43, 43, 509, 756);
    PF.setPaper(p);
    //--- Create a new book to add pages to
    Book book = new Book();
    for (int i=0;i<totalPage;i++)
    {
        book.append(this, PF);
    }

    //--- Add the document page using a landscape page format
    //PageFormat documentPageFormat = new PageFormat();
    //documentPageFormat.setOrientation(PageFormat.LANDSCAPE);
    //book.append(this, documentPageFormat);

    //--- Tell the printJob to use the book as the pageable object
    printJob.setPageable(book);


    if (printJob.printDialog())
      try
      {
        printJob.print();
      } 
      catch(PrinterException pe)
      {
        System.out.println("Error printing: " + pe);
      }
  }

  public int print(Graphics g, PageFormat pageFormat, int pageIndex)
  {
    if (pageIndex >= totalPage)
    {
      return(NO_SUCH_PAGE);
    } 
    else
    {
      Graphics2D g2d = (Graphics2D)g;
      g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
      disableDoubleBuffering(componentToBePrinted[pageIndex]);
      if (PD2 != null)
      {
        PD2.setPage(pageIndex);
      }
      componentToBePrinted[pageIndex].paint(g2d);
      enableDoubleBuffering(componentToBePrinted[pageIndex]);
      //System.out.println("PRINT(Graphics g, PageFormat pageFormat, int pageIndex)");
      return(PAGE_EXISTS);
    }
  }

  /** The speed and quality of printing suffers dramatically if
   *  any of the containers have double buffering turned on.
   *  So this turns if off globally.
   *  @see enableDoubleBuffering
   */
  public static void disableDoubleBuffering(Component c) {
    RepaintManager currentManager = RepaintManager.currentManager(c);
    currentManager.setDoubleBufferingEnabled(false);
  }

  /** Re-enables double buffering globally. */
  
  public static void enableDoubleBuffering(Component c) {
    RepaintManager currentManager = RepaintManager.currentManager(c);
    currentManager.setDoubleBufferingEnabled(true);
  }


}
