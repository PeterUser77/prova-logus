package br.com.logus.prova.api.combustivel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CombustivelDTO {

    private String tipo;
    private BigDecimal consumo;

}
