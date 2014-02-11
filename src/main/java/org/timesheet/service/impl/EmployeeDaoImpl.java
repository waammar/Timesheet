package org.timesheet.service.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.timesheet.domain.Employee;
import org.timesheet.service.dao.EmployeeDao;

/**
 * Created by iWael on 11/02/2014.
 */

@Repository("employeeDao")
public class EmployeeDaoImpl extends HibernateDao<Employee, Long> implements EmployeeDao{

    @Override
    public boolean removeEmployee(Employee employee){
        Query employeeTaskQuery = currentSession().createQuery(
                "from Task t where :id in elements(t.assignedEmployees)");

        // Employee mustn't be assigned on no task
        if (!employeeTaskQuery.list().isEmpty()){
            return false;
        }

        Query employeeTimesheetQuery = currentSession().createQuery(
                "from Timesheet t where t.who.id = :id ");

        employeeTimesheetQuery.setParameter("id",employee.getId());

        // Employee mustn't be assigned to any timesheet
        if(!employeeTimesheetQuery.list().isEmpty()){
            return false;
        }

        // remove as usual
        remove(employee);

        return true;
    }
}
