package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.RoleDAO;
import com.sparrow.security.admin.dao.query.role.CountRoleQuery;
import com.sparrow.security.admin.dao.query.role.PagerRoleQuery;
import com.sparrow.security.po.Role;
import java.util.List;
import javax.inject.Named;

@Named
public class RoleDaoImpl extends ORMStrategy<Role, Long> implements RoleDAO {
    @Override public List<Role> queryRoles(PagerRoleQuery pagerRoleQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerRoleQuery.getPager());
        searchCriteria.setWhere(this.generateCriteria(pagerRoleQuery));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(CountRoleQuery countRoleQuery) {
        Long startTime = null;
        if (countRoleQuery.getBeginDate() != null) {
            startTime = countRoleQuery.getBeginDate().getTime();
        }
        Long endTime = null;
        if (countRoleQuery.getEndDate() != null) {
            endTime = countRoleQuery.getEndDate().getTime();
        }
        return BooleanCriteria.criteria(
            Criteria.field("role.name").equal(countRoleQuery.getRoleName()))
            .and(Criteria.field("role.createTime").greaterThan(startTime))
            .and(Criteria.field("role.createTime").lessThan(endTime))
            .and(Criteria.field("role.status").equal(countRoleQuery.getStatus()));
    }

    @Override public Long countRole(CountRoleQuery countRoleQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(countRoleQuery));
        return this.getCount(searchCriteria);
    }
}
