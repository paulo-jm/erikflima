package com.guusto.mapping.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import com.guusto.mapping.entity.GenericEntity;
import com.guusto.mapping.entity.GenericModel;

public interface Converter<Entity extends GenericEntity, Model extends GenericModel> {

	Entity createFrom(Model model);

	Model createFrom(Entity entity);

	Entity updateEntity(Entity entity, Model model);

	Model updateModel(Model model, Entity entity);

	default Collection<Entity> createFromModels(Collection<Model> models) {
		if (models != null && !models.isEmpty()) {
			return models.stream().map(item -> this.createFrom(item)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	default Collection<Model> createFromEntities(Collection<Entity> entities) {
		if (entities != null && !entities.isEmpty()) {
			return entities.stream().map(item -> this.createFrom(item)).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
