package com.skillsoft.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App72 {

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


            List<Employee7> employee7List = entityManager
                    .createQuery("SELECT ed FROM Employee ed")
                    .getResultList();

            System.out.println("\n****************************\n");
            System.out.println("The employees in the EmployeeDetails table:");
            for(Employee7 emp: employee7List){
                System.out.println(emp);
            }
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
