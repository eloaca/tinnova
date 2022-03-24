package com.eloaca.tinnova.controller.rs.response;

import com.eloaca.tinnova.domain.Veiculo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoResponse implements Serializable {

    private static final long serialVersionUID = 8503334649150075426L;

    @Schema(name = "id", description = "Id do Veiculo", example = "1")
    private Long id;

    @Schema(name = "veiculo", description = "Nome do Veiculo", example = "Corsa")
    private String veiculo;

    @Schema(name = "marca", description = "Marca do Veiculo", example = "Chevrolet")
    private String marca;

    @Schema(name = "ano", description = "Ano de lancamento do Veiculo", example = "2020")
    private Integer ano;

    @Schema(name = "descricao", description = "Descricao do Veiculo", example = "Corsa 1.6 Completo Automatico")
    private String descricao;

    @Schema(name = "vendido", description = "Indica se o Veiculo foi ou nao vendido", example = "true - vendido / false - disponivel")
    private boolean vendido;

    @Schema(name = "cor", description = "Cor do Veiculo", example = "Prata")
    private String cor;

    @Schema(name = "created", description = "Data e Hora de criacao do Veiculo", example = "2022-03-23 11:55:50.690")
    private LocalDateTime created;

    @Schema(name = "updated", description = "Data e Hora de atualizacao do Veiculo", example = "2022-03-24 11:55:50.690")
    private LocalDateTime updated;

    public VeiculoResponse(Veiculo v){
        this.id = v.getId();
        this.veiculo = v.getVeiculo();
        this.marca = v.getMarca();
        this.ano = v.getAno();
        this.descricao = v.getDescricao();
        this.vendido = v.isVendido();
        this.cor = v.getCor();
        this.created = v.getCreated();
        this.updated = v.getUpdated();
    }
}
