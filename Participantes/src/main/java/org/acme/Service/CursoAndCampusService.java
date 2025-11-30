package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.Entity.Campus;
import org.acme.Entity.Curso;

@ApplicationScoped
public class CursoAndCampusService {

    Campus repositoryCampus;

    Curso repositoryCurso;

    public Object findAllCampus(){
        return repositoryCampus.listAll();
    }
    public Object findAllCurso(){
        return repositoryCurso.listAll();
    }
}
