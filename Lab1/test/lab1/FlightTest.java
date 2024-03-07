package lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Haque
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        int expResult = 140;
        int result = instance.getFlightNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        String expResult = "Toronto";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        String expResult = "London";
        String result = instance.getDestination();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        String expResult = "03/02/99 7:50 pm";
        String result = instance.getDepartureTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        int expResult = 200;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        int expResult = 200;
        int result = instance.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        double expResult = 250.0;
        double result = instance.getOriginalPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int newFlightNumber = 1040;
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setFlightNumber(newFlightNumber);
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String newOrigin = "Ottawa";
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setOrigin(newOrigin);
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String newDestination = "Birmingham";
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setDestination(newDestination);
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String newDepartureTime = "04/02/99 7:50 pm";
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setDepartureTime(newDepartureTime);
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int newCapacity = 190;
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setCapacity(newCapacity);
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int newNumberOfSeatsLeft = 190;
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setNumberOfSeatsLeft(newNumberOfSeatsLeft);
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double newOriginalPrice = 275.0;
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        instance.setOriginalPrice(newOriginalPrice);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0);
        String expResult = "Flight 1030, Toronto to London, 03/02/99 7:50 pm, Original Price: $250.0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
 
    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0); 
        assertEquals(1030, instance.getFlightNumber());
        assertEquals("Toronto", instance.getOrigin());
        assertEquals("London", instance.getDestination());
        assertEquals("03/02/99 7:50 pm", instance.getDepartureTime());
        assertEquals(200, instance.getCapacity());
        assertEquals(250.0, instance.getOriginalPrice(), 0.0);
        assertEquals(200, instance.getNumberOfSeatsLeft());
    }
    
    @Test
    public void testInvalidConstructor() {
        System.out.println("testInvalidConstructor");
        Flight instance = new Flight(140, 100, "Toronto", "Dhaka", "02/04/04 7:20 pm", 250.0); 
        assertEquals(1030, instance.getFlightNumber());
        assertEquals("Toronto", instance.getOrigin());
        assertEquals("Toronto", instance.getDestination());
        assertEquals("03/02/99 7:50 pm", instance.getDepartureTime());
        assertEquals(200, instance.getCapacity());
        assertEquals(250.0, instance.getOriginalPrice(), 0.0);
        assertEquals(200, instance.getNumberOfSeatsLeft());
    }
    
    
}