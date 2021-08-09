package br.com.logus.prova.api.veiculo.web;

import br.com.logus.prova.api.veiculo.Veiculo;
import br.com.logus.prova.api.veiculo.VeiculoService;
import br.com.logus.prova.api.modelo.Modelo;
import br.com.logus.prova.api.modelo.ModeloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;
    private final ModeloService modeloService;

    public VeiculoController(VeiculoService service, ModeloService modeloService) {
        this.service = service;
        this.modeloService = modeloService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> obterPorId(@PathVariable Integer id){
        return ResponseEntity.ok(this.converterParaDTO(this.service.buscarPorId(id)));
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> cadastrar(@RequestBody VeiculoRequestDTO body){
        var veiculo = this.service.cadastrar(this.converterParaEntidade(body, modeloService.buscarPorId(body.getModeloId())));
        return ResponseEntity.status(HttpStatus.CREATED).body(this.converterParaDTO(veiculo));
    }

    private VeiculoResponseDTO converterParaDTO(Veiculo veiculo){
        return VeiculoResponseDTO.builder()
                .modelo(veiculo.getModelo().getNome())
                .placa(veiculo.getPlaca())
                .build();
    }

    private Veiculo converterParaEntidade(VeiculoRequestDTO veiculo, Modelo modelo){
        return Veiculo.builder()
                .modelo(modelo)
                .placa(veiculo.getPlaca())
                .build();
    }

}
