package com.guusto.buygift.merchant.mapping.query.partner;

import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantPartnerSearchPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantPartnerSearchPreparedQueryBuilder getInstance() {
		return new MerchantPartnerSearchPreparedQueryBuilder();
	}

	public MerchantPartnerSearchPreparedQueryBuilder() {
		super(MerchantPartnerEntity.class);
	}

}
