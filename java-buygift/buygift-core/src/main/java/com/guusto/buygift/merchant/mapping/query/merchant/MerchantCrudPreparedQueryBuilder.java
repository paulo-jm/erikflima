package com.guusto.buygift.merchant.mapping.query.merchant;

import javax.persistence.criteria.JoinType;

import com.guusto.buygift.merchant.mapping.entity.MerchantEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantEntity_;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;
import com.guusto.query.join.QueryJoinType;

public class MerchantCrudPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantCrudPreparedQueryBuilder getInstance() {
		return new MerchantCrudPreparedQueryBuilder();
	}

	public MerchantCrudPreparedQueryBuilder() {
		super(MerchantEntity.class);

		addJoin(MerchantEntity_.merchantDenominations, QueryJoinType.FETCH, JoinType.LEFT);

	}

}
