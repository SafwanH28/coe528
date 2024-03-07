package lab1;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Haque
 */
public class Manager {

    ArrayList<Flight> flights;
    ArrayList<Integer> flightNumber;
    ArrayList<Ticket> tickets;
    int size = 0;

    public Manager() {
        this.flights = new ArrayList<>();
        this.flightNumber = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public void createFlights() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter flight information");
        System.out.println("Flight Number");
        String flightNum = sc.nextLine();
        int flightNum1 = Integer.parseInt(flightNum);
        System.out.println("Flight Capacity");
        String cap = sc.nextLine();
        int cap1 = Integer.parseInt(cap);
        System.out.println("Origin");
        String origin = sc.nextLine();
        System.out.println("Destination");
        String destin = sc.nextLine();
        System.out.println("Departure Date and Time");
        String depTime = sc.nextLine();
        System.out.println("Original Price");
        String ogPrice = sc.nextLine();
        double ogPrice1 = Double.parseDouble(ogPrice);

        Flight f1 = new Flight(flightNum1, cap1, origin, destin, depTime, ogPrice1);
        flights.add(f1);
        this.size++;
        System.out.println("Flight Successfully Created: " + f1.toString());
    }

    public void displayAvailableFlights(String origin, String destination) {
        for (int i = 0; i < size; i++) {
            if (flights.get(i).getOrigin().equals(origin) && flights.get(i).getDestination().equals(destination) && flights.get(i).getNumberOfSeatsLeft() != 0) {
                System.out.println(flights.get(i).toString());
            }
        }
    }

    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < size; i++) {
            if (flightNumber == flights.get(i).flightNumber) {
                return (flights.get(i));

            }
        }
        return (null);
    }

    public void bookSeat(int flightNumber, Passenger p) {
        Flight f1 = getFlight(flightNumber);
        double discountedPrice;
        if (getFlight(flightNumber) != null) {
            if (getFlight(flightNumber).bookASeat() == true) {
                discountedPrice = p.applyDiscount(getFlight(flightNumber).getOriginalPrice());
                Ticket t1 = new Ticket(p, f1, discountedPrice);
                tickets.add(t1);
                System.out.println("Ticket Purchased: " + t1.toString());
            }
        }

    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        int done = 0;
        while (done == 0) {
            System.out.println("WELCOME TO XYZ FLIGHT SYSTEM");
            System.out.println("Disclaimer: Flights must be created first before other functions can be used!");
            System.out.println("Press 1 to create a new flight");
            System.out.println("Press 2 to see availlable flights for your specified Origin and Destination");
            System.out.println("Press 3 to book a seat");
            System.out.println("Press 4 to find a specific flight with Flight Number");
            System.out.println("Press 5 to Exit");

            Scanner sc2 = new Scanner(System.in);
            String ans = sc2.nextLine();

            if (ans.equals("1")) {
                manager.createFlights();
            } else if (ans.equals("2")) {
                System.out.println("Enter Origin");
                String og2 = sc2.nextLine();
                System.out.println("Enter Destination");
                String dest2 = sc2.nextLine();
                manager.displayAvailableFlights(og2, dest2);
            } else if (ans.equals("3")) {
                System.out.println("Enter flight number");
                String flightnum = sc2.nextLine();
                int flightnum2 = Integer.parseInt(flightnum);
                System.out.println("Enter passengers name");
                String pname = sc2.nextLine();
                System.out.println("Enter pasasengers age");
                String page = sc2.nextLine();
                int page2 = Integer.parseInt(page);
                System.out.println("Are you a Member (y/n)");
                String mem = sc2.nextLine();
                if (mem.equals("y")) {
                    System.out.println("How many years have you been a member for?");
                    String years = sc2.nextLine();
                    int years2 = Integer.parseInt(years);
                    Member p = new Member(pname, page2);
                    p.setYearsOfMembership(years2);
                    manager.bookSeat(flightnum2, p);

                } else {
                    NonMember p = new NonMember(pname, page2);
                    manager.bookSeat(flightnum2, p);
                }
            } else if (ans.equals("4")) {
                System.out.println("Enter your flight number)");
                String flightn = sc2.nextLine();
                int flightno = Integer.parseInt(flightn);
                System.out.println(manager.getFlight(flightno));
            } else if (ans.equals("5")) {
                done = 1;
            }
        }

    }
}
