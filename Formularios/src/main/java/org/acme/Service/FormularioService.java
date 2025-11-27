package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.Entity.Formulario;
import org.acme.Entity.RespostaForm;
import org.acme.Repository.FormularioRepository;

import java.util.List;

@ApplicationScoped
public class FormularioService {

    @Inject
    FormularioRepository repository;

    @Transactional
    public Formulario create(Formulario Formulario) {
        repository.persist(Formulario);
        return Formulario;
    }

    public List<Formulario> findAll() {
        return repository.listAll();
    }
    public Formulario findById(Long id) {
        return (Formulario) repository.findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Formulario não encontrada"));
    }

    @Transactional
    public Formulario updateDates(Long id, Formulario atualizado) {
        Formulario existente = findById(id);
        existente.setDataAbertura(atualizado.getDataAbertura());
        existente.setDataFechamento(atualizado.getDataFechamento());
        return existente;
    }

    @Transactional
    public List<RespostaForm> addResposta(Long id, RespostaForm resposta) {
        Formulario existente = findById(id);
        existente.getRespostas().add(resposta);
        return existente.getRespostas();
    }

    @Transactional
    public void delete(Long id) {
        Formulario Formulario = findById(id);
        repository.delete(String.valueOf(Formulario));
    }
}

