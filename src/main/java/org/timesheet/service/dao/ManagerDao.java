package org.timesheet.service.dao;

import org.timesheet.domain.Manager;
import org.timesheet.service.GenericDao;

/**
 * Created by iWael on 11/02/2014.
 */
public interface ManagerDao extends GenericDao<Manager, Long>{

    boolean removeManager(Manager manager);
}
