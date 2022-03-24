package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.FatorialException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FatorialImplTest {

    @InjectMocks
    private FatorialImpl service;

    @Test
    void calcularFatorial() throws FatorialException {
        var fatorial = service.calcularFatorial(5);
        Assertions.assertEquals(fatorial, 120);
    }

    @Test
    void calcularFatorialNulo() {
        var exception = assertThrows(
                FatorialException.class,
                () -> service.calcularFatorial(null));

        assertEquals("Numero nao pode ser nulo", exception.getMessage());
    }
}