package com.sparrow.security;

import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.dao.admin.AppDAO;
import com.sparrow.security.po.App;
import org.junit.Test;

public class AppDaoTest extends BaseTest {
    @Test
    public void getApp() {
        AppDAO appDao = container.getBean("appDao");
        App app = appDao.getEntity(1L);
        appDao.delete(1L);
        app = appDao.getEntity(1L);
    }

    @Test
    public void appTest() {
        AppDAO appDao = container.getBean("appDao");
        App app = new App();
        app.setId(0L);
        app.setCode("code");
        app.setName("name");
        app.setSort(0);
        app.setLogo("logo");
        app.setCreateUserId(0L);
        app.setUpdateUserId(0L);
        app.setCreateTime(0L);
        app.setUpdateTime(0L);
        app.setRemark("remark");
        app.setStatus(StatusRecord.DISABLE);
        appDao.insert(app);
    }
}
