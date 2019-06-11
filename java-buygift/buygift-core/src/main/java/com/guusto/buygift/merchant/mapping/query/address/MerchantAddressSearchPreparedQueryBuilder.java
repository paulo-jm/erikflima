package com.guusto.buygift.merchant.mapping.query.address;

import com.guusto.buygift.merchant.mapping.entity.MerchantAddressEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantAddressSearchPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantAddressSearchPreparedQueryBuilder getInstance() {
		return new MerchantAddressSearchPreparedQueryBuilder();
	}

	public MerchantAddressSearchPreparedQueryBuilder() {
		super(MerchantAddressEntity.class);
	}

}
