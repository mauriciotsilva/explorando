package br.com.mauriciotsilva.explorer.servico;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import br.com.mauriciotsilva.explorer.dominio.Mapa;

@Transactional(Transactional.TxType.REQUIRED)
public class MapaService {

	@Inject
	private EntityManager entityManager;

	public void catalogar(Mapa mapa) {
		entityManager.persist(mapa);
	}

	public Mapa trazer(Long id) {
		Mapa mapa = entityManager.find(Mapa.class, id);
		if (mapa == null) {
			throw new RecursoNaoLocalizadoException("Nao foi possivel localizar o Mapa desejado");
		}
		return mapa;
	}

}
