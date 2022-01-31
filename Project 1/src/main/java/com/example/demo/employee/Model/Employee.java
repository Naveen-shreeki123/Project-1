package com.example.demo.employee.Model;

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;
    private String name;
    private String email;
    private String phnumber;
    private int age;
    private int salary;
    private long DepartmentId;

    @ManyToOne
    private Department department;

    public Employee() {
    }

    public Employee(long id, String name, String email, String phnumber, int age, int salary, long DepartmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phnumber = phnumber;
        this.age = age;
        this.salary = salary;
        this.DepartmentId = DepartmentId;
    }

    public Employee(String name, String email, String phnumber, int age, int salary, long DepartmentId) {
        this.name = name;
        this.email = email;
        this.phnumber = phnumber;
        this.age = age;
        this.salary = salary;
        this.DepartmentId = DepartmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnumber() {
        return phnumber;
    }

    public void setPhnumber(String phnumber) {
        this.phnumber = phnumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(long departmentId) {
        DepartmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phnumber='" + phnumber + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", departmentId='" + DepartmentId + '\'' +
                '}';
    }
}
