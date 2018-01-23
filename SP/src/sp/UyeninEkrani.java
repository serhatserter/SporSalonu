
package sp;

import sp.Charts.CreateChart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class UyeninEkrani extends javax.swing.JFrame {

    /** Creates new form UyeninEkrani */
    public UyeninEkrani() {
        initComponents();
     
    }  
    
    UyeninEkrani(String globalNo) {
        initComponents();
        KullaniciNo = globalNo;
        İsim();
        
        
    }
    public String KullaniciNo,Resim;
    
    
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

void İsim(){
    try {
        st = Baglan();
        
        rs = st.executeQuery("SELECT Ad, Soyad FROM musteri WHERE MusteriNo=" + KullaniciNo);
        rs.next();
        isim.setText(rs.getString(1) + " " + rs.getString(2));

    
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    double[] UyeVerileriHesapla(){
    int[] dizi = new int[6]; 
    double[] oran = new double[6]; 
    int toplam = 0;
    try {
        st = Baglan();      
        rs = st.executeQuery("SELECT * FROM antrenman WHERE MusteriNo=" + KullaniciNo);
        
            if(rs.next()){
                int a=0,i=2;
                while(i!=8){
                    rs.beforeFirst();
                    while(rs.next()){
                        dizi[a] = dizi[a] + Integer.parseInt(rs.getString(i));
                    }                  
                    toplam = toplam + dizi[a];
                    a++; i++;
                }
                
                for(int x=0; x<=5; x++){
                    oran[x] = (dizi[x]*100)/toplam;
                }
            }
            else{
                for(int x=0; x<=5; x++){
                oran[x] = 0;
            } 
            }
            
    
        } catch (SQLException ex) {
            Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
return oran;
}
    
    public void GelisimChart(){
        CreateChart CC = new CreateChart("Deneme", isim.getText(), UyeVerileriHesapla());
        CC.pack(); 
        CC.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isim = new javax.swing.JLabel();
        Cikis = new javax.swing.JLabel();
        p5 = new javax.swing.JLabel();
        GelisimDurumu = new javax.swing.JLabel();
        AntrenmanEkle = new javax.swing.JLabel();
        SporProg = new javax.swing.JLabel();
        BesProg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
        setMaximumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        setSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(null);

        isim.setBackground(new java.awt.Color(102, 153, 255));
        isim.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        isim.setForeground(new java.awt.Color(255, 255, 255));
        isim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isim.setOpaque(true);
        getContentPane().add(isim);
        isim.setBounds(1, 0, 640, 100);

        Cikis.setBackground(new java.awt.Color(102, 153, 255));
        Cikis.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Cikis.setForeground(new java.awt.Color(255, 255, 255));
        Cikis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cikis.setText("Çıkış");
        Cikis.setOpaque(true);
        Cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CikisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CikisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CikisMouseExited(evt);
            }
        });
        getContentPane().add(Cikis);
        Cikis.setBounds(240, 380, 170, 30);

        p5.setBackground(new java.awt.Color(102, 153, 255));
        p5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        p5.setForeground(new java.awt.Color(255, 255, 255));
        p5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p5.setText("Profil");
        p5.setOpaque(true);
        p5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p5MouseExited(evt);
            }
        });
        getContentPane().add(p5);
        p5.setBounds(160, 320, 320, 40);

        GelisimDurumu.setBackground(new java.awt.Color(102, 153, 255));
        GelisimDurumu.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        GelisimDurumu.setForeground(new java.awt.Color(255, 255, 255));
        GelisimDurumu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GelisimDurumu.setText("Gelişim Durumu");
        GelisimDurumu.setOpaque(true);
        GelisimDurumu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GelisimDurumuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GelisimDurumuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GelisimDurumuMouseExited(evt);
            }
        });
        getContentPane().add(GelisimDurumu);
        GelisimDurumu.setBounds(20, 150, 300, 66);

        AntrenmanEkle.setBackground(new java.awt.Color(102, 153, 255));
        AntrenmanEkle.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        AntrenmanEkle.setForeground(new java.awt.Color(255, 255, 255));
        AntrenmanEkle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AntrenmanEkle.setText("Antrenman Ekle");
        AntrenmanEkle.setOpaque(true);
        AntrenmanEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AntrenmanEkleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AntrenmanEkleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AntrenmanEkleMouseExited(evt);
            }
        });
        getContentPane().add(AntrenmanEkle);
        AntrenmanEkle.setBounds(332, 150, 290, 66);

        SporProg.setBackground(new java.awt.Color(102, 153, 255));
        SporProg.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        SporProg.setForeground(new java.awt.Color(255, 255, 255));
        SporProg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SporProg.setText("Spor Programı");
        SporProg.setOpaque(true);
        SporProg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SporProgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SporProgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SporProgMouseExited(evt);
            }
        });
        getContentPane().add(SporProg);
        SporProg.setBounds(330, 230, 290, 66);

        BesProg.setBackground(new java.awt.Color(102, 153, 255));
        BesProg.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        BesProg.setForeground(new java.awt.Color(255, 255, 255));
        BesProg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BesProg.setText("Beslenme Programı");
        BesProg.setOpaque(true);
        BesProg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BesProgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BesProgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BesProgMouseExited(evt);
            }
        });
        getContentPane().add(BesProg);
        BesProg.setBounds(20, 230, 300, 66);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GelisimDurumuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GelisimDurumuMouseClicked
        this.setVisible(false);
        new UyeGelisimDurumu(KullaniciNo).setVisible(true);
    }//GEN-LAST:event_GelisimDurumuMouseClicked

    private void GelisimDurumuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GelisimDurumuMouseEntered
        setColor(GelisimDurumu);
    }//GEN-LAST:event_GelisimDurumuMouseEntered

    private void GelisimDurumuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GelisimDurumuMouseExited
        resetColor(GelisimDurumu);
    }//GEN-LAST:event_GelisimDurumuMouseExited

    private void CikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseClicked
        dispose();
    }//GEN-LAST:event_CikisMouseClicked

    private void CikisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseEntered
        setColor(Cikis);
    }//GEN-LAST:event_CikisMouseEntered

    private void CikisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseExited
        resetColor(Cikis);
    }//GEN-LAST:event_CikisMouseExited

    private void AntrenmanEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AntrenmanEkleMouseClicked
        this.setVisible(false);
        new UyeAntrenmanEkle(KullaniciNo).setVisible(true);
        
    }//GEN-LAST:event_AntrenmanEkleMouseClicked

    private void AntrenmanEkleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AntrenmanEkleMouseEntered
        setColor(AntrenmanEkle);
    }//GEN-LAST:event_AntrenmanEkleMouseEntered

    private void AntrenmanEkleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AntrenmanEkleMouseExited
        resetColor(AntrenmanEkle);
    }//GEN-LAST:event_AntrenmanEkleMouseExited

    private void p5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseClicked
        this.setVisible(false);
        new UyeProfil(KullaniciNo).setVisible(true);
    }//GEN-LAST:event_p5MouseClicked

    private void p5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseEntered
        setColor(p5);
    }//GEN-LAST:event_p5MouseEntered

    private void p5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p5MouseExited
        resetColor(p5);
    }//GEN-LAST:event_p5MouseExited

    private void SporProgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgMouseClicked
        this.setVisible(false);
        new UyeSporProgrami(KullaniciNo).setVisible(true);
    }//GEN-LAST:event_SporProgMouseClicked

    private void SporProgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgMouseEntered
        setColor(SporProg);
    }//GEN-LAST:event_SporProgMouseEntered

    private void SporProgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SporProgMouseExited
        resetColor(SporProg);
    }//GEN-LAST:event_SporProgMouseExited

    private void BesProgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BesProgMouseClicked
        this.setVisible(false);
        new UyeBeslenmeProgrami(KullaniciNo).setVisible(true);
    }//GEN-LAST:event_BesProgMouseClicked

    private void BesProgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BesProgMouseEntered
        setColor(BesProg);
    }//GEN-LAST:event_BesProgMouseEntered

    private void BesProgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BesProgMouseExited
        resetColor(BesProg);
    }//GEN-LAST:event_BesProgMouseExited

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
            java.util.logging.Logger.getLogger(UyeninEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UyeninEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UyeninEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UyeninEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UyeninEkrani().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AntrenmanEkle;
    private javax.swing.JLabel BesProg;
    private javax.swing.JLabel Cikis;
    private javax.swing.JLabel GelisimDurumu;
    private javax.swing.JLabel SporProg;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel p5;
    // End of variables declaration//GEN-END:variables

}
