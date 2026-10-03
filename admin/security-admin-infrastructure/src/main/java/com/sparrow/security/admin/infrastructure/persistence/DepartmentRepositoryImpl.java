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

package com.sparrow.security.admin.infrastructure.persistence;

import com.sparrow.protocol.dao.StatusCriteria;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.security.admin.dao.DepartmentDAO;
import com.sparrow.security.admin.domain.bo.DepartmentBO;
import com.sparrow.security.admin.infrastructure.persistence.data.converter.DepartmentConverter;
import com.sparrow.security.admin.protocol.param.DepartmentParam;
import com.sparrow.security.admin.protocol.query.DepartmentQuery;
import com.sparrow.security.admin.repository.DepartmentRepository;
import com.sparrow.security.po.Department;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.Set;

@Named
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @Inject
    private DepartmentConverter departmentConverter;

    @Inject
    private DepartmentDAO departmentDao;

    @Override
    public Long save(DepartmentParam departmentParam) {
        Department department = this.departmentConverter.param2po(departmentParam);
        if (department.getId() != null) {
            this.departmentDao.update(department);
            return department.getId();
        }
        this.departmentDao.insert(department);
        return department.getId();
    }

    @Override
    public Integer delete(Set<Long> departmentIds) {
        return this.departmentDao.batchDelete(departmentIds);
    }

    @Override
    public Integer disable(Set<Long> departmentIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(departmentIds, StatusRecord.DISABLE);
        this.departmentConverter.convertStatus(statusCriteria);
        return this.departmentDao.changeStatus(statusCriteria);
    }

    @Override
    public Integer enable(Set<Long> departmentIds) {
        StatusCriteria<Long> statusCriteria = new StatusCriteria(departmentIds, StatusRecord.ENABLE);
        this.departmentConverter.convertStatus(statusCriteria);
        return this.departmentDao.changeStatus(statusCriteria);
    }

    @Override
    public DepartmentBO getDepartment(Long departmentId) {
        Department department = this.departmentDao.getEntity(departmentId);
        return this.departmentConverter.po2bo(department);
    }

    @Override
    public List<DepartmentBO> queryDepartments(DepartmentQuery departmentQuery) {
        List<Department> departmentList = this.departmentDao.queryDepartments(this.departmentConverter.toDbPagerQuery(departmentQuery));
        return this.departmentConverter.poList2BoList(departmentList);
    }

    @Override
    public Long getDepartmentCount(DepartmentQuery departmentQuery) {
        return this.departmentDao.countDepartment(this.departmentConverter.toDbPagerQuery(departmentQuery));
    }
}
