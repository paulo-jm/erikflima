package com.guusto.buygift.merchant.mapping.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import com.guusto.buygift.merchant.mapping.entity.MerchantDenominationEntity;
import com.guusto.mapping.entity.GenericModel;

public class Merchant implements GenericModel {

	public static class MerchantBuild {

		public static MerchantBuild getInstance() {
			return new MerchantBuild();
		}

		public static MerchantBuild getInstance(Merchant entity) {
			if (entity != null) {
				return new MerchantBuild(entity);
			}
			return new MerchantBuild();
		}

		private Merchant toBuild;

		public MerchantBuild() {
			this.toBuild = new Merchant();
		}

		public MerchantBuild(Merchant entity) {
			this.toBuild = entity;
		}

		public MerchantBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantBuild merchantName(String merchantName) {
			this.toBuild.merchantName = merchantName;
			return this;
		}

		public MerchantBuild merchantDescription(String merchantDescription) {
			this.toBuild.merchantDescription = merchantDescription;
			return this;
		}

		public MerchantBuild merchantPicture(String merchantPicture) {
			this.toBuild.merchantPicture = merchantPicture;
			return this;
		}

		public MerchantBuild active(Boolean active) {
			this.toBuild.active = active;
			return this;
		}
		
		public MerchantBuild minAmount(BigDecimal minAmount) {
			this.toBuild.minAmount = minAmount;
			return this;
		}

		public MerchantBuild maxAmount(BigDecimal maxAmount) {
			this.toBuild.maxAmount = maxAmount;
			return this;
		}

		public MerchantBuild merchantNote(String merchantNote) {
			this.toBuild.merchantNote = merchantNote;
			return this;
		}

		public MerchantBuild shoppingOption(ShoppingOption shoppingOption) {
			this.toBuild.shoppingOption = shoppingOption;
			return this;
		}

		public MerchantBuild website(String website) {
			this.toBuild.website = website;
			return this;
		}

		public MerchantBuild defaultMessage(String defaultMessage) {
			this.toBuild.defaultMessage = defaultMessage;
			return this;
		}

		public MerchantBuild typeFK(Long typeFK) {
			this.toBuild.typeFK = typeFK;
			return this;
		}

		public MerchantBuild merchantDenominations(Collection<MerchantDenominationEntity> merchantDenominations) {
			if (merchantDenominations != null && !merchantDenominations.isEmpty()) {
				merchantDenominations.forEach(item -> {
					if (item != null) {
						addMerchantDenomination(item.getAmount());
					}
				});
			}

			return this;
		}

		public MerchantBuild addMerchantDenomination(BigDecimal amount) {

			if (this.toBuild.merchantDenominations == null) {
				this.toBuild.merchantDenominations = new ArrayList<>();
			}

			if (amount != null) {
				this.toBuild.merchantDenominations.add(amount);
			}

			return this;
		}

		public MerchantBuild functionalities(List<MerchantFunctionality> functionalities) {
			this.toBuild.functionalities = functionalities;
			return this;
		}

		public MerchantBuild partnerFK(Long partnerFK) {
			this.toBuild.partnerFK = partnerFK;
			return this;
		}

		public MerchantBuild country(Locale country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantBuild currency(String currency) {
			this.toBuild.currency = currency;
			return this;
		}

		public MerchantBuild metadata(Map<String, Object> metadata) {
			this.toBuild.metadata = metadata;
			return this;
		}
		public MerchantBuild metadata(String key, Object value) {

			if (toBuild.metadata == null) {
				this.toBuild.metadata = new HashMap<>();
			}

			if (StringUtils.isNotBlank(key)) {
				this.toBuild.metadata.put(key, value);
			}
			return this;
		}

		public Merchant build() {
			return this.toBuild;
		}

	}

	private Long id;

	@NotBlank
	private String merchantName;

	private String merchantDescription;

	@NotBlank
	private String merchantPicture;

	@NotNull
	private Boolean active;

	@NotNull
	private BigDecimal minAmount;

	@NotNull
	private BigDecimal maxAmount;

	private String merchantNote;

	@NotNull
	private ShoppingOption shoppingOption;

	private String website;

	private String defaultMessage;

	private Long typeFK;

	private List<BigDecimal> merchantDenominations;

	private List<MerchantFunctionality> functionalities;

	private Long partnerFK;

	@NotNull
	private Locale country;

	@Size(min = 3, max = 3)
	private String currency;

	private Map<String, Object> metadata;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantDescription() {
		return merchantDescription;
	}

	public void setMerchantDescription(String merchantDescription) {
		this.merchantDescription = merchantDescription;
	}

	public String getMerchantPicture() {
		return merchantPicture;
	}

	public void setMerchantPicture(String merchantPicture) {
		this.merchantPicture = merchantPicture;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getMerchantNote() {
		return merchantNote;
	}

	public void setMerchantNote(String merchantNote) {
		this.merchantNote = merchantNote;
	}

	public ShoppingOption getShoppingOption() {
		return shoppingOption;
	}

	public void setShoppingOption(ShoppingOption shoppingOption) {
		this.shoppingOption = shoppingOption;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public Long getTypeFK() {
		return typeFK;
	}

	public void setTypeFK(Long typeFK) {
		this.typeFK = typeFK;
	}

	public List<BigDecimal> getMerchantDenominations() {
		return merchantDenominations;
	}

	public void setMerchantDenominations(List<BigDecimal> merchantDenominations) {
		this.merchantDenominations = merchantDenominations;
	}

	public List<MerchantFunctionality> getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(List<MerchantFunctionality> functionalities) {
		this.functionalities = functionalities;
	}

	public Long getPartnerFK() {
		return partnerFK;
	}

	public void setPartnerFK(Long partnerFK) {
		this.partnerFK = partnerFK;
	}

	public Locale getCountry() {
		return country;
	}

	public void setCountry(Locale country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Map<String, Object> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, Object> metadata) {
		this.metadata = metadata;
	}

}
