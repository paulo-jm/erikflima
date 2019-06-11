import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms'
import { PaginationSource } from 'src/app/shared/collection/pagination-source';
import { Merchant } from '../../../mapping/model/merchant';
import { MerchantSearchService } from '../../../service/search/merchant-search.service';
import { SearchMerchant } from '../../../mapping/specification/search-merchant';

@Component({
  selector: 'gt-merchant-manage-page-view',
  templateUrl: './merchant-manage-page-view.component.html',
  styleUrls: ['./merchant-manage-page-view.component.scss']
})
export class MerchantManagePageViewComponent implements OnInit {

  public merchantPaginationSource: PaginationSource<Merchant, SearchMerchant>;

  public searchMerchantForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private merchantSearchService: MerchantSearchService) {
    this.merchantPaginationSource = new PaginationSource(this.merchantSearchService);
    this.searchMerchantForm = this.createFormGroupWithBuilder(this.formBuilder);
  }

  createFormGroupWithBuilder(formBuilder: FormBuilder) {
    return formBuilder.group({
      'q': [null, []],
    });
  }

  onSort(event) {
    console.log(event);
  }

  ngOnInit() {

    this.searchMerchantForm.valueChanges.subscribe(value => {
      const searchMerchant: SearchMerchant = Object.assign({}, this.searchMerchantForm.value);
      this.merchantPaginationSource.specification = searchMerchant;
    });

  }

}
