package com.guusto.buygift.merchant.service.partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guusto.buygift.mapping.repository.BuygiftRepository;
import com.guusto.buygift.merchant.mapping.converter.MerchantPartnerConverter;
import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity;
import com.guusto.buygift.merchant.mapping.model.MerchantPartner;
import com.guusto.buygift.merchant.mapping.query.partner.MerchantPartnerSearchPreparedQueryBuilder;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.repository.Repository;
import com.guusto.query.PreparedQuery;
import com.guusto.service.GenericSearchService;

@Service
public class MerchantPartnerSearchService extends GenericSearchService<MerchantPartner, MerchantPartnerEntity> {

	@Autowired
	private MerchantPartnerConverter merchantConverter;

	@Autowired
	private BuygiftRepository<MerchantPartnerEntity> merchantRepository;

	@Override
	protected PreparedQuery getPreparedQuery() {
		return MerchantPartnerSearchPreparedQueryBuilder.getInstance().build();
	}

	@Override
	protected Repository<MerchantPartnerEntity> getRepository() {
		return merchantRepository;
	}

	@Override
	protected Converter<MerchantPartnerEntity, MerchantPartner> getConverter() {
		return merchantConverter;
	}

}
