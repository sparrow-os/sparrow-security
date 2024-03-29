package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.ResourceBO;
import com.sparrow.security.admin.dao.query.ResourceDBQuery;
import com.sparrow.security.po.Resource;
import com.sparrow.security.admin.protocol.param.ResourceParam;
import com.sparrow.security.admin.protocol.query.ResourceQuery;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import com.sparrow.utility.CollectionsUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;

@Named
public class ResourceConverter implements Param2POConverter<ResourceParam, Resource>, PO2BOConverter<ResourceBO, Resource> {

    public ResourceDBQuery toDBQuery(ResourceQuery query) {
        ResourceDBQuery dbQuery = new ResourceDBQuery();
        BeanUtility.copyProperties(query, dbQuery);
        return dbQuery;
    }

    @Override public ResourceBO po2bo(Resource resource) {
        ResourceBO resourceBo = new ResourceBO();
        BeanUtility.copyProperties(resource, resourceBo);
        return resourceBo;
    }

    @Override public List<ResourceBO> poList2BoList(List<Resource> list) {
        if (CollectionsUtility.isNullOrEmpty(list)) {
            return Collections.emptyList();
        }
        List<ResourceBO> resources = new ArrayList<>(list.size());
        for (Resource resource : list) {
            resources.add(this.po2bo(resource));
        }
        return resources;
    }

    @Override public Resource param2po(ResourceParam resourceParam) {
        Resource resource = new Resource();
        BeanUtility.copyProperties(resourceParam, resource);
        resource.setStatus(StatusRecord.ENABLE);
        LoginUser loginUser = ThreadContext.getLoginToken();
        resource.setCreateUserId(loginUser.getUserId());
        resource.setModifiedUserId(loginUser.getUserId());
        resource.setGmtCreate(System.currentTimeMillis());
        resource.setGmtModified(resource.getGmtCreate());

        return resource;
    }
}
