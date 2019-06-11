import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantManagePageEditComponent } from './merchant-manage-page-edit.component';

describe('MerchantManagePageEditComponent', () => {
  let component: MerchantManagePageEditComponent;
  let fixture: ComponentFixture<MerchantManagePageEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantManagePageEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantManagePageEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
