import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchProgressComponent } from './search-progress/search-progress.component';
import {MaterialModule} from "../material/material.module";
import {RouterModule} from "@angular/router";

const routes = [{
  path: '',
  component: SearchProgressComponent
}];

@NgModule({
  declarations: [SearchProgressComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    MaterialModule
  ]
})
export class SearchProgressModule { }
