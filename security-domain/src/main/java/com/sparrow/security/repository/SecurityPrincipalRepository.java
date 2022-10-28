package com.sparrow.security.repository;

import com.sparrow.passport.domain.entity.SecurityPrincipalEntity;

public interface SecurityPrincipalRepository {
    SecurityPrincipalEntity findByUserId(Long userId);

    SecurityPrincipalEntity findByEmail(String email);

    SecurityPrincipalEntity findByName(String userName);

    SecurityPrincipalEntity findByMobile(String mobile, String secretMobile);

    void saveSecurity(SecurityPrincipalEntity securityPrincipal);
}
