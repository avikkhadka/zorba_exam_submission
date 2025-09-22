package org.example;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.entity.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Scanner;

public class CustomerOrder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Setup Hibernate
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ProductCategory.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Customer.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Customer entering details...");
            System.out.print("Enter Customer ID: ");
            String custId = scanner.nextLine();

            System.out.print("Enter Customer Name: ");
            String custName = scanner.nextLine();

            System.out.print("Enter Customer Email: ");
            String custEmail = scanner.nextLine();

            System.out.print("Enter Customer Mobile (10 digits): ");
            String mobileStr = scanner.nextLine();

            if (mobileStr.length() != 10 || !mobileStr.matches("\\d+")) {
                System.out.println("Invalid mobile number! Must be exactly 10 digits.");
                return;
            }
            Long custMobile = Long.parseLong(mobileStr);

            System.out.println("Entering Product details...");
            System.out.print("Enter Product ID: ");
            String productId = scanner.nextLine();

            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine();

            System.out.print("Enter Product Quantity: ");
            BigDecimal quantity = new BigDecimal(scanner.nextLine());

            System.out.print("Enter Product Type (grocery/cosmetics/dairyproduct): ");
            String productTypeInput = scanner.nextLine();

            //getting the category of product the user entered
            ProductCategory category = (ProductCategory) session
                    .createQuery("FROM ProductCategory WHERE productType = :type")
                    .setParameter("type", productTypeInput)
                    .uniqueResult();

            if (category == null) {
                System.out.println("Invalid product type! Exiting...");
                return;
            }

            //calculating the price
            BigDecimal rate = category.getRate();
            BigDecimal finalPrice = quantity.multiply(rate);

            Product product = new Product(productId, productName, quantity, category);
            Customer customer = new Customer(custId, custName, custEmail, custMobile, finalPrice);

            // Save entities to database
            session.save(product);
            session.save(customer);

            session.getTransaction().commit();

            System.out.println("Order saved successfully!");
            System.out.println("Customer: " + customer);
            System.out.println("Product: " + product);
            System.out.println("Final Price: " + finalPrice);





        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
