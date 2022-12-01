package com.sparrow.security.infrastructure.persistence.admin;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.repository.ResourceRepository;
import com.sparrow.security.dao.admin.ResourceDAO;
import com.sparrow.security.dao.admin.query.ResourceDBQuery;
import com.sparrow.security.infrastructure.persistence.admin.data.converter.ResourceConverter;
import com.sparrow.security.po.Resource;
import com.sparrow.security.protocol.admin.param.ResourceParam;
import com.sparrow.security.protocol.admin.param.ResourceSortParam;
import com.sparrow.security.protocol.admin.query.ResourceQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ResourceRepositoryImpl implements ResourceRepository {
    @Inject
    private ResourceDAO resourceDao;
    @Inject
    private ResourceConverter resourceConverter;

    @Override public Long save(ResourceParam resourceParam) {
        Resource resource = this.resourceConverter.param2po(resourceParam);
        if (resource.getId() == null) {
            Long resourceId = this.resourceDao.insert(resource);
            resourceParam.setId(resourceId);
            return resourceId;
        }
        this.resourceDao.update(resource);
        return resource.getId();
    }

    @Override public int delete(Long resourceId) {
        StatusCriteria statusCriteria = new StatusCriteria(resourceId + "", StatusRecord.DESTROYED);
        return this.resourceDao.changeStatus(statusCriteria);
    }

    @Override public int disable(Long resourceId) {
        StatusCriteria statusCriteria = new StatusCriteria(resourceId + "", StatusRecord.DISABLE);
        return this.resourceDao.changeStatus(statusCriteria);
    }

    @Override public int sort(ResourceSortParam sortParam) {
        return this.resourceDao.sort(sortParam.getId(), sortParam.getTarget());
    }

    @Override public int enable(Long resourceId) {
        StatusCriteria statusCriteria = new StatusCriteria(resourceId + "", StatusRecord.ENABLE);
        return this.resourceDao.changeStatus(statusCriteria);
    }

    @Override public ResourceBO getResource(Long resourceId) {
        Resource resource = this.resourceDao.getEntity(resourceId);
        return this.resourceConverter.po2bo(resource);
    }

    @Override public List<ResourceBO> queryResources(ResourceQuery resourceQuery) {
        ResourceDBQuery resourceDBQuery = this.resourceConverter.toDBQuery(resourceQuery);
        List<Resource> resources = this.resourceDao.queryResources(resourceDBQuery);
        return this.resourceConverter.poList2BoList(resources);
    }

    @Override public Integer resort(Long parentResourceId, Integer currentSort) {
        return this.resourceDao.resort(parentResourceId, currentSort);
    }

    @Override public Integer maxSort(Long parentResourceId) {
        return this.resourceDao.maxSort(parentResourceId);
    }
}
