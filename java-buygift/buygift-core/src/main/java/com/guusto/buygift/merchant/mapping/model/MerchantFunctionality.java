package com.guusto.buygift.merchant.mapping.model;

import org.apache.commons.lang3.StringUtils;

public enum MerchantFunctionality {

	OFFLINE("Offline"), BALANCE_CHECK("BalanceCheck"), CANCEL("Cancel");
	
	public String functionality;

	MerchantFunctionality(String functionality) {
        this.functionality = functionality;
    }
	
	public String getFunctionality() {
		return functionality;
	}

    public static MerchantFunctionality fromString(String functionality) {
        if (StringUtils.isNotBlank(functionality)) {
            for (MerchantFunctionality type : MerchantFunctionality.values()) {
                if (functionality.equalsIgnoreCase(type.functionality)) {
                    return type;
                }
            }
        }
        return null;
    }
	
	

}
