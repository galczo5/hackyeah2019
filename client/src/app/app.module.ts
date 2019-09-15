import { BrowserModule } from '@angular/platform-browser';
import {APP_BOOTSTRAP_LISTENER, APP_INITIALIZER, NgModule} from '@angular/core';
import { ServiceWorkerModule } from '@angular/service-worker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { environment } from '../environments/environment';
import { FAKE_LOCATION } from './geolocation/geolocation.service';
import { MaterialModule } from './material/material.module';
import { ActiveTravelerStore } from './traveler/active.traveler.store';
import { NavigationModule } from './shared/navigation/navigation.module';
import {Router} from "@angular/router";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production }),
    BrowserAnimationsModule,
    MaterialModule,
    NavigationModule
  ],
  providers: [
    { provide: FAKE_LOCATION, useValue: true },
    {
      multi: true,
      provide: APP_BOOTSTRAP_LISTENER,
      useFactory: (router: Router) => {
        return () => {
          router.navigateByUrl('/welcome');
        }
      },
      deps: [Router]
    },
    ActiveTravelerStore
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
