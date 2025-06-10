package com.sparrow.security;

import com.sparrow.container.Container;
import com.sparrow.container.ContainerBuilder;
import com.sparrow.core.spi.ApplicationContext;
import org.junit.Before;

public class BaseTest {
    protected Container container;

    @Before
    public void initContainer() {
        container = ApplicationContext.getContainer();
        ContainerBuilder containerBuilder = new ContainerBuilder().contextConfigLocation("/dao.xml");
        container.init(containerBuilder);
    }
}
