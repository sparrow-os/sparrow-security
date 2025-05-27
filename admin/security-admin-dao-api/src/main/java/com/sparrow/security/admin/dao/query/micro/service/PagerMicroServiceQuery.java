package com.sparrow.security.admin.dao.query.micro.service;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import lombok.Data;

@Data
public class PagerMicroServiceQuery extends CountMicroServiceQuery {
    private DatabasePagerQuery pager;

    public PagerMicroServiceQuery() {
        this.pager = new DatabasePagerQuery();
    }
}
