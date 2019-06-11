import { ShoppingOption } from './shopping-option';
import { MerchantType } from './merchant-type';
import { MerchantPartner } from './merchant-partner';

export interface Merchant {

    id: number;
    merchantName: string;
    merchantDescription: string;
    merchantPicture: string;
    active: boolean;
    minAmount: number;
    maxAmount: number;
    merchantNote: string;
    shoppingOption: ShoppingOption;
    website: string;
    defaultMessage: string;
    typeFK: MerchantType;
    merchantDenominations: number[];
    functionalities: string[];
    balanceCheck: boolean;
    partnerFK: MerchantPartner;
    country: string;
    currency: string;
    metadata: any;

}
