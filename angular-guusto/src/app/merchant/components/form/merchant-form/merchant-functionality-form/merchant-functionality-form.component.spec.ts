import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantFunctionalityFormComponent } from './merchant-functionality-form.component';

describe('MerchantFunctionalityFormComponent', () => {
  let component: MerchantFunctionalityFormComponent;
  let fixture: ComponentFixture<MerchantFunctionalityFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantFunctionalityFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantFunctionalityFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
