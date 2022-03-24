package com.eloaca.tinnova.service;

import com.eloaca.tinnova.domain.Veiculo;
import com.eloaca.tinnova.exception.VeiculoException;
import com.eloaca.tinnova.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository repository;

    @Override
    public List<Veiculo> consultarVeiculos() {
        return repository.findAll();
    }

    @Override
    public Veiculo consultarVeiculo(final Long id) throws VeiculoException {
        return repository.findById(id).orElseThrow(() ->
                new VeiculoException("Nao foi encontrado nenhum veiculo com o id {0}", id));
    }

    @Override
    public List<Veiculo> consultarVeiculosPorParametro(final String marca,
                                                       final Integer ano,
                                                       final String cor) {
        return repository.findByMarcaAndAnoAndCor(marca, ano, cor);
    }

    @Override
    public Veiculo salvarVeiculo(Veiculo veiculo) throws VeiculoException {
        return this.salvarVeiculoComValidacoes(veiculo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean excluirVeiculo(final Long id) throws VeiculoException {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return repository.findById(id).isEmpty();
        } else {
            throw new VeiculoException("Nao foi encontrado nenhum veiculo com o id {0}", id);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private Veiculo salvarVeiculoComValidacoes(Veiculo veiculo) throws VeiculoException{
        if (veiculo.getId() != null) {
            var v = repository.findById(veiculo.getId());
            if (v.isPresent()) {
                veiculo.setCreated(v.get().getCreated());
                return repository.save(veiculo);
            } else {
                throw new VeiculoException("Nao foi encontrado nenhum veiculo com o id {0}", veiculo.getId());
            }
        } else {
            return repository.save(veiculo);
        }
    }
}
