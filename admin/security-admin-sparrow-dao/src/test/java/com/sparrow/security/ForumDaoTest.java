package com.sparrow.security;

import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.dao.admin.ForumDAO;
import com.sparrow.security.po.Forum;
import org.junit.Test;

public class ForumDaoTest extends BaseTest {
    @Test
    public void getForum() {
        ForumDAO forumDao = container.getBean("forumDao");
        Forum forum = forumDao.getEntity(1L);
        forumDao.delete(1L);
        forum = forumDao.getEntity(1L);
    }

    @Test
    public void forumTest() {
        ForumDAO forumDao = container.getBean("forumDao");

        Forum forum = new Forum();
        forum.setForumId(0L);
        forum.setResourceId(0L);
        forum.setListUrl("list url");
        forum.setDetailUrl("details url");
        forum.setPlaceholderUrl("placeholder url");
        forum.setNewUrl("new url");
        forum.setManager("manager");
        forum.setUploadKey("upload key");
        forum.setCover("cover");
        forum.setMaxRecordCount(0);
        forum.setCreateUserId(0L);
        forum.setUpdateUserId(0L);
        forum.setCreateTime(0L);
        forum.setUpdateTime(0L);
        forum.setRemark("remarks");
        forum.setStatus(StatusRecord.DISABLE);
        forumDao.insert(forum);
    }
}
