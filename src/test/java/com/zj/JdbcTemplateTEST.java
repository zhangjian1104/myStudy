package com.zj;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateTEST {

    private ApplicationContext ctx = null;

    @Before
    public  void init() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("test begin");
    }

    @After
    public void destroy() {
        ctx = null;
        System.out.println("test end");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
        System.out.println("testDataSource excute");
    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);
        System.out.println("jdbcTemplate excute");
    }
}
