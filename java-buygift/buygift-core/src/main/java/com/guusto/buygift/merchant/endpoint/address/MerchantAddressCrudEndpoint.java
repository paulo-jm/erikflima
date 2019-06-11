package com.guusto.buygift.merchant.endpoint.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantAddress;
import com.guusto.buygift.merchant.mapping.query.address.MerchantAddressCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantAddress;
import com.guusto.buygift.merchant.service.address.MerchantAddressCrudService;
import com.guusto.endpoint.GenericCrudEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.CrudService;

@RestController
@RequestMapping("/merchant/address")
public class MerchantAddressCrudEndpoint extends GenericCrudEndpoint<MerchantAddress, Long, SearchMerchantAddress> {
	
	@Autowired
	private MerchantAddressCrudService merchantCrudService;
	
	@Override
	protected CrudService<MerchantAddress, ?> getCrudService() {
		return merchantCrudService;
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
