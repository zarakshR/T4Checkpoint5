package com.stir.cscu9t4practical1;

import java.util.TimeZone;

public class CycleEntry extends Entry {

    private final Terrain terrain;
    private final Tempo tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, TimeZone tz, float dist, Terrain terrain,
                      Tempo tempo) {
        super(n, d, m, y, h, min, s, tz, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Tempo getTempo() {
        return tempo;
    }

    @Override
    public String formattedEntry() {
        return getName() + " cycled " + formattedDistance() + " in " + formattedTime() + " " +
                "on " + formattedDate() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
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
