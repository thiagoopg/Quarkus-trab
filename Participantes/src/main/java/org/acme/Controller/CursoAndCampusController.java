package org.acme.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Service.CursoAndCampusService;

@Path("/cc")
@Produces(MediaType.APPLICATION_JSON)
public class CursoAndCampusController {

    @Inject
    CursoAndCampusService service;

    @GET
    @Path("/Campus")
    public Response findAllCampus() {
        var lista = service.findAllCampus();

        return Response.ok(lista).build();
    }

    @GET
    @Path("/Curso")
    public Response findAllCurso() {
        var lista = service.findAllCurso();

        return Response.ok(lista).build();
    }
}
