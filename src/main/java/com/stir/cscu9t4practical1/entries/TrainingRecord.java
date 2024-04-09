package com.stir.cscu9t4practical1.entries;


import java.time.LocalDate;
import java.util.*;


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

    public void removeEntry(final Entry e) { store.remove(e); }

    public Collection<Entry> lookupEntriesByName(final String name) {
        return store.stream().filter(e -> e.getName().equals(name)).toList();
    }

    public Collection<Entry> lookupEntriesByDay(final LocalDate date) {
        return store.stream().filter(e -> e.getDateTime().toLocalDate().equals(date)).toList();
    }

    public Double lookupWeeklyDistance(final String name, final LocalDate today) {
        // I'm on that Functional Programming grindset
        return store.stream()
                .filter(e -> e.getName().equals(name))
                // only consider dates within the last seven days
                .filter(e -> {
                    // the easiest way to do this, since we know exactly what the valid range of days is, is to just generate
                    //  all possible matching days :)
                    ArrayList<LocalDate> lastSevenDays = new ArrayList<LocalDate>(List.of(
                            today,
                            today.minusDays(1),
                            today.minusDays(2),
                            today.minusDays(3),
                            today.minusDays(4),
                            today.minusDays(5),
                            today.minusDays(6)
                    ));

                    return lastSevenDays.contains(e.getDateTime().toLocalDate());
                })
                // this should parallelize easily
                .reduce(0.0, (acc, e) -> acc + e.getDistance(), (acc1, acc2) -> acc1 + acc2);
    }

    public Vector<Entry> getEntries() {
        return new Vector<Entry>(store);
    }
}
