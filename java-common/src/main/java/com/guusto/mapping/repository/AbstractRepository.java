package com.guusto.mapping.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.query.ExpressionHandler;
import com.guusto.query.PreparedQuery;
import com.guusto.query.QueryHandler;


public abstract class AbstractRepository<T extends GenericEntity> implements Repository<T> {

	public static final Long MAX_LIMIT = Long.valueOf(10);

	@Override
	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	@Override
	public T merge(T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public void remove(T entity) {
		T t = merge(entity);
		getEntityManager().remove(t);
	}

	@Override
	public void detach(T entity) {
		getEntityManager().detach(entity);
	}

	@Override
	public void detach(Collection<T> data) {
		for (T entity : data) {
			detach(entity);
		}
	}

	@Override
	public void refresh(T entity) {
		getEntityManager().refresh(entity);
	}

	@Override
	public void flush() {
		getEntityManager().flush();
	}
	
	@Override
	public T find(PreparedQuery preparedQuery) {
		return createTypedQuery(preparedQuery).getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public T findById(Serializable id, Class<?> clazz) {
		return (T) getEntityManager().find(clazz, id);
	}

	@Override
	public Collection<T> findAll(PreparedQuery preparedQuery) {
		TypedQuery<T> typedQuery = createTypedQuery(preparedQuery);
		prepareNumberOfRecords(preparedQuery, typedQuery);
		return typedQuery.getResultList();
	}

	@Override
	public boolean contains(PreparedQuery preparedQuery) {
		return size(preparedQuery) > 0;
	}

	@Override
	public long size(PreparedQuery preparedQuery) {

		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<T> root = criteriaQuery.from(getGenericClassType(preparedQuery));

		boolean disableFetch = !criteriaQuery.getResultType().equals(preparedQuery.getGenericType());
		ExpressionHandler expressionHandler = ExpressionHandler.getInstance(root, preparedQuery.getJoins(), disableFetch);
		
		QueryHandler.getInstance().prepareQuery(criteriaBuilder, criteriaQuery, root, preparedQuery, expressionHandler);

		criteriaQuery.select(criteriaBuilder.count(root));

		return getEntityManager().createQuery(criteriaQuery).getSingleResult();

	}

	protected TypedQuery<T> createTypedQuery(PreparedQuery preparedQuery) {

		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getGenericClassType(preparedQuery));
		Root<T> root = criteriaQuery.from(getGenericClassType(preparedQuery));

		ExpressionHandler expressionHandler = ExpressionHandler.getInstance(root, preparedQuery.getJoins());
		
		QueryHandler.getInstance().prepareWhere(criteriaBuilder, criteriaQuery, root, preparedQuery, expressionHandler);

		criteriaQuery.select(root);

		return  getEntityManager().createQuery(criteriaQuery);

	}

	@SuppressWarnings("unchecked")
	private Class<T> getGenericClassType(PreparedQuery preparedQuery) {
		return (Class<T>) preparedQuery.getGenericType();
	}

	protected void prepareNumberOfRecords(PreparedQuery preparedQuery, TypedQuery<T> typedQuery) {

		typedQuery.setMaxResults(Optional.ofNullable(preparedQuery.getLimit()).orElse(MAX_LIMIT).intValue());
		typedQuery.setFirstResult(Optional.ofNullable(preparedQuery.getOffest()).orElse(BigDecimal.ZERO.longValue()).intValue());

	}
	
	protected abstract EntityManager getEntityManager();

}