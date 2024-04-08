package com.stir.cscu9t4practical1.entries;


import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public class TrainingRecord {

    // Use a Set because the primary use of TrainingRecordApp will be lookups.
    private final Set<Entry> store;

    public TrainingRecord() {
        // Use a HashSet because its fast
        this.store = new HashSet<Entry>();
    }

    public void addEntry(Entry e) {
        store.add(e);
    }

    // currently just looks up the first entry in a given day for compatibility with the GUI implementations
    @Deprecated
    public String lookupEntry(int day, int month, int year) {
        for (Entry entry : store) {
            if (entry.getYear() == year && entry.getMonth() == month && entry.getDay() == day) {
                return entry.toString();
            }
        }
        return null;
    }

    @Deprecated
    public String lookupEntries(int day, int month, int year) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : store) {
            if (entry.getYear() == year && entry.getMonth() == month && entry.getDay() == day) {
                sb.append(entry);
            }
        }
        String str = sb.toString();
        // this is what the tests expect
        return str.isEmpty() ? "Sorry couldn't find anything for this date" : str;
    }

    public int getNumberOfEntries() {
        return store.size();
    }

    public void clearAllEntries() {
        store.clear();
    }

    public Vector<Entry> getEntries() {
        return new Vector<Entry>(store);
    }
}
