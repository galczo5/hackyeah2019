import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { TravelerProfileComponent } from './traveler-profile.component';

const routes = [{
  path: '',
  component: TravelerProfileComponent
}];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    TravelerProfileComponent
  ]
})
export class TravelerProfileModule {}
