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
package com.sparrow.security.admin.domain.bo;

import com.sparrow.protocol.BO;
import com.sparrow.protocol.enums.StatusRecord;

public class SparrowExampleBO implements BO {
    private Long id; 
private String avatar; 
private String userName; 
private String password; 
private String age; 
private String email; 
private String confirmPassword; 
private String idCard; 
private String mobile; 
private String tel; 
private String name; 
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
public String getAvatar(){
 return this.avatar;
}
public void setAvatar(String avatar){
this.avatar=avatar;
}
public String getUserName(){
 return this.userName;
}
public void setUserName(String userName){
this.userName=userName;
}
public String getPassword(){
 return this.password;
}
public void setPassword(String password){
this.password=password;
}
public String getAge(){
 return this.age;
}
public void setAge(String age){
this.age=age;
}
public String getEmail(){
 return this.email;
}
public void setEmail(String email){
this.email=email;
}
public String getConfirmPassword(){
 return this.confirmPassword;
}
public void setConfirmPassword(String confirmPassword){
this.confirmPassword=confirmPassword;
}
public String getIdCard(){
 return this.idCard;
}
public void setIdCard(String idCard){
this.idCard=idCard;
}
public String getMobile(){
 return this.mobile;
}
public void setMobile(String mobile){
this.mobile=mobile;
}
public String getTel(){
 return this.tel;
}
public void setTel(String tel){
this.tel=tel;
}
public String getName(){
 return this.name;
}
public void setName(String name){
this.name=name;
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