package com.guusto.service;

import java.io.Serializable;
import java.util.Collection;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.mapping.specification.Specification;
import com.guusto.query.PreparedQuery;

public interface CrudService<Model extends GenericModel, Entity extends GenericEntity> {

	void create(Model dto);

	Model update(Model dto);

	Collection<Model> findAll(PreparedQuery preparedQuery);

	Collection<Model> findAllWithoutLimit();

	Model find(Specification specification);

	Model findById(Serializable id);

	boolean contains(Model dto);

	boolean contains(Specification specification);

	Long count(Specification specification);

	Long count(PreparedQuery preparedQuery);
	
}
