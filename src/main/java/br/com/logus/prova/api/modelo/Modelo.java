package br.com.logus.prova.api.modelo;

import br.com.logus.prova.api.veiculo.combustivel.CombustivelModelo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "MODELO")
public class Modelo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MODELO")
    @SequenceGenerator(name = "SEQ_MODELO", sequenceName = "SEQ_MODELO", allocationSize = 1)
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CAPACIDADE_COMBUSTIVEL")
    private Integer capacidadeCombustivel;

    @OneToMany(mappedBy = "modelo")
    private Set<CombustivelModelo> combustiveis;
}
