package org.acme.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.Servidor;
import org.acme.Service.ServidorService;

@Path("/Servidores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ServidorController {

    @Inject
    ServidorService service;

    @POST
    public Response create(Servidor Servidor) {
        Servidor entity = service.create(Servidor);
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
    public Response update(@PathParam("id") Long id, Servidor Servidor) {
        return Response.ok(service
                .update(id, Servidor))
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

