import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileComponent } from './profile.component';
import {AvatarModuleModule} from "../../avatar-module/avatar-module.module";


@NgModule({
  imports: [
    CommonModule,
    AvatarModuleModule
  ],
  declarations: [
    ProfileComponent
  ],
  exports: [
    ProfileComponent
  ]
})
export class ProfileModule {
}
