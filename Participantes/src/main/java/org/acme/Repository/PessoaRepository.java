package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.Pessoa;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {
}
