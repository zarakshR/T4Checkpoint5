package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

    private final Integer repetitions;
    private final Integer recovery;

    public Integer getRepetitions() {
        return repetitions;
    }

    public Integer getRecovery() {
        return recovery;
    }

    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, Integer repetitions, Integer recovery) {
        super(n, d, m, y, h, min, s, dist);
        this.repetitions = repetitions;
        this.recovery = recovery;
    }
}
