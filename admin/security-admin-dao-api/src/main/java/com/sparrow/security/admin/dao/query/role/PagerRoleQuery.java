package com.sparrow.security.admin.dao.query.role;

import com.sparrow.protocol.dao.PagerQuery;
import com.sparrow.security.admin.dao.query.role.CountRoleQuery;

public class PagerRoleQuery extends CountRoleQuery {

    public PagerRoleQuery() {
    }

    private PagerQuery pager;

    public PagerQuery getPager() {
        return pager;
    }

    public void setPager(PagerQuery pager) {
        this.pager = pager;
    }
}
