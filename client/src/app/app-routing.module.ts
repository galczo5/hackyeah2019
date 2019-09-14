import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'location', pathMatch: 'full' },
  { path: 'location', loadChildren: './location/location.module#LocationModule', data: { num: 0 } },
  { path: 'check-in', loadChildren: './check-in/check-in.module#CheckInModule', data: { num: 1 } },
  { path: 'search', loadChildren: './search-progress/search-progress.module#SearchProgressModule', data: { num: 2 } },
  { path: 'matched', loadChildren: './matched/matched.module#MatchedModule', data: { num: 3 } },
  { path: 'explore', loadChildren: './explore/recomendation.module#RecomendationModule', data: { num: 4 } },
  { path: 'profile', loadChildren: './traveler/profile/traveler-profile.module#TravelerProfileModule', data: { num: 5 } },
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
