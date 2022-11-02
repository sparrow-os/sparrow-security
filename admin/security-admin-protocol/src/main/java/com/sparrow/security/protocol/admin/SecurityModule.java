package com.sparrow.security.protocol.admin;

import com.sparrow.protocol.ModuleSupport;

public class SecurityModule {
    public static final ModuleSupport GROUP = new ModuleSupport() {
        public String code() {
            return "31";
        }

        public String name() {
            return "group";
        }
    };
}