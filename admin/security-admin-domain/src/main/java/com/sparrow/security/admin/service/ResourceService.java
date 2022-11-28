package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.repository.ResourceRepository;
import com.sparrow.security.protocol.admin.enums.SecurityAdminError;
import com.sparrow.security.protocol.admin.param.ResourceParam;
import com.sparrow.security.protocol.admin.query.ResourceQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ResourceService {
    @Inject
    private ResourceRepository resourceRepository;

    public void validateSaveResource(ResourceParam resourceParam) {

    }

    public Long saveResource(ResourceParam resourceParam) throws BusinessException {
        this.validateSaveResource(resourceParam);
        return this.resourceRepository.save(resourceParam);
    }

    public Integer deleteResource(Long resourceId) throws BusinessException {
        Asserts.isTrue(resourceId == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        return this.resourceRepository.delete(resourceId);
    }

    public Integer enableResource(Long resourceId) throws BusinessException {
        Asserts.isTrue(resourceId == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        return this.resourceRepository.enable(resourceId);
    }

    public Integer disableGroup(Long resourceId) throws BusinessException {
        Asserts.isTrue(resourceId == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        return this.resourceRepository.disable(resourceId);
    }

    public List<ResourceBO> queryResources(ResourceQuery resourceQuery) {
        return this.resourceRepository.queryResources(resourceQuery);
    }

    public ResourceBO getResource(Long resourceId) throws BusinessException {
        Asserts.isTrue(resourceId == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        return this.resourceRepository.getResource(resourceId);
    }
}
