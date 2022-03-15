package com.company.model;

public class Customer {

    int id;
    String name;
    String nationalityId;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }
}
