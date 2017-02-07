package br.com.testemeta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.testemeta.entity.AbstractEntity;


public abstract class AbstractDAO<T extends AbstractEntity> {

	private EntityManagerFactory emf;
	private EntityManager manager;
	private final static String PU = "testemetaPU";

	public AbstractDAO() {
		emf = Persistence.createEntityManagerFactory(PU);
		manager = emf.createEntityManager();

	}
	
	public EntityManager getManager(){
		return manager;
	}

	public void begin(){
		try{
			manager.flush();
			manager.clear();
		}catch(Exception e){
			
		}
		manager.getTransaction().begin();
	}

	public void commit(){
		manager.getTransaction().commit();
		try{
			manager.flush();
			manager.clear();
		}catch(Exception e){
			
		}
	}

	public void rollback(){
		manager.getTransaction().rollback();
	}
	
	/**
	 * Save an entity using JPA
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T save(final T entity) throws Exception {
		try {
			manager.persist(entity);
			return entity;
		} catch (final Exception e) {
			throw e;
		}
	}

	
	/**
	 * Remove an entity using JPA
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T remove(final T entity) throws Exception {

		try {
			manager.remove(manager.getReference(entity(), entity.getId()));
			return entity;
		} catch (final Exception e) {
			throw e;
		}
	}

	/**
	 * Update an entity using JPA
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public T update(final T entity) throws Exception {

		try {
			manager.merge(entity);
			return entity;

		} catch (final Exception e) {
			throw e;
		}

	}

	/**
	 * Get an entity by code
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T get(final int code) throws Exception {

		try {
			manager.clear();
			
			T result = (T) manager.find(entity(), code);

			return result;

		} catch (final Exception e) {
			throw e;
		}

	}

	/**
	 * Get a list with all the Entities
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() throws Exception {

		try {
			manager.clear();
			
			final List<T> colEntities = (List<T>) manager
					.createQuery(
							"select model from " + entity().getSimpleName()
									+ " model").getResultList();
			
			return colEntities;
		} catch (final Exception e) {
			throw e;
		}


	}

	/**
	 * Get an entity using a where clause
	 * @param where
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public T getBy(final String where) throws Exception {
		try {
			manager.clear();
			
			final T entity = (T) manager
					.createQuery(
							"select model from " + entity().getSimpleName()
									+ " model " + where).getSingleResult();

			if (entity == null)
				return null;
			
			return entity;

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			throw e;
		}

	}

	
	/**
	 * Get a list of entities with where clause
	 * @param where
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> findBy(final String where) throws Exception {

		try {
			manager.clear();
			
			String sql = "select model from " + entity().getSimpleName()
			+ " model " + where;
			final List<T> colEntities = (List<T>) manager
					.createQuery(sql).getResultList();
			
			return colEntities;
		} catch (final Exception e) {
			throw e;
		}

	}
	
	/**
	 * Get the entity from the sub class
	 * @return
	 * @throws Exception
	 */
	protected abstract Class<? extends AbstractEntity> entity()
			throws Exception;
	
}
