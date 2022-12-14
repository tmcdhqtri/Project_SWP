/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admin
 */
public class Food {
    private int foodID;
    private String foodName;
    private String foodDescription;
    private String foodImage;
    private float foodPrice;
    private boolean foodIsActive;
    
    public Food(int foodID, String foodName, String foodDescription, String foodImage, float foodPrice, boolean foodIsActive) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
        this.foodIsActive = foodIsActive;
    }

    public Food(String foodName, String foodDescription, String foodImage, float foodPrice, boolean foodIsActive) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
        this.foodIsActive = foodIsActive;
    }
    
    public Food(String foodName, String foodDescription, String foodImage, float foodPrice) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
    }

    public Food(int foodID, String foodName, String foodDescription, String foodImage, float foodPrice) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.foodPrice = foodPrice;
    }
    
    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public boolean isFoodIsActive() {
        return foodIsActive;
    }

    public void setFoodIsActive(boolean foodIsActive) {
        this.foodIsActive = foodIsActive;
    }
    
}
