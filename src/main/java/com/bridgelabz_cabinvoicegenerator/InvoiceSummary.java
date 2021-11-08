package com.bridgelabz_cabinvoicegenerator;

/**
 * InvoiceSummary class is used to calculate total and average fare of Multiple Rides.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 7-11-2021
 */

public class InvoiceSummary {
    private final int noOfRides;
    private final double totalFare;
    private final double averageFare;

    InvoiceSummary(int noOfRides, double totalFare){
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.noOfRides;
    }

    /**
     * equals method overriding the parent class to check equality
     * @param obj to access the equality with the current passing object
     * @return the equality
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) obj;
        return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
    }
}
