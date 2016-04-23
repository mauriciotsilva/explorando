package br.com.mauriciotsilva.explorer.resource;

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

import br.com.mauriciotsilva.explorer.dominio.ComandoEquipamento;
import br.com.mauriciotsilva.explorer.dominio.Equipamento;
import br.com.mauriciotsilva.explorer.gerenciador.GerenciadorEquipamento;
import br.com.mauriciotsilva.explorer.gerenciador.dto.CadastroEquipamento;
import br.com.mauriciotsilva.explorer.resource.dto.ComandoRemoto;

@Path("/v1/equipamentos")
@Produces("application/json")
public class EquipamentoResource {

	@Inject
	private GerenciadorEquipamento gerente;

	@POST
	@Consumes("application/json")
	public Response cadastrar(CadastroEquipamento cadastro) {

		Equipamento equipamento = gerente.enviar(cadastro);
		return Response.created(criarLink(equipamento)).entity(equipamento).build();
	}

	@GET
	@Path("/{id}")
	public Equipamento trazer(@PathParam("id") Long id) {
		return gerente.conectar(id);
	}

	@POST
	@Path("/{id}/comandos")
	public Response comandar(@PathParam("id") Long id, ComandoRemoto comandoRemoto) {
		ComandoEquipamento comando = gerente.comandar(id, comandoRemoto.getComando());
		return Response.created(criarLink(id)).entity(comando).build();
	}

	private URI criarLink(Equipamento equipamento) {
		return criarLink(equipamento.getId());
	}

	private URI criarLink(Long id) {
		return fromResource(EquipamentoResource.class).path(EquipamentoResource.class, "trazer").build(id);
	}

}
