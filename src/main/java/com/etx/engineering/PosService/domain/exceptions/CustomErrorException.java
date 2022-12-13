package com.etx.engineering.PosService.domain.exceptions;

import org.springframework.http.HttpStatus;

public class CustomErrorException extends RuntimeException{
    private HttpStatus status;
    private Object data;

    public CustomErrorException() {
        super();
    }

    public CustomErrorException(
            String message
    ) {
        super(message);
    }

    public CustomErrorException(
            HttpStatus status,
            String message
    ) {
        this(message);
        this.status = status;
    }

    public CustomErrorException(
            HttpStatus status,
            String message,
            Object data
    ) {
        this(
                status,
                message
        );
        this.data = data;
    }
}
