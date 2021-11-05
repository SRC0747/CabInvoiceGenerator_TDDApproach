package cabinvoicegenerator;


/**
 * Ride is used to access Multiple Rides.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 5-11-2021
 */

public class Ride {
    public final double distance;
    public final int time;

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
    }
}
