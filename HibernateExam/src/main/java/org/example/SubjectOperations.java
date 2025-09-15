package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SubjectOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter subject name: ");
        String subName = sc.nextLine();

        Subject sub = new Subject(subName);

        // Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(sub); // save subject
            session.getTransaction().commit();

            System.out.println("Subject saved successfully");




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
            sc.close();
        }
    }
}
