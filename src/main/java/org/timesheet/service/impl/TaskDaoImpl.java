package org.timesheet.service.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.timesheet.domain.Task;
import org.timesheet.service.dao.TaskDao;

import java.util.List;

/**
 * Created by iWael on 12/02/2014.
 */
@Repository("TaskDao")
public class TaskDaoImpl extends HibernateDao<Task, Long> implements TaskDao {

    @Override
    public boolean removeTask(Task task){
        Query taskQuery = currentSession().createQuery(
                "from Task t where t.task.id = :id");
        taskQuery.setParameter("id",task.getId());

        // task mustn't be assignet to no timesheet
        if (!taskQuery.list().isEmpty()){
            return false;
        }

        //ok remove as usual
        remove(task);

        return true;
    }

    @Override
    public List<Task> list(){
        return currentSession()
                .createCriteria(Task.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .list();
    }

}
