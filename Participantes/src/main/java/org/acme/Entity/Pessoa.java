package org.acme.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends PanacheEntityBase {

    @Id
    @Column(unique = true, length = 11)
    private String cpf;

    private String nome;

    @Column(name = "contato_celular", length = 11)
    private String contatoCelular;

    // getters e setters
}
