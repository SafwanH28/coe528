package lab1;

/**
 *
 * @author Haque
 */
public abstract class Passenger {

    public String name;
    public int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract double applyDiscount(double p);
}
