package org.example.fetchRecords;

import org.example.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchMathematics {
    public static void main(String[] args) {

        // Hibernate session
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        try {
            session.beginTransaction();


            String hql = "FROM Subject WHERE subName = 'Mathematics'";
            Subject mathSubject = session.createQuery(hql, Subject.class).uniqueResult();

            if (mathSubject != null) {
                System.out.println("Subject found: " + mathSubject);
            } else {
                System.out.println("No subject found with name 'Mathematics'");
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
