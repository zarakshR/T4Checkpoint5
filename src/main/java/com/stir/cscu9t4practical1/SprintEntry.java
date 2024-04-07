package com.stir.cscu9t4practical1;

import java.time.ZonedDateTime;

public class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    public SprintEntry(String n, ZonedDateTime zonedDateTime, float dist, Integer repetitions,
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

    // We need this because sprint entries are stores as metre-distances while Entry assumes kilometre distances
    @Override
    protected String formattedDistance() {
        return getDistance() + "m";
    }

    @Override
    public String formattedEntry() {
        return getName() + " sprinted " + getRepetitions() + " x " + formattedDistance() + " in " + formattedTime() + " with " + getRecovery() + " minutes recovery on " + formattedDate() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
