package com.stir.cscu9t4practical1.gui;

// An exception that indicates that the user has entered invalid values for a field.
final class InvalidFieldsException extends Exception {

    private final String fieldName;
    private final String badValue;

    public InvalidFieldsException(final String fieldName, final String badValue) {
        this.fieldName = fieldName;
        this.badValue = badValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getBadValue() {
        return badValue;
    }
}
