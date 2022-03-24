package com.eloaca.tinnova.controller.rs.erro;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class Erro {

    private String titulo;
    private LocalDateTime dataHora;
    private Integer status;
    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Campo {
        private String nome;
        private String mensagem;

    }

    public Erro(String titulo, LocalDateTime dataHora, Integer status) {
        this.titulo = titulo;
        this.dataHora = dataHora;
        this.status = status;
    }
}
