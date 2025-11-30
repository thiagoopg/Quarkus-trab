package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.acme.Enum.NivelCurso;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;

    @Enumerated(EnumType.STRING)
    private NivelCurso nivel;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "campus_id_campus")
    private Campus campus;

    // getters e setters
}
