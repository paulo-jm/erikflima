package com.guusto.endpoint;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.guusto.exception.GuustoException;
import com.guusto.mapping.entity.GenericModel;
import com.guusto.mapping.repository.AbstractRepository;
import com.guusto.mapping.specification.Specification;
import com.guusto.mapping.utils.ObjectMapperUtils;
import com.guusto.query.PreparedQuery;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;
import com.guusto.search.model.Paginator;
import com.guusto.search.model.Paginator.PaginatorBuild;
import com.guusto.search.model.ResultSet;
import com.guusto.search.model.ResultSet.ResultSetBuild;
import com.guusto.service.SearchService;

public abstract class GenericSearchEndpoint<Model extends GenericModel, PK extends Serializable, SP extends Specification> {

	@GetMapping(value = "/search")
	public ResponseEntity<ResultSet> search(@RequestParam(name = "limit", required = false) Long limit,
			@RequestParam(name = "offset", required = false) Long offset,
			@RequestParam(name = "specification", required = false) String specification) {

		PreparedQuery preparedQuery = PreparedQueryBuilder.getInstance(getPreparedQuery())
				.specification(getSpecificationAsObject(specification))
				.limit(limit)
				.offset(offset)
				.build();
		
		Long totalRecords = getSearchService().count(preparedQuery);
		ResultSetBuild resultSetBuild = ResultSetBuild.getInstance()
				.totalRecords(totalRecords);
		
		
		if (totalRecords > BigDecimal.ZERO.longValue()) {
			Collection<Model> results = getSearchService().search(preparedQuery);
			resultSetBuild
				.numberOfRecords(results.size())
				.results(results);
			return new ResponseEntity<>(resultSetBuild.build(), HttpStatus.OK);
		}

		return new ResponseEntity<>(resultSetBuild.build(), HttpStatus.NO_CONTENT);

	}

	@GetMapping(value = "/paginate")
	public ResponseEntity<Paginator> paginate(@RequestParam(name = "itensPerPage", required = false) Long itensPerPage,
			@RequestParam(name = "currentPage", required = false) Long currentPage,
			@RequestParam(name = "specification", required = false) String specification) {

		itensPerPage = Optional.ofNullable(itensPerPage).orElse(AbstractRepository.MAX_LIMIT);

		if (currentPage == null || currentPage == BigDecimal.ZERO.longValue() || currentPage < 1) {
			currentPage = BigDecimal.ONE.longValue();
		}

		Long offset = (itensPerPage * currentPage) - itensPerPage;

		PreparedQuery preparedQuery = PreparedQueryBuilder.getInstance(getPreparedQuery())
				.specification(getSpecificationAsObject(specification))
				.limit(itensPerPage)
				.offset(offset)
				.build();

		Long totalItens = getSearchService().count(preparedQuery);

		PaginatorBuild paginatorBuild = PaginatorBuild.getInstance()
				.currentPage(currentPage)
				.totalItens(totalItens)
				.itensPerPage(itensPerPage);

		if (totalItens > BigDecimal.ZERO.longValue()) {
			paginatorBuild.results(getSearchService().search(preparedQuery));
			return new ResponseEntity<>(paginatorBuild.build(), HttpStatus.OK);
		}

		return new ResponseEntity<>(paginatorBuild.build(), HttpStatus.NO_CONTENT);

	}

	@SuppressWarnings("unchecked")
	protected SP getSpecificationAsObject(String json) {

		if (StringUtils.isNotBlank(json)) {
			try {
				return (SP) ObjectMapperUtils.readValue(json, getSpecificationGenericType());
			} catch (GuustoException e) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
			}
		}

		return null;
	}

	protected ResponseEntity<Collection<Model>> search(PreparedQuery preparedQuery) {

		Collection<Model> models = getSearchService().search(preparedQuery);
		if (models != null && !models.isEmpty()) {
			return new ResponseEntity<>(models, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	protected abstract SearchService<Model, ?> getSearchService();

	protected abstract Class<?> getSpecificationGenericType();

	protected abstract PreparedQuery getPreparedQuery();

}
