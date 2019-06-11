package com.guusto.buygift.mapping.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.repository.AbstractRepository;

@Service
public class BuygiftRepository<Entity extends GenericEntity> extends AbstractRepository<Entity> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
