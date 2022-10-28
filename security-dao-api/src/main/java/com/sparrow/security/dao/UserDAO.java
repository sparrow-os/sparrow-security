package com.sparrow.security.dao;

import com.sparrow.protocol.dao.DaoSupport;
import com.sparrow.security.po.User;

public interface UserDAO extends DaoSupport<User, Long> {
    void save(SecurityPrincipal securityPrincipal);
}
