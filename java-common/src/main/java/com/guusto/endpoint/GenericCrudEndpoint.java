package com.guusto.endpoint;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.mapping.specification.Specification;
import com.guusto.query.PreparedQuery;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;
import com.guusto.service.CrudService;

public abstract class GenericCrudEndpoint<Model extends GenericModel, PK extends Serializable, SP extends Specification> {

	protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@PostMapping
	public ResponseEntity<Model> create(@Valid @NotNull @RequestBody Model model, HttpServletResponse response) {

		if (!getCrudService().contains(model)) {
			getCrudService().create(model);
			return new ResponseEntity<>(model, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);

	}

	@GetMapping
	public ResponseEntity<Collection<Model>> findAll(@RequestParam(name = "limit", required = false) Long limit,
			@RequestParam(name = "offset", required = false) Long offset,
			@RequestParam(name = "specification", required = false) String specification) {

		PreparedQuery preparedQuery = PreparedQueryBuilder.getInstance(getPreparedQuery())
				.specification(getSpecificationAsObject(specification))
				.limit(limit)
				.offset(offset)
				.build();

		return findAll(preparedQuery);

	}
	
	@GetMapping(value = "/count")
	public ResponseEntity<Long> count(@RequestParam(name = "specification", required = true) String specification) {
		return new ResponseEntity<>(getCrudService().count(getSpecificationAsObject(specification)), HttpStatus.OK);
	}

	@GetMapping(value = "/find")
	public ResponseEntity<Model> find(@RequestParam(name = "specification", required = true) String specification) {
		
		Model model = getCrudService().find(getSpecificationAsObject(specification));
		if (model != null ) {
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "/contains")
	public ResponseEntity<Boolean> contains(@RequestParam(name = "specification", required = true) String specification) {
		return new ResponseEntity<>(getCrudService().contains(getSpecificationAsObject(specification)), HttpStatus.OK);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Model update(@NotNull @PathVariable("id") PK id, @Valid @NotNull @RequestBody Model dto) {
		return getCrudService().update(dto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Model> findById(@NotNull @PathVariable("id") PK id) {

		Model model = getCrudService().findById(id);
		if (model != null) {
			return new ResponseEntity<>(model, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@SuppressWarnings("unchecked")
	protected SP getSpecificationAsObject(String json) {

		if (StringUtils.isNotBlank(json)) {
			try {
				return (SP) OBJECT_MAPPER.readValue(json, getSpecificationGenericType());
			} catch (IOException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			}
		}

		return null;
	}

	protected ResponseEntity<Collection<Model>> findAll(PreparedQuery preparedQuery) {

		Collection<Model> models = getCrudService().findAll(preparedQuery);
		if (models != null && !models.isEmpty()) {
			return new ResponseEntity<>(models, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	protected abstract CrudService<Model, ?> getCrudService();

	protected abstract Class<?> getSpecificationGenericType();

	protected abstract PreparedQuery getPreparedQuery();

}
