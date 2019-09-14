import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfirmMeetingComponent } from './confirm-meeting/confirm-meeting.component';
import {RouterModule} from "@angular/router";
import {MaterialModule} from "../material/material.module";

const routes = [{
  path: '',
  component: ConfirmMeetingComponent
}];

@NgModule({
  declarations: [ConfirmMeetingComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule
  ]
})
export class ConfirmMeetingModule { }
