import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CheckInComponent } from './check-in/check-in.component';
import {RouterModule} from "@angular/router";
import {MaterialModule} from "../material/material.module";

const routes = [{
  path: '',
  component: CheckInComponent
}];

@NgModule({
  declarations: [CheckInComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule
  ]
})
export class CheckInModule { }
