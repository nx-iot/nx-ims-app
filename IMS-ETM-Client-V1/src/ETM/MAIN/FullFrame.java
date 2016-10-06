package ETM.MAIN;

import HydeModule.Image.HydeImage;

public class FullFrame extends javax.swing.JFrame 
{

    public FullFrame(String imgUrl)
    {
        if (imgUrl == null) return;

        initComponents();
        HydeImage HI = new HydeImage();
        HI.setImageFromUrl(imgUrl, fullPic, fullPicPanel, 0, 0,HydeImage.NO_SCALED);
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fullPicScroll = new javax.swing.JScrollPane();
        fullPicPanel = new javax.swing.JPanel();
        fullPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Full Frame");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        fullPicScroll.setPreferredSize(new java.awt.Dimension(800, 600));

        fullPicPanel.setLayout(new java.awt.GridLayout(1, 0));

        fullPic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullPicPanel.add(fullPic);

        fullPicScroll.setViewportView(fullPicPanel);

        getContentPane().add(fullPicScroll);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fullPic;
    private javax.swing.JPanel fullPicPanel;
    private javax.swing.JScrollPane fullPicScroll;
    // End of variables declaration//GEN-END:variables

}
