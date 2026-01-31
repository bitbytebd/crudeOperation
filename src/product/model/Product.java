/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.model;

/**
 *
 * @author Tultuli
 */
public class Product {
    private int pid;
    private String pname;
    private int qty;
    private double price;
    

    public Product(int pid, String pname, int qty, double price) {
        this.pid = pid;
        this.pname = pname;
        this.qty = qty;
        this.price = price;
    }

    public Product() {
    }
    
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void getPid(Integer valueOf) {
  
    }

    
    
}
