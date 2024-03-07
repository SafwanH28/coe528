/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Haque
 */
public class FoodItem extends FoodComponent {

    double price;

    FoodItem(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(int level) {
        for (int i = 0; i < level; i++) //put tabs based on the level
        {
            System.out.print("\t");
        }
        System.out.println("FoodItem: " + super.getName() + ", " + this.getPrice()); //print remaining details
    }
}