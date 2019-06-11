import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantManagePageComponent } from './merchant-manage-page.component';

describe('MerchantManagePageComponent', () => {
  let component: MerchantManagePageComponent;
  let fixture: ComponentFixture<MerchantManagePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantManagePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantManagePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
