package com.sparrow.security.admin.dao.query.micro.service;

import com.sparrow.protocol.dao.PagerQuery;

public class PagerMicroServiceQuery extends CountMicroServiceQuery {
    private PagerQuery pager;

    public PagerQuery getPager() {
        return pager;
    }

    public void setPager(PagerQuery pager) {
        this.pager = pager;
    }
}
