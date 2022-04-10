
package modelclasses;


public class Customer {
    
    private String cid;
    private String cname;
    private String cpassword;

    public Customer(String cid, String cname,  String cpassword) {
        this.cid = cid;
        this.cname = cname;
        this.cpassword = cpassword;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    
    
    
    public String toString(){
        return cid+","+cname+","+this.cpassword;
    }
    
}
