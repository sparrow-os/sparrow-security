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

package com.sparrow.security.admin.infrastructure.persistence.data.converter;

import com.sparrow.context.SessionContext;
import com.sparrow.protocol.BeanCopier;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.security.admin.dao.query.DepartmentDBPagerQuery;
import com.sparrow.security.admin.domain.bo.DepartmentBO;
import com.sparrow.security.admin.protocol.param.DepartmentParam;
import com.sparrow.security.admin.protocol.query.DepartmentQuery;
import com.sparrow.security.po.Department;
import com.sparrow.support.converter.PO2BOConverter;
import com.sparrow.support.converter.POInitUtils;
import com.sparrow.support.converter.Param2POConverter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;


@Named
public class DepartmentConverter implements Param2POConverter<DepartmentParam, Department>, PO2BOConverter<DepartmentBO, Department> {

    @Inject
    private BeanCopier beanCopier;

    public DepartmentDBPagerQuery toDbPagerQuery(DepartmentQuery departmentQuery) {
        if (departmentQuery == null) {
            return new DepartmentDBPagerQuery();
        }
        DepartmentDBPagerQuery department = new DepartmentDBPagerQuery();
        beanCopier.copyProperties(departmentQuery, department);
        return department;
    }

    @Override
    public Department param2po(DepartmentParam param) {
        Department department = new Department();
        beanCopier.copyProperties(param, department);
        POInitUtils.init(department);

        return department;
    }

    @Override
    public DepartmentBO po2bo(Department department) {
        DepartmentBO departmentBO = new DepartmentBO();
        beanCopier.copyProperties(department, departmentBO);

        return departmentBO;
    }

    @Override
    public List<DepartmentBO> poList2BoList(List<Department> list) {
        List<DepartmentBO> departmentBos = new ArrayList<>(list.size());
        for (Department department : list) {
            departmentBos.add(this.po2bo(department));
        }
        return departmentBos;
    }

    public void convertStatus(StatusCriteria statusCriteria) {
        LoginUser loginUser = SessionContext.getLoginUser();
        statusCriteria.setModifiedUserName(loginUser.getUserName());
        statusCriteria.setGmtModified(System.currentTimeMillis());
        statusCriteria.setModifiedUserId(loginUser.getUserId());
    }
}
