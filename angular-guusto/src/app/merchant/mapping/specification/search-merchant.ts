import { SearchSpecification } from 'src/app/shared/query/specification/search-specification';
import { ShoppingOption } from '../model/shopping-option';
import { MerchantType } from '../model/merchant-type';

export class SearchMerchant extends SearchSpecification {

  ids: string;
  merchantDenominations: string;
  amount: number;
  shoppingOption: ShoppingOption;
  type: MerchantType;
  country: string;
  currency: string;

}

export class SearchMerchantBuilder {

  private toBuild: SearchMerchant = new SearchMerchant();

  public static getInstance(): SearchMerchantBuilder {
    return new SearchMerchantBuilder();
  }

  public ids(ids: string): SearchMerchantBuilder {
    this.toBuild.ids = ids;
    return this;
  }

  public merchantDenominations(merchantDenominations: string): SearchMerchantBuilder {
    this.toBuild.merchantDenominations = merchantDenominations;
    return this;
  }

  public q(q: string): SearchMerchantBuilder {
    this.toBuild.q = q;
    return this;
  }

  public build(): SearchMerchant {
    return this.toBuild;
  }

}
