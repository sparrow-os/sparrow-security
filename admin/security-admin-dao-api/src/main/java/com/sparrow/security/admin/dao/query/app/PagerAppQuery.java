package com.sparrow.security.admin.dao.query.app;

import com.sparrow.protocol.dao.PagerQuery;

public class PagerAppQuery extends CountAppQuery {

    public PagerAppQuery() {
    }

    private PagerQuery pager;

    public PagerQuery getPager() {
        return pager;
    }

    public void setPager(PagerQuery pager) {
        this.pager = pager;
    }
}
