package com.stir.cscu9t4practical1.entries;

import java.time.ZonedDateTime;

public final class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    public SprintEntry(final String n, final ZonedDateTime zonedDateTime, final double dist, final Integer repetitions,
                       final Integer recovery) {
        super(n, zonedDateTime, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public Integer getRecovery() {
        return recovery;
    }

    @Override
    public String toString() {
        return getName() + " sprinted " + getRepetitions() + " x " + getDistance() + "m in " + getFormattedTime() + " with "
                + getRecovery() + " minutes recovery on " + getFormattedDate() + "\n";
    }
}
