package com.guusto.buygift.merchant.mapping.entity;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.guusto.mapping.entity.GenericEntity;

@Entity
@Table(name = "merchant_partner") 
public class MerchantPartnerEntity implements GenericEntity {

	public static class MerchantPartnerEntityBuild {

		public static MerchantPartnerEntityBuild getInstance() {
			return new MerchantPartnerEntityBuild();
		}

		public static MerchantPartnerEntityBuild getInstance(MerchantPartnerEntity entity) {
			if (entity != null) {
				return new MerchantPartnerEntityBuild(entity);
			}
			return new MerchantPartnerEntityBuild();
		}

		private MerchantPartnerEntity toBuild;

		public MerchantPartnerEntityBuild() {
			this.toBuild = new MerchantPartnerEntity();
		}

		public MerchantPartnerEntityBuild(MerchantPartnerEntity entity) {
			this.toBuild = entity;
		}

		public MerchantPartnerEntityBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantPartnerEntityBuild merchantPartnerName(String merchantPartnerName) {
			this.toBuild.merchantPartnerName = merchantPartnerName;
			return this;
		}

		public MerchantPartnerEntityBuild country(Locale country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantPartnerEntityBuild currency(String currency) {
			this.toBuild.currency = currency;
			return this;
		}

		public MerchantPartnerEntityBuild metadata(String metadata) {
			this.toBuild.metadata = metadata;
			return this;
		}

		public MerchantPartnerEntity build() {
			return this.toBuild;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String merchantPartnerName;

	@NotNull
	private Locale country;

	@Size(min = 3, max = 3)
	private String currency;

	@Column(columnDefinition = "text")
	private String metadata;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantPartnerName() {
		return merchantPartnerName;
	}

	public void setMerchantPartnerName(String merchantPartnerName) {
		this.merchantPartnerName = merchantPartnerName;
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
