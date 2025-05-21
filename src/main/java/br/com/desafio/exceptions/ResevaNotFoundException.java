package br.com.desafio.exceptions;

public class ResevaNotFoundException extends RuntimeException {
    public ResevaNotFoundException(String message) {
        super(message);
    }
}
