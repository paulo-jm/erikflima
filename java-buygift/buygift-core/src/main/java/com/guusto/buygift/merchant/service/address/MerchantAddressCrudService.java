package com.guusto.buygift.merchant.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.buygift.mapping.repository.BuygiftRepository;
import com.guusto.buygift.merchant.mapping.converter.MerchantAddressConverter;
import com.guusto.buygift.merchant.mapping.entity.MerchantAddressEntity;
import com.guusto.buygift.merchant.mapping.model.MerchantAddress;
import com.guusto.buygift.merchant.mapping.query.address.MerchantAddressCrudPreparedQueryBuilder;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.service.GenericCrudService;

@Service
public class MerchantAddressCrudService extends GenericCrudService<MerchantAddress, MerchantAddressEntity> {

	@Autowired
	private MerchantAddressConverter merchantConverter;

	@Autowired
	private BuygiftRepository<MerchantAddressEntity> merchantRepository;

	@Override
	public boolean contains(MerchantAddress dto) {
		return false;
	}

	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantAddressCrudPreparedQueryBuilder.getInstance().build();
	}

	@Override
	protected Repository<MerchantAddressEntity> getRepository() {
		return merchantRepository;
	}

	@Override
	protected Converter<MerchantAddressEntity, MerchantAddress> getConverter() {
		return merchantConverter;
	}

}
