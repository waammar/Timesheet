package org.timesheet.integration;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by iWael on 11/02/2014.
 */

@ContextConfiguration(locations="/persistence-beans.xml")
public class HibernateConfigurationTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void testHibernateConfiguration(){
        // Spring IOC Container instanciated and prepared sessionFactory
        Assert.assertNotNull(sessionFactory);
    }
}

