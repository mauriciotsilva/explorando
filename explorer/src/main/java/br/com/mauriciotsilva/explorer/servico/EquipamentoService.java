package br.com.mauriciotsilva.explorer.servico;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.mauriciotsilva.explorer.dominio.ComandoEquipamento;
import br.com.mauriciotsilva.explorer.dominio.Equipamento;
import br.com.mauriciotsilva.explorer.dominio.Mapa;

public class EquipamentoService {

	@Inject
	private EntityManager entityManager;

	@Inject
	private MapaService mapaService;

	public Equipamento enviar(Long idMapa, String posicao) {

		Mapa mapa = mapaService.trazer(idMapa);

		Equipamento equipamento = new Equipamento(mapa, posicao);
		entityManager.persist(equipamento);

		return equipamento;
	}

	public ComandoEquipamento enviarComandoRemoto(Long id, String comando) {
		Equipamento equipamento = trazer(id);
		return equipamento.comandar(comando);
	}

	public Equipamento trazer(Long id) {
		Equipamento equipamento = entityManager.find(Equipamento.class, id);
		if (equipamento == null) {
			throw new RecursoNaoLocalizadoException("Nao foi possivel localizar Equipamento solicitado");
		}
		return equipamento;
	}

}
