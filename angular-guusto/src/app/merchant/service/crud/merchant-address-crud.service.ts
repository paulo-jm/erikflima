import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenericCrudService } from 'src/app/shared/service/crud/generic-crud-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GuustoService } from 'src/app/service/guusto-service';
import { MerchantAddress } from '../../mapping/model/merchant-address';

@Injectable({
  providedIn: 'root'
})
export class MerchantAddressCrudService extends GenericCrudService<MerchantAddress> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_ADDRESS_CRUD_SERVICE), httpClient);
  }

}
