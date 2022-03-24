package com.eloaca.tinnova.controller.rs.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VeiculoRequest implements Serializable {

    private static final long serialVersionUID = -49199893991901540L;

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
}
