import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GuustoService } from 'src/app/service/guusto-service';
import { MerchantAddress } from '../../mapping/model/merchant-address';
import { GenericSearchService } from 'src/app/shared/service/search/generic-search-service';

@Injectable({
  providedIn: 'root'
})
export class MerchantAddressSearchService extends GenericSearchService<MerchantAddress> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_ADDRESS_SEARCH_SERVICE), httpClient);
  }

}
