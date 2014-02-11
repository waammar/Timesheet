package org.timesheet.service.dao;

import org.timesheet.domain.Employee;
import org.timesheet.service.GenericDao;

/**
 * Created by iWael on 11/02/2014.
 */

public interface EmployeeDao extends GenericDao<Employee, Long>{

    /**
     * Tries to remove employee from the system
     * @param employee Employee to remove
     * @return {@code true} if employee is not assigned to any task or timesheet. Else {@code false}
     */
    boolean removeEmployee(Employee employee);
}
