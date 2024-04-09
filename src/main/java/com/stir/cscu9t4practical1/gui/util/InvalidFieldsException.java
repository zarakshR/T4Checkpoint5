package com.stir.cscu9t4practical1.gui.util;

/**
 An exception that indicates that the user has entered invalid values for a field
 */
public final class InvalidFieldsException extends Exception {

    private final String fieldName;
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

    /**
     Gets the name of the field which had invalid input provided to it
     @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     Gets the invalid value provided
     @return the bad value
     */
    public String getBadValue() {
        return badValue;
    }
}
