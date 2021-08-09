/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Account;
import Entity.BuyerAccount;
import Entity.Category;
import Entity.Feedback;
import Entity.OrderDetail;
import Entity.Product;
import context.DBContext;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class loadDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(int id) {
        String query = "select * from product where id =" + id;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String query = "select * from product where cateID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductById(String id) {
        String query = " select * from product where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getBestSellProduct() {
        String query = "select * from product where amoutBuy=(select max(amoutBuy) from product)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Product getSaleProduct() {
        String query = "select * from product where amoutBuy=(select min(amoutBuy) from product)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> searchProductByName(String name) {
        List<Product> list = new ArrayList<>();
        String query = "select p.* from product p join category c on \n"
                + "p.cateID=c.cid\n"
                + "where [name] like N'%" + name + "%'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account login(String user, String pass) {
        String query = "select * from account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, user);
            ps.setString(2, convertPassWord(pass));
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String convertPassWord(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
        }
        return "";
    }

    public Account checkExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, user);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertAccount(String username, String password, String fullName) {
        String query = "insert into account\n"
                + "values (?,?,1,0,N'" + fullName + "')";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, username);
            ps.setString(2, convertPassWord(password));
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertBuyerAccount(String fullName, String address, String email, String phone, String gender, String dob) {
        String query = "insert into BuyerAccount \n"
                + "values (N'" + fullName + "',N'" + address + "','" + email + "','" + phone + "',N'" + gender + "','" + dob + "')";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateAmountBuy(int newBuyAmount, int id) {
        String query = "update product \n"
                + "set amoutBuy=?\n"
                + "where id=?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setInt(1, newBuyAmount);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertIntoOrderDetail(String cusName, String detail, double totalPay, String status, String deleveryAddress, String payment) {
        String query = "insert into orderDetail \n"
                + "values(N'" + cusName + "',N'" + detail + "'," + totalPay + ",N'" + status + "',N'" + deleveryAddress + "',N'" + payment + "')";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public BuyerAccount getBuyerAccountByUser(String user) {
        String query = "select ba.* from buyerAccount ba join account a on ba.fullName=a.fullName\n"
                + "where [user]=?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, user);
            rs = ps.executeQuery();//chay cau lenh query, nhan ket qua tra ve
            while (rs.next()) {
                return new BuyerAccount(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateBuyerAccount(String newFullName, String address, String email, String phone, String oldFullName) {
        String query = "update buyerAccount set fullname=N'" + newFullName + "',\n"
                + "[address] =N'" + address + "',\n"
                + "email='" + email + "',phoneNumber='" + phone + "'\n"
                + "where fullName=N'" + oldFullName + "'";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public void updateFullNameForAccount(String user, String fullName) {
        String query = "update account set fullname=N'" + fullName + "'\n"
                + "where [user]='" + user + "'";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public List<OrderDetail> getAllOrderDetailByCustomerName(String customerName) {
        String query = "select od.* from orderDetail od join buyerAccount ba on od.CustomerName=ba.fullName\n"
                + "where CustomerName=N'" + customerName + "'";
        List<OrderDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void insertFeedback(int orderID, String comment, String time, String evalue) {
        String query = "insert into feedback\n"
                + "values(" + orderID + ",N'" + comment + "','" + time + "','" + evalue + "')";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public Feedback searchFeedbackByOrderID(int orderID) {
        String query = "select * from feedback where orderID=?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Feedback(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }

        } catch (Exception e) {
        }
        return null;
    }

    public void changePass(String user, String newPass) {
        String query = "update account set pass=?\n"
                + "where [user]=?";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.setString(1, convertPassWord(newPass));
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(int id, String image, double price, String title, String description) {
        String query = "update product set [image]='" + image + "',price=" + price + ",title=N'" + title + "',description=N'" + description + "'\n"
                + "where id=" + id + "";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(int id) {
        String query = "delete product where id=" + id + "";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void addNewProduct(String name, String image, double price, String title, String description, int cateID) {
        String query = "insert into product\n"
                + "values (N'" + name + "','" + image + "'," + price + ",N'" + title + "',N'" + description + "'," + cateID + ",0)";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<OrderDetail> getAllOrderDetail() {
        String query = "select * from orderDetail";
        List<OrderDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateStatusOrder(int orderID, String status) {
        String query = "update orderDetail set status=N'" + status + "'\n"
                + "where orderId=" + orderID + "";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertCategory(String cname) {
        String query = "insert into category \n"
                + "values(N'"+cname+"')";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteCategoryById(int cid) {
        String query = "delete category where cid="+cid;
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteProductByCateID(int cid){
        String query = "delete product where cateID="+cid;
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Product> getProductByPaging(int indexPage,int numPerPage) {
        String query = "SELECT * FROM product ORDER BY id   \n"
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Product> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, indexPage);
            ps.setInt(2, numPerPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Category> getCategoryByPaging(int indexPage,int numPerPage) {
        String query = "SELECT * FROM category ORDER BY cid   \n"
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        List<Category> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, indexPage);
            ps.setInt(2, numPerPage);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void updateCustomerNameInOrderDetail(String oldName,String updateName){
        String query = "update OrderDetail set CustomerName=N'"+updateName+"' where CustomerName=N'"+oldName+"'";
        try {
            conn = new DBContext().getConnection(); //mo ket noi toi sql
            ps = conn.prepareStatement(query);//nem cau lenh query sang sql
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        loadDAO ld = new loadDAO();
        List<Category> list=ld.getCategoryByPaging(0, 3);
        for (Category product : list) {
            System.out.println(product);
        }
    }
}
