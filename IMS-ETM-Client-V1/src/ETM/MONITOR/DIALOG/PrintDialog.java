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

import ETM.MONITOR.PANEL.GraphDisplayPanel;
import ETM.MONITOR.PANEL.GraphPrintFormatter;
import ETM.Util.HydePrint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintDialog extends javax.swing.JDialog implements ActionListener
{
    public GraphPrintFormatter printObject;
    public GraphDisplayPanel GDP;
    public PrintDialog(GraphPrintFormatter JP, GraphDisplayPanel GDP)
    {
        initComponents();
        this.GDP = GDP;
        printObject = JP;
        preview.setSize(JP.getSize());
        preview.add(JP);

        setSize(new java.awt.Dimension(167+JP.getSize().width,71+JP.getSize().height));

        printButton.addActionListener(this);

        
        this.pack();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        printButton = new javax.swing.JButton();
        preview = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Preview...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        printButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picz/Button32/printer_32.png"))); // NOI18N

        preview.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        preview.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setText("Print preview ...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(printButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(printButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        GDP.graphPanel.add(printObject.GP);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel preview;
    private javax.swing.JButton printButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if (src == printButton)
        {
            if (printObject.getSize().getHeight() > printObject.getSize().getWidth())
            {
                HydePrint.printComponent(printObject,HydePrint.PORTRAIT);
            }
            else
            {
                HydePrint.printComponent(printObject,HydePrint.LANDSCAPE);
            }
        }
    }
    
}
