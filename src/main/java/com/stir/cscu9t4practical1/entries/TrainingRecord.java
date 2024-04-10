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
        final Collection<Entry> toReturn = new Vector<Entry>();

        for (Entry entry : store) {
            if (entry.getName().equals(name)) {
                toReturn.add(entry);
            }
        }

        return toReturn;
    }

    /**
     Returns a collection of all entries in the database which match the given date
     @param date the name to lookup by

     @return the entries which have the same date as <code>date</code>
     */
    @Override
    public Collection<Entry> lookupEntriesByDay(final LocalDate date) {
        final Collection<Entry> toReturn = new Vector<>();

        for (final Entry entry : store) {
            if (entry.getDateTime().toLocalDate().equals(date)) {
                toReturn.add(entry);
            }
        }

        return toReturn;
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
        // the easiest way to do this, since we know exactly what the valid range of days is, is to just generate
        //  all possible matching days :)
        final ArrayList<LocalDate> lastSevenDays = new ArrayList<LocalDate>(List.of(
                today,
                today.minusDays(1),
                today.minusDays(2),
                today.minusDays(3),
                today.minusDays(4),
                today.minusDays(5),
                today.minusDays(6)
        ));

        Double totalDistance = 0.0;

        for (Entry entry : store) {
            final String entryName = entry.getName();
            final boolean inLast7Days = lastSevenDays.contains(entry.getDateTime().toLocalDate());

            if (entryName.equals(name) && inLast7Days) {
                totalDistance += entry.getDistance();
            }
        }

        return totalDistance;
    }

    /**
     @return all entries in the database as a <code>Collection<Entry></code>
     */
    @Override
    public Collection<Entry> getEntries() {
        return new Vector<Entry>(store);
    }
}
