package org.timesheet.domain;

/**
 * Created by iWael on 04/02/2014.
 * test
 */


public class Employee {

    private String name;
    private String departement;

    public Employee(String departement, String name) {
        this.departement = departement;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
