package com.guusto.service;

import java.io.Serializable;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.mapping.repository.Repository;
import com.guusto.mapping.specification.Specification;
import com.guusto.query.PreparedQuery;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public abstract class GenericCrudService<Model extends GenericModel, Entity extends GenericEntity>
		implements CrudService<Model, GenericEntity> {

	@Override
	public void create(Model dto) {
		Entity entity = this.getConverter().createFrom(dto);
		this.getRepository().persist(entity);
		this.getConverter().updateModel(dto, entity);
	}

	@Override
	public Model update(Model dto) {

		Entity entity = this.getRepository().findById(dto.getId(), getPreparedQuery().getGenericType());
		this.getConverter().updateModel(dto, entity);

		return dto;
	}

	@Override
	public Collection<Model> findAll(PreparedQuery preparedQuery) {
		return getConverter().createFromEntities(
				getRepository().findAll(PreparedQueryBuilder.getInstance(preparedQuery).build()));
	}

	@Override
	public Model findById(@NotNull Serializable id) {
		return this.getConverter().createFrom(getRepository().findById(id, getPreparedQuery().getGenericType()));
	}

	@Override
	public Model find(Specification specification) {

		PreparedQuery preparedQuery = PreparedQueryBuilder.getInstance(this.getPreparedQuery())
				.specification(specification).build();

		return getConverter().createFrom(getRepository().find(preparedQuery));
	}

	@Override
	public Long count(PreparedQuery preparedQuery) {
		return getRepository().size(preparedQuery);
	}

	@Override
	public Long count(Specification specification) {
		return getRepository()
				.size(PreparedQueryBuilder.getInstance(this.getPreparedQuery()).specification(specification).build());
	}

	@Override
	public boolean contains(Specification specification) {
		return getRepository().contains(
				PreparedQueryBuilder.getInstance(this.getPreparedQuery()).specification(specification).build());
	}

	@Override
	public Collection<Model> findAllWithoutLimit() {
		throw new RuntimeException();
	}

	protected abstract PreparedQuery getPreparedQuery();

	protected abstract Repository<Entity> getRepository();

	protected abstract Converter<Entity, Model> getConverter();

}
