package org.example; // Not in entity package

import org.example.entity.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Scanner;

 class ProductCategoryInsert{

    public static void main(String[] args) {

        // Setup Hibernate SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProductCategory.class)
                .buildSessionFactory();

        Scanner scanner = new Scanner(System.in);

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // Take one input from console
            System.out.print("Enter product type: ");
            String type = scanner.nextLine();

            System.out.print("Enter rate (numeric value only): ");
            BigDecimal rate = new BigDecimal(scanner.nextLine());

            // Create ProductCategory object
            ProductCategory category = new ProductCategory(type, rate);

            // Save to database
            session.save(category);

            session.getTransaction().commit();
            System.out.println("Saved product category: " + category);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
