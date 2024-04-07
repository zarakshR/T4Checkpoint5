package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

    private final String where;

    public String getWhere() {
        return where;
    }

    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
        super(n, d, m, y, h, min, s, dist);
        this.where = where;
    }
}
