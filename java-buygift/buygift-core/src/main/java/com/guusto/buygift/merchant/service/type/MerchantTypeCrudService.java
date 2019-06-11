package com.guusto.buygift.merchant.service.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.buygift.mapping.repository.BuygiftRepository;
import com.guusto.buygift.merchant.mapping.converter.MerchantTypeConverter;
import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity;
import com.guusto.buygift.merchant.mapping.model.MerchantType;
import com.guusto.buygift.merchant.mapping.query.type.MerchantTypeCrudPreparedQueryBuilder;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.service.GenericCrudService;

@Service
public class MerchantTypeCrudService extends GenericCrudService<MerchantType, MerchantTypeEntity> {

	@Autowired
	private MerchantTypeConverter merchantConverter;

	@Autowired
	private BuygiftRepository<MerchantTypeEntity> merchantRepository;

	@Override
	public boolean contains(MerchantType dto) {
		return false;
	}

	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantTypeCrudPreparedQueryBuilder.getInstance().build();
	}

	@Override
	protected Repository<MerchantTypeEntity> getRepository() {
		return merchantRepository;
	}

	@Override
	protected Converter<MerchantTypeEntity, MerchantType> getConverter() {
		return merchantConverter;
	}

}
