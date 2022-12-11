package com.sparrow.security.admin.dao.query.group;

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
