package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.MultiploException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MultiplosImplTest {

    @InjectMocks
    private MultiplosImpl impl;

    @Test
    void somarMultiplosDeTresECinco() throws MultiploException {
        var soma = impl.somarMultiplosDeTresECinco(10);
        assertEquals(23, soma);
    }

    @Test
    void somarComNumeroNulo() {
        var exception = assertThrows(
                MultiploException.class,
                () -> impl.somarMultiplosDeTresECinco(null)
        );
        assertEquals("Parametro nao pode ser nulo", exception.getMessage());
    }
}