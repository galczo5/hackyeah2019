import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../material/material.module';
import { RecomendationListComponent } from './recomendation-list.component';
import { RecomendationService } from './recomendation.service';
import { RecomendationCardComponent } from './card/recomendation-card.component';

const routes = [{
  path: '',
  component: RecomendationListComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    RecomendationListComponent,
    RecomendationCardComponent
  ],
  providers: [
    RecomendationService
  ]
})
export class RecomendationModule {}
