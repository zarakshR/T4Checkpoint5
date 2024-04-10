package com.stir.cscu9t4practical1.gui;

import com.stir.cscu9t4practical1.entries.Entry;
import com.stir.cscu9t4practical1.gui.util.InvalidFieldsException;

import java.time.LocalDate;

/**
 This interface defines all actions that a valid controller implementation for the app must define. The methods are named
 starting with request since the controller implementation is by design the final arbiter of what happens
 */
public interface TrainingRecordAppController {

    /**
     The user has requested that the specified entry be created

     @param e the entry which the user is attempting to create
     */
    void requestCreationOfEntry(Entry e);

    /**
     A UI component has requested that a message be logged to some kind of system messages panel

     @param message the string to log
     */
    void requestLog(String message);

    /**
     The user has requested to delete an entry at a given (list) index. The index is defined as the index that is visible to
     the user, i.e., if the user requests deletion of the first entry in the list, the index will be 0.

     @param index the index to remove the element from
     */
    void requestRemovalOfEntryAtIndex(int index);

    /**
     The user has requested a search for entries by the given name

     @param name the name to search for
     */
    void requestSearchByName(String name);

    /**
     The user has requested a search for entries on the given date

     @param date the date to search for
     */
    void requestSearchByDate(LocalDate date);

    /**
     The user has requested the weekly summary of an athlete of the given name

     @param name the name of the athlete
     */
    void requestShowWeeklyDistance(String name);

    /**
     A UI component has requested that the records be refreshed from the database
     */
    void requestReinitializeRecords();

    /**
     A UI component has indicated that the user has attempted to create an Entry with an invalid definition

     @param ex the <code>InvalidFieldsException</code> that contains information on the attempted Entry definition
     */
    // we do all the janky error handling code in EntryPanel / SearchPanel so we can get neat error messages here and so that
    //  our Controllers don't have to concern itself with the internal representation of Entry objects
    void handleInvalidInput(InvalidFieldsException ex);
}
