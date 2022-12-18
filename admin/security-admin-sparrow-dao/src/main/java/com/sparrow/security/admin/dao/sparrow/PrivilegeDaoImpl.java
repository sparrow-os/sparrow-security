package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.security.admin.dao.PrivilegeDAO;
import com.sparrow.security.po.Privilege;
import java.util.List;
import javax.inject.Named;

@Named
public class PrivilegeDaoImpl extends ORMStrategy<Privilege, Long> implements PrivilegeDAO {
    @Override public List<Privilege> queryAllAccessibleResources(Long roleId) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(Criteria.field("privilege.roleId").equal(roleId));
        return this.getList(searchCriteria);
    }

    @Override public Integer deleteByRole(Long roleId) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(Criteria.field("privilege.roleId").equal(roleId));
        return this.delete(searchCriteria);
    }
}
