package com.example.BackendPoli.exception;


public class AppException extends RuntimeException {
    public AppException(String mensagem) {
        super(mensagem);
    }
    
    public AppException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
