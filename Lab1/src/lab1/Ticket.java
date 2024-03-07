package lab1;

/**
 *
 * @author Haque
 */
public class Ticket {

    public double price;
    public Flight flight;
    public Passenger passenger;
    public static int number;

    public Ticket(Passenger p, Flight flight, double price) {
    passenger = p;
    this.flight = flight;
    this.price = price;
    number++;
    }

    public double getPrice() {
        return price;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getNumber() {
        return number;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setNumber(int number) {
        this.number = number;
    }

 @Override
    public String toString() {
        return (passenger.name + ", Flight " + flight.flightNumber + ", " + flight.origin + " to " + flight.destination + ", " + flight.departureTime + ", Original Price: " + flight.originalPrice + ", Ticket Price: " + getPrice()) + "\n";
    }
}
