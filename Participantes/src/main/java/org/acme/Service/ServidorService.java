package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.Entity.Servidor;
import org.acme.Repository.ServidorRepository;

@ApplicationScoped
public class ServidorService {

    @Inject
    ServidorRepository repository;

    @Transactional
    public Servidor create(Servidor Servidor) {
        repository.persist(Servidor);
        return Servidor;
    }

    public Servidor findById(Long id) {
        return (Servidor) repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Servidor não encontrada"));
    }

    @Transactional
    public Servidor update(Long id, Servidor atualizado) {
        Servidor existente = findById(id);
        existente.setNome(atualizado.getNome());
        existente.setCpf(atualizado.getCpf());
        return existente;
    }

    @Transactional
    public void delete(Long id) {
        Servidor Servidor = findById(id);
        repository.delete(String.valueOf(Servidor));
    }

    public Object findAll() {
        return repository.listAll();
    }
}

