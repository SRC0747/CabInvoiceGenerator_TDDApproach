package com.bridgelabz_cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * RideRepository is used to access the list of rides based on list of userId given as input
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 7-11-2021
 */
public class RideRepository {
    Map<String, Ride[]> userRides;

    public RideRepository() {

        this.userRides = new HashMap<>();
    }

    /**
     * addRides is used to add rides based on UserId and throwing Exception if occurred
     * @param userId
     * @param rides
     * @throws InvoiceGeneratorException
     */
    public void addRides(String userId, Ride[] rides) throws InvoiceGeneratorException {
        if (userRides.containsKey(userId))
            throw new InvoiceGeneratorException(InvoiceGeneratorException.ExceptionType.USER_ALREADY_EXISTS,
                    "User ID Already Exists!!!");
        else
            userRides.put(userId, rides);
    }

    /**
     * getRides is used to get the userId String array as input
     * @param userId
     * @return the userId given as input
     */
    public Ride[] getRides(String[] userId) {
        return this.userRides.get(userId[0]);
    }
}
