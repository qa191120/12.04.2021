package com.example;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    // 1 make it work
    // 2 perform insert update delete
    // 3 run the calc unit test and read the data from the
    //   caladata table + use it




    public static void main(String[] args) {
        EmployeeDAO empDAO = new EmployeeDAO( "jdbc:sqlite:D:/SQLITE/2203.db");

        //empDAO.select("Select * from EMPLOYEES");
        //System.out.println("=====================");
        //empDAO.select("SELECT * FROM EMPLOYEES WHERE AGE > 30");
        //System.out.println("=====================");
        //empDAO.update("UPDATE EMPLOYEES SET AGE = 12 WHERE NAME LIKE 'ALL%'");
        //System.out.println("=====================");
        //empDAO.select("Select * from EMPLOYEES");

        ArrayList<Employee> employees = empDAO.getAllEmployees();
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        //employees.get(0).

        CustomerDAO custDAO = new CustomerDAO( "jdbc:sqlite:D:/SQLITE/2203.db");
        custDAO.update("DELETE FROM CUSTOMER where id >= 1");
        custDAO.update("INSERT INTO CUSTOMER (Firstname, Lastname, Numberoforders, Height)"+
                " values ('COHEN', 'MOSHE', 12, 1.89)");
        custDAO.update("UPDATE CUSTOMER set height=height+0.01");
        ArrayList<Customer> customers = custDAO.getAllCustomers();
        Iterator<Customer> iter_cust = customers.iterator();
        while (iter_cust.hasNext()) {
            System.out.println(iter_cust.next());
        }


    }


}
