package com.guusto.buygift.merchant.endpoint.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantPartner;
import com.guusto.buygift.merchant.mapping.query.partner.MerchantPartnerCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantPartner;
import com.guusto.buygift.merchant.service.partner.MerchantPartnerCrudService;
import com.guusto.endpoint.GenericCrudEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.CrudService;

@RestController
@RequestMapping("/merchant/partner")
public class MerchantPartnerCrudEndpoint extends GenericCrudEndpoint<MerchantPartner, Long, SearchMerchantPartner> {
	
	@Autowired
	private MerchantPartnerCrudService merchantCrudService;
	
	@Override
	protected CrudService<MerchantPartner, ?> getCrudService() {
		return merchantCrudService;
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
