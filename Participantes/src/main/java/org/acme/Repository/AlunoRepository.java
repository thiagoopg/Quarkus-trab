package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.Aluno;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
}
