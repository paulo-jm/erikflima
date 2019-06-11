import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Merchant } from '../../mapping/model/merchant';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GenericSearchService } from 'src/app/shared/service/search/generic-search-service';
import { GuustoService } from 'src/app/service/guusto-service';

@Injectable({
  providedIn: 'root'
})
export class MerchantSearchService extends GenericSearchService<Merchant>  {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_SEARCH_SERVICE), httpClient);
  }
  
}
