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
package com.sparrow.security.admin.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.po.Permission;
import com.sparrow.security.admin.dao.query.PermissionDBPagerQuery;
import java.util.*;

import com.sparrow.protocol.enums.StatusRecord;

public interface PermissionDAO extends DaoSupport<Permission, Long> {
    List<Permission> queryPermissions(PermissionDBPagerQuery permissionPagerQuery);

    Long countPermission(PermissionDBPagerQuery permissionPagerQuery);
    
    List<Permission> queryChildren(PermissionDBPagerQuery permissionPagerQuery);
    Set<Long> getParentIdsHavingChildren(Collection<Long> parentIds,StatusRecord statusRecord);
    

}