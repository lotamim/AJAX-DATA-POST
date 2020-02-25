package jquey.demo.models;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String empFirstName;
    private String empLastName;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Department department;

    public Employee(Integer id,String empFirstName,String empLastName,Department department) {
        this.id = id;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.department = department;
    }
    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
