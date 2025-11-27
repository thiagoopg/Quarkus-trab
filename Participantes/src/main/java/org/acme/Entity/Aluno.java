package org.acme.Entity;

import jakarta.persistence.*;

@Entity
public class Aluno extends Pessoa {

    @Column(name = "identificador", unique = true)
    private Long matricula;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    private String curso;

    @Column(name = "email_institucional")
    private String emailInstitucional;

    // getters e setters
}
