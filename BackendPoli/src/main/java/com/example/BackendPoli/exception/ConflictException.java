package com.example.BackendPoli.exception;
import com.example.BackendPoli.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends AppException {
    public ConflictException(String nomeRecurso, String campo, Object valor) {
        super(String.format("Já existe um(a) %s com %s '%s'",
              nomeRecurso, campo, valor));
    }
    
    public ConflictException(String mensagem) {
        super(mensagem);
    }
}
