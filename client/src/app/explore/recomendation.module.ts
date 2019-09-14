import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../material/material.module';
import { RecomendationListComponent } from './recomendation-list.component';
import { RecomendationService } from './recomendation.service';
import { RecomendationCardComponent } from './card/recomendation-card.component';
import { ColoredButtonModule } from '../shared/colored-button/colored-button.module';

const routes = [{
  path: '',
  component: RecomendationListComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ColoredButtonModule,
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
