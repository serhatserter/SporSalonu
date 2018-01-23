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
import sp.Charts.CreateChartGelisim;


/**
 *
 * @author serhatPC
 */
public class UyeGelisimDurumu extends javax.swing.JFrame {

    /**
     * Creates new form UyeSporProgrami
     */
    public UyeGelisimDurumu() {
        initComponents();
    }

    @SuppressWarnings("empty-statement")
  UyeGelisimDurumu(String globalNo) {
        initComponents();
        KullaniciNo = globalNo;
        İsim();
        
        
        
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
int oran[] = new int[2];
String Gunler[] = {"Pazartesi","Salı","Çarşamba","Perşembe","Cuma","Cumartesi","Pazar"};

int[] Parcala(){
        try {
        st = Baglan();
for(int a=0; a<=6; a++){        
        rs = st.executeQuery("SELECT "+Gunler[a]+" FROM sporprogrami where MusteriNo='"+KullaniciNo+ "'");
        rs.next();
        
        int x = 0;
        int dizi[] = new int[6];
        
       if(rs.first()){
           if(rs.last()){       
                String Program = rs.getString(1);
                
                if(Program == null){System.out.println("null");}
                else {
                    
                    int i=0;
                    x=0;
                    while(i < Program.length()){
                        if(Program.substring(i, i+1).equals("-")){i++;}
                        else{
                           dizi[x] = Integer.parseInt(Program.substring(i, i+1));
                            
                           x++;
                           i++;   
                            
                        }
                    }
                    
                }
       
                
           }
        }
       
       int dizi2[] =new int[6];
       rs = st.executeQuery("SELECT * FROM antrenman where MusteriNo='"+KullaniciNo+ "' AND Gunİsim='"+Gunler[a]+"'");
           
       
        for(int i=2,t=0; i<=7; i++,t++){
            rs.beforeFirst();
            while(rs.next()){
                dizi2[t] =  Integer.parseInt(rs.getString(i));
                System.out.println(dizi2[t]+" "+dizi[t]);
                if(dizi2[t]==dizi[t]) {oran[0]++;}
                else {oran[1]++;}
                        
            }           
        }
        
          
}        
           
        } catch (SQLException ex) {
            Logger.getLogger(Kayit.class.getName()).log(Level.SEVERE, null, ex);
        }
        int toplam = oran[0]+oran[1];
        oran[0]=(oran[0]*100)/toplam;
        oran[1]=(oran[1]*100)/toplam;
        return oran;
}

    public void CreateChartGelisimE(){
        CreateChartGelisim CC = new CreateChartGelisim("Deneme", isim.getText(),Parcala());
        CC.pack(); 
        CC.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        isim = new javax.swing.JLabel();
        GeriDon = new javax.swing.JLabel();
        SetOranlari = new javax.swing.JLabel();
        Haftalık = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(350, 150));
        setMaximumSize(new java.awt.Dimension(640, 480));
        setPreferredSize(new java.awt.Dimension(640, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 600));
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
        GeriDon.setBounds(220, 390, 210, 30);

        SetOranlari.setBackground(new java.awt.Color(102, 153, 255));
        SetOranlari.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SetOranlari.setForeground(new java.awt.Color(255, 255, 255));
        SetOranlari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SetOranlari.setText("Set Oranları");
        SetOranlari.setOpaque(true);
        SetOranlari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SetOranlariMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SetOranlariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SetOranlariMouseExited(evt);
            }
        });
        getContentPane().add(SetOranlari);
        SetOranlari.setBounds(80, 190, 210, 90);

        Haftalık.setBackground(new java.awt.Color(102, 153, 255));
        Haftalık.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Haftalık.setForeground(new java.awt.Color(255, 255, 255));
        Haftalık.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Haftalık.setText("Haftalık Prog. Uyma Oranı");
        Haftalık.setOpaque(true);
        Haftalık.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HaftalıkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HaftalıkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HaftalıkMouseExited(evt);
            }
        });
        getContentPane().add(Haftalık);
        Haftalık.setBounds(340, 190, 210, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sp/resimler/spor2.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 100, 640, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void SetOranlariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetOranlariMouseClicked
        new UyeninEkrani(KullaniciNo).GelisimChart();
    }//GEN-LAST:event_SetOranlariMouseClicked

    private void SetOranlariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetOranlariMouseEntered
        setColor(SetOranlari);
    }//GEN-LAST:event_SetOranlariMouseEntered

    private void SetOranlariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SetOranlariMouseExited
        resetColor(SetOranlari);
    }//GEN-LAST:event_SetOranlariMouseExited

    private void HaftalıkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HaftalıkMouseClicked
        CreateChartGelisimE();
        
    }//GEN-LAST:event_HaftalıkMouseClicked

    private void HaftalıkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HaftalıkMouseEntered
        setColor(Haftalık);
    }//GEN-LAST:event_HaftalıkMouseEntered

    private void HaftalıkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HaftalıkMouseExited
       resetColor(Haftalık);
    }//GEN-LAST:event_HaftalıkMouseExited

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
            java.util.logging.Logger.getLogger(UyeGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UyeGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UyeGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UyeGelisimDurumu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UyeGelisimDurumu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GeriDon;
    private javax.swing.JLabel Haftalık;
    private javax.swing.JLabel SetOranlari;
    private javax.swing.JLabel isim;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
