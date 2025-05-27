package com.sparrow.security.admin.dao.query.group;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import lombok.Data;

@Data
public class PagerGroupQuery extends CountGroupQuery {

    public PagerGroupQuery() {
        this.pager = new DatabasePagerQuery();
    }

    private DatabasePagerQuery pager;
}
