package com.guusto.buygift.merchant.mapping.converter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.guusto.buygift.merchant.mapping.entity.MerchantEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantEntity.MerchantEntityBuild;
import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity;
import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity;
import com.guusto.buygift.merchant.mapping.model.Merchant;
import com.guusto.buygift.merchant.mapping.model.Merchant.MerchantBuild;
import com.guusto.buygift.merchant.mapping.model.MerchantFunctionality;
import com.guusto.mapping.converter.Converter;
import com.guusto.mapping.utils.ObjectMapperUtils;

@Service
public class MerchantConverter implements Converter<MerchantEntity, Merchant>{
	
	private final String FUNCTIONALITY_SEPARATOR = ",";

	@Override
	public MerchantEntity createFrom(Merchant model) {
		return updateEntity(new MerchantEntity(), model);
	}

	@Override
	public Merchant createFrom(MerchantEntity entity) {
		return updateModel(new Merchant(), entity);
	}

	@Override
	public MerchantEntity updateEntity(MerchantEntity entity, Merchant model) {
		
		if(model != null) {
			return MerchantEntityBuild.getInstance()
					.id(model.getId())
					.merchantName(model.getMerchantName())
					.merchantDescription(model.getMerchantDescription())
					.merchantPicture(model.getMerchantPicture())
					.active(model.getActive())
					.minAmount(model.getMinAmount())
					.maxAmount(model.getMaxAmount())
					.merchantNote(model.getMerchantNote())
					.shoppingOption(model.getShoppingOption())
					.website(model.getWebsite())
					.defaultMessage(model.getDefaultMessage())
					.type(model.getTypeFK())
					.merchantDenominations(model.getMerchantDenominations())
					.functionalities(StringUtils.join(model.getFunctionalities(), FUNCTIONALITY_SEPARATOR))
					.partner(model.getPartnerFK())
					.country(model.getCountry())
					.currency(model.getCurrency())
					.metadata(ObjectMapperUtils.writeValueMetadata(model.getMetadata()))
					.build();
		}
		
		return null;
		
	}

	@Override
	public Merchant updateModel(Merchant model, MerchantEntity entity) {
		
		if(entity != null) {
			
			return MerchantBuild.getInstance()
					.id(entity.getId())
					.merchantName(entity.getMerchantName())
					.merchantDescription(entity.getMerchantDescription())
					.merchantPicture(entity.getMerchantPicture())
					.active(entity.getActive())
					.minAmount(entity.getMinAmount())
					.maxAmount(entity.getMaxAmount())
					.merchantNote(entity.getMerchantNote())
					.shoppingOption(entity.getShoppingOption())
					.website(entity.getWebsite())
					.defaultMessage(entity.getDefaultMessage())
					.typeFK(Optional.ofNullable(entity.getType()).map(MerchantTypeEntity::getId).orElse(null))
					.merchantDenominations(entity.getMerchantDenominations())
					.functionalities(toListOfFunctionalities(Optional.ofNullable(entity.getFunctionalities()).orElse(null)))
					.partnerFK(Optional.ofNullable(entity.getPartner()).map(MerchantPartnerEntity::getId).orElse(null))
					.country(entity.getCountry())
					.currency(entity.getCurrency())
					.metadata(ObjectMapperUtils.readValueMetadata(entity.getMetadata()))
					.build();
		}
		
		return null;
		
	}

	private List<MerchantFunctionality> toListOfFunctionalities(String functionalities) {
		List<MerchantFunctionality> list = null;
		if(StringUtils.isNotBlank(functionalities)) {
			Stream<String> stream1 = Arrays.stream(functionalities.split(FUNCTIONALITY_SEPARATOR));
			list = stream1.map(value -> MerchantFunctionality.fromString(value)).collect(Collectors.toList());
		}
		return list;
	}

}
