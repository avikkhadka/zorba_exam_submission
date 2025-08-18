package org.example;

import java.io.*;
import java.util.Properties;

public class WriteToPropFile {
    public static void main(String[] args) {
        File fileObj=new File("/Users/avikkhadka/Desktop/17AugExam/ZorbaFileOperation/src/main/resources/employee.properties");
        Properties propertiesObj=new Properties();

        try{
            //this step loads if we have any existing properties in the properties file
            if(fileObj.exists())
            {
                FileInputStream fileInputStreamObj=new FileInputStream(fileObj);
                propertiesObj.load(fileInputStreamObj);
                fileInputStreamObj.close();



            }
            //adding the properties to the file

            propertiesObj.setProperty("name", "Robert");
            propertiesObj.setProperty("address", "NYC");
            propertiesObj.setProperty("salary", "2398.23");
            propertiesObj.setProperty("mobile", "57575757");
            propertiesObj.setProperty("department", "Finance");
            propertiesObj.setProperty("dateOfJoining", "2021-02-03");
            propertiesObj.setProperty("policy_id", "1003");

            //now we will write all the properties to our properties file
            OutputStream outputStreamObj = new FileOutputStream(fileObj);
            propertiesObj.store(outputStreamObj, "Details added/updated");
            outputStreamObj.close();

            System.out.println("Properties Added Successfully ");


            //now, reading the properties from the file.

            FileInputStream fileInputStreamObj=new FileInputStream(fileObj);
            Properties readPropertiesObj=new Properties();
            readPropertiesObj.load(fileInputStreamObj);
            fileInputStreamObj.close();

            //reading the data

            System.out.println("Name: " + readPropertiesObj.getProperty("name"));
            System.out.println("Address: " + readPropertiesObj.getProperty("address"));
            System.out.println("Salary: " + readPropertiesObj.getProperty("salary"));
            System.out.println("Mobile: " + readPropertiesObj.getProperty("mobile"));
            System.out.println("Department: " + readPropertiesObj.getProperty("department"));
            System.out.println("Date Of Joining: " + readPropertiesObj.getProperty("dateOfJoining"));
            System.out.println("Policy ID: " + readPropertiesObj.getProperty("policy_id"));


        }
        catch(IOException e)
        {
            System.err.println(e.getMessage());
        }


    }
}
