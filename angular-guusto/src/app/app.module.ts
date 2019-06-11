import { BrowserModule } from '@angular/platform-browser';
import { NgModule, APP_INITIALIZER } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GuustoInitializerService } from './service/guusto-initializer.service';
import { EndpointFactoryService } from './shared/factory/endpoint-factory.service';
import { environment } from 'src/environments/environment';
import { SharedModule } from './shared/shared.module';

export function initializer(guustoInitializerService: GuustoInitializerService, endpointFactoryService: EndpointFactoryService) {
  return (): Promise<any> => {
    return guustoInitializerService.initializer(environment.guustoBaseApi);
  }
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule
  ],
  providers: [
    GuustoInitializerService,
    EndpointFactoryService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [GuustoInitializerService, EndpointFactoryService],
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
