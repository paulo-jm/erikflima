package com.guusto.buygift.merchant.mapping.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.guusto.buygift.merchant.mapping.entity.MerchantEntity.MerchantEntityBuild;
import com.guusto.mapping.entity.GenericEntity;

@Entity
@Table(name = "merchant_address") 
public class MerchantAddressEntity implements GenericEntity {

	public static class MerchantAddressEntityBuild {

		public static MerchantAddressEntityBuild getInstance() {
			return new MerchantAddressEntityBuild();
		}

		public static MerchantAddressEntityBuild getInstance(MerchantAddressEntity entity) {
			if (entity != null) {
				return new MerchantAddressEntityBuild(entity);
			}
			return new MerchantAddressEntityBuild();
		}

		private MerchantAddressEntity toBuild;

		public MerchantAddressEntityBuild() {
			this.toBuild = new MerchantAddressEntity();
		}

		public MerchantAddressEntityBuild(MerchantAddressEntity entity) {
			this.toBuild = entity;
		}

		public MerchantAddressEntityBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantAddressEntityBuild merchant(Long merchantID) {
			if (merchantID != null) {
				merchant(MerchantEntityBuild.getInstance().id(merchantID).build());
			}
			return this;
		}

		public MerchantAddressEntityBuild merchant(MerchantEntity merchant) {
			this.toBuild.merchant = merchant;
			return this;
		}

		public MerchantAddressEntityBuild street(String street) {
			this.toBuild.street = street;
			return this;
		}

		public MerchantAddressEntityBuild city(String city) {
			this.toBuild.city = city;
			return this;
		}

		public MerchantAddressEntityBuild province(String province) {
			this.toBuild.province = province;
			return this;
		}

		public MerchantAddressEntityBuild zipcode(String zipcode) {
			this.toBuild.zipcode = zipcode;
			return this;
		}

		public MerchantAddressEntityBuild country(String country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantAddressEntityBuild lattitude(String lattitude) {
			this.toBuild.lattitude = lattitude;
			return this;
		}

		public MerchantAddressEntityBuild longitude(String longitude) {
			this.toBuild.longitude = longitude;
			return this;
		}

		public MerchantAddressEntity build() {
			return this.toBuild;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merchant_fk")
	private MerchantEntity merchant;

	private String street;

	private String city;

	private String province;

	private String zipcode;

	private String country;

	private String lattitude;

	private String longitude;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MerchantEntity getMerchant() {
		return merchant;
	}

	public void setMerchant(MerchantEntity merchant) {
		this.merchant = merchant;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
