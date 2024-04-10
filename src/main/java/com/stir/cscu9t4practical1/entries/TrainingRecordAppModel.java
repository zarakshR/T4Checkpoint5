package com.stir.cscu9t4practical1.entries;

import java.time.LocalDate;
import java.util.Collection;

public interface TrainingRecordAppModel {

    /**
     Add an entry to the training record database. If the entry already exists (as defined by Entry.equals()), it is
     overwritten with the new entry.

     @param e the entry to add
     */
    void addEntry(Entry e);

    /**
     Remove an entry, if it exists, from the training record database

     @param e the entry to remove
     */
    void removeEntry(Entry e);

    /**
     Returns a collection of all entries in the database which match the given name

     @param name the name to lookup by

     @return the entries which have the same name as <code>name</code>
     */
    Collection<Entry> lookupEntriesByName(String name);

    /**
     Returns a collection of all entries in the database which match the given date

     @param date the name to lookup by

     @return the entries which have the same date as <code>date</code>
     */
    Collection<Entry> lookupEntriesByDay(LocalDate date);

    /**
     Returns the total distance accumulated by all entries with the given name which occurred within the last seven days
     of the date

     @param name  the name to lookup by
     @param today the date which entries must be within seven days before of

     @return the total distance accumulated by the entries
     */
    Double lookupWeeklyDistance(String name, LocalDate today);

    /**
     @return all entries in the database as a <code>Collection<Entry></code>
     */
    Collection<Entry> getEntries();
}
