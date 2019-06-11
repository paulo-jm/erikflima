package com.guusto.buygift.merchant.mapping.model;

import javax.validation.constraints.NotBlank;

import com.guusto.mapping.entity.GenericModel;

public class MerchantType implements GenericModel {

	public static class MerchantTypeBuild {

		public static MerchantTypeBuild getInstance() {
			return new MerchantTypeBuild();
		}

		public static MerchantTypeBuild getInstance(MerchantType entity) {
			if (entity != null) {
				return new MerchantTypeBuild(entity);
			}
			return new MerchantTypeBuild();
		}

		private MerchantType toBuild;

		public MerchantTypeBuild() {
			this.toBuild = new MerchantType();
		}

		public MerchantTypeBuild(MerchantType entity) {
			this.toBuild = entity;
		}

		public MerchantTypeBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantTypeBuild merchantTypeName(String merchantTypeName) {
			this.toBuild.merchantTypeName = merchantTypeName;
			return this;
		}

		public MerchantTypeBuild merchantTypePicture(String merchantTypePicture) {
			this.toBuild.merchantTypePicture = merchantTypePicture;
			return this;
		}

		public MerchantType build() {
			return this.toBuild;
		}

	}

	private Long id;

	@NotBlank
	private String merchantTypeName;

	private String merchantTypePicture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantTypeName() {
		return merchantTypeName;
	}

	public void setMerchantTypeName(String merchantTypeName) {
		this.merchantTypeName = merchantTypeName;
	}

	public String getMerchantTypePicture() {
		return merchantTypePicture;
	}

	public void setMerchantTypePicture(String merchantTypePicture) {
		this.merchantTypePicture = merchantTypePicture;
	}

}
