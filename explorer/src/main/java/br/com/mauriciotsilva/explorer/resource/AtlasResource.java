package br.com.mauriciotsilva.explorer.resource;

import static javax.ws.rs.core.Response.created;
import static javax.ws.rs.core.UriBuilder.fromResource;

import java.net.URI;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.mauriciotsilva.explorer.dominio.Mapa;
import br.com.mauriciotsilva.explorer.gerenciador.GerenciadorMapa;

@Path("/v1/atlas")
@Produces("application/json")
public class AtlasResource {

	@Inject
	private GerenciadorMapa servico;

	@POST
	@Consumes("application/json")
	public Response cadastrar(Mapa mapa) {
		servico.catalogar(mapa);
		return created(criarLink(mapa)).entity(mapa).build();
	}

	@GET
	@Path("/{id}")
	public Mapa trazer(@PathParam("id") Long id) {
		return servico.trazer(id);
	}

	private URI criarLink(Mapa mapa) {
		return fromResource(AtlasResource.class).path(AtlasResource.class, "trazer").build(mapa.getId());
	}

}
