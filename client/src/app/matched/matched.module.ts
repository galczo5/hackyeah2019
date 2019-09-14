import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../material/material.module';
import { MatchedComponent } from './matched.component';
import { ProfileModule } from '../shared/profile/profile.module';


const routes = [{
  path: '',
  component: MatchedComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ProfileModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    MatchedComponent
  ],
  providers: [
  ]
})
export class MatchedModule {}
