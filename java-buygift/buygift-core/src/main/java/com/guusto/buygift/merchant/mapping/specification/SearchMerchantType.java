package com.guusto.buygift.merchant.mapping.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.guusto.buygift.merchant.mapping.entity.MerchantEntity_;
import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity_;
import com.guusto.mapping.specification.Specification;
import com.guusto.query.ExpressionHandler;
import com.guusto.query.PredicateUtils;
import com.guusto.query.PreparedQuery;

public class SearchMerchantType implements Specification {

	private List<Long> ids;

	private String q;

	@Override
	public <T> Predicate toPredicate(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<?> root,
			PreparedQuery preparedQuery, ExpressionHandler expressionHandler) {

		Predicate idsPredicate = PredicateUtils.in(ids, expressionHandler.getExpression(MerchantEntity_.id),
				criteriaBuilder);

		Predicate qPredicate = PredicateUtils.or(criteriaBuilder, PredicateUtils.like(q,
				expressionHandler.getExpression(MerchantTypeEntity_.merchantTypeName), criteriaBuilder));

		return PredicateUtils.and(criteriaBuilder, idsPredicate, qPredicate);

	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
}
