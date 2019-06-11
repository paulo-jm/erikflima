import { SearchSpecification } from 'src/app/shared/query/specification/search-specification';
export class SearchMerchantType extends SearchSpecification {

  ids: string;

}

export class SearchMerchantTypeBuilder {

  private toBuild: SearchMerchantType = new SearchMerchantType();

  public static getInstance(): SearchMerchantTypeBuilder {
    return new SearchMerchantTypeBuilder();
  }

  public ids(ids: string): SearchMerchantTypeBuilder {
    this.toBuild.ids = ids;
    return this;
  }

  public q(q: string): SearchMerchantTypeBuilder {
    this.toBuild.q = q;
    return this;
  }

  public build(): SearchMerchantType {
    return this.toBuild;
  }

}
