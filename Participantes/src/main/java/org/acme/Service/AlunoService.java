package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.Entity.Aluno;
import org.acme.Repository.AlunoRepository;

@ApplicationScoped
public class AlunoService {

    @Inject
    AlunoRepository repository;

    @Transactional
    public Aluno create(Aluno Aluno) {
        repository.persist(Aluno);
        return Aluno;
    }

    public Aluno findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Aluno update(Long id, Aluno atualizado) {
        Aluno aluno = findById(id);
        aluno.setNome(atualizado.getNome());
        aluno.setCpf(atualizado.getCpf());
        repository.persist(aluno);
        return aluno;
    }

    @Transactional
    public void delete(Long id) {
        Aluno Aluno = findById(id);
        repository.delete(String.valueOf(Aluno));
    }

    public Object findAll() {
        return repository.listAll();
    }
}

