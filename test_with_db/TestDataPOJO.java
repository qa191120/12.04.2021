package com.example;

import lombok.ToString;

@ToString
public class TestDataPOJO {

    public int id;
    public String name;
    public double input1;
    public double input2;
    public double input3;
    public double result1;
    public String exception;

    public TestDataPOJO() {
    }

    public TestDataPOJO(int id, String name, double input1, double input2, double input3, double result1, String exception) {
        this.id = id;
        this.name = name;
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
        this.result1 = result1;
        this.exception = exception;
    }
}
