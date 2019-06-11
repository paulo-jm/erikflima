package com.guusto.buygift.merchant.mapping.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.guusto.buygift.merchant.mapping.entity.MerchantDenominationEntity.MerchantDenominationEntityBuild;
import com.guusto.buygift.merchant.mapping.entity.MerchantPartnerEntity.MerchantPartnerEntityBuild;
import com.guusto.buygift.merchant.mapping.entity.MerchantTypeEntity.MerchantTypeEntityBuild;
import com.guusto.buygift.merchant.mapping.model.ShoppingOption;
import com.guusto.mapping.entity.GenericEntity;

@Entity
@Table(name = "merchant") 
public class MerchantEntity implements GenericEntity {

	public static class MerchantEntityBuild {

		public static MerchantEntityBuild getInstance() {
			return new MerchantEntityBuild();
		}

		public static MerchantEntityBuild getInstance(MerchantEntity entity) {
			if (entity != null) {
				return new MerchantEntityBuild(entity);
			}
			return new MerchantEntityBuild();
		}

		private MerchantEntity toBuild;

		public MerchantEntityBuild() {
			this.toBuild = new MerchantEntity();
		}

		public MerchantEntityBuild(MerchantEntity entity) {
			this.toBuild = entity;
		}

		public MerchantEntityBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantEntityBuild merchantName(String merchantName) {
			this.toBuild.merchantName = merchantName;
			return this;
		}

		public MerchantEntityBuild merchantDescription(String merchantDescription) {
			this.toBuild.merchantDescription = merchantDescription;
			return this;
		}

		public MerchantEntityBuild merchantPicture(String merchantPicture) {
			this.toBuild.merchantPicture = merchantPicture;
			return this;
		}

		public MerchantEntityBuild active(Boolean active) {
			this.toBuild.active = active;
			return this;
		}

		public MerchantEntityBuild minAmount(BigDecimal minAmount) {
			this.toBuild.minAmount = minAmount;
			return this;
		}

		public MerchantEntityBuild maxAmount(BigDecimal maxAmount) {
			this.toBuild.maxAmount = maxAmount;
			return this;
		}

		public MerchantEntityBuild merchantNote(String merchantNote) {
			this.toBuild.merchantNote = merchantNote;
			return this;
		}

		public MerchantEntityBuild shoppingOption(ShoppingOption shoppingOption) {
			this.toBuild.shoppingOption = shoppingOption;
			return this;
		}

		public MerchantEntityBuild website(String website) {
			this.toBuild.website = website;
			return this;
		}

		public MerchantEntityBuild defaultMessage(String defaultMessage) {
			this.toBuild.defaultMessage = defaultMessage;
			return this;
		}

		public MerchantEntityBuild type(Long typeID) {
			if(typeID != null) {
				this.toBuild.type = MerchantTypeEntityBuild.getInstance().id(typeID).build();
			}
			return this;
		}

		
		public MerchantEntityBuild type(MerchantTypeEntity type) {
			this.toBuild.type = type;
			return this;
		}

		public MerchantEntityBuild merchantDenominations(Collection<BigDecimal> merchantDenominations) {
			if (merchantDenominations != null && !merchantDenominations.isEmpty()) {
				merchantDenominations.forEach(item -> {
					if(item != null) {
						addMerchantDenomination(MerchantDenominationEntityBuild.getInstance()
								.amount(item)
								.build());
					}
				});
			}

			return this;
		}

		public MerchantEntityBuild addMerchantDenomination(MerchantDenominationEntity merchantDenomination) {

			if (this.toBuild.merchantDenominations != null) {
				this.toBuild.merchantDenominations = new HashSet<>();
			}

			if (merchantDenomination != null) {
				merchantDenomination.setMerchant(toBuild);
				this.toBuild.merchantDenominations.add(merchantDenomination);
			}

			return this;
		}

		public MerchantEntityBuild functionalities(String functionalities) {
			this.toBuild.functionalities = functionalities;
			return this;
		}
		
		public MerchantEntityBuild partner(Long partnerID) {
			if(partnerID != null) {
				this.toBuild.partner = MerchantPartnerEntityBuild.getInstance().id(partnerID).build();
			}
			return this;
		}

		public MerchantEntityBuild partner(MerchantPartnerEntity partner) {
			this.toBuild.partner = partner;
			return this;
		}

		public MerchantEntityBuild country(Locale country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantEntityBuild currency(String currency) {
			this.toBuild.currency = currency;
			return this;
		}
		
		public MerchantEntityBuild metadata(String metadata) {
			this.toBuild.metadata = metadata;
			return this;
		}

		public MerchantEntity build() {
			return this.toBuild;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "merchant_name")
	private String merchantName;

	@Column(name = "merchant_description")
	private String merchantDescription;

	@NotBlank
	@Column(name = "merchant_picture")
	private String merchantPicture;

	@NotNull
	@Column(columnDefinition = "boolean")
	private Boolean active;
	
	@NotNull
	@Column(name = "min_amount")
	private BigDecimal minAmount;

	@NotNull
	@Column(name = "max_amount")
	private BigDecimal maxAmount;

	@Column(name = "merchant_note")
	private String merchantNote;

	@NotNull
	@Column(name = "shopping_option")
	@Enumerated(EnumType.STRING)
	private ShoppingOption shoppingOption;

	@Column(name = "website")
	private String website;

	@Column(name = "default_message")
	private String defaultMessage;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_fk")
	private MerchantTypeEntity type;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "merchant", orphanRemoval = true)
	private Set<MerchantDenominationEntity> merchantDenominations;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "merchant", orphanRemoval = true)
	private Set<MerchantAddressEntity> merchantAddresses;

	@Column(name = "functionalities")
	private String functionalities;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partner_fk")
	private MerchantPartnerEntity partner;

	@NotNull
	@Column(name = "country")
	private Locale country;

	@Size(min = 3, max = 3)
	@Column(name = "currency")
	private String currency;
	
	@Column(columnDefinition = "text")
	private String metadata;

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

	public Set<MerchantAddressEntity> getMerchantAddresses() {
		return merchantAddresses;
	}

	public void setMerchantAddresses(Set<MerchantAddressEntity> merchantAddresses) {
		this.merchantAddresses = merchantAddresses;
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

	public MerchantTypeEntity getType() {
		return type;
	}

	public void setType(MerchantTypeEntity type) {
		this.type = type;
	}

	public Set<MerchantDenominationEntity> getMerchantDenominations() {
		return merchantDenominations;
	}

	public void setMerchantDenominations(Set<MerchantDenominationEntity> merchantDenominations) {
		this.merchantDenominations = merchantDenominations;
	}

	public String getFunctionalities() {
		return functionalities;
	}

	public void setFunctionalities(String functionalities) {
		this.functionalities = functionalities;
	}

	public MerchantPartnerEntity getPartner() {
		return partner;
	}

	public void setPartner(MerchantPartnerEntity partner) {
		this.partner = partner;
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

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	
}
