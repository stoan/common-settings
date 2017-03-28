package com.housescent.commonsettings.service.exception;

/**
 * Created by Siya Sosibo on 2017/03/28 8:21 PM.
 */
public class SettingException extends RuntimeException {

    public SettingException() {
        super();
    }

    public SettingException(String message) {
        super(message);
    }

    public SettingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingException(Throwable cause) {
        super(cause);
    }

    protected SettingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
