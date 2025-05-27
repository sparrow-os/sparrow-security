package com.sparrow.security.admin.dao.query.forum;


import com.sparrow.protocol.dao.DatabasePagerQuery;
import lombok.Data;

@Data
public class PagerForumQuery extends CountForumQuery {
    public PagerForumQuery() {
        this.pager = new DatabasePagerQuery();
    }
    private DatabasePagerQuery pager;

}
