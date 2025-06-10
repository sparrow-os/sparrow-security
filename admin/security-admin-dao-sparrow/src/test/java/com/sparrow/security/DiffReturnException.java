package com.sparrow.security;

import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.SparrowError;

public class DiffReturnException {
    public static void main(String[] args) throws BusinessException {
        service(0);
        System.out.println("ending");
    }

    private static void service(int i) throws BusinessException {
        Asserts.isTrue(i == 0, SparrowError.GLOBAL_DB_DELETE_ERROR);
    }
}
