package org.timesheet.service.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.timesheet.domain.Timesheet;
import org.timesheet.service.dao.TimesheetDao;

import java.util.List;

/**
 * Created by iWael on 12/02/2014.
 */

@Repository("timesheetDao")
public class TimesheetDaoImpl extends HibernateDao<Timesheet, Long> implements TimesheetDao {

    @Override
    public List<Timesheet> list(){
        return currentSession()
                .createCriteria(Timesheet.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                        .list();
    }
}
