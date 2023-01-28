package com.sparrow.spring.test;

import com.alibaba.fastjson.JSON;
import com.sparrow.security.admin.protocol.param.MicroServiceParam;

public class MicroServiceTest {
    public static void main(String[] args) {
        MicroServiceParam microServiceParam = new MicroServiceParam();
        microServiceParam.setId(0L);
        microServiceParam.setAppId(0L);
        microServiceParam.setName("server-name");
        microServiceParam.setLogo("logo");
        microServiceParam.setSort(0);
        microServiceParam.setRemark("remarks");
        System.out.println(JSON.toJSONString(microServiceParam));
    }
}
