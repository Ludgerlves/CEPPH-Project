package com.example.BackendPoli.exceptions;

/**
 * Exception lançada quando há conflito de dados.
 */
public class ConflictException extends AppException {
    public ConflictException(String nomeRecurso, String campo, Object valor) {
        super(String.format("Já existe um(a) %s com %s '%s'", 
              nomeRecurso, campo, valor));
    }
    
    public ConflictException(String mensagem) {
        super(mensagem);
    }
}
