package com.sparrow.security.admin.dao.query.role;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import lombok.Data;

@Data
public class PagerRoleQuery extends CountRoleQuery {

    public PagerRoleQuery() {
    }

    private DatabasePagerQuery pager;

}
