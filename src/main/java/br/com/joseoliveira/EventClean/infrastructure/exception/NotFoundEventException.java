package br.com.joseoliveira.EventClean.infrastructure.exception;

public class NotFoundEventException extends RuntimeException {

    public NotFoundEventException(String message) {
        super(message);
    }
}
