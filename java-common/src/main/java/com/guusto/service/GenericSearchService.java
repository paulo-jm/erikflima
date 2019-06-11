package com.guusto.service;

import java.util.Collection;

import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public abstract class GenericSearchService<Model extends GenericModel, Entity extends GenericEntity>
		implements SearchService<Model, GenericEntity> {

	@Override
	public Collection<Model> search(PreparedQuery preparedQuery) {
		return getConverter()
				.createFromEntities(getRepository().findAll(PreparedQueryBuilder.getInstance(preparedQuery).build()));
	}

	@Override
	public Collection<Model> paginate(PreparedQuery preparedQuery) {
		return getConverter()
				.createFromEntities(getRepository().findAll(PreparedQueryBuilder.getInstance(preparedQuery).build()));
	}
	
	@Override
	public Long count(PreparedQuery preparedQuery) {
		return getRepository().size(preparedQuery);
	}

	protected abstract PreparedQuery getPreparedQuery();

	protected abstract Repository<Entity> getRepository();

	protected abstract Converter<Entity, Model> getConverter();

}
