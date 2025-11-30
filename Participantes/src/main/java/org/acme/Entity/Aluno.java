package org.acme.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa {

    @Column(name = "identificador", unique = true)
    private Long matricula;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    @ManyToOne
    @JoinColumn(name = "curso_id_curso")
    private Curso curso;

    @Column(name = "email_institucional")
    private String emailInstitucional;

    // getters e setters
}
