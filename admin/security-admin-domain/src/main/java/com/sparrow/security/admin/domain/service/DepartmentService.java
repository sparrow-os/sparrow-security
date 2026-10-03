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

package com.sparrow.security.admin.domain.service;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.ListRecordTotalBO;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.security.admin.domain.bo.DepartmentBO;
import com.sparrow.security.admin.protocol.param.DepartmentParam;
import com.sparrow.security.admin.protocol.query.DepartmentQuery;
import com.sparrow.security.admin.repository.DepartmentRepository;
import com.sparrow.utility.CollectionsUtility;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;
import java.util.Set;


@Named
public class DepartmentService {
    @Inject
    private DepartmentRepository departmentRepository;

    private void validateSaveDepartment(DepartmentParam departmentParam) throws BusinessException {
        //Asserts.isTrue(StringUtility.isNullOrEmpty(departmentParam.getName()), SecurityAdminError.NAME_IS_EMPTY, DepartmentSuffix.name);
    }

    public Long saveDepartment(DepartmentParam departmentParam) throws BusinessException {
        this.validateSaveDepartment(departmentParam);
        return this.departmentRepository.save(departmentParam);
    }

    public Integer deleteDepartment(Set<Long> departmentIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(departmentIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.departmentRepository.delete(departmentIds);
    }

    public Integer enableDepartment(Set<Long> departmentIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(departmentIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.departmentRepository.enable(departmentIds);
    }

    public Integer disableDepartment(Set<Long> departmentIds) throws BusinessException {
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(departmentIds), SparrowError.GLOBAL_PARAMETER_NULL);
        return this.departmentRepository.disable(departmentIds);
    }

    public ListRecordTotalBO<DepartmentBO> queryAllDepartment() {
        return queryDepartment(null);
    }

    public ListRecordTotalBO<DepartmentBO> queryDepartment(DepartmentQuery departmentQuery) {
        Long totalRecord = this.departmentRepository.getDepartmentCount(departmentQuery);
        List<DepartmentBO> departmentBoList = null;
        if (totalRecord > 0) {
            departmentBoList = this.departmentRepository.queryDepartments(departmentQuery);
        }
        return new ListRecordTotalBO<>(departmentBoList, totalRecord);
    }

    public DepartmentBO getDepartment(Long departmentId) throws BusinessException {
        Asserts.isTrue(departmentId == null, SparrowError.GLOBAL_PARAMETER_NULL);
        return this.departmentRepository.getDepartment(departmentId);
    }

}
