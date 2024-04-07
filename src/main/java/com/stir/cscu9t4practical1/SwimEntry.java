package com.stir.cscu9t4practical1;

import java.util.TimeZone;

public class SwimEntry extends Entry {

    private final LOCATION location;

    public LOCATION getLocation() {
        return location;
    }

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, TimeZone tz, LOCATION location) {
        super(n, d, m, y, h, min, s, tz, dist);
        this.location = location;
    }

    @Override
    public String formattedEntry() {
        return getName() + " swam " + formattedDistance() + " " + getLocation() + " in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
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
