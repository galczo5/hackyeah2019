import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { MaterialModule } from '../material/material.module';
import { ProfileModule } from '../shared/profile/profile.module';
import { LoginComponent } from './login.component';
import { ColoredButtonModule } from '../shared/colored-button/colored-button.module';


const routes = [{
  path: '',
  component: LoginComponent
}];

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ProfileModule,
    FormsModule,
    RouterModule.forChild(routes),
    ColoredButtonModule
  ],
  declarations: [
    LoginComponent
  ],
  providers: [
  ]
})
export class LoginModule {}
