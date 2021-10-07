package com.persona.domain.exception;

public class RequiredValueException extends RuntimeException {

    public RequiredValueException(String msj) {
        super(msj);
    }
}
