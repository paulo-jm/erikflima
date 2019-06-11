package com.guusto.buygift.merchant.mapping.query.type;

import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantTypeSearchPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantTypeSearchPreparedQueryBuilder getInstance() {
		return new MerchantTypeSearchPreparedQueryBuilder();
	}

	public MerchantTypeSearchPreparedQueryBuilder() {
		super(MerchantTypeEntity.class);
	}

}
