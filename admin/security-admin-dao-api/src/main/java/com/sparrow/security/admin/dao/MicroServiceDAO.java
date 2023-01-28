package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.po.MicroService;
import com.sparrow.security.admin.dao.query.micro.service.CountMicroServiceQuery;
import com.sparrow.security.admin.dao.query.micro.service.PagerMicroServiceQuery;
import java.util.List;

public interface MicroServiceDAO extends DaoSupport<MicroService, Long> {
    List<MicroService> queryMicroServices(PagerMicroServiceQuery microServicePagerQuery);

    Long countMicroService(CountMicroServiceQuery countMicroServiceQuery);
}