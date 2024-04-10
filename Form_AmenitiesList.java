/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my_project;

import Classes.Amenities;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ARORA
 */
public class Form_AmenitiesList extends javax.swing.JFrame {

    /**
     * Creates new form Form_HouseList
     * @param width
     * @param height
     * @param image_byte
     * @param label
     */
  /* public void displayByteImage(int width, int height, byte[] image_byte, JLabel label) {
    if (image_byte != null && image_byte.length > 0) {
        // Convert the byte array to an Image
        ImageIcon imageIcon = new ImageIcon(image_byte);
        // Scale the image to fit the size of the JLabel
        Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        // Set the scaled image as the icon of the JLabel
        label.setIcon(new ImageIcon(image));
    } else {
        // If the byte array is null or empty, clear the icon of the JLabel
        label.setIcon(null);
    }
}*/

    Amenities amenities = new Amenities();
    int houseid;
    
    //table of jlabels
   // JLabel[] labels = new JLabel[6];
    
    
    
    public Form_AmenitiesList() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        populateJtableWithAmenities();
        
        //labels[0] = jLabel_House_Image_1;
        //labels[1] = jLabel_House_Image_2;
        //labels[2] = jLabel_House_Image_3;
        //labels[3] = jLabel_House_Image_4;
        //labels[4] = jLabel_House_Image_5;
        //labels[5] = jLabel_House_Image_6;
    }
    
    public double calculate_price()
    {
        int rowIndex = jTable_Houses.getSelectedRow();

    String layout = jTable_Houses.getValueAt(rowIndex, 1).toString();
    String vicinity = jTable_Houses.getValueAt(rowIndex, 2).toString();
    String rent = jTable_Houses.getValueAt(rowIndex, 3).toString();
    String area = jTable_Houses.getValueAt(rowIndex, 4).toString();
    String flooring = jTable_Houses.getValueAt(rowIndex, 5).toString();
    String clubHouse = jTable_Houses.getValueAt(rowIndex, 6).toString();
    String vastuu = jTable_Houses.getValueAt(rowIndex, 7).toString();
    String aircon = jTable_Houses.getValueAt(rowIndex, 8).toString();
    String wifi = jTable_Houses.getValueAt(rowIndex, 9).toString();
    String balcony = jTable_Houses.getValueAt(rowIndex, 10).toString();
    String mk = jTable_Houses.getValueAt(rowIndex, 11).toString();
    String fur = jTable_Houses.getValueAt(rowIndex, 12).toString();
    String park = jTable_Houses.getValueAt(rowIndex, 13).toString();
    String sec = jTable_Houses.getValueAt(rowIndex, 14).toString();
    String lift = jTable_Houses.getValueAt(rowIndex, 15).toString();
    
    // Add more amenities as needed
    
    // Define pricing algorithm based on the selected amenities and layout
    double basePrice = 0.0; // Base price for the house
    
    // Adjust the price based on amenities
    if ("yes".equals(aircon)) {
        basePrice += 300.0;
    }
    if ("yes".equals(wifi)) {
        basePrice += 150.0;
    }
    if ("yes".equals(balcony)) {
        basePrice += 400.0;
    }
    if ("yes".equals(mk)) {
        basePrice += 300.0;
    }
    if ("yes".equals(fur)) {
        basePrice += 200.0;
    }
    if ("yes".equals(park)) {
        basePrice += 150.0;
    }
    if ("yes".equals(sec)) {
        basePrice += 150.0;
    }
    if ("yes".equals(lift)) {
        basePrice += 450.0;
    }
    if ("Penthouse".equals(layout)) {
        basePrice += 25000.0;
    }
    if ("1 BHK".equals(layout)) {
        basePrice += 10000.0;
    }
    if ("2 BHK".equals(layout)) {
        basePrice += 15000.0;
    }
    if ("3 BHK".equals(layout)) {
        basePrice += 20000.0;
    }
    if ("Mall".equals(vicinity)) {
        basePrice += 450.0;
    }
    if ("School".equals(vicinity)) {
        basePrice += 550.0;
    }
    if ("Hospital".equals(vicinity)) {
        basePrice += 650.0;
    }
    if ("Air Port".equals(vicinity)) {
        basePrice += 750.0;
    }
    if ("Railway Station".equals(vicinity)) {
        basePrice += 750.0;
    }
    if ("Restaurant".equals(vicinity)) {
        basePrice += 450.0;
    }
    if ("School".equals(vicinity)) {
        basePrice += 550.0;
    }
    if ("400 - 600".equals(area)) {
        basePrice += 400.0;
    }
    if ("600 - 800".equals(area)) {
        basePrice += 600.0;
    }
    if ("800 - 1000".equals(area)) {
        basePrice += 800.0;
    }
    if ("> 1000".equals(area)) {
        basePrice += 1000.0;
    }
    if ("granite".equals(flooring)) {
        basePrice += 500.0;
    }
    if ("marble".equals(flooring)) {
        basePrice += 300.0;
    }
    if ("Swimming Pool".equals(clubHouse)) {
        basePrice += 550.0;
    }
    if ("Gym".equals(clubHouse)) {
        basePrice += 650.0;
    }
    if ("Badminton".equals(clubHouse)) {
        basePrice += 350.0;
    }
        return basePrice;
    }
    
    
    public void populateJtableWithAmenities()
    {
        //clear arraylist
        //categorys_list.clear();
        //populate arraylist
       ArrayList<Amenities> amenities_list = amenities.amenitiesList();
        
        //jtable columns
        String[] columnsName = {"ID","layout","vicinity","rent","area","flooring","club_house","vastuu","air_cond","wifi","balcony","modular_kitchen","furniture","parking","secuirty","lift"};
        
        //jtable rows
        Object[][] rows = new Object[amenities_list.size()][columnsName.length];
        
        for(int i=0;i<amenities_list.size();i++)
        {
            rows[i][0] = amenities_list.get(i).getId();
            rows[i][1] = amenities_list.get(i).getLayout();
            rows[i][2] = amenities_list.get(i).getVicinity();
            rows[i][3] = amenities_list.get(i).getRent();
            rows[i][4] = amenities_list.get(i).getArea();
            rows[i][5] = amenities_list.get(i).getFlooring();
            rows[i][6] = amenities_list.get(i).getClub_house();
            rows[i][7] = amenities_list.get(i).getVastuu();
            rows[i][8] = amenities_list.get(i).getAir_con();
            rows[i][9] = amenities_list.get(i).getWifi();
            rows[i][10] = amenities_list.get(i).getBalcony();
            rows[i][11] = amenities_list.get(i).getMod_kitch();
            rows[i][12] = amenities_list.get(i).getFur();
            rows[i][13] = amenities_list.get(i).getParking();
            rows[i][14] = amenities_list.get(i).getSecurity();
            rows[i][15] = amenities_list.get(i).getLift();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columnsName);
        jTable_Houses.setModel(model);
        
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_close = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Houses = new javax.swing.JTable();
        jLabel_imagePath = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_price = new javax.swing.JLabel();
        jButton_calculate = new javax.swing.JButton();
        jButton_booking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel3.setBackground(new java.awt.Color(225, 112, 85));
        jPanel3.setToolTipText("");

        jLabel_close.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel_close.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close.setText("X");
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("House Bookings");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(475, 475, 475)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_close)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTable_Houses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable_Houses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Houses.setRowHeight(50);
        jTable_Houses.setSelectionBackground(new java.awt.Color(255, 51, 0));
        jTable_Houses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_HousesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Houses);

        jLabel_imagePath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_imagePath.setText("     ");

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel1.setText("Total Price:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel2.setText("Rs/month");

        jLabel_price.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel_price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel_price, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel_price, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jButton_calculate.setBackground(new java.awt.Color(153, 255, 153));
        jButton_calculate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jButton_calculate.setText("Calculate");
        jButton_calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calculateActionPerformed(evt);
            }
        });

        jButton_booking.setBackground(new java.awt.Color(255, 153, 153));
        jButton_booking.setFont(new java.awt.Font("Segoe UI Emoji", 0, 18)); // NOI18N
        jButton_booking.setText("Confirm Booking");
        jButton_booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_bookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(883, 883, 883))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jButton_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton_calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(250, 250, 250))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_booking, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)))
                .addComponent(jLabel_imagePath))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jLabel_closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseEntered
        jLabel_close.setForeground(Color.RED);
        jLabel_close.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel_closeMouseEntered

    private void jLabel_closeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseExited
        jLabel_close.setForeground(Color.BLACK);
        jLabel_close.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jLabel_closeMouseExited

    private void jTable_HousesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_HousesMouseClicked
    //clear the images
    //jLabel_House_Image.setIcon(null);
    
    /*for(int i=0;i<labels.length;i++)
    {
        labels[i].setIcon(null);
    }*/
        
        
   // int index = jTable_Houses.getSelectedRow();
    //int id = Integer.valueOf(jTable_Houses.getValueAt(index, 0).toString());
    //houseid = id;

