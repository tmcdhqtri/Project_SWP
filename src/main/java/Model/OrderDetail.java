package Model;

public class OrderDetail {
    private int orderID;
    private int foodID;
    private int quantity;

    public OrderDetail(int orderID, int foodID, int quantity) {
        this.orderID = orderID;
        this.foodID = foodID;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
