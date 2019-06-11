import { Observable } from 'rxjs';
import { Paginator } from '../result/model/paginator';
import { ResultSet } from '../result/model/result-set';
import { Specification } from '../../query/specification/specification';

export interface SearchService<T> {

    search(specification: Specification, limit: number, offest: number, ordersBy: Map<String, String>): Observable<ResultSet<T>>;

    paginate(specification: Specification, page: number, itemsPerPage: number, ordersBy: Map<String, String>): Observable<Paginator<T>>;

}
