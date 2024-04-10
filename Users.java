/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ARORA
 */
public class Users {
    private int id;
    private String fullname;
    private String username;
    private String password;
    private String user_type;
    private String phone;
    private byte[] picture;
    private String email;

    public Users() {
    }

    public Users(int id, String fullname, String username, String password, String user_type, byte[] picture, String phone, String email) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.picture = picture;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    
    public void addUser(String _fullname ,String _username,String _password,String _usertype, byte[] img, String _phone,String _email)
    { 
        String insertQuery = "INSERT INTO `users`(`fullname`, `username`, `password`, `user_type`, `image`, `phone`, `email`) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _fullname);
            ps.setString(2, _username);
            ps.setString(3, _password);
            ps.setString(4, _usertype);
            ps.setBytes(5, img);
            ps.setString(6, _phone);
            ps.setString(7, _email);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"Account has been Created","Add User",1);
                //System.out.println("Location Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Account Not Created","Add User",2);
                //System.out.println("Location Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void editUser(int _id,String _fullname ,String _username,String _password,String _usertype, byte[] img, String _phone,String _email )
    { 
        String editQuery = "UPDATE `users` SET `fullname`=?,`username`=?,`password`=?,`user_type`=?,`image`=?,`phone`=?,`email`=? WHERE `id` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _fullname);
            ps.setString(2, _username);
            ps.setString(3, _password);
            ps.setString(4, _usertype);
            ps.setBytes(5, img);
            ps.setString(6, _phone);
            ps.setString(7, _email);
            ps.setInt(8,_id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The user info has been edited","Edit user info",1);
                //System.out.println("Location Edited");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"User info not edited","Edit user info",2);
                //System.out.println("Location Not Edited");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void removeUser(int _id)
    { 
        String removeQuery = "DELETE FROM `users` WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This user info has been deleted","Delete user info",1);
                //System.out.println("Location Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"User info not deleted","Delete user info",2);
                //System.out.println("Location Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
     public Users getUserById(int user_id)
    {
        String query = "SELECT * FROM `users` WHERE `ID` = " + user_id;
        ResultSet rs = getData(query);
        Users user= null;
        try{
            rs.next();
            user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5),rs.getBytes(6), rs.getString(7),rs.getString(8));
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return user;
    }
    
    
    public ResultSet getData(String query)
    {
        PreparedStatement ps;
        ResultSet rs = null;
        
        try{
            
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        }catch(SQLException ex)
        {
             java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         return rs;
    }
    
    //create a function to get all categories and return an array list
    public ArrayList<Users> usersList()
    {
        ArrayList<Users> users_List = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `users`");
        
        try{
            while(rs.next())
            {
               
                Users user = new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getBytes(6),rs.getString(7),rs.getString(8));
                users_List.add(user);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return users_List;
    }
    
}
