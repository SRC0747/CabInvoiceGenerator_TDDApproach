package com.bridgelabz_cabinvoicegenerator;

/**
 * Ride is used to access Multiple Rides.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 7-11-2021
 */

public class Ride {
    public final double distance;
    public final int time;
    public InvoiceService.RideMode rideMode;

    public Ride(double distance, int time, InvoiceService.RideMode rideMode) {
        this.distance = distance;
        this.time = time;
        this.rideMode = rideMode;
    }
}
