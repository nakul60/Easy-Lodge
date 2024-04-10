/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author ARORA
 */
public class Category_Cls {
    
    private int id;
    private String name;
    private byte[] pic;
    
     public Category_Cls() {
        
    }

    public Category_Cls(int _id, String _name, byte[] _pic) {
        this.id = _id;
        this.name = _name;
        this.pic = _pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }
    
    public void addCategory(String _name, byte[] _pic)
    { 
        String insertQuery = "INSERT INTO `category`(`Name`, `Pic`) VALUES (?,?)";
        PreparedStatement ps;
        ResultSet rs;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _name);
            ps.setBytes(2, _pic);
            
            if(ps.executeUpdate() != 0)
            { 
                System.out.println("Category Added");
            }
            else
            { 
                System.out.println("Category not added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Category_Cls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
