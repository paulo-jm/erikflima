package com.guusto.buygift.merchant.endpoint.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guusto.buygift.merchant.mapping.model.MerchantType;
import com.guusto.buygift.merchant.mapping.query.type.MerchantTypeCrudPreparedQueryBuilder;
import com.guusto.buygift.merchant.mapping.specification.SearchMerchantType;
import com.guusto.buygift.merchant.service.type.MerchantTypeCrudService;
import com.guusto.endpoint.GenericCrudEndpoint;
import com.guusto.query.PreparedQuery;
import com.guusto.service.CrudService;

@RestController
@RequestMapping("/merchant/type")
public class MerchantTypeCrudEndpoint extends GenericCrudEndpoint<MerchantType, Long, SearchMerchantType> {
	
	@Autowired
	private MerchantTypeCrudService merchantCrudService;
	
	@Override
	protected CrudService<MerchantType, ?> getCrudService() {
		return merchantCrudService;
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
