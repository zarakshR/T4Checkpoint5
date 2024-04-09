package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public final class RunEntry extends Entry {

    public RunEntry(final String name, final LocalDateTime dateTime, final double dist) {
        super(name, dateTime, dist);
    }

    @Deprecated
    public RunEntry(final String n, final ZonedDateTime zonedDateTime, final double dist) {
        this(n, zonedDateTime.toLocalDateTime(), dist);
    }

    @Override
    public String toString() {
        return getName() + " ran " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + "\n";
    }
}
