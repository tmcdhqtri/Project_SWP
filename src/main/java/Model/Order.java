/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Order {
    private int CusID;
    private int ID;
    private int orderID;
    private String orderDate;
    private float total;
    private boolean payment; // 0: Cash;    1: VNPAY
    private int orderStatus; //0 đang giao; 1: đã giao; 2: hủy
    private boolean isActive; //True === 1 === Active; False === 0 === inActive



    public Order(int CusID, int ID, int orderID, String orderDate, float total, boolean payment, int orderStatus, boolean isActive) {
        this.CusID = CusID;
        this.ID = ID;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.total = total;
        this.payment = payment;
        this.orderStatus = orderStatus;
        this.isActive = isActive;
    }
    
    public Order(){}
    
    public int getCusID() {
        return CusID;
    }

    public void setCusID(int CusID) {
        this.CusID = CusID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }
}
