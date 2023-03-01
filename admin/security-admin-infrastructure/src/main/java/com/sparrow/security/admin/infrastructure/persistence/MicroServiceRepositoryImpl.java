package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.MicroServiceDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.MicroServiceConverter;
import com.sparrow.security.po.MicroService;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.repository.MicroServiceRepository;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MicroServiceRepositoryImpl implements MicroServiceRepository {
    @Inject
    private MicroServiceConverter microServiceConverter;

    @Inject
    private MicroServiceDAO microServiceDao;

    @Override public Long save(MicroServiceParam microServiceParam) {
        MicroService microService = this.microServiceConverter.param2po(microServiceParam);
        if (microService.getId() != null) {
            this.microServiceDao.update(microService);
            return microService.getId();
        }
        return this.microServiceDao.insert(microService);
    }

    @Override public int delete(String microServiceIds) {
        return this.microServiceDao.batchDelete(microServiceIds);
    }

    @Override public int disable(String microServiceIds) {
        StatusCriteria statusCriteria = new StatusCriteria(microServiceIds, StatusRecord.DISABLE);
        return this.microServiceDao.changeStatus(statusCriteria);
    }

    @Override public int enable(String microServiceIds) {
        StatusCriteria statusCriteria = new StatusCriteria(microServiceIds, StatusRecord.ENABLE);
        return this.microServiceDao.changeStatus(statusCriteria);
    }

    @Override public MicroServiceBO getMicroService(Long microServiceId) {
        MicroService microService = this.microServiceDao.getEntity(microServiceId);
        return this.microServiceConverter.po2bo(microService);
    }

    @Override public List<MicroServiceBO> queryMicroServices(MicroServiceQuery microServiceQuery) {
        List<MicroService> microServiceList = this.microServiceDao.queryMicroServices(this.microServiceConverter.toDbPagerQuery(microServiceQuery));
        return this.microServiceConverter.poList2BoList(microServiceList);
    }

    @Override public Long getMicroServiceCount(MicroServiceQuery microServiceQuery) {
        return this.microServiceDao.countMicroService(this.microServiceConverter.toDbCountQuery(microServiceQuery));
    }
}