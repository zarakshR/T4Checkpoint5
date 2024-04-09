package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

public final class RunEntry extends Entry {

    public RunEntry(final String name, final LocalDateTime dateTime, final double dist) {
        super(name, dateTime, dist);
    }

    @Override
    public String toString() {
        return getName() + " ran " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + "\n";
    }
}
