package com.example;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestWithDB {

    @Test
    public void testAdd_small_numbers() {

        // table --
        // test data for calculator
        // per method:
        // Id (int) (pk) (ai)
        // Method_name (text) (not null)
        // input1 (not null), input2, input3 (double)
        // result1 (double)
        // exception (bool)

        TestdataRepo repo = new TestdataRepo("jdbc:sqlite:D:/SQLITE/2203.db");
        ArrayList<TestDataPOJO>  methodData =
                repo.select("SELECT * FROM testdata where NAME = 'testAdd_small_numbers'");
        Calculator calc = new Calculator();

        for (TestDataPOJO one_row : methodData) {
            double actual_result =  calc.add(one_row.input1, one_row.input2);
            assertEquals(one_row.result1, actual_result);
        }

    }
}
