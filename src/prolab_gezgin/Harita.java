package prolab_gezgin;

import java.awt.Graphics;

public class Harita extends javax.swing.JFrame {

    /*static int x1;
     static int x2;
     static int y1;
     static int y2;*/
    static int[][] matris = null;
    static int[][] koordinat = null;
    static int[][] plakalar = null;

    public Harita(/*int x1,int x2,int y1,int y2,*/int[][] matris, int[][] koordinat, int n, int k) {
        int i = 0, j = 0;
        int[][] plakalar = new int[5][n + 2];

        if (k > 5) {

            for (i = 0; i < 5; i++) {
                plakalar[i][0] = 41;
                plakalar[i][n + 1] = 41;
            }

            for (i = 0; i < 5; i++) {
                for (j = 1; j < n + 1; j++) {

                    plakalar[i][j] = matris[i][j - 1];
                }
            }

            for (i = 0; i < 5; i++) {
                for (j = 0; j < n + 2; j++) {
                    System.out.print(plakalar[i][j] + "     ");
                }
                System.out.println("");
            }

        } else {
            for (i = 0; i < k; i++) {
                plakalar[i][0] = 41;
                plakalar[i][n + 1] = 41;
            }

            for (i = 0; i < k; i++) {
                for (j = 1; j < n + 1; j++) {
                    plakalar[i][j] = matris[i][j - 1];
                }
            }

            for (i = 0; i < k; i++) {
                for (j = 0; j < n + 2; j++) {
                    System.out.print(plakalar[i][j] + "     ");
                }
                System.out.println("");
            }
        }

        /*this.x1 = x1;
         this.x2 = x2;
         this.y1 = y1;
         this.y2 = y2;*/
        this.koordinat = koordinat;
        this.matris = matris;
        /*for(int i=0 ; i<3 ; i++)
         for(int j=0 ; j<5 ; j++)
         {
         if(j%5==0)
         System.out.println("");
         System.out.print("\t"+ this.matris[i][j]);
         }*/
        initComponents();
        new Harita().setVisible(true);
    }

    public Harita() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/map.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Harita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Harita().setVisible(true);
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        //73-43---->> 83-43
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 - 1; j++) {
                g.drawLine(koordinat[matris[i][j]][0], koordinat[matris[i][j]][1], koordinat[matris[i][j + 1]][0], koordinat[matris[i][j + 1]][1]);
            }
        }
          //g.drawLine(koordinat[matris[i][j]][1],koordinat[matris[i][j+1]][1],koordinat[matris[i][j]][0],koordinat[matris[i][j+1]][0]);
        //g.drawLine(295,160,400,300);
        //          x2, y2, x1, y1 
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
/*public void paint(Graphics g) {
        super.paint(g);
        //73-43---->> 83-43
        for(int i=0 ; i<3 ; i++)
          for(int j=0 ; j<5-1 ; j++)
          //g.drawLine(koordinat[matris[i][j]][1],koordinat[matris[i][j+1]][1],koordinat[matris[i][j]][0],koordinat[matris[i][j+1]][0]);
          g.drawLine(300,300,200,200);

    }*/
