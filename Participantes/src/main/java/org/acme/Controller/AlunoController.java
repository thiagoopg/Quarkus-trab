package org.acme.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.Aluno;
import org.acme.Service.AlunoService;

@Path("/Alunos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlunoController {

    @Inject
    AlunoService service;

    @POST
    public Response create(Aluno Aluno) {
        Aluno entity = service.create(Aluno);
        return Response.status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        if(service.findById(id) == null){return Response.status(Response.Status.NOT_FOUND).build();}

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
    public Response update(@PathParam("id") Long id, Aluno Aluno) {
        if(service.findById(id) == null){return Response.status(Response.Status.NOT_FOUND).build();}
        return Response.ok(service
                .update(id, Aluno))
                .build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        if(service.findById(id) == null){return Response.status(Response.Status.NOT_FOUND).build();}
        service.delete(id);
        return Response
                .noContent()
                .build();
    }
}

