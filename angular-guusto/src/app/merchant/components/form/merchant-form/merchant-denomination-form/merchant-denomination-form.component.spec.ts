import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantDenominationFormComponent } from './merchant-denomination-form.component';

describe('MerchantDenominationFormComponent', () => {
  let component: MerchantDenominationFormComponent;
  let fixture: ComponentFixture<MerchantDenominationFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantDenominationFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantDenominationFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
