package com.example.BackendPoli.exception;

/**
 * Exception lançada quando há erro de validação.
 */
public class ValidationException extends AppException {
    public ValidationException(String mensagem) {
        super(mensagem);
    }
    
    public ValidationException(String campo, String mensagemValidacao) {
        super(String.format("Campo '%s': %s", campo, mensagemValidacao));
    }
}
