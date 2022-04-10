
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelclasses.*;


public class Manager {
    
    
    private ArrayList<Customer> customers;
    
    private ArrayList<Order> orders;
      
    private ArrayList<Product> products;
    
    
    

    public Manager() throws FileNotFoundException {
        
        
        customers = new ArrayList<Customer>();
        orders = new ArrayList();
        products = new ArrayList();
        
        Scanner customerScanner = new Scanner(new File("customers.txt"));
        Scanner orderScanner = new Scanner(new File("orders.txt"));
        Scanner productScanner = new Scanner(new File("products.txt"));
        String line;
        while(customerScanner.hasNext()){
            line = customerScanner.nextLine();
            String[] parts = line.split(",");
            customers.add(new Customer(parts[0], parts[1],  parts[2]));
        }
        
//        while(orderScanner.hasNext()){
//            line = customerScanner.nextLine();
//            String[] parts = line.split(",");
//            customers.add(new Order(parts[0], parts[1]));
//        }
        
        
        while(productScanner.hasNext()){
            line = productScanner.nextLine();
            String[] parts = line.split(",");
            products.add(new Product(parts[0], parts[1],Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
        }
        
        while(orderScanner.hasNext()){
            line = orderScanner.nextLine();
            String[] parts = line.split(",");
            String orderID = parts[0];
            String customerID = parts[1];
            Order newOrder = new Order(orderID, customerID);
            
            for(int i=2; i<parts.length; i+=2){
                String pid = parts[i];
                int q = Integer.parseInt(parts[i+1]);
                
                newOrder.getOrderItems().add(new OrderItem(pid, q));
            }
            
            orders.add(newOrder);
        
        }
        
        
        
        
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    
    
    public void addCustomer(Customer c){
        customers.add(c);
    }
    
    public void addProduct(Product p){
        products.add(p);
    }
    
    public void addOrder(Order o){
        orders.add(o);
    }
    
    
    
    
    
    
    
      
    
}
