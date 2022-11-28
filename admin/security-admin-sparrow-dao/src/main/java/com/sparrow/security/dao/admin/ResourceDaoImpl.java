package com.sparrow.security.dao.admin;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.dao.admin.query.ResourceDBQuery;
import com.sparrow.security.po.Resource;
import java.util.List;
import javax.inject.Named;

@Named
public class ResourceDaoImpl extends ORMStrategy<Resource, Long> implements ResourceDAO {
    @Override public Integer sort(Long resourceId, int sort) {
        return null;
    }

    @Override public List<Resource> queryResources(ResourceDBQuery resourceQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        BooleanCriteria booleanCriteria = BooleanCriteria.criteria(
            Criteria.field("resource.appId").equal(resourceQuery.getAppId()))
            .and(Criteria.field("resource.status").equal(resourceQuery.getStatus())
            );
        searchCriteria.setWhere(booleanCriteria);
        return this.getList(searchCriteria);
    }
}
