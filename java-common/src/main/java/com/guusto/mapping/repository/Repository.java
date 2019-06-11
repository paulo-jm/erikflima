package com.guusto.mapping.repository;

import java.io.Serializable;
import java.util.Collection;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.query.PreparedQuery;

public interface Repository<Entity extends GenericEntity> {

	void persist(Entity entity);

	Entity merge(Entity entity);

	void remove(Entity entity);

	void detach(Entity entity);

	void detach(Collection<Entity> data);

	void refresh(Entity entity);

	void flush();

	Entity find(PreparedQuery preparedQuery);

	Collection<Entity> findAll(PreparedQuery preparedQuery);

	long size(PreparedQuery preparedQuery);

	boolean contains(PreparedQuery preparedQuery);

	Entity findById(Serializable id, Class<?> clazz);

}
