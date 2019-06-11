import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GuustoService } from 'src/app/service/guusto-service';
import { EndpointFactoryService } from 'src/app/shared/factory/endpoint-factory.service';
import { GenericCrudService } from 'src/app/shared/service/crud/generic-crud-service';
import { MerchantType } from '../../mapping/model/merchant-type';

@Injectable({
  providedIn: 'root'
})
export class MerchantTypeCrudService extends GenericCrudService<MerchantType> {

  constructor(endpointFactory: EndpointFactoryService, httpClient: HttpClient) {
    super(endpointFactory.getEndpoint(GuustoService.MERCHANT_TYPE_CRUD_SERVICE), httpClient);
  }

}
