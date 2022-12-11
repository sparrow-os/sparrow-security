package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.ForumDAO;
import com.sparrow.security.admin.dao.query.forum.CountForumQuery;
import com.sparrow.security.admin.dao.query.forum.PagerForumQuery;
import com.sparrow.security.po.Forum;
import java.util.List;
import javax.inject.Named;

@Named
public class ForumDaoImpl extends ORMStrategy<Forum, Long> implements ForumDAO {
    @Override public List<Forum> queryForums(PagerForumQuery pagerForumQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerForumQuery.getPager());
        searchCriteria.setWhere(this.generateCriteria(pagerForumQuery));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(CountForumQuery countForumQuery) {
        Long startTime=null;
        if(countForumQuery.getBeginDate()!=null){
            startTime=countForumQuery.getBeginDate().getTime();
        }

        Long endTime=null;
        if(countForumQuery.getEndDate()!=null){
            endTime=countForumQuery.getEndDate().getTime();
        }

        return BooleanCriteria.criteria(
            Criteria.field("forum.forumName").equal(countForumQuery.getForumName()))
            .and(Criteria.field("forum.createTime").greaterThan(startTime))
            .and(Criteria.field("forum.createTime").lessThan(endTime));
    }

    @Override public Long countForum(CountForumQuery forumPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(forumPagerQuery));
        return this.getCount(searchCriteria);
    }
}