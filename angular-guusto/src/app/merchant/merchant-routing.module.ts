import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MerchantManagePageEditComponent } from './page/merchant-manage-page/merchant-manage-page-edit/merchant-manage-page-edit.component';
import { MerchantManagePageViewComponent } from './page/merchant-manage-page/merchant-manage-page-view/merchant-manage-page-view.component';
import { MerchantManagePageComponent } from './page/merchant-manage-page/merchant-manage-page.component';


const routes: Routes = [
  { path: 'merchant', component: MerchantManagePageComponent, children: [
    { path: '', component: MerchantManagePageViewComponent },
    { path: 'view', component: MerchantManagePageViewComponent },
    { path: 'edit', component: MerchantManagePageEditComponent },
    { path: 'edit/:id', component: MerchantManagePageEditComponent },
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MerchantRoutingModule { }
