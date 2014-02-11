package org.timesheet.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iWael on 04/02/2014.
 */
public class Task {

    private List<Employee> assignedEmployees = new ArrayList<Employee>();
    private Manager manager;
    private boolean completed;
    private String description;


    public Task(String description, Manager manager, Employee... employees) {
        this.description = description;
        this.manager = manager;
        assignedEmployees.addAll(Arrays.asList(employees));
        completed = false;
    }


    public List<Employee> getAssignedEmployees() {
        return assignedEmployees;
    }


    public void addEmployee(Employee e) {
        assignedEmployees.add(e);
    }

    public void removeEmployee(Employee e) {
        assignedEmployees.remove(e);
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeTask() {
        completed = true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
