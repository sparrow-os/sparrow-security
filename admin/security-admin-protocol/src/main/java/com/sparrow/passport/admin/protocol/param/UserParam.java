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
package com.sparrow.passport.admin.protocol.param;

import com.sparrow.protocol.Param;
import com.sparrow.protocol.enums.StatusRecord;


public class UserParam implements Param {
    private Long userId; 
private String userName; 
private String nickName; 
private String password; 
private String avatar; 
private Integer gender; 
private Date birthday; 
private String email; 
private String mobile; 
private Long cent; 
private Boolean activate; 
private Long activateTime; 
private Long lastLoginTime; 
private Long ip; 
private String device; 
private String deviceId; 
private String deviceModel; 
private String channel; 
private String personalSignature; 
private String groupLevel; 
private String secretMobile; 
private StatusRecord status; 
private Long gmtCreate; 
private Long gmtModified; 
public Long getUserId(){
 return this.userId;
}
public void setUserId(Long userId){
this.userId=userId;
}
public String getUserName(){
 return this.userName;
}
public void setUserName(String userName){
this.userName=userName;
}
public String getNickName(){
 return this.nickName;
}
public void setNickName(String nickName){
this.nickName=nickName;
}
public String getPassword(){
 return this.password;
}
public void setPassword(String password){
this.password=password;
}
public String getAvatar(){
 return this.avatar;
}
public void setAvatar(String avatar){
this.avatar=avatar;
}
public Integer getGender(){
 return this.gender;
}
public void setGender(Integer gender){
this.gender=gender;
}
public Date getBirthday(){
 return this.birthday;
}
public void setBirthday(Date birthday){
this.birthday=birthday;
}
public String getEmail(){
 return this.email;
}
public void setEmail(String email){
this.email=email;
}
public String getMobile(){
 return this.mobile;
}
public void setMobile(String mobile){
this.mobile=mobile;
}
public Long getCent(){
 return this.cent;
}
public void setCent(Long cent){
this.cent=cent;
}
public Boolean getActivate(){
 return this.activate;
}
public void setActivate(Boolean activate){
this.activate=activate;
}
public Long getActivateTime(){
 return this.activateTime;
}
public void setActivateTime(Long activateTime){
this.activateTime=activateTime;
}
public Long getLastLoginTime(){
 return this.lastLoginTime;
}
public void setLastLoginTime(Long lastLoginTime){
this.lastLoginTime=lastLoginTime;
}
public Long getIp(){
 return this.ip;
}
public void setIp(Long ip){
this.ip=ip;
}
public String getDevice(){
 return this.device;
}
public void setDevice(String device){
this.device=device;
}
public String getDeviceId(){
 return this.deviceId;
}
public void setDeviceId(String deviceId){
this.deviceId=deviceId;
}
public String getDeviceModel(){
 return this.deviceModel;
}
public void setDeviceModel(String deviceModel){
this.deviceModel=deviceModel;
}
public String getChannel(){
 return this.channel;
}
public void setChannel(String channel){
this.channel=channel;
}
public String getPersonalSignature(){
 return this.personalSignature;
}
public void setPersonalSignature(String personalSignature){
this.personalSignature=personalSignature;
}
public String getGroupLevel(){
 return this.groupLevel;
}
public void setGroupLevel(String groupLevel){
this.groupLevel=groupLevel;
}
public String getSecretMobile(){
 return this.secretMobile;
}
public void setSecretMobile(String secretMobile){
this.secretMobile=secretMobile;
}
public StatusRecord getStatus(){
 return this.status;
}
public void setStatus(StatusRecord status){
this.status=status;
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