package br.com.mauriciotsilva.explorer.gerenciador;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.mauriciotsilva.explorer.dominio.ComandoEquipamento;
import br.com.mauriciotsilva.explorer.dominio.Equipamento;
import br.com.mauriciotsilva.explorer.dominio.Mapa;
import br.com.mauriciotsilva.explorer.gerenciador.dto.CadastroEquipamento;

@Gerente
public class GerenciadorEquipamento {

	@Inject
	private EntityManager entityManager;

	@Inject
	private GerenciadorMapa mapaService;

	public Equipamento enviar(@Valid CadastroEquipamento cadastroEquipamento) {

		try {
			Mapa mapa = mapaService.trazer(cadastroEquipamento.getMapa());
			Equipamento equipamento = new Equipamento(mapa, cadastroEquipamento.getPosicao());
			entityManager.persist(equipamento);

			return equipamento;
		} catch (Exception e) {
			throw new AcaoNaoExecutadaException("Nao foi possivel enviar Equipamento", e);
		}
	}

	public ComandoEquipamento comandar(Long id, String comando) {
		return conectar(id).comandar(comando);
	}

	public Equipamento conectar(Long id) {
		return recuperar(id)
				.orElseThrow(() -> new ItemNaoLocalizadoException("Nao foi possivel localizar Equipamento solicitado"));
	}

	private Optional<Equipamento> recuperar(Long id) {

		Map<String, Object> hints = new HashMap<>();

		EntityGraph<?> graph = entityManager.getEntityGraph("graph.Equipamento.ultimosComandos");
		hints.put("javax.persistence.loadgraph", graph);

		return Optional.ofNullable(entityManager.find(Equipamento.class, id, hints));
	}

}
