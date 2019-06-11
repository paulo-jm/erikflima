import { PreparedQuery } from '../../query/prepared-query/prepared-query';
import { Observable } from 'rxjs';

export interface ResultSetAdapter<T> {

    findAll(preparedQuery: PreparedQuery): Observable<T[]>;

    count(preparedQuery: PreparedQuery): Observable<number>; 

}
