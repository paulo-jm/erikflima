import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';

@Component({
  selector: 'gt-merchant-metadata-form',
  templateUrl: './merchant-metadata-form.component.html',
  styleUrls: ['./merchant-metadata-form.component.scss']
})
export class MerchantMetadataFormComponent implements OnInit {

  @Input() metadataFormGroup: FormGroup;

  @Input() set metadata(value: any[]) {
    this.updateMetadataForm(value);
  }
  metadataForm: FormGroup;

  constructor(private formBuilder: FormBuilder) { }


  createMetadataForm(): FormGroup {

    return this.formBuilder.group({
      key: ['', Validators.required],
      value: ['', Validators.required],
    });

  }

  getMetadataAsKeys() {
    return Object.keys(this.metadataFormGroup.controls);
  }

  addMetadata() {
    if (this.metadataForm.valid) {
      const key = this.metadataForm.get('key').value;
      const value = this.metadataForm.get('value').value;
      this.addMetadataValue(key, value);
      this.metadataForm = this.createMetadataForm();
    }
  }
  addMetadataValue(key: any, value: any) {
    if (key) {
      const control = this.formBuilder.control(value, []);
      this.metadataFormGroup.addControl(key, control);
    }
  }

  removeMetadata(key: string) {
    if (key) {
      this.metadataFormGroup.removeControl(key);
    }
  }

  updateMetadataForm(metadata: any): void {

    if (this.metadataFormGroup && metadata) {
      Object.keys(metadata).forEach( key=> {
        this.addMetadataValue(key, metadata[key]);
      });
    }

  }

  ngOnInit() {
    this.metadataForm = this.createMetadataForm();
  }

}
