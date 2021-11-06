package cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {
    private static InvoiceGenerator invoiceGenerator;
   
    @BeforeAll
    static void beforeAll() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        //InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        //InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.4;
        int time = 1;
        double minimumFare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, minimumFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        //InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1),
                //new Ride(0.2,2),
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() throws InvoiceGeneratorException {
        //InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        String[] userId = {"user1", "user2", "user3"};
        Ride[][] rides ={
                {new Ride(5.0, 12), new Ride(2.5, 6)},
                {new Ride(3.0, 5), new Ride(0.01, 1)},
                {new Ride(10.0, 15), new Ride(2, 30)} };
        invoiceGenerator.addRideToRepositoy(userId, rides);
        InvoiceSummary summery = invoiceGenerator.invoiceForUser(userId[2]);
        InvoiceSummary expectedInvoiceSummery = new InvoiceSummary(rides[2].length, 165.0);
        Assertions.assertEquals(expectedInvoiceSummery, summery);
    }
}