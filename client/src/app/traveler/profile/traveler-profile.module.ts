import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { TravelerProfileComponent } from './traveler-profile.component';
import { MaterialModule } from '../../material/material.module';
import { AirportAchievementService } from '../achivement/airports/airport-achievement.service';
import { TravelerBadgesComponent } from '../achivement/badges/traveler-badges.component';
import { TravelerAirportsComponent } from '../achivement/airports/traveler-airports.component';

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
  ],
  providers: [
    AirportAchievementService
  ]
})
export class TravelerProfileModule {}
