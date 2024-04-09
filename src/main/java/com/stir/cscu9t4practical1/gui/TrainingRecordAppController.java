package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import java.time.LocalDate;

/**
 The interface Training record app controller.
 */
public interface TrainingRecordAppController {

    /**
     Add entry.

     @param e the e
     */
    void addEntry(Entry e);

    /**
     Log.

     @param s the s
     */
    void log(String s);

    /**
     Remove entry at index.

     @param index the index
     */
    void removeEntryAtIndex(int index);

    /**
     Update with search by name.

     @param name the name
     */
    void updateWithSearchByName(String name);

    /**
     Update with search by date.

     @param date the date
     */
    void updateWithSearchByDate(LocalDate date);

    /**
     Show weekly distance.

     @param name the name
     */
    void showWeeklyDistance(String name);

    /**
     Reinitialize records.
     */
    void reinitializeRecords();

    /**
     Handle invalid input.

     @param ex the ex
     */
// we do all the janky error handling code in EntryPanel / SearchPanel so we can get neat error messages here and so that
    //  out Controllers don't have to concern itself with the internal representation of Entry objects
    void handleInvalidInput(InvalidFieldsException ex);
}
