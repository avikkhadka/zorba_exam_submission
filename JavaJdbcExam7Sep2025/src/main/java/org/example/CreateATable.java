package org.example;

import java.sql.*;

public class CreateATable {
    public static void main(String[] args) {
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcPractice","root","echoRoot");
            String CreateTableSql="CREATE TABLE students (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT" +
                    ")";
            Statement statement=connection.createStatement();
            statement.execute(CreateTableSql);
            System.out.println("Table has been created successfully");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
