package org.acme.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Entity.Formulario;
import org.acme.Entity.RespostaForm;

@ApplicationScoped
public class ResFormularioRepository implements PanacheRepository<RespostaForm> {
}
