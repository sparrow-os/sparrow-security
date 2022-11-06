package com.sparrow.security.protocol.admin.enums;

import com.sparrow.protocol.ModuleSupport;

public class SecurityModule {
    public static final ModuleSupport Group = new ModuleSupport() {
        @Override
        public String code() {
            return "31";
        }

        @Override
        public String name() {
            return "Group";
        }
    };
}
