package org.acme.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.acme.DTO.PessoaDTO;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespostaForm extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    PessoaDTO pessoa;

    @ManyToOne
    @JoinColumn(name = "id_form")
    @JsonIgnore
    private Formulario formulario;

    @Column(columnDefinition = "TEXT")
    private String resto;

    // getters e setters
}
