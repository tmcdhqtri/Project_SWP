package DAO;

import Context.DBContext;
import Model.Customer;
import Model.Food;
import Model.Order;
import Model.OrderDetail;
import Model.Personnel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    //BEGIN DAO Customer  
    public boolean registeredCustomer(String customerName, String customerPhone, String customerEmail, String customerAddress, String customerBirthday, String customerUsername, String customerPassword, boolean cusStatus) {
        try {
            String sql = "insert into CustomerInfo values(?, ?, ?, ?, ?, ?, ?, 1)";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, customerName);
            stm.setString(2, customerPhone);
            stm.setString(3, customerEmail);
            stm.setString(4, customerAddress);
            stm.setString(5, customerBirthday);
            stm.setString(6, customerUsername);
            stm.setString(7, customerPassword);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return false;
    }

    public void deleteCustomer(int customerID) {
        try {
            String query = "update CustomerInfo set cusStatus=0 where cusID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, customerID);
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
    }

    public Customer getCustomer(int customerID) {
        try {
            String query = "select * from CustomerInfo where cusID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, customerID);
            rs = stm.executeQuery();
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }
    public Customer loginCustomer(String username, String password) {
        try {
            String query = "select * from CustomerInfo where cusUsername = ? and cusPassword = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }
    public List<Customer> getAllCustomers() {
        try {
            String query = "select * from CustomerInfo";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            List<Customer> listCustomers = new ArrayList<Customer>();
            while (rs.next()) {
                listCustomers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9)));
            }
            return listCustomers;
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }

    public void updateCustomer(int customerID, String customerName, String customerPhone, String customerEmail, String customerAddress, String customerDateOfBirth) {
        try {
            String query = "update CustomerInfo set cusName= ?,cusPhone= ?, cusEmail=?, cusAddress=?, cusDateOfBirth=? where cusID= ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, customerName);
            stm.setString(2, customerPhone);
            stm.setString(3, customerEmail);
            stm.setString(4, customerAddress);
            stm.setString(5, customerDateOfBirth);
            stm.setInt(6, customerID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
        }
    }

    public void updatePasswordCustomer(String username, String password) {
        String query = "update CustomerInfo set password = ? where username =?";
        try {
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, password);
            stm.setString(2, username);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
        }
    }
    //END DAO Customer

    //BEGIN DAO Food 
    public boolean addFood(String foodName, String foodDescription, String foodImage, float foodPrice) {
        try {
            String sql = "insert into Food values(?, ?, ?, ?, 1)";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, foodName);
            stm.setString(2, foodDescription);
            stm.setString(3, foodImage);
            stm.setFloat(4, foodPrice);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return false;
    }

    public void deleteFood(int foodID) {
        try {
            String query = "update Food set foodIsActive=0 where foodID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, foodID);
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
    }

    public Food getFood(int foodID) {
        try {
            String query = "select * from Food where foodID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, foodID);
            rs = stm.executeQuery();
            return new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getBoolean(6));
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }

    public List<Food> getAllFoods() {
        try {
            String query = "select * from Food";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            List<Food> listFoods = new ArrayList<>();
            while (rs.next()) {
                listFoods.add((Food) new Food(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getBoolean(6)));
            }
            return listFoods;
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }

    public void updateFood(int foodID, String foodName, String foodDescription, String foodImage, float foodPrice) {
        try {
            String query = "update Food set foodName= ?,description= ?, image=?, price=? where foodID= ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, foodName);
            stm.setString(2, foodDescription);
            stm.setString(3, foodImage);
            stm.setFloat(4, foodPrice);
            stm.setInt(5, foodID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
        }
    }

    //END DAO Food
    //BEGIN DAO Order
    
    public boolean addOrder(int CusID, int ID, int orderID, LocalDate orderDate, float total, int status, boolean isActive) {
        try {
            String sql = "insert into Order values(?, ?, ?, ?, 1)";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, CusID);
            stm.setInt(2, ID);
            stm.setFloat(3, total);
            stm.setInt(4, status);
            int row = stm.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Order> getAllOrders() {
        try {
            String query = "select * from Order";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            ArrayList<Order> listOrders = new ArrayList<Order>();
            while (rs.next()) {
                listOrders.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getFloat(5), rs.getInt(6), rs.getBoolean(7)));
            }
            return listOrders;
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }
    public Order getOrder(int orderID) {
        try {
            String query = "select * from Order where orderID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, orderID);
            rs = stm.executeQuery();
            return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getFloat(5),rs.getInt(6),rs.getBoolean(7));
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }
    public void deleteOrder(int orderID) {
        try {
            String query = "update Order set orderIsActive=0 where orderID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, orderID);
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
    }

    public void updateOrderStatus(int orderID) {
        try {
            String query = "update Order set orderStatus=1 where orderID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, orderID);
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
    }

    //END DAO Order
    //BEGIN DAO OrderDetail
    public List<OrderDetail> getAllOrderDetails() {
        try {
            String query = "select * from OrderDetail";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            List<OrderDetail> listOrderDetails = new ArrayList<OrderDetail>();
            while (rs.next()) {
                listOrderDetails.add(new OrderDetail(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
            return listOrderDetails;
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }

    //END DAO OrderDetail
    //BEGIN DAO Personnel
    public Personnel getPersonnel(int personnelID) {
        try {
            String query = "select * from Personnel where perID=?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, personnelID);
            rs = stm.executeQuery();

            return new Personnel(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));
        } catch (Exception e) {
            System.out.println("SQL er  ror in DAO " + e.getMessage());
        }
        return null;
    }
    
    public boolean addPersonnel(String name, String role, String phone, String email, String address, String dateOfBirth,
                            String username, String password, String image, String perStatus)
    {
        try {
                String sql = "insert into Personnel values(?,?,?,?,?,?,?,?,?,1)";
                con = new DBContext().getConnection();
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, role);
                stm.setString(3, phone);
                stm.setString(4, email);
                stm.setString(5, address);
                stm.setString(6, dateOfBirth);
                stm.setString(7, username);
                stm.setString(8, password);
                stm.setString(9, image);
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("SQL error in DAO " + e.getMessage());
            } catch (Exception e) {
                System.out.println("SQL error in DAO " + e.getMessage());
            }
            return false;
    }
    
    public void updatePasswordPersonnel(String username, String password) {
        String query = "update Personnel set password = ? where username =?";
        try {
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, password);
            stm.setString(2, username);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
        }
    }
    
    public void deletePersonnel(int personnelID) {
        try {
            String query = "update Personnel set perStatus=0 where perID = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setInt(1, personnelID);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
    }

    public List<Personnel> getAllPersonnel() {
        try {
            String query = "select * from Personnel";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            rs = stm.executeQuery();

            List<Personnel> listPersonnels = new ArrayList<Personnel>();
            while (rs.next()) {
                listPersonnels.add(new Personnel(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11)));
            }
            return listPersonnels;
        } catch (Exception e) {
            System.out.println("SQL er  ror in DAO " + e.getMessage());
        }
        return null;
    }

    public void updatePersonnnel(int personnelID, String personnelName,
            String personnelPhone, String personnelEmail,
            String personnelAddress, String personnelDateOfBirth,
            String personnelImageUrl) {
        if (!personnelImageUrl.equals(""))
        {
            try {
            String query = "update Personnel set name= ?, phone=?, email=?, address =?, dateOfBirth=?, image =? where perID= ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, personnelName);
            stm.setString(2, personnelPhone);
            stm.setString(3, personnelEmail);
            stm.setString(4, personnelAddress);
            stm.setString(5, personnelDateOfBirth);
            stm.setString(6, personnelImageUrl);
            stm.setInt(7, personnelID);
            stm.executeUpdate();
            } catch (Exception e) {
                System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
            }
        }
        else   
        {
            try {
            String query = "update Personnel set name= ?, phone=?, email=?, address =?, dateOfBirth=? where perID= ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, personnelName);
            stm.setString(2, personnelPhone);
            stm.setString(3, personnelEmail);
            stm.setString(4, personnelAddress);
            stm.setString(5, personnelDateOfBirth);
            stm.setInt(6, personnelID);
            stm.executeUpdate();
            } catch (Exception e) {
                System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
            }
        }
        
    }
    public Personnel loginPersonnel(String username, String password){
        try {
           String query = "select * from Personnel where username=? and password = ?";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            return new Personnel(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getBoolean(11));
        } catch (Exception e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }


}
