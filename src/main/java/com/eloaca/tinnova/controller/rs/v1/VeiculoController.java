package com.eloaca.tinnova.controller.rs.v1;

import com.eloaca.tinnova.controller.rs.request.VeiculoRequest;
import com.eloaca.tinnova.controller.rs.response.VeiculoResponse;
import com.eloaca.tinnova.domain.Veiculo;
import com.eloaca.tinnova.exception.VeiculoException;
import com.eloaca.tinnova.service.VeiculoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/veiculo")
@AllArgsConstructor
public class VeiculoController {

    private static final Logger log = LoggerFactory.getLogger(VeiculoController.class);

    private final VeiculoService service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculos Encontrados"),
            @ApiResponse(responseCode = "404", description = "Nenhum Veiculo Encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @GetMapping(
            name = "consultarAll",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<VeiculoResponse>> consultarAll() {
        var veiculos = service.consultarVeiculos();
        var responses = new ArrayList<VeiculoResponse>();
        if (veiculos.isEmpty()) {
            log.info("Nennhum veiculo encontrado");
            return ResponseEntity.notFound().build();
        } else {
             responses = (ArrayList<VeiculoResponse>) veiculos
                    .stream()
                    .map(VeiculoResponse::new)
                    .collect(Collectors.toList());
             log.info("Veiculos encontrados: "+responses.size());
            return ResponseEntity.ok(responses);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo Encontrado"),
            @ApiResponse(responseCode = "404", description = "Veiculo nao Encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @GetMapping(
            name = "consultarOnly",
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public ResponseEntity<VeiculoResponse> consultarOnly(@PathVariable(name = "id") final Long id) {
        try {
            var v = service.consultarVeiculo(id);
            var response = new VeiculoResponse(v);
            log.info("veiculo encontrado");
            return ResponseEntity.ok(response);
        } catch (VeiculoException e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Veiculo Cadastrado"),
            @ApiResponse(responseCode = "400", description = "Veiculo nao Cadastrado"),
            @ApiResponse(responseCode = "404", description = "Veiculo nao Cadastrado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<VeiculoResponse> salvar(@RequestBody final VeiculoRequest request) {
        var v = new Veiculo(request);
        v.setCreated(LocalDateTime.now());
        try {
            v = service.salvarVeiculo(v);
            var response = new VeiculoResponse(v);
            log.info("Veiculo cadastrado com o id "+v.getId());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (VeiculoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo Atualizado"),
            @ApiResponse(responseCode = "404", description = "Veiculo nao Atualizado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public ResponseEntity<VeiculoResponse> atualizarAll(@RequestBody final VeiculoRequest request,
                                                        @PathVariable(name = "id") final Long id) {
        var v = new Veiculo(request);
        v.setId(id);
        v.setUpdated(LocalDateTime.now());
        try {
            v = service.salvarVeiculo(v);
            var response = new VeiculoResponse(v);
            log.info("Veiculo atualizado com o id "+v.getId());
            return ResponseEntity.ok(response);
        } catch (VeiculoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo Atualizado"),
            @ApiResponse(responseCode = "404", description = "Veiculo nao Atualizado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @PatchMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}"
    )
    public ResponseEntity<VeiculoResponse> atualizarFew(@RequestBody final VeiculoRequest request,
                                                        @PathVariable(name = "id") final Long id) {
        var v = new Veiculo(request);
        v.setId(id);
        v.setUpdated(LocalDateTime.now());
        try {
            v = service.salvarVeiculo(v);
            var response = new VeiculoResponse(v);
            log.info("Veiculo atualizado com o id "+v.getId());
            return ResponseEntity.ok(response);
        } catch (VeiculoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculo Excluido"),
            @ApiResponse(responseCode = "400", description = "Veiculo nao Excluido"),
            @ApiResponse(responseCode = "404", description = "Veiculo nao Encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @DeleteMapping(
            name = "delete",
            value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Boolean> delete(@PathVariable(name = "id") final Long id){
        try {
            var response = service.excluirVeiculo(id);
            if (response) {
                log.info("veiculo excluido");
                return ResponseEntity.ok(response);
            } else {
                log.error("veiculo nao excluido");
                return ResponseEntity.notFound().build();
            }
        } catch (VeiculoException e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Veiculos Encontrados"),
            @ApiResponse(responseCode = "404", description = "Veiculos nao Encontrados"),
            @ApiResponse(responseCode = "500", description = "Erro Servidor")
    })
    @GetMapping(
            name = "/consultarByParametro",
            value = "/{marca}/{ano}/{cor}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<VeiculoResponse>> consultarByParametro(@PathVariable(name = "marca") String marca,
                                                                      @PathVariable(name = "ano") Integer ano,
                                                                      @PathVariable(name = "cor") String cor){

        var veiculos = service.consultarVeiculosPorParametro(marca, ano, cor);
        var responses = new ArrayList<VeiculoResponse>();
        if (veiculos.isEmpty()) {
            log.info("Nenhum veiculo encontrado");
            return ResponseEntity.notFound().build();
        } else {
            responses = (ArrayList<VeiculoResponse>) veiculos
                    .stream()
                    .map(VeiculoResponse::new)
                    .collect(Collectors.toList());
            log.info("Veiculos encontrados: "+responses.size());
            return ResponseEntity.ok(responses);
        }
    }
}
