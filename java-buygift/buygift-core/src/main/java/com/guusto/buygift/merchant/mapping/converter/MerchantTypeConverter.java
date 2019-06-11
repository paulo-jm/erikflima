package com.guusto.buygift.merchant.mapping.converter;

import org.springframework.stereotype.Service;

import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity.MerchantTypeEntityBuild;
import com.guusto.buygift.merchant.mapping.model.MerchantType;
import com.guusto.buygift.merchant.mapping.model.MerchantType.MerchantTypeBuild;
import com.guusto.mapping.converter.Converter;

@Service
public class MerchantTypeConverter implements Converter<MerchantTypeEntity, MerchantType>{

	@Override
	public MerchantTypeEntity createFrom(MerchantType model) {
		return updateEntity(new MerchantTypeEntity(), model);
	}

	@Override
	public MerchantType createFrom(MerchantTypeEntity entity) {
		return updateModel(new MerchantType(), entity);
	}

	@Override
	public MerchantTypeEntity updateEntity(MerchantTypeEntity entity, MerchantType model) {
		
		if(model != null) {
			return MerchantTypeEntityBuild.getInstance()
					.id(model.getId())
					.merchantTypeName(model.getMerchantTypeName())
					.merchantTypePicture(model.getMerchantTypePicture())
					.build();
		}
		
		return null;
		
	}

	@Override
	public MerchantType updateModel(MerchantType model, MerchantTypeEntity entity) {
		
		if(entity != null) {
			return MerchantTypeBuild.getInstance()
					.id(entity.getId())
					.merchantTypeName(entity.getMerchantTypeName())
					.merchantTypePicture(entity.getMerchantTypePicture())
					.build();
		}
		
		return null;
		
	}

}
