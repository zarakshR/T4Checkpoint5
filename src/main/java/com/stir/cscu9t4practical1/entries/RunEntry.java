package com.stir.cscu9t4practical1.entries;

import java.time.ZonedDateTime;

public class RunEntry extends Entry {

    public RunEntry(String n, ZonedDateTime zonedDateTime, double dist) {
        super(n, zonedDateTime, dist);
    }

    @Override
    public String formattedEntry() {
        return getName() + " ran " + getDistance() + " km in " + formattedTime() + " " +
                "on " + formattedDate() + "\n";
    }

    @Override
    public String toString() {
        return formattedEntry();
    }
}
