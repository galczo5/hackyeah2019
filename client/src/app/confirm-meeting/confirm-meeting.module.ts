import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { ConfirmMeetingComponent } from './confirm-meeting/confirm-meeting.component';
import { MaterialModule } from '../material/material.module';
import { ColoredButtonModule } from '../shared/colored-button/colored-button.module';
import { ConfirmMeetingService } from './confirm-meeting/confirm-meeting.service';


const routes = [{
  path: '',
  component: ConfirmMeetingComponent
}];

@NgModule({
  declarations: [ConfirmMeetingComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule,
    FormsModule,
    ColoredButtonModule
  ],
  providers: [
    ConfirmMeetingService
  ]
})
export class ConfirmMeetingModule {
}
