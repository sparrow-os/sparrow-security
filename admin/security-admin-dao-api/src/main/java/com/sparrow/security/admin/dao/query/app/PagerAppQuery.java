package com.sparrow.security.admin.dao.query.app;


import com.sparrow.protocol.dao.DatabasePagerQuery;
import lombok.Data;

@Data
public class PagerAppQuery extends CountAppQuery {

    public PagerAppQuery() {
    }

    private DatabasePagerQuery pager;
}
