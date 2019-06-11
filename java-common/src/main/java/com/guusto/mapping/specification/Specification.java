package com.guusto.mapping.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.guusto.query.ExpressionHandler;
import com.guusto.query.PreparedQuery;

public interface Specification {

	public <T> Predicate toPredicate(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<?> root,
			PreparedQuery preparedQuery, ExpressionHandler expressionHandler);

}
