package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.protocol.dao.PagerQuery;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.bo.ForumBO;
import com.sparrow.security.admin.dao.query.forum.CountForumQuery;
import com.sparrow.security.admin.dao.query.forum.PagerForumQuery;
import com.sparrow.security.admin.protocol.query.ForumQuery;
import com.sparrow.security.po.Forum;
import com.sparrow.security.admin.protocol.param.ForumParam;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.Param2POConverter;
import com.sparrow.utility.BeanUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;

@Named
public class ForumConverter implements Param2POConverter<ForumParam, Forum>, PO2BOConverter<ForumBO, Forum> {

    public PagerForumQuery toDbPagerQuery(ForumQuery forumQuery) {
        if (forumQuery == null) {
            PagerForumQuery pagerForumQuery = new PagerForumQuery();
            pagerForumQuery.setPager(new PagerQuery());
            return pagerForumQuery;
        }
        PagerQuery pagerQuery = new PagerQuery(forumQuery.getPageSize(), forumQuery.getCurrentPageIndex());
        PagerForumQuery pagerForumQuery = new PagerForumQuery();
        this.fullProperties(forumQuery, pagerForumQuery);
        pagerForumQuery.setPager(pagerQuery);
        return pagerForumQuery;
    }

    private void fullProperties(ForumQuery forumQuery, CountForumQuery countForumQuery) {
        if (forumQuery == null) {
            return;
        }
        countForumQuery.setForumName(forumQuery.getForumName());
        countForumQuery.setBeginDate(forumQuery.getBeginDate());
        countForumQuery.setEndDate(forumQuery.getEndDate());
    }

    public CountForumQuery toDbCountQuery(ForumQuery forumQuery) {
        CountForumQuery countForumQuery = new CountForumQuery();
        if (forumQuery == null) {
            return countForumQuery;
        }
        this.fullProperties(forumQuery, countForumQuery);
        return countForumQuery;
    }

    @Override public Forum param2po(ForumParam param) {
        Forum forum = new Forum();
        BeanUtility.copyProperties(param, forum);
        forum.setCreateTime(System.currentTimeMillis());
        forum.setUpdateTime(forum.getCreateTime());
        forum.setCreateUserId(0L);
        forum.setUpdateUserId(0L);
        forum.setStatus(StatusRecord.ENABLE);
        if (forum.getRemark() == null) {
            forum.setRemark("");
        }
        return forum;
    }

    @Override public ForumBO po2bo(Forum forum) {
        ForumBO forumBO = new ForumBO();
        BeanUtility.copyProperties(forum, forumBO);
        return forumBO;
    }

    @Override public List<ForumBO> poList2BoList(List<Forum> list) {
        List<ForumBO> forumBos = new ArrayList<>(list.size());
        for (Forum forum : list) {
            forumBos.add(this.po2bo(forum));
        }
        return forumBos;
    }
}