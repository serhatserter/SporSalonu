/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author serhatPC
 */
public class YoneticininEkrani extends javax.swing.JFrame {
String YoneticiNo;
    YoneticininEkrani(String globalNo) {
        initComponents();
        YoneticiNo = globalNo;
        İsim();
    }
    
public Connect c;
    private static String USERNAME;
    private static  String PASSWORD;
    private static  String CONN_STRING;
    private static  String JDBC_DRIVER; 
        
 
public Statement Baglan() throws SQLException{
    c = new Connect();
    
    USERNAME=c.username;
    PASSWORD=c.password;
    CONN_STRING=c.conn_string;
    JDBC_DRIVER=c.jdbc_driver;
    
    Connection conn = null;
    conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD); 
    return (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
}
    Statement st;
    ResultSet rs;    
    public String globalNo;
    
    
    public YoneticininEkrani() {
        initComponents();
    }

void İsim(){
    try {
        st = Baglan();
        
        rs = st.executeQuery("SELECT Ad, Soyad FROM yonetici WHERE YoneticiNo=" + YoneticiNo);
        rs.next();
        isim.setText(rs.getString(1) + " " + rs.getString(2));
    
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Kayit = new javax.swing.JLabel();
        isim = new javax.swing.JLabel();
        UyeGelisim = new javax.swing.JLabel();
        SporProgEkle = new javax.swing.JLabel();
        BeslProgEkle = new javax.swing.JLabel();
        GeriDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(350, 150));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(null);

        Kayit.setBackground(new java.awt.Color(102, 153, 255));
        Kayit.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Kayit.setForeground(new java.awt.Color(255, 255, 255));
        Kayit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Kayit.setText("Yeni Kayıt");
        Kayit.setOpaque(true);
        Kayit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KayitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                KayitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KayitMouseExited(evt);
            }
        });
        getContentPane().add(Kayit);
        Kayit.setBounds(330, 130, 270, 70);

        isim.setBackground(new java.awt.Color(102, 153, 255));
        isim.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        isim.setForeground(new java.awt.Color(255, 255, 255));
        isim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isim.setOpaque(true);
        getContentPane().add(isim);
        isim.setBounds(0, 0, 640, 100);

        UyeGelisim.setBackground(new java.awt.Color(102, 153, 255));
        UyeGelisim.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        UyeGelisim.setForeground(new java.awt.Color(255, 255, 255));
        UyeGelisim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UyeGelisim.setText("Tüm Üyelerin Durumu");
        UyeGelisim.setOpaque(true);
        UyeGelisim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UyeGelisimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UyeGelisimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UyeGelisimMouseExited(evt);
            }
        });
        getContentPane().add(UyeGelisim);
        UyeGelisim.setBounds(30, 130, 270, 70);

        SporProgEkle.setBackground(new java.awt.Color(102, 153, 255));
        SporProgEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        SporProgEkle.setForeground(new java.awt.Color(255, 255, 255));
        SporProgEkle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SporProgEkle.setText("Spor Prog. Ekle");
        SporProgEkle.setOpaque(true);
        SporProgEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SporProgEkleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SporProgEkleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SporProgEkleMouseExited(evt);
            }
        });
        getContentPane().add(SporProgEkle);
        SporProgEkle.setBounds(30, 240, 270, 70);

        BeslProgEkle.setBackground(new java.awt.Color(102, 153, 255));
        BeslProgEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BeslProgEkle.setForeground(new java.awt.Color(255, 255, 255));
        BeslProgEkle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BeslProgEkle.setText("Beslenme Prog. Ekle");
        BeslProgEkle.setOpaque(true);
        BeslProgEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeslProgEkleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BeslProgEkleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BeslProgEkleMouseExited(evt);
            }
        });
        getContentPane().add(BeslProgEkle);
        BeslProgEkle.setBounds(330, 240, 270, 70);

        GeriDon.setBackground(new java.awt.Color(102, 153, 255));
        GeriDon.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GeriDon.setForeground(new java.awt.Color(255, 255, 255));
        GeriDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GeriDon.setText("Çıkış");
        GeriDon.setOpaque(true);
        GeriDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeriDonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GeriDonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GeriDonMouseExited(evt);
            }
        });
        getContentPane().add(GeriDon);
        GeriDon.setBounds(210, 370, 210, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KayitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KayitMouseClicked
        Kayit frame = new Kayit();
        frame.setVisible(true);
    }//GEN-LAST:event_KayitMouseClicked

    private void KayitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KayitMouseEntered
        setColor(Kayit);
    }//GEN-LAST:event_KayitMouseEntered

    private void KayitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KayitMouseExited
        resetColor(Kayit);
    }//GEN-LAST:event_KayitMouseExited

    private void UyeGelisimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeGelisimMouseClicked
        this.setVisible(false);
        new YoneticiGelisimDurumu(YoneticiNo).setVisible(true);
    }//GEN-LAST:event_UyeGelisimMouseClicked

    private void UyeGelisimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeGelisimMouseEntered
        setColor(UyeGelisim);
    }//GEN-LAST:event_UyeGelisimMouseEntered

    private void UyeGelisimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeGelisimMouseExited
        resetColor(UyeGelisim);
    }//GEN-LAST:event_UyeGelisimMouseExited

    private void SporProgEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgEkleMouseClicked
        new SporProgEkle().setVisible(true);
    }//GEN-LAST:event_SporProgEkleMouseClicked

    private void SporProgEkleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgEkleMouseEntered
        setColor(SporProgEkle);
    }//GEN-LAST:event_SporProgEkleMouseEntered

    private void SporProgEkleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgEkleMouseExited
        resetColor(SporProgEkle);
    }//GEN-LAST:event_SporProgEkleMouseExited

    private void BeslProgEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeslProgEkleMouseClicked
        BeslenmeProgEkle frame = new BeslenmeProgEkle();
        frame.setVisible(true);
    }//GEN-LAST:event_BeslProgEkleMouseClicked

    private void BeslProgEkleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeslProgEkleMouseEntered
        setColor(BeslProgEkle);
    }//GEN-LAST:event_BeslProgEkleMouseEntered

    private void BeslProgEkleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeslProgEkleMouseExited
        resetColor(BeslProgEkle);
    }//GEN-LAST:event_BeslProgEkleMouseExited

    private void GeriDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseClicked
        dispose();
    }//GEN-LAST:event_GeriDonMouseClicked

    private void GeriDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseEntered
        setColor(GeriDon);
    }//GEN-LAST:event_GeriDonMouseEntered

    private void GeriDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseExited
        resetColor(GeriDon);
    }//GEN-LAST:event_GeriDonMouseExited

 public void setColor(JLabel label)
 {
     label.setBackground(new java.awt.Color(51,51,255));
 }

 public void resetColor(JLabel label)
 {
     label.setBackground(new java.awt.Color(102,153,255));
 }
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(YoneticininEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticininEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticininEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticininEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticininEkrani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BeslProgEkle;
    private javax.swing.JLabel GeriDon;
    private javax.swing.JLabel Kayit;
    private javax.swing.JLabel SporProgEkle;
    private javax.swing.JLabel UyeGelisim;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
