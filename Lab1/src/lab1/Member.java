package lab1;

/**
 *
 * @author Haque
 */
public class Member extends Passenger {

    public int yearsOfMembership;

    public Member(String name, int age) {
    super(name, age);
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }


    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership >= 5) {
            p = p * 0.5;
            System.out.println("Discount Applied. New Price: " + p);
            return (p);
        } else if (yearsOfMembership < 5 && yearsOfMembership > 1) {
            p = p * 0.9;
            System.out.println("Discount Applied. New Price: " + p);
            return (p);
        } else {
            System.out.println("No Discount Applied");
            return (p);
        }

    }

}
