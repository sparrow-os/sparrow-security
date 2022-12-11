package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.exception.Asserts;
import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.OrderCriteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.query.UpdateCriteria;
import com.sparrow.orm.query.UpdateSetClausePair;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.protocol.dao.AggregateCriteria;
import com.sparrow.protocol.dao.enums.Aggregate;
import com.sparrow.security.admin.dao.ResourceDAO;
import com.sparrow.security.admin.dao.query.ResourceDBQuery;
import com.sparrow.security.po.Resource;
import java.util.List;
import javax.inject.Named;

@Named
public class ResourceDaoImpl extends ORMStrategy<Resource, Long> implements ResourceDAO {
    @Override public Integer sort(Long resourceId, int targetSort) {
        Resource resource = this.getEntity(resourceId);
        Asserts.illegalArgument(resource == null, "resource " + resourceId + " is found");

        int originSort = resource.getSort();
        UpdateCriteria updateCriteria = new UpdateCriteria();
        BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field("resource.parentId").equal(resource.getParentId()));
        /**
         * 下移
         * 比如10移至15
         * 11，12，13，14，15 分别减1变为10,11,12,13,14
         * 10--15
         */
        if (originSort < targetSort) {
            booleanCriteria.and(Criteria.field("resource.sort").greaterThan(originSort)).and(Criteria.field("resource.sort").lessThanEqual(targetSort));
            updateCriteria.set(UpdateSetClausePair.field("resource.sort").add(-1));
        } else {
            // 上移同理F
            booleanCriteria.and(Criteria.field("resource.sort").greaterThanEqual(targetSort)).and(Criteria.field("resource.sort").lessThan(originSort));
            updateCriteria.set(UpdateSetClausePair.field("resource.sort").add(1));
        }
        updateCriteria.setWhere(booleanCriteria);
        this.update(updateCriteria);
        updateCriteria = new UpdateCriteria();
        updateCriteria.setWhere(BooleanCriteria.criteria(Criteria.field("resource.id").equal(resourceId)));
        updateCriteria.set(UpdateSetClausePair.field("resource.sort").equal(targetSort));
        return this.update(updateCriteria);
    }

    @Override public Integer resort(Long parentResourceId, Integer originSort) {
        UpdateCriteria updateCriteria = new UpdateCriteria();
        BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field("resource.parentId").equal(parentResourceId));
        /**
         * 原位置后边的所有资源向前顺延
         * 比如1.2.3....15 10被移走
         * 11，12，13，14，15 分别减1变为10,11,12,13,14
         */
        booleanCriteria.and(Criteria.field("resource.sort").greaterThan(originSort));
        updateCriteria.set(UpdateSetClausePair.field("resource.sort").add(-1));
        updateCriteria.setWhere(booleanCriteria);
        return this.update(updateCriteria);
    }

    @Override public Integer maxSort(Long parentResourceId) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setAggregate(new AggregateCriteria(Aggregate.MAX, "resource.sort"));
        searchCriteria.setWhere(Criteria.field("resource.parentId").equal(parentResourceId));
        Integer sort = this.getAggregateByCriteria(searchCriteria);
        if (sort == null) {
            sort = 0;
        }
        return sort + 1;
    }

    @Override public List<Resource> queryResources(ResourceDBQuery resourceQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        BooleanCriteria booleanCriteria = BooleanCriteria.criteria(
            Criteria.field("resource.appId").equal(resourceQuery.getAppId()))
            .and(Criteria.field("resource.status").equal(resourceQuery.getStatus())
            );
        searchCriteria.addOrderCriteria(OrderCriteria.asc("resource.parentId"));
        searchCriteria.addOrderCriteria(OrderCriteria.asc("resource.sort"));
        searchCriteria.setWhere(booleanCriteria);
        return this.getList(searchCriteria);
    }
}
