package com.stir.cscu9t4practical1.entries;

import java.time.ZonedDateTime;

public class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    public SprintEntry(String n, ZonedDateTime zonedDateTime, double dist, Integer repetitions,
                       Integer recovery) {
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
        return getName() + " sprinted " + getRepetitions() + " x " + getDistance() + "m in " + formattedTime() + " with "
                + getRecovery() + " minutes recovery on " + formattedDate() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
