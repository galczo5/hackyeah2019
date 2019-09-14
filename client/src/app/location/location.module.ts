import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SetLocationComponent } from './set-location/set-location.component';
import {RouterModule} from "@angular/router";
import {MaterialModule} from "../material/material.module";

const routes = [{
  path: '',
  component: SetLocationComponent
}];

@NgModule({
  declarations: [SetLocationComponent],
  imports: [
    RouterModule.forChild(routes),
    MaterialModule,
    CommonModule
  ]
})
export class LocationModule { }
