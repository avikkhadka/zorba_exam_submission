package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class StudentOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter student roll number: ");
        int roll = sc.nextInt();

        Student s = new Student(name, roll);

        // Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(s);
            session.getTransaction().commit();

            System.out.println("Student saved successfully");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
            sc.close();
        }
    }
}
