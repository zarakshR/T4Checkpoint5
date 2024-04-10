package com.stir.cscu9t4practical1.entries;


import java.time.LocalDate;
import java.util.*;


public final class TrainingRecord implements TrainingRecordAppModel {

    // Use a Set because the primary use of TrainingRecordApp will be lookups.
    private final Set<Entry> store;

    /**
     Creates a new <code>TrainingRecord</code> with no entries
     */
    public TrainingRecord() {
        // Use a HashSet because its fast
        this.store = new HashSet<Entry>();
    }

    /**
     Add an entry to the training record database. If the entry already exists (as defined by Entry.equals()), it is
     overwritten with the new entry.
     @param e the entry to add
     */
    @Override
    public void addEntry(final Entry e) {
        store.add(e);
    }

    /**
     Remove an entry, if it exists, from the training record database
     @param e the entry to remove
     */
    @Override
    public void removeEntry(final Entry e) { store.remove(e); }

    /**
     Returns a collection of all entries in the database which match the given name
     @param name the name to lookup by

     @return the entries which have the same name as <code>name</code>
     */
    @Override
    public Collection<Entry> lookupEntriesByName(final String name) {
        return store.stream().filter(e -> e.getName().equals(name)).toList();
    }

    /**
     Returns a collection of all entries in the database which match the given date
     @param date the name to lookup by

     @return the entries which have the same date as <code>date</code>
     */
    @Override
    public Collection<Entry> lookupEntriesByDay(final LocalDate date) {
        return store.stream().filter(e -> e.getDateTime().toLocalDate().equals(date)).toList();
    }

    /**
     Returns the total distance accumulated by all entries with the given name which occurred within the last seven days
     of the date
     @param name the name to lookup by
     @param today the date which entries must be within seven days before of

     @return the total distance accumulated by the entries
     */
    @Override
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

    /**
     @return all entries in the database as a <code>Collection<Entry></code>
     */
    @Override
    public Collection<Entry> getEntries() {
        return new Vector<Entry>(store);
    }
}
