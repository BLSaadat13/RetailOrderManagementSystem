package ui;


import controller.Manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelclasses.Customer;
import modelclasses.Order;
import modelclasses.OrderItem;
import modelclasses.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AA
 */
public class Admin extends javax.swing.JFrame {
    
     Manager manager;
     
     
      ArrayList<modelclasses.Customer> customers;
        ArrayList<modelclasses.Order> orders ;
        ArrayList<modelclasses.Product> products;
    
    
    
    private void updateTables(){
                customers = manager.getCustomers();
        orders = manager.getOrders();
         products = manager.getProducts();
        
      //  String customer_cols[] = {""};

        DefaultTableModel customerTM = new DefaultTableModel(new Object[]
        {
            "Customer ID", "Customer Name"
        }, 0);
        
        
         DefaultTableModel productTM = new DefaultTableModel(new Object[]
        {
            "Product ID", "Product Name", "Price", "Quantity"
        }, 0);
         
         
         
        
        for(modelclasses.Customer customer : customers){
            customerTM.addRow(new Object[]{customer.getCid(), customer.getCname()});
        }
        
        customerTable.setModel(customerTM);
        
        
        for(modelclasses.Product product : products){
            if(product.getQuantity()>0)
            productTM.addRow(new Object[]{product.getPid(), product.getPname(), product.getPrice(), product.getQuantity()});
        }
        
        productsTable.setModel(productTM);
        
         DefaultTableModel orderTM = new DefaultTableModel(new Object[]
        {
            "Order ID", "Customer ID", "Items","Cost"
        }, 0);
        
        for(Order o : orders){
            
            String items = "";
            
            double price = 0;
            
            
            
            
            for(OrderItem oi : o.getOrderItems()){
                items+=""+getProductName(oi.getPid())+" | ";
                price+= getProductPrice(oi.getPid())*oi.getQuantity();
            }
            
            orderTM.addRow(new Object[]{o.getOid(), o.getCid(),items, price});
            
        }
        
        orderTable.setModel(orderTM);
    }
    
    
    public String getProductName(String pid){
        
        for(Product p : products){
            if(p.getPid().equals(pid)){
                return p.getPname();
            }
        }
        
        return null;
    }
    
    
    public double getProductPrice(String pid){
        
        for(Product p : products){
            if(p.getPid().equals(pid)){
                return p.getPrice();
            }
        }
        
        return 0;
    }
    
    
    
        private void updateFiles() throws IOException{
               customers = manager.getCustomers();
        orders = manager.getOrders();
         products = manager.getProducts();
        
      //  String customer_cols[] = {""};
      
      
      FileWriter fw = new FileWriter(new File("customers.txt"));
       
        
        
       
        
        for(modelclasses.Customer customer : customers){
           fw.write(customer.toString()+"\r\n");
        }
        
        fw.close();
        
        
          fw = new FileWriter(new File("products.txt"));
       
        
        
       
    
        
        
        
        
        for(modelclasses.Product product : products){
            
            if(product.getQuantity()>0)
              fw.write(product.toString()+"\r\n");
        }
        
         fw.close();
         
         
            fw = new FileWriter(new File("orders.txt"));
       
        
        
       
    
        
        
        
        
        for(modelclasses.Order order : orders){
            
            fw.write(order.getOid()+","+order.getCid()+",");
            for(int i=0; i<order.getOrderItems().size(); i++){
                if(i==order.getOrderItems().size()-1){
                    fw.write(""+order.getOrderItems().get(i).getPid()+","+""+order.getOrderItems().get(i).getQuantity());
                }
                else{
                     fw.write(""+order.getOrderItems().get(i).getPid()+","+""+order.getOrderItems().get(i).getQuantity()+",");
                }
            }
            
            fw.write("\r\n");
        }
        
         fw.close();
        
       
    }

