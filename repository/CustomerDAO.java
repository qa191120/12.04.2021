package com.example;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    private String m_conn; // connection string

    public CustomerDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<Customer> getAllCustomers() {
        return select("SELECT * FROM CUSTOMER");
    }

    public Customer getById(int id) {
        // run select query for customer with the given id
        ArrayList<Customer> results =
                select("SELECT * FROM CUSTOMER WHERE ID = " + id);
        if (results.size() > 0)
            return results.get(0);
        else
            return null;
    }

    public ArrayList<Customer> select(String query) {

        // fire select query
        // create Employee instance per record
        // create array list of all employees
        // try to connect to db

        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    Customer e = new Customer(
                            rs.getInt("id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getInt("numberoforders"),
                            rs.getDouble("height"));
                    customers.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customers;
    }

    public void update(String query) {

        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(result + " record updated.");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
