package com.guusto.buygift.merchant.endpoint.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.Merchant;
import com.guusto.buygift.merchant.mapping.query.merchant.MerchantCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchant;
import com.guusto.buygift.merchant.service.merchant.MerchantCrudService;
import com.guusto.endpoint.GenericCrudEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.CrudService;

@RestController
@RequestMapping("/merchant/merchant")
public class MerchantCrudEndpoint extends GenericCrudEndpoint<Merchant, Long, SearchMerchant> {
	
	@Autowired
	private MerchantCrudService merchantCrudService;
	
	@Override
	protected CrudService<Merchant, ?> getCrudService() {
		return merchantCrudService;
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
