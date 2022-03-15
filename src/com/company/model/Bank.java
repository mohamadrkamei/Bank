package com.company.model;


public class Bank {
    private  int id ;
    private String name;
    private String branchName;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranchName() {
        return branchName;
    }



    public void setId(int id) {

        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


}
