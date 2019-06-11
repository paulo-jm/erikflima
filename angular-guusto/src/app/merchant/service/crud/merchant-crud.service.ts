import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Merchant } from '../../mapping/model/merchant';
import { GenericCrudService } from 'src/app/shared/service/crud/generic-crud-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GuustoService } from 'src/app/service/guusto-service';

@Injectable({
  providedIn: 'root'
})
export class MerchantCrudService extends GenericCrudService<Merchant> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_CRUD_SERVICE), httpClient);
  }

}
