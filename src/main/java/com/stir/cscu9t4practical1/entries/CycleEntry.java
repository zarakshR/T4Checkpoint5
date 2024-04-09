package com.stir.cscu9t4practical1.entries;

import java.time.LocalDateTime;

/**
 The type Cycle entry.
 */
public final class CycleEntry extends Entry {

    private final TERRAIN terrain;
    private final TEMPO tempo;

    /**
     Instantiates a new Cycle entry.

     @param name     the name
     @param dateTime the date time
     @param dist     the dist
     @param terrain  the terrain
     @param tempo    the tempo
     */
    public CycleEntry(final String name, final LocalDateTime dateTime, final double dist, final TERRAIN terrain,
                      final TEMPO tempo) {
        super(name, dateTime, dist);
        this.terrain = terrain;
        this.tempo = tempo;
    }

    /**
     Gets terrain.

     @return the terrain
     */
    public TERRAIN getTerrain() {
        return terrain;
    }

    /**
     Gets tempo.

     @return the tempo
     */
    public TEMPO getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return getName() + " cycled " + getDistance() + " km in " + getFormattedTime() + " "
                + "on " + getFormattedDate() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
    }

    /**
     The enum Terrain.
     */
    public enum TERRAIN {
        /**
         Asphalt terrain.
         */
        ASPHALT,
        /**
         Gravel terrain.
         */
        GRAVEL,
        /**
         Mountain terrain.
         */
        MOUNTAIN;

        // the tests expect lowercase terrain names
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    /**
     The enum Tempo.
     */
    public enum TEMPO {
        /**
         Fast tempo.
         */
        FAST,
        /**
         Moderate tempo.
         */
        MODERATE,
        /**
         Slow tempo.
         */
        SLOW;

        // the tests expect lowercase tempo names
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
