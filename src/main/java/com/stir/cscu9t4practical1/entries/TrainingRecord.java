package com.stir.cscu9t4practical1.entries;


import com.stir.cscu9t4practical1.entries.Entry;

import java.util.HashSet;
import java.util.Set;


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
                return entry.formattedEntry();
            }
        }
        return null;
    }

    @Deprecated
    public String lookupEntries(int day, int month, int year) {
        StringBuilder sb = new StringBuilder();
        for (Entry entry : store) {
            if (entry.getYear() == year && entry.getMonth() == month && entry.getDay() == day) {
                sb.append(entry.formattedEntry());
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

}
