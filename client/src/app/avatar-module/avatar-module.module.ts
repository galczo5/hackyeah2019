import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AvatarComponentComponent } from './avatar-component/avatar-component.component';



@NgModule({
  declarations: [AvatarComponentComponent],
  exports: [
    AvatarComponentComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AvatarModuleModule { }
