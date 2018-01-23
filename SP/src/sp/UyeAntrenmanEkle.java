
package sp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


public class UyeAntrenmanEkle extends javax.swing.JFrame {

    /**
     * Creates new form UyeAntrenmanEkle
     */
    public UyeAntrenmanEkle() {
        initComponents();
    }

 UyeAntrenmanEkle(String globalNo) {
        initComponents();
        KullaniciNo = globalNo;
        İsim();
        Gun();
    }
    public String KullaniciNo;
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
        
        rs = st.executeQuery("SELECT Ad, Soyad FROM musteri WHERE MusteriNo=" + KullaniciNo);
        rs.next();
        isim.setText(rs.getString(1) + " " + rs.getString(2));
    
        } catch (SQLException ex) {
            Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
void Gun(){
    try {
        st = Baglan();
        rs = st.executeQuery("SELECT Gun FROM antrenman WHERE MusteriNo=" + KullaniciNo);
        rs.next();
        
     if(rs.first()){
           if(rs.last()){
            int x = Integer.parseInt(rs.getString(1));
            gun = x+1;
            GunLabel2.setText(gun + "");       
           }
        }
       else {
         gun = 1; 
         GunLabel2.setText("İLK "); 
       }

    
        } catch (SQLException ex) {
            Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        set4 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        set5 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        set6 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        set7 = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        set8 = new javax.swing.JComboBox<>();
        isim = new javax.swing.JLabel();
        AEkle = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        GunLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        s1 = new javax.swing.JComboBox<>();
        s2 = new javax.swing.JComboBox<>();
        s3 = new javax.swing.JComboBox<>();
        s4 = new javax.swing.JComboBox<>();
        s5 = new javax.swing.JComboBox<>();
        s6 = new javax.swing.JComboBox<>();
        GunBox = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        Uyari = new javax.swing.JLabel();
        GeriDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Sırt Set Sayısı");

        set4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(set4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(set4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setText("Kol Set Sayısı");

        set5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(set5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(set5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel14.setText("EKLE");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Kanat Set Sayısı");

        set6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(set6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(set6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setText("Omuz Set Sayısı");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        set7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(set7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(set7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setText("Bacak Set Sayısı");

        set8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", " " }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(set8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(set8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
        setMaximumSize(new java.awt.Dimension(640, 481));
        setMinimumSize(new java.awt.Dimension(640, 481));
        setPreferredSize(new java.awt.Dimension(640, 520));
        setResizable(false);
        getContentPane().setLayout(null);

        isim.setBackground(new java.awt.Color(102, 153, 255));
        isim.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        isim.setForeground(new java.awt.Color(255, 255, 255));
        isim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isim.setOpaque(true);
        getContentPane().add(isim);
        isim.setBounds(1, 0, 640, 100);

        AEkle.setBackground(new java.awt.Color(102, 153, 255));
        AEkle.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AEkle.setForeground(new java.awt.Color(255, 255, 255));
        AEkle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AEkle.setText("Ekle");
        AEkle.setOpaque(true);
        AEkle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AEkleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AEkleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AEkleMouseExited(evt);
            }
        });
        getContentPane().add(AEkle);
        AEkle.setBounds(230, 380, 210, 30);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setLayout(null);

        GunLabel2.setBackground(new java.awt.Color(255, 255, 255));
        GunLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        GunLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        GunLabel2.setText(" ");
        GunLabel2.setOpaque(true);
        jPanel5.add(GunLabel2);
        GunLabel2.setBounds(0, 0, 150, 30);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText(".GÜN");
        jLabel7.setOpaque(true);
        jPanel5.add(jLabel7);
        jLabel7.setBounds(150, 0, 60, 30);

        jLabel8.setText("Kol Set Sayısı");
        jPanel5.add(jLabel8);
        jLabel8.setBounds(10, 140, 130, 20);

        jLabel15.setText("Spor Günü");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(10, 40, 80, 30);

        jLabel16.setText("Sırt Set Sayısı");
        jPanel5.add(jLabel16);
        jLabel16.setBounds(10, 110, 130, 20);

        jLabel17.setText("Bacak Set Sayısı");
        jPanel5.add(jLabel17);
        jLabel17.setBounds(10, 230, 130, 20);

        jLabel18.setText("Kanat Set Sayısı");
        jPanel5.add(jLabel18);
        jLabel18.setBounds(10, 170, 130, 20);

        jLabel19.setText("Omuz Set Sayısı");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(10, 200, 130, 20);

        s1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s1);
        s1.setBounds(150, 80, 50, 20);

        s2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s2);
        s2.setBounds(150, 110, 50, 20);

        s3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s3);
        s3.setBounds(150, 140, 50, 20);

        s4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s4);
        s4.setBounds(150, 170, 50, 20);

        s5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s5);
        s5.setBounds(150, 200, 50, 20);

        s6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));
        jPanel5.add(s6);
        s6.setBounds(150, 230, 50, 20);

        GunBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar" }));
        jPanel5.add(GunBox);
        GunBox.setBounds(93, 40, 110, 30);

        jLabel20.setText("Göğüs Set Sayısı");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(10, 80, 130, 20);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(230, 110, 210, 260);

        Uyari.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Uyari.setForeground(new java.awt.Color(255, 255, 255));
        Uyari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Uyari);
        Uyari.setBounds(220, 380, 230, 30);

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
        GeriDon.setBounds(230, 420, 210, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AEkleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AEkleMouseClicked
    try {
        st = Baglan();
        rs = st.executeQuery("SELECT Gun FROM antrenman WHERE MusteriNo=" + KullaniciNo);
        rs.next();
        
        st.executeUpdate("insert into antrenman (Gun,Gogus,Sırt,Kol,Kanat,Omuz,Bacak,MusteriNo,Gunİsim)"
                + "Values('"+gun+"','"+s1.getSelectedItem().toString()+"','"+s2.getSelectedItem().toString()
                +"','"+s3.getSelectedItem().toString()+"','"+s4.getSelectedItem().toString()
                +"','"+s5.getSelectedItem().toString()+"','"+s6.getSelectedItem().toString()
                +"','"+KullaniciNo +"','"+ GunBox.getSelectedItem().toString() + "')");
  
        } catch (SQLException ex) {
            Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(Level.SEVERE, null, ex);
        }
        Uyari.setText("Başarıyla Eklendi!");
        AEkle.setVisible(false);
    }//GEN-LAST:event_AEkleMouseClicked

    private void AEkleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AEkleMouseEntered
        setColor(AEkle);
    }//GEN-LAST:event_AEkleMouseEntered

    private void AEkleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AEkleMouseExited
        resetColor(AEkle);
    }//GEN-LAST:event_AEkleMouseExited

    private void GeriDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeriDonMouseClicked
        this.setVisible(false);
        new UyeninEkrani(KullaniciNo).setVisible(true);
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
            java.util.logging.Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UyeAntrenmanEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UyeAntrenmanEkle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AEkle;
    private javax.swing.JLabel GeriDon;
    private javax.swing.JComboBox<String> GunBox;
    private javax.swing.JLabel GunLabel2;
    private javax.swing.JLabel Uyari;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> s1;
    private javax.swing.JComboBox<String> s2;
    private javax.swing.JComboBox<String> s3;
    private javax.swing.JComboBox<String> s4;
    private javax.swing.JComboBox<String> s5;
    private javax.swing.JComboBox<String> s6;
    private javax.swing.JComboBox<String> set4;
    private javax.swing.JComboBox<String> set5;
    private javax.swing.JComboBox<String> set6;
    private javax.swing.JComboBox<String> set7;
    private javax.swing.JComboBox<String> set8;
    // End of variables declaration//GEN-END:variables
}
