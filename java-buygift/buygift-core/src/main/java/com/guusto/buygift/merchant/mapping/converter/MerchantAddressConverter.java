package com.guusto.buygift.merchant.mapping.converter;

import org.springframework.stereotype.Service;

import com.guusto.buygift.merchant.mapping.entity.MerchantAddressEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantAddressEntity.MerchantAddressEntityBuild;
import com.guusto.buygift.merchant.mapping.model.MerchantAddress;
import com.guusto.buygift.merchant.mapping.model.MerchantAddress.MerchantAddressBuild;
import com.guusto.mapping.converter.Converter;

@Service
public class MerchantAddressConverter implements Converter<MerchantAddressEntity, MerchantAddress>{

	@Override
	public MerchantAddressEntity createFrom(MerchantAddress model) {
		return updateEntity(new MerchantAddressEntity(), model);
	}

	@Override
	public MerchantAddress createFrom(MerchantAddressEntity entity) {
		return updateModel(new MerchantAddress(), entity);
	}

	@Override
	public MerchantAddressEntity updateEntity(MerchantAddressEntity entity, MerchantAddress model) {
		
		if(model != null) {
			return MerchantAddressEntityBuild.getInstance()
					.id(model.getId())
					.city(model.getCity())
					.country(model.getCountry())
					.lattitude(model.getLattitude())
					.longitude(model.getLongitude())
					.zipcode(model.getZipcode())
					.street(model.getStreet())
					.province(model.getProvince())
					.build();
		}
		
		return null;
		
	}

	@Override
	public MerchantAddress updateModel(MerchantAddress model, MerchantAddressEntity entity) {
		
		if(entity != null) {
			return MerchantAddressBuild.getInstance()
					.id(entity.getId())
					.city(model.getCity())
					.country(model.getCountry())
					.lattitude(model.getLattitude())
					.longitude(model.getLongitude())
					.zipcode(model.getZipcode())
					.street(model.getStreet())
					.province(model.getProvince())
					.build();
		}
		
		return null;
		
	}

}
