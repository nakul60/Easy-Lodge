/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Classes.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import my_project.Form_Category;
/**
 *
 * @author ARORA
 */
public class Category {
    
     private int id;
    private String name;
    private byte[] pic;
    
     public Category() {
        
    }

    public Category(int _id, String _name, byte[] _pic) {
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
    //Function to add category
    public void addCategory(String _name, byte[] _pic)
    { 
        String insertQuery = "INSERT INTO `category`(`Name`, `Pic`) VALUES (?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _name);
            ps.setBytes(2, _pic);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The new category has been added","Add category",1);
                //System.out.println("Category Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Category not added","Add category",2);
               // System.out.println("Category Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Category_Cls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    
    //Function to edit category
    public void editCategory(int _id,String _name, byte[] _pic)
    { 
        String editQuery = "UPDATE `category` SET `Name`= ?,`Pic`= ? WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _name);
            ps.setBytes(2, _pic);
            ps.setInt(3, _id);
            
            if(ps.executeUpdate() != 0)
            { 
               JOptionPane.showMessageDialog(null,"The category has been edited","Edit category",1);
                // System.out.println("Category Edited");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Category not edited","Edit category",2);
                //System.out.println("Category Not Edited");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Category_Cls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    //Function to remove category
    public void removeCategory(int _id)
    { 
        String removeQuery = "DELETE FROM `category` WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This category has been deleted","Delete category",1);
                //System.out.println("Category Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Category not deleted","Delete category",2);
                //System.out.println("Category Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Category_Cls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //create a function to return a resultset
    public ResultSet getData(String query)
    {
        PreparedStatement ps;
        ResultSet rs = null;
        
        try{
            
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        }catch(SQLException ex)
        {
             java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
         return rs;
    }
    
    //create a function to get all categories and return an array list
    public ArrayList<Category> categorysList()
    {
        ArrayList<Category> catList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `category`");
        
        try{
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                Category category = new Category(rs.getInt(1),rs.getString(2),rs.getBytes(3));
                catList.add(category);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return catList;
    }
    
    
    //create a function to get category by id
    public Category getCategoryById(int category_id)
    {
        String query = "SELECT * FROM `category` WHERE `ID` = "+category_id;
        ResultSet rs = getData(query);
        Category category = null;
        try{
            rs.next();
            category = new Category(rs.getInt(1), rs.getString(2), rs.getBytes(3));
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return category;
    }
    
    public HashMap<String, Integer> categoryHashMap()
{ 
    HashMap<String, Integer> category_map = new HashMap<String, Integer>();
    ResultSet rs = getData("SELECT * FROM category"); // Remove single quotes
    try
    { 
        while(rs.next())
        { 
            category_map.put(rs.getString(2), rs.getInt(1));
        }
    }
    catch(SQLException ex)
    { 
         java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    
    return category_map;
}

}
