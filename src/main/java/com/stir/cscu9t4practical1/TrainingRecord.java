package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {

    // Use a Set because the primary use of TrainingRecord will be lookups.
    private final Set<Entry> store;

    // This is the time zone used for lookups when a TimeZone is not provided by the user
    private final TimeZone tz;

    public TrainingRecord(TimeZone tz) {
        // Use a HashSet because its fast
        this.store = new HashSet<Entry>();
        this.tz = tz;
    }

    public void addEntry(Entry e) {
        store.add(e);
    }

    // currently just looks up the first entry in a given day for compatibility with the GUI implementations
    @Deprecated
    public String lookupEntry(int day, int month, int year) {
        for (Entry entry : store) {
            if (entry.getYear() == year && entry.getMonth() == month && entry.getDay() == day) {
                return entry.formattedEntry();
            }
        }
        return null;
    }

    public int getNumberOfEntries() {
        return store.size();
    }

    public void clearAllEntries() {
        store.clear();
    }

}
