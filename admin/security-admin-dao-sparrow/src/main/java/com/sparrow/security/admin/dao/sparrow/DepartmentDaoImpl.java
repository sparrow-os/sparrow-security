/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparrow.security.admin.dao.sparrow;

import com.sparrow.context.SessionContext;
import com.sparrow.orm.query.BooleanCriteria;
import com.sparrow.orm.query.Criteria;
import com.sparrow.orm.query.OrderCriteria;
import com.sparrow.orm.query.SearchCriteria;
import com.sparrow.orm.template.impl.ORMStrategy;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.DepartmentDAO;
import com.sparrow.security.admin.dao.query.DepartmentDBPagerQuery;
import com.sparrow.security.po.Department;
import jakarta.inject.Named;

import java.util.List;


@Named
public class DepartmentDaoImpl extends ORMStrategy<Department, Long> implements DepartmentDAO {
    @Override
    public List<Department> queryDepartments(DepartmentDBPagerQuery pagerDepartmentQuery) {
        SearchCriteria searchCriteria = new SearchCriteria(pagerDepartmentQuery);
        searchCriteria.setWhere(this.generateCriteria(pagerDepartmentQuery));
        searchCriteria.setOrderCriteria(OrderCriteria.desc(Department::getId));
        return this.getList(searchCriteria);
    }

    private BooleanCriteria generateCriteria(DepartmentDBPagerQuery departmentQuery) {
        BooleanCriteria booleanCriteria = BooleanCriteria.criteria(Criteria.field(Department::getCreateUserId).equal(SessionContext.getLoginUser().getUserId()));
        if (departmentQuery.getStatus() != null && departmentQuery.getStatus() >= 0) {
            booleanCriteria.and(Criteria.field(Department::getStatus).equal(StatusRecord.valueOf(departmentQuery.getStatus())));
        }
        return booleanCriteria;
    }

    @Override
    public Long countDepartment(DepartmentDBPagerQuery departmentPagerQuery) {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setWhere(this.generateCriteria(departmentPagerQuery));
        return this.getCount(searchCriteria);
    }
}
