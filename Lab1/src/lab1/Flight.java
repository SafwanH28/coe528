package lab1;

/**
 *
 * @author Haque
 */
public class Flight {

    public int flightNumber, capacity, numberOfSeatsLeft;
    public String origin, destination, departureTime;
    public double originalPrice;

    public Flight(int flightnum, int cap, String og, String destin, String depTime, double ogPrice) {
        flightNumber = flightnum;
        capacity = cap;
        numberOfSeatsLeft = cap;
        origin = og;
        destination = destin;
        departureTime = depTime;
        originalPrice = ogPrice;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public boolean bookASeat() {
        System.out.println("\nBooking Seat...");
        if (numberOfSeatsLeft > 0) {
            numberOfSeatsLeft = numberOfSeatsLeft - 1;    
            System.out.println("Booked Seat");
            System.out.println("Seats remaining: " + numberOfSeatsLeft);
            return (true);
        } else {
            System.out.println("Booking Failed");
            return (false);
        }

    }

    @Override
    public String toString() {
        return ("\nFlight Number " + getFlightNumber() + ", Travelling from " + getOrigin() + " to " + getDestination() + ", On " + getDepartureTime() + ". - Original Price: $" + getOriginalPrice() + "\n");
    }

}
