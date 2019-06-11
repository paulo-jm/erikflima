import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, Subject } from 'rxjs';
import { MerchantCrudService } from 'src/app/merchant/service/crud/merchant-crud.service';
import { Merchant } from 'src/app/merchant/mapping/model/merchant';
import { SnackbarService } from 'src/app/shared/components/snackbar/service/snackbar.service';
import { FormGroup } from '@angular/forms';
import { MerchantFormComponent } from 'src/app/merchant/components/form/merchant-form/merchant-form.component';

@Component({
  selector: 'gt-merchant-manage-page-edit',
  templateUrl: './merchant-manage-page-edit.component.html',
  styleUrls: ['./merchant-manage-page-edit.component.scss']
})
export class MerchantManagePageEditComponent implements OnInit {

  private merchantId: Subject<number> = new Subject<number>();

  public merchant: Merchant;

  public merchantForm: FormGroup;

  @ViewChild(MerchantFormComponent) merchantFormComponent: MerchantFormComponent;

  constructor(private route: ActivatedRoute,
              private merchantCrudService: MerchantCrudService,
              private snackbarService: SnackbarService) {
  }

  saveMerchant(){
    // this.merchantCrudService.persist().subscribe(x= > {
    //   this.snackbarService.open("Save with sucess");
    // })
  }

  ngOnInit() {

    this.merchantId.subscribe(value => {
      if (value) {
        this.merchantCrudService.findById(value).subscribe(merchant => this.merchant = merchant);
      }
    });

    this.route.params.subscribe(params => {
      this.merchantId.next(+params.id);
    });

  }

}
