import { SearchSpecification } from 'src/app/shared/query/specification/search-specification';

export class SearchMerchantAddress extends SearchSpecification {
  ids: string;
}

export class SearchMerchantAddressBuilder {

  private toBuild: SearchMerchantAddress = new SearchMerchantAddress();

  public static getInstance(): SearchMerchantAddressBuilder {
    return new SearchMerchantAddressBuilder();
  }

  public ids(ids: string): SearchMerchantAddressBuilder {
    this.toBuild.ids = ids;
    return this;
  }

  public q(q: string): SearchMerchantAddressBuilder {
    this.toBuild.q = q;
    return this;
  }

  public build(): SearchMerchantAddress {
    return this.toBuild;
  }

}
