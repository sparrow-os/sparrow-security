package com.sparrow.security.dao.admin.query;

import com.sparrow.protocol.dao.PagerQuery;

public class PagerGroupQuery extends CountGroupQuery {

    public PagerGroupQuery() {
    }

    private PagerQuery pager;

    public PagerQuery getPager() {
        return pager;
    }

    public void setPager(PagerQuery pager) {
        this.pager = pager;
    }
}
