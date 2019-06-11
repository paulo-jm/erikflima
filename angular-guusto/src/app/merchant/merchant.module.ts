import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MerchantFormComponent } from './components/form/merchant-form/merchant-form.component';
import { MerchantRoutingModule } from './merchant-routing.module';
import { MerchantManagePageEditComponent } from './page/merchant-manage-page/merchant-manage-page-edit/merchant-manage-page-edit.component';
import { MerchantManagePageViewComponent } from './page/merchant-manage-page/merchant-manage-page-view/merchant-manage-page-view.component';
import { MerchantManagePageComponent } from './page/merchant-manage-page/merchant-manage-page.component';
import { MerchantCrudService } from './service/crud/merchant-crud.service';
import { MerchantSearchService } from './service/search/merchant-search.service';
import { MerchantAddressCrudService } from './service/crud/merchant-address-crud.service';
import { MerchantAddressSearchService } from './service/search/merchant-address-search.service';
import { MerchantTypeCrudService } from './service/crud/merchant-type-crud.service';
import { MerchantTypeSearchService } from './service/search/merchant-type-search.service';
import { MerchantPartnerCrudService } from './service/crud/merchant-partner-crud.service';
import { MerchantPartnerSearchService } from './service/search/merchant-partner-search.service';
import { MerchantDenominationFormComponent } from './components/form/merchant-form/merchant-denomination-form/merchant-denomination-form.component';
import { MerchantFunctionalityFormComponent } from './components/form/merchant-form/merchant-functionality-form/merchant-functionality-form.component';
import { MerchantMetadataFormComponent } from './components/form/merchant-form/merchant-metadata-form/merchant-metadata-form.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    FormsModule,
    NgbModule,
    MerchantRoutingModule,
    SharedModule
  ],
  providers: [MerchantCrudService, MerchantSearchService, MerchantAddressCrudService, MerchantAddressSearchService,
    MerchantTypeCrudService, MerchantTypeSearchService, MerchantPartnerCrudService, MerchantPartnerSearchService],
  declarations: [MerchantManagePageComponent, MerchantManagePageViewComponent, MerchantManagePageEditComponent,
    MerchantFormComponent, MerchantDenominationFormComponent, MerchantFunctionalityFormComponent, MerchantMetadataFormComponent],
  exports: [MerchantManagePageComponent, MerchantManagePageViewComponent, MerchantManagePageEditComponent, MerchantFormComponent]
})
export class MerchantModule { }
