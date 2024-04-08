package com.stir.cscu9t4practical1.entries;

import java.time.ZonedDateTime;

public class SwimEntry extends Entry {

    private final LOCATION location;

    public SwimEntry(String n, ZonedDateTime zonedDateTime, float dist, LOCATION location) {
        super(n, zonedDateTime, dist);
        this.location = location;
    }

    public LOCATION getLocation() {
        return location;
    }

    @Override
    public String formattedEntry() {
        return getName() + " swam " + getDistance() + " km " + getLocation() + " in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
    }

    @Override
    public String toString() {
        return formattedEntry();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public enum LOCATION {
        OUTDOORS,
        POOL;

        // these are what the tests expect
        @Override
        public String toString() {
            if (this.equals(OUTDOORS)) {
                return "outdoors";
            } else if (this.equals(POOL)) {
                return "in a pool";
            } else {
                return super.toString();
            }
        }
    }
}
