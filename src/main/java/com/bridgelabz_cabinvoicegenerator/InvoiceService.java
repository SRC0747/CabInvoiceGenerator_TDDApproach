package com.bridgelabz_cabinvoicegenerator;

/**
 * InvoiceService is used to access both Normal and Premium Multiple Rides
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 7-11-2021
 */
public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final double MINIMUM_FARE = 5;
    private static final int COST_PER_TIME_PREMIUM = 2;
    private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
    private static final double MINIMUM_FARE_PREMIUM = 10;

    public enum RideMode {NORMAL, PREMIUM}

    RideRepository rideRepository = new RideRepository();

    /**
     * calculateFareNormal is used to calculate total fare of Normal Ride
     * @param distance
     * @param time
     * @return totalFare of Normal Ride
     */
    public double calculateFareForNormal(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_TIME);
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * calculateFareForPremium is used to calculate fare of Premium Ride
     * @param distance
     * @param time
     * @return totalFare of Premium Ride
     */
    public double calculateFareForPremium(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM_PREMIUM) + (time * COST_PER_TIME_PREMIUM);
        return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
    }

    /**
     * calculateFareForNormal is used to calculate total fare of Multiple Normal and Premium Rides
     * @param rides
     * @return totalFare of Multiple Normal and Premium Rides
     */
    public InvoiceSummary calculateFareForNormalPremium(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            if (ride.rideMode.equals(RideMode.NORMAL))
                totalFare += this.calculateFareForNormal(ride.distance, ride.time);
            else
                totalFare += this.calculateFareForPremium(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * addRides is used to add the rides based on the given userId and throws exception if occurred
     * @param userId
     * @param rides
     * @throws InvoiceGeneratorException
     */
    public void addRides(String[] userId, Ride[][] rides) throws InvoiceGeneratorException {
        for (int i = 0; i < userId.length; i++)
        {
            rideRepository.addRides(userId[i], rides[i]);
        }
    }

    /**
     * getInvoiceSummery is used to get the userId given as input
     * @param userId
     * @return totalFare
     */
    public InvoiceSummary getInvoiceSummary(String[] userId) {
        return this.calculateFareForNormalPremium(rideRepository.getRides(userId));
    }
}
