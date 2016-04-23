package br.com.mauriciotsilva.explorer.gerenciador;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;

import br.com.mauriciotsilva.explorer.dominio.Mapa;

@Gerente
public class GerenciadorMapa {

	@Inject
	private EntityManager entityManager;

	public void catalogar(@Valid Mapa mapa) {
		try {
			mapa.getPlanalto();
			entityManager.persist(mapa);
		} catch (Exception e) {
			throw new AcaoNaoExecutadaException("Nao foi possivel catalogar Mapa", e);
		}
	}

	public Mapa trazer(Long id) {
		Mapa mapa = entityManager.find(Mapa.class, id);
		if (mapa == null) {
			throw new ItemNaoLocalizadoException("Nao foi possivel localizar o Mapa desejado");
		}
		return mapa;
	}

}
