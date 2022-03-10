package com.skillsoft.jpa;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Employee5Entry {

    @EmbeddedId
    Employee5EntryId employeePlusDate;
    LocalTime entryTime;

    public Employee5Entry() {
    }

    public Employee5Entry(int empId, LocalDate entryDate, LocalTime entryTime) {

        this.employeePlusDate = new Employee5EntryId(empId, entryDate);
        this.entryTime = entryTime;
    }

    public Employee5EntryId getEmployeePlusDate() {
        return employeePlusDate;
    }

    public void setEmployeePlusDate(Employee5EntryId employeePlusDate) {
        this.employeePlusDate = employeePlusDate;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {

        return "EmployeeEntry{" +
                ", employeeId=" + employeePlusDate.getEmployeeId() +
                ", entryDate='" + employeePlusDate.getEntryDate() + '\'' +
                ", entryTime='" + entryTime +
                '}';
    }

}
