package com.gmail.michzuerch.locateipaddress.security;

public class Role {
    public static final String VIEWER = "viewer";
    public static final String ADMIN = "admin";

    private Role() {
        // Static methods and fields only
    }

    public static String[] getAllRoles() {
        return new String[]{VIEWER, ADMIN};
    }

}
