package com.sparrow.security.admin.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.repository.ResourceRepository;
import com.sparrow.security.admin.protocol.enums.SecurityAdminError;
import com.sparrow.security.admin.protocol.param.ResourceParam;
import com.sparrow.security.admin.protocol.param.ResourceSortParam;
import com.sparrow.security.admin.protocol.query.ResourceQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ResourceService {
    @Inject
    private ResourceRepository resourceRepository;

    public void validateSaveResource(ResourceParam resourceParam) {

    }

    public Long saveResource(ResourceParam resourceParam) {
        this.validateSaveResource(resourceParam);
        //新parent的最大序号
        int maxSort = this.resourceRepository.maxSort(resourceParam.getParentId());

        if (resourceParam.getId() == null) {
            resourceParam.setSort(maxSort);
            this.resourceRepository.save(resourceParam);
            return resourceParam.getId();
        }
        ResourceBO originResource = this.resourceRepository.getResource(resourceParam.getId());
        //如果resource 移动了,则在新parent 中排在最后位置
        if (!originResource.getParentId().equals(resourceParam.getParentId())) {
            resourceParam.setSort(maxSort);
            this.resourceRepository.resort(originResource.getParentId(), originResource.getSort());
        }
        this.resourceRepository.save(resourceParam);
        return resourceParam.getId();
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

    public Integer sort(ResourceSortParam sortParam) throws BusinessException {
        Asserts.isTrue(sortParam.getId() == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        Asserts.isTrue(sortParam.getTarget() == null, SecurityAdminError.RESOURCE_SORT_TARGET_IS_EMPTY);
        return this.resourceRepository.sort(sortParam);
    }

    public List<ResourceBO> queryResources(ResourceQuery resourceQuery) {
        return this.resourceRepository.queryResources(resourceQuery);
    }

    public List<ResourceBO> queryAllEnableResources() {
        return this.resourceRepository.queryAllEnableResources();
    }

    public ResourceBO getResource(Long resourceId) throws BusinessException {
        Asserts.isTrue(resourceId == null, SecurityAdminError.RESOURCE_ID_IS_EMPTY);
        return this.resourceRepository.getResource(resourceId);
    }
}
