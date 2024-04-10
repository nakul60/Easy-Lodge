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
public class Tenants {
    
    private int id;
    private String fullname;
    private String birthdate;
    private String phone;
    private String email;
    private String address;

    public Tenants() {
    }

    public Tenants(int id, String fullname, String birthdate, String phone, String email, String address) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    public void addTenant(String _fullname ,String _birthdate,String _phone,String _email, String _address)
    { 
        String insertQuery = "INSERT INTO `tenants`(`fullname`, `birth_date`, `phone`, `email`, `address`) VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _fullname);
            ps.setString(2, _birthdate);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _address);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The new tenant has been added","Add Tenant",1);
                //System.out.println("Location Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Tenant not added","Add Tenant",2);
                //System.out.println("Location Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    public void editTenant(int _id, String _fullname ,String _birthdate,String _phone,String _email, String _address)
    { 
        String editQuery = "UPDATE `tenants` SET `fullname`=?,`birth_date`=?,`phone`=?,`email`=?,`address`=? WHERE `id` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _fullname);
            ps.setString(2, _birthdate);
            ps.setString(3, _phone);
            ps.setString(4, _email);
            ps.setString(5, _address);
            ps.setInt(6, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The tenant info has been edited","Edit tenant info",1);
                //System.out.println("Location Edited");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Tenant info not edited","Edit Tenant info",2);
                //System.out.println("Location Not Edited");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void removeTenant(int _id)
    { 
        String removeQuery = "DELETE FROM `tenants` WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This tenant has been deleted","Delete tenant",1);
                //System.out.println("Location Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Tenant not deleted","Delete tenant",2);
                //System.out.println("Location Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
    public ArrayList<Tenants> tenantsList()
    {
        ArrayList<Tenants> tenantsList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `tenants`");
        
        try{
            while(rs.next())
            {
               
                Tenants tenant = new Tenants(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                tenantsList.add(tenant);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Tenants.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return tenantsList;
    }
    
    
    
}
