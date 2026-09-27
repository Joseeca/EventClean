package br.com.joseoliveira.EventClean.infrastructure.exception;

public class DuplicateEventException extends RuntimeException {

    public DuplicateEventException(String mensage) {
        super(mensage);
    }
}
