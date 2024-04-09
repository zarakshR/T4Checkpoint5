package com.stir.cscu9t4practical1.entries;


import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;


public final class TrainingRecord {

    // Use a Set because the primary use of TrainingRecordApp will be lookups.
    private final Set<Entry> store;

    public TrainingRecord() {
        // Use a HashSet because its fast
        this.store = new HashSet<Entry>();
    }

    public void addEntry(final Entry e) {
        store.add(e);
    }

    public Collection<Entry> lookupEntriesByName(String name) {
        return store.stream().filter(e -> e.getName().equals(name)).toList();
    }

    public Collection<Entry> lookupEntriesByDay(LocalDate date) {
        return store.stream().filter(e -> e.getDateTime().toLocalDate().equals(date)).toList();
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
