package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.MultiploException;
import org.springframework.stereotype.Service;

@Service
public class MultiplosImpl implements Multiplos {

    @Override
    public Integer somarMultiplosDeTresECinco(final Integer param) throws MultiploException {

        if (param == null){
            throw new MultiploException("Parametro nao pode ser nulo");
        }
        var soma = 0;
        for (var i = 0; i < param; i++){
            if ((ehMultiploDe(i, 3)) || ehMultiploDe(i, 5)){
                soma = soma + i;
            }
        }
        return soma;
    }

    private boolean ehMultiploDe(final Integer numero, final Integer multiplo) {
        return numero % multiplo == 0;
    }
}
