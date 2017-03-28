package com.housescent.commonsettings.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Siya on 2017/03/23.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SettingNotFoundException extends SettingException {

    public SettingNotFoundException() {
        super();
    }

    public SettingNotFoundException(String message) {
        super(message);
    }

    public SettingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SettingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
