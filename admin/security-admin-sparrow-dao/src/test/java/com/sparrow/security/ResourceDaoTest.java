package com.sparrow.security;

import com.sparrow.container.Container;
import com.sparrow.container.ContainerBuilder;
import com.sparrow.core.spi.ApplicationContext;
import com.sparrow.datasource.ConnectionContextHolderImpl;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.dao.ResourceDAO;
import com.sparrow.security.po.Resource;
import org.junit.Test;

public class ResourceDaoTest {
    @Test
    public void getUser() {
        Container container = ApplicationContext.getContainer();
        ContainerBuilder containerBuilder = new ContainerBuilder().contextConfigLocation("/dao.xml");
        container.init(containerBuilder);
        ResourceDAO resourceDao = container.getBean("resourceDao");
        Resource resource = resourceDao.getEntity(1L);
        System.out.println(resource.getAccessUrl());
        resourceDao.delete(1L);
        resource = resourceDao.getEntity(1L);
        System.out.println(resource.getAccessUrl());
    }

    @Test
    public void userTest() {
        Container container = ApplicationContext.getContainer();
        ContainerBuilder containerBuilder = new ContainerBuilder().contextConfigLocation("/dao.xml");
        container.init(containerBuilder);
        ResourceDAO resourceDao = container.getBean("resourceDao");

        Resource resource = new Resource();
        resource.setAppId(1L);
        resource.setResourceType(1);
        resource.setCode("code");
        resource.setCover("cover");
        resource.setDetailUrl("detail url");
        resource.setAccessUrl("access url");
        resource.setIcoUrl("ico url");
        resource.setMaxRecordCount(1);
        resource.setListUrl("list url");
        resource.setManager("manager");
        resource.setManageUrl("manage url");
        resource.setNewUrl("new url");
        resource.setOpenType("open type");
        resource.setParentId(0L);
        resource.setUploadKey("upload key");
        resource.setCreateTime(System.currentTimeMillis());
        resource.setUpdateTime(System.currentTimeMillis());
        resource.setCreateUserId(1L);
        resource.setUpdateUserId(1L);
        resource.setRemark("remark");
        resource.setName("name");
        resource.setStatus(StatusRecord.ENABLE);
        resource.setSort(1);
        resourceDao.insert(resource);
    }
}
