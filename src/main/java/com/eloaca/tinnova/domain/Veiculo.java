package com.eloaca.tinnova.domain;


import com.eloaca.tinnova.controller.rs.request.VeiculoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Veiculo implements Serializable {

    private static final long serialVersionUID = -1928945578435935837L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "veiculo", length = 50, nullable = false)
    private String veiculo;

    @Column(name = "marca", length = 50, nullable = false)
    private String marca;

    @Column(name = "ano", length = 4, nullable = false)
    private Integer ano;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "vendido", nullable = false)
    private boolean vendido;

    @Column(name = "cor", length = 50, nullable = false)
    private String cor;

    @Column(name = "created", length = 25, nullable = false)
    private LocalDateTime created;

    @Column(name = "updated", length = 25)
    private LocalDateTime updated;

    public Veiculo(VeiculoRequest request){
        this.veiculo = request.getVeiculo();
        this.marca = request.getMarca();
        this.ano = request.getAno();
        this.descricao = request.getDescricao();
        this.vendido = request.isVendido();
        this.cor = request.getCor();
    }
}
