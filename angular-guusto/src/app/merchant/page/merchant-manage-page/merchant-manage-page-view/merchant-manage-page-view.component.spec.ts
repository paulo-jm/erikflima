import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MerchantManagePageViewComponent } from './merchant-manage-page-view.component';

describe('MerchantManagePageViewComponent', () => {
  let component: MerchantManagePageViewComponent;
  let fixture: ComponentFixture<MerchantManagePageViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MerchantManagePageViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MerchantManagePageViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
