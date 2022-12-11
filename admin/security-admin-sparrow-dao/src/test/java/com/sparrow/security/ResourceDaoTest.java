package com.sparrow.security;

import com.alibaba.fastjson.JSON;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.ResourceDAO;
import com.sparrow.security.po.Resource;
import org.junit.Test;

public class ResourceDaoTest extends BaseTest {
    @Test
    public void getResource() {
        ResourceDAO resourceDao = container.getBean("resourceDao");
        Resource resource = resourceDao.getEntity(2L);
        resourceDao.delete(2L);
        resource = resourceDao.getEntity(2L);
    }

    @Test
    public void resourceTest() {
        ResourceDAO resourceDao = container.getBean("resourceDao");
        Resource resource = new Resource();
        resource.setAppId(1L);
        resource.setResourceType(1);
        resource.setPermission("/cms-manage");
        resource.setUrl("/cms-manage/friends-link");
        resource.setMethod("GET");
        resource.setIcoUrl("ico url");
        resource.setOpenType("open type");
        resource.setParentId(0L);
        resource.setCreateTime(System.currentTimeMillis());
        resource.setUpdateTime(System.currentTimeMillis());
        resource.setCreateUserId(1L);
        resource.setUpdateUserId(1L);
        resource.setRemark("remark");
        resource.setName("name");
        resource.setStatus(StatusRecord.ENABLE);
        resource.setSort(1);
        System.out.println(JSON.toJSONString(resource));
        resourceDao.insert(resource);
    }
}
