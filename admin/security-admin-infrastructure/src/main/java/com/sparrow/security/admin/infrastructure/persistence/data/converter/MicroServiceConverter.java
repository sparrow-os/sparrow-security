package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.MicroServiceBO;
import com.sparrow.security.admin.dao.query.micro.service.CountMicroServiceQuery;
import com.sparrow.security.admin.dao.query.micro.service.PagerMicroServiceQuery;
import com.sparrow.security.po.MicroService;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;
import com.sparrow.security.admin.protocol.query.MicroServiceQuery;
import com.sparrow.protocol.dao.PagerQuery;

import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class MicroServiceConverter implements Param2POConverter<MicroServiceParam, MicroService>, PO2BOConverter<MicroServiceBO, MicroService> {
   
   
    public PagerMicroServiceQuery toDbPagerQuery(MicroServiceQuery microServiceQuery) {
           if (microServiceQuery == null) {
               PagerMicroServiceQuery pagerMicroServiceQuery = new PagerMicroServiceQuery();
               pagerMicroServiceQuery.setPager(new PagerQuery());
               return pagerMicroServiceQuery;
           }
           PagerQuery pagerQuery = new PagerQuery(microServiceQuery.getPageSize(), microServiceQuery.getCurrentPageIndex());
           PagerMicroServiceQuery pagerMicroServiceQuery = new PagerMicroServiceQuery();
           this.fullProperties(microServiceQuery, pagerMicroServiceQuery);
           pagerMicroServiceQuery.setPager(pagerQuery);
           return pagerMicroServiceQuery;
       }
   
       private void fullProperties(MicroServiceQuery microServiceQuery, CountMicroServiceQuery countMicroServiceQuery) {
           if (microServiceQuery == null) {
               return;
           }
           countMicroServiceQuery.setName(microServiceQuery.getName());
           countMicroServiceQuery.setBeginDate(microServiceQuery.getBeginDate());
           countMicroServiceQuery.setEndDate(microServiceQuery.getEndDate());
       }
   
       public CountMicroServiceQuery toDbCountQuery(MicroServiceQuery microServiceQuery) {
           CountMicroServiceQuery countMicroServiceQuery = new CountMicroServiceQuery();
           if (microServiceQuery == null) {
               return countMicroServiceQuery;
           }
           this.fullProperties(microServiceQuery, countMicroServiceQuery);
           return countMicroServiceQuery;
       }


    @Override public MicroService param2po(MicroServiceParam param) {
        MicroService microService = new MicroService();
        BeanUtility.copyProperties(param, microService);
        microService.setCreateTime(System.currentTimeMillis());
        microService.setUpdateTime(microService.getCreateTime());
        microService.setCreateUserId(0L);
        microService.setUpdateUserId(0L);
        microService.setStatus(StatusRecord.ENABLE);
        if (microService.getRemark() == null) {
            microService.setRemark("");
        }
        return microService;
    }

    @Override public MicroServiceBO po2bo(MicroService microService) {
        MicroServiceBO microServiceBO = new MicroServiceBO();
        BeanUtility.copyProperties(microService, microServiceBO);
        return microServiceBO;
    }

    @Override public List<MicroServiceBO> poList2BoList(List<MicroService> list) {
        List<MicroServiceBO> microServiceBos = new ArrayList<>(list.size());
        for (MicroService microService : list) {
            microServiceBos.add(this.po2bo(microService));
        }
        return microServiceBos;
    }
}