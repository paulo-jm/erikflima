
import { Injectable } from '@angular/core';
import { GuustoService } from './guusto-service';
import { EndopointBuilder } from '../shared/factory/model/endopoint';
import { EndpointFactoryService } from '../shared/factory/endpoint-factory.service';
import { CrudServiceResource } from '../shared/service/crud/crud-service-resource.enum';
import { SearchServiceResource } from '../shared/service/search/search-service-resource.enum';

@Injectable({
  providedIn: 'root'
})
export class GuustoInitializerService {

  constructor(private endpointFactory: EndpointFactoryService) { };

  initializer(baseURL: string): Promise<void> {
    return new Promise<void>((resolve, reject) => {

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_CRUD_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(CrudServiceResource.PERSIST, 'merchant/merchant')
        .addResource(CrudServiceResource.REMOVE, 'merchant/merchant')
        .addResource(CrudServiceResource.FIND_ALL, 'merchant/merchant')
        .addResource(CrudServiceResource.UPDATE, 'merchant/merchant/{0}')
        .addResource(CrudServiceResource.REMOVE_BY_ID, 'merchant/merchant/{0}')
        .addResource(CrudServiceResource.FIND, 'merchant/merchant/find')
        .addResource(CrudServiceResource.CONTAINS, 'merchant/merchant/contains')
        .addResource(CrudServiceResource.FIND_BY_ID, 'merchant/merchant/{0}')
        .addResource(CrudServiceResource.SEARCH, 'merchant/merchant/search')
        .addResource(CrudServiceResource.COUNT, 'merchant/merchant/count')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_SEARCH_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(SearchServiceResource.PAGINATE, 'merchant/merchant/paginate')
        .addResource(SearchServiceResource.SEARCH, 'merchant/merchant/search')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_ADDRESS_CRUD_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(CrudServiceResource.PERSIST, 'merchant/address')
        .addResource(CrudServiceResource.REMOVE, 'merchant/address')
        .addResource(CrudServiceResource.FIND_ALL, 'merchant/address')
        .addResource(CrudServiceResource.UPDATE, 'merchant/address/{0}')
        .addResource(CrudServiceResource.REMOVE_BY_ID, 'merchant/address/{0}')
        .addResource(CrudServiceResource.FIND, 'merchant/address/find')
        .addResource(CrudServiceResource.CONTAINS, 'merchant/address/contains')
        .addResource(CrudServiceResource.FIND_BY_ID, 'merchant/address/{0}')
        .addResource(CrudServiceResource.SEARCH, 'merchant/address/search')
        .addResource(CrudServiceResource.COUNT, 'merchant/address/count')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_ADDRESS_SEARCH_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(SearchServiceResource.PAGINATE, 'merchant/address/paginate')
        .addResource(SearchServiceResource.SEARCH, 'merchant/address/search')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_PARTNER_CRUD_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(CrudServiceResource.PERSIST, 'merchant/partner')
        .addResource(CrudServiceResource.REMOVE, 'merchant/partner')
        .addResource(CrudServiceResource.FIND_ALL, 'merchant/partner')
        .addResource(CrudServiceResource.UPDATE, 'merchant/partner/{0}')
        .addResource(CrudServiceResource.REMOVE_BY_ID, 'merchant/partner/{0}')
        .addResource(CrudServiceResource.FIND, 'merchant/partner/find')
        .addResource(CrudServiceResource.CONTAINS, 'merchant/partner/contains')
        .addResource(CrudServiceResource.FIND_BY_ID, 'merchant/partner/{0}')
        .addResource(CrudServiceResource.SEARCH, 'merchant/partner/search')
        .addResource(CrudServiceResource.COUNT, 'merchant/partner/count')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_PARTNER_SEARCH_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(SearchServiceResource.PAGINATE, 'merchant/partner/paginate')
        .addResource(SearchServiceResource.SEARCH, 'merchant/partner/search')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_TYPE_CRUD_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(CrudServiceResource.PERSIST, 'merchant/type')
        .addResource(CrudServiceResource.REMOVE, 'merchant/type')
        .addResource(CrudServiceResource.FIND_ALL, 'merchant/type')
        .addResource(CrudServiceResource.UPDATE, 'merchant/type/{0}')
        .addResource(CrudServiceResource.REMOVE_BY_ID, 'merchant/type/{0}')
        .addResource(CrudServiceResource.FIND, 'merchant/type/find')
        .addResource(CrudServiceResource.CONTAINS, 'merchant/type/contains')
        .addResource(CrudServiceResource.FIND_BY_ID, 'merchant/type/{0}')
        .addResource(CrudServiceResource.SEARCH, 'merchant/type/search')
        .addResource(CrudServiceResource.COUNT, 'merchant/type/count')
        .build());

      this.endpointFactory.addEndpoint(GuustoService.MERCHANT_TYPE_SEARCH_SERVICE, EndopointBuilder.getInstance()
        .endopoint(baseURL)
        .addResource(SearchServiceResource.PAGINATE, 'merchant/type/paginate')
        .addResource(SearchServiceResource.SEARCH, 'merchant/type/search')
        .build());

      resolve();

    });
  }
}
