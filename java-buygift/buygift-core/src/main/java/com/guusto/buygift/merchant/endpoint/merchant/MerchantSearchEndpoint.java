package com.guusto.buygift.merchant.endpoint.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.Merchant;
import com.guusto.buygift.merchant.mapping.query.merchant.MerchantCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchant;
import com.guusto.buygift.merchant.service.merchant.MerchantSearchService;
import com.guusto.endpoint.GenericSearchEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.SearchService;

@RestController
@RequestMapping("/merchant/merchant")
public class MerchantSearchEndpoint extends GenericSearchEndpoint<Merchant, Long, SearchMerchant> {
	
	@Autowired
	private MerchantSearchService merchantSearchService;
	
	@Override
	protected SearchService<Merchant, ?> getSearchService() {
		return merchantSearchService;
	}

	@Override
	protected Class<?> getSpecificationGenericType() {
		return SearchMerchant.class;
	}
	
	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantCrudPreparedQueryBuilder.getInstance().build();
	}

}
