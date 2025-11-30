package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.Entity.Pessoa;
import org.acme.Repository.PessoaRepository;

@ApplicationScoped
public class PessoaService {

    @Inject
    PessoaRepository repository;

    @Transactional
    public Pessoa create(Pessoa Pessoa) {
        repository.persist(Pessoa);
        return Pessoa;
    }

    public Pessoa findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Pessoa update(Long id, Pessoa atualizado) {
        Pessoa pessoa = findById(id);
        pessoa.setNome(atualizado.getNome());
        pessoa.setCpf(atualizado.getCpf());
        repository.persist(pessoa);
        return pessoa;
    }

    @Transactional
    public void delete(Long id) {
        Pessoa Pessoa = findById(id);
        repository.delete(String.valueOf(Pessoa));
    }

    public Object findAll() {
        return repository.listAll();
    }
}

