package br.com.fiap.portoapi.controller;


import java.net.URI;
import java.util.List;

import br.com.fiap.portoapi.model.Health;
import br.com.fiap.portoapi.model.repository.HealthRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.UriBuilder;


@Path("/health")
public class HealthResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {

		List<Health> retorno = HealthRepository.findAll();

		ResponseBuilder response = Response.ok();
		response.entity(retorno);

		return response.build();

	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Health health) {
        
        Health updatedHealth = HealthRepository.save(health);

        if (updatedHealth != null) {
            return Response.status(Response.Status.CREATED)
                    .entity("Atualizado com sucesso")
                    .build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar no banco de dados")
                    .build();
        }
    }

	
	@DELETE
	@Path("/{ID_PAC}")
	public Response delete (@PathParam("ID_PAC") Long HealthId ) {
	
		if (HealthRepository.delete(HealthId) ) {
			ResponseBuilder response = Response.noContent();	
			return response.build();
		}else {
			System.out.println("id "+ HealthId + " removido: ");
			ResponseBuilder response = Response.notModified();
			return response.build();
		}
		
	}
	
	
	@PUT
	@Path("/{ID_PAC}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("ID_PAC") Long id, @Valid Health health ) {
		
		Health velho = HealthRepository.findById(id);
		Health novo = null;
		
		if(velho == null || velho.getId() != health.getId() ) {
			novo = HealthRepository.save(health);
			
			final URI healthUri = UriBuilder
					.fromResource(HealthResource.class)
					.path("/health/{ID_PAC}")
					.build(novo.getId());
			
			ResponseBuilder response = Response.created(healthUri);
			response.entity(novo);
			
			return response.build();
			
		}
		
		
		novo = HealthRepository.update(health);
		
		return Response.ok(novo).build();

		
	}
	

	@GET
	@Path("/{ID_PAC}")
	public Response findById(@PathParam("ID_PAC") Long HealthId ) {
		Health health = HealthRepository.findById(HealthId);
		
		if(health!=null) {
			ResponseBuilder response = Response.ok();
			response.entity(health);
			
			return response.build();
		}else {
			ResponseBuilder response = Response.noContent();
			return response.build();
		}
		
	}
	
	
	
	
}
