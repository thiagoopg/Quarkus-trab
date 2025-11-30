package org.acme.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.acme.DTO.PessoaDTO;
import org.acme.Entity.Formulario;
import org.acme.Entity.PessoaRestClient;
import org.acme.Entity.RespostaForm;
import org.acme.Repository.FormularioRepository;
import org.acme.Repository.ResFormularioRepository;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class FormularioService {

    @Inject
    FormularioRepository repository;

    @Inject
    ResFormularioRepository repositoryResposta;

    @Inject
    @RestClient
    PessoaRestClient pessoaRestClient;

    @Transactional
    @Retry(maxRetries = 3, delay = 2000)
    public Formulario create() {
        Formulario formulario = new Formulario();

        formulario.setDataAbertura(LocalDate.now());
        formulario.setDataFechamento(LocalDate.now().plusDays(7)); // exemplo

        repository.persist(formulario);

        return formulario;
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
    public void addResposta(Long id, RespostaForm resposta, String idPessoa) {
        Formulario existente = findById(id);
        PessoaDTO pessoa = pessoaRestClient.getPessoa(idPessoa);
        resposta.setPessoa(pessoa);
        resposta.setFormulario(existente);
        existente.getRespostas().add(resposta);
        repository.persist(existente);
        repositoryResposta.persist(resposta);
    }

    @Transactional
    public void delete(Long id) {
        Formulario Formulario = findById(id);
        repository.delete(String.valueOf(Formulario));
    }
}

