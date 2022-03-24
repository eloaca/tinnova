package com.eloaca.tinnova.repository;

import com.eloaca.tinnova.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByMarcaAndAnoAndCor(String marca, Integer ano, String cor);


}
