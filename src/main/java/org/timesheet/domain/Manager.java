package org.timesheet.domain;

import javax.persistence.*;

/**
 * Created by iWael on 04/02/2014.
 */

@Entity
@Table(name= "manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Manager(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;

        Manager manager = (Manager) o;

        if (id != manager.id) return false;
        if (!name.equals(manager.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }

    /**
     * Tutorial Examples
     */

    /*
     @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((id == null) ? 0 : id.hashCode());
  result = prime * result + ((name == null) ? 0 : name.hashCode());
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
  if (!(obj instanceof Manager)) {
   return false;
  }
  Manager other = (Manager) obj;
  if (id == null) {
   if (other.id != null) {
    return false;
   }
  } else if (!id.equals(other.id)) {
   return false;
  }
  if (name == null) {
   if (other.name != null) {
    return false;
   }
  } else if (!name.equals(other.name)) {
   return false;
  }
  return true;
 }
     */

}
