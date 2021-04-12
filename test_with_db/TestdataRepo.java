package com.example;

import java.sql.*;
import java.util.ArrayList;

public class TestdataRepo {

    private String m_conn; // connection string

    public TestdataRepo(String m_conn) {
        this.m_conn = m_conn;
    }

    public ArrayList<TestDataPOJO> getAll() {
        return select("select * from testdata");
    }

    public TestDataPOJO getById(int id) {
        ArrayList<TestDataPOJO> results = select("select * from testdata where id = " + id);
        if (results.size() == 0) {
            return null;
        }
        return results.get(0);
    }

    public ArrayList<TestDataPOJO> select(String query) {

        ArrayList<TestDataPOJO> results = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    TestDataPOJO row_data = new TestDataPOJO(
                            rs.getInt("Id"),
                            rs.getString("Name"),
                            rs.getDouble("Input1"),
                            rs.getDouble("Input2"),
                            rs.getDouble("Input3"),
                            rs.getDouble("Result1"),
                            rs.getString("Exception"));
                        results.add(row_data);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return results;
    }

    public void modify_query(String query) {

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                Statement stmt = conn.createStatement();
                int rows = stmt.executeUpdate(query);
                System.out.println(String.format("%d rows updated", rows));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

