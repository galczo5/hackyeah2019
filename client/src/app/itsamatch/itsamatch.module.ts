import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ItsamatchComponent } from './itsamatch.component';
import { RouterModule } from '@angular/router';


const routes = [{
  path: '',
  component: ItsamatchComponent
}];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    ItsamatchComponent
  ],
  providers: []
})
export class ItsamatchModule {}
