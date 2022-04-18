package br.com.zup.handora.umparamuitos1exemplo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TelefoneNaoEncontradoException extends ResponseStatusException {

    public TelefoneNaoEncontradoException(HttpStatus status, String reason) {
        super(status, reason);
    }

}
