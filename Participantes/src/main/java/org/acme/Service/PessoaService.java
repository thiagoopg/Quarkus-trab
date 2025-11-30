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
        return (Pessoa) repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Pessoa não encontrada"));
    }

    @Transactional
    public Pessoa update(Long id, Pessoa atualizado) {
        Pessoa existente = findById(id);
        existente.setNome(atualizado.getNome());
        existente.setCpf(atualizado.getCpf());
        return existente;
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

