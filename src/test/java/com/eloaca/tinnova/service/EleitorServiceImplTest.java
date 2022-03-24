package com.eloaca.tinnova.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EleitorServiceImplTest {

    @InjectMocks
    private EleitorServiceImpl service;


    @Test
    void votosValidos() {
        final var validos = service.votosValidos();
        assertEquals(validos, 80.0);
    }

    @Test
    void votosBrancos() {
        final var brancos = service.votosBrancos();
        assertEquals(brancos, 15.0);
    }

    @Test
    void votosNulos() {
        final var nulos = service.votosNulos();
        assertEquals(nulos, 5.0);
    }
}