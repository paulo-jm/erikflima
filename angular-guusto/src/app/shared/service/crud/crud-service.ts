import { PreparedQuery } from '../../query/prepared-query/prepared-query';
import { Observable } from 'rxjs';

export interface CrudService<T> {

    persist(model: T): Observable<any>;

    update(id: number, model: T): Observable<T>;

    remove(model: T): Observable<any>;

    removeById(id: number): Observable<any>;

    find(preparedQuery: PreparedQuery): Observable<T>;

    findAll(preparedQuery: PreparedQuery): Observable<T[]>;

    search(preparedQuery: PreparedQuery): Observable<T[]>;

    count(preparedQuery: PreparedQuery): Observable<number>;

    contains(model: T): Observable<boolean>;

}
