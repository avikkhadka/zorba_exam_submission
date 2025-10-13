package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyFirstJDBCCommection {
    public static void main(String[] args) {
        //loading the mysql driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        //Create the Connection
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/SQL_PATIENT_ASSIGNMENT","root","echoRoot");
            System.out.println("Connection successfull.Lets Master JDBC!");

            //creating new schema
//            String createNewSchema="CREATE DATABASE IF NOT EXISTS jdbcCreateNewSchemaPractice";
//            Statement statement=connection.createStatement();
            //fetching all the tables in my database
            Statement statement=connection.createStatement();
            List<String> allSchema=new ArrayList<>();
            String createNewSchema="SHOW TABLES";
            ResultSet resultSet=statement.executeQuery(createNewSchema);

            while(resultSet.next())
            {
               allSchema.add(resultSet.getString(1));
            }

            System.out.println(allSchema);

        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
