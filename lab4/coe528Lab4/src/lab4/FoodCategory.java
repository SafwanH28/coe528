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
public class FoodCategory extends FoodComponent {
    
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
        for (int i = 0; i < level; i++) //put proper tabs as per the level
        {
            System.out.print("\t");
        }
        System.out.println("FoodCategory (" + this.getName() + ", " + this.getPrice() + ") contains:"); //print the details of this FoodCategory
        for (FoodComponent comp : list) { //now print details of all components in the list 
            comp.print(level + 1); //increases the level by 1
        }
    }

    public void add(FoodComponent fc) {
        list.add(fc);
    }

    public void remove(FoodComponent fc) {
        list.remove(fc);
    }
}