package com.kozyrev.iLoveHibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Something went wrong!");
        }
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/avemiha",
                "postgres", "200496");

        System.out.println("Connection successful");
    }
}
