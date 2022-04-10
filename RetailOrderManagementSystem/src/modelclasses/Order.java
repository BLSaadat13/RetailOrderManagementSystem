
package modelclasses;

import java.util.ArrayList;


public class Order {
    
    String oid;
    String cid;
    ArrayList<OrderItem> orderItems;
   

    public Order(String oid, String cid) {
        this.oid = oid;
        this.cid = cid;
        
        orderItems = new ArrayList<OrderItem>();
    }

    public String getOid() {
        return oid;
    }

    public String getCid() {
        return cid;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    
    

  
    
    
    
}
