package com.guusto.buygift.merchant.mapping.converter;

import org.springframework.stereotype.Service;

import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity.MerchantPartnerEntityBuild;
import com.guusto.buygift.merchant.mapping.model.MerchantPartner;
import com.guusto.buygift.merchant.mapping.model.MerchantPartner.MerchantPartnerBuild;
import com.guusto.mapping.converter.Converter;

@Service
public class MerchantPartnerConverter implements Converter<MerchantPartnerEntity, MerchantPartner>{

	@Override
	public MerchantPartnerEntity createFrom(MerchantPartner model) {
		return updateEntity(new MerchantPartnerEntity(), model);
	}

	@Override
	public MerchantPartner createFrom(MerchantPartnerEntity entity) {
		return updateModel(new MerchantPartner(), entity);
	}

	@Override
	public MerchantPartnerEntity updateEntity(MerchantPartnerEntity entity, MerchantPartner model) {
		
		if(model != null) {
			return MerchantPartnerEntityBuild.getInstance()
					.id(model.getId())
					.country(model.getCountry())
					.currency(model.getCurrency())
					.merchantPartnerName(model.getMerchantPartnerName())
					.build();
		}
		
		return null;
		
	}

	@Override
	public MerchantPartner updateModel(MerchantPartner model, MerchantPartnerEntity entity) {
		
		if(entity != null) {
			return MerchantPartnerBuild.getInstance()
					.id(entity.getId())
					.country(entity.getCountry())
					.currency(entity.getCurrency())
					.merchantPartnerName(entity.getMerchantPartnerName())
					.build();
		}
		
		return null;
		
	}

}
