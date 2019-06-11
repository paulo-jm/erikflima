import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GuustoService } from 'src/app/service/guusto-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GenericCrudService } from 'src/app/shared/service/crud/generic-crud-service';
import { MerchantPartner } from '../../mapping/model/merchant-partner';

@Injectable({
  providedIn: 'root'
})
export class MerchantPartnerCrudService extends GenericCrudService<MerchantPartner> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_PARTNER_CRUD_SERVICE), httpClient);
  }

}