    /**
     * Creates new form Login
     */
    public Admin(Manager m) throws FileNotFoundException, IOException {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        if(m==null){
             manager = new Manager();
        }
        else{
           manager = m;
        }
       
        updateTables();
        updateFiles();
        

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
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        searchText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        search2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        orderSearch = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(144, 60, 123));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        searchText.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(144, 60, 123));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(customerTable);

        jButton2.setBackground(new java.awt.Color(144, 60, 123));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(144, 60, 123));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(144, 60, 123));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Customer", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        search2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search2KeyTyped(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(144, 60, 123));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product  Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(productsTable);

        jButton7.setBackground(new java.awt.Color(144, 60, 123));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(144, 60, 123));
        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Delete");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(144, 60, 123));
        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton10))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Products", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        orderSearch.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        orderSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                orderSearchKeyTyped(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(144, 60, 123));
        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Search");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Items", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderTable);

        jButton12.setBackground(new java.awt.Color(144, 60, 123));
        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Edit");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(144, 60, 123));
        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Delete");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(144, 60, 123));
        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Add");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(orderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton15))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Orders", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        

        String search = searchText.getText();
        
        
        if(search.equals("")){
            JOptionPane.showMessageDialog(null, "Type name to search");
            updateTables();
        }
        else{
            
            
             DefaultTableModel customerTM = new DefaultTableModel(new Object[]
        {
            "Customer ID", "Customer Name"
        }, 0);
             
             
               for(modelclasses.Customer customer : customers){
                   
                   
                   if(customer.getCname().toLowerCase().contains(search.toLowerCase()))
            customerTM.addRow(new Object[]{customer.getCid(), customer.getCname()});
        }
        
        customerTable.setModel(customerTM);
             
             
             
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
           int row = customerTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String customerID;
            String customerName;
           
                customerID = (String) customerTable.getValueAt(row, 0);
              customerName = (String) customerTable.getValueAt(row, 1);
              
              Customer temp = null;
              
              for(Customer c : customers){
                  if(c.getCid().equals(customerID)){
                      temp = c;
                      break;
                  }
              }

              this.setVisible(false);
              new EditCustomer(manager, temp).setVisible(true);
            
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
           int row = customerTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String customerID;
            String customerName;
           
                customerID = (String) customerTable.getValueAt(row, 0);
              customerName = (String) customerTable.getValueAt(row, 1);
              
              Customer temp = null;
              
              for(Customer c : customers){
                  if(c.getCid().equals(customerID)){
                      temp = c;
                      break;
                  }
              }

             
              manager.getCustomers().remove(temp);
              
              updateTables();
               try {
                   updateFiles();
               } catch (IOException ex) {
                   Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
               }
            
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        
        new AddCustomer(manager).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        
        
        String search = search2.getText();
        
        
        if(search.equals("")){
            JOptionPane.showMessageDialog(null, "Type name to search");
            updateTables();
        }
        else{
            
            
             DefaultTableModel productTM = new DefaultTableModel(new Object[]
        {
            "Product ID", "Product Name", "Price", "Quantity"
        }, 0);
             
             
               for(modelclasses.Product product : products){
                   
                   
                   if(product.getPname().toLowerCase().contains(search.toLowerCase()))
          productTM.addRow(new Object[]{product.getPid(), product.getPname(), product.getPrice(), product.getQuantity()});
        }
        
        productsTable.setModel(productTM);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        
        // TODO add your handling code here:
           int row = productsTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String productID;
            String productName;
            double price;
            int quantity;
           
                productID = (String) productsTable.getValueAt(row, 0);
              productName = (String) productsTable.getValueAt(row, 1);
              price =(Double) productsTable.getValueAt(row, 2);
              quantity = (int) productsTable.getValueAt(row, 3);
              
              Product temp = null;
              
              for(Product c : products){
                  if(c.getPid().equals(productID)){
                      temp = c;
                      break;
                  }
              }

              this.setVisible(false);
              new EditProduct(manager, temp).setVisible(true);
            
            }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
          // TODO add your handling code here:
        
        // TODO add your handling code here:
           int row = productsTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String productID;
            
           
                productID = (String) productsTable.getValueAt(row, 0);
             
              
              Product temp = null;
              
              for(Product c : products){
                  if(c.getPid().equals(productID)){
                      temp = c;
                      break;
                  }
              }

             
              manager.getProducts().remove(temp);
              
              updateTables();
               try {
                   updateFiles();
               } catch (IOException ex) {
                   Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
               }
            
            }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
          // TODO add your handling code here:
        
        this.setVisible(false);
        
        new AddProduct(manager).setVisible(true);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        
        
        // TODO add your handling code here:
        
        
        String search = orderSearch.getText();
        
        
         DefaultTableModel orderTM = new DefaultTableModel(new Object[]
        {
            "Order ID", "Customer ID", "Items","Cost"
        }, 0);
         
        if(search.equals("")){
            JOptionPane.showMessageDialog(null, "Type name to search");
            updateTables();
        }
        else{
            
            
           
        
        for(Order o : orders){
            
            String items = "";
            
            double price = 0;
            
            
            
             if(o.getCid().toLowerCase().contains(search.toLowerCase())){
           
            
            
            
            for(OrderItem oi : o.getOrderItems()){
                items+=""+getProductName(oi.getPid())+" | ";
                price+= getProductPrice(oi.getPid())*oi.getQuantity();
            }
            
            orderTM.addRow(new Object[]{o.getOid(), o.getCid(),items, price});
            
             }
             
             } 
        
        
        orderTable.setModel(orderTM);
        
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
             // TODO add your handling code here:
        
        // TODO add your handling code here:
           int row = orderTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String orderID;
           
           
                orderID = (String) orderTable.getValueAt(row, 0);
           
              
              Order temp = null;
              
              for(Order c : orders){
                  if(c.getOid().equals(orderID)){
                      temp = c;
                      break;
                  }
              }

              this.setVisible(false);
              new EditOrder(manager, temp).setVisible(true);
            
            }
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
        
          // TODO add your handling code here:
        
        // TODO add your handling code here:
           int row = orderTable.getSelectedRow();
           
            if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row first");
        }
        else{
            String orderID;
            
           
                orderID = (String) orderTable.getValueAt(row, 0);
             
              
              Order temp = null;
              
              for(Order c : orders){
                  if(c.getOid().equals(orderID)){
                      temp = c;
                      break;
                  }
              }

             
              manager.getOrders().remove(temp);
              
              updateTables();
               try {
                   updateFiles();
               } catch (IOException ex) {
                   Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
               }
            
            }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        
        
        this.setVisible(false);
        
        new AddOrder(manager).setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void searchTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyTyped
        // TODO add your handling code here:
        
         if(searchText.getText().equals("")){
           
            updateTables();
        }
    }//GEN-LAST:event_searchTextKeyTyped

    private void search2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyTyped
        // TODO add your handling code here:
        
        if(search2.getText().equals("")){
           
            updateTables();
        }
    }//GEN-LAST:event_search2KeyTyped

    private void orderSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderSearchKeyTyped
        // TODO add your handling code here:
        
        
         if(orderSearch.getText().equals("")){
           
            updateTables();
        }
    }//GEN-LAST:event_orderSearchKeyTyped

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customerTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField orderSearch;
    private javax.swing.JTable orderTable;
    private javax.swing.JTable productsTable;
    private javax.swing.JTextField search2;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
