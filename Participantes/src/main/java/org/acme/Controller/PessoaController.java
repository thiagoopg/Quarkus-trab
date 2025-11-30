package org.acme.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.Pessoa;
import org.acme.Service.PessoaService;

@Path("/Pessoas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PessoaController {

    @Inject
    PessoaService service;

    @POST
    public Response create(Pessoa Pessoa) {
        Pessoa entity = service.create(Pessoa);
        return Response.status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service
                .findById(id))
                .build();
    }
    @GET
    public Response findAll() {
        var lista = service.findAll();

        return Response.ok(lista).build();
    }



    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Pessoa Pessoa) {
        return Response.ok(service
                .update(id, Pessoa))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response
                .noContent()
                .build();
    }
}

