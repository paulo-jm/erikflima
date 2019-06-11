import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Endopoint } from '../../factory/model/endopoint';
import { ParamBuilder } from '../../query/param/param-builder';
import { Paginator } from '../result/model/paginator';
import { ResultSet } from '../result/model/result-set';
import { SearchService } from './search-service';
import { SearchServiceResource } from './search-service-resource.enum';
import { Specification } from '../../query/specification/specification';

export class GenericSearchService<T> implements SearchService<T>{

    constructor(protected endpoint: Endopoint, protected httpClient: HttpClient) { }

    search(specification: string | Specification = null, limit: number = null, offest: number = null, ordersBy: Map<String, String> = null): Observable<ResultSet<T>> {
        const url = this.endpoint.getUrl(SearchServiceResource.SEARCH)
        let params = null;

        if (specification && typeof specification === 'string') {
            params = ParamBuilder.getInstance()
                .addParam('limit', limit)
                .addParam('offest', offest)
                .addParam('q', specification)
                .addJsonParam('ordersBy', ordersBy)
                .toHttpParams();
        }
        else {
            params = ParamBuilder.getInstance()
                .addParam('limit', limit)
                .addParam('offest', offest)
                .addJsonParam('specification', specification)
                .addJsonParam('ordersBy', ordersBy)
                .toHttpParams();
        }

        const fullUrl = params ? `${url}?${params.toString()}` : url;
        return this.httpClient.get<ResultSet<T>>(fullUrl);
    }

    paginate(specification:  string | Specification = null, itensPerPage: number = null, currentPage: number = null, ordersBy: Map<String, String> = null): Observable<Paginator<T>> {
        const url = this.endpoint.getUrl(SearchServiceResource.PAGINATE)
        let params = null;

        if (specification && typeof specification === 'string') {
            params = ParamBuilder.getInstance()
                .addParam('currentPage', currentPage)
                .addParam('itensPerPage', itensPerPage)
                .addParam('q', specification)
                .addJsonParam('ordersBy', ordersBy)
                .toHttpParams();
        }
        else {
            params = ParamBuilder.getInstance()
                .addParam('currentPage', currentPage)
                .addParam('itensPerPage', itensPerPage)
                .addJsonParam('specification', specification)
                .addJsonParam('ordersBy', ordersBy)
                .toHttpParams();
        }
        const fullUrl = params ? `${url}?${params.toString()}` : url;
        return this.httpClient.get<Paginator<T>>(fullUrl);
    }


}
