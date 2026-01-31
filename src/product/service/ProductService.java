/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import product.model.Product;
import product.util.DBConnection;

/**
 *
 * @author Tultuli
 */
public class ProductService {
        Connection con;
        
 public int save(Product p) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "insert into products (pid, pname, qty, price) values (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
                          ps.setInt(1, p.getPid());
                          ps.setString(2, p.getPname());
                          ps.setInt(3, p.getQty());
                          ps.setDouble(4, p.getPrice());
        
        int status = ps.executeUpdate();
        return status;
    }
  
     public int update(Product p) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "update products set pname = ?, qty = ? , price = ? where pid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
                          ps.setString(1, p.getPname());
                          ps.setInt(2, p.getQty());
                          ps.setDouble(3, p.getPrice());
                          ps.setInt(4, p.getPid());
        
        int status = ps.executeUpdate();
        return status;
    }
       public int delete(int pid) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "delete from products where pid = ?";
        PreparedStatement ps = con.prepareStatement(sql);
                         ps.setInt(1, pid);
        int status = ps.executeUpdate();
        return status;
    }
    
    public Product getByID(int pid) throws SQLException{
        con = DBConnection.getConnection();
        String sql = "select * from products where pid = (?)";
        PreparedStatement ps = con.prepareStatement(sql);
                          ps.setInt(1, pid);
        ResultSet rs = ps.executeQuery();
        Product p = new Product();
        while(rs.next()){
            p.setPname(rs.getString("pname"));
            p.setQty(rs.getInt("qty"));
            p.setPrice(rs.getDouble("price"));
        }
        return p;
    }

    public List<Product> getAll() throws SQLException{
        con = DBConnection.getConnection();
        String sql = "select * from products";
        PreparedStatement ps = con.prepareStatement(sql);
        List products = new ArrayList();
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Product p = new Product();
                    p.setPid(rs.getInt("pid"));
                    p.setPname(rs.getString("pname"));
                    p.setQty(rs.getInt("qty"));
                    p.setPrice(rs.getDouble("price"));
            
            products.add(p);
        }
        return products;
    }

   public ResultSet getResultSet() throws SQLException{
        con = DBConnection.getConnection();
        String sql = "select * from products";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
