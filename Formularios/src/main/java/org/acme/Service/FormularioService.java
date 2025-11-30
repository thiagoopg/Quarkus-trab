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
        return repository.findById(id);
    }

    @Transactional
    public Formulario updateDates(Long id, Formulario atualizado) {
        Formulario formulario = findById(id);
        formulario.setDataAbertura(atualizado.getDataAbertura());
        formulario.setDataFechamento(atualizado.getDataFechamento());
        repository.persist(formulario);
        return formulario;
    }

    @Transactional
    public void addResposta(Long id, RespostaForm resposta, String idPessoa) {
        Formulario existente = findById(id);
        PessoaDTO pessoa = pessoaRestClient.getPessoa(idPessoa);
        if(pessoa == null){throw new NotFoundException();}
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

