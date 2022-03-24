package com.eloaca.tinnova.service;

import com.eloaca.tinnova.exception.BubbleSortException;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class BubbleSortImpl implements BubbleSort {

    @Override
    public Integer[] ordernar(Integer[] v) throws BubbleSortException {
        if (v == null || v.length == 0){
            throw new BubbleSortException("Vetor nao pode ser vazio");
        }
        IntStream.range(0, v.length - 1)
                .flatMap(i -> IntStream.range(0, v.length - 1 - i))
                .filter(j -> v[j] > v[j + 1])
                .forEach(j -> {
                    var aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                });
        return v;
    }
}
