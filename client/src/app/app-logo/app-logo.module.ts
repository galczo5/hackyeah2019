import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppLogoComponent } from './app-logo/app-logo.component';
import {RouterModule} from "@angular/router";

const routes = [{
  path: '',
  component: AppLogoComponent
}];

@NgModule({
  declarations: [AppLogoComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class AppLogoModule { }
