package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.AppDAO;
import com.sparrow.security.admin.dao.query.app.CountAppQuery;
import com.sparrow.security.admin.dao.query.app.PagerAppQuery;
import com.sparrow.security.admin.dao.query.group.CountGroupQuery;
import com.sparrow.security.po.App;
import java.util.List;
import javax.inject.Named;

@Named
public class AppDaoImpl extends ORMStrategy<App, Long> implements AppDAO {

    private BooleanCriteria generateCriteria(CountAppQuery countAppQuery) {
        Long startTime = null;
        if (countAppQuery.getBeginDate() != null) {
            startTime = countAppQuery.getBeginDate().getTime();
        }

        Long endTime = null;
        if (countAppQuery.getEndDate() != null) {
            endTime = countAppQuery.getEndDate().getTime();
        }

        return BooleanCriteria.criteria(
            Criteria.field("app.name").contains(countAppQuery.getName()))
            .and(Criteria.field("app.createTime").greaterThan(startTime))
            .and(Criteria.field("app.createTime").lessThan(endTime))
            .and(Criteria.field("app.status").equal(countAppQuery.getStatus()));
    }

    @Override public List<App> queryApps(PagerAppQuery appPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(appPagerQuery.getPager());
        searchCriteria.setWhere(this.generateCriteria(appPagerQuery));
        return this.getList(searchCriteria);
    }

    @Override public Long countApp(CountAppQuery countAppQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(countAppQuery));
        return this.getCount(searchCriteria);
    }

    @Override public List<App> queryAllEnableApps() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(Criteria.field("app.status").equal(StatusRecord.ENABLE));
        return this.getList(searchCriteria);
    }
}
