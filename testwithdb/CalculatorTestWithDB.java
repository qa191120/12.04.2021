package com.example;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class CalculatorTestWithDB {

    @Test
    public void testAdd_small_numbers() {

        // Arrange
        Calculator calculator = new Calculator();

        // table --
        // test data for calculator
        // per method:
        // Id (int) (pk) (ai)
        // Method_name (text) (not null)
        // input1 (not null), input2, input3 (double)
        // result1 (double)
        // exception (bool)

        // run on data for this method
        // act + assert per row
        //for( CalcData one : allData) {
          //  double actual_result = calculator.add(one.A, one.B);
        //}

    }
}
