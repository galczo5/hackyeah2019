import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../material/material.module';
import { ProfileModule } from '../shared/profile/profile.module';
import { ColoredButtonModule } from '../shared/colored-button/colored-button.module';
import { PlaceConfirmComponent } from './place-confirm.component';


const routes = [{
  path: '',
  component: PlaceConfirmComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ProfileModule,
    RouterModule.forChild(routes),
    ColoredButtonModule
  ],
  declarations: [
    PlaceConfirmComponent
  ],
  providers: [
  ]
})
export class PlaceConfirm {}
