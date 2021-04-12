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
