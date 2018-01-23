package sp;

import sp.Charts.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class YoneticiGelisimDurumu extends javax.swing.JFrame {

    
    public YoneticiGelisimDurumu() {
        initComponents();

        
    }
    
YoneticiGelisimDurumu(String globalNo) {
        initComponents();
        YoneticiNo = globalNo;
        İsim();
    }
    public String YoneticiNo;
    int gun;
    
    
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
        
        rs = st.executeQuery("SELECT Ad, Soyad FROM yonetici WHERE YoneticiNo=" + YoneticiNo);
        rs.next();
        isim.setText(rs.getString(1) + " " + rs.getString(2));
    
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
}

//SPOR VERİLERİ--------------------------------------------------/
 double[] VerileriHesapla(){
    double[] dizi = new double[6]; 
    double[] oran = new double[6]; 
    double toplam = 0;
    try {
        st = Baglan();      
        rs = st.executeQuery("SELECT * FROM antrenman");
        
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
                    oran[x] = Math.round(oran[x]*100);
                    oran[x] = oran[x]/100;
                    
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
 // ZAMAN VERİLERİ -----------------------------------------//
 double[] ZamanVerileriHesapla(){
    double[] dizi = new double[3]; 
    double[] oran = new double[3]; 
    for(int i=0; i<=dizi.length-1; i++){
        dizi[i]=0;
    }
    try {
        st = Baglan();      
        rs = st.executeQuery("SELECT SporZamani FROM spordetaylari");
        int toplam =0;
    while(rs.next()){    
        
            if("Sabah".equals(rs.getString(1))){
                dizi[0]++;
                toplam++;
            }
            else if("Öğle".equals(rs.getString(1))){
                dizi[1]++;
                toplam++;
            }
            else if("Akşam".equals(rs.getString(1))){
                dizi[2]++;
                toplam++;
            }
             
    }
    
    for(int x=0; x<=2; x++){
        oran[x] = (dizi[x]*100)/toplam; 
        oran[x] = Math.round(oran[x]*100);
        oran[x] = oran[x]/100;
    }
    
    } catch (SQLException ex) {
         Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
 return oran;
 }
 

 // ÜYE TİPİ VERİLERİ -----------------------------------------//
  double[] UyeTipiVerileriHesapla(){
    double[] dizi = new double[7]; 
    double[] oran = new double[7]; 
    for(int i=0; i<=dizi.length-1; i++){
        dizi[i]=0;
    }
    try {
        st = Baglan();      
        rs = st.executeQuery("SELECT UyelikTipi FROM spordetaylari");
        int toplam =0;
    while(rs.next()){    
        
            if("Fitness".equals(rs.getString(1))){
                dizi[0]++;
                toplam++;
            }
            else if("Body Building".equals(rs.getString(1))){
                dizi[1]++;
                toplam++;
            }
            else if("Box".equals(rs.getString(1))){
                dizi[2]++;
                toplam++;
            }
            else if("Kick-Box".equals(rs.getString(1))){
                dizi[3]++;
                toplam++;
            }
            else if("Judo".equals(rs.getString(1))){
                dizi[4]++;
                toplam++;
            }
            else if("Tekvando".equals(rs.getString(1))){
                dizi[5]++;
                toplam++;
            }
            else if("Yoga".equals(rs.getString(1))){
                dizi[6]++;
                toplam++;
            }
             
    }
    
    for(int x=0; x<=dizi.length-1; x++){
        oran[x] = (dizi[x]*100)/toplam;  
        oran[x] = Math.round(oran[x]*100);
        oran[x] = oran[x]/100;
    }
    
    } catch (SQLException ex) {
         Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
 return oran;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isim = new javax.swing.JLabel();
        GeriDon = new javax.swing.JLabel();
        Grafik = new javax.swing.JLabel();
        Zaman = new javax.swing.JLabel();
        UyeTipi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
        setMaximumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        isim.setBackground(new java.awt.Color(102, 153, 255));
        isim.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        isim.setForeground(new java.awt.Color(255, 255, 255));
        isim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isim.setOpaque(true);
        getContentPane().add(isim);
        isim.setBounds(1, 0, 640, 100);

        GeriDon.setBackground(new java.awt.Color(102, 153, 255));
        GeriDon.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        GeriDon.setForeground(new java.awt.Color(255, 255, 255));
        GeriDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GeriDon.setText("Geri Dön");
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
        GeriDon.setBounds(210, 330, 210, 30);

        Grafik.setBackground(new java.awt.Color(102, 153, 255));
        Grafik.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Grafik.setForeground(new java.awt.Color(255, 255, 255));
        Grafik.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Grafik.setText("Genel Durum");
        Grafik.setOpaque(true);
        Grafik.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GrafikMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GrafikMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GrafikMouseExited(evt);
            }
        });
        getContentPane().add(Grafik);
        Grafik.setBounds(430, 130, 160, 110);

        Zaman.setBackground(new java.awt.Color(102, 153, 255));
        Zaman.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Zaman.setForeground(new java.awt.Color(255, 255, 255));
        Zaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Zaman.setText("Zaman Durumu");
        Zaman.setOpaque(true);
        Zaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ZamanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ZamanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ZamanMouseExited(evt);
            }
        });
        getContentPane().add(Zaman);
        Zaman.setBounds(240, 130, 160, 110);

        UyeTipi.setBackground(new java.awt.Color(102, 153, 255));
        UyeTipi.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        UyeTipi.setForeground(new java.awt.Color(255, 255, 255));
        UyeTipi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UyeTipi.setText("Üyelik Tipi");
        UyeTipi.setOpaque(true);
        UyeTipi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UyeTipiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UyeTipiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UyeTipiMouseExited(evt);
            }
        });
        getContentPane().add(UyeTipi);
        UyeTipi.setBounds(50, 130, 160, 110);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeriDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseClicked
        this.setVisible(false);
        new YoneticininEkrani(YoneticiNo).setVisible(true);
    }//GEN-LAST:event_GeriDonMouseClicked

    private void GeriDonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseEntered
        setColor(GeriDon);
    }//GEN-LAST:event_GeriDonMouseEntered

    private void GeriDonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseExited
        resetColor(GeriDon);
    }//GEN-LAST:event_GeriDonMouseExited

    private void GrafikMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrafikMouseClicked
        CreateChart CC = new CreateChart("Deneme", "Genel Durum", VerileriHesapla());
        CC.pack(); 
        CC.setVisible(true);
    }//GEN-LAST:event_GrafikMouseClicked

    private void GrafikMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrafikMouseEntered
        setColor(Grafik);
    }//GEN-LAST:event_GrafikMouseEntered

    private void GrafikMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GrafikMouseExited
        resetColor(Grafik);
    }//GEN-LAST:event_GrafikMouseExited

    private void ZamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZamanMouseClicked
        CreateChartZaman CC = new CreateChartZaman("Deneme", "Zaman Dağılımı", ZamanVerileriHesapla());
        CC.pack(); 
        CC.setVisible(true);
    }//GEN-LAST:event_ZamanMouseClicked

    private void ZamanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZamanMouseEntered
        setColor(Zaman);
    }//GEN-LAST:event_ZamanMouseEntered

    private void ZamanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ZamanMouseExited
         resetColor(Zaman);
    }//GEN-LAST:event_ZamanMouseExited

    private void UyeTipiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeTipiMouseClicked
       CreateChartUye CC = new CreateChartUye("Deneme", "Üyelik Tipi Dağılımı", UyeTipiVerileriHesapla());
        CC.pack(); 
        CC.setVisible(true);
    }//GEN-LAST:event_UyeTipiMouseClicked

    private void UyeTipiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeTipiMouseEntered
        setColor(UyeTipi);
    }//GEN-LAST:event_UyeTipiMouseEntered

    private void UyeTipiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UyeTipiMouseExited
        resetColor(UyeTipi);
    }//GEN-LAST:event_UyeTipiMouseExited

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
            java.util.logging.Logger.getLogger(YoneticiGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YoneticiGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YoneticiGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YoneticiGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YoneticiGelisimDurumu().setVisible(true);

            }
        });
    
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GeriDon;
    private javax.swing.JLabel Grafik;
    private javax.swing.JLabel UyeTipi;
    private javax.swing.JLabel Zaman;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
