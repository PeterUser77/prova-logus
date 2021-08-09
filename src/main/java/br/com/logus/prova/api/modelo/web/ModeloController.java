package br.com.logus.prova.api.modelo.web;

import br.com.logus.prova.api.combustivel.CombustivelDTO;
import br.com.logus.prova.api.modelo.Modelo;
import br.com.logus.prova.api.modelo.ModeloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService service;

    public ModeloController(ModeloService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponseDTO> obterPorId(@PathVariable Integer id){
        return ResponseEntity.ok(this.converterParaDTO(this.service.buscarPorId(id)));
    }

    private ModeloResponseDTO converterParaDTO(Modelo modelo){
        return ModeloResponseDTO.builder().nome(modelo.getNome())
                .capacidadeCombustivel(modelo.getCapacidadeCombustivel())
                .combustiveis(modelo.getCombustiveis().stream()
                        .map(cb -> CombustivelDTO.builder()
                                .tipo(cb.getCombustivel().getTipo())
                                .consumo(cb.getConsumo())
                                .build()).collect(Collectors.toList())).build();
    }


}
