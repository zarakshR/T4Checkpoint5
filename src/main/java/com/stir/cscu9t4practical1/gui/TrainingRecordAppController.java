package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import java.time.LocalDate;

public interface TrainingRecordAppController {

    void addEntry(Entry e);

    void log(String s);

    void updateWithSearchByName(String name);

    void updateWithSearchByDate(LocalDate date);

    void showWeeklyDistance(String name);

    void reinitializeRecords();

    // we do all the janky error handling code in EntryPanel / SearchPanel so we can get neat error messages here and so that
    //  out Controllers don't have to concern itself with the internal representation of Entry objects
    void handleInvalidInput(InvalidFieldsException ex);
}
