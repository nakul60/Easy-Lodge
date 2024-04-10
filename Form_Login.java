/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my_project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Classes.DB;
import javax.swing.JOptionPane;

/**
 *
 * @author ARORA
 */
public class Form_Login extends javax.swing.JFrame {

    /**
     * Creates new form Form_Login
     */
    public Form_Login() {
        initComponents();
        
        //centre the form
        this.setLocationRelativeTo(null);
        
    }
    public void displayImage(int width,int height,byte[] image_byte, JLabel label)
    { 
        ImageIcon imageIco = new ImageIcon(image_byte);
        Image image = imageIco.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        jLabel_user = new javax.swing.JLabel();
        jLabel_pass = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jCheckBox_password = new javax.swing.JCheckBox();
        jButton_login = new javax.swing.JButton();
        jLabel_close = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        login1 = new javax.swing.JLabel();
        jButton_signup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 153));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jPanel3.setBackground(new java.awt.Color(230, 230, 235));

        login.setFont(new java.awt.Font("Monotype Corsiva", 1, 48)); // NOI18N
        login.setText("Login");

        jLabel_user.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my_project/images/admin_4_1.jpg"))); // NOI18N
        jLabel_user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 204), 1, true));
        jLabel_user.setOpaque(true);

        jLabel_pass.setBackground(new java.awt.Color(0, 0, 0));
        jLabel_pass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my_project/images/password_1.png"))); // NOI18N
        jLabel_pass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 255), 1, true));
        jLabel_pass.setOpaque(true);

        jTextField_username.setForeground(new java.awt.Color(204, 204, 204));
        jTextField_username.setText("username");
        jTextField_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_usernameFocusLost(evt);
            }
        });

        jCheckBox_password.setText("Show Password");
        jCheckBox_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_passwordActionPerformed(evt);
            }
        });

        jButton_login.setBackground(new java.awt.Color(153, 255, 153));
        jButton_login.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jButton_login.setText("Login");
        jButton_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_login.setOpaque(true);
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        jLabel_close.setBackground(new java.awt.Color(255, 0, 0));
        jLabel_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_close.setText("X");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseExited(evt);
            }
        });

        jPasswordField2.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordField2.setText("password");
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my_project/images/House Renting System_4.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        login1.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 18)); // NOI18N
        login1.setText("Do not have an account ?");

        jButton_signup.setBackground(new java.awt.Color(153, 153, 255));
        jButton_signup.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jButton_signup.setText("Sign up");
        jButton_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_signup.setOpaque(true);
        jButton_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_signupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(login1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(login1)
                .addGap(29, 29, 29)
                .addComponent(jButton_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_user)
                            .addComponent(jLabel_pass))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox_password)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_user)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_pass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
        String username = jTextField_username.getText();
        String password = String.valueOf(jPasswordField2.getPassword());
        
        PreparedStatement ps;
        ResultSet rs;
        
        String query = "SELECT * FROM `users` WHERE `username` = ? AND password = ?";
        
        
        if(username.trim().toLowerCase().equals("username") || password.trim().toLowerCase().equals("password"))
        { 
            JOptionPane.showMessageDialog(null, "Enter a Valid username and password", "Error", JOptionPane.ERROR_MESSAGE);

        }
        
        else
        { 
            try
            { 
                ps = DB.getConnection().prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
            
                if(rs.next())
                { 
                    //System.out.println("Login");
                    //display the dashboard form
                    Form_Dashboard frm_dsh = new Form_Dashboard();
                    frm_dsh.setVisible(true);
                    Form_Dashboard.jLabel_username.setText(rs.getString("username"));
                    
                    displayImage(Form_Dashboard.jLabeluser_Profile_Pic.getWidth(), Form_Dashboard.jLabeluser_Profile_Pic.getHeight(), rs.getBytes("image"), Form_Dashboard.jLabeluser_Profile_Pic);
                    
                    //hide the login form
                    this.dispose();
                }
            
                else
                { 
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            
            catch(SQLException ex)
            { 
                System.out.println(ex.getMessage());
            }
            
            
        }
    }//GEN-LAST:event_jButton_loginActionPerformed

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
            System.exit(0);
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
         jLabel_close.setForeground(Color.RED);
         jLabel_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        jLabel_close.setForeground(Color.BLACK);
        jLabel_close.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jTextField_usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusGained
        //clear text if text = 'username'
        if(jTextField_username.getText().trim().toLowerCase().equals("username"))
        {
            jTextField_username.setText("");
            jTextField_username.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jTextField_usernameFocusGained

    private void jTextField_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_usernameFocusLost
        if(jTextField_username.getText().trim().toLowerCase().equals("username") || 
                jTextField_username.getText().trim().toLowerCase().equals(""))
        {
            jTextField_username.setText("username");
            jTextField_username.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jTextField_usernameFocusLost

    private void jCheckBox_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_passwordActionPerformed
        jCheckBox_password.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //show and hide password
        if(jCheckBox_password.isSelected())
        {
            jPasswordField2.setEchoChar((char)0);
        }
        else
        {
            jPasswordField2.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox_passwordActionPerformed

    private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        //clear text if text = 'password'
        String password = String.valueOf(jPasswordField2.getPassword());
        if(password.trim().toLowerCase().equals("password"))
        {
            jPasswordField2.setText("");
            jPasswordField2.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jPasswordField2FocusGained

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        String password = String.valueOf(jPasswordField2.getPassword());
        if(password.trim().toLowerCase().equals("password") || password.trim().toLowerCase().equals(""))
        {
            jPasswordField2.setText("password");
            jPasswordField2.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jButton_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_signupActionPerformed
        // TODO add your handling code here:
        Form_Users frm_users = new Form_Users();
                    frm_users.setVisible(true);
    }//GEN-LAST:event_jButton_signupActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Form_Login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_login;
    private javax.swing.JButton jButton_signup;
    private javax.swing.JCheckBox jCheckBox_password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_pass;
    private javax.swing.JLabel jLabel_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField_username;
    private javax.swing.JLabel login;
    private javax.swing.JLabel login1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
