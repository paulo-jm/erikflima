package com.guusto.buygift.merchant.endpoint.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantType;
import com.guusto.buygift.merchant.mapping.query.type.MerchantTypeCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantType;
import com.guusto.buygift.merchant.service.type.MerchantTypeSearchService;
import com.guusto.endpoint.GenericSearchEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.SearchService;

@RestController
@RequestMapping("/merchant/type")
public class MerchantTypeSearchEndpoint extends GenericSearchEndpoint<MerchantType, Long, SearchMerchantType> {
	
	@Autowired
	private MerchantTypeSearchService merchantSearchService;
	
	@Override
	protected SearchService<MerchantType, ?> getSearchService() {
		return merchantSearchService;
	}

	@Override
	protected Class<?> getSpecificationGenericType() {
		return SearchMerchantType.class;
	}
	
	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantTypeCrudPreparedQueryBuilder.getInstance().build();
	}

}
