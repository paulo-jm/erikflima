import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GuustoService } from 'src/app/service/guusto-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { MerchantPartner } from '../../mapping/model/merchant-partner';
import { GenericSearchService } from 'src/app/shared/service/search/generic-search-service';

@Injectable({
  providedIn: 'root'
})
export class MerchantPartnerSearchService extends GenericSearchService<MerchantPartner> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_PARTNER_SEARCH_SERVICE), httpClient);
  }

}
