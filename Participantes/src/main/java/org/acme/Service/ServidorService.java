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
        return repository.findById(id);
    }

    @Transactional
    public Servidor update(Long id, Servidor atualizado) {
        Servidor servidor = findById(id);
        servidor.setNome(atualizado.getNome());
        servidor.setCpf(atualizado.getCpf());
        repository.persist(servidor);
        return servidor;
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

