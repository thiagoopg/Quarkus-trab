package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.Servidor;

@ApplicationScoped
public class ServidorRepository implements PanacheRepository<Servidor> {
}
