import { BehaviorSubject, Subject, merge, Observable } from 'rxjs';
import { SearchService } from '../service/search/search-service';

export class PaginationSource<T, S> {

  totalRecordsSubject: BehaviorSubject<number> = new BehaviorSubject<number>(0);

  $totalRecords: Observable<number> = this.totalRecordsSubject.asObservable();

  private numberOfRecordsSubject: BehaviorSubject<number> = new BehaviorSubject<number>(0);

  $numberOfRecords: Observable<number> = this.numberOfRecordsSubject.asObservable();

  private recordsSubject: BehaviorSubject<T[]> = new BehaviorSubject<T[]>([]);
  get records(): Observable<T[]> {
    return this.recordsSubject.asObservable();;
  }

  private loadingSubject: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  $loading: Observable<boolean> = this.loadingSubject.asObservable();

  private $itemsPerPage: Subject<number> = new Subject<number>();
  private _itemsPerPage: number = 10;
  get itemsPerPage(): number {
    return this._itemsPerPage;
  }
  set itemsPerPage(value: number) {
    this._itemsPerPage = value;
    this.$itemsPerPage.next(value);
  }

  private $currentPage: Subject<number> = new Subject<number>();
  private _currentPage: number = 1;
  get currentPage(): number {
    return this._currentPage;
  }
  set currentPage(value: number) {
    this._currentPage = value;
    this.$currentPage.next(value);
  }

  private $specification: Subject<S> = new Subject<S>();
  private _specification: S;
  get specification(): S {
    return this._specification;
  }
  set specification(value: S) {
    this._specification = value;
    this.$specification.next(value);
  }

  private $ordersBy: Subject<Map<string, string>> = new Subject<Map<string, string>>();
  private _ordersBy: Map<string, string>;
  get ordersBy(): Map<string, string> {
    return this._ordersBy;
  }
  set ordersBy(value: Map<string, string>) {
    this._ordersBy = value;
    this.$ordersBy.next(value);
  }

  constructor(private searchService: SearchService<T>) {

    this.paginate(this.specification, this.itemsPerPage, this.currentPage, this.ordersBy);

    merge(this.$specification, this.$currentPage, this.$itemsPerPage)
      .subscribe(value => {
        this.paginate(this.specification, this.itemsPerPage, this.currentPage, this.ordersBy);
      });

  }

  paginate(specification: S | string = null, itensPerPage: number = null, currentPage: number = null, ordersBy: Map<string, string> = null): void {

    this.loadingSubject.next(true);

    this.searchService.paginate(specification, itensPerPage, currentPage, ordersBy)
      .subscribe(
        result => {
          if (result) {
            this.totalRecordsSubject.next(result.totalItens);
            this.numberOfRecordsSubject.next(result.itensPerPage);
            this.recordsSubject.next(result.results);
          } else {
            this.totalRecordsSubject.next(0);
            this.numberOfRecordsSubject.next(0);
            this.recordsSubject.next([]);
          }
        },
        error => {
          this.loadingSubject.next(false);
        },
        () => {
          this.loadingSubject.next(false);
        }
      );

  }

}
