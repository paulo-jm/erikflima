import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GuustoService } from 'src/app/service/guusto-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { MerchantType } from '../../mapping/model/merchant-type';
import { GenericSearchService } from 'src/app/shared/service/search/generic-search-service';

@Injectable({
  providedIn: 'root'
})
export class MerchantTypeSearchService extends GenericSearchService<MerchantType> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_TYPE_SEARCH_SERVICE), httpClient);
  }

}
