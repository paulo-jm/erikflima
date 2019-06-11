import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationItemComponent } from './components/navigation/navigation-item/navigation-item.component';
import { NavigationComponent } from './components/navigation/navigation/navigation.component';
import { RouterModule } from '@angular/router';
import { SnackbarComponent } from './components/snackbar/snackbar/snackbar.component';
import { SnackbarService } from './components/snackbar/service/snackbar.service';

@NgModule({
  declarations: [NavigationComponent, NavigationItemComponent, SnackbarComponent],
  exports: [NavigationComponent, NavigationItemComponent, SnackbarComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  providers: [SnackbarService]
})
export class SharedModule { }
