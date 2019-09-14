import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { TravelerProfileComponent } from './traveler-profile.component';
import { TravelerAirportsComponent } from './airports/traveler-airports.component';
import { TravelerBadgesComponent } from './badges/traveler-badges.component';
import { MaterialModule } from '../../material/material.module';

const routes = [{
  path: '',
  component: TravelerProfileComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    TravelerProfileComponent,
    TravelerBadgesComponent,
    TravelerAirportsComponent
  ]
})
export class TravelerProfileModule {}
