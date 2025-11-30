package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends PanacheEntityBase {

    @Id
    @Column(unique = true, length = 11)
    private String cpf;

    private String nome;

    @Column(name = "email")
    public String email;

    // getters e setters
}
