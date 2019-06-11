package com.guusto.buygift.merchant.mapping.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.guusto.mapping.entity.GenericEntity;

@Entity
@Table(name = "merchant_type") 
public class MerchantTypeEntity implements GenericEntity {

	public static class MerchantTypeEntityBuild {

		public static MerchantTypeEntityBuild getInstance() {
			return new MerchantTypeEntityBuild();
		}

		public static MerchantTypeEntityBuild getInstance(MerchantTypeEntity entity) {
			if (entity != null) {
				return new MerchantTypeEntityBuild(entity);
			}
			return new MerchantTypeEntityBuild();
		}

		private MerchantTypeEntity toBuild;

		public MerchantTypeEntityBuild() {
			this.toBuild = new MerchantTypeEntity();
		}

		public MerchantTypeEntityBuild(MerchantTypeEntity entity) {
			this.toBuild = entity;
		}

		public MerchantTypeEntityBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantTypeEntityBuild merchantTypeName(String merchantTypeName) {
			this.toBuild.merchantTypeName = merchantTypeName;
			return this;
		}

		public MerchantTypeEntityBuild merchantTypePicture(String merchantTypePicture) {
			this.toBuild.merchantTypePicture = merchantTypePicture;
			return this;
		}

		public MerchantTypeEntity build() {
			return this.toBuild;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
