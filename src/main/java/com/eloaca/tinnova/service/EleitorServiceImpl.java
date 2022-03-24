package com.eloaca.tinnova.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EleitorServiceImpl implements EleitorService {

    private static int eleitores = 1000;
    private static int validos = 800;
    private static int brancos = 150;
    private static int nulos = 50;

    @Override
    public float votosValidos() {
        return (validos*100)/eleitores;
    }

    @Override
    public float votosBrancos() {
        return (brancos*100)/eleitores;
    }

    @Override
    public float votosNulos() {
        return (nulos *100)/eleitores;
    }
}
