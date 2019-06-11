package com.guusto.buygift.merchant.mapping.model;

import com.guusto.mapping.entity.GenericModel;

public class MerchantAddress implements GenericModel {

	public static class MerchantAddressBuild {

		public static MerchantAddressBuild getInstance() {
			return new MerchantAddressBuild();
		}

		public static MerchantAddressBuild getInstance(MerchantAddress entity) {
			if (entity != null) {
				return new MerchantAddressBuild(entity);
			}
			return new MerchantAddressBuild();
		}

		private MerchantAddress toBuild;

		public MerchantAddressBuild() {
			this.toBuild = new MerchantAddress();
		}

		public MerchantAddressBuild(MerchantAddress entity) {
			this.toBuild = entity;
		}

		public MerchantAddressBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantAddressBuild merchantFK(Long merchantFK) {
			this.toBuild.merchantFK = merchantFK;
			return this;
		}

		public MerchantAddressBuild street(String street) {
			this.toBuild.street = street;
			return this;
		}

		public MerchantAddressBuild city(String city) {
			this.toBuild.city = city;
			return this;
		}

		public MerchantAddressBuild province(String province) {
			this.toBuild.province = province;
			return this;
		}

		public MerchantAddressBuild zipcode(String zipcode) {
			this.toBuild.zipcode = zipcode;
			return this;
		}

		public MerchantAddressBuild country(String country) {
			this.toBuild.country = country;
			return this;
		}

		public MerchantAddressBuild lattitude(String lattitude) {
			this.toBuild.lattitude = lattitude;
			return this;
		}

		public MerchantAddressBuild longitude(String longitude) {
			this.toBuild.longitude = longitude;
			return this;
		}

		public MerchantAddress build() {
			return this.toBuild;
		}

	}

	private Long id;

	private Long merchantFK;

	private String street;

	private String city;

	private String province;

	private String zipcode;

	private String country;

	private String lattitude;

	private String longitude;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMerchantFK() {
		return merchantFK;
	}

	public void setMerchantFK(Long merchantFK) {
		this.merchantFK = merchantFK;
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
