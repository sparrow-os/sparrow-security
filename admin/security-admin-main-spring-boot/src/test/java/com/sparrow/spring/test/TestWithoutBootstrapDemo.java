package com.sparrow.spring.test;

import com.sparrow.security.admin.dao.GroupDAO;
import com.sparrow.spring.starter.test.TestWithoutBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestWithoutBootstrap
public class TestWithoutBootstrapDemo {
    @Autowired
    private GroupDAO groupDAO;

    @Test
    public void testSpring() {
        System.out.println(groupDAO);
    }
}
