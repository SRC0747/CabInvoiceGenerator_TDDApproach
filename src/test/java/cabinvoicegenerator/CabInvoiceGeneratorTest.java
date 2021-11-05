package cabinvoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CabInvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.4;
        int time = 1;
        double minimumFare = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, minimumFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.4, 1),
                new Ride(0.2,2),
        };
        InvoiceSummary summary = invoiceGenerator.calculateFareMultipleRides(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 4.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}