/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LibraryVisitorsTrackingSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
  import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import static LibraryVisitorsTrackingSystem.in_gui.notify_name;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author jober
 */  
public class Login_Gui extends javax.swing.JFrame {
    /**
     * Creates new form LOGIN
     */
    public Login_Gui() {
        initComponents();
          getRootPane().setDefaultButton(logenter_btn);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idNumber_input = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        logenter_btn = new javax.swing.JButton();
        logback_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("ID No: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        idNumber_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumber_inputActionPerformed(evt);
            }
        });
        jPanel1.add(idNumber_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 160, -1));

        jLabel1.setText("Talisay City College Library Department");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        logenter_btn.setText("Enter");
        logenter_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logenter_btnActionPerformed(evt);
            }
        });
        logenter_btn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                logenter_btnKeyPressed(evt);
            }
        });
        jPanel1.add(logenter_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        logback_btn.setText("Back");
        logback_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logback_btnActionPerformed(evt);
            }
        });
        jPanel1.add(logback_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        jLabel3.setText("Full Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameActionPerformed(evt);
            }
        });
        jPanel1.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

       public static String nameNotify;
    Connection con;
    PreparedStatement ps; 
    private void login_fetch(){
     
       LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String formattedDateTime = now.format(formatter);
        
    //fetching date and time to sql
        
        String IDum = idNumber_input.getText();
        String fname = fullname.getText();
        
        
          try {
              
              //visitor counter
             // Replace 42 with your int value
         
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String jdbcURL = "jdbc:mysql://127.0.0.1:3306/ADMIN_DB?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "kalmamigos";
            
             con = DriverManager.getConnection(jdbcURL, username, password);
            
            Connection con = DriverManager.getConnection(jdbcURL, username, password);

            // Get the current date and time formatted as "yyyy-MM-dd HH:mm:ss"
          

            // Create a PreparedStatement with your INSERT SQL
            String insertSql = "INSERT INTO STUDENT_INFO (ID_NUMBER, FULLNAME, TIME_IN) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSql);

            // Set values for the placeholders
            ps.setString(1, IDum);
            ps.setString(2, fname);
            ps.setString(3, formattedDateTime);

            // Execute the INSERT query
            int rowsAffected = ps.executeUpdate();

            ps.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dashboard_Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void idNumber_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumber_inputActionPerformed
         
    }//GEN-LAST:event_idNumber_inputActionPerformed
  
    private void logback_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logback_btnActionPerformed
        // TODO add your handling code here:
        Menu_Gui menu = new Menu_Gui();
        menu.setVisible(true);
        this.setVisible(false);
        

    }//GEN-LAST:event_logback_btnActionPerformed
  public static void name(){
        
       String notName = fullname.getText();
       //declared jlabel "notify_name"
     nameNotify = "Hello "+fullname.getText();
           
       System.out.println("Hello "+notName+" you have successfully logged in");
       
       
    }
    private void logenter_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logenter_btnActionPerformed
 // TODO add your handling code here:
 
 Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(idNumber_input.getText());
        if (matcher.find()) {
            JOptionPane.showMessageDialog(
                null,
                "You are not allowed to input letters from 'a' to 'z.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE
            );

        }
        else{
            name();
  login_fetch();
   Menu_Gui menu = new Menu_Gui();
   
   
   
   in_gui notif = new in_gui();
   notif.setVisible(true);
   this.dispose();
        }
        
    }//GEN-LAST:event_logenter_btnActionPerformed

    private void fullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fullnameActionPerformed

    private void logenter_btnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_logenter_btnKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_logenter_btnKeyPressed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_Gui().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField fullname;
    public static javax.swing.JTextField idNumber_input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logback_btn;
    private javax.swing.JButton logenter_btn;
    // End of variables declaration//GEN-END:variables
}
