package com.sparrow.security.admin.protocol.query;

import com.sparrow.protocol.pager.SimplePager;
import java.util.Date;

public class ForumQuery extends SimplePager {
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