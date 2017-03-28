package com.housescent.commonsettings.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Siya Sosibo on 2017/03/28.
 */

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateSettingFoundException extends SettingException{

    public DuplicateSettingFoundException() {
        super();
    }

    public DuplicateSettingFoundException(String message) {
        super(message);
    }

    public DuplicateSettingFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateSettingFoundException(Throwable cause) {
        super(cause);
    }

    protected DuplicateSettingFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
