package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

/**
 The type Run entry.
 */
public final class RunEntry extends Entry {

    /**
     Instantiates a new Run entry.

     @param name     the name
     @param dateTime the date time
     @param dist     the dist
     */
    public RunEntry(final String name, final LocalDateTime dateTime, final double dist) {
        super(name, dateTime, dist);
    }

    @Override
    public String toString() {
        return getName() + " ran " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + "\n";
    }
}
