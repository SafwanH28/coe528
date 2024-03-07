/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.util.ArrayList;
/**
 *
 * @author Haque
 */
public class FoodCatagory extends FoodComponent {
    
    private ArrayList<FoodComponent> list;

    public FoodCategory(String name) {
        super(name);
        this.list = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for (FoodComponent i : list) {
            sum = sum + i.getPrice();
        }
        return sum;
    }

    @Override
    public void print(int level) {
        for (FoodComponent i : list) {
            System.out.println("FoodCategory (" + name + ", " + i.getPrice() + ") contains:");
            for(FoodComponent j: list){
                System.out.println("2FoodCategory (" + j.getName() + ", " + j.getPrice() + ") contains:");
            }
        }
    }

    public void add(FoodComponent fc) {
        list.add(fc);
    }

    public void remove(FoodComponent fc) {
        list.remove(fc);
    }
}