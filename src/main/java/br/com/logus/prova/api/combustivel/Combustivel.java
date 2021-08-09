package br.com.logus.prova.api.combustivel;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COMBUSTIVEL")
public class Combustivel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMBUSTIVEL")
    @SequenceGenerator(name = "SEQ_COMBUSTIVEL", sequenceName = "SEQ_COMBUSTIVEL", allocationSize = 1)
    private Integer id;

    @Column(name = "TIPO")
    private String Tipo;
}
