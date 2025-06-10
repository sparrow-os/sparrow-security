package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.MicroServiceDAO;
import com.sparrow.security.admin.dao.query.micro.service.CountMicroServiceQuery;
import com.sparrow.security.admin.dao.query.micro.service.PagerMicroServiceQuery;
import com.sparrow.security.po.MicroService;
import java.util.List;
import javax.inject.Named;

@Named
public class MicroServiceDaoImpl extends ORMStrategy<MicroService, Long> implements MicroServiceDAO {
    @Override public List<MicroService> queryMicroServices(PagerMicroServiceQuery pagerMicroServiceQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerMicroServiceQuery.getPager());
        searchCriteria.setWhere(this.generateCriteria(pagerMicroServiceQuery));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(CountMicroServiceQuery countMicroServiceQuery) {
        Long startTime=null;
        if(countMicroServiceQuery.getBeginDate()!=null){
            startTime=countMicroServiceQuery.getBeginDate().getTime();
        }

        Long endTime=null;
        if(countMicroServiceQuery.getEndDate()!=null){
            endTime=countMicroServiceQuery.getEndDate().getTime();
        }

        return BooleanCriteria.criteria(
            Criteria.field("microService.microServiceName").equal(countMicroServiceQuery.getName()))
            .and(Criteria.field("microService.createTime").greaterThan(startTime))
            .and(Criteria.field("microService.createTime").lessThan(endTime));
    }

    @Override public Long countMicroService(CountMicroServiceQuery microServicePagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(microServicePagerQuery));
        return this.getCount(searchCriteria);
    }
}