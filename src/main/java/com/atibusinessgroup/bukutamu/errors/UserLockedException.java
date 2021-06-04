package com.atibusinessgroup.bukutamu.errors;

import org.springframework.security.authentication.AccountStatusException;

public class UserLockedException extends AccountStatusException {
    public UserLockedException(String msg) {
        super(msg);
    }

    public UserLockedException(String msg, Throwable t) {
        super(msg, t);
    }
}
