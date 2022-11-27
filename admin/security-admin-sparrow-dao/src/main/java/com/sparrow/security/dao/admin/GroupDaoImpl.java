package com.sparrow.security.dao.admin;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.dao.admin.query.CountGroupQuery;
import com.sparrow.security.dao.admin.query.PagerGroupQuery;
import com.sparrow.security.po.Group;
import java.util.List;
import javax.inject.Named;

@Named
public class GroupDaoImpl extends ORMStrategy<Group, Long> implements GroupDAO {
    @Override public List<Group> queryGroups(PagerGroupQuery pagerGroupQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerGroupQuery.getPager());
        searchCriteria.setWhere(this.generateCriteria(pagerGroupQuery));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(CountGroupQuery countGroupQuery) {
        Long startTime=null;
        if(countGroupQuery.getBeginDate()!=null){
            startTime=countGroupQuery.getBeginDate().getTime();
        }

        Long endTime=null;
        if(countGroupQuery.getEndDate()!=null){
            endTime=countGroupQuery.getEndDate().getTime();
        }

        return BooleanCriteria.criteria(
            Criteria.field("group.groupName").equal(countGroupQuery.getGroupName()))
            .and(Criteria.field("group.createTime").greaterThan(startTime))
            .and(Criteria.field("group.createTime").lessThan(endTime));
    }

    @Override public Long countGroup(CountGroupQuery groupPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(groupPagerQuery));
        return this.getCount(searchCriteria);
    }
}
