package com.guusto.buygift.merchant.endpoint.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantAddress;
import com.guusto.buygift.merchant.mapping.query.address.MerchantAddressCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantAddress;
import com.guusto.buygift.merchant.service.address.MerchantAddressSearchService;
import com.guusto.endpoint.GenericSearchEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.SearchService;

@RestController
@RequestMapping("/merchant/address")
public class MerchantAddressSearchEndpoint extends GenericSearchEndpoint<MerchantAddress, Long, SearchMerchantAddress> {
	
	@Autowired
	private MerchantAddressSearchService merchantSearchService;
	
	@Override
	protected SearchService<MerchantAddress, ?> getSearchService() {
		return merchantSearchService;
	}

	@Override
	protected Class<?> getSpecificationGenericType() {
		return SearchMerchantAddress.class;
	}
	
	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantAddressCrudPreparedQueryBuilder.getInstance().build();
	}

}
