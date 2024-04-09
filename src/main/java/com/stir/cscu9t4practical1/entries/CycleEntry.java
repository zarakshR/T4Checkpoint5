package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public final class CycleEntry extends Entry {

    private final Terrain terrain;
    private final Tempo tempo;

    public CycleEntry(final String name, final LocalDateTime dateTime, final double dist, final Terrain terrain,
                      final Tempo tempo) {
        super(name, dateTime, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    @Deprecated
    public CycleEntry(final String n, final ZonedDateTime zonedDateTime, final double dist, final Terrain terrain,
                      final Tempo tempo) {
        this(n, zonedDateTime.toLocalDateTime(), dist, terrain, tempo);
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return getName() + " cycled " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
    }

    public enum Terrain {
        ASPHALT,
        GRAVEL,
        MOUNTAIN;

        // the tests expect lowercase terrain names
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    public enum Tempo {
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
