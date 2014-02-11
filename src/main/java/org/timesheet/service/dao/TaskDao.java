package org.timesheet.service.dao;

import org.timesheet.domain.Task;
import org.timesheet.service.GenericDao;

/**
 * Created by iWael on 11/02/2014.
 */
public interface TaskDao extends GenericDao<Task, Long>{

    boolean removeTask(Task task);
}
