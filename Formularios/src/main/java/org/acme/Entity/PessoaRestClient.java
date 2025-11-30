package org.acme.Entity;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.DTO.PessoaDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/Pessoas")
@RegisterRestClient(configKey = "pessoas-service")
public interface PessoaRestClient {

    @GET
    @Path("/{id}")
    PessoaDTO getPessoa(@PathParam("id") String id);  // PessoaDTO local
}