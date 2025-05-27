package com.sparrow.security.admin.dao.query.forum;

import lombok.Data;

import java.util.Date;

@Data
public class CountForumQuery {
    public CountForumQuery() {
    }

    public CountForumQuery(CountForumQuery countGroupQuery) {
        this.forumName = countGroupQuery.forumName;
        this.beginDate = countGroupQuery.beginDate;
        this.endDate = countGroupQuery.endDate;
    }

    private String forumName;
    private Date beginDate;
    private Date endDate;
}
