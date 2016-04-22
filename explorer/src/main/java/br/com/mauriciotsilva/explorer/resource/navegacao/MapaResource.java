package br.com.mauriciotsilva.explorer.resource.navegacao;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.mauriciotsilva.explorer.dominio.Mapa;
import br.com.mauriciotsilva.explorer.servico.MapaService;

@Path("mapas")
public class MapaResource {

	@Inject
	private MapaService servico;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrar(Mapa mapa) {
		servico.catalogar(mapa);
		return Response.created(null).entity(mapa).build();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Mapa trazer(@PathParam("id") Long id) {
		return servico.trazer(id);
	}

}
