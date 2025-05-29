package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.AppBO;
import com.sparrow.security.admin.protocol.query.AppQuery;
import com.sparrow.security.admin.repository.AppRepository;
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.AppConverter;
import com.sparrow.security.po.App;
import com.sparrow.security.admin.protocol.param.AppParam;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AppRepositoryImpl implements AppRepository {

    @Inject
    private AppConverter appConverter;

    @Inject
    private AppDAO appDao;

    @Override
    public Long save(AppParam appParam) {
        App app = this.appConverter.param2po(appParam);
        if (appParam.getId() == null) {
            return this.appDao.insert(app);
        }
        return (long) this.appDao.update(app);
    }

    @Override
    public int delete(String appIds) {
        return this.appDao.batchDelete(appIds);
    }

    @Override
    public int disable(String appIds) {
        StatusCriteria statusCriteria = new StatusCriteria(appIds, StatusRecord.DISABLE);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override
    public int enable(String appIds) {
        StatusCriteria statusCriteria = new StatusCriteria(appIds, StatusRecord.ENABLE);
        return this.appDao.changeStatus(statusCriteria);
    }

    @Override
    public AppBO getApp(Long appId) {
        App app = this.appDao.getEntity(appId);
        return this.appConverter.po2bo(app);
    }

    @Override
    public List<AppBO> queryApps(AppQuery appQuery) {
        List<App> apps = this.appDao.queryApps(this.appConverter.toDbPagerQuery(appQuery));
        return this.appConverter.poList2BoList(apps);
    }

    @Override
    public List<AppBO> queryAllEnableApps() {
        List<App> apps = this.appDao.queryAllEnableApps();
        return this.appConverter.poList2BoList(apps);
    }

    @Override
    public Long getAppCount(AppQuery appQuery) {
        return this.appDao.countApp(this.appConverter.toDbCountQuery(appQuery));
    }
}
