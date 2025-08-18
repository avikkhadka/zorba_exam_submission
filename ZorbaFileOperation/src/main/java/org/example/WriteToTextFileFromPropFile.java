package org.example;

import java.io.*;
import java.util.Properties;

public class WriteToTextFileFromPropFile {
    public static void main(String[] args) {
        try {

            File propFileObj = new File("/Users/avikkhadka/Desktop/17AugExam/ZorbaFileOperation/src/main/resources/employee.properties");
            Properties propertiesObj = new Properties();
            FileInputStream fileInputStreamObj = new FileInputStream(propFileObj);
            propertiesObj.load(fileInputStreamObj);
            fileInputStreamObj.close();


            String name = propertiesObj.getProperty("name");
            String address = propertiesObj.getProperty("address");
            String mobile = propertiesObj.getProperty("mobile");
            String salary = propertiesObj.getProperty("salary");
            String dateOfJoining = propertiesObj.getProperty("dateOfJoining");
            String department = propertiesObj.getProperty("department");

            String content = String.format(
                    "My name is %s. Address is %s, Mobile number %s, having salary %s. %s has joined the organisation on %s under %s Department.",
                    name, address, mobile, salary, name, dateOfJoining, department
            );


        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
