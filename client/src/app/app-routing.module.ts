import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TravelerFriendsModule } from './traveler/friends/traveler-friends.module';
import { TravelerProfileModule } from './traveler/profile/traveler-profile.module';


const routes: Routes = [
  { path: '', redirectTo: 'location', pathMatch: 'full' },
  { path: 'location', loadChildren: './location/location.module#LocationModule' },
  { path: 'friends', loadChildren: './traveler/friends/traveler-friends.module#TravelerFriendsModule' },
  { path: 'profile', loadChildren: './traveler/profile/traveler-profile.module#TravelerProfileModule' },
  { path: '**', redirectTo: 'location', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    TravelerFriendsModule,
    TravelerProfileModule
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
