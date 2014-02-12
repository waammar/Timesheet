package org.timesheet;

/**
 * Created by iWael on 12/02/2014.
 */

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.jdbc.SimpleJdbcTestUtils;

/**
 * Base make sure that before any test, empty database is available
 */
@ContextConfiguration(locations = {"/persistence-beans.xml"})
public class DomainAwareBase extends AbstractJUnit4SpringContextTests{

    private final String deleteScript = "src/main/resources/sql/cleanup.sql";

    @Autowired
    private SimpleJdbcTemplate jdbcTemplate;

    @Before
    public void deleteAllDomainEntities(){
        SimpleJdbcTestUtils.executeSqlScript(jdbcTemplate, new FileSystemResource(deleteScript),false);
    }
}
