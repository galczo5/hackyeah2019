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
import {AvatarModuleModule} from "../../avatar-module/avatar-module.module";
import {TicketComponent} from "../achivement/airports/ticket.component";
import {ForeignerAchievementComponent} from "../achivement/foreigners/foreigner-achievement.component";

const routes = [{
  path: '',
  component: TravelerProfileComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ProfileModule,
    RouterModule.forChild(routes),
    AvatarModuleModule
  ],
  declarations: [
    TravelerProfileComponent,
    TravelerForeignersComponent,
    TravelerAirportsComponent,
    TicketComponent,
    ForeignerAchievementComponent
  ],
  providers: [
    AirportAchievementService,
    ForeignersAchievementService
  ]
})
export class TravelerProfileModule {}
