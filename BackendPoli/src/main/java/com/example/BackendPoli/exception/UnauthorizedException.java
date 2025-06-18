package com.example.BackendPoli.exceptions;

/**
 * Exception lançada quando há tentativa de acesso não autorizado.
 * Retorna HTTP 401 (Unauthorized).
 */
public class UnauthorizedException extends AppException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
