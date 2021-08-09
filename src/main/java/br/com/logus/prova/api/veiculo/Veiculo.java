package br.com.logus.prova.api.veiculo;

import br.com.logus.prova.api.modelo.Modelo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "VEICULO")
public class Veiculo {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEICULO")
    @SequenceGenerator(name = "SEQ_VEICULO", sequenceName = "SEQ_VEICULO", allocationSize = 1)
    private Integer id;

    @Column(name = "PLACA")
    private String placa;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "MODELO_ID")
    private Modelo modelo;

}
