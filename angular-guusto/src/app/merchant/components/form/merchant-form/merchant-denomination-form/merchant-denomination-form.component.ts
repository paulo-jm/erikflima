import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, Validators, FormBuilder, FormArray } from '@angular/forms';

@Component({
  selector: 'gt-merchant-denomination-form',
  templateUrl: './merchant-denomination-form.component.html',
  styleUrls: ['./merchant-denomination-form.component.scss']
})
export class MerchantDenominationFormComponent implements OnInit {

  merchantDenominationForm: FormGroup;

  @Input() set merchantDenominations(merchantDenominations: any[]) {
    this.updateMerchantDenominationFormArray(merchantDenominations);
  }
  @Input() merchantDenominationFormArray: FormArray;

  constructor(private formBuilder: FormBuilder) { }

  addMerchantDenomination() {
    if (this.merchantDenominationForm.valid) {
      this.addMerchantDenominationValue(this.merchantDenominationForm.get('merchantDenomination').value);
      this.merchantDenominationForm = this.createMerchantDenominationForm();
    }
  }

  addMerchantDenominationValue(denomination: number) {
    if (denomination) {
      this.merchantDenominationFormArray.push(this.formBuilder.control(denomination));
    }
  }

  removeMerchantDenomination(index) {
    this.merchantDenominationFormArray.removeAt(index);
  }

  createMerchantDenominationForm(): FormGroup {

    return this.formBuilder.group({
      merchantDenomination: ['', Validators.required]
    });

  }

  updateMerchantDenominationFormArray(merchantDenominations: any[]) {
    if (this.merchantDenominationFormArray && merchantDenominations && merchantDenominations.length > 0) {
      merchantDenominations.forEach(denomination => this.addMerchantDenominationValue(denomination));
    }
  }

  ngOnInit() {
    this.merchantDenominationForm = this.createMerchantDenominationForm();
  }

}
