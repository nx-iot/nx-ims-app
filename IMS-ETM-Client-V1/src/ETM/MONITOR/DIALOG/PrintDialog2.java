/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrintDialog.java
 *
 * Created on May 9, 2012, 6:15:50 PM
 */

package ETM.MONITOR.DIALOG;

import ETM.MONITOR.PANEL.TablePrintFormatter;
import ETM.Util.HydePrint;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintDialog2 extends javax.swing.JDialog implements ActionListener
{
    public TablePrintFormatter[] printObject;
    private int currentIndex = 1;
    private int maxIndex = 1;
    //TableDisplayPanel TDP;
    public PrintDialog2(TablePrintFormatter[] TPF)
    {
        initComponents();
        //this.TDP = TDP;
        printObject = TPF;
        maxIndex = TPF.length;
        actionComponents();
        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
        setPage(currentIndex-1);
        setSize(new java.awt.Dimension(556,700));
    }

    private void actionComponents()
    {
        printButton.addActionListener(this);
        prevButton.addActionListener(this);
        nextButton.addActionListener(this);
    }

    public void setPage(int index)
    {
        pageIndex.setText("Page index : "+currentIndex+"/"+maxIndex);
        preview.removeAll();
        preview.setSize(new Dimension(509,756));
        preview.add(printObject[index]);
        previewScroll.setSize(new Dimension(509,756));
        printObject[index].setSize(new Dimension(509,756));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pageIndex = new javax.swing.JLabel();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        previewScroll = new javax.swing.JScrollPane();
        preview = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/printer_32.png"))); // NOI18N

        jLabel1.setText("Print preview ...");

        pageIndex.setText("Page 0/0");

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/go_16.png"))); // NOI18N
        prevButton.setMaximumSize(new java.awt.Dimension(20, 20));
        prevButton.setMinimumSize(new java.awt.Dimension(20, 20));
        prevButton.setPreferredSize(new java.awt.Dimension(20, 20));

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button16/go2_16.png"))); // NOI18N
        nextButton.setMaximumSize(new java.awt.Dimension(20, 20));
        nextButton.setMinimumSize(new java.awt.Dimension(20, 20));
        nextButton.setPreferredSize(new java.awt.Dimension(20, 20));

        previewScroll.setMaximumSize(new java.awt.Dimension(600, 800));

        preview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        preview.setLayout(new java.awt.GridLayout(1, 0));
        previewScroll.setViewportView(preview);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(previewScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pageIndex)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(printButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(printButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                                .addComponent(pageIndex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(7, 7, 7)
                .addComponent(previewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //GDP.graphPanel.add(printObject.GP);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel pageIndex;
    private javax.swing.JButton prevButton;
    private javax.swing.JPanel preview;
    private javax.swing.JScrollPane previewScroll;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables

    public void setAllPage()
    {
        Thread t1 = new Thread() {
        public void run() {
            for(int i=0;i<maxIndex;i++)
            {
              nextButton.doClick();

            }
          }
        };
        t1.start();
    }
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == printButton)
        {
            setAllPage();
            HydePrint.printComponent(printObject,HydePrint.PORTRAIT, maxIndex,this);
        }
        else if (src == prevButton)
        {
            if (currentIndex > 1)
            {
                currentIndex -= 1;
                setPage(currentIndex-1);
            }
        }
        else if (src == nextButton)
        {
            if (currentIndex < maxIndex)
            {
                currentIndex += 1;
                setPage(currentIndex-1);
            }
        }
    }
    
}
