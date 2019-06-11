package com.guusto.service;

import java.util.Collection;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.query.PreparedQuery;

public interface SearchService<Model extends GenericModel, Entity extends GenericEntity> {

	Collection<Model> search(PreparedQuery preparedQuery);

	Collection<Model> paginate(PreparedQuery preparedQuery);

	Long count(PreparedQuery preparedQuery);

}
