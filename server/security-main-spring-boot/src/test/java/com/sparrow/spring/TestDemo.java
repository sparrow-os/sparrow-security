package com.sparrow.spring;

import com.sparrow.security.boot.Application;
import com.sparrow.security.dao.GroupDAO;
import com.sparrow.spring.container.SparrowTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@TestExecutionListeners(listeners = {SparrowTestExecutionListener.class, DependencyInjectionTestExecutionListener.class})
public class TestDemo {
    @Autowired
    private GroupDAO groupDAO;

    @Test
    public void testUserDao() {
        System.out.println(groupDAO);
    }
}
