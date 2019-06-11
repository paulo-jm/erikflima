package com.guusto.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class PredicateUtils {

	public static Predicate[] removeAllNullFromArray(Predicate... predicates) {

		if (ArrayUtils.isNotEmpty(predicates)) {
			List<Predicate> list = new ArrayList<>();
			for (Predicate predicate : predicates) {
				if (predicate != null) {
					list.add(predicate);
				}
			}
			if (!list.isEmpty()) {
				Predicate[] array = new Predicate[list.size()];
				list.toArray(array);
				return array;
			}
		}
		return null;

	}

	public static Predicate and(CriteriaBuilder criteriaBuilder, Predicate... predicates) {

		if (ArrayUtils.isNotEmpty(predicates)) {
			Predicate[] array = removeAllNullFromArray(predicates);
			if (ArrayUtils.isNotEmpty(array)) {
				return criteriaBuilder.and(array);
			}
		}

		return null;
	}

	public static Predicate or(CriteriaBuilder criteriaBuilder, Predicate... predicates) {

		if (ArrayUtils.isNotEmpty(predicates)) {
			Predicate[] array = removeAllNullFromArray(predicates);
			if (ArrayUtils.isNotEmpty(array)) {
				return criteriaBuilder.or(array);
			}
		}

		return null;
	}

	public static Predicate equal(Object value, Expression<?> expression, CriteriaBuilder criteriaBuilder) {

		if (value != null) {

			if (value instanceof String) {
				String str = (String) value;
				if (StringUtils.isNotBlank(str)) {
					return criteriaBuilder.equal(criteriaBuilder.lower(expression.as(String.class)), str.toLowerCase());
				}
			}

			return criteriaBuilder.equal(expression, value);
		}

		return null;
	}

	public static Predicate like(String value, Expression<?> expression, CriteriaBuilder criteriaBuilder) {

		if (StringUtils.isNotBlank(value)) {
			return criteriaBuilder.like(criteriaBuilder.lower(expression.as(String.class)),
					"%" + value.toLowerCase() + "%");
		}

		return null;
	}

	public static Predicate greaterThanOrEqual(Number value, Expression<?> expression,
			CriteriaBuilder criteriaBuilder) {

		if (value != null) {
			return criteriaBuilder.ge(expression.as(value.getClass()), value);
		}

		return null;
	}

	public static Predicate lessThanOrEqual(Number value, Expression<?> expression, CriteriaBuilder criteriaBuilder) {

		if (value != null) {
			return criteriaBuilder.le(expression.as(value.getClass()), value);
		}

		return null;
	}

	public static Predicate between(Number stat, Number end, Expression<?> expression,
			CriteriaBuilder criteriaBuilder) {
		return and(criteriaBuilder, greaterThanOrEqual(stat, expression, criteriaBuilder),
				lessThanOrEqual(end, expression, criteriaBuilder));
	}

	public static Predicate in(Collection<?> ins, Expression<?> expression, CriteriaBuilder criteriaBuilder) {

		if (ins != null && !ins.isEmpty()) {
			return expression.in(ins);
		}

		return null;
	}

}
