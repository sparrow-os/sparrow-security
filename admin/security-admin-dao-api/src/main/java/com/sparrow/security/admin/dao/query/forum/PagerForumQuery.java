package com.sparrow.security.admin.dao.query.forum;

import com.sparrow.protocol.dao.PagerQuery;

public class PagerForumQuery extends CountForumQuery {

    public PagerForumQuery() {
    }

    private PagerQuery pager;

    public PagerQuery getPager() {
        return pager;
    }

    public void setPager(PagerQuery pager) {
        this.pager = pager;
    }
}
