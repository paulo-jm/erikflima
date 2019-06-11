import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantMetadataFormComponent } from './merchant-metadata-form.component';

describe('MerchantMetadataFormComponent', () => {
  let component: MerchantMetadataFormComponent;
  let fixture: ComponentFixture<MerchantMetadataFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantMetadataFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantMetadataFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
