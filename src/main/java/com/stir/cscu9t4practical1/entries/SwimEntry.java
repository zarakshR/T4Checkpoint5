package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

/**
 The type Swim entry.
 */
public final class SwimEntry extends Entry {

    private final LOCATION location;

    /**
     Instantiates a new Swim entry.

     @param n        the n
     @param dateTime the date time
     @param dist     the dist
     @param location the location
     */
    public SwimEntry(final String n, final LocalDateTime dateTime, final double dist, final LOCATION location) {
        super(n, dateTime, dist);
        this.location = location;
    }

    /**
     Gets location.

     @return the location
     */
    public LOCATION getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getName() + " swam " + getDistance() + " km " + getLocation() + " in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + "\n";
    }

    /**
     The enum Location.
     */
    public enum LOCATION {
        /**
         Outdoors location.
         */
        OUTDOORS,
        /**
         Pool location.
         */
        POOL;

        // these are what the tests expect
        @Override
        public String toString() {
            return switch (this) {
                case OUTDOORS -> "outdoors";
                case POOL -> "in a pool";
            };
        }
    }
}
