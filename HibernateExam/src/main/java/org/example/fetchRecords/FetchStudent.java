package org.example.fetchRecords;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchStudent {
    public static void main(String[] args) {

        // Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();


            String hql = "FROM Student";
            Query<Student> query = session.createQuery(hql, Student.class);


            query.setMaxResults(2);
            List<Student> students = query.list();

            System.out.println("First 2 students:");
            for (Student s : students) {
                System.out.println("Name: " + s.getStudName() + ", Roll Number: " + s.getStudRollNumber());
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
