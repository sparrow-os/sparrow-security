package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.ForumDAO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.ForumConverter;
import com.sparrow.security.po.Forum;
import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.protocol.param.ForumParam;
import com.sparrow.security.admin.repository.ForumRepository;
import com.sparrow.security.admin.protocol.query.ForumQuery;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ForumRepositoryImpl implements ForumRepository {
    @Inject
    private ForumConverter forumConverter;

    @Inject
    private ForumDAO forumDao;

    @Override public Long save(ForumParam forumParam) {
        Forum forum = this.forumConverter.param2po(forumParam);
        if (forum.getForumId() != null) {
            this.forumDao.update(forum);
            return forum.getForumId();
        }
        return this.forumDao.insert(forum);
    }

    @Override public int delete(String forumIds) {
        StatusCriteria statusCriteria = new StatusCriteria(forumIds, StatusRecord.DESTROYED);
        return this.forumDao.changeStatus(statusCriteria);
    }

    @Override public int disable(String forumIds) {
        StatusCriteria statusCriteria = new StatusCriteria(forumIds, StatusRecord.DISABLE);
        return this.forumDao.changeStatus(statusCriteria);
    }

    @Override public int enable(String forumIds) {
        StatusCriteria statusCriteria = new StatusCriteria(forumIds, StatusRecord.ENABLE);
        return this.forumDao.changeStatus(statusCriteria);
    }

    @Override public ForumBO getForum(Long forumId) {
        Forum forum = this.forumDao.getEntity(forumId);

        return this.forumConverter.po2bo(forum);
    }

    @Override public List<ForumBO> queryForums(ForumQuery forumQuery) {
        List<Forum> forumList = this.forumDao.queryForums(this.forumConverter.toDbPagerQuery(forumQuery));
        return this.forumConverter.poList2BoList(forumList);
    }

    @Override public Long getForumCount(ForumQuery forumQuery) {
        return this.forumDao.countForum(this.forumConverter.toDbCountQuery(forumQuery));
    }
}