package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

public final class SwimEntry extends Entry {

    private final LOCATION location;

    public SwimEntry(final String n, final LocalDateTime dateTime, final double dist, final LOCATION location) {
        super(n, dateTime, dist);
        this.location = location;
    }

    public LOCATION getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return getName() + " swam " + getDistance() + " km " + getLocation() + " in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + "\n";
    }

    public enum LOCATION {
        OUTDOORS,
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
