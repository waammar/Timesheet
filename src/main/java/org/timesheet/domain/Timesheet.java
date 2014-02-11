package org.timesheet.domain;

/**
 * Created by iWael on 04/02/2014.
 */
public class Timesheet {

    private Employee who;
    private Task task;
    private Integer hours;

    public Timesheet(Employee who, Task task, Integer hours) {
        this.who = who;
        this.task = task;
        this.hours = hours;
    }

    public Employee getWho() {
        return who;
    }

    public void setWho(Employee who) {
        this.who = who;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * Manager can alter hours before closing task
     * @param hours New amount of hours
     */
    public void alterHours(Integer hours) {
        this.hours = hours;
    }


    @Override
    public String toString() {
        return "Timesheet [who=" + who + ", task=" + task + ", hours=" + hours + "]";
    }
}
