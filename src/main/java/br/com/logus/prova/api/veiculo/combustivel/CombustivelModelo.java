package br.com.logus.prova.api.veiculo.combustivel;

import br.com.logus.prova.api.combustivel.Combustivel;
import br.com.logus.prova.api.modelo.Modelo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "COMBUSTIVEL_MODELO")
public class CombustivelModelo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMBUSTIVEL_MODELO")
    @SequenceGenerator(name = "SEQ_COMBUSTIVEL_MODELO", sequenceName = "SEQ_COMBUSTIVEL_MODELO", allocationSize = 1)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "COMBUSTIVEL_ID")
    private Combustivel combustivel;

    @ManyToOne()
    @JoinColumn(name = "MODELO_ID")
    private Modelo modelo;

    @Column(name = "CONSUMO")
    private BigDecimal consumo;

}
