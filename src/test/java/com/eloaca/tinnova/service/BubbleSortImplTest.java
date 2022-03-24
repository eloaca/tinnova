package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.BubbleSortException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BubbleSortImplTest {

    @InjectMocks
    private BubbleSortImpl sort;

    @Test
    void ordernar() throws BubbleSortException {
        Integer[] vetor =  {5, 3, 2, 4, 7, 1, 0, 6};
        final Integer[] vetorOrdernado = {0, 1, 2, 3, 4, 5, 6, 7};
        vetor = sort.ordernar(vetor);
        for (var i = 0; i < vetor.length; i++){
            assertEquals(vetor[i], vetorOrdernado[i]);
        }
    }

    @Test
    void ordernarVazioOuNulo() {
        var msg = "Vetor nao pode ser vazio";
        var vazio = assertThrows(
                BubbleSortException.class,
                () -> sort.ordernar(new Integer[0])
        );
        var nulo = assertThrows(
                BubbleSortException.class,
                () -> sort.ordernar(null)
        );
        assertEquals(vazio.getMessage(), msg);
        assertEquals(nulo.getMessage(), msg);
    }
}