import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { TravelerProfileComponent } from './traveler-profile.component';
import { MaterialModule } from '../../material/material.module';
import { AirportAchievementService } from '../achivement/airports/airport-achievement.service';
import { TravelerAirportsComponent } from '../achivement/airports/traveler-airports.component';
import { TravelerForeignersComponent } from '../achivement/foreigners/traveler-foreigners.component';
import { ForeignersAchievementService } from '../achivement/foreigners/foreigners-achievement.service';
import { ProfileModule } from '../../shared/profile/profile.module';

const routes = [{
  path: '',
  component: TravelerProfileComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ProfileModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    TravelerProfileComponent,
    TravelerForeignersComponent,
    TravelerAirportsComponent
  ],
  providers: [
    AirportAchievementService,
    ForeignersAchievementService
  ]
})
export class TravelerProfileModule {}
