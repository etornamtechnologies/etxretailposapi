package com.etx.engineering.PosService.domain.exceptions;

public class DatabaseException extends RuntimeException {
    public DatabaseException() {
        super("Something nwent wrong during database operation");
    }

    public DatabaseException(String message) {
        super(message);
    }

}
