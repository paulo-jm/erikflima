import { Component, Input, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Merchant } from 'src/app/merchant/mapping/model/merchant';
import { MerchantAddress } from 'src/app/merchant/mapping/model/merchant-address';
import { MerchantPartner } from 'src/app/merchant/mapping/model/merchant-partner';
import { MerchantType } from 'src/app/merchant/mapping/model/merchant-type';
import { SearchMerchantAddress } from 'src/app/merchant/mapping/specification/search-merchant-address';
import { SearchMerchantPartner } from 'src/app/merchant/mapping/specification/search-merchant-partner';
import { SearchMerchantType } from 'src/app/merchant/mapping/specification/search-merchant-type';
import { MerchantAddressSearchService } from 'src/app/merchant/service/search/merchant-address-search.service';
import { MerchantPartnerSearchService } from 'src/app/merchant/service/search/merchant-partner-search.service';
import { MerchantTypeSearchService } from 'src/app/merchant/service/search/merchant-type-search.service';
import { DataSource } from 'src/app/shared/collection/data-source';

@Component({
  selector: 'gt-merchant-form',
  templateUrl: './merchant-form.component.html',
  styleUrls: ['./merchant-form.component.scss']
})
export class MerchantFormComponent implements OnInit {

  merchantForm: FormGroup;

  merchantPartnerDataSource: DataSource<MerchantPartner, SearchMerchantPartner>;
  merchantAddressDataSource: DataSource<MerchantAddress, SearchMerchantAddress>;
  merchantTypeDataSource: DataSource<MerchantType, SearchMerchantType>;

  public $merchant: Merchant;
  @Input() set merchant(merchant: Merchant) {
    this.$merchant = merchant;
    this.updateMerchantForm(merchant);
  }
  get merchant() {
    return this.$merchant;
  }

  constructor(private formBuilder: FormBuilder,
              private merchantPartnerSearchService: MerchantPartnerSearchService,
              private merchantAddressSearchService: MerchantAddressSearchService,
              private merchantTypeSearchService: MerchantTypeSearchService) {

    this.merchantPartnerDataSource = new DataSource(this.merchantPartnerSearchService);
    this.merchantAddressDataSource = new DataSource(this.merchantAddressSearchService, false);
    this.merchantTypeDataSource = new DataSource(this.merchantTypeSearchService, false);
    this.merchantTypeDataSource.itemsPerPage = 50;

  }

  getFunctionalities(): FormArray {
    return this.merchantForm.get('functionalities') as FormArray;
  }

  getMerchantDenominations(): FormArray {
    return this.merchantForm.get('merchantDenominations') as FormArray;
  }

  getMetadata(): FormGroup {
    return this.merchantForm.get('metadata') as FormGroup;
  }

  createMerchantForm(): FormGroup {

    return this.formBuilder.group({
      id: [''],
      merchantName: [''],
      merchantDescription: [''],
      merchantPicture: [''],
      active: [''],
      minAmount: [''],
      maxAmount: [''],
      merchantNote: [''],
      shoppingOption: [''],
      website: [''],
      defaultMessage: [''],
      typeFK: [''],
      metadata: this.formBuilder.group({}),
      merchantDenominations: this.formBuilder.array([]),
      partnerFK: [''],
      country: [''],
      currency: [''],
      functionalities: this.formBuilder.array([])
    });

  }

  updateMerchantForm(merchant: Merchant) {

    if (this.merchantForm && merchant) {
      this.merchantForm.patchValue({
        id: merchant.id,
        merchantName: merchant.merchantName,
        merchantDescription: merchant.merchantDescription,
        merchantPicture: merchant.merchantPicture,
        active: merchant.active,
        minAmount: merchant.minAmount,
        maxAmount: merchant.maxAmount,
        merchantNote: merchant.merchantNote,
        shoppingOption: merchant.shoppingOption,
        website: merchant.website,
        defaultMessage: merchant.defaultMessage,
        typeFK: merchant.typeFK,
        balanceCheck: merchant.balanceCheck,
        partnerFK: merchant.partnerFK,
        country: merchant.country,
        currency: merchant.currency
      });
    }

  }

  ngOnInit() {
    if (!this.merchantForm) {
      this.merchantForm = this.createMerchantForm();
    }
  }

}
