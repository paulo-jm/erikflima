package com.guusto.buygift.merchant.mapping.specification;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.guusto.buygift.merchant.mapping.entity.MerchantEntity_;
import com.guusto.buygift.merchant.mapping.model.MerchantType;
import com.guusto.buygift.merchant.mapping.model.ShoppingOption;
import com.guusto.mapping.specification.Specification;
import com.guusto.query.ExpressionHandler;
import com.guusto.query.PredicateUtils;
import com.guusto.query.PreparedQuery;

public class SearchMerchant implements Specification {

	private List<Long> ids;

	private List<BigDecimal> merchantDenominations;

	private BigDecimal amount;

	private ShoppingOption shoppingOption;

	private MerchantType type;

	private Locale country;

	private String currency;
	
	private String q;

	@Override
	public <T> Predicate toPredicate(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, Root<?> root,
			PreparedQuery preparedQuery, ExpressionHandler expressionHandler) {

		Predicate idsPredicate = PredicateUtils.in(ids, expressionHandler.getExpression(MerchantEntity_.id), criteriaBuilder);

		Predicate merchantDenominationsPredicate = PredicateUtils.in(merchantDenominations, expressionHandler.getExpression("merchantDenominations"), criteriaBuilder);

		Predicate amountPredicate = PredicateUtils.and(criteriaBuilder,
				PredicateUtils.greaterThanOrEqual(amount, expressionHandler.getExpression(MerchantEntity_.minAmount), criteriaBuilder),
				PredicateUtils.lessThanOrEqual(amount, expressionHandler.getExpression(MerchantEntity_.maxAmount), criteriaBuilder));

		Predicate shoppingOptionPredicate = PredicateUtils.equal(shoppingOption, expressionHandler.getExpression(MerchantEntity_.shoppingOption), criteriaBuilder);

		Predicate typePredicate = PredicateUtils.equal(type, expressionHandler.getExpression(MerchantEntity_.type), criteriaBuilder);

		Predicate countryPredicate = PredicateUtils.equal(country, expressionHandler.getExpression(MerchantEntity_.country), criteriaBuilder);

		Predicate currencyPredicate = PredicateUtils.equal(currency, expressionHandler.getExpression(MerchantEntity_.currency), criteriaBuilder);

		Predicate qPredicate = PredicateUtils.or(criteriaBuilder,
				PredicateUtils.like(q, expressionHandler.getExpression(MerchantEntity_.merchantName), criteriaBuilder));
		
		return PredicateUtils.and(criteriaBuilder, idsPredicate, merchantDenominationsPredicate, amountPredicate,
				shoppingOptionPredicate, typePredicate, countryPredicate, currencyPredicate, qPredicate);

	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public List<BigDecimal> getMerchantDenominations() {
		return merchantDenominations;
	}

	public void setMerchantDenominations(List<BigDecimal> merchantDenominations) {
		this.merchantDenominations = merchantDenominations;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ShoppingOption getShoppingOption() {
		return shoppingOption;
	}

	public void setShoppingOption(ShoppingOption shoppingOption) {
		this.shoppingOption = shoppingOption;
	}

	public MerchantType getType() {
		return type;
	}

	public void setType(MerchantType type) {
		this.type = type;
	}

	public Locale getCountry() {
		return country;
	}

	public void setCountry(Locale country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
}
