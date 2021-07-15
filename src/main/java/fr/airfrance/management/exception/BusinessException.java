package fr.airfrance.management.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {
    private HttpStatus status;
    private  String param;

    public BusinessException(HttpStatus status, String param) {
        this.status = status;
        this.param = param;
    }

    public BusinessException(String message, HttpStatus status, String param) {
        super(message);
        this.status = status;
        this.param = param;
    }

    public BusinessException(String message, Throwable cause, HttpStatus status, String param) {
        super(message, cause);
        this.status = status;
        this.param = param;
    }

    public BusinessException(Throwable cause, HttpStatus status, String param) {
        super(cause);
        this.status = status;
        this.param = param;
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus status, String param) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
        this.param = param;
    }
}
