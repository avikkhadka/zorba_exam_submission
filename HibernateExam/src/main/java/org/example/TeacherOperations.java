package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class TeacherOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter teacher name: ");
        String name = sc.nextLine();

        System.out.print("Enter teacher qualification: ");
        String qualification = sc.nextLine();

        System.out.print("Enter experience of teaching: ");
        String experience = sc.nextLine();

        Teacher t = new Teacher(name, qualification, experience);

        // Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();

            System.out.println("Teacher saved successfully");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
            sc.close();
        }
    }
}
