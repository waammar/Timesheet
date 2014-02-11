package org.timesheet.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iWael on 04/02/2014.
 */

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="task_employee",
                joinColumns = {@JoinColumn(name="task_id")},
                inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> assignedEmployees = new ArrayList<Employee>();

    @OneToOne
    @JoinColumn(name="manager_id")
    private Manager manager;

    private boolean completed;
    private String description;

    public Task(){}

    public Task(String description, Manager manager, Employee... employees) {
        this.description = description;
        this.manager = manager;
        assignedEmployees.addAll(Arrays.asList(employees));
        completed = false;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", assignedEmployees=" + assignedEmployees +
                ", manager=" + manager +
                ", completed=" + completed +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (completed != task.completed) return false;
        if (id != task.id) return false;
        if (!assignedEmployees.equals(task.assignedEmployees)) return false;
        if (!description.equals(task.description)) return false;
        if (!manager.equals(task.manager)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + assignedEmployees.hashCode();
        result = 31 * result + manager.hashCode();
        result = 31 * result + (completed ? 1 : 0);
        result = 31 * result + description.hashCode();
        return result;
    }

    /*
        @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;

        if (completed != task.completed) {
            return false;
        }
        if (description != null ? !description.equals(task.description) : task.description != null) {
            return false;
        }
        if (id != null ? !id.equals(task.id) : task.id != null) {
            return false;
        }
        if (manager != null ? !manager.equals(task.manager) : task.manager != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }
     */
}
