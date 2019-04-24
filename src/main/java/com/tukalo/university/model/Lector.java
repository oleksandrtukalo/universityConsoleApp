package com.tukalo.university.model;

import javax.persistence.*;
import java.util.Set;

@Entity()
@Table(name = "lectors")
public class Lector {
    @Id
    @GeneratedValue
    int lecId;

    @Column(name = "fname")
    private String fName;

    @Column(name = "lname")
    private String lName;

    @Column(name = "degree")
    private String degree;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lector_department", joinColumns = {@JoinColumn(name = "lecId")}, inverseJoinColumns = {@JoinColumn(name = "depId")})
    private Set<Department> department;

    public int getLecId() {
        return lecId;
    }

    public void setLecId(int lecId) {
        this.lecId = lecId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
