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
package com.sparrow.coding.protocol;

import com.sparrow.protocol.BO;
import com.sparrow.protocol.enums.StatusRecord;

public class TTableConfigBO implements BO {
    private Long id; 
private String primaryKey; 
private String tableName; 
private String className; 
private String description; 
private Boolean checkable; 
private Boolean rowMenu; 
private Boolean columnFilter; 
private Boolean statusCommand; 
private String columnConfigs; 
private String createUserName; 
private Long createUserId; 
private Long modifiedUserId; 
private String modifiedUserName; 
private Long gmtCreate; 
private Long gmtModified; 
public Long getId(){
 return this.id;
}
public void setId(Long id){
this.id=id;
}
public String getPrimaryKey(){
 return this.primaryKey;
}
public void setPrimaryKey(String primaryKey){
this.primaryKey=primaryKey;
}
public String getTableName(){
 return this.tableName;
}
public void setTableName(String tableName){
this.tableName=tableName;
}
public String getClassName(){
 return this.className;
}
public void setClassName(String className){
this.className=className;
}
public String getDescription(){
 return this.description;
}
public void setDescription(String description){
this.description=description;
}
public Boolean getCheckable(){
 return this.checkable;
}
public void setCheckable(Boolean checkable){
this.checkable=checkable;
}
public Boolean getRowMenu(){
 return this.rowMenu;
}
public void setRowMenu(Boolean rowMenu){
this.rowMenu=rowMenu;
}
public Boolean getColumnFilter(){
 return this.columnFilter;
}
public void setColumnFilter(Boolean columnFilter){
this.columnFilter=columnFilter;
}
public Boolean getStatusCommand(){
 return this.statusCommand;
}
public void setStatusCommand(Boolean statusCommand){
this.statusCommand=statusCommand;
}
public String getColumnConfigs(){
 return this.columnConfigs;
}
public void setColumnConfigs(String columnConfigs){
this.columnConfigs=columnConfigs;
}
public String getCreateUserName(){
 return this.createUserName;
}
public void setCreateUserName(String createUserName){
this.createUserName=createUserName;
}
public Long getCreateUserId(){
 return this.createUserId;
}
public void setCreateUserId(Long createUserId){
this.createUserId=createUserId;
}
public Long getModifiedUserId(){
 return this.modifiedUserId;
}
public void setModifiedUserId(Long modifiedUserId){
this.modifiedUserId=modifiedUserId;
}
public String getModifiedUserName(){
 return this.modifiedUserName;
}
public void setModifiedUserName(String modifiedUserName){
this.modifiedUserName=modifiedUserName;
}
public Long getGmtCreate(){
 return this.gmtCreate;
}
public void setGmtCreate(Long gmtCreate){
this.gmtCreate=gmtCreate;
}
public Long getGmtModified(){
 return this.gmtModified;
}
public void setGmtModified(Long gmtModified){
this.gmtModified=gmtModified;
}

}