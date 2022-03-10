package com.skillsoft.jpa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App2 {
    public static void main( String[] args )
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee2 firstEmployee = new Employee2(1121, "Pavan", "Hosha",
                "SE", 120000);

        Employee2 secondEmployee = new Employee2(1141,"Bavana", "Bunna",
                "Analyst", 90000);

        entityManager.persist(firstEmployee);
        entityManager.persist(secondEmployee);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();

    }
}

