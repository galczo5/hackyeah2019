import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColoredButtonComponent } from './colored-button.component';
import { MaterialModule } from '../../material/material.module';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule
  ],
  declarations: [
    ColoredButtonComponent
  ],
  exports: [
    ColoredButtonComponent
  ]
})
export class ColoredButtonModule {
}
