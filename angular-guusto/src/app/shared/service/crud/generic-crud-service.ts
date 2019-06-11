import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PreparedQuery } from '../../query/prepared-query/prepared-query';
import { CrudService } from './crud-service';
import { Endopoint } from '../../factory/model/endopoint';
import { ResultSetAdapter } from '../result/result-set-adapter';
import { CrudServiceResource } from './crud-service-resource.enum';

export class GenericCrudService<T> implements CrudService<T>, ResultSetAdapter<T>{

    constructor(protected endpoint: Endopoint, protected httpClient: HttpClient) { }

    persist(model: T): Observable<any> {
        return this.httpClient.post<T>(this.endpoint.getUrl(CrudServiceResource.PERSIST), model);
    }

    update(id: number, model: T): Observable<T> {
        return this.httpClient.put<T>(this.endpoint.getUrl(CrudServiceResource.UPDATE, id), model);
    }

    remove(model: T): Observable<any> {
        return this.httpClient.delete<T>(this.endpoint.getUrl(CrudServiceResource.REMOVE), model);
    }

    removeById(id: number): Observable<any> {
        return this.httpClient.delete<T>(this.endpoint.getUrl(CrudServiceResource.REMOVE_BY_ID, id));
    }

    findById(id: number): Observable<T> {
        return this.httpClient.get<T>(this.endpoint.getUrl(CrudServiceResource.FIND_BY_ID, id));
    }

    find(preparedQuery: PreparedQuery): Observable<T> {
        const options = preparedQuery ? { params: preparedQuery.toHttpParams() } : {};
        return this.httpClient.get<T>(this.endpoint.getUrl(CrudServiceResource.FIND), options);
    }

    findAll(preparedQuery: PreparedQuery): Observable<T[]> {
        const url = this.endpoint.getUrl(CrudServiceResource.FIND_ALL)
        const params = preparedQuery.toHttpParams(); 
        const fullUrl = params ? `${url}?${params.toString()}` : url;
        return this.httpClient.get<T[]>(fullUrl);
    }

    search(preparedQuery: PreparedQuery): Observable<T[]> {
        const url = this.endpoint.getUrl(CrudServiceResource.SEARCH)
        const params = preparedQuery.toHttpParams(); 
        const fullUrl = params ? `${url}?${params.toString()}` : url;
        return this.httpClient.get<T[]>(fullUrl);
    }

    contains(model: T): Observable<boolean> {
        return this.httpClient.post<boolean>(this.endpoint.getUrl(CrudServiceResource.CONTAINS), model);
    }

    count(preparedQuery: PreparedQuery): Observable<number> {
        const options = preparedQuery ? { params: preparedQuery.toHttpParams() } : {};
        return this.httpClient.get<number>(this.endpoint.getUrl(CrudServiceResource.COUNT), options);
    }

}
