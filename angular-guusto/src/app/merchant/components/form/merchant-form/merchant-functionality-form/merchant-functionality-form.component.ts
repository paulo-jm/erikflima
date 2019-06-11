import { Component, OnInit, Input } from '@angular/core';
import { FormArray, FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'gt-merchant-functionality-form',
  templateUrl: './merchant-functionality-form.component.html',
  styleUrls: ['./merchant-functionality-form.component.scss']
})
export class MerchantFunctionalityFormComponent implements OnInit {

  @Input() set functionalities(functionalities: any[]) {
    this.updateFunctionalitiesFormArray(functionalities);
  }
  @Input() functionalitiesFormArray: FormArray;

  functionalityForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  addFunctionality() {
    if (this.functionalityForm.valid) {
      this.addFunctionalityValue(this.functionalityForm.get('functionality').value);
      this.functionalityForm = this.createFunctionalityForm();
    }
  }

  addFunctionalityValue(functionality:string) {
    if (functionality) {
      this.functionalitiesFormArray.push(this.formBuilder.control(functionality));
    }
  }

  removeFunctionality(index) {
    this.functionalitiesFormArray.removeAt(index);
  }

  createFunctionalityForm(): FormGroup {

    return this.formBuilder.group({
      functionality: ['', Validators.required]
    });

  }

  updateFunctionalitiesFormArray(functionalities: any[]) {
    if (this.functionalitiesFormArray && functionalities && functionalities.length > 0) {
      functionalities.forEach(functionality => this.addFunctionalityValue(functionality));
    }
  }

  ngOnInit() {
    this.functionalityForm = this.createFunctionalityForm();
  }

}
