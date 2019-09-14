import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { SetLocationComponent } from './set-location/set-location.component';
import { MaterialModule } from '../material/material.module';
import { AirportListComponent } from './airport-list/airport-list.component';
import { ActivityComponent } from './activity/activity.component';

const routes = [{
  path: '',
  component: SetLocationComponent
}];

@NgModule({
  declarations: [SetLocationComponent, AirportListComponent, ActivityComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule
  ]
})
export class LocationModule {
}
