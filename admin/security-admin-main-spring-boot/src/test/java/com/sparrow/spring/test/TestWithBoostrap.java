package com.sparrow.spring.test;

import com.sparrow.security.admin.boot.Application;
import com.sparrow.security.admin.dao.GroupDAO;
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
public class TestWithBoostrap {
    @Autowired
    private GroupDAO groupDAO;

    @Test
    public void testSpring() {
        System.out.println(groupDAO);
    }
}
