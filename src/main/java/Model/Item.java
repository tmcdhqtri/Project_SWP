package Model;
import Model.Food;


public class Item {
    private Food food;
    private int sl;

    public Item() {
    }

    public Item(Food food, int sl) {
        this.food = food;
        this.sl = sl;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }
    
    
    
}
