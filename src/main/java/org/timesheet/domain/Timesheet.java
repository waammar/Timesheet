package org.timesheet.domain;

import javax.persistence.*;

/**
 * Created by iWael on 04/02/2014.
 */

@Entity
@Table(name= "timesheet")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee who;

    @OneToOne
    @JoinColumn(name="task_id")
    private Task task;
    private Integer hours;

    public Timesheet(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Timesheet)) return false;

        Timesheet timesheet = (Timesheet) o;

        if (id != timesheet.id) return false;
        if (!hours.equals(timesheet.hours)) return false;
        if (!task.equals(timesheet.task)) return false;
        if (!who.equals(timesheet.who)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + who.hashCode();
        result = 31 * result + task.hashCode();
        result = 31 * result + hours.hashCode();
        return result;
    }

    /*

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((hours == null) ? 0 : hours.hashCode());
  result = prime * result + ((id == null) ? 0 : id.hashCode());
  result = prime * result + ((task == null) ? 0 : task.hashCode());
  result = prime * result + ((who == null) ? 0 : who.hashCode());
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj) {
   return true;
  }
  if (obj == null) {
   return false;
  }
  if (!(obj instanceof Timesheet)) {
   return false;
  }
  Timesheet other = (Timesheet) obj;
  if (hours == null) {
   if (other.hours != null) {
    return false;
   }
  } else if (!hours.equals(other.hours)) {
   return false;
  }
  if (id == null) {
   if (other.id != null) {
    return false;
   }
  } else if (!id.equals(other.id)) {
   return false;
  }
  if (task == null) {
   if (other.task != null) {
    return false;
   }
  } else if (!task.equals(other.task)) {
   return false;
  }
  if (who == null) {
   if (other.who != null) {
    return false;
   }
  } else if (!who.equals(other.who)) {
   return false;
  }
  return true;
 }
     */

}
