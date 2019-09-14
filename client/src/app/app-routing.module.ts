import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'location', pathMatch: 'full' },
  { path: 'location', loadChildren: './location/location.module#LocationModule', data: { animation: 'isRight' } },
  { path: 'check-in', loadChildren: './check-in/check-in.module#CheckInModule', data: { animation: 'isRight' } },
  { path: 'search', loadChildren: './search-progress/search-progress.module#SearchProgressModule', data: { animation: 'isRight' } },
  { path: 'matched', loadChildren: './matched/matched.module#MatchedModule', data: { animation: 'isRight' } },
  { path: 'explore', loadChildren: './explore/recomendation.module#RecomendationModule', data: { animation: 'isRight' } },
  { path: 'profile', loadChildren: './traveler/profile/traveler-profile.module#TravelerProfileModule', data: { animation: 'isRight' } },
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
