package com.skillsoft.jpa;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

//public class App {
       // public static void main( String[] args )
      //  {

         //   Configuration cfg = new Configuration();
         //   cfg = cfg.configure("META-INF/hibernate.cfg.xml");

         //   SessionFactory factory = cfg.buildSessionFactory();
          //  Session session = factory.openSession();

           // Employee firstEmployee = new Employee(1121, "Peter", "Holland",
           //         "Manager", 120000);

           // Employee secondEmployee = new Employee(1141,"Bruce", "Brenner",
          //          "Analyst", 80000);

          //  Transaction transaction = session.beginTransaction();

         //   session.save(firstEmployee);
          //  session.save(secondEmployee);

          //  transaction.commit();

          //  session.close();
          //  factory.close();
       /// }
//}
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class App {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();
        try {

            entityManager.getTransaction().begin();
            EmployeeContactInfo eciOne = new EmployeeContactInfo("101 Main St", "555-101");
            EmployeeContactInfo eciTwo = new EmployeeContactInfo("51 Broadway", "555-155");
            EmployeeContactInfo eciThree = new EmployeeContactInfo("24 Walnut St", "555-222");
            Employee firstEmployee = new Employee("Peter", "Holland",
                    "Manager", 120000d);
            Employee secondEmployee = new Employee("Bruce", "Brenner",
                    "Analyst", 80000d);
            Employee thirdEmployee = new Employee("Naomi", "Miller",
                    "Vice President", 160000d);
            firstEmployee.setContactInfo(eciOne);
            secondEmployee.setContactInfo(eciTwo);
            thirdEmployee.setContactInfo(eciThree);
            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);
            entityManager.persist(eciOne);
            entityManager.persist(eciTwo);
            entityManager.persist(eciThree);
            List<Employee> employeeList = entityManager
                    .createQuery("SELECT ed FROM Employees ed")
                    .getResultList();
            System.out.println("\n****************************\n");
            System.out.println("The employees in the Employee table:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }

            System.out.println("\n****************************\n");
            List<EmployeeContactInfo> contactInfos = entityManager
                    .createQuery("SELECT eci FROM EmployeeContactInfo eci")
                    .getResultList();
            System.out.println("\nThe contact details for employees:\n");
            for (EmployeeContactInfo eci : contactInfos) {
                System.out.println(eci);
            }

            System.out.println("\n****************************\n");
        } catch (Exception exception) {

            System.err.println("An exception occurred:" + exception);
        } finally {

            entityManager.getTransaction().commit();
            entityManager.close();
            factory.close();
        }

    }
}
