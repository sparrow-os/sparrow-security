package com.sparrow.security.admin.repository;

import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.protocol.param.ForumParam;
import com.sparrow.security.admin.protocol.query.ForumQuery;
import java.util.List;

public interface ForumRepository {

    Long save(ForumParam appParam);

    int delete(String forumIds);

    int disable(String forumIds);

    int enable(String forumIds);

    ForumBO getForum(Long forumId);

    List<ForumBO> queryForums(ForumQuery forumQuery);

    Long getForumCount(ForumQuery forumQuery);

}