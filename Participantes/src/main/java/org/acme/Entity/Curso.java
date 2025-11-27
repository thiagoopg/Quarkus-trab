package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.acme.Enum.NivelCurso;

@Entity
public class Curso extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Enumerated(EnumType.STRING)
    private NivelCurso nivel;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    // getters e setters
}
