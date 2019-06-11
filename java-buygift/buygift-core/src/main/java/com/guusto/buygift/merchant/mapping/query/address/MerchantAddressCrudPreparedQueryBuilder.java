package com.guusto.buygift.merchant.mapping.query.address;

import com.guusto.buygift.merchant.mapping.entity.MerchantAddressEntity;
import com.guusto.query.PreparedQuery.PreparedQueryBuilder;

public class MerchantAddressCrudPreparedQueryBuilder extends PreparedQueryBuilder {

	public static MerchantAddressCrudPreparedQueryBuilder getInstance() {
		return new MerchantAddressCrudPreparedQueryBuilder();
	}

	public MerchantAddressCrudPreparedQueryBuilder() {
		super(MerchantAddressEntity.class);
	}

}
