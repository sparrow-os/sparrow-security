package com.sparrow.security;

import com.alibaba.fastjson.JSON;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.RoleDAO;
import com.sparrow.security.po.Role;
import org.junit.Test;

public class RoleDaoTest extends BaseTest {
    @Test
    public void getRole() {
        RoleDAO roleDao = container.getBean("roleDao");
        Role role = roleDao.getEntity(1L);
        roleDao.delete(1L);
        role = roleDao.getEntity(1L);
    }

    @Test
    public void roleTest() {
        RoleDAO roleDao = container.getBean("roleDao");
        Role role = new Role();
        role.setId(0L);
        role.setCode("role code");
        role.setName("role name");
        role.setSort(0);
        role.setCreateUserId(0L);
        role.setModifiedUserId(0L);
        role.setGmtCreate(0L);
        role.setModifiedUserId(0L);
        role.setStatus(StatusRecord.DISABLE);
        System.out.println(JSON.toJSONString(role));
        roleDao.insert(role);
    }
}
