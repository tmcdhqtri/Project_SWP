
package DAO;

import Context.DBContext;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    //BEGIN DAO Customer   
    public List<Customer> getAllCustomer() throws Exception {
        try {
            String sql = "select * from [CustomerInfo]";
            con = new DBContext().getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();

            List<Customer> listCustomers = new ArrayList<Customer>();
            while (rs.next()) {
                listCustomers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
            return listCustomers;
        } catch (SQLException e) {
            System.out.println("SQL error in DAO " + e.getMessage());
        }
        return null;
    }
    public void updateCustomer(int customerID, String customerName, String customerPhone, String customerEmail, String customerAddress, String customerDateOfBirth){
        String query = "update CustomerInfor set cusName= ?,cusPhone= ?, Email=?, CusAddress=?, DateOfBirth=? where customerID= ?";
        try {
            con = new DBContext().getConnection();
            stm = con.prepareStatement(query);
            stm.setString(1, customerName);
            stm.setString(2, customerPhone);
            stm.setString(3, customerEmail);
            stm.setString(4, customerAddress);
            stm.setString(5, customerDateOfBirth);
            stm.setInt(7, customerID);
            stm.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("SQL error in updateCustomerAcc " + e.getMessage());
        }
    }
    //END DAO Customer
    
    //BEGIN DAO Food 
    //END DAO Food
    
    //BEGIN DAO Order
    //END DAO Order
    
    //BEGIN DAO OrderDetail
    //END DAO OrderDetail
    
    //BEGIN DAO User
    //END DAO User
    
}
