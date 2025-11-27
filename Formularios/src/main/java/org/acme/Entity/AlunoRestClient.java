package org.acme.Entity;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.DTO.AlunoDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/alunos")
@RegisterRestClient
public interface AlunoRestClient {

    @GET
    @Path("/{id}")
    AlunoDTO getAluno(@PathParam("id") Long id);  // AlunoDTO local
}