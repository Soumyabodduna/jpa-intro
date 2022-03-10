package com.skillsoft.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee2 {



    private int id;
    private String firstName;
    private String lastName;
    private String job;
    private double salary;

    public Employee2() {
    }

    public Employee2(int id, String firstName, String lastName, String job, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
    }
    @Id
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJob() {
        return job;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
