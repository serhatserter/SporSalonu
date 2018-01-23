package sp;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class AnaGiris extends javax.swing.JFrame {
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
    public String globalNo,Resim;
    
    

public AnaGiris() {
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        KullaniciAdi = new javax.swing.JTextField();
        Giris = new javax.swing.JLabel();
        Sifre = new javax.swing.JPasswordField();
        Hata = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        checkbox = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(350, 150));
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        KullaniciAdi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(KullaniciAdi);
        KullaniciAdi.setBounds(70, 80, 180, 30);

        Giris.setBackground(new java.awt.Color(102, 153, 255));
        Giris.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        Giris.setForeground(new java.awt.Color(255, 255, 255));
        Giris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Giris.setText("Giriş");
        Giris.setOpaque(true);
        Giris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GirisMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                GirisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GirisMouseExited(evt);
            }
        });
        getContentPane().add(Giris);
        Giris.setBounds(60, 180, 200, 30);

        Sifre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Sifre.setToolTipText("");
        getContentPane().add(Sifre);
        Sifre.setBounds(70, 120, 180, 30);

        Hata.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        Hata.setForeground(new java.awt.Color(255, 255, 255));
        Hata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Hata);
        Hata.setBounds(30, 220, 250, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        checkbox.setText("Yönetici Girişi");
        checkbox.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(checkbox)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(checkbox)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 30, 200, 140);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("ed");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("Örnek Yönetici:\nK.Adı: admin \nŞifre: admin\n\nÖrnek Müşteriler:\nK.Adı: birinci \nŞifre: 1234\n\nK.Adı: ikinci \nŞifre: 1234");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 260, 200, 180);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 640, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GirisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GirisMouseClicked
 
        
        if(checkbox.isSelected() == true){
          try {
              String KAdi = KullaniciAdi.getText(); 
              String Sif = Sifre.getText(); 
              st = Baglan();   
                rs = st.executeQuery("select YoneticiNo,kullaniciadi,Sifre from yonetici where kullaniciadi='"+KAdi+"'"+"AND Sifre='"+Sif+"'");
 
                    if(rs.first()){   
                        if(rs.getString(2).equals(KAdi) && rs.getString(3).equals(Sif)){
                                
                        globalNo = rs.getString(1);
                        
            
                        new YoneticininEkrani(globalNo).setVisible(true);
                        this.setVisible(false);
                        }

                    }
                    else {
                    Hata.setText("Kullanıcı Adı veya Şifre Hatalı!");
                    }
                } catch (SQLException ex) {
                  Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
                  }   
        } 
        else{
            try {
                String KAdi = KullaniciAdi.getText(); 
                String Sif = Sifre.getText(); 
                st = Baglan();   
                rs = st.executeQuery("select MusteriNo,kullaniciadi,Sifre,Resim from musteri where kullaniciadi='"+KAdi+"'"+"AND sifre='"+Sif+"'");

                    if(rs.first()){   
                        if(rs.getString(2).equals(KAdi) && rs.getString(3).equals(Sif)){
            
                        globalNo = rs.getString(1);
                        Resim = rs.getString(3);
            
                        new UyeninEkrani(globalNo).setVisible(true);
                        this.setVisible(false);
                        }
                    }
                    else {
                        Hata.setText("Kullanıcı Adı veya Şifre Hatalı!");
                        }
                } catch (SQLException ex) {
                  Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
                  }
        }
        

    }//GEN-LAST:event_GirisMouseClicked

    private void GirisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GirisMouseEntered
        setColor(Giris);
    }//GEN-LAST:event_GirisMouseEntered

    private void GirisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GirisMouseExited
        resetColor(Giris);
    }//GEN-LAST:event_GirisMouseExited

    
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
            java.util.logging.Logger.getLogger(AnaGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaGiris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaGiris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Giris;
    private javax.swing.JLabel Hata;
    private javax.swing.JTextField KullaniciAdi;
    private javax.swing.JPasswordField Sifre;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
