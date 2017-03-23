package com.housescent.commonsettings.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Siya on 2017/03/23.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SettingNotFound extends RuntimeException {

    public SettingNotFound() {
        super();
    }

    public SettingNotFound(String message) {
        super(message);
    }

    public SettingNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingNotFound(Throwable cause) {
        super(cause);
    }

    protected SettingNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
