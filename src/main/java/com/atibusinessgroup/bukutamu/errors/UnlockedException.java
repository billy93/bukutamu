package com.atibusinessgroup.bukutamu.errors;

import org.springframework.security.authentication.AccountStatusException;

public class UnlockedException extends AccountStatusException {
    public UnlockedException(String msg) {
        super(msg);
    }

    public UnlockedException(String msg, Throwable t) {
        super(msg, t);
    }
}
