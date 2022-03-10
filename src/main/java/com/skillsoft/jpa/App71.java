package com.skillsoft.jpa;import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App71 {
//retreving data from database
    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {

            entityManager.getTransaction().begin();

            Employee7 firstEmployee = new Employee7("Peter", "Holland",
                    "Manager", 120000d);

            Employee7 secondEmployee = new Employee7("Bruce", "Brenner",
                    "Analyst", 80000d);

            Employee7 thirdEmployee = new Employee7("Naomi", "Miller",
                    "Vice President", 160000d);

            entityManager.persist(firstEmployee);
            entityManager.persist(secondEmployee);
            entityManager.persist(thirdEmployee);


            Employee7 empOne = entityManager.find(Employee7.class, 1);
            Employee7 empThree = entityManager.find(Employee7.class, 3);

            System.out.println("\n****************************\n");

            System.out.println("Details of empOne: " + empOne);
            System.out.println("Details of empThree: " + empThree);

            System.out.println("\n****************************\n");

        }
        catch (Exception exception){

            System.err.println("An exception occurred:" + exception);
        }
        finally {

            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }

    }
}


