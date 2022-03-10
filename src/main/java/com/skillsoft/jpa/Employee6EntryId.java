package com.skillsoft.jpa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee6EntryId implements Serializable {

    private int employeeId;
    private LocalDate entryDate;

    public Employee6EntryId() {
    }

    public Employee6EntryId(int employeeId, LocalDate entryDate) {

        this.employeeId = employeeId;
        this.entryDate = entryDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if (!(obj instanceof Employee6EntryId)) {
            return false;
        }
        Employee6EntryId entryId = (Employee6EntryId) obj;

        return ((entryId.getEmployeeId() == this.getEmployeeId()) &&
                (this.getEntryDate().equals(entryId.getEntryDate())));

    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, entryDate);
    }
}