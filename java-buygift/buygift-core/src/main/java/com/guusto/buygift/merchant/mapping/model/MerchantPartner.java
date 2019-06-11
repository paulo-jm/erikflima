package com.guusto.buygift.merchant.mapping.model;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;

import com.guusto.mapping.entity.GenericModel;

public class MerchantPartner implements GenericModel {

	public static class MerchantPartnerBuild {

		public static MerchantPartnerBuild getInstance() {
			return new MerchantPartnerBuild();
		}

		public static MerchantPartnerBuild getInstance(MerchantPartner entity) {
			if (entity != null) {
				return new MerchantPartnerBuild(entity);
			}
			return new MerchantPartnerBuild();
		}

		private MerchantPartner toBuild;

		public MerchantPartnerBuild() {
			this.toBuild = new MerchantPartner();
		}

		public MerchantPartnerBuild(MerchantPartner entity) {
			this.toBuild = entity;
		}

		public MerchantPartnerBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantPartnerBuild merchantPartnerName(String merchantPartnerName) {
			this.toBuild.merchantPartnerName = merchantPartnerName;
			return this;
		}

		public MerchantPartnerBuild country(Locale country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantPartnerBuild currency(String currency) {
			this.toBuild.currency = currency;
			return this;
		}

		public MerchantPartnerBuild metadata(String key, String value) {

			if (toBuild.metadata == null) {
				this.toBuild.metadata = new HashMap<>();
			}

			if (StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)) {
				this.toBuild.metadata.put(key, value);
			}
			return this;
		}

		public MerchantPartner build() {
			return this.toBuild;
		}

	}

	private Long id;

	@NotBlank
	private String merchantPartnerName;

	@NotNull
	private Locale country;

	@Size(min = 3, max = 3)
	private String currency;

	private Map<String, String> metadata;

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

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

}
