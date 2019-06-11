package com.guusto.buygift.merchant.endpoint.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantPartner;
import com.guusto.buygift.merchant.mapping.query.partner.MerchantPartnerCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantPartner;
import com.guusto.buygift.merchant.service.partner.MerchantPartnerSearchService;
import com.guusto.endpoint.GenericSearchEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.SearchService;

@RestController
@RequestMapping("/merchant/partner")
public class MerchantPartnerSearchEndpoint extends GenericSearchEndpoint<MerchantPartner, Long, SearchMerchantPartner> {
	
	@Autowired
	private MerchantPartnerSearchService merchantSearchService;
	
	@Override
	protected SearchService<MerchantPartner, ?> getSearchService() {
		return merchantSearchService;
	}

	@Override
	protected Class<?> getSpecificationGenericType() {
		return SearchMerchantPartner.class;
	}
	
	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantPartnerCrudPreparedQueryBuilder.getInstance().build();
	}

}
