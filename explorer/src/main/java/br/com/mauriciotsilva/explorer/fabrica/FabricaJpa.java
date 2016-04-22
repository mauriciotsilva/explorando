package br.com.mauriciotsilva.explorer.fabrica;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class FabricaJpa {

	@Produces
	@PersistenceContext
	private EntityManager entityManager;
}
