package cabinvoicegenerator;

/**
 * InvoiceGenerator is used to calculate Total Fare by taking distance and time and also compare with the Minimum fare.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 5-11-2021
 */

public class InvoiceGenerator {
    private static final double MINIMUM_COST_PER_KILLOMETER = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;

    /**
     * calculateFare method calculate totalFare and Minimum Fare taking distance and time.
     * @param distance
     * @param time
     * @return totalFare and Minimum Fare
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KILLOMETER + time * COST_PER_TIME;
        if(totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public double calculateFareMultipleRides(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides){
            totalFare = this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
