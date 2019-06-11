package com.guusto.buygift.merchant.service.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.buygift.mapping.repository.BuygiftRepository;
import com.guusto.buygift.merchant.mapping.converter.MerchantConverter;
import com.guusto.buygift.merchant.mapping.entity.MerchantEntity;
import com.guusto.buygift.merchant.mapping.model.Merchant;
import com.guusto.buygift.merchant.mapping.query.merchant.MerchantSearchPreparedQueryBuilder;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.service.GenericSearchService;

@Service
public class MerchantSearchService extends GenericSearchService<Merchant, MerchantEntity> {

	@Autowired
	private MerchantConverter merchantConverter;

	@Autowired
	private BuygiftRepository<MerchantEntity> merchantRepository;

	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantSearchPreparedQueryBuilder.getInstance().build();
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
