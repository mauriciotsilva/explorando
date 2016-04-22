package br.com.mauriciotsilva.explorer.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.mauriciotsilva.explorer.dominio.Equipamento;
import br.com.mauriciotsilva.explorer.resource.dto.CadastroEquipamento;
import br.com.mauriciotsilva.explorer.resource.dto.ComandoRemoto;
import br.com.mauriciotsilva.explorer.servico.EquipamentoService;

@Path("/equipamentos")
public class EquipamentoResource {

	@Inject
	private EquipamentoService service;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrar(CadastroEquipamento cadastro) {

		Equipamento equipamento = service.enviar(cadastro.getMapa(), cadastro.getPosicao());
		return Response.created(null).entity(equipamento).build();
	}

	@GET
	@Path("/{id}")
	public Equipamento trazer(@PathParam("id") Long id) {
		return service.trazer(id);
	}

	@POST
	@Path("/{id}/comandos")
	public void comandar(@PathParam("id") Long id, ComandoRemoto comandoRemoto) {
		service.enviarComandoRemoto(id, comandoRemoto.getComando());
	}

}
