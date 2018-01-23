
package sp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UyeProfil extends javax.swing.JFrame {

    /** Creates new form UyeninEkrani */
    public UyeProfil() {
        initComponents();
     
    }  
    
    UyeProfil(String globalNo) {
        initComponents();
        KullaniciNo = globalNo;
        İsim();
        VerileriGetir();
    }
    public String KullaniciNo;
    
    int boy,kilo,yag,sauna;
    String kan,hasta,uyelik,zaman;
    
    
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
        
        rs = st.executeQuery("SELECT Ad,Soyad FROM musteri WHERE MusteriNo=" + KullaniciNo);
        rs.next();
        isim.setText(rs.getString(1) + " " + rs.getString(2));
    
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
}

void VerileriGetir(){
    try {
        st = Baglan();
        
        rs = st.executeQuery("SELECT spordetaylari.`MusteriNo`, spordetaylari.`UyelikTipi`, spordetaylari.`SporZamani`, \n" +
                             "spordetaylari.`HamamSauna`,saglikfizik.`Boy`,saglikfizik.`Kilo`, saglikfizik.`YagOrani`, \n" +
                             "saglikfizik.`KanGrubu`,saglikfizik.`Hastalik`\n" +
                             "FROM saglikfizik INNER JOIN spordetaylari ON saglikfizik.`MusteriNo` = spordetaylari.`MusteriNo` \n" +
                             "AND spordetaylari.`MusteriNo` =" + KullaniciNo);
        rs.next();
        
        uyelik = rs.getString(2);
        zaman = rs.getString(3);
        sauna = Integer.parseInt(rs.getString(4));
        boy =Integer.parseInt(rs.getString(5));
        kilo = Integer.parseInt(rs.getString(6));
        yag = Integer.parseInt(rs.getString(7));
        kan = rs.getString(8);
        hasta = rs.getString(9);
        
        t1.setText("Üyelik Tipi: " + uyelik );
        t2.setText("Üyelik Zamanı: " + zaman);
        t3.setText("Hamam/Sauna: " + Sauna(sauna));
        t4.setText("Boy: " + boy);
        t5.setText("Kilo: " + kilo);
        t6.setText("Yağ Oranı: " + yag);
        t7.setText("Kan Grubu: " + kan);
        t8.setText("Hastalık: " + hasta);
        
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
String Sauna(int sauna){
    if(sauna==1) {return "Var";}
    else{ return "Yok";} 
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isim = new javax.swing.JLabel();
        Cikis = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        t3 = new javax.swing.JLabel();
        t4 = new javax.swing.JLabel();
        t5 = new javax.swing.JLabel();
        t6 = new javax.swing.JLabel();
        t7 = new javax.swing.JLabel();
        t8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
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
        Cikis.setText("Geri Dön");
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
        Cikis.setBounds(230, 370, 170, 30);

        t1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setOpaque(true);
        getContentPane().add(t1);
        t1.setBounds(170, 110, 290, 20);

        t2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t2.setOpaque(true);
        getContentPane().add(t2);
        t2.setBounds(170, 140, 290, 20);

        t3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t3.setOpaque(true);
        getContentPane().add(t3);
        t3.setBounds(170, 170, 290, 20);

        t4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t4.setOpaque(true);
        getContentPane().add(t4);
        t4.setBounds(170, 200, 290, 20);

        t5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t5.setOpaque(true);
        getContentPane().add(t5);
        t5.setBounds(170, 230, 290, 20);

        t6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t6.setOpaque(true);
        getContentPane().add(t6);
        t6.setBounds(170, 260, 290, 20);

        t7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t7.setOpaque(true);
        getContentPane().add(t7);
        t7.setBounds(170, 290, 290, 20);

        t8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t8.setOpaque(true);
        getContentPane().add(t8);
        t8.setBounds(170, 320, 290, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseClicked
        this.setVisible(false);
        new UyeninEkrani(KullaniciNo).setVisible(true);
    }//GEN-LAST:event_CikisMouseClicked

    private void CikisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseEntered
        setColor(Cikis);
    }//GEN-LAST:event_CikisMouseEntered

    private void CikisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CikisMouseExited
        resetColor(Cikis);
    }//GEN-LAST:event_CikisMouseExited

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
            java.util.logging.Logger.getLogger(UyeProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UyeProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UyeProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UyeProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UyeProfil().setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cikis;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel t3;
    private javax.swing.JLabel t4;
    private javax.swing.JLabel t5;
    private javax.swing.JLabel t6;
    private javax.swing.JLabel t7;
    private javax.swing.JLabel t8;
    // End of variables declaration//GEN-END:variables

}
