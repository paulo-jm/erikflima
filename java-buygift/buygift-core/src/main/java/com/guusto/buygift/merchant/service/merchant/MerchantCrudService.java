package com.guusto.buygift.merchant.service.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.buygift.mapping.repository.BuygiftRepository;
import com.guusto.buygift.merchant.mapping.converter.MerchantConverter;
import com.guusto.buygift.merchant.mapping.entity.MerchantEntity;
import com.guusto.buygift.merchant.mapping.model.Merchant;
import com.guusto.buygift.merchant.mapping.query.merchant.MerchantCrudPreparedQueryBuilder;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.service.GenericCrudService;

@Service
public class MerchantCrudService extends GenericCrudService<Merchant, MerchantEntity> {

	@Autowired
	private MerchantConverter merchantConverter;

	@Autowired
	private BuygiftRepository<MerchantEntity> merchantRepository;

	@Override
	public boolean contains(Merchant dto) {
		return false;
	}

	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantCrudPreparedQueryBuilder.getInstance().build();
	}

	@Override
	protected Repository<MerchantEntity> getRepository() {
		return merchantRepository;
	}

	@Override
	protected Converter<MerchantEntity, Merchant> getConverter() {
		return merchantConverter;
	}

}
