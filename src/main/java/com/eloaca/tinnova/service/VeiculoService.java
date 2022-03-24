package com.eloaca.tinnova.service;

import com.eloaca.tinnova.domain.Veiculo;
import com.eloaca.tinnova.exception.VeiculoException;

import java.util.List;

public interface VeiculoService {

    List<Veiculo> consultarVeiculos();

    Veiculo consultarVeiculo(final Long id) throws VeiculoException;

    List<Veiculo> consultarVeiculosPorParametro(final String marca, final Integer ano, final String cor);

    Veiculo salvarVeiculo(Veiculo veiculo) throws VeiculoException;

    boolean excluirVeiculo(final Long id) throws VeiculoException;
}
