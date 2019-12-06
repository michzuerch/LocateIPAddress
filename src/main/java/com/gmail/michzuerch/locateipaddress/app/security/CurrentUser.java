package com.gmail.michzuerch.locateipaddress.app.security;

import com.gmail.michzuerch.locateipaddress.backend.data.entity.User;

@FunctionalInterface
public interface CurrentUser {

    User getUser();
}
