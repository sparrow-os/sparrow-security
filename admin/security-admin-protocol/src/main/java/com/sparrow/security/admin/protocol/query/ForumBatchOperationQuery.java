package com.sparrow.security.admin.protocol.query;

public class ForumBatchOperationQuery extends ForumQuery{
    private String forumIds;

    public String getForumIds() {
        return forumIds;
    }

    public void setForumIds(String forumIds) {
        this.forumIds = forumIds;
    }
}
