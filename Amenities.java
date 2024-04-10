/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 * 
 *
 * @author ARORA
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Amenities {
    
    private int price = 0;
    private int id;
    private String layout;
    private String vicinity;
    private String rent;
    private String area;
    private String flooring;
    private String club_house;
    private String vastuu;
    
    private String air_con;
    private String wifi;
    private String balcony;
    private String lift;
    private String parking;
    private String security;
    private String mod_kitch;
    private String fur;

    public Amenities() {}

    public Amenities(int id, String layout, String vicinity, String rent, String area, String flooring, String club_house, String vastuu, String air_con, String wifi, String balcony, String lift, String parking, String security, String mod_kitch, String fur) {
        this.id = id;
        this.layout = layout;
        this.vicinity = vicinity;
        this.rent = rent;
        this.area = area;
        this.flooring = flooring;
        this.club_house = club_house;
        this.vastuu = vastuu;
        this.air_con = air_con;
        this.wifi = wifi;
        this.balcony = balcony;
        this.lift = lift;
        this.parking = parking;
        this.security = security;
        this.mod_kitch = mod_kitch;
        this.fur = fur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFlooring() {
        return flooring;
    }

    public void setFlooring(String flooring) {
        this.flooring = flooring;
    }

    public String getClub_house() {
        return club_house;
    }

    public void setClub_house(String club_house) {
        this.club_house = club_house;
    }

    public String getVastuu() {
        return vastuu;
    }

    public void setVastuu(String vastuu) {
        this.vastuu = vastuu;
    }

    public String getAir_con() {
        return air_con;
    }

    public void setAir_con(String air_con) {
        this.air_con = air_con;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBalcony() {
        return balcony;
    }

    public void setBalcony(String balcony) {
        this.balcony = balcony;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getMod_kitch() {
        return mod_kitch;
    }

    public void setMod_kitch(String mod_kitch) {
        this.mod_kitch = mod_kitch;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
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
    
    //create a function to get all houses and return an array list
    public ArrayList<Amenities> housesList()
    {
        ArrayList<Amenities> housesList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `amenities`");
        
        try{
            while(rs.next())
            {
                Amenities amen = new Amenities(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
                housesList.add(amen);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return housesList;
    }
    
    
    
    public void addAmenities(String _layout, String _vicinity,  String _rent,String _area, String _flooring, String _club_house, String _vastuu, String _air_con, String _wifi,String _balcony,String _lift,String _parking,String _security,String _mod_kitch,String _fur)
    { 
        String insertQuery ="INSERT INTO `amenities`(`layout`, `vicinity`, `rent_per_month`, `area`, `flooring`, `clubhouse`, `vastuu`, `air_conditioning`, `wifi`, `balcony`, `modular_kitchen`, `furniture`, `parking`, `security`, `lift`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _layout);
            ps.setString(2, _vicinity);
            ps.setString(3, _rent);
            ps.setString(4, _area); // Assuming _area is a string
            ps.setString(5, _flooring);
            ps.setString(6, _club_house);
            ps.setString(7, _vastuu);
            ps.setString(8, _air_con);
            ps.setString(9, _wifi);
            ps.setString(10, _balcony);
            ps.setString(11, _lift);
            ps.setString(12, _parking);
            ps.setString(13, _security);
            ps.setString(14, _mod_kitch);
            ps.setString(15, _fur);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The new house info has been added","Add location",1);
                //System.out.println("Location Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"House info not added","Add location",2);
                //System.out.println("Location Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Amenities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    //Function to add new house pic
    public void addHouseImage(int house_id, byte[] house_pic)
    { 
        String insertQuery = "INSERT INTO `house_images`(`house_id`, `house_pic`) VALUES (?,?)";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, house_id);
            ps.setBytes(2, house_pic);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"The new image has been added","Add Image",1);
                //System.out.println("Category Added");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"Image not added","Add Image",2);
               // System.out.println("Category Not Added");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Amenities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
     //Function to edit category
    public void editAmenities(int _id, String _layout, String _vicinity, String _rent, String _area, String _flooring, String _club_house, String _vastuu, String _air_con, String _wifi,String _balcony,String _lift,String _parking,String _security,String _mod_kitch,String _fur)
    { 
        String editQuery = "UPDATE `amenities` SET `layout`=?,`vicinity`=?,`rent_per_month`=?,`area`=?,`flooring`=?,`clubhouse`=?,`vastuu`=?,`air_conditioning`=?,`wifi`=?,`balcony`=?,`modular_kitchen`=?,`furniture`=?,`parking`=?,`security`=?,`lift`=? WHERE `id` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setString(1, _layout);
            ps.setString(2, _vicinity);
            ps.setString(3, _rent);
            ps.setString(4, _area); // Assuming _area is a string
            ps.setString(5, _flooring);
            ps.setString(6, _club_house);
            ps.setString(7, _vastuu);
            ps.setString(8, _air_con);
            ps.setString(9, _wifi);
            ps.setString(10, _balcony);
            ps.setString(11, _lift);
            ps.setString(12, _parking);
            ps.setString(13, _security);
            ps.setString(14, _mod_kitch);
            ps.setString(15, _fur);
            ps.setInt(16,_id);
          
            if(ps.executeUpdate() != 0)
            { 
               JOptionPane.showMessageDialog(null,"The House info has been edited","Edit house info",1);
                // System.out.println("Category Edited");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"House info not edited","Edit house info",2);
                //System.out.println("Category Not Edited");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Amenities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
    //Function to remove category
    public void removeAmenities(int _id)
    { 
        String removeQuery = "DELETE FROM `amenities` WHERE `ID` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, _id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This house info has been deleted","Delete house info",1);
                //System.out.println("Category Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"House info not deleted","Delete house info",2);
                //System.out.println("Category Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            java.util.logging.Logger.getLogger(Amenities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
     public void removeHouseImage(int img_id)
    { 
        String removeQuery = " DELETE FROM `house_images` WHERE `id` = ?";
        PreparedStatement ps;
        
        try
        { 
            ps = DB.getConnection().prepareStatement(removeQuery);
            ps.setInt(1, img_id);
            
            if(ps.executeUpdate() != 0)
            { 
                JOptionPane.showMessageDialog(null,"This house image  has been deleted","Delete house image",1);
                //System.out.println("Category Deleted");
            }
            else
            { 
                JOptionPane.showMessageDialog(null,"House image not deleted","Delete house image",2);
                //System.out.println("Category Not Deleted");
            }
            
        }
        
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null,"Select the image first","Delete Image",2);
        }
    }
    
     public ArrayList<Amenities> amenitiesList()
    {
        ArrayList<Amenities> amenitiesList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `Amenities`");
        
        try{
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                Amenities amenities = new Amenities(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
                amenitiesList.add(amenities);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return amenitiesList;
    }
    
    
     //START create a class for images
     public class HouseImage{
         private int img_id;
         private int house_id;
         private byte[] house_img;

        public HouseImage() {
        }

        public HouseImage(int img_id, int house_id, byte[] house_img) {
            this.img_id = img_id;
            this.house_id = house_id;
            this.house_img = house_img;
        }

        public int getImg_id() {
            return img_id;
        }

        public void setImg_id(int img_id) {
            this.img_id = img_id;
        }

        public int getHouse_id() {
            return house_id;
        }

        public void setHouse_id(int house_id) {
            this.house_id = house_id;
        }

        public byte[] getHouse_img() {
            return house_img;
        }

        public void setHouse_img(byte[] house_img) {
            this.house_img = house_img;
        }
         
         
     }
     
     //END class for images
   
     
    //create a function to get car images and return an array list
    public ArrayList<HouseImage> houseImagesList(int house_id)
    {
        ArrayList<HouseImage> images = new ArrayList<>();
        
        ResultSet rs = getData("SELECT `id`, `house_id`, `house_pic` FROM `house_images` WHERE `house_id` = " + house_id);
        HouseImage house_image;
        try{
            while(rs.next())
            {
               house_image = new HouseImage();
               house_image.setImg_id(rs.getInt(1));
               house_image.setHouse_id(rs.getInt(2));
               house_image.setHouse_img(rs.getBytes(3));
               images.add(house_image);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return images;
    }
    
    //create a function to get category by id
    public Amenities getAmenitiesById(int house_id)
    {
        String query = "SELECT * FROM `amenities` WHERE `ID` = " + house_id;
        ResultSet rs = getData(query);
        Amenities amen = null;
        try{
            if(rs.next())
            { 
                amen = new Amenities(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
            }
            
            else
            { 
                JOptionPane.showMessageDialog(null, "No house with this id","Invalid id",2);

            }
            
        }
        catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return amen;
    }
    
    
    public ArrayList<Amenities> housesbyCategoryList(int category_id)
    {
        ArrayList<Amenities> amenitiesList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `Amenities` WHERE layout = " + category_id);
        
        try{
            while(rs.next())
            {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                Amenities amenities = new Amenities(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15),rs.getString(16));
                amenitiesList.add(amenities);
            }
        }catch(SQLException ex)
        {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return amenitiesList;
    }
    
     public int calculateTotalPrice() {
        int totalPrice = 0;
        
        if (air_con != null) {
            totalPrice += 500; // Price for air conditioning
        }
        if (wifi != null) {
            totalPrice += 200; // Price for wifi
        }
        if (balcony != null) {
            totalPrice += 700; // Price for balcony
        }
        if (lift != null) {
            totalPrice += 600; // Price for lift
        }
        if (parking != null) {
            totalPrice += 500; // Price for parking
        }
        if (fur != null) {
            totalPrice += 800; // Price for furniture
        }
        if (security != null) {
            totalPrice += 400; // Price for security
        }
        if (mod_kitch != null) {
            totalPrice += 500; // Price for modular kitchen
        }
        
        // Add base price based on layout
        if ("Penthouse".equals(layout)) {
            totalPrice += 25000;
        } else if ("1 BHK".equals(layout)) {
            totalPrice += 10000;
        } else if ("2 BHK".equals(layout)) {
            totalPrice += 15000;
        } else if ("3 BHK".equals(layout)) {
            totalPrice += 20000;
        }
        
        // Add prices based on other factors like vicinity, area, flooring, etc.
        
        
        return totalPrice;
    }
}
