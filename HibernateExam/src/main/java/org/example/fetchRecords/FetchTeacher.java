package org.example.fetchRecords;

import org.example.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchTeacher {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();


            String hql = "FROM Teacher";
            Query<Teacher> query = session.createQuery(hql, Teacher.class);


            query.setMaxResults(2);
            List<Teacher> teachers = query.list();

            System.out.println("First 2 teachers:");
            for (Teacher t : teachers) {
                System.out.println("Name: " + t.getTeacherName() +
                        ", Qualification: " + t.getTeacherQualification());
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
