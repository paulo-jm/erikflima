package com.guusto.buygift.merchant.mapping.query.type;

import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantTypeCrudPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantTypeCrudPreparedQueryBuilder getInstance() {
		return new MerchantTypeCrudPreparedQueryBuilder();
	}

	public MerchantTypeCrudPreparedQueryBuilder() {
		super(MerchantTypeEntity.class);
	}

}
