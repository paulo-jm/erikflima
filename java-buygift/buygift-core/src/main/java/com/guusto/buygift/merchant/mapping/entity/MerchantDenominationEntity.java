package com.guusto.buygift.merchant.mapping.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "merchant_denomination") 
public class MerchantDenominationEntity {

	public static class MerchantDenominationEntityBuild {

		public static MerchantDenominationEntityBuild getInstance() {
			return new MerchantDenominationEntityBuild();
		}

		public static MerchantDenominationEntityBuild getInstance(MerchantDenominationEntity entity) {
			if (entity != null) {
				return new MerchantDenominationEntityBuild(entity);
			}
			return new MerchantDenominationEntityBuild();
		}

		private MerchantDenominationEntity toBuild;

		public MerchantDenominationEntityBuild() {
			this.toBuild = new MerchantDenominationEntity();
		}

		public MerchantDenominationEntityBuild(MerchantDenominationEntity entity) {
			this.toBuild = entity;
		}

		public MerchantDenominationEntityBuild id(Long id) {
			this.toBuild.id = id;
			return this;
		}

		public MerchantDenominationEntityBuild merchant(MerchantEntity merchant) {
			this.toBuild.merchant = merchant;
			return this;
		}

		public MerchantDenominationEntityBuild amount(BigDecimal amount) {
			this.toBuild.amount = amount;
			return this;
		}

		public MerchantDenominationEntity build() {
			return this.toBuild;
		}

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "merchant_fk")
	private MerchantEntity merchant;

	private BigDecimal amount;

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
