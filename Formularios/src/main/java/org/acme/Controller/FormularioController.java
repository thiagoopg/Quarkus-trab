package org.acme.Controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.Entity.Formulario;
import org.acme.Entity.RespostaForm;
import org.acme.Service.FormularioService;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path("/Formularios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FormularioController {

    @Inject
    FormularioService service;

    @POST
    @Retry(maxRetries = 2, delay = 2000)
    @Fallback(fallbackMethod = "mensagem")
    @Timeout(3000)
    public Response create() {
        Formulario entity = service.create();
        return Response.status(Response.Status.CREATED)
                .entity(entity)
                .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(service
                        .findAll())
                .build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service
                        .findById(id))
                .build();
    }

    @PUT
    @Path("/{id}/dates")
    public Response updateDates(@PathParam("id") Long id, Formulario Formulario) {
        return Response.ok(service
                        .updateDates(id, Formulario))
                .build();
    }
    @PUT
    @Path("/{id}/Resposta")
    public Response AddResposta(@PathParam("id") Long id, RespostaForm RespostaForm) {
        return Response.ok(service
                        .addResposta(id, RespostaForm))
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
    public String mensagem() {
        return "Erro na criação";
    }
}

