package com.stir.cscu9t4practical1;

import java.util.TimeZone;

public class CycleEntry extends Entry {

    private final String terrain;

    public String getTerrain() {
        return terrain;
    }

    public String getTempo() {
        return tempo;
    }

    private final String tempo;

    public CycleEntry(String n, int d, int m, int y, int h, int min, int s, TimeZone tz, float dist, String terraim,
                      String tempo) {
        super(n, d, m, y, h, min, s, tz, dist);
        this.terrain = terraim;
        this.tempo = tempo;
    }

    @Override
    public String formattedEntry() {
        return getName() + " cycled " + formattedDistance() + " in " + formattedTime() + " " +
                "on " + formattedDate() + " on " + getTerrain() + " at " + getTempo() + " tempo\n";
    }
}
