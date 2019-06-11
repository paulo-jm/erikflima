package com.guusto.buygift.merchant.mapping.query.partner;

import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantPartnerCrudPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantPartnerCrudPreparedQueryBuilder getInstance() {
		return new MerchantPartnerCrudPreparedQueryBuilder();
	}

	public MerchantPartnerCrudPreparedQueryBuilder() {
		super(MerchantPartnerEntity.class);
	}

}
