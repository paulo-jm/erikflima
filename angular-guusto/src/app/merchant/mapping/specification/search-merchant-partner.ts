import { SearchSpecification } from 'src/app/shared/query/specification/search-specification';

export class SearchMerchantPartner extends SearchSpecification {

  ids: string;

}

export class SearchMerchantPartnerBuilder {

  private toBuild: SearchMerchantPartner = new SearchMerchantPartner();

  public static getInstance(): SearchMerchantPartnerBuilder {
    return new SearchMerchantPartnerBuilder();
  }

  public ids(ids: string): SearchMerchantPartnerBuilder {
    this.toBuild.ids = ids;
    return this;
  }

  public q(q: string): SearchMerchantPartnerBuilder {
    this.toBuild.q = q;
    return this;
  }

  public build(): SearchMerchantPartner {
    return this.toBuild;
  }

}
