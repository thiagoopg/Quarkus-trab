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
public class Servidor extends Pessoa {

    @Column(name = "identificador", unique = true)
    private Long identificador;

    @ManyToOne
    @JoinColumn(name = "id_campus")
    private Campus campus;

    @Column(name = "email_institucional")
    private String emailInstitucional;

    // getters e setters
}
