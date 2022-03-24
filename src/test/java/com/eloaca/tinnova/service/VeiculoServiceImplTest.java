package com.eloaca.tinnova.service;

import com.eloaca.tinnova.domain.Veiculo;
import com.eloaca.tinnova.exception.VeiculoException;
import com.eloaca.tinnova.repository.VeiculoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VeiculoServiceImplTest {

    @InjectMocks
    private VeiculoServiceImpl impl;

    @Mock
    private VeiculoRepository repo;


    @Test
    void consultarVeiculos() {
        var v = criarVeiculo();
        var vs = new ArrayList<Veiculo>();
        vs.add(v);
        when(repo.findAll()).thenReturn(vs);
        var list = impl.consultarVeiculos();
        assertEquals(list, vs);
    }

    @Test
    void consultarVeiculo() throws VeiculoException {
        var v = criarVeiculo();
        when(repo.findById(anyLong())).thenReturn(Optional.of(v));
        var encontrado = impl.consultarVeiculo(1L);
        assertEquals(encontrado, v);
    }

    @Test
    void consultarVeiculoLancandoExcessao() {
        when(repo.findById(anyLong())).thenReturn(Optional.empty());
        var exception = assertThrows(
                VeiculoException.class,
                () -> impl.consultarVeiculo(1L)
        );
        assertEquals(exception.getMessage(), "Nao foi encontrado nenhum veiculo com o id 1");
    }

    @Test
    void consultarVeiculosPorParametro() {
        var v = criarVeiculo();
        var vs = new ArrayList<Veiculo>();
        vs.add(v);
        when(repo.findByMarcaAndAnoAndCor(anyString(), anyInt(), anyString())).thenReturn(vs);
        var encontrados = impl.consultarVeiculosPorParametro("Chevrolet", 2020,"Prata");
        assertEquals(encontrados, vs);
    }

    @Test
    void salvarVeiculo() throws VeiculoException {
        var v = criarVeiculo();
        v.setId(null);
        when(repo.save(any(Veiculo.class))).thenReturn(v);
        var vSalvo = impl.salvarVeiculo(v);
        assertEquals(vSalvo, v);
    }

    @Test
    void salvarVeiculoJaSalvo() throws VeiculoException {
        var v = criarVeiculo();
        when(repo.findById(anyLong())).thenReturn(Optional.of(v));
        when(repo.save(any(Veiculo.class))).thenReturn(v);
        var vSalvo = impl.salvarVeiculo(v);
        assertEquals(vSalvo, v);
    }

    @Test
    void salvarVeiculoLancandoExcessao() {
        var v = criarVeiculo();
        when(repo.findById(anyLong())).thenReturn(Optional.empty());
        var e = assertThrows(
                VeiculoException.class,
                () -> impl.salvarVeiculo(v)
        );
        assertEquals(e.getMessage(), "Nao foi encontrado nenhum veiculo com o id 1");
    }

    @Test
    void excluirVeiculo() throws VeiculoException {
        var v = criarVeiculo();
        when(repo.findById(anyLong()))
                .thenReturn(Optional.of(v))
                .thenReturn(Optional.empty());
        var b = impl.excluirVeiculo(1L);
    }

    @Test
    void excluirVeiculoLancandoExcessao() {
        when(repo.findById(anyLong())).thenReturn(Optional.empty());
        var exception = assertThrows(
                VeiculoException.class,
                () -> impl.excluirVeiculo(1L)
        );
        assertEquals(exception.getMessage(), "Nao foi encontrado nenhum veiculo com o id 1");
    }

    private Veiculo criarVeiculo() {
        return new Veiculo(1L, "Corsa", "Chevrolet", 2020,
                "Corsa Hatch 1.6 Completo", false, "Prata",
                LocalDateTime.now(), null);
    }
}