package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.admin.dao.query.forum.CountForumQuery;
import com.sparrow.security.admin.dao.query.forum.PagerForumQuery;
import com.sparrow.security.po.Forum;
import java.util.List;

public interface ForumDAO extends DaoSupport<Forum, Long> {
    List<Forum> queryForums(PagerForumQuery forumPagerQuery);

    Long countForum(CountForumQuery countForumQuery);
}