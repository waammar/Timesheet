package org.timesheet.service.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.timesheet.domain.Manager;
import org.timesheet.service.dao.ManagerDao;

/**
 * Created by iWael on 12/02/2014.
 */
@Repository("managerDao")
public class ManagerDaoImpl extends HibernateDao<Manager, Long>  implements ManagerDao{

    @Override
    public boolean removeManager(Manager manager){
        Query managerQuery = currentSession().createQuery(
                "from Task t where t.manager.id = :id");
        managerQuery.setParameter("id",manager.getId());

        //Manager mustn't be assigned on no task
        if (!managerQuery.list().isEmpty()){
            return false;
        }

        //ok, remove as usual
        remove(manager);

        return true;
    }
}
