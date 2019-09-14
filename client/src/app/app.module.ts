import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
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
    ActiveTravelerStore
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
