package org.example.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class PassengersImplementation {

    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Load Hibernate configuration
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Passenger.class);
            configuration.addAnnotatedClass(GeneralPassenger.class);
            configuration.addAnnotatedClass(PhysicallyHandicappedPassenger.class);
            configuration.addAnnotatedClass(SeniorCitizenPassenger.class);

            // Build SessionFactory
            sessionFactory = configuration.buildSessionFactory();

            // Open session
            Session session = sessionFactory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                // Taking input for 3 passengers
                for (int i = 1; i <= 3; i++) {
                    System.out.println("\nEnter details for Passenger " + i);

                    // Common information of all three types of passengers
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Mobile: ");
                    String mobile = scanner.nextLine();

                    System.out.print("Destination: ");
                    String destination = scanner.nextLine();

                    System.out.print("Seat Number: ");
                    String seatNumber = scanner.nextLine();

                    // choosing type of passengers
                    System.out.println("Select Passenger Type:");
                    System.out.println("1. General");
                    System.out.println("2. Senior Citizen");
                    System.out.println("3. Physically Handicapped");
                    int type = Integer.parseInt(scanner.nextLine());

                    switch (type) {
                        case 1:
                            System.out.print("Coach Type: ");
                            String coachType = scanner.nextLine();

                            GeneralPassenger general = new GeneralPassenger();
                            general.setName(name);
                            general.setEmail(email);
                            general.setMobile(mobile);
                            general.setDestination(destination);
                            general.setSeatNumber(seatNumber);
                            general.setCoachType(coachType);

                            session.persist(general);
                            break;

                        case 2:
                            System.out.print("Has Discount? (true/false): ");
                            boolean discount = Boolean.parseBoolean(scanner.nextLine());

                            System.out.print("Senior Citizen ID: ");
                            String seniorId = scanner.nextLine();

                            SeniorCitizenPassenger senior = new SeniorCitizenPassenger();
                            senior.setName(name);
                            senior.setEmail(email);
                            senior.setMobile(mobile);
                            senior.setDestination(destination);
                            senior.setSeatNumber(seatNumber);
                            senior.setDiscount(discount);
                            senior.setSeniorCitizenId(seniorId);

                            session.persist(senior);
                            break;

                        case 3:
                            System.out.print("Proof of Disability: ");
                            String proof = scanner.nextLine();

                            PhysicallyHandicappedPassenger ph = new PhysicallyHandicappedPassenger();
                            ph.setName(name);
                            ph.setEmail(email);
                            ph.setMobile(mobile);
                            ph.setDestination(destination);
                            ph.setSeatNumber(seatNumber);
                            ph.setProofOfDisability(proof);

                            session.persist(ph);
                            break;

                        default:
                            System.out.println("Invalid type! Try again.");
                            i--;
                            break;
                    }
                }

                // Commit transaction
                tx.commit();
                System.out.println("\nAll 3 passengers saved successfully!");

                // Fetch and display Physically Handicapped passengers
                List<PhysicallyHandicappedPassenger> handicappedPassengers =
                        session.createQuery("from PhysicallyHandicappedPassenger", PhysicallyHandicappedPassenger.class)
                                .list();

                if (handicappedPassengers.isEmpty()) {
                    System.out.println("\nNo physically handicapped passengers found.");
                } else {
                    System.out.println("\nPhysically Handicapped Passengers:");
                    for (PhysicallyHandicappedPassenger ph : handicappedPassengers) {
                        System.out.println("Name: " + ph.getName()
                                + ", Email: " + ph.getEmail()
                                + ", Mobile: " + ph.getMobile()
                                + ", Destination: " + ph.getDestination()
                                + ", Seat Number: " + ph.getSeatNumber()
                                + ", Proof of Disability: " + ph.getProofOfDisability());
                    }
                }

            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null) sessionFactory.close();
            scanner.close();
        }
    }
}
