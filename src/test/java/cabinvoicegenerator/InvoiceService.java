package cabinvoicegenerator;

public class InvoiceService {
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KM = 10.0;
    private static final double MINIMUM_FARE = 5;
    private static final int COST_PER_TIME_PREMIUM = 2;
    private static final double MINIMUM_COST_PER_KM_PREMIUM = 15.0;
    private static final double MINIMUM_FARE_PREMIUM = 10;

    public enum RideMode {NORMAL, PREMIUM}

    RideRepository rideRepository = new RideRepository();

    public double calculateFareForNormal(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_TIME);
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFareForPremium(double distance, int time) {
        double totalFare = (distance * MINIMUM_COST_PER_KM_PREMIUM) + (time * COST_PER_TIME_PREMIUM);
        return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
    }

}
