package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.AppConverter;
import com.sparrow.security.po.App;
import com.sparrow.security.admin.protocol.param.AppParam;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AppRepositoryImpl implements AppRepository {

    @Inject
    private AppConverter appDataMapper;

    @Inject
    private AppDAO appDao;

    @Override public Long save(AppParam appParam) {
        App app = this.appDataMapper.param2po(appParam);
        if (appParam.getId() == null) {
            return this.appDao.insert(app);
        }
        return (long) this.appDao.update(app);
    }

    @Override public int delete(String appIds) {
        StatusCriteria statusCriteria = new StatusCriteria(appIds, StatusRecord.DESTROYED);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override public int disable(String appIds) {
        StatusCriteria statusCriteria = new StatusCriteria(appIds, StatusRecord.DISABLE);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override public int enable(String appIds) {
        StatusCriteria statusCriteria = new StatusCriteria(appIds, StatusRecord.ENABLE);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override public AppBO getApp(Long appId) {
        App app = this.appDao.getEntity(appId);
        return this.appDataMapper.po2bo(app);
    }
}
