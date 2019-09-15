import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatchNotFoundComponent } from './match-not-found/match-not-found.component';
import {RouterModule} from "@angular/router";

const routes = [{
  path: '',
  component: MatchNotFoundComponent
}];

@NgModule({
  declarations: [MatchNotFoundComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ]
})
export class MatchNotFoundModule { }
