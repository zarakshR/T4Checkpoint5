package com.stir.cscu9t4practical1;

import java.util.TimeZone;

public class SwimEntry extends Entry {

    private final String location;

    public String getLocation() {
        return location;
    }

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, TimeZone tz, String location) {
        super(n, d, m, y, h, min, s, tz, dist);
        this.location = location.equals("pool") ? "in a pool" : "outdoors";
    }

    @Override
    public String formattedEntry() {
        return getName() + " swam " + formattedDistance() + " " + getLocation() + " in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
    }
}
