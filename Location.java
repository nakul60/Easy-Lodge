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
public class Location {
    
    private int id;
    private String city;
    private String address;

    public Location() {}

    public Location(int _id, String _city, String _address) {
        this.id = _id;
        this.city = _city;
        this.address = _address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void addLocation(String _city, String _address)
    { 
        String insertQuery = "INSERT INTO `locations`(`city`, `location`) VALUES (?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _city);
            ps.setString(2, _address);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The new location has been added","Add location",1);
                //System.out.println("Location Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Location not added","Add location",2);
                //System.out.println("Location Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    public void editLocation(int _id, String _city, String _address)
    { 
        String editQuery = "UPDATE `locations` SET `city`=? ,`location`=? WHERE `id` =?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _city);
            ps.setString(2, _address);
            ps.setInt(3, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The location has been edited","Edit location",1);
                //System.out.println("Location Edited");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Location not edited","Edit location",2);
                //System.out.println("Location Not Edited");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void removeLocation(int _id)
    { 
        String removeQuery = "DELETE FROM `locations` WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This location has been deleted","Delete location",1);
                //System.out.println("Location Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Location not deleted","Delete location",2);
                //System.out.println("Location Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
             java.util.logging.Logger.getLogger(Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         return rs;
    }
    
    //create a function to get all categories and return an array list
    public ArrayList<Location> locationsList()
    {
        ArrayList<Location> locList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `locations`");
        
        try{
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                Location location = new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
                locList.add(location);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Location.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return locList;
    }
    
    
    
    
    
    
}
