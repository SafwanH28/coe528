package lab1;

/**
 *
 * @author Haque
 */
public class NonMember extends Passenger {

    public NonMember(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if (age > 65) {
            p = p * 0.9;
            System.out.println("Discount Applied. New Price: " + p);
            return (p);
        } else {
            System.out.println("No Discount Applied.");
            return (p);
        }

    }
}