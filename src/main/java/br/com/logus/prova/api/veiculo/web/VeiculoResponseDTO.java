package br.com.logus.prova.api.veiculo.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class VeiculoResponseDTO {

    private String modelo;
    private String placa;

}
