import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'location', pathMatch: 'full' },
  { path: 'welcome', loadChildren: './app-logo/app-logo.module#AppLogoModule' },
  { path: 'location', loadChildren: './location/location.module#LocationModule', data: { num: 0 } },
  { path: 'check-in', loadChildren: './check-in/check-in.module#CheckInModule', data: { num: 1 } },
  { path: 'search', loadChildren: './search-progress/search-progress.module#SearchProgressModule', data: { num: 2 } },
  { path: 'matched', loadChildren: './matched/matched.module#MatchedModule', data: { num: 3 } },
  { path: 'confirm', loadChildren: './confirm-meeting/confirm-meeting.module#ConfirmMeetingModule', data: { num: 4 } },
  { path: 'explore', loadChildren: './explore/recomendation.module#RecomendationModule', data: { num: 5 } },
  { path: 'profile', loadChildren: './traveler/profile/traveler-profile.module#TravelerProfileModule', data: { num: 6 } },
  { path: 'login', loadChildren: './login/login.module#LoginModule', data: { num: 7 } },
  { path: '**', redirectTo: 'location', pathMatch: 'full' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
