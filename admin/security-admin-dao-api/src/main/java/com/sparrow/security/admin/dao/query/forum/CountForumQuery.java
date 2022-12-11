package com.sparrow.security.admin.dao.query.forum;

import java.util.Date;

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

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
