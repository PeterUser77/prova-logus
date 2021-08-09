package br.com.logus.prova.api.modelo.web;

import br.com.logus.prova.api.combustivel.CombustivelDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ModeloResponseDTO {

    private String nome;
    private Integer capacidadeCombustivel;
    private List<CombustivelDTO> combustiveis;

}
