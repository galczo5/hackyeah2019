import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { TravelerFriendsComponent } from './traveler-friends.component';

const routes = [{
  path: '',
  component: TravelerFriendsComponent
}];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    TravelerFriendsComponent
  ]
})
export class TravelerFriendsModule {}
