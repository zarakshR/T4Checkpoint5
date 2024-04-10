package com.stir.cscu9t4practical1.gui.util;

import lombok.Getter;

/**
 An exception that indicates that the user has entered invalid values for a field
 */
@Getter
public final class InvalidFieldsException extends Exception {

    /**
     * -- GETTER --
     * Gets the name of the field which had invalid input provided to it@return the field name

     */
    private final String fieldName;
    /**
     * -- GETTER --
     * Gets the invalid value provided@return the bad value

     */
    private final String badValue;

    /**
     Create an <code>InvalidFieldsException</code> with the name of the field and the invalid value
     @param fieldName the field which has the bad value
     @param badValue the invalid value
     */
    public InvalidFieldsException(final String fieldName, final String badValue) {
        this.fieldName = fieldName;
        this.badValue = badValue;
    }

}
