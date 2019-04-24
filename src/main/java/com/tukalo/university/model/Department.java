package com.tukalo.university.model;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue
    private int depId;

    @Column(name = "dep_name")
    private String depName;

    @OneToOne(targetEntity = Lector.class)
    private int depHead;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getDepHead() {
        return depHead;
    }

    public void setDepHead(int depHead) {
        this.depHead = depHead;
    }

}
