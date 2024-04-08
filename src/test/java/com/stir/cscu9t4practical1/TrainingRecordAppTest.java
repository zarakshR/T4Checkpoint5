package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TrainingRecordAppTest {

    @Test
    public void testMain() {
        assertDoesNotThrow(() -> TrainingRecordApp.main(null));
    }
}
