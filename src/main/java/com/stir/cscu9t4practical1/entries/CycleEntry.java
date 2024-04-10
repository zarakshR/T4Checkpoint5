package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

public final class CycleEntry extends Entry {

    private final TERRAIN terrain;
    private final TEMPO tempo;

    public CycleEntry(final String name, final LocalDateTime dateTime, final double dist, final TERRAIN terrain,
                      final TEMPO tempo) {
        super(name, dateTime, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return getName() + " cycled " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
    }

    public TERRAIN getTerrain() {return this.terrain;}

    public TEMPO getTempo() {return this.tempo;}

    public enum TERRAIN {
        ASPHALT,
        GRAVEL,
        MOUNTAIN;

        // the tests expect lowercase terrain names
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public enum TEMPO {
        FAST,
        MODERATE,
        SLOW;

        // the tests expect lowercase tempo names
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
