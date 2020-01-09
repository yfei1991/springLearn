package com.central.cms.commons.exception;

public class CmsException extends RuntimeException{

    public CmsException(String message) {
        super(message);
    }

    public CmsException(String message, Throwable cause) {
        super(message, cause);
    }
}
