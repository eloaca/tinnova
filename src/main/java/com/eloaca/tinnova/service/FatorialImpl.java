package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.FatorialException;
import org.springframework.stereotype.Service;

@Service
public class FatorialImpl implements Fatorial {

    @Override
    public Integer calcularFatorial(final Integer numero) throws FatorialException {
        if (numero == null){
            throw new FatorialException("Numero nao pode ser nulo");
        }
        var fatorial = 1;
        for(var i = 1; i <= numero; i++ ) {
            fatorial *= i;
        }
        return fatorial;
    }
}