// Fetching images associated with the selected ID
    //ArrayList<Amenities.HouseImage> images = amenities.houseImagesList(id);

// Checking if the images list is not empty before attempting to display the first image
/*if (!images.isEmpty()) {
    // Displaying the first image in the jLabel component
    displayByteImage(jLabel_House_Image.getWidth(), jLabel_House_Image.getHeight(), images.get(0).getHouse_img(), jLabel_House_Image);
} else {
    // Handle the case where no images are found for the selected ID
    // For example, display a default image or a message indicating no images found
    jLabel_House_Image.setIcon(null); // Clearing any previous image
    // jLabel_House_Image.setText("No image available"); // Optionally display a message
}*/
    /*if(images.size() > 0)
    {
        displayByteImage(jLabel_House_Image.getWidth(), jLabel_House_Image.getHeight(), images.get(0).getHouse_img(), jLabel_House_Image);
        for(int i=0;i<images.size();i++)
        {
            if(i < labels.length)
               displayByteImage(labels[i].getWidth(), labels[i].getHeight(), images.get(i).getHouse_img(), labels[i]);
        }
    }*/
    /*else
    {
        JOptionPane.showMessageDialog(null, "This house has No Images", "No Image",2);
    }*/

        //int id = Integer.valueOf(jTable_Locations.getValueAt(index, 0).toString());
        //Classes.Category cat = location.getCategoryById(id);
        //jSpinner_id.setValue(Integer.valueOf(jTable_Category.getValueAt(index,0).toString()));
        //jComboBox_City.setSelectedItem(jTable_Category.getValueAt(index,1).toString());
        //jTextArea_Address.setText(jTable_Category.getValueAt(index,2).toString());
    }//GEN-LAST:event_jTable_HousesMouseClicked

    private void jButton_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calculateActionPerformed
        //Button to calaculate the price of the house
        // Get the selected row index from the jTable
    int rowIndex = jTable_Houses.getSelectedRow();
    double price = calculate_price();
    // Check if any row is selected
    if (rowIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please select a house to calculate the price.");
        return;
    }
    /*
    // Retrieve the selected amenities and layout from the jTable
    String layout = jTable_Houses.getValueAt(rowIndex, 1).toString();
    String vicinity = jTable_Houses.getValueAt(rowIndex, 2).toString();
    String rent = jTable_Houses.getValueAt(rowIndex, 3).toString();
    String area = jTable_Houses.getValueAt(rowIndex, 4).toString();
    String flooring = jTable_Houses.getValueAt(rowIndex, 5).toString();
    String clubHouse = jTable_Houses.getValueAt(rowIndex, 6).toString();
    String vastuu = jTable_Houses.getValueAt(rowIndex, 7).toString();
    String aircon = jTable_Houses.getValueAt(rowIndex, 8).toString();
    String wifi = jTable_Houses.getValueAt(rowIndex, 9).toString();
    String balcony = jTable_Houses.getValueAt(rowIndex, 10).toString();
    String mk = jTable_Houses.getValueAt(rowIndex, 11).toString();
    String fur = jTable_Houses.getValueAt(rowIndex, 12).toString();
    String park = jTable_Houses.getValueAt(rowIndex, 13).toString();
    String sec = jTable_Houses.getValueAt(rowIndex, 14).toString();
    String lift = jTable_Houses.getValueAt(rowIndex, 15).toString();
    
    // Add more amenities as needed
    
    // Define pricing algorithm based on the selected amenities and layout
    double basePrice = 0.0; // Base price for the house
    
    // Adjust the price based on amenities
    if ("yes".equals(aircon)) {
        basePrice += 300.0;
    }
    if ("yes".equals(wifi)) {
        basePrice += 150.0;
    }
    if ("yes".equals(balcony)) {
        basePrice += 400.0;
    }
    if ("yes".equals(mk)) {
        basePrice += 300.0;
    }
    if ("yes".equals(fur)) {
        basePrice += 200.0;
    }
    if ("yes".equals(park)) {
        basePrice += 150.0;
    }
    if ("yes".equals(sec)) {
        basePrice += 150.0;
    }
    if ("yes".equals(lift)) {
        basePrice += 450.0;
    }
    if ("Penthouse".equals(layout)) {
        basePrice += 25000.0;
    }
    if ("1 BHK".equals(layout)) {
        basePrice += 10000.0;
    }
    if ("2 BHK".equals(layout)) {
        basePrice += 15000.0;
    }
    if ("3 BHK".equals(layout)) {
        basePrice += 20000.0;
    }
    if ("Mall".equals(vicinity)) {
        basePrice += 450.0;
    }
    if ("School".equals(vicinity)) {
        basePrice += 550.0;
    }
    if ("Hospital".equals(vicinity)) {
        basePrice += 650.0;
    }
    if ("Air Port".equals(vicinity)) {
        basePrice += 750.0;
    }
    if ("Railway Station".equals(vicinity)) {
        basePrice += 750.0;
    }
    if ("Restaurant".equals(vicinity)) {
        basePrice += 450.0;
    }
    if ("School".equals(vicinity)) {
        basePrice += 550.0;
    }
    if ("400 - 600".equals(area)) {
        basePrice += 400.0;
    }
    if ("600 - 800".equals(area)) {
        basePrice += 600.0;
    }
    if ("800 - 1000".equals(area)) {
        basePrice += 800.0;
    }
    if ("> 1000".equals(area)) {
        basePrice += 1000.0;
    }
    if ("granite".equals(flooring)) {
        basePrice += 500.0;
    }
    if ("marble".equals(flooring)) {
        basePrice += 300.0;
    }
    if ("Swimming Pool".equals(clubHouse)) {
        basePrice += 550.0;
    }
    if ("Gym".equals(clubHouse)) {
        basePrice += 650.0;
    }
    if ("Badminton".equals(clubHouse)) {
        basePrice += 350.0;
    }*/
    // Display the calculated price in jLabel_price
    jLabel_price.setText(String.format("%.2f", price));
    }//GEN-LAST:event_jButton_calculateActionPerformed

    private void jButton_bookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_bookingActionPerformed
        // give option pane for confirmation of booking
        // For demonstration purposes, let's assume the price is calculated and stored in a variable named 'calculatedPrice'
    double calculatedPrice = calculate_price(); // Replace this with your actual calculation logic

    // Update the jLabel_price to display the calculated price
    jLabel_price.setText(String.valueOf(calculatedPrice));

    // Check if the price has been calculated
    if (calculatedPrice > 0) {
        // Show confirmation dialog
        int option = JOptionPane.showConfirmDialog(this, "Do you want to confirm the booking?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // User confirmed booking
            // Display a confirmation panel
            JOptionPane.showMessageDialog(this, "Booking confirmed!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // User canceled booking
            // Add code here to handle the cancellation
        }
    } else {
        // Handle the case where the price could not be calculated
        JOptionPane.showMessageDialog(this, "Failed to calculate the price. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton_bookingActionPerformed

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
            java.util.logging.Logger.getLogger(Form_AmenitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_AmenitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_AmenitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_AmenitiesList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_AmenitiesList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_booking;
    private javax.swing.JButton jButton_calculate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_imagePath;
    private javax.swing.JLabel jLabel_price;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Houses;
    // End of variables declaration//GEN-END:variables
}
