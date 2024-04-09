package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

/**
 The type Sprint entry.
 */
public final class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    /**
     Instantiates a new Sprint entry.

     @param name        the name
     @param dateTime    the date time
     @param dist        the dist
     @param repetitions the repetitions
     @param recovery    the recovery
     */
    public SprintEntry(final String name, final LocalDateTime dateTime, final double dist, final Integer repetitions,
                       final Integer recovery) {
        super(name, dateTime, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }

    /**
     Gets repetitions.

     @return the repetitions
     */
    public Integer getRepetitions() {
        return repetitions;
    }

    /**
     Gets recovery.

     @return the recovery
     */
    public Integer getRecovery() {
        return recovery;
    }

    @Override
    public String toString() {
        return getName() + " sprinted " + getRepetitions() + " x " + getDistance() + "m in " + getFormattedTime() + " with "
                + getRecovery() + " minutes recovery on " + getFormattedDate() + "\n";
    }
}
