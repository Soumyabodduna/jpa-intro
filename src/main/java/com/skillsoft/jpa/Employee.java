package com.skillsoft.jpa;

//public class Employee {
  //  private int id;
 //   private String firstName;
  //  private String lastName;
  //  private String job;
  //  private double salary;

    //public Employee() {
   // }

   // public Employee(int id, String firstName, String lastName, String job, double salary) {
   //     this.id = id;
   ///     this.firstName = firstName;
    //    this.lastName = lastName;
    //    this.job = job;
    //    this.salary = salary;
  //  }

   /// public int getId() {
    ////    return id;
  ///  }

  ///  public String getFirstName() {
   ///     return firstName;
 ///   }

  //  public String getLastName() {
   //     return lastName;
  //  }

   // public String getJob() {
   //     return job;
  //  }

  //  public double getSalary() {
    //    return salary;
    //}

    //public void setId(int id) {
    //    this.id = id;
 //   }

   // public void setFirstName(String firstName) {
    //    this.firstName = firstName;
  //  }

  //  public void setLastName(String lastName) {
     //   this.lastName = lastName;
  //  }

 //   public void setJob(String job) {
   //     this.job = job;
  //  }

    //public void setSalary(double salary) {
   //     this.salary = salary;
   // }
//}
import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private EmployeeContactInfo contactInfo;

    public Employee() {
    }

    public Employee(String firstName, String lastName,
                    String role, Double salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(EmployeeContactInfo contactInfo) {
        if (contactInfo == null) {
            if (this.contactInfo != null) {
                this.contactInfo.setEmployee(null);
            }
        } else {
            contactInfo.setEmployee(this);
        }

        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", contactInfo=" + contactInfo +
                '}';
    }
}

