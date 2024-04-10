package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

public final class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    public SprintEntry(final String name, final LocalDateTime dateTime, final double dist, final Integer repetitions,
                       final Integer recovery) {
        super(name, dateTime, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    public Integer getRepetitions() {return this.repetitions;}

    public Integer getRecovery() {return this.recovery;}

    @Override
    public String toString() {
        return getName() + " sprinted " + getRepetitions() + " x " + getDistance() + "m in " + getFormattedTime() + " with "
                + getRecovery() + " minutes recovery on " + getFormattedDate() + "\n";
    }
}
