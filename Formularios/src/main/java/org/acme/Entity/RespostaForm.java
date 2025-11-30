package org.acme.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.acme.DTO.PessoaDTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RespostaForm extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    PessoaDTO pessoa;

    @ManyToOne
    @JoinColumn(name = "id_form")
    @JsonIgnore //Ignorar Json
    private Formulario formulario;

    @Column(columnDefinition = "TEXT")
    private String resto;
}
