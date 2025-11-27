package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class RespostaForm extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_form")
    private Formulario formulario;

    @Column(name = "cpf_pessoa", length = 11)
    private String alunoId;

    @Column(columnDefinition = "TEXT")
    private String resto;

    // getters e setters
}
