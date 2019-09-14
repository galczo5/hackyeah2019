import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'location', pathMatch: 'full' },
  { path: 'location', loadChildren: './location/location.module#LocationModule' },
  { path: 'matched', loadChildren: './matched/matched.module#MatchedModule' },
  { path: 'profile', loadChildren: './traveler/profile/traveler-profile.module#TravelerProfileModule' },
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
