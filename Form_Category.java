/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package my_project;

import Classes.DB;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARORA
 */
public class Form_Category extends javax.swing.JFrame {

   
    /**
     * Creates new form Form_Category
     */
    
    Classes.Category category = new Classes.Category();
    int index = 0;
     ArrayList<Classes.Category> categorys_list = category.categorysList();
    
    public Form_Category() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        //populate jTable
        populateJtableWithCategorys();
    }
    
    
    public void displayImage(int width,int height,String image_path, JLabel label)
    { 
        ImageIcon imageIco = new ImageIcon(image_path);
        Image image = imageIco.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    public void displayByteImage(int width,int height,byte[] image_byte, JLabel label)
    { 
        ImageIcon imageIco = new ImageIcon(image_byte);
        Image image = imageIco.getImage().getScaledInstance(width,height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }
    
    public String selectImage()
    { 
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Picture");
        
        fileChooser.setCurrentDirectory(new File("C:\\images"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("image", ".png", ".jpg");
        fileChooser.addChoosableFileFilter(filter);
        
        int state = fileChooser.showSaveDialog(null);
        String path = "";
        if(state == JFileChooser.APPROVE_OPTION)
        { 
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return path;
    }
    
    
    //create a function to populate the jTable with category(id & name)
    public void populateJtableWithCategorys()
    {
        //clear arraylist
        categorys_list.clear();
        //populate arraylist
        categorys_list = category.categorysList();
        
        //jtable columns
        String[] columnsName = {"ID","Name"};
        
        //jtable rows
        Object[][] rows = new Object[categorys_list.size()][columnsName.length];
        
        for(int i=0;i<categorys_list.size();i++)
        {
            rows[i][0] = categorys_list.get(i).getId();
            rows[i][1] = categorys_list.get(i).getName();
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columnsName);
        jTable_Category.setModel(model);
        
    }
    
    //create a function to display category
    public void displayCategory()
    {
        Classes.Category selected_category = categorys_list.get(index);
        jSpinner_id.setValue(selected_category.getId());
        jTextField_name.setText(selected_category.getName());
        displayByteImage(jLabel_pic.getWidth(),jLabel_pic.getHeight(),selected_category.getPic(),jLabel_pic);
    }
    
    
    public boolean verify(String add_or_edit)
    { 
        String address = jTextField_name.getText();
        String pic_path = jLabel_imagePath.getText();
        boolean val = false;
        if(address.trim().equals(""))
        { 
            if("add".equals(add_or_edit))
            { 
                if(pic_path.trim().equals(""))
                { 
                    JOptionPane.showMessageDialog(null,"Enter valid category","Invalid Info",2);
                    val =  false;
                }
                else
                { 
                    val = true;
                }
        
            }
            
            if("edit".equals(add_or_edit))
            { 
                if(jLabel_pic.getIcon() == null)
                { 
                    JOptionPane.showMessageDialog(null,"Enter valid category","Invalid Info",2);
                    val=false;
                }
                else
                { 
                    val = true;
                }
            }
            
        }
        
        return val;
        
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
        jTable_Category = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSpinner_id = new javax.swing.JSpinner();
        jTextField_name = new javax.swing.JTextField();
        jButton_Add = new javax.swing.JButton();
        jButton_Edit = new javax.swing.JButton();
        jButton_Remove = new javax.swing.JButton();
        jButton_First = new javax.swing.JButton();
        jButton_Next = new javax.swing.JButton();
        jButton_Previous = new javax.swing.JButton();
        jButton_Last = new javax.swing.JButton();
        jLabel_pic = new javax.swing.JLabel();
        jButton_browse = new javax.swing.JButton();
        jLabel_imagePath = new javax.swing.JLabel();
        jButton_Refresh = new javax.swing.JButton();
        jButton_Clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

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
        jLabel4.setText("Category Of House");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(281, 281, 281)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_close)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(14, 14, 14))
        );

        jTable_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Category.setRowHeight(40);
        jTable_Category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Category);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Category ID:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Layout:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Pic:");

        jSpinner_id.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField_name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jButton_Add.setBackground(new java.awt.Color(102, 255, 102));
        jButton_Add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Add.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Add.setText("Add");
        jButton_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddActionPerformed(evt);
            }
        });

        jButton_Edit.setBackground(new java.awt.Color(29, 209, 161));
        jButton_Edit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Edit.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Edit.setText("Edit");
        jButton_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditActionPerformed(evt);
            }
        });

        jButton_Remove.setBackground(new java.awt.Color(255, 51, 51));
        jButton_Remove.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Remove.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Remove.setText("Remove");
        jButton_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveActionPerformed(evt);
            }
        });

        jButton_First.setBackground(new java.awt.Color(37, 47, 62));
        jButton_First.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_First.setForeground(new java.awt.Color(255, 255, 255));
        jButton_First.setText("<<");
        jButton_First.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FirstActionPerformed(evt);
            }
        });

        jButton_Next.setBackground(new java.awt.Color(37, 47, 62));
        jButton_Next.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Next.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Next.setText(">");
        jButton_Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_NextActionPerformed(evt);
            }
        });

        jButton_Previous.setBackground(new java.awt.Color(37, 47, 62));
        jButton_Previous.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Previous.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Previous.setText("<");
        jButton_Previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PreviousActionPerformed(evt);
            }
        });

        jButton_Last.setBackground(new java.awt.Color(37, 47, 62));
        jButton_Last.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Last.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Last.setText(">>");
        jButton_Last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LastActionPerformed(evt);
            }
        });

        jLabel_pic.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_pic.setOpaque(true);

        jButton_browse.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_browse.setText("Browse");
        jButton_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_browseActionPerformed(evt);
            }
        });

        jLabel_imagePath.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_imagePath.setText("     ");

        jButton_Refresh.setBackground(new java.awt.Color(255, 153, 51));
        jButton_Refresh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Refresh.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Refresh.setText("Refresh");
        jButton_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RefreshActionPerformed(evt);
            }
        });

        jButton_Clear.setBackground(new java.awt.Color(255, 255, 51));
        jButton_Clear.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton_Clear.setForeground(new java.awt.Color(51, 51, 51));
        jButton_Clear.setText("Clear");
        jButton_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jButton_Remove))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(jSpinner_id, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(58, 58, 58)
                                .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_First, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jSpinner_id))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_imagePath)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jButton_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_First, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Next, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Previous, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Last, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddActionPerformed
        //add a new brand
        try {
        String name = jTextField_name.getText();
        byte[] pic = Files.readAllBytes(Paths.get(jLabel_imagePath.getText()));
        
        
            Classes.Category category = new Classes.Category();
            category.addCategory(name, pic);
        

        
        
    } catch(IOException ex) {
        
        JOptionPane.showMessageDialog(null,"Select the category pic [" +  ex + "]","Category pic", 2);
        //java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton_AddActionPerformed

    private void jButton_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditActionPerformed
        // edit a brand
        try {
            int id = (int) jSpinner_id.getValue();
        String name = jTextField_name.getText();
        byte[] pic;

        if(jLabel_imagePath.getText().trim().equals(""))
        {
            pic = category.getCategoryById(id).getPic();
        }
        else
        {
            pic = Files.readAllBytes(Paths.get(jLabel_imagePath.getText()));
        }
        
            Classes.Category category = new Classes.Category();
            category.editCategory(id, name, pic);
          
    } catch(Exception ex) {
       
        JOptionPane.showMessageDialog(null,"Select the category pic [" +  ex + "]","Category pic", 2);
        //java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton_EditActionPerformed

    private void jButton_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveActionPerformed
        // remove a brand
        
        int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this category?","Confirm",JOptionPane.YES_NO_OPTION);
        int id = (int) jSpinner_id.getValue();
        if(confirm == JOptionPane.YES_OPTION)
        { 
           
            category.removeCategory(id);
        }

        
        
    }//GEN-LAST:event_jButton_RemoveActionPerformed

    private void jButton_FirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FirstActionPerformed
        index = 0;
        displayCategory();
    }//GEN-LAST:event_jButton_FirstActionPerformed

    private void jButton_NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_NextActionPerformed
        index++;
        if(index > categorys_list.size()-1)
        {
            index = categorys_list.size()-1;
        }
        displayCategory();
    }//GEN-LAST:event_jButton_NextActionPerformed

    private void jButton_PreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PreviousActionPerformed
        index--;
        if(index < 0)
        {
            index = 0;
        }
        displayCategory();
    }//GEN-LAST:event_jButton_PreviousActionPerformed

    private void jButton_LastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LastActionPerformed
        index = categorys_list.size()-1;
        displayCategory();
    }//GEN-LAST:event_jButton_LastActionPerformed

    
    
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

    private void jButton_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_browseActionPerformed
        // TODO add your handling code here:
        String imagePath = selectImage();
        displayImage(jLabel_pic.getWidth(), jLabel_pic.getHeight(), imagePath, jLabel_pic);
        
        jLabel_imagePath.setText(imagePath);
    }//GEN-LAST:event_jButton_browseActionPerformed

    private void jTable_CategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CategoryMouseClicked
        //get the selected category
        int index = jTable_Category.getSelectedRow();
        int id = Integer.valueOf(jTable_Category.getValueAt(index, 0).toString());
        Classes.Category cat = category.getCategoryById(id);
        jSpinner_id.setValue(cat.getId());
        jTextField_name.setText(cat.getName());
        displayByteImage(jLabel_pic.getWidth(),jLabel_pic.getHeight(),cat.getPic(),jLabel_pic);
    }//GEN-LAST:event_jTable_CategoryMouseClicked

    private void jButton_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RefreshActionPerformed
        //refresh the jtable
        populateJtableWithCategorys();
    }//GEN-LAST:event_jButton_RefreshActionPerformed

    private void jButton_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearActionPerformed
        //clear jtable
        jSpinner_id.setValue(0);
        jTextField_name.setText("");
        jLabel_pic.setIcon(null);
        jLabel_imagePath.setText("");
    }//GEN-LAST:event_jButton_ClearActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

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
            java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add;
    private javax.swing.JButton jButton_Clear;
    private javax.swing.JButton jButton_Edit;
    private javax.swing.JButton jButton_First;
    private javax.swing.JButton jButton_Last;
    private javax.swing.JButton jButton_Next;
    private javax.swing.JButton jButton_Previous;
    private javax.swing.JButton jButton_Refresh;
    private javax.swing.JButton jButton_Remove;
    private javax.swing.JButton jButton_browse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_imagePath;
    private javax.swing.JLabel jLabel_pic;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_id;
    private javax.swing.JTable jTable_Category;
    private javax.swing.JTextField jTextField_name;
    // End of variables declaration//GEN-END:variables
}
