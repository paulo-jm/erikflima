package com.guusto.query;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class QueryHandler {

	private static QueryHandler queryHandler;

	public static QueryHandler getInstance() {
		if (queryHandler == null) {
			queryHandler = new QueryHandler();
		}

		return queryHandler;
	}

	private QueryHandler() {
		super();
	}

	public <T> void prepareQuery(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<T> root,
			PreparedQuery preparedQuery, ExpressionHandler expressionHandler) {

		prepareWhere(criteriaBuilder, criteriaQuery, root, preparedQuery, expressionHandler);

	}

	public <T> void prepareWhere(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<?> root,
			PreparedQuery preparedQuery, ExpressionHandler expressionHandler) {

		if (preparedQuery.getSpecification() != null) {
			Predicate predicate = preparedQuery.getSpecification().toPredicate(criteriaBuilder, criteriaQuery, root,
					preparedQuery, expressionHandler);

			if (Optional.ofNullable(predicate).isPresent()) {
				criteriaQuery.where(predicate);
			}
		}

	}

}
