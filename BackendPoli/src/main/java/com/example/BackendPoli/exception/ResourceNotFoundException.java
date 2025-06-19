package com.example.BackendPoli.exception;

/**
 * Exception lançada quando um recurso não é encontrado.
 */
public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String nomeRecurso, Object identificador) {
        super(String.format("%s não encontrado(a) com o identificador: %s", 
              nomeRecurso, identificador.toString()));
    }
}
